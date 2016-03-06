package info.nukoneko.kidspos4j;


import info.nukoneko.kidspos4j.api.*;
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
        // ok Sale API
        // ok Staff API

//        Sale sale = APIManager.Sale();
//        ModelSale sale1 = sale.createSale(3555, 5, 1000, "3,3,3,3,3", 999, 999)
//                .onErrorReturn(new Func1<Throwable, ModelSale>() {
//                    @Override
//                    public ModelSale call(Throwable throwable) {
//                        return null;
//                    }
//                })
//                .toBlocking().first();
//        System.out.println(sale1);
    }
}