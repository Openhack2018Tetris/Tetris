package company.co.kr.tugether;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import company.co.kr.turing.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewItem_student listViewItem_student;
        ListViewAdapter_student listViewAdapter_student;

        listViewAdapter_student = new ListViewAdapter_student();
        listViewItem_student 


    }
}
