package info.nukoneko.kidspos4j;


import info.nukoneko.kidspos4j.api.APIManager;
import info.nukoneko.kidspos4j.model.ModelItem;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

import java.util.List;

/**
 * Created by TEJNEK on 2016/02/03.
 */
public class Main {
    public static void main(String[] args) {
        APIManager.Item().getList()
                .flatMap(new Func1<List<ModelItem>, Observable<ModelItem>>() {
                    @Override
                    public Observable<ModelItem> call(List<ModelItem> modelItems) {
                        return Observable.from(modelItems);
                    }
                })
                .subscribe(new Observer<ModelItem>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }

                    @Override
                    public void onNext(ModelItem modelItem) {
                        System.out.println(modelItem.getBarcode());
                    }
                });
    }
}
