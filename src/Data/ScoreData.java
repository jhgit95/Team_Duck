package Data;

import java.util.ArrayList;

public class ScoreData {
    protected int subjectId;
    protected int studentId;
    protected int round;
    protected int score;
    protected char grade;
    protected final ArrayList<String> ScoreList;
    protected final ArrayList<String> GradeList;

    public void setScoreList(int score,String subjectType,int round){
        //[][0] round [][1] score [][2]subjectType
        //값 입력이끝나면 count++
        ScoreList.add(String.valueOf(score));
        this.round=round;

        //subjectType==R이면 필수과목
        if(subjectType.equals("R")){
            if (score >= 95) {
                GradeList.add("A");
            } else if (score >= 90) {
                GradeList.add("B");
            } else if (score >= 80) {
                GradeList.add("C");
            } else if (score >= 70) {
                GradeList.add("D");
            } else if (score >= 60) {
                GradeList.add("F");
            } else{
                GradeList.add("N");
            }
        }

        //선택과목
        else if(subjectType.equals("E")){
            if (score >= 90) {
                GradeList.add("A");
            } else if (score >= 80) {
                GradeList.add("B");
            } else if (score >= 70) {
                GradeList.add("C");
            } else if (score >= 60) {
                GradeList.add("D");
            } else if (score >= 50) {
                GradeList.add("F");
            } else{
                GradeList.add("N");
            }

        }
        else{
            //예외처리필요
        }

    }
    public ArrayList<String> getScoreList(){
        return ScoreList;
    }
    public ArrayList<String> getGradeList(){
        return GradeList;
    }

    public ScoreData(int studentId) {
        this.studentId = studentId;
        ScoreList = new ArrayList<String>();
        GradeList = new ArrayList<String>();

    }
    public int getSubjectId() {
        return this.subjectId;
    }
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    public int getStudentId() {
        return this.studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public int getRound() {
        return this.round;
    }
    public void setRound(int round) {
        this.round = round;
    }


    public int getsSore() {
        return this.score;
    }
    public void setsSore(int score) {
        this.score = score;
    }


    public char getGrade() {
        return this.grade;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }
    // 이 아래는 전부 테스트에 사용되는 메서드
    public void testScoreInit(){
        this.subjectId=1000;
        this.studentId=10000;
        this.round=10000;
        this.score=10000;
        this.grade='T';
    }

    public void testScoreInput(int subId, int stuId, int r, int s, char g){
        this.subjectId=subId;
        this.studentId=stuId;
        this.round=r;
        this.score=s;
        this.grade=g;
    }

}