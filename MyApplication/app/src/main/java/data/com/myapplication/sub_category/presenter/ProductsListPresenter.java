package data.com.myapplication.sub_category.presenter;

/**
 * Created by aman on 28/3/17.
 */

public interface ProductsListPresenter {

    void requestProductList(String query,String access_token, int subCategoryId);
}
