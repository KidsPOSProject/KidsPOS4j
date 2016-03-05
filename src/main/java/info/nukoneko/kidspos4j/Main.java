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

        Store store = APIManager.Store();
        store.getList()
                .flatMap(new Func1<List<ModelStore>, Observable<ModelStore>>() {
            @Override
            public Observable<ModelStore> call(List<ModelStore> modelStores) {
                return Observable.from(modelStores);
            }
        }).subscribe(new Action1<ModelStore>() {
            @Override
            public void call(ModelStore modelStore) {
                System.out.println(modelStore.getName());
            }
        });
    }
}