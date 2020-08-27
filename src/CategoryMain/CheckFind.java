package CategoryMain;

import Objects.Inpatient;
import Objects.Outpatient;
import Objects.TransferPatient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class CheckFind {
    private static CheckFind instance = new CheckFind();
    public static CheckFind getInstance(){return instance;}
    public static final Scanner scanner = new Scanner(System.in);
    public void CheckFind(){
        boolean check = true;
        do {
            StartFind:{
                System.out.println("1. Tìm kiếm danh sách bệnh nhân nội trú");
                System.out.println("2. Tìm kiếm danh sách bệnh nhân ngoại trú");
                System.out.println("3. Tìm kiếm danh sách bệnh nhân chuyển tuyến");
                System.out.println("4. Quay lại");
                System.out.print("Nhập số: ");
                String choice= scanner.nextLine();
                switch (choice){
                    case "1":
                        String name;
                        do{
                            System.out.print("Nhập Họ và tên bệnh nhân nội trú: ");
                            try {
                                name = scanner.nextLine();
                                if (!name.equals("")) break;
                            }catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        }while (true);

                        ReadFind(name,"Inpatient");
                        break;
                    case "2":
                        String nameOut;
                        do {
                            System.out.print("Nhập họ và tên bệnh nhân ngoại trú: ");
                            try{
                                nameOut= scanner.nextLine();
                                if (!nameOut.equals("")) break;
                            }catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        }while (true);

                        ReadFind(nameOut,"Outpatient");
                        break;
                    case "3":
                        String nameTrans;
                        do {
                            System.out.print("Nhập họ và tên bệnh nhân chuyển tuyến: ");
                            try{
                                nameTrans= scanner.nextLine();
                                if (!nameTrans.equals("")) break;
                            }catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        }while (true);

                        ReadFind(nameTrans,"TransferPatient");
                        break;
                    case "4":
                        check= false;
                        break;
                    default:
                        break StartFind;
                }
            }
        }while (check);
    }
    public static void ReadFind(String name,String file){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/"+file+".txt");
            ObjectInputStream dis = new ObjectInputStream(fi);

            if(file.equals("Inpatient")){
                while (fi.available() > 0) {
                    Inpatient ip = (Inpatient) dis.readObject();
                    if (ip.getHoTen().equals(name)) {
                        System.out.println(ip);
                    }
                }
            }else if (file.equals("Outpatient")){
                while (fi.available() > 0) {
                    Outpatient op = (Outpatient) dis.readObject();
                    if (op.getHoTen().equals(name)){
                        System.out.println(op);
                    }
                }
            }else if (file.equals("TransferPatient")){
                while (fi.available() > 0) {
                    TransferPatient tp = (TransferPatient) dis.readObject();
                    if (tp.getHoTen().equals(name)){
                        System.out.println(tp);
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
