package cal.ui;import javax.swing.*;
import java.awt.event.*;

public class Listners implements ActionListener{
    CalBack cb=new CalBack();
double v1=0,v2=0,result=0,tempresult=v1,tempv2=0,tempv1=0;
String u1="",u2="",opt="",lopt="",tempopt="";
    private JButton opt_sec; private JButton opt_cosec; private JButton opt_tan; private JButton opt_cot;
    private JButton opt_cos;private JButton opt_sin; private JButton int_1; private JButton int_4;
    private JButton int_7; private JButton int_2; private JButton int_5; private JButton int_8;
    private JButton int_3; private JButton int_6; private JButton int_9; private JButton int_0;
    private JButton opt_sum; private JButton opt_sub; private JButton opt_mult; private JButton opt_divd;
    private JButton opt_mode;  private JButton int_point; private JTextField textField1;  public JPanel MainPanel;
    private JButton btn_clr; private JTextField resfild; private JButton backspace; private JButton a00Button;
    private JButton calculate;

    public void setNum(String num){
        if (opt.equals("")) {
            textField1.setText(u1+num);
            u1=textField1.getText();
            v1=Double.parseDouble(u1);
            tempresult=v1;
        } else {
            textField1.setText(textField1.getText()+num);
            u2=textField1.getText();
            u2=u2.substring(u1.length(),u2.length());
            v2=Double.parseDouble(u2);
        }
    }
    public void setOpt(String op){
        opt=op;
        textField1.setText(textField1.getText()+""+opt);
        u1=textField1.getText();
        if(opt=="+"&&lopt=="+"||opt=="+"&&lopt=="-"||opt=="-"&&lopt=="+"||opt=="-"&&lopt=="-"){
            tempresult=cb.choose(tempresult,v2,lopt);
            v2=0;
        }
        else if(opt=="X"&&lopt=="+"||opt=="X"&&lopt=="-"||opt=="/"&&lopt=="+"||opt=="/"&&lopt=="-"){
           tempv1=tempresult;tempv2=v2;tempopt=lopt;
            System.out.println(tempv1);
        }
        else if(opt=="+"&&lopt=="X"||opt=="+"&&lopt=="/"||opt=="-"&&lopt=="X"||opt=="-"&&lopt=="/"){
            System.out.println(tempopt+"tempopt is this");
            if(tempopt==""){tempresult=cb.choose(tempresult,v2,lopt);}
            else {
                double x = cb.choose(tempv2, v2, lopt);
                tempresult = cb.choose(tempresult, x, tempopt);
            }
        }
        else if(opt=="+"&&lopt=="X"||opt=="+"&&lopt=="/"||opt=="-"&&lopt=="X"||opt=="-"&&lopt=="/"){
            tempresult= cb.choose(tempv1,tempv2,tempopt);
        }
        else if (opt=="X"&&lopt=="X"||opt=="X"&&lopt=="/"||opt=="/"&&lopt=="X"||opt=="/"&&lopt=="/"){
            if(tempopt==""){ tempresult=cb.choose(tempresult,v2,lopt);
                v2=0;}
            else {tempv2 = cb.choose(tempv2, v2, lopt); v2 = 0;
            }
        }
        else if(opt=="%"){
            tempresult=cb.choose(tempresult,v2,lopt);
        }
        lopt=opt;
        resfild.setText(tempresult+"");
    }

    public void seeResult(){
        if(opt=="+"||opt=="-"){
            result=cb.choose(tempresult,v2,opt);
        }
        else if(opt=="X"||opt=="/"){
            if(lopt=="+"||lopt=="-")
            {
                double x = cb.choose(tempv2, v2, lopt);
                result = cb.choose(tempv1, x, tempopt);
            }
            else if(lopt=="/"&&tempopt=="+"||lopt=="/"&&tempopt=="-"||lopt=="X"&&tempopt=="+"||lopt=="X"&&tempopt=="-")
            {
                double d=cb.choose(tempv2,v2,lopt);
                result=cb.choose(tempv1,d,tempopt);
            }
            else{
                double x = cb.choose(tempresult, v2, lopt);
                result = cb.choose(tempv1, x, tempopt);
            }
        }
        else if(lopt=="%"){
            result=cb.choose(tempresult,v2,lopt);
        }
        if(u1!=null&&opt!=""&&u2!=null)
            textField1.setText(""+result);
        else if (u1!=null&&opt!=""){textField1.setText(""+result);}
        resfild.setText("");
    }

    public void setOpt2(String op){
        opt=op;
        textField1.setText(opt+" of "+ u1+" is ="+cb.choose(v1,v2,opt));
    }

    public void back(){
        if (opt.equals("")) {
            if(textField1.getText().length()>0)
                textField1.setText(textField1.getText().substring(0,textField1.getText().length()-1));
            u1=textField1.getText();
            v1=Double.parseDouble(u1);
        } else {
            v1=Double.parseDouble(u1.replace(opt,""));
            if(textField1.getText().length()>0)
                textField1.setText(textField1.getText().substring(0,textField1.getText().length()-1));
            u2=textField1.getText();
            u2=u2.replaceFirst(u1,"");
            u2=u2.replace(opt,"");
            v2=Double.parseDouble(u2);
        }
    }
    public Listners() {
        int_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("1");
            }
        });
        int_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("2");
            }
        });
        int_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("3");
            }
        });
        int_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("4");
            }
        });
        int_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("5");
            }
        });
        int_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("6");
            }
        });
        int_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("7");
            }
        });
        int_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("8");
            }
        });
        int_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("9");
            }
        });
        int_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("0");
            }
        });
        a00Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum("00");
            }
        });
        opt_sum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpt("+");
            }
        });
        opt_sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpt("-");
            }
        });
        opt_mult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpt("X");
            }
        });
        opt_divd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpt("/");
            }
        });
        opt_mode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpt("%");
            }
        });

        opt_sin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               setOpt2("sin");
            }
        });
        opt_cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpt2("cos");
            }
        });
        opt_tan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpt2("tan");
            }
        });
        opt_cot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpt2("cot");
            }
        });
        opt_sec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpt2("sec");
            }
        });
        opt_cosec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpt2("cosec");
            }
        });
        btn_clr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v1=0;v2=0;opt="";u1="";u2="";lopt="";tempresult=0;
                tempopt="";tempv2=0;
                textField1.setText("");
                resfild.setText("");
            }
        });
        int_point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(".");
            }
        });
        backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               back();
            }
        });
       calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seeResult();
            }
        });
        textField1.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
               switch (e.getKeyChar()) {
                   case '\n': seeResult();break;
                   case '0': setNum("0");break;
                   case '1': setNum("1");break;
                   case '2': setNum("2");break;
                   case '3': setNum("3");break;
                   case '4': setNum("4");break;
                   case '5': setNum("5");break;
                   case '6': setNum("6");break;
                   case '7': setNum("7");break;
                   case '8': setNum("8");break;
                   case '9': setNum("9");break;
                   case '+': setOpt("+");break;
                   case '-': setOpt("-");break;
                   case '*': setOpt("X");break;
                   case '/': setOpt("/");break;
               }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if()
    }
}
