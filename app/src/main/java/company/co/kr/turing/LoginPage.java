package company.co.kr.turing;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by Haru on 2018-06-29.
 */

public class LoginPage extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);

        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        final EditText selectEditText = (EditText) findViewById(R.id.passTextField);

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                imm.hideSoftInputFromWindow(selectEditText.getWindowToken(),0);

                switch (view.getId()) {
                    case R.id.logInBtn :
//                        메인 로그인 버튼 이벤트
//                           if(mainLogInCheck()){
                        if(true){
                            ((EditText) findViewById(R.id.passTextField)).setText("");//입력했던 비밀번호 리셋
                            Intent home_view = new Intent(getApplicationContext(),MainPage.class);
                            home_view.putExtra("userName","Tester");
                            home_view.putExtra("from", "main");
                            startActivity(home_view);
                        }else
                            Toast.makeText(getApplicationContext(), "아이디/비밀번호를 확인하세요.",Toast.LENGTH_SHORT).show();
                        break ;

                    default:
                        break ;
                }
            }
        } ;

        int[] btnItem = {R.id.logInBtn};

        for(int id : btnItem){
            Button btn = (Button) findViewById(id);
            btn.setOnClickListener(onClickListener);
        }

    }

    private boolean mainLogInCheck(){

        EditText idText = (EditText) findViewById(R.id.idTextField);
        EditText passText = (EditText) findViewById(R.id.passTextField);

        if(String.valueOf(idText.getText()).equals("Tester") && String.valueOf(passText.getText()).equals("Tester")){
            return true;
        }else{
            return false;
        }

    }


}