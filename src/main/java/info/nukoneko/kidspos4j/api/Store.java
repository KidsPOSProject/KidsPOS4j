package info.nukoneko.kidspos4j.api;

import info.nukoneko.kidspos4j.model.ModelStore;
import retrofit2.http.GET;
import rx.Observable;

import java.util.List;

/**
 * Created by TEJNEK on 2016/02/04.
 */
public interface Store {
    /***
     * お店の一覧を返す
     * @return
     */
    @GET("store/list")
    Observable<List<ModelStore>> getList();
}
