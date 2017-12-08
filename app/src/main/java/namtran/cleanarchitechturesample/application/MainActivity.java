package namtran.cleanarchitechturesample.application;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.mvp.view.MvpActivity;
import namtran.cleanarchitechturesample.application.mvvm.view.MvvmActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoMvp(View view) {
        startActivity(new Intent(this,MvpActivity.class));
    }

    public void goToMvvm(View view) {
        startActivity(new Intent(this,MvvmActivity.class));
    }
}
