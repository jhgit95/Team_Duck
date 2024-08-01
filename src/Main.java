
import Data.StudentData;
import StudentInfo.Inquiry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    public static void main(String[] args) {
        List<StudentData> students = new ArrayList();
        //studentData객체를 담는 students
        StudentData student = new StudentData(1);
        student.setScoreList(91, "R");
        student.addSubject("자바");
        student.setStudentName("이길환");
        students.add(student);

        Inquiry inquiry = new Inquiry((StudentData)students.get(0));
        inquiry.InquiryStudentInfo();
        inquiry.InquirySubjectInfo();
        inquiry.InquiryScoreInfo();

        student = new StudentData(2);
        student.setScoreList(75, "E");
        student.addSubject("Spring");
        student.setStudentName("김길환");
        students.add(student);
        inquiry = new Inquiry((StudentData)students.get(1));
        inquiry.InquiryStudentInfo();
        inquiry.InquirySubjectInfo();
        inquiry.InquiryScoreInfo();
    }
}
