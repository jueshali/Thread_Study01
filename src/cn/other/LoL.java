package cn.other;

/**
 * 项目名：Thread_Study01
 * 描述：盖伦打timo
 *
 * @author : Lpc
 * @date : 2019-06-18 22:03
 **/
public class LoL {
    public static void main(String[] args) {
        Hero timo = new Hero("Timo",10);
        Hero ga = new Hero("Gailun",timo,20);
        Hero sj = new Hero("sj",timo,30);
        new Thread(ga).start();
        new Thread(sj).start();
    }
}


class Hero implements Runnable{
    String name;
    Hero hero;
    int blood = 1000;
    int attack;

    public Hero(String name,int attack) {
        this.name = name;
        this.attack = attack;
    }

    public Hero(String name, Hero hero,int attack ){
        this.name = name;
        this.hero = hero;
        this.attack = attack;
    }

    @Override
    public void run(){

            if (hero.blood <= 0) {
                return;
            }
        synchronized (hero) {
            while (hero.blood > 0) {
                if (hero.blood > this.attack) {
                    hero.blood -= this.attack;
                    System.out.println(this.name + "打了" + hero.name + this.attack + "滴血，他还剩" + hero.blood);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    hero.blood = 0;
                    System.out.println(this.name + "得到300赏金");
                    return;
                }
            }
        }
    }


}


