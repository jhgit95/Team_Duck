package Data;

import java.util.*;
public class SubjectData {
    protected String subjectId;
    protected String subjectName;
    protected String subjectType;

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
    public static char changeGradeChar(int grade){
        //메서드의 반환형이 int여서 char로 수정했습니다--multiverse22
        return switch (grade) {
            case  1-> 'A';
            case  2-> 'B';
            case  3-> 'C';
            case  4-> 'D';
            case  5-> 'F';
            case  6-> 'N';
            default -> 0;
            //해당부분은 사용하지않는 다른알파벳을 리턴해 등급에서 예외사항발생을
            //표현하는것이 좋을 것 같습니다.
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