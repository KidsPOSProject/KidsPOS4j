package info.nukoneko.kidspos4j.api;

import info.nukoneko.kidspos4j.model.ModelItem;
import info.nukoneko.kidspos4j.model.ModelItemGenre;
import retrofit.http.GET;
import rx.Observable;

import java.util.List;

/**
 * Created by TEJNEK on 2016/02/04.
 */
public interface ItemGenre {
    @GET("item_genre/list")
    Observable<List<ModelItemGenre>> getList();
}
