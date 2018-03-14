package com.example.giovanni.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {

    private Boolean newOperation=true;
    DecimalFormat decimal = new DecimalFormat("#.#######"); // Limit the digits of a decimal number
    private String lastChange;  //Keeps track of the last action executed
    private double firstNum=Double.NaN;  //First number of the operation
    private double secondNum=Double.NaN; //Second number of the operation
    private double ans=Double.NaN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Button 1
        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                editText.append("1");

            }
        });

        // Button 2
        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                editText.append("2");

            }
        });

        // Button 3
        final Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                editText.append("3");

            }
        });

        // Button 4
        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                editText.append("4");

            }
        });

        // Button 5
        final Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                editText.append("5");

            }
        });

        // Button 6
        final Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                editText.append("6");

            }
        });

        // Button 7
        final Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                editText.append("7");

            }
        });

        // Button 8
        final Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                editText.append("8");

            }
        });

        // Button 9
        final Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                editText.append("9");

            }
        });

        // Button 0
        final Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                editText.append("0");

            }
        });

        // Button dot
        final Button button_dot = findViewById(R.id.button_dot);
        button_dot.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                NewOperation();
                EditText editText = findViewById(R.id.editText);
                String temp = editText.getText().toString();
                if(!temp.contains("."))
                {
                    if (isEmptyEt(editText)) {
                        editText.setText("0.");
                    } else
                        editText.append(".");
                }
            }
        });

        // Button c
        final Button button_c = findViewById(R.id.button_c);
        button_c.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                newOperation=true;
                NewOperation();

            }
        });

        // Button ANS
        final Button button_ans = findViewById(R.id.button_ans);
        button_ans.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                if(!Double.isNaN(ans))
                {
                    editText.setText(ans+"");
                }

            }
        });

        // Button delete
        final Button button_delete = findViewById(R.id.button_delete);
        button_delete.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                String text = editText.getText().toString();
                if(!isEmptyEt(editText))
                editText.setText(text.substring(0, text.length() - 1));

            }
        });

        // Button sum
        final Button button_sum = findViewById(R.id.button_sum);
        button_sum.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                TextView textView= findViewById(R.id.textView);
                String text = editText.getText().toString() ;
                    if(newOperation && !isEmptyEt(editText))
                    {
                        firstNum = Double.parseDouble(text);
                        textView.setText(firstNum+"+");
                        editText.setText("");
                        newOperation=false;
                    }
                    else if(!isEmptyEt(editText))
                    {
                        multipleInput();
                        textView.setText(textView.getText().toString()+"+");
                    }
                if(isEmptyEt(editText) && !isEmptyTw(textView) && !newOperation)
                    {
                        text = textView.getText().toString();
                        textView.setText(text.substring(0, text.length() - 1) + "+");
                    }
                lastChange="+";
            }
        });

        // Button sub
        final Button button_sub = findViewById(R.id.button_sub);
        button_sub.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                TextView textView= findViewById(R.id.textView);
                String text = editText.getText().toString() ;
                if(newOperation && !isEmptyEt(editText))
                {
                    firstNum = Double.parseDouble(text);
                    textView.setText(firstNum+"-");
                    editText.setText("");
                    newOperation=false;
                }
                else if(!isEmptyEt(editText))
                {
                    multipleInput();
                    textView.setText(textView.getText().toString()+"-");
                }
                if(isEmptyEt(editText) && !isEmptyTw(textView)&& !newOperation)
                {
                    text = textView.getText().toString();
                    textView.setText(text.substring(0, text.length() - 1) + "-");
                }

                lastChange="-";
            }
        });

        // Button mul
        final Button button_mul = findViewById(R.id.button_mul);
        button_mul.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                TextView textView= findViewById(R.id.textView);
                String text = editText.getText().toString() ;
                if(newOperation && !isEmptyEt(editText))
                {
                    firstNum = Double.parseDouble(text);
                    textView.setText(firstNum+"x");
                    editText.setText("");
                    newOperation=false;
                }
                else if(!isEmptyEt(editText))
                {
                    multipleInput();
                    textView.setText(textView.getText().toString()+"x");
                }
                if(isEmptyEt(editText) && !isEmptyTw(textView)&& !newOperation)
                {
                    text = textView.getText().toString();
                    textView.setText(text.substring(0, text.length() - 1) + "x");
                }
                lastChange="x";
            }
        });

        // Button div
        final Button button_div = findViewById(R.id.button_div);
        button_div.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                TextView textView= findViewById(R.id.textView);
                String text = editText.getText().toString() ;
                if(newOperation && !isEmptyEt(editText))
                {
                    firstNum = Double.parseDouble(text);
                    textView.setText(firstNum+"÷");
                    editText.setText("");
                    newOperation=false;
                }
                else if(!isEmptyEt(editText))
                {
                    multipleInput();
                    textView.setText(textView.getText().toString()+"÷");
                }
                if(isEmptyEt(editText) && !isEmptyTw(textView)&& !newOperation)
                {
                    text = textView.getText().toString();
                    textView.setText(text.substring(0, text.length() - 1) + "÷");
                }
                lastChange="÷";
            }
        });

        // Button sqrt
        final Button button_sqrt = findViewById(R.id.button_sqrt);
        button_sqrt.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                TextView textView= findViewById(R.id.textView);
                String text = editText.getText().toString() ;
                if(!isEmptyEt(editText))
                {
                    ans=Math.sqrt(Double.parseDouble(text));
                    textView.setText(String.valueOf(decimal.format(ans))+"");
                    editText.setText("");
                    newOperation=true;
                }

            }
        });

        // Button sin
        final Button button_sin = findViewById(R.id.button_sin);
        button_sin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                TextView textView= findViewById(R.id.textView);
                String text = editText.getText().toString() ;
                if(!isEmptyEt(editText))
                {
                    ans=Math.sin(Double.parseDouble(text));
                    textView.setText(String.valueOf(decimal.format(ans))+"");
                    editText.setText("");
                    newOperation=true;
                }

            }
        });

        // Button cos
        final Button button_cos = findViewById(R.id.button_cos);
        button_cos.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                TextView textView= findViewById(R.id.textView);
                String text = editText.getText().toString() ;
                if(!isEmptyEt(editText))
                {
                    ans=Math.cos(Double.parseDouble(text));
                    textView.setText(String.valueOf(decimal.format(ans))+"");
                    editText.setText("");
                    newOperation=true;
                }

            }
        });

        // Button tan
        final Button button_tan = findViewById(R.id.button_tan);
        button_tan.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                TextView textView= findViewById(R.id.textView);
                String text = editText.getText().toString() ;
                if(!isEmptyEt(editText))
                {
                    ans=Math.tan(Double.parseDouble(text));
                    textView.setText(String.valueOf(decimal.format(ans))+"");
                    editText.setText("");
                    newOperation=true;
                }

            }
        });



        // Button result
        final Button button_result = findViewById(R.id.button_result);
        button_result.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText);
                TextView textView= findViewById(R.id.textView);
                lastChange="";
                if(!isEmptyEt(editText) && firstNum!=Double.NaN)
                {
                    secondNum = Double.parseDouble(editText.getText().toString());
                    String text = textView.getText().toString();
                     if(text.contains("+")||text.contains("-")||text.contains("x")||text.contains("÷"))
                    {

                        String operation =  text.substring(text.length()-1);

                        switch(operation) {
                            case "+":
                                double num=firstNum+secondNum;
                                textView.setText(String.valueOf(decimal.format(num)));
                                editText.setText("");
                                ans=num;
                                newOperation=true;
                                break;
                            case "-":
                                num=firstNum-secondNum;
                                textView.setText(String.valueOf(decimal.format(num)));
                                editText.setText("");
                                ans=num;
                                newOperation=true;
                                break;
                            case "x":
                                num=firstNum*secondNum;
                                textView.setText(String.valueOf(decimal.format(num)));
                                editText.setText("");
                                ans=num;
                                newOperation=true;
                                break;
                            case "÷":
                                if(firstNum!=0)
                                {
                                    num = firstNum / secondNum;
                                    textView.setText(String.valueOf(decimal.format(num)));
                                    editText.setText("");
                                    ans=num;
                                }
                                else
                                {
                                    textView.setText("Math Error");
                                    newOperation = true;
                                }
                                editText.setText("");
                                newOperation=true;
                                break;
                            default:
                                editText.setText("");
                                textView.setText("");
                                newOperation=true;
                                break;
                        }

                    }
                }
            }
        });

    }

    private boolean isEmptyEt(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }
    private boolean isEmptyTw(TextView twText) {
        if (twText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }
    private void NewOperation()
    {
        EditText editText = findViewById(R.id.editText);
        TextView textView= findViewById(R.id.textView);
        if(newOperation) {
            lastChange="";
            textView.setText("");
            firstNum=Double.NaN;
            secondNum=Double.NaN;
        }
    }

    private void multipleInput()
    {
        EditText editText = findViewById(R.id.editText);
        TextView textView= findViewById(R.id.textView);
        double num = 0;
        if(lastChange!="")
        {
            secondNum =Double.parseDouble( editText.getText().toString());
        }
        if(secondNum!=Double.NaN)
        {
            switch(lastChange) {
                case "+":
                    num=firstNum+secondNum;
                    firstNum=num;
                    secondNum=Double.NaN;
                    textView.setText(String.valueOf(decimal.format(num)));
                    break;
                case "-":
                    num=firstNum-secondNum;
                    firstNum=num;
                    secondNum=Double.NaN;
                    textView.setText(String.valueOf(decimal.format(num)));
                    break;
                case "x":
                    num=firstNum*secondNum;
                    firstNum=num;
                    secondNum=Double.NaN;
                    textView.setText(String.valueOf(decimal.format(num)));
                    break;
                case "÷":
                    if(firstNum!=0)
                    {
                        num=firstNum/secondNum;
                        firstNum=num;
                        secondNum=Double.NaN;
                        textView.setText(String.valueOf(decimal.format(num)));
                    }
                    else
                    {
                        textView.setText("Math Error");
                        newOperation = true;
                    }
                    break;
                default:
                    break;
            }
        }
        editText.setText("");
    }
}

