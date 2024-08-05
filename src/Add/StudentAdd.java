package Add;

import Data.StudentData;

import java.util.ArrayList;

public class StudentAdd {

    int studentId;
    int number =0;
    String studentName="";
    int state = 0; // state 값 추가. 정확히 어떤 정보인지 확인 필요.

    StudentData a = new StudentData(number,studentName,state);

    // StudentData 에서 가져옴. 과제 리스트 생성.
    ArrayList<int[]> subjectList = new ArrayList<>();
    int[] subjectDetails = new int[5];

    //필드에 scoreList 가 없어서 subjectList 랑 같은 형식으로 생성. 점수 리스트 생성.
    ArrayList<int[]> scoreList = new ArrayList<>();

    public StudentAdd(String studentName, ArrayList<int[]> subjectList, ArrayList<int[]> scoreList) {
    }


    //생성자.. 객체가 생성될 때, 적용될 내용 정리.
    public StudentData StudentAdd(String Name, int happy, int number){
        studentId = number;
        studentName = Name;
        state =happy;
        number++;
//        this.subjectList = subjectList; 과제, 점수 제거.
//        this.scoreList = scoreList;

//        return new StudentData(number,studentName,state);

    }

    //객체 생성.
    StudentAdd student1 = new StudentAdd(studentName, subjectList, scoreList);

    //리턴타입 StudentAdd = 메소드 호출 시, 객체 생성.
    public StudentAdd plus(String name){
        return new StudentAdd(name);
    }




    ArrayList<int> subjectList = a.getSubjectList();
    ArrayList<int> scoreList = a.getScoreList();




    // ArrrayList 가 <> 안에 String인지 확인 필요. 어차피 scoreList 삭제될 수도! 가볍게 무시하고 작업.

}
