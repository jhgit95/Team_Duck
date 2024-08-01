package Manager;

public class ScoreManager extends Manager {
    
    public ScoreManager() {
        // 초기화
    }

    @Override
    public void addData() {
        System.out.println("\t*****************************************");
        System.out.println("\t             Score is added!             ");
        System.out.println("\t*****************************************\n\n");
    }

    @Override
    public void inquiryData() {
        System.out.println("\t*****************************************");
        System.out.println("\t             Score is inquired!          ");
        System.out.println("\t*****************************************\n\n");
    }

    @Override
    public void modifyData() {
        System.out.println("\t*****************************************");
        System.out.println("\t             Score is Modified!          ");
        System.out.println("\t*****************************************\n\n");
    }
}
