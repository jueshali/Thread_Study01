/*
快乐影院
 */

import java.util.ArrayList;
import java.util.List;

public class TestThread {
    public static void main(String[] args) {
        System.out.println("快乐影院");
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(5);
        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(1);
        seats2.add(4);


        Cinema c = new Cinema(available,"happy");
        new Thread(new Customer(c,seats1)).start();
        new Thread(new Customer(c,seats2)).start();
    }
}
class Cinema{
    List<Integer> available;
    String name;

    public Cinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean bookTickets( List<Integer> seats){
        System.out.println("可用位置为"+ available);
        List<Integer> temp = new ArrayList<Integer>();
        temp.addAll(available);
        temp.removeAll(seats);
        if (available.size()-temp.size() != seats.size()){
            return false;
        }
        available = temp;
        return true;
    }
}
class Customer implements Runnable{
    Cinema cinema;
    List<Integer> seats;

    public Customer(Cinema cinema,List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("成功" + "剩下" + cinema.available);
            } else {
                System.out.println("你想取"+seats+"我们只剩下"+cinema.available);
                System.out.println("失败");
            }
        }
    }
}
