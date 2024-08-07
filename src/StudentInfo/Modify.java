package StudentInfo;

import Data.StudentData;

import java.util.Scanner;
import java.util.ArrayList;

public class Modify {
    private Scanner scanner = new Scanner(System.in);

    public Modify() {

    }

    // 수강생 정보 수정
    public StudentData modifyStudentInfo(StudentData studentData) {
        boolean validInput = false;

        while (!validInput) {
            try {

                // 변경항목 선택
                System.out.println("변경할 항목을 선택하세요.");
                System.out.println("1. 학생 이름");
                System.out.println("2. 상태");
                int select = scanner.nextInt();
                scanner.nextLine();

                switch (select) {
                    case 1:
                        // 이름 수정
                        System.out.println("새로운 이름을 입력하세요.");
                        String newName = scanner.nextLine();
                        studentData.setStudentName(newName); // 이름 변경
                        validInput = true;
                        break;

                    case 2:
                        // 상태 수정
                        System.out.println("새로운 상태를 입력하세요.");
                        System.out.println("(1) : Green");
                        System.out.println("(2) : Yellow");
                        System.out.println("(3) : Red");
                        int newState = scanner.nextInt();
                        if (newState >= 1 && newState <= 3) {
                            studentData.setStudentState(newState); // 상태 변경
                            validInput = true;
                        } else {
                            System.out.println("잘못된 값입니다.");
                        }
                        break;
                    default:
                        System.out.println("잘못된 값입니다.");
                }
            } catch (Exception e) {
                System.out.println("유효한 입력이 아닙니다. 다시 시도하세요.");
                scanner.nextLine();
            }
        }
        // 수정 완료 메세지 출력
        return studentData;
    }

    // 수강생 과목별 회차 점수 수정
    public StudentData ModifyScoreInfo(StudentData studentData) {
        ArrayList<int[]> subjectList = studentData.getSubjectList();
        boolean validInput = false;

        while (!validInput) {
            try {

                // 사용자에게 수정할 과목의 ID를 입력받음
                System.out.print("수정할 과목의 ID를 입력하세요: ");
                int subjectId = scanner.nextInt();

                // 과목의 존재유무
                boolean subjectCheck = false;
                int subjectType = 2; // 초기값 2설정 (존재하지 않는 과목 설정)
                for (int[] subject : subjectList) {
                    if (subject[0] == subjectId) {
                        subjectCheck = true;
                        subjectType = subject[1];
                        break;
                    }
                }
                if (subjectCheck) {
                    if (subjectType == 0) {
                        System.out.println(subjectId + "는 필수 과목입니다.");
                    } else if (subjectType == 1) {
                        System.out.println(subjectId + "는 선택 과목입니다.");
                    } else {
                        System.out.println( subjectId + "의 과목 타입을 알 수 없습니다.");
                    }
                } else { // 과목이 존재하지 않을때
                    System.out.println(+ subjectId + "는 존재하지 않습니다.");
                    continue; // 다시 입력받도록함
                }

                // 수정할 회차 입력받기
                System.out.println("수정할 회차를 입력하세요.");
                int round = scanner.nextInt();

                if (round < 1 || round > 10) {
                    System.out.println("1에서 10 사이인 회차만 가능합니다.");
                    continue;
                }

                System.out.println("새로운 점수를 입력하세요.");
                int newScore = scanner.nextInt();

                // 유효한 점수인지(0~100사이) 확인
                if (newScore < 0 || newScore > 100) {
                    System.out.println("0에서 100사이의 점수만 가능합니다.");
                    continue;
                }

                // 과목 리스트에서 해당 과목의 점수 수정
                for (int[] subject : subjectList) {
                    if (subject[0] == subjectId && subject[3] == round) {
                        subject[2] = newScore;
                        System.out.println("과목ID : "  +subjectId + ", 해당회차 : " + round +
                                "의 점수 수정이" + newScore + " 로 완료되었습니다.");
                        validInput = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("유효한 입력이 아닙니다. 다시 시도하세요.");
                scanner.nextLine();
            }
        }
        // 수정된 subjectList를 studentData에 다시 설정
        studentData.setSubjectList((subjectList));
        return studentData;
    }
}