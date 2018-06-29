package company.co.kr.tugether;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import company.co.kr.turing.R;

public class ListViewAdapter_student extends BaseAdapter {

    private ArrayList<ListViewItem_student> listViewItemList = new ArrayList<ListViewItem_student>();


    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);

        }
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem_student listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
       /* iconImageView.setImageDrawable(ListViewItem_student.setIcon());
        tutorNameTextView.setText(ListViewItem_student.setTitle());
        descTextView.setText(ListViewItem_student.getDesc());
*/
    return convertView;
    }

    public void addInfo(String name, Gender gender,String Phone ){
        ListViewItem_student item_student = new ListViewItem_student(name,gender,Phone);

        listViewItemList.add(item_student);
    }
}




