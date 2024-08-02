package Add;

import Data.StudentData;

import java.util.ArrayList;

public class Student {

    int studentId;
    int number =0;
    String studentName="";


    StudentData a = new StudentData(number);


    ArrayList<String> subjectList = a.getSubjectList();
    ArrayList<String> scoreList = a.getScoreList();


    Student student1 = new Student(studentName);

    public void StudentAdd(String Name,ArrayList<String> subjectList,ArrayList<String> scoreList){
        studentId = number;
        studentName = Name;

        this.subjectList = subjectList;
        this.scoreList = scoreList;

        return new StudentData(number);
        number =number+1;



    }
}
