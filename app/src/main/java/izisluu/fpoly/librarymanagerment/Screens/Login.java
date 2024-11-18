package izisluu.fpoly.librarymanagerment.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import izisluu.fpoly.librarymanagerment.DAO.LibraryDAO;
import izisluu.fpoly.librarymanagerment.R;

public class Login extends AppCompatActivity {
    private EditText edtUsername,edtPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();
            LibraryDAO libraryDAO = new LibraryDAO(this);
            int role = libraryDAO.getRole(username);
            boolean check = libraryDAO.checkLogin(username,password);
            if (check){
                Intent intent = new Intent(Login.this,MainActivity.class);
                intent.putExtra("role",role);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }

        });

    }
}