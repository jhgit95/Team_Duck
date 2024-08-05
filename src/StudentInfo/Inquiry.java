package StudentInfo;
import Data.StudentData;
import Data.SubjectData;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inquiry {
    Integer studentId;
    SubjectData subjectData;
    public Inquiry() {
        subjectData=new SubjectData();

    }

    public void InquiryStudentInfo(StudentData studentData) {
        studentId=studentData.getStudentId();
        String Name = studentData.getStudentName();
        ArrayList<int[]> subjectList = studentData.getSubjectList();
        int state=studentData.getStudentState();
        List<Integer> list=new ArrayList<>();
        //Stream활용을 위한 list생
        System.out.println("학생 번호:" +studentId);
        System.out.println("학생 이름:" + Name);
        System.out.println(Name + "님은");
        for(int i=0;i<subjectList.size();i++) {
            list.add(subjectList.get(i)[0]);
        }
        Stream<Integer> subject=list.stream().distinct();
        subject.forEach(System.out::println);
        System.out.println("과목을 수강중입니다.");
        System.out.println("학생의 상태:"+state);
    }
    public void InquirySubjectByRound(StudentData studentData,int subjectId){
        ArrayList<int[]> subjectList = studentData.getSubjectList();
        String Name=studentData.getStudentName();
        subjectList=InquirySort(subjectList);
        System.out.println(Name+" 님의 "+subjectId+" 코드 과목의 회차별 점수는");
        for(int i=0;i<subjectList.size();i++) {
            if(subjectList.get(i)[0]==subjectId){
                System.out.println(subjectList.get(i)[3]+"회차 점수:"+subjectList.get(i)[2]+"등급은:"+studentData.changeScoreGrade(subjectList.get(i)[1],subjectList.get(i)[2]));
            }
        }

    }
    public void InquiryStudentsList(List<StudentData> studentsList){
        //학생리스트를 통째로받아옴
        for(StudentData Data:studentsList) {
            String Name = Data.getStudentName();
            int Id = Data.getStudentId();
            ArrayList<int[]> subjectList = Data.getSubjectList();
            List<Integer> list=new ArrayList<>();
            int state = Data.getStudentState();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println(Name + "님의 고유번호는 " + Id + "입니다");
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
            System.out.println("-----------------------------------------------------------------------------");
        }
    }
    public ArrayList<int[]> InquirySort(ArrayList<int[]> subjectList){
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
    public void InquiryByState(List<StudentData> studentsList,int state) {
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
                String Name = Data.getStudentName();
                int Id = Data.getStudentId();
                System.out.println(Name +" 님의 id는"+ Id+ "입니다");
            }
        }


    }
    public void InquiryScoreInfo(StudentData studentData) {
        String Name = studentData.getStudentName();
        //넘겨받은객체에서 이름받아오기
        ArrayList<int[]> subjectList = studentData.getSubjectList();
        //학생의 점수리스트
        subjectData.inquirySubjectList();
        //과목의 리스트 출력해 어떤코드가 어떤과목인지 알수있게 하는 메서드
        System.out.println(Name + "님의 점수는");
        subjectList=InquirySort(subjectList);
        for(int i = 0; i < subjectList.size(); i++) {
            int subjectId = subjectList.get(i)[0];
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
            System.out.println("Code:"+subjectId+"의 타입은"+Type+"입니다"+round+"회차의 점수는"+score+"점이고 등급은"+grade+"입니다.");
            //[0][0] [0][1] [0][2] [0][3] 순서로 출력
        }

    }
}