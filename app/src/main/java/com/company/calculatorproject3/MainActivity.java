package com.company.calculatorproject3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView answer,equation;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    Button acbtn,addbtn,subbtn,multibtn,delbtn,dotbtn,equalbtn,divbtn;
    String number= null;

    double firstnum =0;
    double lastnum=0;
    DecimalFormat decimalFormat = new DecimalFormat("######.######");

    String history, currentresult;
    boolean operator;
    String status=null;


    boolean dotuse=true;
    boolean deluse = true;
    boolean acuse=true;
    boolean equaluse=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer = findViewById(R.id.answer);
        equation = findViewById(R.id.equation);


        btn0= findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        acbtn = findViewById(R.id.acbtn);
        addbtn = findViewById(R.id.addbtn);
        subbtn = findViewById(R.id.subbtn);
        multibtn = findViewById(R.id.multibtn);
        dotbtn = findViewById(R.id.btndot);
        divbtn = findViewById(R.id.dividebtn);
        equalbtn = findViewById(R.id.equalbtn);
        delbtn = findViewById(R.id.delbtn);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberclick("9");
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                history = answer.getText().toString();
                currentresult = equation.getText().toString();
                answer.setText( history+currentresult+"+");

                if(operator){
                    if(status=="multiplication"){
                        multiply();
                    }else if(status=="subtract"){
                        minus();
                    }else if(status=="divide"){
                        divide();
                    }else{
                        plus();
                    }

                    operator=false;
                    status="add";
                    number=null;
                    dotuse=true;
                }
            }
        });

        subbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                history = answer.getText().toString();
                currentresult = equation.getText().toString();
                answer.setText(history+currentresult+"-");
                if(operator) {
                    if (status == "multiplication") {
                        multiply();
                    } else if (status == "add") {
                        plus();
                    } else if (status == "divide") {
                        divide();
                    } else {
                        minus();
                    }

                    operator = false;
                    status = "subtract";
                    number = null;
                    dotuse=true;
                }
            }
        });
        multibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = answer.getText().toString();
                currentresult = equation.getText().toString();
                answer.setText(history+currentresult+"*");
                if (operator) {
                    if (status == "add") {
                        plus();
                    } else if (status == "subtract") {
                        minus();
                    } else if (status == "divide") {
                        divide();
                    } else {
                        multiply();
                    }

                    operator = false;
                    status = "multiplication";
                    number = null;
                    dotuse=true;
                }
            }
        });
        divbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = answer.getText().toString();
                currentresult = equation.getText().toString();
                answer.setText(history+currentresult+"/");
                if(operator){
                    if(status=="multiplication"){
                        multiply();
                    }else if(status=="subtract"){
                        minus();
                    }else if(status=="add"){
                        plus();
                    }else{
                        divide();
                    }

                    operator=false;
                    status="divide";
                    number=null;
                    dotuse=true;
            }

            }
        });

        equalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(operator){
                        //equation.setText(""+firstnum);

                        history = answer.getText().toString();
                        currentresult = equation.getText().toString();
                        answer.setText(history+currentresult);

                        if(status=="multiplication"){
                            multiply();
                            //equation.setText(""+firstnum);
                        }else if(status=="subtract"){
                            minus();
                        }else if(status=="add"){
                            plus();
                        }else if(status=="divide"){
                            divide();
                        }else{
                            firstnum = Double.parseDouble(equation.getText().toString());
                            // equation.setText(""+firstnum);
                        }


                        operator=false;
                        equaluse=true;
                        //status=null;
                    }

                }


        });

        acbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number=null;
                status=null;
                answer.setText("");
                equation.setText("0");
                firstnum=0;
                lastnum=0;
                dotuse=true;
                acuse=true;
            }
        });

        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(acuse)
                {
                        equation.setText("0");
                    }
                else
                    {
                        number = number.substring(0,number.length()-1);

                        if(number.length()==0){
                            delbtn.setClickable(false);
                        }else if(number.contains(".")){
                            dotuse=false;
                        }else{
                            dotuse=true;
                        }


                        equation.setText(""+number);

                }

            }
        });

        dotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(dotuse){
                    if(number==null){
                    number="0.";

                }else{
                    number=number+".";
                }
                }
                equation.setText(number);
                    dotuse=false;
            }
        });



    }

    public void numberclick(String view){
        if(number== null){
            number = view;
        }else if(equaluse){
            firstnum=0;lastnum=0;
            number=view;

        }
        else{
            number = number +view;
        }
        equation.setText(number);
        operator=true;
        acuse=false;
        delbtn.setClickable(true);

    }

    public void plus(){
        lastnum =Double.parseDouble(equation.getText().toString());
        firstnum = firstnum+lastnum;

        equation.setText(" " +decimalFormat.format(firstnum));

    }


    public void  minus(){
        if(firstnum==0){
            firstnum = Double.parseDouble(equation.getText().toString());

        }else{
            lastnum =Double.parseDouble(equation.getText().toString());
            firstnum = firstnum-lastnum;
        }
        decimalFormat.format(firstnum);
        equation.setText(""+decimalFormat.format(firstnum));
    }

    public void multiply(){
        if(firstnum==0){
            firstnum=1;
            lastnum =Double.parseDouble(equation.getText().toString());
            firstnum = firstnum*lastnum;
        }
        else {
            lastnum=Double.parseDouble(equation.getText().toString());
            firstnum=firstnum*lastnum;
        }
        decimalFormat.format(firstnum);
        equation.setText(""+decimalFormat.format(firstnum));
    }

    public void divide(){
        if(firstnum==0){
            lastnum=Double.parseDouble(equation.getText().toString());
            firstnum=lastnum/1;
        }else{
            lastnum=Double.parseDouble(equation.getText().toString());
            firstnum=firstnum/lastnum;
        }

        decimalFormat.format(firstnum);
      equation.setText(""+decimalFormat.format(firstnum));

    }
}