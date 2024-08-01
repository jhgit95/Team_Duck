package StudentInfo;
import Data.*;
import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Inquiry {
    Integer studentId=0;
    StudentData studentData;
    public Inquiry(Integer studentId){
        this.studentId=studentId;
    }

    public InquiryStudentInfo()
    {


        String Name=studentData.getStudentName(studentId);

        ArrayList<String> subjectList=studentData.getStudentSubjectList();

        System.out.println("학생 번호:"+studentId);
        System.out.println("학생 이름:"+Name);
        System.out.println("학생의 과목 목록:");
        for(String subject:subjectList)
        {
            System.out.println(subject);
        }
    }
    public InquiryScoreInfo(){
        //조회 필수 정보 회차,등급 /+등급
        String Name=getStudentName(studentId);
        ArrayList<String> subjectList=getStudentSubjectList(studentId);
        ArrayList<Integer> score=getScoreList(studentId);
        ArrayList<String> grade=getScoreGrade(studentId);
        System.out.println(Name+"님의 점수는");
        for(int i=0;i<score.size();i++) {
            System.out.println(subjectList.get(i)+"과목의 점수는 :"+score.get(i)+"등급은 :"+grade.get(i));
        }
    }
    public InquirySubjectInfo(){

        //과목정보형태는 어떤식으로 구현해야할까?? enum으로 구현하기 Data클래스에서 과목들의 정보를 저장했다가 리턴하는방식?
        //2차원배열로 하면어떨까?  subject[N][0]은 과목이름 subject[N][1]=과목Id subject[N][2]는 과목타입
        //subjectList[N]={"Java","0001","필수"}
        //그렇게되면

        for(int i=0;i<subjectList.size();i++) {
            System.out.println(subjectList[i][0]+"의 고유번호는"+subjectList[i][1]+"이고 과목타입은"+subjectList[i][2]+"입니다.");
        }
    }
}
