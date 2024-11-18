package izisluu.fpoly.librarymanagerment.Model;

public class Sach {
    private String loaiSach,tenSach,soLuong;

    public Sach(String loaiSach, String tenSach, String soLuong) {
        this.loaiSach = loaiSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
    }
    public Sach(){}
    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }
}
