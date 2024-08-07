package Add;

import Data.StudentData;
import Data.SubjectData;
import StudentInfo.Inquiry;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentAdd {
    StudentData st;
    int number = 0;
    Scanner sc = new Scanner(System.in);
    SubjectData subjectData=new SubjectData();
    public StudentAdd() {

    }

    //학생정보를 Add하는 메서드
    public StudentData addStudent() {
        System.out.println("이름을입력하세요");
        String Name =sc.nextLine();
        while(true) {
            System.out.println("상태를 입력하세요");
            int state = sc.nextInt();
            sc.nextLine();
            if (state >= 1 && state <= 3) {
                st = new StudentData(number, Name, state);
                number++;
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시입력해주세요");
            }
        }
        return st;
    }

    public StudentData addSubject(StudentData studentData) {
        subjectData.inquirySubjectList();
        boolean flag=true;
        int subjectId=0;
        int subjectType=0;
        ArrayList<int[]> studentsubjectlist = studentData.getSubjectList();
        ArrayList<String[]> subjectInfoList = subjectData.getSubjectList();

        while (flag) {
            System.out.println("과목코드를 입력하세요");
            subjectId = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < subjectInfoList.size(); i++) {
                if(subjectInfoList.get(i)[0].equals(subjectId+""))
                {
                    flag=false;
                    break;
                }
                else
                {
                }
            }
            if(flag)
                System.out.println("잘못된 코드입니다 다시입력하세요");
        }
        for(int i=0;i<subjectInfoList.size();i++)
        {
            if(subjectInfoList.get(i)[0].equals(subjectId+"")) {
                if (subjectInfoList.get(i)[2].equals("필수")) {
                    subjectType = 0;
                } else if (subjectInfoList.get(i)[2].equals("선택")) {
                    subjectType = 1;
                } else {

                }
            }
            else{
            }
        }

        System.out.println("입력하시려는 회차를 입력해주세요");
        int round=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<studentsubjectlist.size();i++)
        {
            if(studentsubjectlist.get(i)[2]==round&&studentsubjectlist.get(i)[0]==subjectId)
            {
                throw new RuntimeException();
            }
            else {
            }
        }
        System.out.println("점수를 입력해주세요");
        int score=sc.nextInt();
        sc.nextLine();
        st = studentData;
        st.subjectDetailsInput(subjectId, subjectType, score, round);
        return st;
    }
}


    /*
    int studentId;
    int number =0;
    String Name="";
    int state =0; // state 생태값 추가. 0 , 1, 2, 3, 4 에 따라 상태를 나타냄

//    상태값을 문자로 바꿔주는 기능이 Add 에서 필요할 경우 추가. -Data 참고.
//    public String changeStateString(int state){
//        return switch (state) {
//            case '1' -> "좋음";
//            case '2' -> "보통";
//            case '3' -> "나쁨";
//            case '4' -> "망함";
//            default -> 0;
//        };



    // StudentData 에서 가져옴. 과제 리스트, 과제 생성.
    ArrayList<int[]> subjectList = new ArrayList<>();
    int[] subjectDetails = new int[4];

    //필드에 scoreList 가 없어서 subjectList 랑 같은 형식으로 생성. 점수 리스트 생성.
//    int[] scoreList = new int[];

    //객체 생성.
    StudentAdd st = new StudentAdd(Name, 0);

    //생성자.. 객체가 생성될 때, 적용될 내용 정리. 이름 , 상태 순   ID는 자동으로 0부터 시작.= number.
    //그냥 가져다 쓰면됨. Data.메서드. 이미 만들어두신거 확인. 생성과 동시에 데이터에 저장.
    public StudentAdd(String Name, int state){
        number++;
//        Data.StudentData st = new Data.StudentData(number, Name, state);
        new Data.StudentData(number,Name,state);

    }
    // 학생을 등록할 때, 과목 받는것 삭제. 과목으로 따로 뺌.
    // 객체에 배열 추가? 배열에 객체 추가?? 화요일 오전에 질문.. 방법도 같이!
    // 배열에 객체 추가는 arr.push({...obj}) 형태로 해야한다!!!???





}

     */