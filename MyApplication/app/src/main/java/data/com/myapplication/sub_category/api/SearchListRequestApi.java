package data.com.myapplication.sub_category.api;



import data.com.myapplication.sub_category.model.data.ProductListData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface SearchListRequestApi {

    @GET("search")
    Call<ProductListData> getProductListData(@Query("query") String query, @Query("access_token") String access_token
            , @Query("type") int subCategoryId);

}
