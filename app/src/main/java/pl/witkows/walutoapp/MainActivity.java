package pl.witkows.walutoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import pl.witkows.Currency;
import pl.witkows.CurrencyApi;
import pl.witkows.CurrencyInfo;

public class MainActivity extends AppCompatActivity {


    CurrencyApi currencyApi = new CurrencyApi();
    private TextView currencyText;
    private Button currencyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currencyText = findViewById(R.id.currency_text);
        currencyButton = findViewById(R.id.get_currency_button);

        currencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final CurrencyInfo result = currencyApi.getInfoForCurrency(Currency.CAD);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    currencyText.setText(result.getName() + " " + result.getBuy());
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });


    }
}