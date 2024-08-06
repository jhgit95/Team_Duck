package Data;

import java.util.ArrayList;

public class StudentData {
    ScoreData scoreData;
    //객체생성 각각 ScoreData
    protected int studentId;
    protected String studentName;

    // 1=Green, 2=Yellow, 3=Red
    int studentState;


    public StudentData(int studentId, String name, int state) {
        this.studentId = studentId;
        this.studentName = name;
        this.studentState = state;
    }


    // subjectType : 0 = 필수, 1 = 선택
    // 등급 : A = 1, B = 2, C = 3, D = 4, F = 5, N = 6
    ArrayList<int[]> subjectList = new ArrayList<>();
    int[] subjectDetails = new int[5];

    public void subjectDetailsInput(int subjectId,int subjectType, int score,int round, char grade){
        subjectDetails = new int[5];
        //초기화 안해주면 고장남!!
        this.subjectDetails[0] = subjectId;
        this.subjectDetails[1] = subjectType;
        this.subjectDetails[2] = score;
        this.subjectDetails[3] = round;
        this.subjectDetails[4] = changeGradeInt(grade);
        subjectList.add(subjectDetails);
    }


    // 등급 int 값으로 변환
    public int changeGradeInt(char grade){
        return switch (grade) {
            case 'A' -> 1;
            case 'B' -> 2;
            case 'C' -> 3;
            case 'D' -> 4;
            case 'F' -> 5;
            case 'N' -> 6;
            default -> 0;
        };
    }

    // int값에 해당하는 등급 변환
    public char changeGradeChar(int grade){
        //메서드의 반환형이 int여서 char로 수정했습니다--multiverse22
        return switch (grade) {
            case  1-> 'A';
            case  2-> 'B';
            case  3-> 'C';
            case  4-> 'D';
            case  5-> 'F';
            case  6-> 'N';
            default -> 0;
        };
    }

    public char changeScoreGrade(int subjectType, int score) {
        // subjectType==0이면 필수과목
        if (subjectType == 0) {
            if (score >= 95) {
                return 'A';
            } else if (score >= 90) {
                return 'B';
            } else if (score >= 80) {
                return 'C';
            } else if (score >= 70) {
                return 'D';
            } else if (score >= 60) {
                return 'F';
            } else {
                return 'N';
            }
        }

        // 선택과목
        else if (subjectType == 1) {
            if (score >= 90) {
                return 'A';
            } else if (score >= 80) {
                return 'B';
            } else if (score >= 70) {
                return 'C';
            } else if (score >= 60) {
                return 'D';
            } else if (score >= 50) {
                return 'F';
            } else {
                return 'N';
            }
        }
        // e가 나올 경우 예외 처리 필요
        return 'e';
    }
    public ArrayList<int[]> getSubjectList(){
        //inquiry클래스에서 사용할 SubjectList를 get하는 메서드추가 --multiverse22
        return subjectList;
    }
    public int getStudentState(){
        //상태를 get하는 메서드추가 --multiverse22
        return studentState;
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

//
//    public ArrayList<String> getSubjectList() {
//        return this.subjectList;
//    }
//    public void addSubject(String subject) {
//        this.subjectList.add(subject);
//    }

//    public String getStudentState(){
//        return studentState;
//    }
//    public void setStudentState(String state){
//        this.studentState=state;
//    }

    // 이 아래는 전부 테스트에 사용되는 메서드

    public void testStudentInit(){
        this.studentId=999;
        this.studentName="Test Student";
        this.studentState=1;
        scoreData.setScoreList(100,"R", 1);
    }

    public void testStudentInput(int id, String name, int state, int score, String type,int round){
        this.studentId=id;
        this.studentName=name;
        this.studentState=state;
        scoreData.setScoreList(score,type,round);
    }

}
