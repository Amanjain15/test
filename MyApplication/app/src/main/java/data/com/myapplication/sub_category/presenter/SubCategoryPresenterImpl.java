package data.com.myapplication.sub_category.presenter;

import android.util.Log;

import data.com.myapplication.sub_category.OnSubCategoryGetRequest;
import data.com.myapplication.sub_category.model.SubCategoryDetailsProvider;
import data.com.myapplication.sub_category.model.data.SubCategoryData;
import data.com.myapplication.sub_category.view.SubCategoryView;

/**
 * Created by aman on 28/3/17.
 */

public class SubCategoryPresenterImpl implements  SubCategoryPresenter {


    private SubCategoryView subCategoryView;
    private SubCategoryDetailsProvider subCategoryDetailsProvider;

    public SubCategoryPresenterImpl(SubCategoryView subCategoryView
            , SubCategoryDetailsProvider subCategoryDetailsProvider) {
        this.subCategoryView = subCategoryView;
        this.subCategoryDetailsProvider = subCategoryDetailsProvider;
    }



    @Override
    public void requestSubCategoryDetails(String access_token) {

        subCategoryView.showProgressBar(true);
        Log.d("sub","4");
        subCategoryDetailsProvider.requestSubCategoryDetails(access_token, new OnSubCategoryGetRequest() {

            @Override
            public void onSuccess(SubCategoryData subCategoryData) {
                if(subCategoryData.isSuccess()) {

                    Log.d("sub","5");
                    subCategoryView.setTabs(subCategoryData);
                    Log.d("sub","8");

                }else{
                    subCategoryView.showMessage("Something went wrong ! Please try again later");
                    Log.d("sub","6");
                }
                subCategoryView.showProgressBar(false);
            }

            @Override
            public void onFailure() {
                subCategoryView.showMessage("Failed ");
            }
        });

    }
}
