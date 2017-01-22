package info.nukoneko.cuc.kidspos4j.model;

final public class SaleFactory {
    private static DataSaleImpl INSTANCE = new DataSaleImpl();
    public static DataSaleImpl getInstance(){
        return INSTANCE;
    }
}
