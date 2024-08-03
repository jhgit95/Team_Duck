package StudentInfo;

import Data.ScoreData;
import Data.StudentData;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Modify {
    private Scanner scanner = new Scanner(System.in);
    private final ArrayList<StudentData> students; //StudentData 리스트
    private final ArrayList<ScoreData> scores; // ScoreData 리스트

    // 생성자 : 학생 리스트와 점수 리스트 초기화
    public Modify(ArrayList<StudentData> students, ArrayList<ScoreData> scores) {
        this.students = students;
        this.scores = scores;
    }

    // 수강생 정보 수정
    public void modifyStudentInfo() {
        // 사용자로부터 수정할 수강생 고유번호 입력받음
        System.out.println("수정할 수강생의 고유 번호를 입력하세요.");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        //수강생 고유번호로 수강생 찾기
        StudentData student = findStudentById(studentId);
        if (student == null) {
            // 수강생이 존재하지 않을 경우
            System.out.println("입력하신 고유번호를 가진 수강생이 존재하지 않습니다. ");
        }

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
                student.setStudentName(newName); // 이름 변경
                break;
            case 2:
                // 상태 수정
                System.out.println("새로운 상태를 입력하세요.");
                System.out.println("(1) : Green");
                System.out.println("(2) : Yellow");
                System.out.println("(3) : Red");
                int newState = scanner.nextInt();
                student.setStudentState(newState); // 상태 변경
                break;
            default:
                System.out.println("잘못된 값입니다. 다시 시도하세요.");
        }
        // 수정 완료 메세지 출력
        System.out.println("수강생 정보가 수정되었습니다.");
    }

    // 수강생 과목별 회차 점수 수정
    public void ModifyScoreInfo() {
        // 점수를 수정할 수강생의 고유번호 입력 받음
        System.out.println("점수를 수정할 수강생의 고유 번호를 입력하세요.");
        int StudentId = scanner.nextInt();
        scanner.nextLine();

        // 수강생의 고유 번호로 수강생 찾기
        StudentData student = findStudentById(StudentId);
        if (student == null) {
            System.out.println("입력하신 고유번호를 가진 수강생이 존재하지 않습니다. ");
            return;
        }

        // 수정할 과목Id와 수정할 회차
        System.out.println("수정할 과목 ID를 입력하세요.");
        int subjectId = scanner.nextInt();
        System.out.println("수정할 회차를 입력하세요.");
        int round = scanner.nextInt();

        // 점수 수정할 ScoreData 써치
        boolean found = false;
        for (ScoreData scoreData : scores) { //studentId 빨간줄 이유 해결x, 추후 질문 필요
            if (scoreData.getStudentId() == studentId && scoreData.getSubjectId() == subjectId && scoreData.getRound() == round) {
                System.out.println("새로운 점수를 입력하세요 :");
                int newScore = scanner.nextInt();

                // 점수 범위 확인(0~100)
                if (newScore < 0 || newScore > 100) {
                    System.out.println("입력한 점수 범위가 아닙니다. 점수는 0~100 사이만 가능합니다.");
                    return;
                }

                // 점수 수정
                scoreData.setsSore(newScore);
                // 점수에 따른 등급을 만들어야할것같은데 아직은 어려운 단계, 추후 피드백 필요(추가구현예정)
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
    private StudentData findStudentById(int studentId) {
        // 학생리스트 순회 -> 해당 Id 수강생 찾음
    for (StudentData student : students) {
        if (student.getStudentId() == studentId) {
            return student;
        }
    }
    return null;
    // 해당 학생이 없을경우
    }
}

