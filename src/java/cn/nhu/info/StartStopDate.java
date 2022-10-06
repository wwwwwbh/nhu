package cn.nhu.info;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StartStopDate implements Serializable {
    private String year;
    private String month;

    public StartStopDate() {
    }

    public StartStopDate(String year, String month) {
        this.year = year;
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getStartDate() {
        if (Integer.parseInt(this.month) < 10) {
            return this.year + "-0" + this.month + "-01";
        } else {
            return this.year + "-" + this.month + "-01";
        }
    }

    public String getStopDate() {
        int tempint = Integer.parseInt(this.month);
        if (tempint < 9) {
            //tempint:1,2,3,4,5,6,7,8,
            tempint++;
            return this.year + "-0" + tempint + "-01";
        } else if (tempint < 12) {
            //tempint:9,10,11
            tempint++;
            return this.year + "-" + tempint + "-01";
        } else {
            int tempyear = Integer.parseInt(this.year);
            tempyear++;
            return tempyear+"-01-01";
        }
    }

    /**
     * 获取当前月份第一天
     *
     * @return
     */
    public static String getMinMonthDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 获取下个月第一天
     *
     * @return
     */
    public static String getNextMonthMinDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month + 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }


}
