package StudentInfo;

import Data.StudentData;
import Data.SubjectData;

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
    public StudentData ModifyScoreInfo(StudentData studentData, SubjectData subjectData) {
        ArrayList<String[]> subjects = subjectData.getSubjectList();

        // 사용자에게 수정할 과목의 ID를 입력받음
        System.out.print("수정할 과목의 ID를 입력하세요: ");
        int subjectId = scanner.nextInt();

        // 과목이 존재하는지 확인
        boolean subjectExists = false;
        int subjectType = 2; // 초기값 2설정, 존재하지 않는 과목 타입으로 나타냄
        for (String[] subject : subjects) {
            if (Integer.parseInt(subject[0]) == subjectId) {
                subjectExists = true;
                subjectType = subject[2].equals("필수") ? 0 : 1;
                break;
            }
        }
        if (!subjectExists) {
            System.out.println("해당 과목이 존재하지 않습니다.");
            return studentData;
        }

        // 사용자에게 수정할 회차 입력받음
        System.out.println("수정할 회차를 입력하세요.");
        int round = scanner.nextInt();

        if (round < 1 || round > 10) {
            System.out.println("1에서 10 사이인 회차만 가능합니다.");
            return studentData;
        }

        System.out.println("새로운 점수를 입력하세요.");
        int newScore = scanner.nextInt();

        // 유효한 점수인지(0~100사이) 확인
        if (newScore < 0 || newScore > 100) {
            System.out.println("0에서 100사이의 점수만 가능합니다.");
            return studentData;
        }

        // 새로운 점수에 대한 등급 계산
//        char newGrade = studentData.changeScoreGrade(subjectType, newScore);

        // 과목 리스트에서 해당 과목의 점수 수정
        ArrayList<int[]> subjectList = studentData.();
            for(int[] subject : subjectList){
                for()
                if(subject[0] ==da )
            }
        //
        studentData.subjectDetailsInput(subjectId, subjectType, newScore, round);
        System.out.println("점수 수정 완료");
        return studentData;
    }
}