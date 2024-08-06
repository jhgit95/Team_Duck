package StudentInfo;
import Data.StudentData;
import Data.SubjectData;
import java.util.*;
import java.util.stream.Stream;

public class Inquiry {
    Integer studentId;
    SubjectData subjectData;
    String Name="";
    int state=0;
    ArrayList<int[]> subjectList;
    //학생들의 점수리스트
    List<Integer> list;
    boolean flag=false;

    public Inquiry() {
        subjectData=new SubjectData();
    }
    public void inquiryStudentInfo(StudentData studentData) {
        //학생객체를 받아 학생한명의 정보를 Inquiry하는 메서드
        studentId=studentData.getStudentId();
        Name = studentData.getStudentName();
        subjectList = studentData.getSubjectList();
        state=studentData.getStudentState();
        list=new ArrayList<>();
        //Stream활용을 위한 list생성
        System.out.println("학생 번호:" +studentId);
        System.out.println("학생 이름:" + Name);
        System.out.println(Name + "님은");
        for(int i=0;i<subjectList.size();i++) {
            list.add(subjectList.get(i)[0]);
            //list에 과목id를 전부넣는다
        }
        Stream<Integer> subject=list.stream().distinct();
        //list에 있는 과목id중 중복되는값은 제외한 스트림생성
        subject.forEach(System.out::println);
        System.out.println("과목을 수강중입니다.");
        System.out.println("학생의 상태:"+state);
    }
    public void inquirySubjectByRound(StudentData studentData,int subjectId){
        //특정 과목의 회차별 점수 Inquiry
        subjectList = studentData.getSubjectList();
        Name=studentData.getStudentName();
        subjectList=inquirySortBySubjectIdThenRound(subjectList);
        //Id로 정렬후 round순으로 정렬하는 Inquiry클래스내부메서드
        System.out.println(Name+" 님의 "+subjectId+" 코드 과목의 회차별 점수는");
        for(int i=0;i<subjectList.size();i++) {
            if(subjectList.get(i)[0]==subjectId){
                System.out.println(subjectList.get(i)[3]+"회차 점수:"+subjectList.get(i)[2]+"등급은:"+studentData.changeScoreGrade(subjectList.get(i)[1],subjectList.get(i)[2]));
            }
        }
    }
    public void inquiryStudentsListShort(List<StudentData> studentsList) {
        for(StudentData Data:studentsList) {
            Name = Data.getStudentName();
            studentId = Data.getStudentId();
            System.out.println(Name + "님의 고유번호는 " + studentId + "입니다");
        }
    }
    public void inquiryStudentsList(List<StudentData> studentsList){
        //학생리스트를 통째로받아옴 학생전부의 정보를 조회하는메서드
        System.out.println("-----------------------------------------------------------------------------");
        for(StudentData Data:studentsList) {
            Name = Data.getStudentName();
            studentId = Data.getStudentId();
            subjectList = Data.getSubjectList();
            list=new ArrayList<>();
            state = Data.getStudentState();
            System.out.println(Name + "님의 고유번호는 " + studentId + "입니다");
            System.out.println(Name + "님은");
            for(int i=0;i<subjectList.size();i++) {
                list.add(subjectList.get(i)[0]);
                //학생의 과목리스트중 id값만을 list에 넣음
            }
            Stream<Integer> subject=list.stream().distinct();
            //리스트에 존재하는 id값중 중복제거
            subject.forEach(System.out::println);
            //중복이 없어진 subject 스트림을 출력
            System.out.println("과목을 수강중입니다.");
            System.out.println(Name + "님의 현재 상태는" + state + "입니다");
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
    public char inquirySpecificAvgGrade(StudentData studentData, int subjectId){
        //특정과목의 id를 받으면 그과목의 평균등급을 Inquiry하는 메서드
        subjectList = studentData.getSubjectList();
        List<Character> list=new ArrayList<>();
        char avgGrade;
        for(int i=0;i<subjectList.size();i++) {
            if(subjectList.get(i)[0]==subjectId){
                Character grade=studentData.changeScoreGrade(subjectList.get(i)[1],subjectList.get(i)[2]);
                list.add(grade);
            }
        }
        double sum=0;
        for(Character grade:list){
            switch(grade) {
                case 'A':
                    sum+=4.5;
                    break;
                case 'B':
                    sum+=3.5;
                    break;
                case 'C':
                    sum+=2.5;
                    break;
                case 'D':
                    sum+=1.5;
                    break;
                case 'E':
                    sum+=0.5;
                    break;
                default:
                    break;
            }
        }
        sum=sum/list.size();
        if(sum>=4.5)
            avgGrade='A';
        else if (sum>=3.5)
            avgGrade='B';
        else if (sum>=2.5)
            avgGrade='C';
        else if (sum>=1.5)
            avgGrade='D';
        else if (sum>=0.5)
            avgGrade='E';
        else avgGrade='F';

        return avgGrade;
    }
    public void inquiryByStateAndRequireSubjectAvgGrade(List<StudentData> studentsList,int state){
        //학생들중 특정상태의 필수과목의 평균등급을 조회하는 메서드
        for(StudentData studentData:studentsList) {
            if(studentData.getStudentState()==state) {
                Name=studentData.getStudentName();
                subjectList = studentData.getSubjectList();
                List<Character> list = new ArrayList<>();
                char avgGrade;
                for (int i = 0; i < subjectList.size(); i++) {
                    if (subjectList.get(i)[1] == 0) {
                        //타입이 0인 필수과목들의 등급만리스트에 .add
                        Character grade = studentData.changeScoreGrade(subjectList.get(i)[1], subjectList.get(i)[2]);
                        list.add(grade);
                    }
                }
                double sum = 0;
                for (Character grade : list) {
                    switch (grade) {
                        case 'A':
                            sum += 4.5;
                            break;
                        case 'B':
                            sum += 3.5;
                            break;
                        case 'C':
                            sum += 2.5;
                            break;
                        case 'D':
                            sum += 1.5;
                            break;
                        case 'E':
                            sum += 0.5;
                            break;
                        default:
                            break;
                    }
                }
                sum = sum / list.size();
                if (sum >= 4.5)
                    avgGrade = 'A';
                else if (sum >= 3.5)
                    avgGrade = 'B';
                else if (sum >= 2.5)
                    avgGrade = 'C';
                else if (sum >= 1.5)
                    avgGrade = 'D';
                else if (sum >= 0.5)
                    avgGrade = 'E';
                else avgGrade = 'F';
                System.out.println("1=Green, 2=Yellow, 3=Red 중 "+state+"상태인");
                System.out.println(Name+"님의 필수 과목 평균 등급은 "+avgGrade+"입니다");
            }
        }
    }
    public ArrayList<int[]> inquirySortBySubjectIdThenRound(ArrayList<int[]> subjectList){
        Collections.sort(subjectList, new Comparator<int[]>() {
            //점수리스트를 정렬합니다.
            @Override
            public int compare(int[] o1, int[] o2) {
                //첫번째 기준[][0] 값 ==과목 id값
                if(o1[0]!=o2[0]){
                    return Integer.compare(o1[0],o2[0]);
                }
                //그다음 기준 round값
                //만약같은값이면->과목이 같은경우에는 round값으로 정렬
                return Integer.compare(o1[3],o2[3]);
            }
        });
        return subjectList;
    }
    public void inquiryByState(List<StudentData> studentsList,int state) {
        //리스트와 상태를 넘겨받아 특정상태의 학생의 id값 Inquiry하는 메서드
        String color="";
        if(state==1)
            color="Green";
        else if(state==2)
            color="Yellow";
        else
            color="Red";
        System.out.println("1=Green, 2=Yellow, 3=Red 중 "+color+" 상태인");
        for(StudentData Data:studentsList) {
            if(Data.getStudentState()==state){
                Name = Data.getStudentName();
                studentId = Data.getStudentId();
                System.out.println(Name +" 님의 id는 "+ studentId+ " 입니다");
            }
        }
    }
    public String changeStateString(int subjectId) {
        return switch (subjectId) {
            case 1 -> "Java";
            case 2 -> "객체지향";
            case 3 -> "Spring";
            case 4 -> "JPA";
            case 5 -> "MySQL";
            case 6 -> "디자인 패턴";
            case 7 -> "Spring Security";
            case 8 -> "Redis";
            case 9 -> "MongoDB";

            default -> "잘못된값";
        };
    }
    public void inquirySubjecList(StudentData studentData) {
        //특정학생의 수강과목점수조회
        Name = studentData.getStudentName();
        ArrayList<int[]> subjectList = studentData.getSubjectList();
        subjectData.inquirySubjectList();
        //과목의 리스트 출력해 어떤코드가 어떤과목인지 알수있게 하는 메서드
        System.out.println(Name + "님의 점수는");
        subjectList=inquirySortBySubjectIdThenRound(subjectList);
        for(int i = 0; i < subjectList.size(); i++) {
            String subjectName = changeStateString(subjectList.get(i)[0]);
            String Type="";
            if(subjectList.get(i)[1]==0) {
                Type="필수";
            }
            else {
                Type="선택";
            }
            int score = subjectList.get(i)[2];
            int round = subjectList.get(i)[3];
            char grade = studentData.changeScoreGrade(subjectList.get(i)[1],score);
            System.out.println("Code:"+subjectName+"의 타입은"+Type+"입니다"+round+"회차의 점수는"+score+"점이고 등급은"+grade+"입니다.");
            //[0][0] [0][1] [0][2] [0][3] 순서로 출력
        }

    }
}