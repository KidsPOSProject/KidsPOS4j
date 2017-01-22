package info.nukoneko.cuc.kidspos4j.model;

final public class StaffFactory {
    private static DataStaffImpl INSTANCE = new DataStaffImpl();
    public static DataStaffImpl getInstance(){
        return INSTANCE;
    }
}
