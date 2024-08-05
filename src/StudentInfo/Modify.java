/*package StudentInfo;

import Data.StudentData;
import java.util.Scanner;
import java.util.ArrayList;

public class Modify {
    private Scanner scanner = new Scanner(System.in);

    public Modify() {

    }

    // 수강생 정보 수정
    public StudentData modifyStudentInfo(StudentData studentData) {

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
                break;

            case 2:
                // 상태 수정
                System.out.println("새로운 상태를 입력하세요.");
                System.out.println("(1) : Green");
                System.out.println("(2) : Yellow");
                System.out.println("(3) : Red");
                int newState = scanner.nextInt();
                studentData.setStudentState(newState); // 상태 변경
                break;
            default:
                System.out.println("잘못된 값입니다. 다시 시도하세요.");
        }
        // 수정 완료 메세지 출력
        return studentData;
    }

    // 수강생 과목별 회차 점수 수정
    public void ModifyScoreInfo(StudentData studentData) {

        // 수정할 과목Id와 수정할 회차
        System.out.println("수정할 과목 ID를 입력하세요.");
        int subjectId = scanner.nextInt();
        System.out.println("수정할 회차를 입력하세요.");
        int round = scanner.nextInt();

        // 점수 수정할 ScoreData 써치
        boolean found = false;
        for (StudentData studentdata : students) {
            if (studentdata.getStudentId() == studentId && studentdata.getSubjectId() == subjectId
                    && studentdata.getRound() == round) {
                found = true; // 일치하는 객체가 있음을 표시
                System.out.println("새로운 점수를 입력하세요 :");
                int newScore = scanner.nextInt();


                // 점수 범위 확인(0~100)
                if (newScore < 0 || newScore > 100) {
                    System.out.println("입력한 점수 범위가 아닙니다. 점수는 0~100 사이만 가능합니다.");
                    return;
                }

                // 점수 수정
                // 점수가 제대로 설정되었는지 확인(넣어도 되고 안넣어도됨 선택적 사항)
                int upgradeScore = scoreData.getScore();

                studentdata.setScore(newScore);
                // 점수에 따른 등급을 만들어야할것같은데 월요일날 상의
                // 점수에 따른 등급 호출↓↓
                scoreData.setGrade();
                break;
            }
        }
        if (!found) {
            System.out.println("과목 ID와 회차를 가진 점수가 없습니다.");
            return;
        }
        System.out.println("점수 수정 완료");
    }
    // 점수에 따른 등급 계산 메서드 선언 (구현필요)
    private 타입 ...{

    }

    // 고유번호로 수강생 찾기

    // 해당 학생이 없을경우
}
}*/