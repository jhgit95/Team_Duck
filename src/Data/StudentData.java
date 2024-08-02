package Data;

import java.util.ArrayList;

public class StudentData {
    ScoreData scoreData;
    SubjectData subjectData;
    //객체생성 각각 ScoreData,SubjectData
    protected int studentId;
    protected String studentName;
    ArrayList<String> subjectList = new ArrayList<>();

    String studentState;

    public StudentData(int studentId) {
        this.studentId = studentId;
        this.subjectData=new SubjectData();
        this.scoreData=new ScoreData(studentId);
        //각객체를 Student객체에 종속시킴
    }
    public void setScoreList(int score,String subjectType){
        scoreData.setScoreList(score,subjectType);
    }
    public ArrayList<String> getGradeList(){
        return scoreData.getGradeList();
        //종속된 ScoreData객체로 만든 scoreData내부 메서드 getGradeList()를실행시킴
    }
    public ArrayList<String> getScoreList(){
        return scoreData.getScoreList();
        //종속된 ScoreData객체로 만든 scoreData내부 메서드 getScoreList()를실행시킴
    }
    public ArrayList<String[]> getSubjectDataSubjectList() {
        return this.subjectData.getSubjectList();
    }


    //내부 get,set메서들은 private으로 하면 접근할수 없음
    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentName) {
        this.studentId = studentName;
    }


    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String name) {
        this.studentName = name;
    }


    public ArrayList<String> getSubjectList() {
        return this.subjectList;
    }
    public void addSubject(String subject) {
        this.subjectList.add(subject);
    }

    public String getStudentState(){
        return studentState;
    }
    public void setStudentState(String state){
        this.studentState=state;
    }

}