package Data;

import java.util.ArrayList;

public class StudentData {
    ScoreData scoreData;
    SubjectData subjectData;
    int studentId;
    String studentName;
    ArrayList<String> subjectList = new ArrayList<>();

    public StudentData(int studentId) {
        this.studentId = studentId;
        this.subjectData=new SubjectData();
        this.scoreData=new ScoreData(studentId);
    }
    public void setScoreList(int score,String subjectType){
        scoreData.setScoreList(score,subjectType);
    }
    public ArrayList<String> getGradeList(){
        return scoreData.getGradeList();
    }
    public ArrayList<String> getScoreList(){
        return scoreData.getScoreList();
    }



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
