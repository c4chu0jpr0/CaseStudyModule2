package Objects;

import java.io.Serializable;
import java.util.Comparator;

public class Outpatient implements Serializable {
    private int MaHS;
    private String HoTen;
    private String NgaySinh;
    private String NgayKham;
    private String ChuanDoanBenh;
    private String SoBaoHiem;
    private int MaToaThuoc;

    public Outpatient(int maHS, String hoTen, String ngaySinh, String ngayKham, String chuanDoanBenh, String soBaoHiem, int maToaThuoc) {
        MaHS = maHS;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        NgayKham = ngayKham;
        ChuanDoanBenh = chuanDoanBenh;
        SoBaoHiem = soBaoHiem;
        MaToaThuoc = maToaThuoc;
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

    public String getNgayKham() {
        return NgayKham;
    }

    public void setNgayKham(String ngayKham) {
        NgayKham = ngayKham;
    }

    public String getChuanDoanBenh() {
        return ChuanDoanBenh;
    }

    public void setChuanDoanBenh(String chuanDoanBenh) {
        ChuanDoanBenh = chuanDoanBenh;
    }

    public String getSoBaoHiem() {
        return SoBaoHiem;
    }

    public void setSoBaoHiem(String soBaoHiem) {
        SoBaoHiem = soBaoHiem;
    }

    public int getMaToaThuoc() {
        return MaToaThuoc;
    }

    public void setMaToaThuoc(int maToaThuoc) {
        MaToaThuoc = maToaThuoc;
    }

    @Override
    public String toString() {
        return "Outpatient: " +
                "MaHS: " + MaHS +
                " HoTen: '" + HoTen + '\'' +
                " NgaySinh: '" + NgaySinh + '\'' +
                " NgayKham: '" + NgayKham + '\'' +
                " ChuanDoanBenh: '" + ChuanDoanBenh + '\'' +
                " SoBaoHiem: '" + SoBaoHiem + '\'' +
                " MaToaThuoc: " + MaToaThuoc;
    }

}
