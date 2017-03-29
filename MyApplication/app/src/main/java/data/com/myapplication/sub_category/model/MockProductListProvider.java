package data.com.myapplication.sub_category.model;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import data.com.myapplication.sub_category.OnProductListGetRequest;
import data.com.myapplication.sub_category.model.data.ProductListData;
import data.com.myapplication.sub_category.model.data.ProductListDetails;

/**
 * Created by aman on 28/3/17.
 */

public class MockProductListProvider implements ProductListDetailsProvider{


    @Override
    public void requestProductList(String query, String access_token, int subCategoryId,
                                   final OnProductListGetRequest onProductListGetRequest) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onProductListGetRequest.onSuccess(getMockProductListData());


            }
        },500);
    }

    private ProductListData getMockProductListData(){

        List<ProductListDetails> productListDetailsList=new ArrayList<>();

        for(int i=0 ;i<20;i++){

            ProductListDetails productListDetails=new ProductListDetails
                    ("Product"+i,i+"",
                            "abc","Raipur","https://www.grocely.com/image/data/products/331930.jpg","gmail.com");

            productListDetailsList.add(productListDetails);
        }
        ProductListData productListData=new ProductListData(true,"Success",productListDetailsList);

        return productListData;

    }

}
