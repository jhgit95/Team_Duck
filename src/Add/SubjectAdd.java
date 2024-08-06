package Add;

import Data.SubjectData;


import java.util.ArrayList;

public class SubjectAdd {

    int subjectId;
    int subjectType;
    int score;
    int round;

    // 메서드 안에서 ArrayList<int[]> 도 초기화 해줘야하는지.. 확인 필요.
    // 과목 리스트(객체)를 담는 리스트.
    ArrayList<int[]> subjectList = new ArrayList<>();
    int[] subjectDetails = new int[4];
    // 과목 리스트 생성.
    //초기화 필수.

//    상태값을 문자로 바꿔주는 기능이 Add 에서 필요할 경우 추가. -Data 참고.
//    public String changeStateString(int subjectId){
//        return switch (subjectId) {
//            case '1' -> "Java";
//            case '2' -> "객체지향";
//            case '3' -> "Spring";
//            case '4' -> "JPA";
//            case '5' -> "MySQL";
//            case '6' -> "디자인 패턴";
//            case '7' -> "Spring Security";
//            case '8' -> "Redis";
//            case '9' -> "MongoDB";
//
//            default -> 0;
//        };

    // 과목 리스트, 과목 리스트를 담는 리스트를 생성하고  메서드...

    public ArrayList<int[]> SubjectAdd(int round, int subjectId, int subjectType,int score){

        subjectDetails = new int[4];
        this.subjectDetails[0] = round;
        this.subjectDetails[1] = subjectId;
        this.subjectDetails[2] = subjectType;
        this.subjectDetails[3] = score;

        subjectList.add(subjectDetails);
        return subjectList;
    }

    //중복으로 받을 경우 처리하는법.
    public void exists(){

        //반복문을 통해 예외처리. 중복일 경우 다시 입력.
        for(int i=0;i < 10; i++){
            if (subjectDetails[i] != subjectDetails[1]){
                boolean flag = true;
            }else{
                boolean flag =false;
            }

        }



    }

    // 회차별 과목으로 정리할 경우. 1st.subjectDetails[i] 뭐 이런식으로.???




}
