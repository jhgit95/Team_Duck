package Manager;

import Data.StudentData;
import StudentInfo.Inquiry;

import java.util.ArrayList;
import java.util.List;

public class StudentManager extends Manager {

    // private Add addStudent;
    // private Inquiry inquiryStudent
    // private Modify modifyStudent

    public List<StudentData> studentDataList;

    public StudentManager(List<StudentData> inputStudentDataList) {
        this.studentDataList = inputStudentDataList;
    }

    @Override
    public void addData() {
        System.out.println("\t*****************************************");
        System.out.println("\t            Student is added!            ");
        System.out.println("\t*****************************************\n\n");
    }

    @Override
    public void inquiryData(int student_ID) {
        StudentData studentData = this.studentDataList.get(student_ID);

        Inquiry studentInquiry = new Inquiry(studentData);
        studentInquiry.InquiryStudentInfo();

        System.out.println("\t*****************************************");
        System.out.println("\t            Student is inquired!         ");
        System.out.println("\t*****************************************\n\n");
    }


    @Override
    public void modifyData(int student_ID) {
        System.out.println("\t*****************************************");
        System.out.println("\t            Student is Modified!         ");
        System.out.println("\t*****************************************\n\n");
    }
}
