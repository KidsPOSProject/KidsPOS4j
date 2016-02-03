package info.nukoneko.kidspos4j.api;

import retrofit.http.GET;

/**
 * Created by TEJNEK on 2016/02/04.
 */

public interface Setting {
    @GET("setting")
    public void getSetting();
}
