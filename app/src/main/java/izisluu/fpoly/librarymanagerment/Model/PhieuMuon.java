package izisluu.fpoly.librarymanagerment.Model;

public class PhieuMuon {
    private String maPhieu,maSach,nguoiMuon,ngayMuon,ngayTra,giaTien;
    public PhieuMuon() {
    }

    public PhieuMuon(String maPhieu, String maSach, String nguoiMuon, String ngayMuon, String ngayTra, String giaTien) {
        this.maPhieu = maPhieu;
        this.maSach = maSach;
        this.nguoiMuon = nguoiMuon;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.giaTien = giaTien;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(String nguoiMuon) {
        this.nguoiMuon = nguoiMuon;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }
}
