package Data;

import java.util.*;
public class SubjectData {
    protected String subjectId;
    protected String subjectName;
    protected String subjectType;
    public static int subjectListMaxCount=9;

    ArrayList<String[]> subjectList = new ArrayList<>();
    public SubjectData() {
        subjectList.add(new String[]{"1", "Java", "필수"});
        subjectList.add(new String[]{"2", "객체지향", "필수"});
        subjectList.add(new String[]{"3", "Spring", "필수"});
        subjectList.add(new String[]{"4", "JPA", "필수"});
        subjectList.add(new String[]{"5", "MySQL", "필수"});
        subjectList.add(new String[]{"6", "디자인 패턴", "선택"});
        subjectList.add(new String[]{"7", "Spring Security", "선택"});
        subjectList.add(new String[]{"8", "Redis", "선택"});
        subjectList.add(new String[]{"9", "MongoDB", "선택"});
        //0001과 같은 숫자를 사용하면 추가할때 0001로 추가해도 int값이라 1로들어감
        //때문에 0을제거한 정수값으로 수정
    }
    public void inquirySubjectList(){
        //subjectList를 정렬하여 Inquiry하는 메서드입니다.
        Collections.sort(subjectList, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
                //[][0]번째 값으로 정렬==코드에 해당하는 값으로 정렬했습니다.
                //초기값은 정렬되어있지만 혹시 나중에 과목을 추가하는 기능을 구현한다면
                //정렬이 필요할 것 같아 미리 구현했습니다.
            }
        });
        System.out.println("==================================================");
        for(int i = 0; i < subjectList.size(); ++i) {
            String[] subject =subjectList.get(i);
            //[][0]=CODE [][1] = Name [][2]=Type
            System.out.printf("Code: %4s Name: %-20s Type: %s",subject[0],subject[1],subject[2]);
            System.out.println();
        }
        System.out.println("==================================================");
    }
    // 과목 타입과 점수에 따라서 등급을 책정하는 기능
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