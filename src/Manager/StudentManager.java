package Manager;

import Data.StudentData;
import StudentInfo.Inquiry;
import StudentInfo.Modify;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentManager extends Manager {

    public List<StudentData> studentDataList;
    public ArrayList<int[]> subjectDataList;

    Scanner scanner = new Scanner(System.in);

    public StudentManager(List<StudentData> inputStudentDataList) {
        this.studentDataList = inputStudentDataList;
    }

    @Override
    public void addData() {
        // 이름, 상태 입력받기
        String name = "";
        int state = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Name : ");
                name = scanner.next();
                System.out.print("Check a State  1. Green / 2. Yellow / 3. Red");
                state = scanner.nextInt();
                if (state < 1 || state > 3) {
                    System.out.println("Invalid state. Please enter between 1, 2, 3.");
                } else {
                    validInput = true; // 올바른 입력을 받았으므로 루프 종료
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the State.");
                System.out.println("If you want to continue, input anything.");
                scanner.next(); // 잘못된 입력을 소비하여 무한 루프 방지
            }
        }

        // Add addStudent = new Add
        // addStudent.addData(name, state);
        //
    }

    @Override
    public void inquiryData() {
        // 수강생 ID 값 입력받기
        int student_ID = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter Student ID: ");
                student_ID = scanner.nextInt();
                validInput = true; // 올바른 입력을 받았으므로 루프 종료
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the Student ID.");
                System.out.println("If you want to continue, input anything.");
                scanner.next(); // 잘못된 입력을 소비하여 무한 루프 방지
            }
        }

        // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                Inquiry studentInquiry = new Inquiry();
                studentInquiry.inquiryStudentInfo(studentData);
            }
        }
    }


    @Override
    public void modifyData() {
        // 수강생 ID 값 입력받기
        int student_ID = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter Student ID: ");
                student_ID = scanner.nextInt();
                validInput = true; // 올바른 입력을 받았으므로 루프 종료
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the Student ID.");
                System.out.println("If you want to continue, input anything.");
                scanner.next(); // 잘못된 입력을 소비하여 무한 루프 방지
            }
        }

        // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                Modify studentModify = new Modify();
                studentModify.modifyStudentInfo(studentData);
            }
        }
    }


    public void removeData() {
        // 수강생 ID 값 입력받기
        System.out.println("Enter Student ID: ");
        int student_ID = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter Student ID: ");
                student_ID = scanner.nextInt();
                validInput = true; // 올바른 입력을 받았으므로 루프 종료
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the Student ID.");
                System.out.println("If you want to continue, input anything.");
                scanner.next(); // 잘못된 입력을 소비하여 무한 루프 방지
            }
        }

        // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                studentDataList.remove(studentData);
            }
        }
    }
}
