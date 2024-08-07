package Add;

import Data.StudentData;
import Data.SubjectData;
import StudentInfo.Inquiry;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class StudentAdd {
    StudentData st;
    int number = 0;
    Scanner sc = new Scanner(System.in);
    SubjectData subjectData = new SubjectData();
    Inquiry inquiry = new Inquiry();
    public StudentAdd() {

    }

    //학생정보를 Add하는 메서드
    public StudentData addStudent() {
        ArrayList<String[]> subjectInfoList = subjectData.getSubjectList();
        int subjectId = 0;
        int require = 0;
        int choice = 0;
        int state=0;
        ArrayList<Integer> requireAndChoice = new ArrayList<>();
        boolean flag = true;
        System.out.println("이름을입력하세요");
        String Name = sc.nextLine();
        while (true) {
            System.out.println("상태를 입력하세요 1. 좋음 2. 보통 3. 나쁨");
            state = sc.nextInt();
            sc.nextLine();
            if (state > 3 || state < 1) {
                System.out.println("잘못된입력입니다 1~3사이의 상태값을 입력해주세요");
                continue;
            }
            break;
        }
        subjectData.inquirySubjectList();
        while (true) {
            System.out.println("과목코드를 입력하세요 필수3개이상 선택2개이상");
            System.out.println("현재 상태 필수:"+require+"개 선택:"+choice+"개 선택되었습니다.");
            subjectId = sc.nextInt();
            sc.nextLine();
            flag=true;
            if(requireAndChoice.contains(subjectId)) {
                System.out.println("입력하신 코드는 이미존재합니다");
                continue;
            }
            for (int i = 0; i < subjectInfoList.size(); i++) {
                if (subjectInfoList.get(i)[0].equals(subjectId + "")) {
                    if (subjectInfoList.get(i)[2].equals("선택")) {
                        requireAndChoice.add(subjectId);
                        flag=false;
                        choice++;
                        break;
                    }
                    if (subjectInfoList.get(i)[2].equals("필수")) {
                        requireAndChoice.add(subjectId);
                        flag=false;
                        require++;
                        break;
                    }
                }
            }
            if(flag){
                System.out.println("존재하지 않는코드입니다.");
                continue;
            }
            if (require >= 3 && choice >= 2) {
                System.out.println("필수과목3개이상과 선택과목2개이상을 선택하셨습니다. 그만담으시겠습니까? 0(Yes), 1(No)");
                int yesOrNo = sc.nextInt();
                sc.nextLine();
                if (yesOrNo == 0)
                    break;
            }
        }
        st =new StudentData(number, Name, state);
        number++;
        st.setRequireAndChoice(requireAndChoice);
        return st;
    }




    public StudentData addSubject(StudentData studentData) {
        boolean flag=true;
        int subjectId=0;
        int subjectType=0;
        int round=0;
        int score=0;
        ArrayList<int[]> studentSubjectList = studentData.getSubjectList();
        ArrayList<String[]> subjectInfoList = subjectData.getSubjectList();
        ArrayList<Integer> requireAndChoice = studentData.getRequireAndChoice();
        subjectData.inquirySubjectList();
        System.out.print("해당 학생은 ");
        for(Integer E:requireAndChoice) {
            System.out.print(inquiry.changeStateString(E)+", ");
        }
        System.out.print("과목을 수강중입니다.");
        //과제 코드 입력. + 예외처리 = subjectInfoList 의 크기보다 높은 값 입력하면 다시 입력.
        //깨알 지식 int 타입의 subjectId 뒤에 +"" 를 붙여서 문자열로 변경했습니다.
        while (flag) {
            System.out.println("과목코드를 입력하세요");
            subjectId = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < requireAndChoice.size(); i++) {
                //학생의 requireAndChoice리스트를 확인 해당리스트에는 해당학생이 수강하는 subject id
                //값이 중복없이 저장되어있음
                if(requireAndChoice.get(i)==subjectId)
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
                System.out.println("이 학생은 해당코드의 과목을 수강하고 있지 않습니다.");
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
                }
                else if (subjectInfoList.get(i)[2].equals("선택")) {
                    subjectType = 1;
                }
            }
        }

        flag=true;
        while(flag) {
            System.out.println("입력하시려는 회차를 입력해주세요");
            round=sc.nextInt();
            sc.nextLine();
            if(round<0||round>10)
            {
                //회차 예외처리. 회차가 0보다 작거나 10보다 크면 다시 입력 반복.
                System.out.println("회차는 1~10사이의 정수여야 합니다.");
                continue;
            }
            //회차가 0보다 크고 10보다 작거나 같다면 반복문 종료.
                //회차 중복체크. 같은 회차에 2개의 과목 중복인지 체크.
                //리스트 크기만큼 반복해서 round(회차 입력값) = studentsubjectlist.get(i)[2] i번째 회차값
                //subjectId(과제 입력값) = studentsubjectlist.get(i)[0] i번째 과제 값 이 동시에 성립하면 중복!
            if(studentSubjectList.size()==0)
            {//사이즈가 0일때는 그냥 넣기 겹칠수가없음
                break;
            }
            for(int i=0;i<studentSubjectList.size();i++)
            {//리스트의 사이즈가0이면 아예안돌아감
                if(studentSubjectList.get(i)[3]==round && studentSubjectList.get(i)[0]==subjectId)
                {
                    //동일id,round가 존재하면 예외처리
                    System.out.println("이미 중복된 회차가 존재합니다.");
                    flag=true;
                    break;
                }
                else
                {
                    //중복값이 없으면 flag=false
                    flag=false;
                }
            }
            //다돌았는데 플래그가 false다= 회차는1~10사이의 정수이면서 중복되는id값에해당하는 중복되는 회차값이없다.
            if(!flag)
                break;
        }


        // 점수를 받습니다. 0~100 사이 값을 입력해야합니다.
        //예외처리. 점수가 0보다 작거나, 100보다 크다면 다시 입력해주세요 안내와 함께 다시 입력을 받는다.
        while(true) {
            System.out.println("점수를 입력해주세요");
            score=sc.nextInt();
            sc.nextLine();
            if(score<0||score>100)
            {
                System.out.println("다시 입력해주세요. 점수는 0~100점 사이입니다.");
                continue;
            }
            break;
        }
        st = studentData;
        st.subjectDetailsInput(subjectId, subjectType, score, round);
        return st;

    }
}























