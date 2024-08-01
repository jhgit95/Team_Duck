
package Data;

import java.util.ArrayList;

public class SubjectData {
    protected int subjectId;
    protected String subjectName;
    protected String subjectType;
    ArrayList<String[]> subjectList = new ArrayList();

    public SubjectData() {
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void getSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectType() {
        return this.subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public void addSubject(String[] subjectDetails) {
        this.subjectList.add(subjectDetails);
    }

    public ArrayList<String[]> getSubjectList() {
        return this.subjectList;
    }
}
