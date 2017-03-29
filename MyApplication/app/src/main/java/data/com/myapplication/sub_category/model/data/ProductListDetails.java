package data.com.myapplication.sub_category.model.data;


public class ProductListDetails {

    private String name;
    private String id;
    private String unit;
    private String place;
    private String image;
    private String email;

    public ProductListDetails(String name, String id, String unit, String place, String image, String email) {
        this.name = name;
        this.id = id;
        this.unit = unit;
        this.place = place;
        this.image = image;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public String getPlace() {
        return place;
    }

    public String getImage() {
        return image;
    }

    public String getEmail() {
        return email;
    }
}
