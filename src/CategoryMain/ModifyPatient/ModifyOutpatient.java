package CategoryMain.ModifyPatient;

import Objects.Inpatient;
import Objects.Outpatient;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ModifyOutpatient {
    private static ModifyOutpatient instance = new ModifyOutpatient();
    public static ModifyOutpatient getInstance(){return instance;}
    public static final Scanner scanner= new Scanner(System.in);
    ArrayList<Outpatient> arrOP= new ArrayList<>();

    public static void checkInpatient(Outpatient op){
        boolean check = true;
        do {
            StartCheckOPatient:{
                System.out.println("1. Sửa Mã hồ sơ");
                System.out.println("2. Sửa Họ và tên");
                System.out.println("3. Sửa Ngày sinh");
                System.out.println("4. Sửa Ngày khám bệnh");
                System.out.println("5. Sửa Chuẩn đoán bệnh");
                System.out.println("6. Sửa Sổ bảo hiểm ");
                System.out.println("7. Sửa Mã toa thuốc");
                System.out.println("8. Save and Back");
                System.out.print("Input number: ");
                String choice = scanner.nextLine();

                switch (choice){
                    case "1":
                        int MHS;
                        do {
                            System.out.print("Nhập mã hồ sơ muốn sửa: ");
                            try {
                                MHS = Integer.parseInt(scanner.nextLine());
                                if (MHS > 0) break;
                            } catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        } while (true);

                        op.setMaHS(MHS);
                        break;
                    case "2":
                        String nameOut;
                        do {
                            System.out.print("Sửa Họ Tên: ");
                            try {
                                nameOut = scanner.nextLine();
                                if (!nameOut.equals("")) break;
                            } catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        } while (true);

                        op.setHoTen(nameOut);
                        break;
                    case "3":
                        String birthdayOut;
                        do {
                            System.out.print("sửa ngày sinh(dd/mm/yyyy): ");
                            try {
                                birthdayOut = scanner.nextLine();
                                String[] strBOut = birthdayOut.split("/");
                                LocalDate myDateOut = LocalDate.of(Integer.parseInt(strBOut[2]), Integer.parseInt(strBOut[1]), Integer.parseInt(strBOut[0]));
                                if (!myDateOut.equals("")) break;
                            } catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        } while (true);

                        op.setNgaySinh(birthdayOut);
                        break;
                    case "4":
                        String ngayKhamOut;
                        do {
                            System.out.print("Sửa ngày khám(dd/mm/yyyy): ");
                            try {
                                ngayKhamOut = scanner.nextLine();
                                String[] strOut = ngayKhamOut.split("/");
                                LocalDate myOut = LocalDate.of(Integer.parseInt(strOut[2]), Integer.parseInt(strOut[1]), Integer.parseInt(strOut[0]));
                                if (!myOut.equals("")) break;
                            } catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        } while (true);

                        op.setNgayKham(ngayKhamOut);
                        break;
                    case "5":
                        String chuanDoanBenhOut;
                        do {
                            System.out.print("Sửa chuẩn đoán bệnh: ");
                            try {
                                chuanDoanBenhOut = scanner.nextLine();
                                if(chuanDoanBenhOut!=null) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        op.setChuanDoanBenh(chuanDoanBenhOut);
                        break;
                    case "6":
                        String Sobaohiem;
                        do {
                            System.out.print("Sửa số sổ bảo hiểm: ");
                            try {
                                Sobaohiem = scanner.nextLine();
                                if (Sobaohiem!=null) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        op.setSoBaoHiem(Sobaohiem);
                        break;
                    case "7":
                        int idthuoc;
                        do {
                            System.out.print("Sửa mã Toa thuốc: ");
                            try {
                                idthuoc = Integer.parseInt(scanner.nextLine());
                                if (idthuoc>0) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        op.setMaToaThuoc(idthuoc);
                        break;
                    case "8":
                        check= false;
                        break;
                    default:
                        break StartCheckOPatient;
                }
            }
        }while (check);
    }

    public void ReadFind(int id){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/Outpatient.txt");
            ObjectInputStream dis = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                Outpatient op = (Outpatient) dis.readObject();
                if (op.getMaHS() == id) {
                    checkInpatient(op);
                }
                arrOP.add(op);
            }
            WriteOutpatient(arrOP);
            dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
    }

    public static void WriteOutpatient(ArrayList<Outpatient> arr){
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
}
