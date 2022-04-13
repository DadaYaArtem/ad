package ua.goit.telegrambot.settings;

import lombok.SneakyThrows;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Scheduler implements Runnable{

    @SneakyThrows
    @Override
    public void run() {
        Calendar calendar = new GregorianCalendar();
        if (calendar.get(Calendar.HOUR_OF_DAY) < 9 || calendar.get(Calendar.HOUR_OF_DAY) > 18){
            if (calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                calendar.add(Calendar.DAY_OF_MONTH,1);
                calendar.set(Calendar.HOUR_OF_DAY, 9);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                Long date = calendar.getTimeInMillis();
                Long delay = date - System.currentTimeMillis();
                Thread.sleep(delay);
            }else {
                calendar.set(Calendar.HOUR_OF_DAY, 9);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                Long date = calendar.getTimeInMillis();
                Long delay = date - System.currentTimeMillis();
                Thread.sleep(delay);
            }
        }
        while (true){
            calendar = new GregorianCalendar();
        }

    }
}
