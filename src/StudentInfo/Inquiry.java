

package StudentInfo;

import Data.ScoreData;
import Data.StudentData;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Inquiry {
    StudentData studentData;
    ScoreData scoreData;
    Integer studentId;

    public Inquiry(StudentData studentData) {
        this.studentData = studentData;
        this.studentId = studentData.getStudentId();
    }

    public void InquiryStudentInfo() {
        String Name = this.studentData.getStudentName();
        ArrayList<String> subjectList = this.studentData.getSubjectList();
        System.out.println("학생 번호:" + this.studentId);
        System.out.println("학생 이름:" + Name);
        System.out.println("학생의 과목 목록:");
        Iterator var3 = subjectList.iterator();

        while(var3.hasNext()) {
            String subject = (String)var3.next();
            System.out.println(subject);
        }

    }

    public void InquiryScoreInfo() {
        String Name = this.studentData.getStudentName();
        ArrayList<String> subjectList = this.studentData.getSubjectList();
        ArrayList<String> score = this.studentData.getScoreList();
        ArrayList<String> grade = this.studentData.getGradeList();
        System.out.println(Name + "님의 점수는");

        for(int i = 0; i < score.size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = (String)subjectList.get(i);
            var10000.println(var10001 + "과목의 점수는 :" + (String)score.get(i) + "등급은 :" + (String)grade.get(i));
        }

    }

    public void InquirySubjectInfo() {
        ArrayList<String[]> subjectList = this.studentData.getSubjectDataSubjectList();

        for(int i = 0; i < subjectList.size(); ++i) {
            String[] subject = (String[])subjectList.get(i);

            for(int j = 0; j < subject.length; ++j) {
                System.out.println(subject[j] + "의 고유번호는" + subject[j] + "이고 과목타입은" + subject[j] + "입니다.");
            }
        }

    }
}
