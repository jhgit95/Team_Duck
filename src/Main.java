import Manager.ScoreManager;
import Manager.StudentManager;
import Data.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import StudentInfo.*;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<StudentData> students = new ArrayList<>();
    private static ArrayList<int[]> subjects = new ArrayList<>();

    private static StudentManager studentManager = new StudentManager(students);
    private static ScoreManager scoreManager = new ScoreManager(students);



    public static void main(String[] args) {

        int choice; // 선택지 입력값 받는 변수
        String stop_keyword = ""; // 반복문 정지를 위한 변수

        do {

            // 메인 메뉴 제공 및 선택값 받기
            displayMenu_Main();
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                // 선택값에 대한 함수 실행 / 1. 학생 관리 / 2. 점수 관리 / 3. 종료 /
                switch(choice) {
                    case 1:
                        managementStudentInfo();
                        break;
                    case 2:
                        managementScoreInfo();
                        break;
                    case 3:
                        System.out.println("Terminate Management Program.");
                        stop_keyword = "exit";
                        break;
                    default:
                        System.out.println("Is not a valid choice.\nInput right choice again.\n");
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.nextLine(); // 잘못된 입력을 소비하여 무한 루프 방지
            }

        } while(!stop_keyword.equals("exit"));

    }



    // 수강생 정보 관리
    public static void managementStudentInfo() {

        int choice;
        String stop_keyword = "";

        do {
            // 학생 관린 메뉴 제공 및 선택값 받기
            displayMenu_StudentManagement();
            try {

                choice = scanner.nextInt();
                scanner.nextLine();

                // 선택값에 대한 함수 실행 / 1. 등록 / 2. 조회 / 3. 수정 / 4. 삭제 / 5. 메인으로 /
                switch(choice) {
                    case 1:
                        System.out.println("Please enter student data to add data");
                        studentManager.addData();
                        break;
                    case 2:
                        studentManager.inquiryData();
                        break;
                    case 3:
                        System.out.println("Please enter student ID to modify data");
                        studentManager.modifyData();
                        break;
                    case 4:
                        System.out.println("Please enter student ID to remove data");
                        studentManager.removeData();
                        break;
                    case 5:
                        stop_keyword = "exit";
                        break;
                    default:
                        System.out.println("Is not a valid choice.\nInput right choice again.\n");
                }

            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer choice");
                scanner.nextLine();
            }


        } while(!stop_keyword.equals("exit"));
    }



    // 점수 정보 관리
    public static void managementScoreInfo() {
        int choice;
        String stop_keyword = "";

        do {
            // 점수 관리 메뉴 제공 및 선택값 받기
            displayMenu_ScoreManagement();

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                // 선택값에 대한 함수 실행 / 1. 조회 / 2. 수정 / 3. 메인으로 /
                switch(choice) {
                    case 1:
                        System.out.println("Please enter student ID to add data");
                        scoreManager.addData();
                        break;
                    case 2:
                        scoreManager.inquiryData();
                        break;
                    case 3:
                        System.out.println("Please enter student ID to modify data");
                        scoreManager.modifyData();
                        break;
                    case 4:
                        stop_keyword = "exit";
                        break;
                    default:
                        System.out.println("Is not a valid choice.\nInput right choice again.\n");
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.nextLine(); // 잘못된 입력을 소비하여 무한 루프 방지
            }



        } while(!stop_keyword.equals("exit"));
    }

    // 메뉴판들 모아둔 곳

    public static void displayMenu_Main() {
        System.out.println("\t=================================================");
        System.out.println("\t=             NBC management system             =");
        System.out.println("\t=================================================");
        System.out.println("\t=            What do you want to do?            =");
        System.out.println("\t=-----------------------------------------------=");
        System.out.println("\t=                                               =");
        System.out.println("\t=           [1] Student Management              =");
        System.out.println("\t=           [2] Score Management                =");
        System.out.println("\t=           [3] Done                            =");
        System.out.println("\t=                                               =");
        System.out.println("\t=-----------------------------------------------=\n");
    }

    public static void displayMenu_StudentManagement() {
        System.out.println("\t=================================================");
        System.out.println("\t=        NBC management system  -  Student      =");
        System.out.println("\t=================================================");
        System.out.println("\t=            What do you want to do?            =");
        System.out.println("\t=-----------------------------------------------=");
        System.out.println("\t=                                               =");
        System.out.println("\t=           [1] Add Student Info                =");
        System.out.println("\t=           [2] Inquiry Student Info            =");
        System.out.println("\t=           [3] Modify Student Info             =");
        System.out.println("\t=           [4] Remove Student Info             =");
        System.out.println("\t=           [5] Back to Main                    =");
        System.out.println("\t=                                               =");
        System.out.println("\t=-----------------------------------------------=\n");
    }

    public static void displayMenu_ScoreManagement() {
        System.out.println("\t=================================================");
        System.out.println("\t=        NBC management system  -   Score       =");
        System.out.println("\t=================================================");
        System.out.println("\t=            What do you want to do?            =");
        System.out.println("\t=-----------------------------------------------=");
        System.out.println("\t=                                               =");
        System.out.println("\t=           [1] Add Score Info                  =");
        System.out.println("\t=           [2] Inquiry Score Info              =");
        System.out.println("\t=           [3] Modify Score Info               =");
        System.out.println("\t=           [4] Back to Main                    =");
        System.out.println("\t=                                               =");
        System.out.println("\t=-----------------------------------------------=\n");

    }
}