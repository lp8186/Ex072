package com.example.ex072;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.FloatEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class Answer extends AppCompatActivity {
    double a1,b1,c1;
    double num1,num2;
    String s1,s2,s3,str2;
    WebView wv;
    TextView first,second;
    Intent getAnswer;
    boolean b=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        wv= (WebView) findViewById(R.id.wv);
        first= (TextView) findViewById(R.id.first);
        second= (TextView) findViewById(R.id.second);

         getAnswer = getIntent();
         s1= getAnswer.getStringExtra("a");
         s2= getAnswer.getStringExtra("b");
         s3= getAnswer.getStringExtra("c");

         a1= Double.valueOf(s1);
         b1= Double.valueOf(s2);
         c1= Double.valueOf(s3);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new MyWebViewClient());

        str2="https://www.google.com/search?q=" + s1 + "x%5E2%2B" + s2 + "x%2B" + s3 + "&oq=" + s1 + "x%5E2%2B" + s2 + "x%2B" + s3 + "&aqs=chrome.0.69i59j0l7.11676j0j7&sourceid=chrome&ie=UTF-8";
        wv.loadUrl(str2);

//        if ((((a1>1)&&((((4*a1*c1-b1*b1)-(b1*b1))/(4*a1))>0))||(((a1<1)&&((((4*a1*c1-b1*b1)-(b1*b1))/(4*a1))<0))))){
        double disc = ((b1 * b1) - (4 * a1 * c1));
        if (disc<0){
            first.setText("null");
            second.setText("null");
        }
        else {
            b=true;
            num1 = (-b1 - (Math.sqrt(disc))) / (2 * a1) ;
            num2 = (-b1 + (Math.sqrt(disc))) / (2 * a1) ;
            first.setText(String.valueOf(num1));
            second.setText(String.valueOf(num2));
        }





    }

    public void backToMain(View view) {
        getAnswer.putExtra("x1",num1);
        getAnswer.putExtra("x2",num2);
        getAnswer.putExtra("flag",b);
        setResult(RESULT_OK,getAnswer);
        finish();

    }


    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}

