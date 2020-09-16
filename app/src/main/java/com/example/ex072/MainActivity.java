package com.example.ex072;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    TextView x1,x2;
    EditText a,b,c;
    String checkA,checkB,checkC;
    int comeBack= 1;
    double n1,n2,n3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a= (EditText) findViewById(R.id.a);
        b= (EditText) findViewById(R.id.b);
        c= (EditText) findViewById(R.id.c);
        x1= (TextView) findViewById(R.id.x1);
        x2= (TextView) findViewById(R.id.x2);
    }

    public void getNum(View view) {
        checkA= a.getText().toString();
        checkB= b.getText().toString();
        checkC= c.getText().toString();
        if (!(checkA.equals(""))||(checkB.equals(""))||(checkC.equals(""))){
            if (!(checkA.equals("-"))||(checkB.equals("-"))||(checkC.equals("-"))){
                if (!(((checkA.startsWith("."))||(checkB.startsWith("."))||(checkC.startsWith(".")))&&((checkA.endsWith("."))||(checkB.endsWith("."))||(checkC.endsWith("."))))) {
                    if (!((checkA.startsWith("-."))||(checkB.startsWith("-."))||(checkC.startsWith("-.")))){
                        if (!(checkA.equals("0"))) {
                            Intent result = new Intent(this, Answer.class);
                            result.putExtra("a", checkA);
                            result.putExtra("b", checkB);
                            result.putExtra("c", checkC);
                            startActivityForResult(result, comeBack);
                        }
                    }
                }

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            if (data.getBooleanExtra("flag",false)) {
                x1.setText(String.valueOf(data.getDoubleExtra("x1", 0)));
                x2.setText(String.valueOf(data.getDoubleExtra("x2", 0)));
            }
            else{
                x1.setText("null");
                x2.setText("null");
            }
        }

    }

    public void random(View view) {
        Random rnd= new Random();
        //n1=Double.MIN_VALUE+(Double.MAX_VALUE-Double.MIN_VALUE)*rnd.nextDouble();
        //n2=Double.MIN_VALUE+(Double.MAX_VALUE-Double.MIN_VALUE)*rnd.nextDouble();
        //n3=Double.MIN_VALUE+(Double.MAX_VALUE-Double.MIN_VALUE)*rnd.nextDouble();
        //מספרים מעבר למה שיכולתי לחשב
        n1=(-100+(100-(-100)))*rnd.nextDouble();
        n2=(-100+(100-(-100)))*rnd.nextDouble();
        n3=(-100+(100-(-100)))*rnd.nextDouble();
        a.setText(String.valueOf(n1));
        b.setText(String.valueOf(n2));
        c.setText(String.valueOf(n3));
    }
}