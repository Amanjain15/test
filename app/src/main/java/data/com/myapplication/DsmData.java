package data.com.myapplication;

import java.util.List;

/**
 * Created by aman on 5/3/17.
 */

public class DsmData {

    private String message;
    private boolean success;
    private List<DsmListDetails> dsmListDetailses;

    public DsmData(String message, boolean success, List<DsmListDetails> dsmListDetailses) {
        this.message = message;
        this.success = success;
        this.dsmListDetailses = dsmListDetailses;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<DsmListDetails> getDsmListDetailses() {
        return dsmListDetailses;
    }
}
