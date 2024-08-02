

package StudentInfo;

import Data.ScoreData;
import Data.StudentData;
import java.util.List;
import java.util.ArrayList;

public class Inquiry {
    StudentData studentData;
    ScoreData scoreData;
    int studentId;
    List<StudentData> studentsList;

    public Inquiry(StudentData studentData) {
        this.studentData = studentData;
        this.studentId = studentData.getStudentId();
    }
    public Inquiry(List<StudentData> studentDataList) {
        this.studentsList = studentDataList;
    }

    public void InquiryStudentInfo() {
        studentId=studentData.getStudentId();
        String Name = studentData.getStudentName();
        ArrayList<String> subjectList = studentData.getSubjectList();
        String state=studentData.getStudentState();
        System.out.println("학생 번호:" +studentId);
        System.out.println("학생 이름:" + Name);
        System.out.println("학생의 과목 목록:"+subjectList);
        System.out.println("학생의 상태:"+state);


    }
    public void InquiryStudentsList(){
        //학생리스트를 통째로받아옴
        for (StudentData studentData : studentsList) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println(studentData.getStudentName()+"님의 고유번호는 "+studentData.getStudentId()+"입니다");
            System.out.println(studentData.getStudentName()+"님은"+studentData.getSubjectList()+"의 과목을 수강중입니다.");
            System.out.println(studentData.getStudentName()+"님의 현재 상태는"+studentData.getStudentState()+"입니다");
            System.out.println("-----------------------------------------------------------------------------");
        }
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
