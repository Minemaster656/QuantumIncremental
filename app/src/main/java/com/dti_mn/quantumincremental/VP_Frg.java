package com.dti_mn.quantumincremental;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quantumincremental.R;

import java.lang.Thread;

public class VP_Frg extends Fragment {

    Button VPClick_Btn;
    TextView VPCount_Txt;
    TextView VCCount_Txt;
    Button VPDelayUpdate_Btn;
    Button VPDivisionUpgrade_Btn;

    int counter=0;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Update_VP();
        }
    };
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        VPCount_Txt = view.findViewById(R.id.VP_count);
        VCCount_Txt = view.findViewById(R.id.VC_count);
        VPDelayUpdate_Btn = view.findViewById(R.id.VP_delayUpgrade);
        VPClick_Btn = view.findViewById(R.id.clickMe_vp);
        VPDivisionUpgrade_Btn = view.findViewById(R.id.VP_dvUpgrade);

        VPClick_Btn.setOnClickListener(v -> vars.VP+=vars.VP_perClick); //vars.VP+=vars.VP_perClick
        VPDelayUpdate_Btn.setOnClickListener(v -> CL_VPDelayUpdate());
        VPDivisionUpgrade_Btn.setOnClickListener(v -> {
            if (vars.VCl >= vars.VP_dvn_UpCost & vars.VP_dvn >2){
                vars.VP_dvn--;
                vars.VCl-=vars.VP_dvn_UpCost;
                vars.VP_dvn_UpCost*=3;
            }
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                while (true){
                try {
                    Thread.sleep(1000/vars.FPS);
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }


    public VP_Frg(){

        super(R.layout.virtual_particles);


    }
    public void Update_VP(){
        VPCount_Txt.setText(Double.toString(vars.VP));
        VCCount_Txt.setText(Double.toString(vars.VCl));
        counter++;
        VPDelayUpdate_Btn.setText(getResources().getString(R.string.VPUpdate_delay)+ "\n"+ getResources().getString(R.string.word_cost)+": "+Double.toString(vars.VP_delayUpd_cost));
        VPDivisionUpgrade_Btn.setText(getResources().getString(R.string.VPUpgrade_divison)+"\n"+getResources().getString(R.string.word_cost)+": "+Double.toString(vars.VP_dvn_UpCost));
        if (counter>=vars.FPS){

        }
        if (counter>=vars.FPS*(vars.VP_delay+0.5) & !vars.isVPBroken){
            vars.VP/=vars.VP_dvn;
            counter=0;
        }
    }
    void CL_VPDelayUpdate(){
        if (vars.VCl >= vars.VP_delayUpd_cost){
            vars.VP_delay++;
            vars.VCl-=vars.VP_delayUpd_cost;
            vars.VP_delayUpd_cost*=2;
        }
    }
}
//class UpdateInvoker extends Thread{
//    @Override
//    public void run() {
////        super.run();
//        try {
//            sleep(20);
//            Update_VP();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
