package Data;

import java.util.ArrayList;

public class StudentData {
    int studentId;
    String studentName;
    ArrayList<String> subjectList = new ArrayList<>();

    private int getStudentId() {
        return this.studentId;
    }
    private void setStudentId(int studentName) {
        this.studentId = studentName;
    }


    private String getStudentName() {
        return studentName;
    }
    private void setStudentName(String name) {
        this.studentName = name;
    }


    public ArrayList<String> getSubjectList() {
        return this.subjectList;
    }
    public void addSubject(String subject) {
        this.subjectList.add(subject);
    }

}
