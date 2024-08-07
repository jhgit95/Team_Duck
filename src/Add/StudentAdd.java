package Add;


import Data.StudentData;
import Data.SubjectData;
import StudentInfo.Inquiry;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import static Data.SubjectData.subjectListMaxCount;
//final int타입변수는 subjectData클래스내부에 있기때문에 import를 해야 사용할 수 있다.
//subjectList의 최대값을 상수로 저장한값이다.

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
            System.out.println("상태를 입력하세요 1.Green 2.Yellow 3.Red");
            //상태는 영어명으로 통일
            state = sc.nextInt();
            sc.nextLine();
            if (state > 3 || state < 1) {
                //state가 범위를 벗어난다면 처음으로 돌아가 상태값을 다시입력받게한다.
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
                //학생의 과목리스트에 존재하면(중복불가)
                System.out.println("입력하신 코드는 이미존재합니다");
                continue;
            }
            for (int i = 0; i < subjectInfoList.size(); i++) {
                if (subjectInfoList.get(i)[0].equals(subjectId + "")) {
                    if (subjectInfoList.get(i)[2].equals("선택")) {
                        //입력받은코드와 같은 과목이 존재하면 그 과목의 타입이선택인지 필수인지확인함
                        //이 if문을 통과한다면 flag값이 false가된다.
                        //선택과목if문을 통과하면 choice값이 증가
                        requireAndChoice.add(subjectId);
                        flag=false;
                        choice++;
                        break;
                    }
                    if (subjectInfoList.get(i)[2].equals("필수")) {
                        //입력받은코드와 같은 과목이 존재하면 그 과목의 타입이선택인지 필수인지확인함
                        //이 if문을 통과한다면 flag값이 false가된다.
                        //필수과목if문을 통과하면 require값이 증가
                        requireAndChoice.add(subjectId);
                        flag=false;
                        require++;
                        break;
                    }
                }
            }
            if(flag){
                //만약 타입if문을 한번이라도 통과했다면 flag값이 false가 되어 동작하지않는다.
                //하지만 한번도통과하지못했다면(입력받은 코드와 동일한 코드를 가진 과목이 없다면)
                //존재하지않는코드라고 출력한후 while문 처음으로 돌아간다.
                System.out.println("존재하지 않는코드입니다.");
                continue;
            }
            if(requireAndChoice.size()>=subjectListMaxCount)
            //9이상의 subjectList는담을수 없다 subjectList의 최대갯수는 9개
            {
                System.out.println("담을수 있는 모든 과목을 담으셨습니다. 욕심이 많으시군요.");
                break;
            }
            if (require >= 3 && choice >= 2) {
                //필수 3개이상과 선택2개이상을 담았다면 더담을때마다 그만담을지 물어본다.
                System.out.println("필수과목3개이상과 선택과목2개이상을 선택하셨습니다. 그만담으시겠습니까? 0(Yes), 1(No)");
                int yesOrNo = sc.nextInt();
                sc.nextLine();
                if (yesOrNo == 0)
                    break;
            }
        }
        //이후 입력받은값에 해당하는 학생객체를 만들고 학생객체에 존재하는 학생이듣는과목에 대한list인
        //requireAndChoice리스트를 set한다.그후 st를 리턴
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
            System.out.print(inquiry.changeSubjectString(E)+", ");
            //E값을 changeSubjectString메서드에 넣으면 해당하는 과목이름이 반환됨
        }
        System.out.print("과목을 수강중입니다.");
        while (flag) {
            System.out.println("과목코드를 입력하세요");
            subjectId = sc.nextInt();
            sc.nextLine();
            if(subjectId<1||subjectId>subjectListMaxCount)
            {
                //아예존재하지않는 코드의 값이 들어온다면 예외처리.
                System.out.println("해당 코드의 과목은 존재하지 않습니다.");
                continue;
            }
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
                //1~9까지의 값이 들어왔지만 학생이 해당과목을 듣지않는경우의 예외처리
                System.out.println("이 학생은 해당코드의 과목을 수강하고 있지 않습니다.");
        }
        // 등록시 선택,필수 입력 삭제. InfoList 에 과제별로 설정인지, 필수인지 설정되어 있는 정보 사용.
        for(int i=0;i<subjectInfoList.size();i++)
        //반복문 모든 subjectInfoList 의 0번째 값(subjectId)에 적용.
        //모든 subjectInfoList 의 2번째 값(subjectType) 을 확인.
        //값이 필수면 0, 선택이면 1 로 입력.
        {
            if(subjectInfoList.get(i)[0].equals(subjectId+"")) {
                //깨알 지식 int 타입의 subjectId 뒤에 +"" 를 붙여서 문자열로 변경했습니다.
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
            if(round<1||round>10)
            {
                //회차 예외처리. 회차가 0보다 작거나 10보다 크면 다시 입력 반복.
                System.out.println("회차는 1~10사이의 정수여야 합니다.");
                continue;
            }
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
                    System.out.println("수정하고 싶으시면 Modify메뉴로 이동하십시오");
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























