package data.com.myapplication.sub_category.model;


import android.util.Log;


import java.util.concurrent.TimeUnit;

import data.com.myapplication.sub_category.OnSubCategoryGetRequest;
import data.com.myapplication.sub_category.api.SubCategoryRequestApi;
import data.com.myapplication.sub_category.model.data.SubCategoryData;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitSubCategoryDetailsProvider implements SubCategoryDetailsProvider {


    private String TAG="RetrofitSubCategory";


    @Override
    public void requestSubCategoryDetails(String access_token,final OnSubCategoryGetRequest onSubCategoryGetRequest) {


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(2,TimeUnit.MINUTES).readTimeout(2,TimeUnit.MINUTES).addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.119:8000/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        final SubCategoryRequestApi subCategoryRequestApi = retrofit.create(SubCategoryRequestApi.class);

        Call<SubCategoryData> subCategoryDataCall = subCategoryRequestApi.getSubCategoryData(access_token);

        subCategoryDataCall.enqueue(new Callback<SubCategoryData>() {
            @Override
            public void onResponse(Call<SubCategoryData> call, Response<SubCategoryData> response) {

                Log.i(TAG,"Response Received :"+response.body());
                onSubCategoryGetRequest.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SubCategoryData> call, Throwable t) {

                onSubCategoryGetRequest.onFailure();
                t.printStackTrace();
            }
        });

    }
}
