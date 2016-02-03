package info.nukoneko.kidspos4j.model;

/**
 * Created by atsumi on 2016/02/03.
 */
final public class StaffFactory {
    private static DataStaffImpl INSTANCE = new DataStaffImpl();
    public static DataBase<ModelStaff> getInstance(){
        return INSTANCE;
    }
}
