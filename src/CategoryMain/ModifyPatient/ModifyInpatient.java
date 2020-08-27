package CategoryMain.ModifyPatient;

import Objects.Inpatient;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ModifyInpatient {
    private static ModifyInpatient instance = new ModifyInpatient();
    public static ModifyInpatient getInstance(){return instance;}
    ArrayList<Inpatient> arrIP= new ArrayList<>();
    public static final Scanner scanner= new Scanner(System.in);

    public static void checkInpatient(Inpatient ip){
        boolean check = true;
        do {
            StartCheckIPatient:{
                System.out.println("1. Sửa Mã hồ sơ");
                System.out.println("2. Sửa Họ và tên");
                System.out.println("3. Sửa Ngày sinh");
                System.out.println("4. Sửa Ngày nhập viện");
                System.out.println("5. Sửa Ngày ra viện");
                System.out.println("6. Sửa Chuẩn đoán bệnh");
                System.out.println("7. Sửa Tên khoa");
                System.out.println("8. Sửa số giường");
                System.out.println("9. Save and Back");
                System.out.print("Input number: ");
                String choice = scanner.nextLine();

                switch (choice){
                    case "1":
                        int MHS;
                        do{
                            System.out.print("Nhập mã muốn sửa: ");
                            try {
                                MHS = Integer.parseInt(scanner.nextLine());
                                if(MHS>0) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        ip.setMaHS(MHS);
                        break;
                    case "2":
                        String name;
                        do {
                            System.out.print("Họ Tên: ");
                            try {
                                name = scanner.nextLine();
                                if (!name.equals("")) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        ip.setHoTen(name);
                        break;
                    case "3":
                        String date;
                        do {
                            System.out.print("Sửa ngày sinh(dd/mm/yyyy): ");
                            try {
                                date = scanner.nextLine();
                                String [] str = date.split("/");
                                LocalDate myDate = LocalDate.of(Integer.parseInt(str[2]),Integer.parseInt(str[1]),Integer.parseInt(str[0]));
                                if (!myDate.equals("")) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        ip.setNgaySinh(date);
                        break;
                    case "4":
                        String inputHospital;
                        do {
                            System.out.print("Sửa Ngày nhập viện(dd/mm/yyyy): ");
                            try{
                                inputHospital = scanner.nextLine();
                                String[] strH= inputHospital.split("/");
                                LocalDate myD = LocalDate.of(Integer.parseInt(strH[2]),Integer.parseInt(strH[1]),Integer.parseInt(strH[0]));
                                if (!myD.equals("")) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        ip.setNgayNhapVien(inputHospital);
                        break;
                    case "5":
                        String outHospital;
                        do {
                            System.out.print("SỬa ngày ra viện(dd/mm/yyyy): ");
                            try {
                                outHospital = scanner.nextLine();
                                String[] strO= outHospital.split("/");
                                LocalDate myO = LocalDate.of(Integer.parseInt(strO[2]),Integer.parseInt(strO[1]),Integer.parseInt(strO[0]));
                                if (!myO.equals("")) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        ip.setNgayRaVien(outHospital);
                        break;
                    case "6":
                        String chuanDoanBenh;
                        do {
                            System.out.print("Sửa Chuẩn đoán bệnh: ");
                            try {
                                chuanDoanBenh = scanner.nextLine();
                                if(chuanDoanBenh!=null) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        ip.setChuanDoanBenh(chuanDoanBenh);
                        break;
                    case "7":
                        String TenKhoa;
                        do {
                            System.out.print("Sửa tên khoa: ");
                            try {
                                TenKhoa = scanner.nextLine();
                                if (TenKhoa!=null) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        ip.setTenKhoa(TenKhoa);
                        break;
                    case "8":
                        int soGiuong;
                        do {
                            System.out.print("Sửa Số giường: ");
                            try {
                                soGiuong = Integer.parseInt(scanner.nextLine());
                                if (soGiuong>0) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        ip.setSoGiuong(soGiuong);
                        break;
                    case "9":
                        check= false;
                        break;
                    default:
                        break StartCheckIPatient;

                }
            }
        }while (check);
    }


    public void ReadFind(int id){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/Inpatient.txt");
            ObjectInputStream dis = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                Inpatient ip = (Inpatient) dis.readObject();
                if (ip.getMaHS() == id) {
                    checkInpatient(ip);
                }
                arrIP.add(ip);
            }
            WriteInpatient(arrIP);
            dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
    }

    public static void WriteInpatient(ArrayList<Inpatient> arr){
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
}
