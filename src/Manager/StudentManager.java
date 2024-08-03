package Manager;

public class StudentManager extends Manager {

    // private Add addStudent;
    // private Inquiry inquiryStudent
    // private Modify modifyStudent;
    public StudentManager() {

        // 초기화
    }

    @Override
    public void addData() {
        System.out.println("\t*****************************************");
        System.out.println("\t            Student is added!            ");
        System.out.println("\t*****************************************\n\n");
    }

    @Override
    public void inquiryData() {
        System.out.println("\t*****************************************");
        System.out.println("\t            Student is inquired!         ");
        System.out.println("\t*****************************************\n\n");
    }

    @Override
    public void modifyData() {
        System.out.println("\t*****************************************");
        System.out.println("\t            Student is Modified!         ");
        System.out.println("\t*****************************************\n\n");
    }
}
