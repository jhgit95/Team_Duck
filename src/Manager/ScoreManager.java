package Manager;

import Data.ScoreData;
import Data.StudentData;
import StudentInfo.Inquiry;
//import StudentInfo.Modify;

import java.util.ArrayList;
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
        // 수강생 ID 값 입력받기
        System.out.println("Enter Student ID: ");
        int student_ID = scanner.nextInt();

        // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                // Add 호출

            }
        }

    }

    @Override
    public void inquiryData() {
        // 수강생 ID 값 입력받기
        System.out.println("Enter Student ID: ");
        int student_ID = scanner.nextInt();

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
        System.out.println("Enter Student ID: ");
        int student_ID = scanner.nextInt();

        // 입력받은 ID값에 해당하는 StudentData를 리스트에서 찾기
        for(StudentData studentData : studentDataList) {
            if(studentData.getStudentId() == student_ID) {
                // modify
                //Modify modifyScore = new Modify();
                //studentData = modifyScore.modifyScoreInfo(studentData);
            }
        }
    }
}
