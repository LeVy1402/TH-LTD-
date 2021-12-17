package com.example.hoatdongngoaikhoa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    Button btn_DangKy;
    EditText ed_TaiKhoan, ed_MatKhau, ed_NhapLai;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        DB = new DBHelper(this);

        anhxa();
        btn_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = ed_TaiKhoan.getText().toString();
                String pass = ed_MatKhau.getText().toString();
                String repass = ed_NhapLai.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(Register.this,"Vui lòng điền đầy đủ thông tih.", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)) {
                        Boolean checkuser = DB.checkUsername(user);
                        if (checkuser==false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(Register.this,"Đăng ký thành công.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this, Login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Register.this,"Tài khoản không hợp lệ.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Register.this,"Tài khoản đã tồn tại.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register.this,"Mật khẩu không giống.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    void anhxa() {
        btn_DangKy = findViewById(R.id.btn_DangKy);
        ed_MatKhau =  findViewById(R.id.ed_MatKhau);
        ed_TaiKhoan =  findViewById(R.id.ed_TaiKhoan);
        ed_NhapLai =  findViewById(R.id.ed_Nhaplai);
    }
}
