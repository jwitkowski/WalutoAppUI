package pl.witkows.walutoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pl.witkows.CurrencyApi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CurrencyApi currencyApi = new CurrencyApi();

    }
}