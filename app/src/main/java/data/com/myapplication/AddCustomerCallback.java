package data.com.myapplication;

/**
 * Created by aman on 5/3/17.
 */

public interface AddCustomerCallback {
    void onSuccess(DsmData dsmData);
    void onFailure(String error);
}
