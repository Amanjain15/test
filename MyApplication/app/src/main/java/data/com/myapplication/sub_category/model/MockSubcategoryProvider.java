package data.com.myapplication.sub_category.model;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import data.com.myapplication.sub_category.OnSubCategoryGetRequest;
import data.com.myapplication.sub_category.model.data.SubCategoryData;
import data.com.myapplication.sub_category.model.data.SubCategoryDetails;

/**
 * Created by aman on 28/3/17.
 */

public class MockSubcategoryProvider implements SubCategoryDetailsProvider {
    @Override
    public void requestSubCategoryDetails(String access_token, final OnSubCategoryGetRequest onSubCategoryGetRequest) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onSubCategoryGetRequest.onSuccess(getMockSubcategoryData());
                Log.d("sub","7");

            }
        },500);
    }

    public SubCategoryData getMockSubcategoryData()
    {
        List<SubCategoryDetails> subCategoryDetailses = new ArrayList<>();

        for (int i=0; i<6;i++)
        {
            SubCategoryDetails subCategoryDetails = new SubCategoryDetails(i,"TAB"+i);
            subCategoryDetailses.add(subCategoryDetails);

        }

        SubCategoryData subCategoryData = new SubCategoryData("Success",true,subCategoryDetailses);
        return  subCategoryData;
    }


}
