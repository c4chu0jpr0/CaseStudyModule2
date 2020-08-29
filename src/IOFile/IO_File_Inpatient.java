package IOFile;

import Objects.Inpatient;
import Objects.Outpatient;
import Objects.TransferPatient;

import java.io.*;
import java.util.ArrayList;

public class IO_File_Inpatient {
    private static IO_File_Inpatient readInpatientFile= new IO_File_Inpatient();
    public static IO_File_Inpatient getInstance(){
        return readInpatientFile;
    }

    public void WriteInpatient(ArrayList<Inpatient> arr){
        String SOURCE = "CaseStudyCG/src/FileSave/Inpatient.txt";
        try{
            FileOutputStream fos = new FileOutputStream(SOURCE, false);
            ObjectOutputStream dos = new ObjectOutputStream(fos);
                for (Inpatient ip : arr) {
                    dos.writeObject(ip);
                }
                dos.close();
                fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteOutpatient(ArrayList<Outpatient> arr){
        String SOURCE = "CaseStudyCG/src/FileSave/Outpatient.txt";

        try{
            FileOutputStream fos= new FileOutputStream(SOURCE, false);
            ObjectOutputStream dos = new ObjectOutputStream(fos);
            for (Outpatient op: arr){
                dos.writeObject(op);
            }
            dos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteTransferPatient(ArrayList<TransferPatient> arr){
        String SOURCE = "CaseStudyCG/src/FileSave/Transferpatient.txt";

        try{
            FileOutputStream fos= new FileOutputStream(SOURCE, false);
            ObjectOutputStream dos = new ObjectOutputStream(fos);
            for (TransferPatient tp: arr){
                dos.writeObject(tp);
            }
            dos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadObject(String name){
        String SOURCE = "CaseStudyCG/src/FileSave/"+name+".txt";
        try{
            FileInputStream fi = new FileInputStream(SOURCE);
            ObjectInputStream dis = new ObjectInputStream(fi);

            if ("Inpatient".equals(name)){
                System.out.printf("%-45s %s"," ","Bệnh nhân nội tuyến");
                System.out.println("");
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-7s %-18s %-13s %-18s %-16s %-21s %-14s %-15s","Mã HS","Họ và Tên","Ngày sinh","Ngày nhập viện","Ngày ra viện","Chuẩn đoán bệnh", "Tên Khoa", "Số Giường");
                System.out.println("");
                while (fi.available()>0) {
                    Inpatient obj = (Inpatient) dis.readObject();
                    System.out.printf("%-7s %-18s %-13s %-18s %-16s %-21s %-14s %-15s",obj.getMaHS(),obj.getHoTen(),obj.getNgaySinh(),obj.getNgayNhapVien(),obj.getNgayRaVien(),obj.getChuanDoanBenh(), obj.getTenKhoa(), obj.getSoGiuong());
                    System.out.println("");
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            }
            else if ("Outpatient".equals(name)){
                System.out.printf("%-38s %s"," ","Bệnh nhân ngoại tuyến");
                System.out.println("");
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.printf("%-7s %-18s %-12s %-12s %-20s %-13s %-9s","Mã HS","Họ và Tên","Ngày sinh","Ngày khám","Chuẩn đoán bệnh", "Sổ bảo hiểm", "Mã toa thuốc");
                System.out.println("");
                while (fi.available()>0) {
                    Outpatient obj = (Outpatient) dis.readObject();
                    System.out.printf("%-7s %-18s %-12s %-12s %-20s %-13s %-9s",obj.getMaHS(),obj.getHoTen(),obj.getNgaySinh(),obj.getNgayKham(),obj.getChuanDoanBenh(), obj.getSoBaoHiem(), obj.getMaToaThuoc());
                    System.out.println("");
                }
                System.out.println("----------------------------------------------------------------------------------------------------");
            }
            else if ("TransferPatient".equals(name)){
                System.out.printf("%-38s %s"," ","Bệnh nhân chuyển tuyến");
                System.out.println("");
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.printf("%-7s %-17s %-13s %-20s %-13s %-9s","Mã HS","Họ và Tên","Ngày sinh","Chuẩn đoán bệnh", "Ngày chuyển", "Nơi chuyển");
                System.out.println("");
                while (fi.available()>0) {
                    TransferPatient obj = (TransferPatient) dis.readObject();
                    System.out.printf("%-7s %-17s %-13s %-20s %-13s %-9s",obj.getMaHS(),obj.getHoTen(),obj.getNgaySinh(),obj.getChuanDoanBenh(),obj.getNgayChuyen(),obj.getNoiChuyen());
                    System.out.println("");
                }
                System.out.println("---------------------------------------------------------------------------------------------------------");
            }
                dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
    }

    // Chức năng hàm add
    public void ReadIn(ArrayList<Inpatient> arrIP){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/Inpatient.txt");
            ObjectInputStream dis = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                Inpatient ip = (Inpatient) dis.readObject();
                arrIP.add(ip);
            }
            dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
    }

    public void ReadOut(ArrayList<Outpatient> arrOP){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/Outpatient.txt");
            ObjectInputStream dis = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                Outpatient op = (Outpatient) dis.readObject();
                arrOP.add(op);
            }
            dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
    }

    public void ReadTrans(ArrayList<TransferPatient> arrTP){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/TransferPatient.txt");
            ObjectInputStream dis = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                TransferPatient tp = (TransferPatient) dis.readObject();
                arrTP.add(tp);
            }
            dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
    }
}
