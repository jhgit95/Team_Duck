package StudentInfo;
import Data.StudentData;
import Data.SubjectData;
import java.util.*;
import java.util.Collections;

import static Data.SubjectData.changeScoreGrade;

public class Inquiry {
    Integer studentId;
    SubjectData subjectData;
    String Name="";
    int state=0;
    String stringState="";
    ArrayList<int[]> subjectList;
    //학생들의 점수리스트
    List<Integer> rAC;
    //requireAndChoice 학생의 과목만을 담은리스트
    boolean flag=false;

    public Inquiry() {
        subjectData=new SubjectData();
    }
    public String changeSubjectString(int subjectId) {
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
    public String changeStateString(int state) {
        return switch (state) {
            case 1 -> "Green";
            case 2 -> "Yellow";
            case 3 -> "Red";

            default -> "잘못된값";
        };
    }
    public void inquiryStudentInfo(StudentData studentData) {
        //학생객체를 받아 학생한명의 정보를 Inquiry하는 메서드
        studentId=studentData.getStudentId();
        Name = studentData.getStudentName();
        subjectList = studentData.getSubjectList();
        stringState=changeStateString(studentData.getStudentState());
        //int타입 state를 String타입 stringState로 변경하는 메서드 changeStateString를 사용해 String타입으로 변경했습니다.
        rAC=studentData.getRequireAndChoice();
        Collections.sort(rAC);
        System.out.println("학생 고유번호:" +studentId);
        System.out.println("학생 이름:" + Name);
        if(subjectList.isEmpty()) {
            System.out.println(Name+" 님은 점수 데이터가 없습니다.");
        }
        else {
            System.out.println(Name + " 님은");
            for (Integer subjectId : rAC)
                System.out.print(changeSubjectString(subjectId) + " ");
            System.out.println();
            System.out.println("과목을 수강중입니다.");
        }
            System.out.println("학생의 상태:" + stringState);
    }
    public void inquirySubjectByRound(StudentData studentData,int subjectId){
        //특정 과목의 회차별 점수 Inquiry
        //학생이 해당과목을 수강하지않는다면 예외처리
        flag=true;
        subjectList = studentData.getSubjectList();
        Name=studentData.getStudentName();
        subjectList=inquirySortBySubjectIdThenRound(subjectList);
        //Id로 정렬후 round순으로 정렬하는 Inquiry클래스내부메서드
        if(subjectList.isEmpty()) {
            System.out.println("점수 데이터가 없습니다.");
        }
        else {
            flag = false;
            //일단 flag를 false로 설정
            for (int i = 0; i < subjectList.size(); i++)
                if (subjectList.get(i)[0] == subjectId) {
                    flag = true;
                    //해당하는 과목이있으면 flag를 true로변경
                }
            if (flag) {
                System.out.println(Name + " 님의 " + changeSubjectString(subjectId) + " 코드 과목의 회차별 점수는");
                for (int i = 0; i < subjectList.size(); i++) {
                    if (subjectList.get(i)[0] == subjectId) {
                        System.out.println(subjectList.get(i)[3] + "회차 점수:" + subjectList.get(i)[2] + "등급은:" + changeScoreGrade(subjectList.get(i)[1], subjectList.get(i)[2]));
                    }
                }
            } else {
                System.out.println("이 학생은 해당코드의 과목을 수강하지않았습니다.");
            }
        }
    }
    public void inquiryStudentsListShort(List<StudentData> studentsList) {
        //학생리스트를 출력해 어떤학생이 어떤 고유번호를 가지고있는지 확인할수 있게만듬
        for(StudentData Data:studentsList) {
            Name = Data.getStudentName();
            studentId = Data.getStudentId();
            System.out.println(Name + "학생의 고유번호는 " + studentId + "입니다");
        }
    }
    public void inquiryStudentsList(List<StudentData> studentsList){
        //학생리스트를 통째로받아옴 학생전부의 정보를 조회하는메서드
        for(StudentData Data:studentsList) {
            Name = Data.getStudentName();
            studentId = Data.getStudentId();
            subjectList = Data.getSubjectList();
            rAC = Data.getRequireAndChoice();
            Collections.sort(rAC);
            stringState = changeStateString(Data.getStudentState());
            System.out.println();
            System.out.println("학생 고유번호:" + studentId);
            System.out.println("학생 이름:" + Name);
            System.out.println(Name + "님은");
            if (subjectList.isEmpty())
            {
                System.out.println("점수 데이터가 없습니다!!");
            }
            else {
                for (Integer subjectId : rAC)
                    System.out.print(changeSubjectString(subjectId) + " ");
                System.out.println("과목을 수강중입니다.");
            }
            System.out.println("학생의 상태:"+stringState);
            System.out.println();
        }
    }
    public void inquirySpecificAvgGrade(StudentData studentData, int subjectId) {
        //특정과목의 id를 받으면 그과목의 평균등급을 Inquiry하는 메서드
        //학생이 해당과목을 듣지않는다면 예외처리
        flag=true;
        subjectList = studentData.getSubjectList();
        List<Character> list = new ArrayList<>();
        Name = studentData.getStudentName();
        char avgGrade;
        if(subjectList.isEmpty()) {
            System.out.println("점수 데이터가 없습니다!!");
        }
        else {
            for (int i = 0; i < subjectList.size(); i++)
                if (subjectList.get(i)[0] == subjectId) {
                    flag = true;
                    //해당하는 과목이있으면 flag를 true로변경
                }
            if (flag) {
                for (int i = 0; i < subjectList.size(); i++) {
                    if (subjectList.get(i)[0] == subjectId) {
                        Character grade = changeScoreGrade(subjectList.get(i)[1], subjectList.get(i)[2]);
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
                System.out.println(subjectId + "에 해당하는 과목은 " + changeSubjectString(subjectId));
                System.out.println(Name + "학생의 " + changeSubjectString(subjectId) + "과목 평균등급은" + avgGrade + "입니다");
            } else {
                System.out.println("해당학생은 해당과목을 수강하지 않았습니다.");
            }
        }
    }
    public void inquiryByStateAndRequireSubjectAvgGrade(List<StudentData> studentsList,int state){
        //학생들중 특정상태의 필수과목의 평균등급을 조회하는 메서드
        flag=true;
        for(StudentData studentData:studentsList) {
            if(studentData.getStudentState()==state) {
                flag = false;
                Name = studentData.getStudentName();
                subjectList = studentData.getSubjectList();
                if (subjectList.isEmpty()) {
                    System.out.println(Name+"학생은 점수데이터가 없습니다.");
                } else {
                    List<Character> list = new ArrayList<>();
                    char avgGrade;
                    for (int i = 0; i < subjectList.size(); i++) {
                        if (subjectList.get(i)[1] == 0) {
                            //타입이 0인 필수과목들의 등급만리스트에 .add
                            Character grade = changeScoreGrade(subjectList.get(i)[1], subjectList.get(i)[2]);
                            list.add(grade);
                        }
                    }
                    double sum = 0;
                    for (Character grade : list) {
                        switch (grade) {
                            case 'A':
                                sum += 4.0;
                                break;
                            case 'B':
                                sum += 3.0;
                                break;
                            case 'C':
                                sum += 2.0;
                                break;
                            case 'D':
                                sum += 1.0;
                                break;
                            case 'E':
                                sum += 0.5;
                                break;
                            default:
                                break;
                        }
                    }
                    sum = sum / list.size();
                    if (sum >= 4.0)
                        avgGrade = 'A';
                    else if (sum >= 3.0)
                        avgGrade = 'B';
                    else if (sum >= 2.0)
                        avgGrade = 'C';
                    else if (sum >= 1.0)
                        avgGrade = 'D';
                    else if (sum >= 0.5)
                        avgGrade = 'E';
                    else avgGrade = 'F';
                    System.out.println("1=Green, 2=Yellow, 3=Red 중 " + changeStateString(state) + "상태인");
                    System.out.println(Name + "님의 필수 과목 평균 등급은 " + avgGrade + "입니다");
                }
            }
        }
        //flag가 false인경우는 내부 if문을 한번도 타지않은경우 = 특정상태의 수강생이 없는경우
        if(flag)
            System.out.println(changeStateString(state)+" 상태의 수강생이 없습니다.");
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
        flag=true;
        System.out.println("Green,Yellow,Red 중 "+changeStateString(state)+" 상태인");
        for(StudentData Data:studentsList) {
            if(Data.getStudentState()==state){
                flag=false;
                Name = Data.getStudentName();
                studentId = Data.getStudentId();
                System.out.println(Name +"학생의 고유번호는 "+ studentId+ " 입니다");
            }
        }
        if(flag)
            System.out.println(changeStateString(state)+"상태인 학생은 없습니다.");
    }
    public void inquirySubjectList(StudentData studentData) {
        //특정학생의 수강과목점수조회
        Name = studentData.getStudentName();
        ArrayList<int[]> subjectList = studentData.getSubjectList();
        if (subjectList.isEmpty())
            System.out.println("점수 데이터가 존재하지 않습니다.");
        else {
            subjectData.inquirySubjectList();
            //과목의 리스트 출력해 어떤코드가 어떤과목인지 알수있게 하는 메서드
            System.out.println(Name + "님의 점수는");
            subjectList = inquirySortBySubjectIdThenRound(subjectList);
            for (int i = 0; i < subjectList.size(); i++) {
                String subjectName = changeSubjectString(subjectList.get(i)[0]);
                String Type = "";
                if (subjectList.get(i)[1] == 0) {
                    Type = "필수";
                } else {
                    Type = "선택";
                }
                int score = subjectList.get(i)[2];
                int round = subjectList.get(i)[3];
                char grade = changeScoreGrade(subjectList.get(i)[1], score);
                System.out.println(Type + "과목의 " + subjectName + "의 " + round + "회차의 점수는 " + score + "점이고 등급은 " + grade + "입니다.");
                //[0][0] [0][1] [0][2] [0][3] 순서로 출력
            }
        }
    }
}