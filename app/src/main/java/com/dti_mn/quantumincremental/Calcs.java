package com.dti_mn.quantumincremental;
import java.lang.Thread;
public class Calcs {
    static CalcThr ct = new CalcThr();
//    static UpdateInvoker ut = new UpdateInvoker();

}
class CalcThr extends Thread{
    @Override
    public void run() {

        while (currentThread().isAlive()){
            vars.VCl_size = vars.VCl_size0*(Math.pow(1.1, vars.VCl));
//            vars.VP = new Double(String.format("%.2f", vars.VP + ""));
        if (vars.VP<=0.1){
            vars.VP=0;
        }
            while (vars.VP >= vars.VCl_size & vars.VCl<=vars.VCl_max){
                vars.VP-=vars.VCl_size;
                vars.VCl++;

            }
//        }

    }}
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
