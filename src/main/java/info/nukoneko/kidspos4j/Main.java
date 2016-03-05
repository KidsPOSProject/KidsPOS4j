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

        // 売上一覧を取得
        sale.getList().flatMap(new Func1<List<ModelSale>, Observable<ModelSale>>() {
            @Override
            public Observable<ModelSale> call(List<ModelSale> modelSales) {
                return Observable.from(modelSales);
            }
        }).subscribe(new Action1<ModelSale>() {
            @Override
            public void call(ModelSale sale) {
                System.out.print(JSONConvertor.toJSON(sale));
            }
        });

    }
}