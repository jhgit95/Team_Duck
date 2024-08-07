package Manager;

import Add.StudentAdd;
import Data.ScoreData;
import Data.StudentData;
import StudentInfo.Inquiry;
import StudentInfo.Modify;
//import StudentInfo.Modify;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ScoreManager extends Manager {

    public List<StudentData> studentDataList;
    public ArrayList<int[]> subjectDataList;

    StudentAdd scoreAdd = new StudentAdd();
    Inquiry scoreInquiry = new Inquiry();
    Modify scoreModify = new Modify();

    Scanner scanner = new Scanner(System.in);

    public ScoreManager(List<StudentData> inputStudentDataList) {
        this.studentDataList = inputStudentDataList;
    }

    @Override
    public void addData() {
        scoreInquiry.inquiryStudentsListShort(studentDataList);
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
        for(int i = 0; i < studentDataList.size(); i++) {
            StudentData studentData = studentDataList.get(i);
            if(studentData.getStudentId() == student_ID) {
                studentData = scoreAdd.addSubject(studentData);
                studentDataList.set(i, studentData); // 리스트의 요소를 수정
            }
        }

    }

    @Override
    public void inquiryData() {
        // 1. 특정학생의 수강과목점수조회,  2. 특정 과목의 회차별 점수 조회
        // 3. 특정과목의 id를 받으면 그 과목의 평균등급 조회, 4. 학생들중 특정상태의 필수과목의 평균등급을 조회

        displayinquiryScore();
        int choice = scanner.nextInt();
        boolean flag = false;

        while (!flag) {
            switch(choice) {
                case 1 : { // 특정학생의 수강 과목 점수 조회
                    scoreInquiry.inquiryStudentsListShort(studentDataList);
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
                            scoreInquiry.inquirySubjecList(studentData);
                        }
                    }
                    flag = true;
                    break;
                }

                case 2 : { // 특정 과목의 회차별 점수 조회
                    scoreInquiry.inquiryStudentsListShort(studentDataList);
                    // 수강생 ID 값 입력받기
                    int student_ID = 0;
                    int subject_ID = 0;
                    boolean validInput = false;

                    while (!validInput) {
                        try {
                            System.out.print("Enter Student ID: ");
                            student_ID = scanner.nextInt();
                            System.out.print("Enter Subject ID: ");
                            subject_ID = scanner.nextInt();
                            validInput = true; // 올바른 입력을 받았으므로 루프 종료
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for the Student ID or Subject ID.");
                            System.out.println("If you want to continue, input anything.");
                            scanner.next(); // 잘못된 입력을 소비하여 무한 루프 방지
                        }
                    }

                    // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
                    for(StudentData studentData : studentDataList) {
                        if(studentData.getStudentId() == student_ID) {
                            scoreInquiry.inquirySubjectByRound(studentData, subject_ID);
                        }
                    }
                    flag = true;
                    break;
                }

                case 3 : { // 특정과목의 id를 받으면 그 과목의 평균등급 조회
                    scoreInquiry.inquiryStudentsListShort(studentDataList);
                    // 수강생 ID 값 입력받기
                    int student_ID = 0;
                    int subject_ID = 0;
                    boolean validInput = false;

                    while (!validInput) {
                        try {
                            System.out.print("Enter Student ID: ");
                            student_ID = scanner.nextInt();
                            System.out.print("Enter Subject ID: ");
                            subject_ID = scanner.nextInt();
                            validInput = true; // 올바른 입력을 받았으므로 루프 종료
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for the Student ID or Subject ID.");
                            System.out.println("If you want to continue, input anything.");
                            scanner.next(); // 잘못된 입력을 소비하여 무한 루프 방지
                        }
                    }

                    // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
                    for(StudentData studentData : studentDataList) {
                        if(studentData.getStudentId() == student_ID) {
                            scoreInquiry.inquirySpecificAvgGrade(studentData, subject_ID);
                        }
                    }
                    flag = true;
                    break;
                }

                case 4 : {
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

                    scoreInquiry.inquiryByStateAndRequireSubjectAvgGrade(studentDataList, student_State);
                    flag = true;
                    break;
                }

                default: System.out.println("Invalid input. Please enter a valid integer."); break;
            }
        }

    }

    @Override
    public void modifyData() {
        scoreInquiry.inquiryStudentsListShort(studentDataList);
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
        for(int i = 0; i < studentDataList.size(); i++) {
            StudentData studentData = studentDataList.get(i);
            if(studentData.getStudentId() == student_ID) {
                studentData = scoreModify.ModifyScoreInfo(studentData);
                studentDataList.set(i, studentData); // 리스트의 요소를 수정
            }
        }
    }



    public void displayinquiryScore() {
        // 3. 특정과목의 id를 받으면 그 과목의 평균등급 조회, 4. 학생들중 특정상태의 필수과목의 평균등급을 조회
        System.out.println("\t=================================================");
        System.out.println("\t=                 Score  -  Inquiry             =");
        System.out.println("\t=================================================");
        System.out.println("\t=                                               =");
        System.out.println("\t=         [1] Subjects Score of the student     =");
        System.out.println("\t=         [2] Score by Round of the Subject     =");
        System.out.println("\t=         [3] Average Grade of the subject      =");
        System.out.println("\t=         [4] Mandatory Subject's Average       =");
        System.out.println("\t=             Grade of Specific State Student   =");
        System.out.println("\t=                                               =");
        System.out.println("\t=-----------------------------------------------=\n");
    }
}
