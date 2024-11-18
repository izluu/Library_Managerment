package izisluu.fpoly.librarymanagerment.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import izisluu.fpoly.librarymanagerment.Database.DBHelper;
import izisluu.fpoly.librarymanagerment.Model.PhieuMuon;
import izisluu.fpoly.librarymanagerment.Model.Sach;
import izisluu.fpoly.librarymanagerment.Model.User;

public class LibraryDAO {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public LibraryDAO(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public ArrayList<User> getAllUser(){
        ArrayList<User> list = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABLE_USER;
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.getCount() >0){
            cursor.moveToFirst();
            do {
                User user = new User();
                user.setId(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_USER_ID)));
                user.setName(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_USER_NAME)));
                user.setUsername(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_USER_USERNAME)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_USER_PASSWORD)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_USER_EMAIL)));
                user.setRole(cursor.getInt(cursor.getColumnIndex(dbHelper.COLLUM_USER_ROLE)));
                list.add(user);
            }while (cursor.moveToNext());

        }
        return list;
    }
    public Boolean addUser(User user){
        ContentValues values = new ContentValues();
        values.put(dbHelper.COLLUM_USER_ID,user.getId());
        values.put(dbHelper.COLLUM_USER_NAME,user.getName());
        values.put(dbHelper.COLLUM_USER_USERNAME,user.getUsername());
        values.put(dbHelper.COLLUM_USER_PASSWORD,user.getPassword());
        values.put(dbHelper.COLLUM_USER_EMAIL,user.getEmail());
        values.put(dbHelper.COLLUM_USER_ROLE,user.getRole());
        long result = db.insert(dbHelper.TABLE_USER,null,values);
        return result != -1;
    }
    public Boolean updateUser(User user){
        ContentValues values = new ContentValues();
        values.put(dbHelper.COLLUM_USER_NAME,user.getName());
        values.put(dbHelper.COLLUM_USER_USERNAME,user.getUsername());
        values.put(dbHelper.COLLUM_USER_PASSWORD,user.getPassword());
        values.put(dbHelper.COLLUM_USER_EMAIL,user.getEmail());
        values.put(dbHelper.COLLUM_USER_ROLE,user.getRole());
        int row = db.update(dbHelper.TABLE_USER,values,dbHelper.COLLUM_USER_ID + "=?",new String[]{user.getId()});
        return row > 0;
    }
    public Boolean deleteUser(String id){
        int row = db.delete(dbHelper.TABLE_USER,dbHelper.COLLUM_USER_ID + "=?",new String[]{id});
        return row > 0;
    }
    @SuppressLint("Range")
    public int getRole(String username){
        int role = -1;
        String sql = "SELECT " + dbHelper.COLLUM_USER_ROLE + " FROM " + dbHelper.TABLE_USER + " WHERE " + dbHelper.COLLUM_USER_USERNAME + " = ?";
        Cursor cursor = db.rawQuery(sql,new String[]{username});
        if(cursor != null && cursor.moveToFirst()){
            role = cursor.getInt(cursor.getColumnIndex(dbHelper.COLLUM_USER_ROLE));
        }
        return role;
    }
    @SuppressLint("Range")
    public ArrayList<Sach> getAllSach(){
        ArrayList<Sach> list = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABLE_SACH;
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.getCount() >0){
            cursor.moveToFirst();
            do {
                Sach sach = new Sach();
                sach.setLoaiSach(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_SACH_LOAISACH)));
                sach.setTenSach(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_SACH_TENSACH)));
                sach.setSoLuong(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_SACH_SOLUONG)));
                list.add(sach);
            }while (cursor.moveToNext());
        }
        return list;
    }
    public Boolean addSach(Sach sach){
        ContentValues values = new ContentValues();
        values.put(dbHelper.COLLUM_SACH_LOAISACH,sach.getLoaiSach());
        values.put(dbHelper.COLLUM_SACH_TENSACH,sach.getTenSach());
        values.put(dbHelper.COLLUM_SACH_SOLUONG,sach.getSoLuong());
        long result = db.insert(dbHelper.TABLE_SACH,null,values);
        return result != -1;
    }
    public Boolean updateSach(Sach sach){
        ContentValues values = new ContentValues();
        values.put(dbHelper.COLLUM_SACH_LOAISACH,sach.getLoaiSach());
        values.put(dbHelper.COLLUM_SACH_TENSACH,sach.getTenSach());
        int row = db.update(dbHelper.TABLE_SACH,values,dbHelper.COLLUM_SACH_LOAISACH + "=?",new String[]{sach.getLoaiSach()});
        return row > 0;
    }
    public Boolean deleteSach(String loaiSach){
        int row = db.delete(dbHelper.TABLE_SACH,dbHelper.COLLUM_SACH_LOAISACH + "=?",new String[]{loaiSach});
        return row > 0;
    }
    @SuppressLint("Range")
    public boolean checkLogin(String username, String password) {
        String sql = "SELECT COUNT(*) FROM " + dbHelper.TABLE_USER +
                " WHERE " + dbHelper.COLLUM_USER_USERNAME + " = ? AND " +
                dbHelper.COLLUM_USER_PASSWORD + " = ?";
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(sql, new String[]{username, password});
            if (cursor != null && cursor.moveToFirst()) {
                int count = cursor.getInt(0);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return false;
    }
    @SuppressLint("Range")
    public ArrayList<PhieuMuon> getAllPhieuMuon(){
        ArrayList<PhieuMuon> list = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABLE_PHIEUMUON;
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.getCount() >0){
            cursor.moveToFirst();
            do {
                PhieuMuon phieuMuon = new PhieuMuon();
                phieuMuon.setMaPhieu(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_PHIEUMUON_MAPHIEU)));
                phieuMuon.setMaSach(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_PHIEUMUON_MASACH)));
                phieuMuon.setNguoiMuon(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_PHIEUMUON_NGUOIMUON)));
                phieuMuon.setNgayMuon(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_PHIEUMUON_NGAYMUON)));
                phieuMuon.setNgayTra(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_PHIEUMUON_NGAYTRA)));
                phieuMuon.setGiaTien(cursor.getString(cursor.getColumnIndex(dbHelper.COLLUM_PHIEUMUON_GIATIEN)));
                list.add(phieuMuon);
            }while (cursor.moveToNext());
        }
        return list;
    }
    public Boolean addPhieuMuon(PhieuMuon phieuMuon) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.COLLUM_PHIEUMUON_MAPHIEU,phieuMuon.getMaPhieu());
        values.put(dbHelper.COLLUM_PHIEUMUON_MASACH,phieuMuon.getMaSach());
        values.put(dbHelper.COLLUM_PHIEUMUON_NGUOIMUON,phieuMuon.getNguoiMuon());
        values.put(dbHelper.COLLUM_PHIEUMUON_NGAYMUON,phieuMuon.getNgayMuon());
        values.put(dbHelper.COLLUM_PHIEUMUON_NGAYTRA,phieuMuon.getNgayTra());
        values.put(dbHelper.COLLUM_PHIEUMUON_GIATIEN,phieuMuon.getGiaTien());
        long result = db.insert(dbHelper.TABLE_PHIEUMUON,null,values);
        return result != -1;
    }
    public Boolean updatePhieuMuon(PhieuMuon phieuMuon){
        ContentValues values = new ContentValues();
        values.put(dbHelper.COLLUM_PHIEUMUON_MAPHIEU,phieuMuon.getMaPhieu());
        values.put(dbHelper.COLLUM_PHIEUMUON_MASACH,phieuMuon.getMaSach());
        values.put(dbHelper.COLLUM_PHIEUMUON_NGUOIMUON,phieuMuon.getNguoiMuon());
        values.put(dbHelper.COLLUM_PHIEUMUON_NGAYMUON,phieuMuon.getNgayMuon());
        values.put(dbHelper.COLLUM_PHIEUMUON_NGAYTRA,phieuMuon.getNgayTra());
        values.put(dbHelper.COLLUM_PHIEUMUON_GIATIEN,phieuMuon.getGiaTien());
        int row = db.update(dbHelper.TABLE_PHIEUMUON,values,dbHelper.COLLUM_PHIEUMUON_MAPHIEU + "=?",new String[]{phieuMuon.getMaPhieu()});
        return row > 0;
    }
    public Boolean deletePhieuMuon(String maPhieu){
        int row = db.delete(dbHelper.TABLE_PHIEUMUON,dbHelper.COLLUM_PHIEUMUON_MAPHIEU + "=?",new String[]{maPhieu});
        return row > 0;
    }




}
