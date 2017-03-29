package data.com.myapplication.sub_category.model.data;


public class SubCategoryDetails {

    private int sub_category_id;
    private String name;

    public SubCategoryDetails(int sub_category_id, String name) {
        this.sub_category_id = sub_category_id;
        this.name = name;
    }

    public int getId() {
        return sub_category_id;
    }

    public String getName() {
        return name;
    }
}
