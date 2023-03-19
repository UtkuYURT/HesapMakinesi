package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hesapmakinesi.databinding.ActivityMainBinding;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding tasarim;
    private String s1 = "";
    private String s2 = "";
    private String islem = "";
    private float sayi1;
    private float sayi2;
    private float sonuc = 0;
    private String result = "";
    private TextView textViewSonuc;
    private TextView textViewIslem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        textViewIslem = findViewById(R.id.textViewIslem);
        textViewSonuc = findViewById(R.id.textViewSonuc);

        tasarim.buttonSifir.setOnClickListener(this);
        tasarim.buttonBir.setOnClickListener(this);
        tasarim.buttonIki.setOnClickListener(this);
        tasarim.buttonUc.setOnClickListener(this);
        tasarim.buttonDort.setOnClickListener(this);
        tasarim.buttonBes.setOnClickListener(this);
        tasarim.buttonAlti.setOnClickListener(this);
        tasarim.buttonYedi.setOnClickListener(this);
        tasarim.buttonSekiz.setOnClickListener(this);
        tasarim.buttonDokuz.setOnClickListener(this);
        tasarim.buttonVirgul.setOnClickListener(this);
        tasarim.buttonToplama.setOnClickListener(this);
        tasarim.buttonCikarma.setOnClickListener(this);
        tasarim.buttonCarpma.setOnClickListener(this);
        tasarim.buttonBolme.setOnClickListener(this);
        tasarim.buttonEsittir.setOnClickListener(this);
        tasarim.buttonClear.setOnClickListener(this);
        tasarim.buttonUs.setOnClickListener(this);
        tasarim.buttonBackSpace.setOnClickListener(this);
    }

    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.buttonSifir:
                tasarim.textViewIslem.append("0");
                break;
            case R.id.buttonBir:
                tasarim.textViewIslem.append("1");
                break;
            case R.id.buttonIki:
                tasarim.textViewIslem.append("2");
                break;
            case R.id.buttonUc:
                tasarim.textViewIslem.append("3");
                break;
            case R.id.buttonDort:
                tasarim.textViewIslem.append("4");
                break;
            case R.id.buttonBes:
                tasarim.textViewIslem.append("5");
                break;
            case R.id.buttonAlti:
                tasarim.textViewIslem.append("6");
                break;
            case R.id.buttonYedi:
                tasarim.textViewIslem.append("7");
                break;
            case R.id.buttonSekiz:
                tasarim.textViewIslem.append("8");
                break;
            case R.id.buttonDokuz:
                tasarim.textViewIslem.append("9");
                break;
            case R.id.buttonVirgul:
                tasarim.textViewIslem.append(".");
                break;
            case R.id.buttonUs:
                islem = "^";
                s1 = tasarim.textViewIslem.getText().toString();
                textViewIslem.setText("");
                break;
            case R.id.buttonBackSpace:
                String str = textViewIslem.getText().toString();
                int length = str.length();
                if (length > 0){
                    textViewIslem.setText(str.substring(0, length - 1));
                }
                else {
                    textViewIslem.setText("");
                }
                break;
            case R.id.buttonToplama:
                islem = "+";
                s1 = tasarim.textViewIslem.getText().toString();
                textViewIslem.setText("");
                break;
            case R.id.buttonCikarma:
                islem = "-";
                s1 = tasarim.textViewIslem.getText().toString();
                tasarim.textViewIslem.setText("");
                break;
            case R.id.buttonCarpma:
                islem = "*";
                s1 = tasarim.textViewIslem.getText().toString();
                tasarim.textViewIslem.setText("");
                break;
            case R.id.buttonBolme:
                islem = "/";
                s1 = tasarim.textViewIslem.getText().toString();
                tasarim.textViewIslem.setText("");
                break;
            case R.id.buttonEsittir:
                s2 = textViewIslem.getText().toString();
                sayi1 = Float.parseFloat(s1);
                sayi2 = Float.parseFloat(s2);
                if (islem.equals("+")) {
                    sonuc = sayi1 + sayi2;
                }
                else if (islem.equals("-")) {
                    sonuc = sayi1 - (-sayi2);
                }
                else if (islem.equals("*")) {
                    sonuc = sayi1 * sayi2;
                }
                else if (islem.equals("/")) {
                    sonuc = sayi1 / sayi2;
                }
                else if (islem.equals("^")) {
                    sonuc = 1;
                    for (int i=0; i<sayi2; i++){
                        sonuc = sayi1 * sonuc;
                    }
                }

                result = Float.toString(sonuc);
                String[] dizi = result.split(Pattern.quote("."));
                String part2 = dizi[1];
                if (part2.equals("0")) {
                    textViewSonuc.setText(dizi[0]);
                }
                else {
                    textViewSonuc.setText(result);
                }

                String cumle = s1 + islem + s2;
                textViewIslem.setText(cumle);
                break;
            case R.id.buttonClear:
                s1 = "0";
                s2 = "0";
                textViewIslem.setText("");
                textViewSonuc.setText("");
                break;
        }
    }
}