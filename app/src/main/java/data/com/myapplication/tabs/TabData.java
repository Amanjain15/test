package data.com.myapplication.tabs;

/**
 * Created by aman on 12/3/17.
 */

public class TabData {
    private String targetDaily="10";
    private String targetMonthly="30";

    public TabData(String targetDaily, String targetMonthly) {
        this.targetDaily = targetDaily;
        this.targetMonthly = targetMonthly;
    }

    public String getTargetDaily() {
        return targetDaily;
    }

    public String getTargetMonthly() {
        return targetMonthly;
    }
}
