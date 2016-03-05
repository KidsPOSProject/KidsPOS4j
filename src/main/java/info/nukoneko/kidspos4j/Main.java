package info.nukoneko.kidspos4j;


import info.nukoneko.kidspos4j.api.APIManager;
import info.nukoneko.kidspos4j.api.Item;
import info.nukoneko.kidspos4j.api.ItemGenre;
import info.nukoneko.kidspos4j.api.Sale;
import info.nukoneko.kidspos4j.model.*;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.List;

/**
 * Created by TEJNEK on 2016/02/03.
 */
public class Main {
    public static void main(String[] args) {
        // ok Item API
        // ok ItemGenre API

        // 売上API
        Sale sale = APIManager.Sale();
        ModelSale sale2 =
                sale.createSale(3, 1200, "1,2,3", 1, 123456789).toBlocking().first();
        System.out.println(JSONConvertor.toJSON(sale2));



//        sale.createSale(sakeJson)
//        sale.updateSale(newSaleJson)
    }
}