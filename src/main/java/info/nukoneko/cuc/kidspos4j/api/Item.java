package info.nukoneko.cuc.kidspos4j.api;

import info.nukoneko.cuc.kidspos4j.model.ModelItem;
import retrofit2.http.*;
import rx.Observable;

import java.util.List;

public interface Item {
    /***
     * 商品一覧を取得する。使いみちはない
     * @return
     */
    @GET("item/list")
    Observable<List<ModelItem>> getList(@Query("limit") Integer limit);

    /***
     * 商品を取得する。無かったらnullを返す
     * @param barcode
     * @return
     */
    @GET("item/{barcode}")
    Observable<ModelItem> readItem(@Path("barcode") String barcode);

    /***
     * 商品のデータ更新する。
     * @param barcode
     * @param newPrice
     * @return
     */
    @FormUrlEncoded
    @POST("item/{barcode}/update")
    Observable<ModelItem> updateItem(@Path("barcode") String barcode,
                                      @Field("itemName") String name,
                                      @Field("storeId") int storeId,
                                      @Field("genreId") int genreId,
                                      @Field("price") int price);

    /***
     * 新しい商品を登録する
     * @param name 商品名
     * @param storeId お店ID
     * @param genreId 商品ジャンルID
     * @param price 値段
     * @return 新しい商品情報
     */
    @FormUrlEncoded
    @POST("item/create")
    Observable<ModelItem> createItem(@Field("itemName") String name,
                                     @Field("storeId") int storeId,
                                     @Field("genreId") int genreId,
                                     @Field("price") int price);
}
