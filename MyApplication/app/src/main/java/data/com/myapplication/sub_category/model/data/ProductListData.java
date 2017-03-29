package data.com.myapplication.sub_category.model.data;

import java.util.List;


public class    ProductListData {

    private boolean success;
    private String message;
    private List<ProductListDetails> product_list;

    public ProductListData(boolean success, String  message, List<ProductListDetails> product_list) {
        this.success = success;
        this.message = message;
        this.product_list = product_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<ProductListDetails> getProduct_list() {
        return product_list;
    }
}
