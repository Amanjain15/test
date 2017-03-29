package data.com.myapplication;

import java.util.List;

/**
 * Created by aman on 5/3/17.
 */

public interface AddCustomerView {

    void showAdd();
    void showUpdate();
    void showProgressBar(boolean show);
    void showError(String error);
    //List-Spinners
    void showSpinners(DsmData dsmData);
    String showSpinnerDsm(List<DsmListDetails> dsmListDetails);
}
