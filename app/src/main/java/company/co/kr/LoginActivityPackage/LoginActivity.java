package company.co.kr.LoginActivityPackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import company.co.kr.MainActivity;
import company.co.kr.tugether.R;
import company.co.kr.WelcomeActivityPackage.WelcomeActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private Button signup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);

        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        final EditText selectEditText = findViewById(R.id.passTextField);

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                imm.hideSoftInputFromWindow(selectEditText.getWindowToken(), 0);

                switch (view.getId()) {
                    case R.id.logInBtn:
//                        메인 로그인 버튼 이벤트
//                           if(mainLogInCheck()){
                        if (true) {
                            ((EditText) findViewById(R.id.passTextField)).setText("");//입력했던 비밀번호 리셋
                            Intent home_view = new Intent(getApplicationContext(), MainActivity.class);
                            home_view.putExtra("userName", "Tester");
                            home_view.putExtra("from", "main");
                            startActivity(home_view);
                        } else
                            Toast.makeText(getApplicationContext(), "이메일/비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }
            }
        };

        etEmail = findViewById(R.id.etEmail);
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SingupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent, 1000);
            }

        });

        int[] btnItem = {R.id.logInBtn};

        for (int id : btnItem) {
            Button btn = findViewById(id);
            btn.setOnClickListener(onClickListener);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // setResult를 통해 받아온 요청번호, 상태, 데이터
        Log.d("RESULT", requestCode + "");
        Log.d("RESULT", resultCode + "");
        Log.d("RESULT", data + "");

        if(requestCode == 1000 && resultCode == RESULT_OK) {
            Toast.makeText(LoginActivity.this, "회원가입을 완료했습니다!", Toast.LENGTH_SHORT).show();
            etEmail.setText(data.getStringExtra("email"));
        }
    }

    private boolean mainLogInCheck() {

        EditText idText = findViewById(R.id.idTextField);
        EditText passText = findViewById(R.id.passTextField);

        return String.valueOf(idText.getText()).equals("Tester") && String.valueOf(passText.getText()).equals("Tester");

    }
}
