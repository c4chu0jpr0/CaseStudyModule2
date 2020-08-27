package Objects;

import java.io.Serializable;
import java.util.Comparator;

public class Inpatient implements Serializable{
    private int MaHS;
    private String HoTen;
    private String NgaySinh;
    private String NgayNhapVien;
    private String NgayRaVien;
    private String ChuanDoanBenh;
    private String TenKhoa;
    private int SoGiuong;

    public Inpatient(int maHS, String hoTen, String ngaySinh, String ngayNhapVien, String ngayRaVien, String chuanDoanBenh, String tenKhoa, int soGiuong) {
        this.MaHS = maHS;
        this.HoTen = hoTen;
        this.NgaySinh = ngaySinh;
        this.NgayNhapVien = ngayNhapVien;
        this.NgayRaVien = ngayRaVien;
        this.ChuanDoanBenh = chuanDoanBenh;
        this.TenKhoa = tenKhoa;
        this.SoGiuong = soGiuong;
    }

    public int getMaHS() {
        return MaHS;
    }

    public void setMaHS(int maHS) {
        MaHS = maHS;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getNgayNhapVien() {
        return NgayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        NgayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return NgayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        NgayRaVien = ngayRaVien;
    }

    public String getChuanDoanBenh() {
        return ChuanDoanBenh;
    }

    public void setChuanDoanBenh(String chuanDoanBenh) {
        ChuanDoanBenh = chuanDoanBenh;
    }

    public String getTenKhoa() {
        return TenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        TenKhoa = tenKhoa;
    }

    public int getSoGiuong() {
        return SoGiuong;
    }

    public void setSoGiuong(int soGiuong) {
        SoGiuong = soGiuong;
    }

    @Override
    public String toString() {
        return "Inpatient: " +
                "MaHS: " + MaHS +
                " HoTen: '" + HoTen + '\'' +
                " NgaySinh: '" + NgaySinh + '\'' +
                " NgayNhapVien: '" + NgayNhapVien + '\'' +
                " NgayRaVien: '" + NgayRaVien + '\'' +
                " ChuanDoanBenh: '" + ChuanDoanBenh + '\'' +
                " TenKhoa: '" + TenKhoa + '\'' +
                " SoGiuong: " + SoGiuong;
    }

}
