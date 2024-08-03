package Data;

import java.util.ArrayList;

public class StudentData {
    ScoreData scoreData;
    SubjectData subjectData;
    //객체생성 각각 ScoreData,SubjectData
    protected int studentId;
    protected String studentName;

    // 1=Green, 2=Yellow, 3=Red
    int studentState;


    public StudentData(int studentId, String name, int state) {
        this.studentId = studentId;
        this.studentName = name;
        this.studentState=state;
//        this.subjectData=new SubjectData();
//        this.scoreData=new ScoreData(studentId);
//        //각객체를 Student객체에 종속시킴
    }



    // subjectType : 0 = 필수, 1 = 선택
    // 등급 : A = 1, B = 2, C = 3, D = 4, F = 5, N = 6
    ArrayList<int[]> subjectList = new ArrayList<>();
    int[] subjectDetails = new int[5];

    public void subjectDetailsInput(int subjectId,int subjectType, int score,int round, char grade){
        this.subjectDetails[0] = subjectId;
        this.subjectDetails[1] = subjectType;
        this.subjectDetails[2] = score;
        this.subjectDetails[3] = round;
        this.subjectDetails[4] = changeGradeInt(grade);
        subjectList.add(subjectDetails);
    }

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
    public int changeGradeChar(int grade){
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
        //subjectType==R이면 필수과목
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

        //선택과목
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


    public void setScoreList(int score,String subjectType, int round){
        scoreData.setScoreList(score,subjectType, round);
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

//
//    public ArrayList<String> getSubjectList() {
//        return this.subjectList;
//    }
//    public void addSubject(String subject) {
//        this.subjectList.add(subject);
//    }

    public int getStudentState(){
        return studentState;
    }
    public void setStudentState(int state){
        this.studentState = state;
    }

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
