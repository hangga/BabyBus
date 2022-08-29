package io.github.hangga.babybus;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BabyBus {
    BabyObserver observer;
    Class<?> cls;
    Intent intent;
    BabyResult babyResult;

    private BabyBus() {
    }

    public BabyBus(AppCompatActivity activity, Intent intent, BabyResult babyResult) {
        if (activity != null) {
            observer = new BabyObserver(activity);
            observer.setBabyResult(babyResult);
            this.intent = intent;
            this.babyResult = babyResult;
            activity.getLifecycle().addObserver(observer);
        }
    }

    public BabyBus(AppCompatActivity activity, Class<?> cls, BabyResult babyResult) {
        if (activity != null) {
            observer = new BabyObserver(activity);
            observer.setBabyResult(babyResult);
            this.cls = cls;
            this.babyResult = babyResult;
            activity.getLifecycle().addObserver(observer);
        }
    }

    public BabyBus(Fragment fragment, Class<?> cls, BabyResult babyResult) {
        if (fragment != null) {
            observer = new BabyObserver(fragment);
            observer.setBabyResult(babyResult);
            this.cls = cls;
            this.babyResult = babyResult;
            fragment.getLifecycle().addObserver(observer);
        }
    }

    public BabyBus(AppCompatActivity activity) {

        if (activity != null) {
            observer = new BabyObserver(activity);
            activity.getLifecycle().addObserver(observer);
        }
    }

    public BabyBus(Fragment fragment) {
        if (fragment != null) {
            observer = new BabyObserver(fragment);
            fragment.getLifecycle().addObserver(observer);
        }
    }

    public static BabyBus create() {
        return new BabyBus();
    }

    public BabyBus setOrigin(AppCompatActivity activity) {
        observer = new BabyObserver(activity);
        activity.getLifecycle().addObserver(observer);
        return this;
    }

    public BabyBus setDestination(Class<?> cls) {
        this.cls = cls;
        return this;
    }

    public BabyBus setResult(BabyResult babyResult) {
        this.babyResult = babyResult;
        observer.setBabyResult(babyResult);
        return this;
    }

    public BabyBus setIntent(Intent intent) {
        this.intent = intent;
        return this;
    }

    public void start() {
        if (cls != null) {
            observer.startIntent(cls, babyResult);
        } else if (intent != null) {
            observer.startIntent(intent, babyResult);
        }
    }

    public void startActivityForResult(Class<?> cls, BabyResult babyResult) {
        observer.startIntent(cls, babyResult);
    }

    public void startIntent(Intent intent, BabyResult babyResult) {
        observer.startIntent(intent, babyResult);
    }
}
