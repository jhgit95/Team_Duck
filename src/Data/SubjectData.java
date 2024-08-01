package Data;

import java.util.ArrayList;

public class SubjectData {
    int subjectId;
    String subjectName;
    String subjectType;

    ArrayList<String[]> subjectList = new ArrayList<>();

    private int getSubjectId() {
        return this.subjectId;
    }

    private void getSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }


    private String getSubjectName() {
        return subjectName;
    }

    private void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    private String getSubjectType() {
        return subjectType;
    }

    private void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }


    public void addSubject(String[] subjectDetails) {
        subjectList.add(subjectDetails);
    }

    public ArrayList<String[]> getSubjectList() {
        return this.subjectList;
    }

}
