package izisluu.fpoly.librarymanagerment.Screens;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import izisluu.fpoly.librarymanagerment.Fragment.DoiMatKhau;
import izisluu.fpoly.librarymanagerment.Fragment.QuanLyPhieuMuon;
import izisluu.fpoly.librarymanagerment.Fragment.QuanLySach;
import izisluu.fpoly.librarymanagerment.Fragment.QuanLyThanhVien;
import izisluu.fpoly.librarymanagerment.Fragment.ThongKe;
import izisluu.fpoly.librarymanagerment.R;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        drawerLayout = findViewById(R.id.main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navigationView = findViewById(R.id.navigationView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        int role = getIntent().getIntExtra("role",-1);
        if (role == 1){
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.navigation_admin);
            if (savedInstanceState == null){
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new QuanLyPhieuMuon()).commit();
                navigationView.setCheckedItem(R.id.QLPM);
            }
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.QLPM) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new QuanLyPhieuMuon()).commit();
                    } else if (id == R.id.QLSach) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new QuanLySach()).commit();
                    } else if (id == R.id.ThongKe) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new ThongKe()).commit();
                    } else if (id == R.id.QLTV) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new QuanLyThanhVien()).commit();
                    }
                    drawerLayout.closeDrawers();
                    return true;
                }
            });
        } else if (role == 0) {
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.navigation_member);
            if (savedInstanceState == null){
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new QuanLyPhieuMuon()).commit();
                navigationView.setCheckedItem(R.id.QLPM);
            }
            navigationView.setNavigationItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.QLPM){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new QuanLyPhieuMuon()).commit();
                } else if (id == R.id.DoiMatKhau) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new DoiMatKhau()).commit();
                }
                drawerLayout.closeDrawers();
                return true;
            });
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new QuanLyPhieuMuon()).commit();
                }else if (id == R.id.add){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new QuanLySach()).commit();
                } else if (id == R.id.account) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new QuanLyThanhVien()).commit();
                }
                return false;
            }
        });
    }

}