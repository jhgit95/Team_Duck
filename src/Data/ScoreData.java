

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

    public void setScoreList(int score, String subjectType) {
        this.ScoreList.add(String.valueOf(score));
        if (subjectType.equals("R")) {
            if (score >= 95) {
                this.GradeList.add("A");
            } else if (score >= 90) {
                this.GradeList.add("B");
            } else if (score >= 80) {
                this.GradeList.add("C");
            } else if (score >= 70) {
                this.GradeList.add("D");
            } else if (score >= 60) {
                this.GradeList.add("F");
            } else {
                this.GradeList.add("N");
            }
        } else if (subjectType.equals("E")) {
            if (score >= 90) {
                this.GradeList.add("A");
            } else if (score >= 80) {
                this.GradeList.add("B");
            } else if (score >= 70) {
                this.GradeList.add("C");
            } else if (score >= 60) {
                this.GradeList.add("D");
            } else if (score >= 50) {
                this.GradeList.add("F");
            } else {
                this.GradeList.add("N");
            }
        }

    }

    public ArrayList<String> getScoreList() {
        return this.ScoreList;
    }

    public ArrayList<String> getGradeList() {
        return this.GradeList;
    }

    public ScoreData(int studentId) {
        this.studentId = studentId;
        this.ScoreList = new ArrayList();
        this.GradeList = new ArrayList();
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
}
