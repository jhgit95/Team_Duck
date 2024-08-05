package Add;

import Data.StudentData;
import Data.SubjectData;
import java.util.ArrayList;

public class StudentAdd {

    int studentId;
    int number =0;
    String studentName="";


    StudentData a = new StudentData(number);


    ArrayList<String> subjectList = a.getSubjectList();
    ArrayList<String> scoreList = a.getScoreList();


    StudentAdd student1 = new StudentAdd(studentName);

    // ArrrayList 가 <> 안에 String인지 확인 필요. 어차피 scoreList 삭제될 수도! 가볍게 무시하고 작업.
    public void StudentAdd(String Name,ArrayList<int> subjectList,ArrayList<int> scoreList){
        studentId = number;
        studentName = Name;

        this.subjectList = subjectList;
        this.scoreList = scoreList;

        return new StudentData(number);
        number =number+1;



    }
}
