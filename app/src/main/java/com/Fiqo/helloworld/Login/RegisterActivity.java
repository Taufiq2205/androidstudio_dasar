package com.Fiqo.helloworld.Login;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.Fiqo.helloworld.DashboardActivity;
import com.Fiqo.helloworld.R;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        //setting shared pref
        sharedPreferences = this.getSharedPreferences("Setting", Context.MODE_PRIVATE);
        //checking sudah login apa belum
        boolean isLogin = sharedPreferences.getBoolean("islogin",false);
        if(isLogin){
            startActivity(new Intent(this, DashboardActivity.class));
        }
        Spinner spinner = findViewById(R.id.spinner);
        //menambahkan elemen, items adalah variabel yang menyimpan list
        List<String> items = Arrays.asList("Laki-laki", "Perempuan");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //deklarasi variabel, findViewById : method untuk mencari tampilan
        Button btnsubmit = findViewById(R.id.btn_submit);
        EditText editfullname = findViewById(R.id.txt_fullname);
        EditText editusername = findViewById(R.id.txt_username);
        EditText editemail = findViewById(R.id.txt_email);
        EditText editpassword = findViewById(R.id.txt_pass);
        EditText editPassword1 = findViewById(R.id.txt_confirm);
        EditText edit_tanggal = findViewById(R.id.txt_date);
        EditText finalEdit_tanggal1 = edit_tanggal;
        EditText edit_notelp = findViewById(R.id.txt_notelp);
        EditText edit_alamat = findViewById(R.id.txt_alamat);

        // Deklarasi boolean
        boolean[] isPasswordVisible = {false};
        boolean[] isConfirmPasswordVisible = {false};

        editpassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    // Mendapatkan ikon mata di sebelah kanan editpassword
                    Drawable drawableEnd = editpassword.getCompoundDrawables()[2];
                    if (drawableEnd != null) {
                        // Mendapatkan lebar ikon mata
                        int drawableEndWidth = drawableEnd.getBounds().width();
                        // Memeriksa apakah sentuhan terjadi di area ikon mata
                        if (motionEvent.getRawX() >= (editpassword.getRight() - drawableEndWidth)) {
                            // Mengganti visibilitas password
                            if (isPasswordVisible[0]) {
                                // Jika password terlihat, sembunyikan. dan menyembunyikan text and hide text
                                editpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                                editpassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_lock_24, 0, R.drawable.baseline_visibility_off_24, 0);
                                isPasswordVisible[0] = false;
                            } else {
                                // Jika password tersembunyi, tampilkan
                                editpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                                editpassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_lock_24, 0, R.drawable.baseline_visibility_24, 0);
                                isPasswordVisible[0] = true;
                            }
                            return true;  // Menandakan bahwa event telah diproses
                        }
                    }
                }
                return false;  // Menandakan bahwa event tidak diproses
            }
        });

        editPassword1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    // Mendapatkan ikon mata di sebelah kanan editpassword
                    Drawable drawableEnd = editPassword1.getCompoundDrawables()[2];
                    if (drawableEnd != null) {
                        // Mendapatkan lebar ikon mata
                        int drawableEndWidth = drawableEnd.getBounds().width();
                        // Memeriksa apakah sentuhan terjadi di area ikon mata
                        if (motionEvent.getRawX() >= (editPassword1.getRight() - drawableEndWidth)) {
                            // Mengganti visibilitas password
                            if (isConfirmPasswordVisible[0]) {
                                // Jika password terlihat, sembunyikan
                                editPassword1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                                editPassword1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_lock_24, 0, R.drawable.baseline_visibility_off_24, 0);
                                isConfirmPasswordVisible[0] = false;
                            } else {
                                // Jika password tersembunyi, tampilkan
                                editPassword1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                                editPassword1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_lock_24, 0, R.drawable.baseline_visibility_24, 0);
                                isConfirmPasswordVisible[0] = true;
                            }
                            return true;  // Menandakan bahwa event telah diproses
                        }
                    }
                }
                return false;  // Menandakan bahwa event tidak diproses
            }
        });


        // membuat aksi(event)
        EditText finalEdit_tanggal2 = edit_tanggal;
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = editfullname.getText().toString();
                String username = editusername.getText().toString();
                String email = editemail.getText().toString();
                String password = editpassword.getText().toString();
                String password1 = editPassword1.getText().toString();
                String tanggal = finalEdit_tanggal2.getText().toString();
                String notelp = edit_notelp.getText().toString();
                String alamat = edit_alamat.getText().toString();

                if (fullname.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || password1.isEmpty() ||
                        tanggal.isEmpty() || notelp.isEmpty() || alamat.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show();
                } else {
                    if (!password.equals(password1)) {
                        Toast.makeText(RegisterActivity.this, "Password dan Confirm Password harus sama", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        intent.putExtra("FULLNAME", fullname);
                        intent.putExtra("USERNAME", username);
                        intent.putExtra("EMAIL", email);
                        intent.putExtra("PASSWORD", password);
                        intent.putExtra("TANGGAL", tanggal);
                        intent.putExtra("NOTELP", notelp);
                        intent.putExtra("ALAMAT", alamat);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
        edit_tanggal = findViewById(R.id.txt_date);
        final Calendar calendar = Calendar.getInstance();
// Mengambil nilai dari datepicker
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        EditText finalEdit_tanggal = edit_tanggal;
// Menampilkan tindakan
        edit_tanggal.setOnClickListener(v -> {
            // Pengguna memilih tanggal
            DatePickerDialog dialog = new DatePickerDialog(RegisterActivity.this,
                    // Memanggil nilai yang dipilih
                    (view, year1, month1, dayOfMonth) -> {
                        // Membuat Calendar baru untuk menampung nilai yang dipilih
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(year1, month1, dayOfMonth);

                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                        String formattedDate = dateFormat.format(selectedDate.getTime());

                        // Menampilkan pada EditText
                        finalEdit_tanggal.setText(formattedDate);
                    }, year, month, day);
            // Menampilkan DatePicker
            dialog.show();
        });

    }
}