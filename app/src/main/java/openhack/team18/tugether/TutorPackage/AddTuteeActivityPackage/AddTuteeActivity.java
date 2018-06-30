package openhack.team18.tugether.TutorPackage.AddTuteeActivityPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import openhack.team18.tugether.R;

public class AddTuteeActivity extends AppCompatActivity {

    private EditText editText_name;
    private EditText editText_phone;
    private EditText editText_home;
    private EditText editText_parentPhone;
    private EditText editText_subject;
    private EditText editText_gender;

    private ImageButton imageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_addtutee);

        editText_name = findViewById(R.id.editText_addTutee_name);
        editText_phone = findViewById(R.id.editText_addTutee_phone);
        editText_home = findViewById(R.id.editText_addTutee_home);
        editText_parentPhone = findViewById(R.id.editText_addTutee_parentPhone);
        editText_subject = findViewById(R.id.editText_addTutee_subject);
        editText_gender = findViewById(R.id.editText_addTutee_gender);

        imageButton = findViewById(R.id.imageButton_addtutee_register);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText_name != null &&
                editText_phone != null &&
                editText_home != null &&
                editText_parentPhone != null &&
                editText_subject != null &&
                editText_gender != null)
                {
                    Intent intent = new Intent();
                    intent.putExtra("name", editText_name.getText().toString());
                    intent.putExtra("phone", editText_phone.getText().toString());
                    intent.putExtra("home", editText_home.getText().toString());
                    intent.putExtra("parentPhone", editText_parentPhone.getText().toString());
                    intent.putExtra("subject", editText_subject.getText().toString());
                    intent.putExtra("gender", editText_gender.getText().toString());

                    setResult(RESULT_OK, intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "정보가 부족합니다.", Toast.LENGTH_SHORT);
                }

                finish();
            }
        });

    }
}
