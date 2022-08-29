package id.web.hangga.babybus;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import io.github.hangga.babybus.BabyBus;
import io.github.hangga.babybus.BabyResult;

public class MainActivity extends AppCompatActivity {

    BabyBus babyBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtData = findViewById(R.id.txtData);
        babyBus = new BabyBus(this, ModalActivity.class, new BabyResult() {
            @Override
            public void onActivityResult(int resultCode, Intent data) {
                if (resultCode == RESULT_OK){
                    String nama = data.getStringExtra("nama");
                    String alamat = data.getStringExtra("alamat");
                    String phone = data.getStringExtra("phone");
                    txtData.append(nama + " | ");
                    txtData.append(alamat + " | ");
                    txtData.append(phone);
                }
            }
        });
        //babyBus.start();

        findViewById(R.id.btnPick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                babyBus.start();

                /*babyBus.startActivityForResult(ModalActivity.class, new BabyResult() {
                    @Override
                    public void onActivityResult(int resultCode, Intent data) {
                        if (resultCode == RESULT_OK){
                            String nama = data.getStringExtra("nama");
                            String alamat = data.getStringExtra("alamat");
                            String phone = data.getStringExtra("phone");
                            txtData.append(nama + " | ");
                            txtData.append(alamat + " | ");
                            txtData.append(phone);
                        }
                    }
                });*/
            }
        });
    }
}