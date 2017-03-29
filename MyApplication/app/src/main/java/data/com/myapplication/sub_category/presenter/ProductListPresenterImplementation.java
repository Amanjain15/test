package data.com.myapplication.sub_category.presenter;

import android.util.Log;

import data.com.myapplication.sub_category.OnProductListGetRequest;
import data.com.myapplication.sub_category.model.ProductListDetailsProvider;
import data.com.myapplication.sub_category.model.data.ProductListData;
import data.com.myapplication.sub_category.view.ProductListView;
import data.com.myapplication.sub_category.view.SubCategoryView;

/**
 * Created by aman on 28/3/17.
 */

public class ProductListPresenterImplementation implements ProductsListPresenter {

    private static final String TAG = "ProductListPresenter";
    private ProductListDetailsProvider productListDetailsProvider;
    private ProductListView productListView;
    private SubCategoryView subCategoryView;

    public ProductListPresenterImplementation(ProductListView productListView,
                                              ProductListDetailsProvider productListDetailsProvider) {
        this.productListDetailsProvider = productListDetailsProvider;
        this.productListView = productListView;
    }

    @Override
    public void requestProductList(String query, String access_token, int subCategoryId) {

        productListView.showProgressbar(true);
        productListDetailsProvider.requestProductList(query, access_token, subCategoryId, new OnProductListGetRequest() {
            @Override
            public void onSuccess(ProductListData productListData) {
                if (productListData.isSuccess()) {

                    Log.i(TAG, "List Received : Size :" + productListData.getProduct_list().size());
                    productListView.setProductData(productListData.getProduct_list());
                    productListView.showProgressbar(false);
                } else {
                    productListView.showMessage(productListData.getMessage());
                    productListView.showProgressbar(false);
                }

            }

            @Override
            public void onFailure() {
                productListView.showProgressbar(false);
                productListView.showMessage("No Internet");

            }
        });


    }
}
