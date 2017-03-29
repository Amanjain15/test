package data.com.myapplication.sub_category.model;


import data.com.myapplication.sub_category.OnProductListGetRequest;

public interface ProductListDetailsProvider {

void requestProductList(String query, String access_token, int subCategoryId, OnProductListGetRequest onProductListGetRequest);

}
