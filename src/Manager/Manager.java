package Manager;
import java.util.List;

public abstract class Manager {

    //protected List<String[]> dataList;

    abstract void addData();

    abstract void inquiryData();

    abstract void modifyData();

    /*
    // 데이터 리스트를 파일로 저장하는 메서드
    public void saveDataToFile(String fileName) {
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(fileName))) {
            for (String data : dataList) {
                writer.println(data);
            }
            System.out.println("Data saved to " + fileName);
        } catch (java.io.IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }*/
}
