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
    Scanner scanner = new Scanner(System.in);

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
            // Add
        }
    }

    @Override
    public void inquiryData() {
        int student_ID = scanner.nextInt();
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                Inquiry studentInquiry = new Inquiry();
                studentInquiry.InquiryStudentInfo(studentData);
            }
        }
    }


    @Override
    public void modifyData() {
        int student_ID = scanner.nextInt();
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                // modify
            }
        }
    }


    public void removeData(int id) {
        int student_ID = scanner.nextInt();
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                studentDataList.remove(studentData);
            }
        }
    }
}
