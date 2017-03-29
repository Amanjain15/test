package data.com.myapplication.sub_category;


import data.com.myapplication.sub_category.model.data.SubCategoryData;

public interface OnSubCategoryGetRequest {

    void onSuccess(SubCategoryData subCategoryData);
    void onFailure();

}
