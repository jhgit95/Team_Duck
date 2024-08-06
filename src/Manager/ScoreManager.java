package Manager;

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

    Scanner scanner = new Scanner(System.in);

    public ScoreManager(List<StudentData> inputStudentDataList) {
        this.studentDataList = inputStudentDataList;
    }

    @Override
    public void addData() {
        // 점수는 이미 학생 정보를 생성하며 그때 처리를 진행함..
    }

    @Override
    public void inquiryData() {
        // 수강생 ID 값 입력받기
        int student_ID = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter Student ID: ");
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
                Inquiry scoreInquiry = new Inquiry();
                scoreInquiry.inquirySubjecList(studentData);
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
                System.out.println("Enter Student ID: ");
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
                Modify modifyScore = new Modify();
                studentData = modifyScore.ModifyScoreInfo(studentData);
                studentDataList.set(i, studentData); // 리스트의 요소를 수정
            }
        }
    }
}
