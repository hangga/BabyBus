package id.web.hangga.babybus;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ModalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modal);

        EditText edtNama = findViewById(R.id.edtNama);
        EditText edtAlamat = findViewById(R.id.edtAlamat);
        EditText edtTelp = findViewById(R.id.edtTelp);

        findViewById(R.id.btnSubmit).setOnClickListener(view -> {
            Intent intent = getIntent();
            intent.putExtra("nama", edtNama.getText().toString());
            intent.putExtra("alamat", edtAlamat.getText().toString());
            intent.putExtra("phone", edtTelp.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}