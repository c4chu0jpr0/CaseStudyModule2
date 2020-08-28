package CategoryMain.ModifyPatient;
import IOFile.IOFileID;
import Objects.IP_Compare_TransP;
import Objects.TransferPatient;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ModifyTP {
    private static ModifyTP instance = new ModifyTP();
    public static ModifyTP getInstance(){return instance;}
    ArrayList<TransferPatient> arrTP = new ArrayList<>();
    public static final Scanner scanner= new Scanner(System.in);
    public static IP_Compare_TransP compare_transP= new IP_Compare_TransP();
    public static IOFileID checkID = IOFileID.getInstance();

    public void ReadFind(int id){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/TransferPatient.txt");
            ObjectInputStream dis = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                TransferPatient tp = (TransferPatient) dis.readObject();
                if (tp.getMaHS() == id) {
                    checkInpatient(tp);
                }
                arrTP.add(tp);
            }
            Collections.sort(arrTP,compare_transP);
            WriteTransferPatient(arrTP);
            arrTP.clear();
            dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
    }

    public static void checkInpatient(TransferPatient tp){
        boolean check = true;
        do {
            StartCheckOPatient:{
                System.out.println("1. Sửa Mã hồ sơ");
                System.out.println("2. Sửa Họ và tên");
                System.out.println("3. Sửa Ngày sinh");
                System.out.println("4. Sửa Chuẩn đoán bệnh");
                System.out.println("5. Sửa Ngày chuyển bệnh viện");
                System.out.println("6. Sửa Nơi chuyển tuyển bệnh viện");
                System.out.println("7. Lưu trữ và Quay lại");
                System.out.print("Input number: ");
                String choice = scanner.nextLine();

                switch (choice){
                    case "1":
                        int MHS;
                        do {
                            System.out.print("Nhập mã hồ sơ muốn sửa: ");
                            try {
                                MHS = Integer.parseInt(scanner.nextLine());
                                if (!checkID.ReadTrans(MHS)){
                                    System.out.println("Đã tồn tại mã hồ sơ này!");
                                }
                                if (MHS > 0 && checkID.ReadTrans(MHS)) break;
                            } catch (Exception ignored) {}
                            System.out.println("nhập lại");
                        } while (true);

                        tp.setMaHS(MHS);
                        System.out.println("Sửa Mã hồ sơ thành công!");
                        break;
                    case "2":
                        String nameTrans;
                        do {
                            System.out.print("Sửa họ và tên(nhập exit để thoát): ");
                            try {
                                nameTrans = scanner.nextLine();
                                if(nameTrans.equals("exit")) break;
                                if (!nameTrans.equals("")) break;
                            } catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        } while (true);

                        if (!nameTrans.equals("exit")){tp.setHoTen(nameTrans);
                        System.out.println("Sửa họ và tên thành công!");}
                        break;
                    case "3":
                        String birthdayTrans;
                        do {
                            System.out.print("Sửa ngày sinh(dd/mm/yyyy): ");
                            try {
                                birthdayTrans = scanner.nextLine();
                                String[] strTrans = birthdayTrans.split("/");
                                LocalDate myDateTrans = LocalDate.of(Integer.parseInt(strTrans[2]), Integer.parseInt(strTrans[1]), Integer.parseInt(strTrans[0]));
                                if (!myDateTrans.equals("")) break;
                            } catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        } while (true);

                        tp.setNgaySinh(birthdayTrans);
                        System.out.println("Sửa ngày tháng năm sinh thành công!");
                        break;
                    case "4":
                        String chuanDoanTrans;
                        do {
                            System.out.print("Sửa chuẩn đoán bệnh: ");
                            try {
                                chuanDoanTrans = scanner.nextLine();
                                if(chuanDoanTrans!=null) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        tp.setChuanDoanBenh(chuanDoanTrans);
                        System.out.println("Sửa bệnh án thành công");
                        break;
                    case "5":
                        String ngayTrans;
                        do {
                            System.out.println("Sửa ngày chuyển(dd/mm/yyyy): ");
                            try {
                                ngayTrans = scanner.nextLine();
                                String[] strTransD= ngayTrans.split("/");
                                LocalDate myTD = LocalDate.of(Integer.parseInt(strTransD[2]), Integer.parseInt(strTransD[1]), Integer.parseInt(strTransD[0]));
                                if (!myTD.equals("")) break;
                            }catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        }while (true);

                        tp.setNgayChuyen(ngayTrans);
                        System.out.println("SỬa ngày chuyển tuyến thành công");
                        break;
                    case "6":
                        String noiTrans;
                        do {
                            System.out.println("sửa nơi chuyển tuyến bệnh viện: ");
                            try{
                                noiTrans = scanner.nextLine();
                                if(!noiTrans.equals(""))break ;
                            }catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        }while (true);

                        tp.setNoiChuyen(noiTrans);
                        System.out.println("Sửa nơi chuyển bệnh viện của bệnh nhân thành công");
                        break;
                    case "7":
                        check= false;
                        break;
                    default:
                        break StartCheckOPatient;
                }
            }
        }while (check);
    }


    public static void WriteTransferPatient(ArrayList<TransferPatient> arr){
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
}
