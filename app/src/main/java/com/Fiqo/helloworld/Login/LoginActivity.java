package com.Fiqo.helloworld.Login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.Fiqo.helloworld.DashboardActivity;
import com.Fiqo.helloworld.DataMHSActivity;
import com.Fiqo.helloworld.ListMHSActivity;
import com.Fiqo.helloworld.R;

public class LoginActivity extends AppCompatActivity {

    //deklarasi variabel
    EditText editemail, editpassword;
    private Button button;
    String fullname;
    String username;
    String password;
    String email;
    String tanggal;
    String notelp;
    String alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        EditText edtEmailLogin = findViewById(R.id.txt_email);
        EditText edtPasswordLogin = findViewById(R.id.txt_password);
        Button btnlogin = findViewById(R.id.btn_login);

        //mengambil intent dan nilai
        Bundle extras = getIntent().getExtras();
        fullname = extras.getString("FULLNAME");
        username = extras.getString("USERNAME");
        email = extras.getString("EMAIL");
        password = extras.getString("PASSWORD");
        tanggal = extras.getString("TANGGAL");
        notelp = extras.getString("NOTELP");
        alamat = extras.getString("ALAMAT");

        edtEmailLogin.setText(email);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email = findViewById(R.id.txt_email);
                EditText password = findViewById(R.id.txt_password);

                try {
                    Bundle extras = getIntent().getExtras();
                    String emailVal = (extras != null) ? extras.getString("EMAIL") : "";
                    String passwordVal = (extras != null) ? extras.getString("PASSWORD") : "";
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);

                    if (email.getText().toString().equals(emailVal) && password.getText().toString().equals(passwordVal)) {
                        Toast.makeText(LoginActivity.this, "ANDA BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    } else {
                        new AlertDialog.Builder(LoginActivity.this)
                                .setTitle("ANNOUNCEMENT")
                                .setMessage("YOUR EMAIL OR PASSWORD IS INCORRECT")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .create().show();
                    }
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, "SERVER ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("LoginActivity", "Error showing dialog", e);
                }

                }
        });
    }
}