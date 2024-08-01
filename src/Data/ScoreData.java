package Data;

public class ScoreData {
    int subjectId;
    int studentId;
    int round;
    int score;
    char grade;
    public ScoreData(int subjectId) {
        this.subjectId = subjectId;
    }

    private int getSubjectId() {
        return this.subjectId;
    }
    private void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    private int getStudentId() {
        return this.studentId;
    }
    private void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    private int getRound() {
        return this.round;
    }
    private void setRound(int round) {
        this.round = round;
    }


    private int getsSore() {
        return this.score;
    }
    private void setsSore(int score) {
        this.score = score;
    }


    private char getGrade() {
        return this.grade;
    }
    private void setGrade(char grade) {
        this.grade = grade;
    }

}
