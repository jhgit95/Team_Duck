package Manager;

import Data.ScoreData;
import Data.StudentData;
import StudentInfo.Inquiry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager extends Manager {

    // private Add addStudent;
    // private Inquiry inquiryStudent
    // private Modify modifyStudent

    public List<StudentData> studentDataList;

    public StudentManager(List<StudentData> inputStudentDataList) {
        this.studentDataList = inputStudentDataList;
    }

    @Override
    public void addData() { // 이름, 상태, 과목 종류
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name : ");
        String name = scanner.next();

        System.out.print("State : ");
        String state = scanner.next();

        System.out.println("* Enter subject at least 5");
        System.out.print("Subjects: ");
        String subjects = scanner.next();
        String[] subjectList = subjects.split(",| |/");

        if(subjectList.length < 5) {
            System.out.println("Not enough subjects");
        } else {
            // 저장 메서드 호출..

            System.out.println("\t*****************************************");
            System.out.println("\t            Student is added!            ");
            System.out.println("\t*****************************************\n\n");
        }
    }

    @Override
    public void inquiryData(int student_ID) {
        StudentData studentData = this.studentDataList.get(student_ID);

        Inquiry studentInquiry = new Inquiry(studentData);
        studentInquiry.InquiryStudentInfo();

        System.out.println("\t*****************************************");
        System.out.println("\t            Student is inquired!         ");
        System.out.println("\t*****************************************\n\n");
    }


    @Override
    public void modifyData(int student_ID) {
        System.out.println("\t*****************************************");
        System.out.println("\t            Student is Modified!         ");
        System.out.println("\t*****************************************\n\n");
    }


    public void removeData(int id) {
        StudentData studentData = this.studentDataList.get(id);
        this.studentDataList.remove(id);


        System.out.println("\t*****************************************");
        System.out.println("\t            Student is Removed!          ");
        System.out.println("\t*****************************************\n\n");

    }
}
