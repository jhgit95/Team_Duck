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

    }

    @Override
    public void inquiryData() {

    }

    @Override
    public void modifyData() {

    }

}
