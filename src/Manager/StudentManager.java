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

    StudentAdd studentAdd = new StudentAdd();
    Inquiry studentInquiry = new Inquiry();
    Modify studentModify = new Modify();

    Scanner scanner = new Scanner(System.in);

    public StudentManager(List<StudentData> inputStudentDataList) {
        this.studentDataList = inputStudentDataList;
    }

    @Override
    public void addData() {
        StudentData studentData = studentAdd.addStudent();
        studentDataList.add(studentData);
    }

    @Override
    public void inquiryData() {
        // 1. 아이디에 맞는 학생 조회 / 2. 전체 학생 조회(따로 빼둠) / 3. 리스트와 상태를 넘겨받아 특정 상태의 학생들 조회
        displayinquiryStudent();
        int choice = scanner.nextInt();
        boolean flag = false;

        while(!flag) {
            switch(choice) {
                case 1 : { // 아이디에 맞는 학생 조회
                    studentInquiry.inquiryStudentsListShort(studentDataList);
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

                    int flag_ID = 0;
                    // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
                    for(StudentData studentData : studentDataList) {
                        if(studentData.getStudentId() == student_ID) {
                            studentInquiry.inquiryStudentInfo(studentData);
                            flag_ID = 1;
                        }
                    }
                    if(flag_ID == 0) {
                        System.out.println("Their is not exist the ID in Students!");
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
        studentInquiry.inquiryStudentsListShort(studentDataList);
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
        int flag_ID = 0;
        // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
        for(int i = 0; i < studentDataList.size(); i++) {
            StudentData studentData = studentDataList.get(i);
            if(studentData.getStudentId() == student_ID) {
                studentModify.modifyStudentInfo(studentData);
                flag_ID = 1;
                break;
            }
        }
        if(flag_ID == 0) {
            System.out.println("Their is not exist the ID in Students!");
        }
    }


    public void removeData() {
        studentInquiry.inquiryStudentsListShort(studentDataList);
        // 수강생 ID 값 입력받기
        int student_ID = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter Student ID: ");
                student_ID = scanner.nextInt();
                validInput = true; // 올바른 입력을 받았으므로 루프 종료
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the Student ID.");
                System.out.println("If you want to continue, input anything.");
                scanner.nextLine(); // 잘못된 입력을 소비하여 무한 루프 방지
            }
        }
        int flag_ID = 0;
        // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
        for(int i = 0; i < studentDataList.size(); i++) {
            StudentData studentData = studentDataList.get(i);
            if(studentData.getStudentId() == student_ID) {
                studentDataList.remove(i);
                flag_ID = 1;
                break;
            }

        }
        if(flag_ID == 0) {
            System.out.println("Their is not exist the ID in Students!");
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
