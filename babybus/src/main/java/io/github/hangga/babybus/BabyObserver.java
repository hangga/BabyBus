package io.github.hangga.babybus;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public class BabyObserver implements DefaultLifecycleObserver {

    BabyResult babyResult;
    private ActivityResultRegistry registry;
    private Activity activity = null;
    ActivityResultCallback<ActivityResult> callback = new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            babyResult.onActivityResult(result.getResultCode(), result.getData());
        }
    };
    private ActivityResultLauncher<Intent> intentLauncher;

    public BabyObserver(AppCompatActivity activity) {
        Log.d("BABY","CEK-CREATE-YAK:0 | " + System.currentTimeMillis());
        this.activity = activity;
        this.registry = activity.getActivityResultRegistry();
    }

    public BabyObserver(Fragment fragment) {
        try {
            this.activity = fragment.getActivity();
            this.registry = fragment.getActivity().getActivityResultRegistry();
        } catch (Exception e) {
            if (this.activity == null) {
                this.activity = fragment.getActivity();
            }
        }
    }

    public void setBabyResult(BabyResult babyResult) {
        this.babyResult = babyResult;
        Log.d("BABY","CEK-CREATE-YAK:0-B | " + System.currentTimeMillis());
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.d("BABY","CEK-CREATE-YAK:1 | " + System.currentTimeMillis());
        DefaultLifecycleObserver.super.onCreate(owner);
        intentLauncher = registry.register("babykey", owner,
                new ActivityResultContracts.StartActivityForResult(),
                callback
        );
    }

    public void startIntent(Class<?> cls, BabyResult babyResult) {
        this.babyResult = babyResult;
        Intent intent = new Intent(activity, cls);
        intentLauncher.launch(intent);
    }

    public void startIntent(Intent intent, BabyResult babyResult) {
        this.babyResult = babyResult;
        intentLauncher.launch(intent);
    }

    /*@Override
    public void onActivityResult(int resultCode, Intent data) {

    }*/
}
