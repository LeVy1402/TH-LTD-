package com.example.hoatdongngoaikhoa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login  extends AppCompatActivity {
    Button btn_DangNhap;
    EditText ed_TaiKhoan, ed_MatKhau;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_vy);
        DB = new DBHelper(this);

       anhxa();
        btn_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
              String user = ed_TaiKhoan.getText().toString();
              String pass = ed_MatKhau.getText().toString();

              if(user.equals("")||pass.equals(""))
                  Toast.makeText(Login.this,"Vui lòng điền đầy đủ thông tih.", Toast.LENGTH_SHORT).show();
              else {
                  Boolean checkuserpass = DB.checkUsernamePassword(user, pass);
                  if (checkuserpass==true) {
                      Toast.makeText(Login.this,"Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(Login.this, Dashboard.class);
                      startActivity(intent);
                  } else {
                      Toast.makeText(Login.this,"Tài khoản không hợp lệ..", Toast.LENGTH_SHORT).show();
                  }
              }
           }
        });
    }
    void anhxa() {
        btn_DangNhap = findViewById(R.id.btn_DangNhap1);
        ed_MatKhau =  findViewById(R.id.ed_MatKhau);
        ed_TaiKhoan =  findViewById(R.id.ed_TaiKhoan);
    }

}
