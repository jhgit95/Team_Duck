

package Data;

import java.util.ArrayList;

public class StudentData {
    protected ScoreData scoreData;
    protected SubjectData subjectData;
    protected int studentId;
    protected String studentName;
    protected ArrayList<String> subjectList = new ArrayList();

    public StudentData(int studentId) {
        this.studentId = studentId;
        this.subjectData = new SubjectData();
        this.scoreData = new ScoreData(studentId);
    }

    public void setScoreList(int score, String subjectType) {
        this.scoreData.setScoreList(score, subjectType);
    }

    public ArrayList<String> getGradeList() {
        return this.scoreData.getGradeList();
    }

    public ArrayList<String> getScoreList() {
        return this.scoreData.getScoreList();
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentName) {
        this.studentId = studentName;
    }

    public ArrayList<String[]> getSubjectDataSubjectList() {
        return this.subjectData.getSubjectList();
    }

    public String getStudentName() {
        return this.studentName;
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
}
