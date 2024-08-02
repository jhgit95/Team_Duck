package StudentInfo;

import Data.ScoreData;
import Data.StudentData;
import java.util.Scanner;
import java.util.Scanner;

public class Modify {
    private Scanner scanner = new Scanner(System.in);

    public void modifyStudentInfo() {
        System.out.println("\t=========================================");
        System.out.println("\t          Student Modification           ");
        System.out.println("\t=========================================");
        System.out.println("변경할 정보를 고르세요.");
        System.out.println("1. 학생 이름");
        System.out.println("2. ");
        System.out.print("엔터를 누르세요.");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                modifyName();
                break;
            case 2:
                ();
                break;
            default:
                System.out.println("잘못된 값입니다. 다시 시도하세요.");
                break;
        }
    }

    private void modifyName() {
        System.out.print("새로운 이름을 입력하세요: ");
        String newName = scanner.nextLine();
        studentData.setStudentName(newName);
        System.out.println("학생 이름이 '" + newName + "'(으)로 업데이트되었습니다.");
    }


    public void StudentInfoModify() {

    }

    public void ScoreInfoModify() {
        System.out.println("ㅇㅅㅇ");
    }
}

