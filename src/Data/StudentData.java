package Data;

import java.util.ArrayList;

public class StudentData {

    protected Integer studentId;
    protected String studentName;
    protected Integer subjectId;
    //리스트에 들어갈 요소가 많아지면 개수 수정
    protected final Integer scoreMaxElement=4;
    //리스트에 들어갈 요소가 많아지면 개수 수정
    protected final ArrayList<String> subjectList = new ArrayList<>();
    //과목담을 리스트
    protected final ArrayList<String>[] scoreList= new ArrayList[scoreMaxElement];
    //[0][0] [][1] [][2] [][3]
    String studentState;

    public StudentData(Integer studentId) {
        this.studentId = studentId;
    }
    public Integer getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public ArrayList<String> getSubjectList() {
        return subjectList;
    }
    public ArrayList<String>[] getScoreList(){
        return scoreList;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public void setStudentName(String name) {
        this.studentName = name;
    }
    //나중에 기능제거필요
    public void addSubject(String subject) {
        this.subjectList.add(subject);
    }
    public String getStudentState(){
        return studentState;
    }
    public void setStudentState(String state){
        this.studentState=state;
    }

    // 이 아래는 전부 테스트에 사용되는 메서드



    public void testStudentInit(){
        this.studentId=999;
        this.studentName="Test Student";
        this.studentState="Green";
        //setScoreList(100,"R", 1);
    }

    public void testStudentInput(int id, String name, String state, int score, String type,int round){
        this.studentId=id;
        this.studentName=name;
        this.studentState=state;
        //setScoreList(score,type,round);
    }

}