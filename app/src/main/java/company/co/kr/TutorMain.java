package company.co.kr.tugether;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import company.co.kr.turing.R;

public class TutorMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);

        ListView listview;
        ListViewAdapter_tutor adapter;

        // Adapter 생성
        adapter = new ListViewAdapter_tutor() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = findViewById(R.id.listview1);
        listview.setAdapter(adapter);

       /* // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_box_black_36dp),
                "Box", "Account Box Black 36dp") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_circle_black_36dp),
                "Circle", "Account Circle Black 36dp") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_assignment_ind_black_36dp),
                "Ind", "Assignment Ind Black 36dp") ;
               */

        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem_tutor item = (ListViewItem_tutor) parent.getItemAtPosition(position) ;

                Drawable tuteeIcon = item.getTuteeIcon() ;
                String tuteeName = item.getTuteeName() ;
                int tuteeAge = item.getTuteeAge() ;
                String subject = item.getSubject() ;

                // TODO : use item data.
            }

        }
    }
