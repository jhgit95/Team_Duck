package Manager;

import Add.StudentAdd;
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
        StudentAdd addStudent = new StudentAdd();
        addStudent.addStudent();
    }

    @Override
    public void inquiryData() {
        // 1. 아이디에 맞는 학생 조회 / 2. 전체 학생 조회(따로 빼둠) / 3. 리스트와 상태를 넘겨받아 특정 상태의 학생들 조회
        displayinquiryStudent();
        int choice = scanner.nextInt();
        boolean flag = false;
        Inquiry studentInquiry = new Inquiry();

        while(!flag) {
            switch(choice) {
                case 1 : { // 아이디에 맞는 학생 조회
                    // 수강생 ID 값 입력받기
                    int student_ID = 0;
                    boolean validInput = false;

                    while (!validInput) {
                        try {
                            System.out.print("Enter Student ID: ");
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
                            studentInquiry.inquiryStudentInfo(studentData);
                        }
                    }
                    flag = true;
                    break;
                }

                case 2 : { // 전체 학생 조회
                    studentInquiry.inquiryStudentsList(studentDataList);
                    flag = true;
                    break;
                }

                case 3 : { // 리스트와 상태를 넘겨받아 특정 상태의 학생들 조회
                    // 수강생 상태 값 입력받기
                    int student_State = 0;
                    boolean validInput = false;

                    while (!validInput) {
                        try {
                            System.out.println("Select Student State: 1. Green / 2. Yellow / 3. Red");
                            student_State = scanner.nextInt();
                            validInput = true; // 올바른 입력을 받았으므로 루프 종료
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for the Student State.");
                            System.out.println("If you want to continue, input anything.");
                            scanner.next(); // 잘못된 입력을 소비하여 무한 루프 방지
                        }
                    }
                    studentInquiry.inquiryByState(studentDataList, student_State);
                    flag = true;
                    break;
                }

                default : System.out.println("Invalid input. Please enter a valid integer."); break;

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
                System.out.print("Enter Student ID: ");
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
        int student_ID = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter Student ID: ");
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





    public void displayinquiryStudent() {
        System.out.println("\t=================================================");
        System.out.println("\t=               Student  -  Inquiry             =");
        System.out.println("\t=================================================");
        System.out.println("\t=                                               =");
        System.out.println("\t=         [1] Individual Student                =");
        System.out.println("\t=         [2] All Student                       =");
        System.out.println("\t=         [3] Specific State Students           =");
        System.out.println("\t=                                               =");
        System.out.println("\t=-----------------------------------------------=\n");
    }
}
