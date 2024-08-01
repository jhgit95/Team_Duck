package Data;

import java.util.ArrayList;

public class StudentData {
    int studentId;
    String studentName;
    final ArrayList<String> subjectList = new ArrayList<>();

    public StudentData(int studentId) {
        this.studentId = studentId;
    }
    ScoreData scoredata = new ScoreData(studentId);
    SubjectData subjectData=new SubjectData(studentId);

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
