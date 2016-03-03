package info.nukoneko.kidspos4j.api;

import info.nukoneko.kidspos4j.model.ModelSale;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

import java.util.List;

/**
 * Created by TEJNEK on 2016/02/04.
 */
public interface Sale {
    /***
     * 売上の一覧を取得する
     * @return
     */
    @GET("sale/list")
    Observable<List<ModelSale>> getList();

    /***
     * 一つだけの売上の情報を取得する。無い時はnull
     * @param barcode
     * @return
     */
    @GET("sale")
    Observable<ModelSale> getSale(@Query("barcode") String barcode);

    /***
     * 重要!! 売上が送信されてきたので受け取る
     * サーバーではレシート印刷もするよ (予定)
     * @param saleJson
     * @return
     */
    @POST("sale")
    Observable<ModelSale> createSale(@Field("sale") String saleJson);

    /***
     * 売上情報を更新する
     * @param newSaleJson
     * @return
     */
    @POST("sale/update")
    Observable<ModelSale> updateSale(
            @Field("newSale") String newSaleJson);
}
