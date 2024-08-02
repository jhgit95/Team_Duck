package Manager;

import Data.ScoreData;
import Data.StudentData;
import StudentInfo.Inquiry;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager extends Manager {

    public List<StudentData> studentDataList;

    public ScoreManager(List<StudentData> inputStudentDataList) {
        // 초기화
        this.studentDataList = inputStudentDataList;
    }

    @Override
    public void addData() {
        System.out.println("\t*****************************************");
        System.out.println("\t             Score is added!             ");
        System.out.println("\t*****************************************\n");
    }

    @Override
    public void inquiryData(int student_ID) {

        StudentData studentData = this.studentDataList.get(student_ID);

        Inquiry scoreInquiry = new Inquiry(studentData);
        scoreInquiry.InquiryScoreInfo();

        System.out.println("\t*****************************************");
        System.out.println("\t             Score is inquired!          ");
        System.out.println("\t*****************************************\n");
    }

    @Override
    public void modifyData(int score_ID) {
        System.out.println("\t*****************************************");
        System.out.println("\t             Score is Modified!          ");
        System.out.println("\t*****************************************\n");
    }

}
