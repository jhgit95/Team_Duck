

package StudentInfo;

import Data.ScoreData;
import Data.StudentData;

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
        System.out.println("학생 번호:" +studentId);
        System.out.println("학생 이름:" + Name);
        System.out.println("학생의 과목 목록:");


    }

    public void InquiryScoreInfo() {
        String Name = studentData.getStudentName();
        ArrayList<String> subjectList = studentData.getSubjectList();
        ArrayList<String> scoreList = studentData.getScoreList();
        ArrayList<String> gradeList = studentData.getGradeList();
        System.out.println(Name + "님의 점수는");

        for(int i = 0; i < scoreList.size(); ++i) {

            System.out.println(subjectList.get(i) + "과목의 점수는 :" + scoreList.get(i) + "등급은 :" + gradeList.get(i));
        }

    }

    public void InquirySubjectInfo() {
        ArrayList<String[]> subjectList = this.studentData.getSubjectDataSubjectList();

        for(int i = 0; i < subjectList.size(); ++i) {
            String[] subject =subjectList.get(i);

            for(int j = 0; j < subject.length; ++j) {
                System.out.println(subject[j] + "의 고유번호는" + subject[j] + "이고 과목타입은" + subject[j] + "입니다.");
            }
        }

    }
}
