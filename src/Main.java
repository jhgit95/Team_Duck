
import Data.ScoreData;
import Data.StudentData;
import Data.SubjectData;

import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        StudentData student1=new StudentData(1);
        student1.setScoreList(91,"R");
        System.out.println(student1.getScoreList());
        System.out.println(student1.getGradeList());


        int choice;
        String stop_keyword = "";

        do {

            // 메인 메뉴 제공 및 선택값 받기
            displayMenu_Main();
            choice = scanner.nextInt();

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
                    System.out.println("Is not a valid choice.\nInput right choice again.");
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
            choice = scanner.nextInt();

            // 선택값에 대한 함수 실행 / 1. 등록 / 2. 조회 / 3. 수정 / 4. 메인으로 /
            switch(choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    stop_keyword = "exit";
                    break;
                default:
                    System.out.println("Is not a valid choice.\nInput right choice again.");
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
            choice = scanner.nextInt();

            // 선택값에 대한 함수 실행 / 1. 등록 / 2. 조회 / 3. 수정 / 4. 메인으로 /
            switch(choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    stop_keyword = "exit";
                    break;
                default:
                    System.out.println("Is not a valid choice.\nInput right choice again.");
            }


        } while(!stop_keyword.equals("exit"));
    }








    // 메뉴판들 모아둔 곳

    public static void displayMenu_Main() {
        System.out.println("\t=========================================");
        System.out.println("\t=         NBC management system         =");
        System.out.println("\t=========================================");
        System.out.println("\t=        What do you want to do?        =");
        System.out.println("\t=---------------------------------------=");
        System.out.println("\t=                                       =");
        System.out.println("\t=         [1] Student Management        =");
        System.out.println("\t=         [2] Score Management          =");
        System.out.println("\t=         [3] Done                      =");
        System.out.println("\t=                                       =");
        System.out.println("\t=---------------------------------------=");
    }

    public static void displayMenu_StudentManagement() {
        System.out.println("\t=========================================");
        System.out.println("\t=    NBC management system  -  Student  =");
        System.out.println("\t=========================================");
        System.out.println("\t=        What do you want to do?        =");
        System.out.println("\t=---------------------------------------=");
        System.out.println("\t=                                       =");
        System.out.println("\t=         [1] Add Student Info          =");
        System.out.println("\t=         [2] Inquiry Student Info      =");
        System.out.println("\t=         [3] Modify Student Info       =");
        System.out.println("\t=         [4] Back to Main              =");
        System.out.println("\t=                                       =");
        System.out.println("\t=---------------------------------------=");
    }

   
}