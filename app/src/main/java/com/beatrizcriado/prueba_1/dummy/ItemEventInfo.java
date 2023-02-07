package com.beatrizcriado.prueba_1.dummy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ItemEventInfo {
    String title;
    String place;
    Calendar calendar = new GregorianCalendar();


    public void setTime(int hourOfDay, int minute) {
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
    }

    public void setDate(int year, int month, int dayOfMonth) {
        calendar.set(year, month, dayOfMonth);
    }

    public boolean isCompleted() {
        if (title.equals("") || place.equals("")) {
            return false;
        } else {
            return true;
        }
    }


    public String dateAsString() {

        String stringDate = new SimpleDateFormat("dd/MMM/yyyy").format(calendar.getTime());
        return stringDate;
    }

    public String timeAsString() {
        String stringTime = new SimpleDateFormat("hh:mm").format(calendar.getTime());
        return stringTime;
    }
}
