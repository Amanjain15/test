package data.com.myapplication.sub_category.view;

import java.util.List;

import data.com.myapplication.sub_category.model.data.ProductListDetails;

/**
 * Created by aman on 28/3/17.
 */

public interface ProductListView {

    void showMessage(String message);
    void showProgressbar(boolean show);
    void setProductData(List<ProductListDetails> productListDetails);
//    void loadData(String s);
}
