package info.nukoneko.cuc.kidspos4j.api;

import info.nukoneko.cuc.kidspos4j.model.ModelStore;
import retrofit2.http.GET;
import rx.Observable;

import java.util.List;

public interface Store {
    /***
     * お店の一覧を返す
     * @return
     */
    @GET("store/list")
    Observable<List<ModelStore>> getList();
}
