package io.github.hangga.babybus;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BabyBus {
    BabyObserver observer;

    private BabyBus(){}

    public BabyBus(AppCompatActivity activity){
        observer = new BabyObserver(activity);
        activity.getLifecycle().addObserver(observer);
    }

    public BabyBus(Fragment fragment){
        observer = new BabyObserver(fragment);
        fragment.getLifecycle().addObserver(observer);
    }

    public void startActivityForResult(Class<?> cls, Listener listener){
        observer.startIntent(cls, listener);
    }

    public void startIntent(Intent intent, Listener listener){
        observer.startIntent(intent, listener);
    }
}
