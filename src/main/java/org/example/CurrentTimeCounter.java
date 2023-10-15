package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTimeCounter {
    public static void main(String[] args) {
        CurrentTimeCounter test = new CurrentTimeCounter();
        test.printCurrentTime();
    }
    public static void printCurrentTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        while (true){
            String formattedTime = currentTime.format(dateTimeFormatter);
            System.out.println("Current time: " + formattedTime);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTime = LocalDateTime.now();
        }
    }
}


