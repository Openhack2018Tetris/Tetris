package company.co.kr.tugether;

import android.graphics.drawable.Drawable;

public class ListViewItem_tutor {
    private Drawable tuteeIcon ;
    private String Gender;
    private String tuteeName ;
    private String subject ;
    private int tuteeAge ;
    private double progressRate ;

    public void setTuteeIcon(Drawable icon) {
        tuteeIcon = icon ;
    }
    public void setGender(String gender) {
        Gender = gender ;
    }
    public void setTuteeName(String name) {
         tuteeName = name ;
    }
    public void setSubject(String sub) {
        subject = sub;
    }
    public void setTuteeAge(int age) {
        tuteeAge = age;
    }
    public void setProgressRate(double progressRate) {
        this.progressRate = progressRate;
    }

    public Drawable getTuteeIcon() {
        return this.tuteeIcon ;
    }
    public String getGender() {
        return this.Gender ;
    }
    public String getTuteeName() {
        return this.tuteeName ;
    }
    public String getSubject() {
        return this.subject ;
    }
    public int getTuteeAge() {
        return this.tuteeAge;
    }
    public double getProgressRate() {
        return this.progressRate;
    }
}