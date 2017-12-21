package tech.iosd.gemselections.MainContent;

/**
 * Created by kushalgupta on 21/12/17.
 */
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import tech.iosd.gemselections.R;

/**
 * Created by kushalgupta on 21/12/17.
 */

public class MainDeveloperInfoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.developer_info,container,false);
int f=0;
         final EditText name=view.findViewById(R.id.et_name);
        final EditText message=view.findViewById(R.id.et_message);
        final EditText subject=view.findViewById(R.id.et_subject);
Button send=view.findViewById(R.id.sendMailBtn);

send.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
         int i=1;
        String sendMailName=name.getText().toString();
        String sendMessageMail=message.getText().toString();
        String sendSubjectMail=subject.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Gem Selections User"+" "+sendSubjectMail);
        intent.putExtra(Intent.EXTRA_TEXT, sendMailName+"\n"+sendMessageMail);
        intent.setData(Uri.parse("mailto:contact@iosd.tech"));
       intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(intent,0);

name.setText(null);
subject.setText(null);
message.setText(null);

    }
});




        return view;
    }
}

