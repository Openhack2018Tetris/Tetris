package openhack.team18.tugether.TutorPackage.TutorMainActivityPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import openhack.team18.tugether.RecommendActivityPackage.RecommendActivity;
import openhack.team18.tugether.Gender;
import openhack.team18.tugether.R;
import openhack.team18.tugether.TutorPackage.AddTuteeActivityPackage.AddTuteeActivity;
import openhack.team18.tugether.TutorPackage.TutorDetailActivityPackage.TutorDetailActivity;

public class TutorMainActivity extends AppCompatActivity {

    public class TutorMainData {
        public Gender gender;
        public String name;
        public String grade;
        public String subject;
        public int progressRate;

        public TutorMainData(String name, Gender gender, String grade, String subject, int progressRate) {
            this.name = name;
            this.gender = gender;
            this.grade = grade;
            this.subject = subject;
            this.progressRate = progressRate;
        }
    }

    private ArrayList<TutorMainData> data;

    private LinearLayout linearLayout;
    private ImageButton community;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tutormain);

        //dummy data
        data = new ArrayList<>();
        data.add(new TutorMainData("홍길동", Gender.Male, "중3", "수학", 50));
        data.add(new TutorMainData("신사임당", Gender.Female, "고2", "영어", 75));
        data.add(new TutorMainData("이순신", Gender.Male, "고1", "과학", 10));
        data.add(new TutorMainData("허난설헌", Gender.Female, "고3", "국어", 25));

        linearLayout = findViewById(R.id.linearLayout_tutormain_container);

        community = findViewById(R.id.button_gotoCommunity);
        community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorMainActivity.this, RecommendActivity.class);
                startActivity(intent);
            }
        });

        linearLayout.removeAllViews();
        LayoutInflater inflater = (LayoutInflater) getSystemService(getApplicationContext().LAYOUT_INFLATER_SERVICE);

        for (final TutorMainData item : data) {
            View view = inflater.inflate(R.layout.item_tutormain, null);

            ImageView gender = view.findViewById(R.id.imageView_tutormain_item_gender);
            TextView name = view.findViewById(R.id.textView_tutormain_item_name);
            TextView grade = view.findViewById(R.id.textView_tutormain_item_grade);
            TextView subject = view.findViewById(R.id.textView_tutormain_item_subject);
            ImageView progressRateImage = view.findViewById(R.id.imageView_tutormain_item_progressRate);
            TextView progressRate = view.findViewById(R.id.textView_tutormain_item_progressRate);
            Button button = view.findViewById(R.id.button_item_tutormain);

            switch (item.gender) {
                case Male:
                    gender.setImageResource(R.drawable.manicon);
                    break;
                case Female:
                    gender.setImageResource(R.drawable.womanicon);
                    break;
            }

            name.setText(item.name);
            grade.setText(item.grade);
            subject.setText(item.subject);

            if (item.progressRate < 9) {
                progressRateImage.setImageResource(R.drawable.p000);
            } else if (item.progressRate < 17) {
                progressRateImage.setImageResource(R.drawable.p017);
            } else if (item.progressRate < 25) {
                progressRateImage.setImageResource(R.drawable.p025);
            } else if (item.progressRate < 34) {
                progressRateImage.setImageResource(R.drawable.p034);
            } else if (item.progressRate < 42) {
                progressRateImage.setImageResource(R.drawable.p042);
            } else if (item.progressRate < 50) {
                progressRateImage.setImageResource(R.drawable.p050);
            } else if (item.progressRate < 59) {
                progressRateImage.setImageResource(R.drawable.p059);
            } else if (item.progressRate < 67) {
                progressRateImage.setImageResource(R.drawable.p067);
            } else if (item.progressRate < 75) {
                progressRateImage.setImageResource(R.drawable.p075);
            } else if (item.progressRate < 84) {
                progressRateImage.setImageResource(R.drawable.p084);
            } else if (item.progressRate < 92) {
                progressRateImage.setImageResource(R.drawable.p092);
            } else {
                progressRateImage.setImageResource(R.drawable.p100);
            }

            progressRate.setText(Integer.toString(item.progressRate));

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TutorMainActivity.this, TutorDetailActivity.class);
                    intent.putExtra("name", item.name);
                    startActivity(intent);
                }
            });

            linearLayout.addView(view);
        }

        View view = inflater.inflate(R.layout.item_empty_tutormain, null);
        Button button = view.findViewById(R.id.button_item_empty_tutormain);
        linearLayout.addView(view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorMainActivity.this, AddTuteeActivity.class);
                startActivityForResult(intent, 3000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode)
        {
            case 3000:
                if(resultCode == RESULT_OK)
                {
                    //데이터 입력
                }
        }
    }
}
