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


    public static int changeGradeInt(char grade){
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
    public static int changeGradeChar(int grade){
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

    public static char changeScoreGrade(int subjectType, int score) {
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



    public String getSubjectId() {
        return this.subjectId;
    }

    public void getSubjectId(String subjectId) {
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