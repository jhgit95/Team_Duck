package Data;

import java.util.ArrayList;

public class SubjectData {
    protected String subjectId;
    protected String subjectName;
    protected String subjectType;

    ArrayList<String[]> subjectList = new ArrayList<>();
    public SubjectData() {
        subjectList.add(new String[]{"0001", "Java", "필수"});
        subjectList.add(new String[]{"0002", "객체지향", "필수"});
        subjectList.add(new String[]{"0003", "Spring", "필수"});
        subjectList.add(new String[]{"0004", "JPA", "필수"});
        subjectList.add(new String[]{"0005", "MySQL", "필수"});
        subjectList.add(new String[]{"0006", "디자인 패턴", "선택"});
        subjectList.add(new String[]{"0007", "Spring Security", "선택"});
        subjectList.add(new String[]{"0008", "Redis", "선택"});
        subjectList.add(new String[]{"0009", "MongoDB", "선택"});

    }
    public String getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }


    public void addSubject(String[] subjectDetails) {
        subjectList.add(subjectDetails);
    }

    public ArrayList<String[]> getSubjectList() {
        return this.subjectList;
    }

}
