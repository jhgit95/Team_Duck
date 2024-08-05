package Manager;

import Data.ScoreData;
import Data.StudentData;
import StudentInfo.Inquiry;
import StudentInfo.Modify;

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
    public void addData() {
        // 이름, 상태 입력받기
        System.out.print("Name : ");
        String name = scanner.next();

        System.out.print("Check a State  1. Grean 2.Yellow 3. Red");
        int state = scanner.nextInt();

        // Add addStudent = new Add
        //addStudentData(name, state);
        //
    }

    @Override
    public void inquiryData() {
        // 수강생 ID 값 입력받기
        System.out.println("Enter Student ID: ");
        int student_ID = scanner.nextInt();

        // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                Inquiry studentInquiry = new Inquiry();
                studentInquiry.InquiryStudentInfo(studentData);
            }
        }
    }


    @Override
    public void modifyData() {
        // 수강생 ID 값 입력받기
        System.out.println("Enter Student ID: ");
        int student_ID = scanner.nextInt();

        // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                // modify
                Modify modify = new Modify();
                studentData = modify.modifyStudentInfo(studentData);
            }
        }
    }


    public void removeData(int id) {
        // 수강생 ID 값 입력받기
        System.out.println("Enter Student ID: ");
        int student_ID = scanner.nextInt();

        // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                studentDataList.remove(studentData);
            }
        }
    }
}
