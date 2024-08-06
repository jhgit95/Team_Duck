/*package Manager;

import Data.ScoreData;
import Data.StudentData;
import

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    private String filePath = "src/Data/Data.json";

    public JsonParser(String filePath) {
        this.filePath = filePath;
    }

    // JSON 파일을 문자열로 읽어오는 메서드
    public String readFile(String filePath) throws IOException { // 꼭 IOException이 필요함..

        StringBuilder stringBuilder = new StringBuilder(); // 복수의 문자열을 합치기 위해 사용

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = bufferedReader.readLine()) != null) { // 문자열을 한줄씩 받아옴
                stringBuilder.append(line); // 받아온 문자열 추가
            }
        }

        return stringBuilder.toString();
    }

    // JSON 문자열을 파싱해서 Student 객체 리스트로 반환
    public ArrayList<StudentData> loadStudents() throws IOException {
        String jsonString = readFile(filePath);
        ArrayList<StudentData> students = new ArrayList<>();


        // 시작 지점의 여는 대괄호 '['와 끝 지점의 닫는 대괄호 ']'를 기점으로 문자열 나누기
        int startIndex = jsonString.indexOf("[");
        int endIndex = jsonString.indexOf("]");
        String studentsArray = jsonString.substring(startIndex + 1, endIndex);
        String[] entries = studentsArray.split("\\},\\{"); // 개인 학생으로 나누기


        // 학생 수 만큼 반복할 예정
        for (String entry: entries) {
            entry = entry.replace("{","").replace("}","").trim(); // 중괄호랑 공백 제거
            String[] keyValue = entry.split(":");

        }



        return null;
    }




    // JSON 문자열을 파싱하여 Score 객체 리스트를 반환하는 메서드
    public List<ScoreData> loadScores() throws IOException {
        String jsonString = readFile(filePath);
        List<ScoreData> scores = new ArrayList<>();

        // 파싱 시작
        int scoresStart = jsonString.indexOf("[", jsonString.indexOf("scores")) + 1;
        int scoresEnd = jsonString.indexOf("]", scoresStart);
        String scoresJson = jsonString.substring(scoresStart, scoresEnd).trim();

        // 점수 데이터를 분리
        String[] scoreEntries = scoresJson.split("\\},\\{");
        for (int i = 0; i < scoreEntries.length; i++) {
            String entry = scoreEntries[i].replaceAll("[\\[\\]{}]", "").trim();
            String[] fields = entry.split(",");
            ScoreData score = new ScoreData(0);
            for (String field : fields) {
                String[] keyValue = field.split(":");
                String key = keyValue[0].trim().replaceAll("\"", "");
                String value = keyValue[1].trim().replaceAll("\"", "");
                switch (key) {
                    case "StudentID":
                        score.setStudentId(Integer.parseInt(value));
                        break;
                    case "SubjectID":
                        score.setSubjectId(Integer.parseInt(value));
                        break;
                    case "Round":
                        score.setRound(Integer.parseInt(value));
                        break;
                    case "Score":
                        score.setsSore(Integer.parseInt(value));
                        break;
                    case "Grade":
                        score.setGrade(value.charAt(0));
                        break;
                }
            }
            scores.add(score);
        }
        return scores;
    }



    // 파일에 Student 및 Score 객체 리스트를 JSON으로 저장하는 메서드
    public void saveDataToFile(List<StudentData> students, List<ScoreData> scores) throws IOException {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        // Students JSON 배열 생성
        jsonBuilder.append("\"students\": [");
        for (int i = 0; i < students.size(); i++) {
            StudentData student = students.get(i);
            jsonBuilder.append("{")
                    .append("\"StudentID\": ").append(student.getStudentId()).append(", ")
                    .append("\"StudentName\": \"").append(student.getStudentName()).append("\", ")
                    //.append("\"State\": \"").append(student.getState()).append("\", ")
                    .append("\"SubjectList\": ").append(student.getSubjectList()).append("}");
            if (i < students.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("], ");

        // Scores JSON 배열 생성
        jsonBuilder.append("\"scores\": [");
        for (int i = 0; i < scores.size(); i++) {
            ScoreData score = scores.get(i);
            jsonBuilder.append("{")
                    .append("\"StudentID\": ").append(score.getStudentId()).append(", ")
                    .append("\"SubjectID\": ").append(score.getSubjectId()).append(", ")
                    .append("\"Round\": ").append(score.getRound()).append(", ")
                    .append("\"Score\": ").append(score.getsSore()).append(", ")
                    .append("\"Grade\": \"").append(score.getGrade()).append("\"}");
            if (i < scores.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("]");

        jsonBuilder.append("}");

        // JSON 문자열을 파일에 저장
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonBuilder.toString());
        }
    }


}
*/