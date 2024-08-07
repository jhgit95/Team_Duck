package Data;

import java.util.ArrayList;

public class StudentData {
    protected int studentId;
    protected String studentName;
    // 1=Green, 2=Yellow, 3=Red
    int studentState;
    public StudentData(int studentId, String name, int state) {
        this.studentId = studentId;
        this.studentName = name;
        this.studentState = state;
    }
    ArrayList<Integer> requireAndChoice=new ArrayList<>();
    //학생이 무슨과목을듣는지 넣어놓는 리스트
    // subjectType : 0 = 필수, 1 = 선택
    // 등급 : A = 1, B = 2, C = 3, D = 4, F = 5, N = 6
    final int detailsSize=4;
    //배열크기가 바뀌면 detailsSize의 값을바꾸자.
    ArrayList<int[]> subjectList = new ArrayList<>();
    int[] subjectDetails = new int[detailsSize];
    public void subjectDetailsInput(int subjectId,int subjectType, int score,int round){
        subjectDetails = new int[detailsSize];
        //초기화 안해주면 고장남!!
        this.subjectDetails[0] = subjectId;
        this.subjectDetails[1] = subjectType;
        //Type= 0 or 1
        this.subjectDetails[2] = score;
        //점수 범위0~100
        this.subjectDetails[3] = round;
        //회차 범위 1~10
        subjectList.add(subjectDetails);
    }
    public void setRequireAndChoice(ArrayList<Integer> requireAndChoice) {
        this.requireAndChoice = requireAndChoice;
    }
    public ArrayList<Integer> getRequireAndChoice() {
        return requireAndChoice;
    }
    public void setSubjectList(ArrayList<int[]> subjectList){
        this.subjectList = subjectList;
    }
    public ArrayList<int[]> getSubjectList(){
        //inquiry클래스에서 사용할 SubjectList를 get하는 메서드추가 --multiverse22
        return subjectList;
    }
    public int getStudentState(){
        return studentState;
    }
    public void setStudentState(int state){
        this.studentState=state;
    }
    public int getStudentId() {
        return this.studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String name) {
        this.studentName = name;
    }
}
