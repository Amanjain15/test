package data.com.myapplication.sub_category;


import data.com.myapplication.sub_category.model.data.ProductListData;

public interface OnProductListGetRequest {

    void onSuccess(ProductListData productListData);
    void onFailure();

}
