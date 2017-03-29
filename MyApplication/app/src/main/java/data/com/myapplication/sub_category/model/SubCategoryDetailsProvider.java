package data.com.myapplication.sub_category.model;


import data.com.myapplication.sub_category.OnSubCategoryGetRequest;

public interface SubCategoryDetailsProvider {

    void requestSubCategoryDetails(String access_token,
                                   OnSubCategoryGetRequest onSubCategoryGetRequest);

}
