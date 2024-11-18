package izisluu.fpoly.librarymanagerment.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Library.db";
    public static final int DB_VERSION = 4;
    public static final String TABLE_USER = "user";
    public static final String COLLUM_USER_ID = "id";
    public static final String COLLUM_USER_NAME = "name";
    public static final String COLLUM_USER_USERNAME = "username";
    public static final String COLLUM_USER_PASSWORD = "password";
    public static final String COLLUM_USER_EMAIL = "email";
    public static final String COLLUM_USER_ROLE = "role";
    public static final String TABLE_PHIEUMUON = "phieumuon";
    public static final String TABLE_SACH = "sach";
    public static final String COLLUM_PHIEUMUON_MAPHIEU = "maPhieu";
    public static final String COLLUM_PHIEUMUON_MASACH = "maSach";
    public static final String COLLUM_PHIEUMUON_NGUOIMUON = "nguoiMuon";
    public static final String COLLUM_PHIEUMUON_NGAYMUON = "ngayMuon";
    public static final String COLLUM_PHIEUMUON_NGAYTRA = "ngayTra";
    public static final String COLLUM_PHIEUMUON_GIATIEN = "giaTien";
    public static final String COLLUM_SACH_LOAISACH = "loaiSach";
    public static final String COLLUM_SACH_TENSACH = "tenSach";
    public static final String COLLUM_SACH_SOLUONG = "soLuong";


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_USER + "(" +
                COLLUM_USER_ID + " TEXT PRIMARY KEY," +
                COLLUM_USER_NAME + " TEXT," +
                COLLUM_USER_USERNAME + " TEXT," +
                COLLUM_USER_PASSWORD + " TEXT," +
                COLLUM_USER_EMAIL + " TEXT," +
                COLLUM_USER_ROLE + " TEXT )";
        db.execSQL(sql);
        String insertAdmin = "INSERT INTO " + TABLE_USER + " (" +
                COLLUM_USER_ID + ", " +
                COLLUM_USER_NAME + ", " +
                COLLUM_USER_USERNAME + ", " +
                COLLUM_USER_PASSWORD + ", " +
                COLLUM_USER_EMAIL + ", " +
                COLLUM_USER_ROLE + ") VALUES (" +
                "'1', 'Admin User', 'admin', 'admin123', 'admin@example.com', '1')";
        db.execSQL(insertAdmin);
        String insertMember = "INSERT INTO " + TABLE_USER + " (" +
                COLLUM_USER_ID + ", " +
                COLLUM_USER_NAME + ", " +
                COLLUM_USER_USERNAME + ", " +
                COLLUM_USER_PASSWORD + ", " +
                COLLUM_USER_EMAIL + ", " +
                COLLUM_USER_ROLE + ") VALUES (" +
                "'2', 'Member', 'hpluu', '123', 'member@example.com', '0')";
        db.execSQL(insertMember);
        String sql3 = "CREATE TABLE " + TABLE_PHIEUMUON + "(" +
                COLLUM_PHIEUMUON_MAPHIEU + " TEXT PRIMARY KEY," +
                COLLUM_PHIEUMUON_MASACH + " TEXT," +
                COLLUM_PHIEUMUON_NGUOIMUON + " TEXT," +
                COLLUM_PHIEUMUON_NGAYMUON + " TEXT," +
                COLLUM_PHIEUMUON_NGAYTRA + " TEXT," +
                COLLUM_PHIEUMUON_GIATIEN + " TEXT )";
        db.execSQL(sql3);
        String sql4 = "CREATE TABLE " + TABLE_SACH + "(" +
                COLLUM_SACH_LOAISACH + " TEXT PRIMARY KEY," +
                COLLUM_SACH_TENSACH + " TEXT," +
                COLLUM_SACH_SOLUONG + " TEXT )";
        db.execSQL(sql4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHIEUMUON);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SACH);
            onCreate(db);
        }
    }
}
