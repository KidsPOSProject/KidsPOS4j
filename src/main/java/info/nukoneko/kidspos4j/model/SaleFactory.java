package info.nukoneko.kidspos4j.model;

/**
 * Created by atsumi on 2016/02/03.
 */
final public class SaleFactory {
    private static DataSaleImpl INSTANCE = new DataSaleImpl();
    public static DataBase<ModelSale> getInstance(){
        return INSTANCE;
    }
}
