package pl.agatarachanska.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class DataName {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd-MM-yyyy");

    private Date date;

    public DataName(){
        setDate(new Date());
    }

    public String createDayName(ResourceBundle resourceBundle) {
        String name = new SimpleDateFormat("EEE", Locale.ENGLISH).format(date);
        return setDayNames(name, resourceBundle);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }


    private String setDayNames(String day, ResourceBundle resourceBundle) {

        switch (day) {
            case "Mon":
                return resourceBundle.getString("poniedzialek") + " " + FORMATTER.format(date);
            case "Tue":
                return resourceBundle.getString("wtorek") + " " + FORMATTER.format(date);
            case "Wed":
                return resourceBundle.getString("sroda") + " " + FORMATTER.format(date);
            case "Thu":
                return resourceBundle.getString("czwartek") + " " + FORMATTER.format(date);
            case "Fri":
                return resourceBundle.getString("piatek") + " " + FORMATTER.format(date);
            case "Sat":
                return resourceBundle.getString("sobota") + " " + FORMATTER.format(date);
            case "Sun":
                return resourceBundle.getString("niedziela") + " " + FORMATTER.format(date);
        }
        return "brak";
    }

}
