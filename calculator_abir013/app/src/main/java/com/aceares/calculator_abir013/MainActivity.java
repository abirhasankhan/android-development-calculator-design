package com.aceares.calculator_abir013;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    TextView inputText, outputText;
    Button btnDot, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnEqual, btnAddition, btnSubtraction, btnMultiplication, btnDivision, btnPar, btnDel, frowardBtn, backBtn, btnAC;
   // private String input, output, newOutput2;
    ArrayList str = new ArrayList<>();
    SharedPreferences myPref;
    int counter = 0;
    int max = 0;
    String[] arrOfStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_xml);

        myPref = getApplicationContext().getSharedPreferences("DATA", MODE_PRIVATE);

        inputText = findViewById(R.id.text1);
        outputText =findViewById(R.id.text2);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDot = findViewById(R.id.btnDot);

        btnEqual = findViewById(R.id.btnEqual);
        btnAddition = findViewById(R.id.btnAddition);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnDivision = findViewById(R.id.btnDivision);
        btnPar = findViewById(R.id.btnPar);

        btnDel = findViewById(R.id.btnDel);
        frowardBtn = findViewById(R.id.frowardBtn);
        backBtn = findViewById(R.id.backBtn);
        btnAC = findViewById(R.id.btnAC);

        btn0.setOnClickListener(view -> fun0());
        btn1.setOnClickListener(view -> fun1());
        btn2.setOnClickListener(view -> fun2());
        btn3.setOnClickListener(view -> fun3());
        btn4.setOnClickListener(view -> fun4());
        btn5.setOnClickListener(view -> fun5());
        btn6.setOnClickListener(view -> fun6());
        btn7.setOnClickListener(view -> fun7());
        btn8.setOnClickListener(view -> fun8());
        btn9.setOnClickListener(view -> fun9());
        btnDot.setOnClickListener(view -> funDot());

        btnAddition.setOnClickListener(view -> funAdd());
        btnSubtraction.setOnClickListener(view -> funSub());
        btnMultiplication.setOnClickListener(view -> funMul());
        btnDivision.setOnClickListener(view -> funDiv());
        btnPar.setOnClickListener(view -> funPar());

        btnDel.setOnClickListener(view -> funDel());
        btnAC.setOnClickListener(view -> funAC());

        btnEqual.setOnClickListener(view -> funEqual());
        frowardBtn.setOnClickListener(v -> funFroward());
        backBtn.setOnClickListener(v -> funBack());

    }

    private void funPar() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"%");
    }

    private void funDiv() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"÷");
    }

    private void funMul() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"×");
    }

    private void funSub() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"-");
    }

    private void funAdd() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"+");
    }

    private void funDot() {
       String data = inputText.getText().toString().trim();
       inputText.setText(data+".");
    }

    private void fun9() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"9");
    }

    private void fun8() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"8");
    }

    private void fun7() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"7");
    }

    private void fun6() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"6");
    }

    private void fun5() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"5");
    }

    private void fun4() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"4");
    }

    private void fun3() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"3");
    }

    private void fun2() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"2");
    }

    private void fun1() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"1");
    }

    private void fun0() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data+"0");
    }


    private void funDel() {
        String data = inputText.getText().toString().trim();
        inputText.setText(data.substring(0, data.length()-1));
    }

    private void funAC() {
        inputText.setText(null);
        outputText.setText(null);
        btnAC.setText("AC");


    }

    private void funEqual() {
       // String[] str ;

        String data = inputText.getText().toString().trim();
        outputText.setText("="+data);
        btnAC.setText("C");
        inputText.setText(null);
        System.out.println(data);


        str.add(data);
        String listString = String.join(", ", str);

        myPref.edit().putString("result", listString).apply();
        String str = myPref.getString("result",null);
        arrOfStr = str.split(",");
        max = arrOfStr.length;
    }

    void getValue(){
        String str = myPref.getString("result",null);
        arrOfStr = str.split(",");
        System.out.println("size: "+max);
    }

    private void funFroward() {
        getValue();
        if (max > 0) {
            inputText.setText("result=" + arrOfStr[max - 1]);
            System.out.println(arrOfStr[max - 1]);
            max--;
        }
    }

    private void funBack() {
        getValue();
        if (counter< arrOfStr.length) {
            inputText.setText("result=" + arrOfStr[counter]);
            System.out.println(arrOfStr[counter]);
            counter++;
        }
    }

    private void solve() {


    }

}