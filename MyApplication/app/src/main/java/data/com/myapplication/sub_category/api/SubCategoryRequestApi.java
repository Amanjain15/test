package data.com.myapplication.sub_category.api;



import data.com.myapplication.sub_category.model.data.SubCategoryData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface SubCategoryRequestApi {

    @GET("192.168.1.1:8888")
    Call<SubCategoryData> getSubCategoryData(@Query("access_token") String access_token
            );


}
