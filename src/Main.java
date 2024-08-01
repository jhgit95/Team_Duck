import Data.ScoreData;
import Data.StudentData;
import Data.SubjectData;

public class Main {
    public static void main(String[] args) {
        StudentData student1=new StudentData(1);
        student1.setScoreList(91,"R");
        System.out.println(student1.getScoreList());
        System.out.println(student1.getGradeList());

    }
}