package Objects;

import java.io.Serializable;
import java.util.Comparator;

public class TransferPatient implements Serializable {
    private int MaHS;
    private String HoTen;
    private String NgaySinh;
    private String ChuanDoanBenh;
    private String NgayChuyen;
    private String NoiChuyen;

    public TransferPatient(int maHS, String hoTen, String ngaySinh, String chuanDoanBenh, String ngayChuyen, String noiChuyen) {
        MaHS = maHS;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        ChuanDoanBenh = chuanDoanBenh;
        NgayChuyen = ngayChuyen;
        NoiChuyen = noiChuyen;
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

    public String getChuanDoanBenh() {
        return ChuanDoanBenh;
    }

    public void setChuanDoanBenh(String chuanDoanBenh) {
        ChuanDoanBenh = chuanDoanBenh;
    }

    public String getNgayChuyen() {
        return NgayChuyen;
    }

    public void setNgayChuyen(String ngayChuyen) {
        NgayChuyen = ngayChuyen;
    }

    public String getNoiChuyen() {
        return NoiChuyen;
    }

    public void setNoiChuyen(String noiChuyen) {
        NoiChuyen = noiChuyen;
    }

    @Override
    public String toString() {
        return "TransferPatient: " +
                "MaHS: " + MaHS +
                " HoTen: '" + HoTen + '\'' +
                " NgaySinh: '" + NgaySinh + '\'' +
                " ChuanDoanBenh: '" + ChuanDoanBenh + '\'' +
                " NgayChuyen: '" + NgayChuyen + '\'' +
                " NoiChuyen: '" + NoiChuyen + '\'' +"\n";
    }


}
