package Add;

import Data.StudentData;
import Data.SubjectData;
import StudentInfo.Inquiry;

import java.util.ArrayList;
import java.util.Scanner;




    public class StudentAdd {
        StudentData st;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        SubjectData subjectData = new SubjectData();

        public StudentAdd() {

        }

        //학생정보를 Add하는 메서드
        public StudentData addStudent() {
            System.out.println("이름을입력하세요");
            String Name = sc.nextLine();
            while (true) {
                System.out.println("상태를 입력하세요");
                int state = sc.nextInt();
                if (state >= 1 && state <= 3) {
                    st = new StudentData(number, Name, state);
                    number++;
                    break;
                } else {
                    System.out.println("잘못된 입력입니다 다시입력해주세요");
                }
            }
            return st;
        }

        public StudentData addSubject(StudentData studentData) {
            subjectData.inquirySubjectList();
            boolean flag = true;
            int subjectId = 0;
            int subjectType = 0;
            ArrayList<int[]> studentsubjectlist = studentData.getSubjectList();
            ArrayList<String[]> subjectInfoList = subjectData.getSubjectList();
            while (flag) {
                System.out.println("과목코드를 입력하세요");
                subjectId = sc.nextInt();
                for (int i = 0; i < subjectInfoList.size(); i++) {
                    if (subjectInfoList.get(i)[0].equals(subjectId + "")) {
                        flag = false;
                    } else {
                        System.out.println("잘못된 코드입니다 다시입력하세요");
                    }
                }
            }
            flag = true;
            while (flag) {
                System.out.println("과목타입을 입력하세요 0--필수 1--선택");
                subjectType = sc.nextInt();
                for (int i = 0; i < subjectInfoList.size(); i++) {
                    if (subjectInfoList.get(i)[0].equals(subjectId + "")) {
                        if (subjectInfoList.get(i)[2].equals(subjectType + "")) {
                            flag = false;
                        } else {
                            System.out.println("잘못된 타입입니다 다시입력하세요");
                        }
                    } else {

                    }
                }
            }

            System.out.println("입력하시려는 회차를 입력해주세요");
            int round = sc.nextInt();
            for (int i = 0; i < studentsubjectlist.size(); i++) {
                if (studentsubjectlist.get(i)[2] == round && studentsubjectlist.get(i)[0] == subjectId) {
                    throw new RuntimeException();
                } else {
                }
            }
            System.out.println("점수를 입력해주세요");
            int score = sc.nextInt();
            st = studentData;
            st.subjectDetailsInput(subjectId, subjectType, score, round);
            return st;
        }
    }






























