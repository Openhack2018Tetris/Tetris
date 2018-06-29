package company.co.kr.tugether;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import company.co.kr.turing.R;

import java.util.ArrayList;

public class ListViewAdapter_tutor extends BaseAdapter{

    private ArrayList<ListViewItem_tutor> listViewItemList = new ArrayList<ListViewItem_tutor>() ;

    public ListViewAdapter_tutor() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item_teacher, parent, false);
        }

        ImageView tuteeIconView = convertView.findViewById(R.id.tuteeIcon) ;
        TextView tuteeNameView = convertView.findViewById(R.id.tuteeName) ;
        TextView tuteeAgeView = convertView.findViewById(R.id.tuteeAge) ;
        TextView subjectView = convertView.findViewById(R.id.subject);

        ListViewItem_tutor listViewItem_tutor = listViewItemList.get(position);

        tuteeIconView.setImageDrawable(listViewItem_tutor.getTuteeIcon());
        tuteeNameView.setText(listViewItem_tutor.getTuteeName());
        tuteeAgeView.setText(listViewItem_tutor.getTuteeAge());
        subjectView.setText(listViewItem_tutor.getSubject());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    public void addItem(Drawable icon, String name, String gender, String subject, int age, double rate) {
        ListViewItem_tutor item = new ListViewItem_tutor();

        item.setTuteeIcon(icon);
        item.setTuteeName(name);
        item.setGender(gender);
        item.setSubject(subject);
        item.setTuteeAge(age);
        item.setProgressRate(rate);

        listViewItemList.add(item);
    }
}