package com.example.quantumincremental;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.lang.Thread;

public class VP_Frg extends Fragment {

    Button VPClick_Btn;
    TextView VPCount_Txt;
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
        VPClick_Btn = view.findViewById(R.id.clickMe_vp);

        VPClick_Btn.setOnClickListener(v -> vars.VP+=vars.VP_perClick); //vars.VP+=vars.VP_perClick
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
        counter++;
        if (counter>=vars.FPS){

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
