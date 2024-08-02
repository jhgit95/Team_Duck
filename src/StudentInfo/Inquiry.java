package StudentInfo;
import Data.*;
import java.util.ArrayList;

public class Inquiry {

    StudentData studentData;
    ScoreData scoreData;
    Integer studentId;

    public Inquiry(StudentData studentData) {
        this.studentData = studentData;
        this.studentId = studentData.getStudentId();
    }

    public void InquiryStudentInfo() {


        String Name = studentData.getStudentName();

        ArrayList<String> subjectList = studentData.getSubjectList();

        System.out.println("학생 번호:" + studentId);
        System.out.println("학생 이름:" + Name);
        System.out.println("학생의 과목 목록:");
        for (String subject : subjectList) {
            System.out.println(subject);
        }
    }

    public void InquiryScoreInfo() {
        //조회 필수 정보 회차,등급 /+등급
        String Name = studentData.getStudentName();
        ArrayList<String> subjectList = studentData.getSubjectList();
        ArrayList<String> score = studentData.getScoreList();
        ArrayList<String> grade = studentData.getGradeList();
        System.out.println(Name + "님의 점수는");
        for (int i = 0; i < score.size(); i++) {
            System.out.println(subjectList.get(i) + "과목의 점수는 :" + score.get(i) + "등급은 :" + grade.get(i));
        }
    }

    public void InquirySubjectInfo() {


        ArrayList<String[]> subjectList = this.studentData.getSubjectDataSubjectList();

        for (int i = 0; i < subjectList.size(); ++i) {
            String[] subject = (String[]) subjectList.get(i);

            for (int j = 0; j < subject.length; ++j) {
                System.out.println(subject[j] + "의 고유번호는" + subject[j] + "이고 과목타입은" + subject[j] + "입니다.");
            }
        }
    }
}