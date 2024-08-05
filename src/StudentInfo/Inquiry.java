

package StudentInfo;

import Data.ScoreData;
import Data.StudentData;
import Data.SubjectData;

import java.util.List;
import java.util.ArrayList;

public class Inquiry {
    Integer studentId;
    SubjectData subjectData;
    public Inquiry() {
        SubjectData subjectData=new SubjectData();

    }

    public void InquiryStudentInfo(StudentData studentData) {
        studentId=studentData.getStudentId();
        String Name = studentData.getStudentName();
        ArrayList<String> subjectList = studentData.getSubjectList();
        String state=studentData.getStudentState();
        System.out.println("학생 번호:" +studentId);
        System.out.println("학생 이름:" + Name);
        System.out.println("학생의 과목 목록:"+subjectList);
        System.out.println("학생의 상태:"+state);
    }
    public void InquiryStudentsList(List<StudentData> studentsList){
        //학생리스트를 통째로받아옴
        for(StudentData Data:studentsList) {
            String Name = Data.getStudentName();
            int Id = Data.getStudentId();
            List<String> subjectList = Data.getSubjectList();
            String state = Data.getStudentState();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println(Name + "님의 고유번호는 " + Id + "입니다");
            System.out.println(Name + "님은" + subjectList + "의 과목을 수강중입니다.");
            System.out.println(Name + "님의 현재 상태는" + state + "입니다");
            System.out.println("-----------------------------------------------------------------------------");

        }
    }
    public void InquiryByState(List<StudentData> studentsList){
        for (StudentData studentData : studentsList) {
            if(studentData.getStudentState().equals("맑음")){
                InquiryStudentInfo(studentData);
            }
        }
        for (StudentData studentData : studentsList) {
            if(studentData.getStudentState().equals("비")){
                InquiryStudentInfo(studentData);
            }
        }
        for (StudentData studentData : studentsList) {
            if(studentData.getStudentState().equals("천둥")){
                InquiryStudentInfo(studentData);
            }
        }
    }
    public void InquiryScoreInfo(StudentData studentData) {
        String Name = studentData.getStudentName();
        ArrayList<String>[] scoreList = studentData.getScoreList();
        System.out.println(Name + "님의 점수는");

        for(int i = 0; i < scoreList.length; ++i) {
            for(int j=0; j < scoreList.length; ++j) {

                //System.out.println(scoreList[i].get(j)+"과목의 점수는 :"++"등급은 :" +);
            }
        }

    }

    public void InquirySubjectInfo() {
        ArrayList<String[]> subjectList = subjectData.getSubjectList();

        for(int i = 0; i < subjectList.size(); ++i) {
            String[] subject =subjectList.get(i);

            for(int j = 0; j < subject.length; ++j) {
                System.out.println(subject[j] + "의 고유번호는" + subject[j] + "이고 과목타입은" + subject[j] + "입니다.");
            }
        }

    }
}