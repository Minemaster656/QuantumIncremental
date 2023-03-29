package com.example.quantumincremental;
import java.lang.Thread;
public class Calcs {
    static CalcThr ct = new CalcThr();
//    static UpdateInvoker ut = new UpdateInvoker();

}
class CalcThr extends Thread{
    @Override
    public void run() {
//        super.run();
        //System.out.println("a");

    }
}
//class UpdateInvoker extends Thread{
//    @Override
//    public void run() {
////        super.run();
//        try {
//            sleep(20);
//
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
