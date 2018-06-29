package company.co.kr.tugether;

public class ListViewItem_student {
    public String tutorName;
    public Gender gender;
    public String tutorPhone;

    public ListViewItem_student(String tutorName, Gender gender, String tutorPhone)
    {
        this.tutorName = tutorName;
        this.gender = gender;
        this.tutorPhone = tutorPhone;
    }
    public void setGender(Gender gender) {
        this.gender=gender ;
    }
    public void setTutorName(String tutorName) {
        this.tutorName = tutorName ;
    }
    public void setTutorPhone(String tutorPhone) {
        this.tutorPhone = tutorPhone ;
    }

    public Gender getGender() {
        return this.gender ;
    }
    public String getTutorName() {
        return this.tutorName ;
    }
    public String getTutorPhone() {
        return this.tutorPhone ;
    }



}
