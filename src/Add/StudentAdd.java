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
            System.out.println("상태를 입력하세요 1. 좋음 2. 보통 3. 나쁨");
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
        //과제 코드 입력. + 예외처리 = subjectInfoList 의 크기보다 높은 값 입력하면 다시 입력.
        //깨알 지식 int 타입의 subjectId 뒤에 +"" 를 붙여서 문자열로 변경했습니다.
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
        // 등록시 선택,필수 입력 삭제. InfoList 에 과제별로 설정인지, 필수인지 설정되어 있는 정보 사용.
        for(int i=0;i<subjectInfoList.size();i++)
        //반복문 모든 subjectInfoList 의 0번째 값(subjectId)에 적용.
        //모든 subjectInfoList 의 2번째 값(subjectType) 을 확인.
        //값이 필수면 0, 선택이면 1 로 입력.
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
        //회차를 받습니다. 1~10 사이 값을 입력해야합니다.
        System.out.println("입력하시려는 회차를 입력해주세요");
        int round=sc.nextInt();
        sc.nextLine();
        //회차 예외처리. 회차가 0보다 작거나 10보다 크면 다시 입력 반복.
        while(round < 0 || round > 10) {
            System.out.println("존재하지 않는 회차입니다. 다시 입력해주세요!");
            round=sc.nextInt();
            sc.nextLine();
        //회차가 0보다 크고 10보다 작거나 같다면 반복문 종료.
            if(round >0 && round <= 10){
        //회차 중복체크. 같은 회차에 2개의 과목 중복인지 체크.
        //리스트 크기만큼 반복해서 round(회차 입력값) = studentsubjectlist.get(i)[2] i번째 회차값
        //subjectId(과제 입력값) = studentsubjectlist.get(i)[0] i번째 과제 값 이 동시에 성립하면 중복!
                for(int i=0;i<studentsubjectlist.size();i++)
                {
                    if(studentsubjectlist.get(i)[2]==round && studentsubjectlist.get(i)[0]==subjectId)
                    {
                        throw new RuntimeException();
                    }
                    else {
                    }
                }break;
            }
        }


        // 점수를 받습니다. 0~100 사이 값을 입력해야합니다.
        System.out.println("점수를 입력해주세요");
        int score=sc.nextInt();
        sc.nextLine();

        //예외처리. 점수가 0보다 작거나, 100보다 크다면 다시 입력해주세요 안내와 함께 다시 입력을 받는다.
        while(score < 0 || score > 100) {
            System.out.println("다시 입력해주세요. 점수는 0~100점 사이입니다.");
            score = sc.nextInt();
            sc.nextLine();
        //점수가 0보다 크면서 동시에 100보다 작거나 같다면 반복문 종료.
            if (score > 0 && score <= 100){
                break;
            }
        }
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