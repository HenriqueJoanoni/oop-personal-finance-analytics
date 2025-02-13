package org.oop.finance.assets;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

    /**
     * Format dates to database input
     *
     * @param userDateInput string
     * @return java.sql.Date
     * @throws ParseException Exception
     */
    public Date formatDate(String userDateInput) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        java.util.Date utilDate = dateFormat.parse(userDateInput);
        java.sql.Date dateIncurred = new java.sql.Date(utilDate.getTime());

        return dateIncurred;
    }
}
