package openhack.team18.tugether.TutorPackage.TutorDetailActivityPackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import openhack.team18.tugether.Gender;
import openhack.team18.tugether.R;

public class TutorDetailActivity extends AppCompatActivity {

    public class TutorDetailData{
        public Gender gender;
        public String name;
        public String grade;
        public String subject;
        public String phoneNumber;
        public String parentPhoneNumber;
        public String Location;
        public String LectureTime;
        public int progressRate;

        public TutorDetailData(Gender gender, String name, String grade, String subject, String phoneNumber, String parentPhoneNumber, String Location, String LectureTime, int progressRate)
        {
            this.gender = gender;
            this.name = name;
            this.grade = grade;
            this.subject = subject;
            this.phoneNumber = phoneNumber;
            this.parentPhoneNumber = parentPhoneNumber;
            this.Location = Location;
            this.LectureTime = LectureTime;
            this.progressRate = progressRate;
        }
    }

    private ArrayList<TutorDetailData> data;

    private ImageView imageView_gender;
    private TextView textView_name;
    private TextView textView_grade;
    private TextView textView_subject;
    private TextView textView_phoneNumber;
    private TextView textView_parentPhoneNumber;
    private TextView textView_location;
    private TextView textView_lectureTime;
    private LinearLayout linearLayout_big;
    private TextView textView_progressRate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tutordetail);

        imageView_gender = findViewById(R.id.Gender);
        textView_name = findViewById(R.id.tuteeName);
        textView_grade = findViewById(R.id.tuteeAge);
        textView_subject = findViewById(R.id.subject);
        textView_phoneNumber = findViewById(R.id.tuteePhone);
        textView_parentPhoneNumber = findViewById(R.id.tuteeParentPhone);
        textView_location = findViewById(R.id.lectureLocation);
        textView_lectureTime = findViewById(R.id.lectureTime);
        linearLayout_big = findViewById(R.id.linearLayout_tutordetail_bigContainer);
        textView_progressRate = findViewById(R.id.textView_tutordetail_progressRate);

        //dummy data
        data = new ArrayList<>();
        data.add(new TutorDetailData(Gender.Male, "홍길동", "중3", "수학", "010-1234-5678", "010-9876-5432", "율도국", "오후 3시 ~ 5시", 50));
        data.add(new TutorDetailData(Gender.Female, "신사임당", "고2", "영어", "010-1234-5678", "010-9876-5432", "강릉", "오후 3시 ~ 5시", 75));
        data.add(new TutorDetailData(Gender.Male, "이순신", "고1", "과학", "010-1234-5678", "010-9876-5432", "통영", "오후 3시 ~ 5시", 10));
        data.add(new TutorDetailData(Gender.Female, "허난설헌", "고3", "국어", "010-1234-5678", "010-9876-5432", "서울", "오후 3시 ~ 5시", 25));

        String curName = getIntent().getStringExtra("name");

        for(TutorDetailData item : data)
        {
            if(item.name.equals(curName))
            {
                switch(item.gender)
                {
                    case Female:
                        imageView_gender.setImageResource(R.drawable.icon_women);
                        break;
                    case Male:
                        imageView_gender.setImageResource(R.drawable.icon_man);
                        break;
                }

                textView_name.setText(item.name);
                textView_grade.setText(item.grade);
                textView_lectureTime.setText(item.LectureTime);
                textView_location.setText(item.Location);
                textView_parentPhoneNumber.setText(item.parentPhoneNumber);
                textView_phoneNumber.setText(item.phoneNumber);
                textView_subject.setText(item.subject);
                textView_progressRate.setText(Integer.toString(item.progressRate));

                if(item.progressRate < 10)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q000);
                }else if(item.progressRate<20)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q010);
                }else if(item.progressRate<25)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q020);
                }else if(item.progressRate<30)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q025);
                }else if(item.progressRate<40)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q030);
                }else if(item.progressRate<50)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q040);
                }else if(item.progressRate<60)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q050);
                }else if(item.progressRate<70)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q060);
                }else if(item.progressRate<75)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q070);
                }else if(item.progressRate<80)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q075);
                }else if(item.progressRate<90)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q080);
                }else if(item.progressRate<100)
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q090);
                }else
                {
                    linearLayout_big.setBackgroundResource(R.drawable.q100);
                }



                break;
            }
        }

    }
}
