package tech.iosd.gemselections;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.Retrofit.PaytmApiClient;
import tech.iosd.gemselections.Retrofit.PaytmApiInterface;
import tech.iosd.gemselections.Retrofit.ResponseModels.Checksum;
import tech.iosd.gemselections.Retrofit.ResponseModels.Paytm;
import tech.iosd.gemselections.Utils.Constants;

public class PaytmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytm);

        generateCheckSum();


    }

    private void initializePaytmPayment(String checksumHash, Paytm paytm) {

        //getting paytm service
        PaytmPGService Service = PaytmPGService.getStagingService();

        //use this when using for production
        //PaytmPGService Service = PaytmPGService.getProductionService();

        //creating a hashmap and adding all the values required
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("MID", Constants.M_ID);
        paramMap.put("ORDER_ID", paytm.getOrderId());
        paramMap.put("CUST_ID", paytm.getCustId());
        paramMap.put("CHANNEL_ID", paytm.getChannelId());
        paramMap.put("TXN_AMOUNT", paytm.getTxnAmount());
        paramMap.put("WEBSITE", paytm.getWebsite());
        paramMap.put("CALLBACK_URL", paytm.getCallBackUrl());
        paramMap.put("CHECKSUMHASH", checksumHash);
        paramMap.put("INDUSTRY_TYPE_ID", paytm.getIndustryTypeId());


        //creating a paytm order object using the hashmap
        PaytmOrder order = new PaytmOrder(paramMap);

        //intializing the paytm service
        Service.initialize(order, null);

        //finally starting the payment transaction
        Service.startPaymentTransaction(this, true, true, new PaytmPaymentTransactionCallback() {
            @Override
            public void onTransactionResponse(Bundle inResponse) {
                Toast.makeText(PaytmActivity.this, inResponse.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void networkNotAvailable() {
                Toast.makeText(PaytmActivity.this, "Network error", Toast.LENGTH_LONG).show();

            }

            @Override
            public void clientAuthenticationFailed(String inErrorMessage) {
                Toast.makeText(PaytmActivity.this, inErrorMessage, Toast.LENGTH_LONG).show();

            }

            @Override
            public void someUIErrorOccurred(String inErrorMessage) {
                Toast.makeText(PaytmActivity.this, inErrorMessage, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onErrorLoadingWebPage(int iniErrorCode, String inErrorMessage, String inFailingUrl) {
                Toast.makeText(PaytmActivity.this, inErrorMessage, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onBackPressedCancelTransaction() {
                Toast.makeText(PaytmActivity.this, "Back Pressed", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onTransactionCancel(String inErrorMessage, Bundle inResponse) {
                Toast.makeText(PaytmActivity.this, inErrorMessage + inResponse.toString(), Toast.LENGTH_LONG).show();

            }
        });


        //all these overriden method is to detect the payment result accordingly


    }


    private void generateCheckSum() {

        //getting the tax amount first.

        //creating a retrofit object.
        PaytmApiClient paytmApiClient = new PaytmApiClient();
        Retrofit retrofit = paytmApiClient.getRetrofit();

        //creating the retrofit api service
        PaytmApiInterface apiService = retrofit.create(PaytmApiInterface.class);

        //creating paytm object
        //containing all the values required
        final Paytm paytm = new Paytm(
                Constants.M_ID,
                Constants.CHANNEL_ID,
                "10",
                Constants.WEBSITE,
                Constants.CALLBACK_URL,
                Constants.INDUSTRY_TYPE_ID
        );

        //creating a call object from the apiService
        Call<Checksum> call = apiService.getChecksum(
                paytm.getmId(),
                paytm.getOrderId(),
                paytm.getCustId(),
                paytm.getChannelId(),
                paytm.getTxnAmount(),
                paytm.getWebsite(),
                paytm.getCallBackUrl(),
                paytm.getIndustryTypeId()
        );

        //making the call to generate checksum
        call.enqueue(new Callback<Checksum>() {
            @Override
            public void onResponse(Call<Checksum> call, Response<Checksum> response) {

                //once we get the checksum we will initiailize the payment.
                //the method is taking the checksum we got and the paytm object as the parameter
                initializePaytmPayment(response.body().getChecksumHash(), paytm);
            }

            @Override
            public void onFailure(Call<Checksum> call, Throwable t) {

            }
        });
    }

}

