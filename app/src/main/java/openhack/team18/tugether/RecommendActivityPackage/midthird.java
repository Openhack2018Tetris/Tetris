package openhack.team18.tugether.RecommendActivityPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import openhack.team18.tugether.R;

public class midthird extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_midthird);

        textView = findViewById(R.id.midthird_textView);
        editText = findViewById(R.id.midthird_editText);
        imageButton = findViewById(R.id.midthird_imageButton);

        textView.setMovementMethod(new ScrollingMovementMethod());

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newStr = editText.getText().toString();
                String prevStr = textView.getText().toString();

                textView.setText(prevStr + "\n" + newStr + "\n");
                editText.setText("");
            }
        });

    }
}
