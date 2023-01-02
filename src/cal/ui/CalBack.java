package cal.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

abstract class cal{

    double v1,v2;
    String oper;

    double choose(double v1,double v2,String opt) {
        this.v1=v1;this.v2=v2;this.oper=opt;
        if(oper.equals("+")||oper.equals("-")||oper.equals("X")||oper.equals("/")||oper.equals("%")){
      calculate(v1,oper,v2);    }
    else{calculate(v1,oper);    }
    return result;
    }
    double result;
    double calculate(double v1,String o){
        switch (o){
            case "sin":result=Math.sin(Math.toRadians(v1));break;
            case "cos":result=Math.cos(Math.toRadians(v1));break;
            case "tan":result=Math.tan(Math.toRadians(v1));break;
            case "cot":result=1/Math.tan(Math.toRadians(v1));break;
            case "sec":result=1/Math.cos(Math.toRadians(v1));break;
            case "cosec":result=1/Math.sin(Math.toRadians(v1));break;
        }
        return result;
    }
    double calculate(double v1, String o,double v2){
        switch (o) {
            case "+":result= v1+v2;
                break;
            case "-":result= v1-v2;
                break;
            case "X":result= v1*v2;
                break;
            case "/":result= v1/v2;
                break;
            case "%":result=v1%v2;
            break;
        }
        return result;
    }
}

class CalBack extends cal{
    JFrame frame=new JFrame();
    void showresult(){
        frame.setTitle("UiForm");
        frame.setIconImage(new ImageIcon("callogo").getImage());
        frame.setContentPane(new Listners().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setTitle("Calculator developed By CHANDAN");
        frame.setBackground(new Color(40,37,125));
    }
}
