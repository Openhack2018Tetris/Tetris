package openhack.team18.tugether.LoginActivityPackage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import openhack.team18.tugether.R;

public class SignupActivity extends AppCompatActivity {

    private ImageButton back;
    private ImageButton tutorSignup;
    private ImageButton gotoTuteeSignup;
    private EditText email;
    private EditText pw;
    private EditText pw_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        back = findViewById(R.id.imageButton_signup_back);
        tutorSignup = findViewById(R.id.imageButton_tutorSignUp);
        gotoTuteeSignup = findViewById(R.id.imageButton_tuteeSignUp);

        email = findViewById(R.id.etEmail);
        pw = findViewById(R.id.etPassword);
        pw_again = findViewById(R.id.etPasswordConfirm);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tutorSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().length() > 0
                        && pw.getText().toString().length() > 0
                        && pw_again.getText().toString().length() > 0
                        && pw.getText().toString().equals(pw_again.getText().toString()))
                {
                    Intent intent = new Intent();
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("pw", pw.getText().toString());

                    setResult(RESULT_OK, intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

