package info.nukoneko.kidspos4j.api;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by TEJNEK on 2016/02/04.
 */

public interface Setting {
    @GET("update/check")
    Observable<Boolean> updateCheck();
}
