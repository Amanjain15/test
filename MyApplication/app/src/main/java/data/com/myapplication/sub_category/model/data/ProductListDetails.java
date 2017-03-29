package data.com.myapplication.sub_category.model.data;


public class ProductListDetails {

    private String name;
    private String id,college,speciality;

    public ProductListDetails(String name, String id, String college, String speciality) {
        this.name = name;
        this.id = id;
        this.college = college;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCollege() {
        return college;
    }

    public String getSpeciality() {
        return speciality;
    }
}
