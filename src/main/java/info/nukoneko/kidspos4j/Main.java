package info.nukoneko.kidspos4j;


import info.nukoneko.kidspos4j.api.APIManager;
import info.nukoneko.kidspos4j.api.Sale;
import info.nukoneko.kidspos4j.model.ModelSale;
import rx.Observable;
import rx.Observer;

import java.util.List;

/**
 * Created by TEJNEK on 2016/02/03.
 */
public class Main {
    public static void main(String[] args) {
//        DataBase<ModelStore> model = StoreFactory.getInstance();

        Sale sale = APIManager.Sale();
        sale.getList()
                .flatMap(Observable::from)
                .filter(modelSale -> modelSale.getPrice() > 300)
                .subscribe(new Observer<ModelSale>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }

                    @Override
                    public void onNext(ModelSale modelSale) {
                        System.out.println(modelSale.getPrice());
                    }
                });
    }
}
