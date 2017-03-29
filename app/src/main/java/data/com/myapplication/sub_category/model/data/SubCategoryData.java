package data.com.myapplication.sub_category.model.data;

import java.util.List;


public class SubCategoryData {
    private String message;
    private boolean success;
    private List<SubCategoryDetails> sub_category_list;

    public SubCategoryData(String message, boolean success, List<SubCategoryDetails> sub_category_list) {
        this.message = message;
        this.success = success;
        this.sub_category_list = sub_category_list;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<SubCategoryDetails> getSub_category_list() {
        return sub_category_list;
    }
}
