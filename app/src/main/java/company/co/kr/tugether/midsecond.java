package company.co.kr.tugether;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class midsecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midsecond);

        final EditText mfedittext=(EditText)findViewById(R.id.mfedittext);
        Button mfinsert=(Button)findViewById(R.id.mfinsert);
        final TextView textView=(TextView)findViewById(R.id.mftext);
        mfinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(mfedittext.getText());
            }
        });

    }
}
