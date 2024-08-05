package Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SubjectData {
    protected String subjectId;
    protected String subjectName;
    protected String subjectType;

    ArrayList<String[]> subjectList = new ArrayList<>();
    public SubjectData() {
        //[][0]=CODE [][1] = Name [][2]=Type
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
    public void inquirySubjectList(){
        Collections.sort(subjectList, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });
        //subjectList를 [][0]번째 값으로 정렬 이경우에는 코드오름차순정렬이된다.
        int lineCount=0;
        System.out.println("==================================================");
        for(int i = 0; i < subjectList.size(); ++i) {
            String[] subject =subjectList.get(i);
            //[][0]=CODE [][1] = Name [][2]=Type
            System.out.printf("Code: %4s Name: %-20s Type: %s",subject[0],subject[1],subject[2]);
            System.out.println();


        }
        System.out.println("==================================================");
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