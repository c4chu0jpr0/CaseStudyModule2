package CategoryMain;

import Objects.Inpatient;
import Objects.Outpatient;
import Objects.TransferPatient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class CheckHS {
    private static CheckHS instance = new CheckHS();
    public static CheckHS getInstan(){return instance; }
    public static final Scanner scanner = new Scanner(System.in);

    public void checkHS(){
        boolean check = true;
        do {
            StartHS:{
                System.out.println("1. Kiểm tra hồ sơ bệnh án");
                System.out.println("2. Quay lại");
                System.out.print("Nhập lựa chọn: ");
                String choice= scanner.nextLine();

                switch (choice){
                    case "1":
                        String idHS;
                        do {
                            System.out.print("Nhập bệnh án: ");
                            try {
                                idHS= scanner.nextLine();
                                if (!idHS.equals("")) break;
                            }catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        }while (true);

                        System.out.printf("%-28s %s"," ","Hồ sơ bệnh án");
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.printf("%-25s %-8s %-18s %-15s %-10s","Bệnh nhân nội tuyến","MãHS","Họ và Tên","Ngày sinh","Bệnh án");
                        System.out.println("");
                        readFile(idHS,"Inpatient");
                        readFile(idHS,"Outpatient");
                        readFile(idHS,"TransferPatient");
                        System.out.println("-----------------------------------------------------------------------------");

                        break;
                    case "2":
                        check= false;
                        break;
                }

            }
        }while (check);
    }

    public static void readFile(String IdHS,String file){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/"+file+".txt");
            ObjectInputStream dis = new ObjectInputStream(fi);

            if(file.equals("Inpatient")){
                while (fi.available() > 0) {
                    Inpatient ip = (Inpatient) dis.readObject();
                    if (ip.getChuanDoanBenh().equals(IdHS)) {
                        System.out.printf("%-25s %-8s %-18s %-15s %-10s","Bệnh nhân nội tuyến",ip.getMaHS(),ip.getHoTen(),ip.getNgaySinh(),ip.getChuanDoanBenh());
                        System.out.println("");
                    }
                }
            }else if (file.equals("Outpatient")){
                while (fi.available() > 0) {
                    Outpatient op = (Outpatient) dis.readObject();
                    if (op.getChuanDoanBenh().equals(IdHS)){
                        System.out.printf("%-25s %-8s %-18s %-15s %-10s","bệnh nhân ngoại tuyến: ",op.getMaHS(),op.getHoTen(),op.getNgaySinh(),op.getChuanDoanBenh());
                        System.out.println("");
                    }
                }
            }else if (file.equals("TransferPatient")){
                while (fi.available() > 0) {
                    TransferPatient tp = (TransferPatient) dis.readObject();
                    if (tp.getChuanDoanBenh().equals(IdHS)){
                        System.out.printf("%-25s %-8s %-18s %-15s %-10s","Bệnh nhân chuyển tuyến: ",tp.getMaHS(),tp.getHoTen(),tp.getNgaySinh(),tp.getChuanDoanBenh());
                        System.out.println("");
                    }
                }
            }
            dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
    }
}
