package com.example.quantumincremental;

public class vars {
    static double inf=Double.parseDouble("1.8E+308");
    static double VP; //в.ч.
    static double VCl; //в.к.
    static double VCl_size = 10; static double VCl_size0 = 10;
    static double VP_delay = 1; //задержка исчезновения (секунды)
    static double VP_delayUpd_cost = 1; //стоимость апгрейда ⬆
    static double VP_dvn = 10; //деитель при исчезновении
    static double VP_perClick = 1; //в.ч. за клик
    static double VCl_max = inf; //максимум кластеров в.ч.
    static boolean isVPBroken; //квантоваяФизика.сломать();
    static int FPS = 50;
}
