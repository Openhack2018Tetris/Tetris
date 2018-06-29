package openhack.team18.tugether.LoginActivityPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import openhack.team18.tugether.R;
import openhack.team18.tugether.TuteePackage.TuteeMainActivityPackage.TuteeMainActivity;
import openhack.team18.tugether.TutorPackage.TutorMainActivityPackage.TutorMainActivity;
import openhack.team18.tugether.WelcomeActivityPackage.WelcomeActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText idText;
    private EditText passText;

    private ImageButton signup;

    private HashMap<String, String> tutorData;
    private HashMap<String, String> tuteeData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);

        idText = findViewById(R.id.idTextField);
        passText = findViewById(R.id.passTextField);

        //dummy data
        tutorData = new HashMap<>();
        tutorData.put("Tutor@openhack.2018", "a");
        tuteeData = new HashMap<>();
        tuteeData.put("Tutee@openhack.2018", "a");

        ImageButton logbtn = (ImageButton)findViewById(R.id.logbtn);
        logbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent;

                if (tutorData.get(idText.getText().toString()) != null)
                {
                    if(tutorData.get(idText.getText().toString()).equals(passText.getText().toString())) {
                        intent = new Intent(getApplicationContext(), TutorMainActivity.class);
                        Toast.makeText(LoginActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                } else if (tuteeData.get(idText.getText().toString()) != null)
                {
                    if(tuteeData.get(idText.getText().toString()).equals(passText.getText().toString())) {
                        intent = new Intent(getApplicationContext(), TuteeMainActivity.class);
                        Toast.makeText(LoginActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });


        ImageButton signup = (ImageButton) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent, 1000);
            }

        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000 && resultCode == RESULT_OK) {
            Toast.makeText(LoginActivity.this, "회원가입을 완료했습니다!", Toast.LENGTH_SHORT).show();
            tutorData.put(data.getStringExtra("email"), data.getStringExtra("pw"));
        }
    }
}
