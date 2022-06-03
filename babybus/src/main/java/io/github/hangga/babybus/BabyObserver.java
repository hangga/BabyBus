package io.github.hangga.babybus;

import android.app.Activity;
import android.content.Intent;
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

    private ActivityResultRegistry registry;
    private Activity activity = null;
    Listener listener;
    ActivityResultCallback<ActivityResult> callback = new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            listener.onActivityResult(result.getResultCode(), result.getData());
        }
    };
    private ActivityResultLauncher<Intent> intentLauncher;

    public BabyObserver(AppCompatActivity activity) {
        this.activity = activity;
        this.registry = activity.getActivityResultRegistry();
    }

    public BabyObserver(Fragment fragment) {
        try{
            this.activity = fragment.requireActivity();
            this.registry = fragment.requireActivity().getActivityResultRegistry();
        }catch (Exception e){
            if (this.activity == null){
                this.activity = fragment.getActivity();
            }
        }
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onCreate(owner);
        intentLauncher = registry.register("babykey", owner, new ActivityResultContracts.StartActivityForResult(), callback);
    }

    public void startIntent(Class<?> cls, Listener listener) {
        this.listener = listener;
        Intent intent = new Intent(activity, cls);
        intentLauncher.launch(intent);
    }

    public void startIntent(Intent intent, Listener listener) {
        this.listener = listener;
        intentLauncher.launch(intent);
    }
}
