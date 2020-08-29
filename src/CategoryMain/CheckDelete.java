package CategoryMain;

import Objects.Inpatient;
import Objects.Outpatient;
import Objects.TransferPatient;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckDelete {
    private static CheckDelete instance = new CheckDelete();
    public static CheckDelete getInstance(){return instance; }
    private static final Scanner scanner = new Scanner(System.in);
    public static ArrayList<Inpatient> arrIn= new ArrayList<>();
    public static ArrayList<Outpatient> arrOut = new ArrayList<>();
    public static ArrayList<TransferPatient> arrTran= new ArrayList<>();
    public void checkDelete(){
        boolean check= true;
        do {
            StartDelete:{
                System.out.println("1. Xóa bệnh nhân trong Danh sách nội trú");
                System.out.println("2. Xóa bệnh nhân trong Danh sách ngoại trú");
                System.out.println("3. Xóa bệnh nhân trong Danh sách bệnh nhân chuyển tuyến");
                System.out.println("4. Quay lại");
                System.out.print("Nhập số: ");
                String choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        int idIP;
                        do{
                            System.out.print("Mã hồ sơ (nhấn phím 0 để quay lại): ");
                            try {
                                idIP =Integer.parseInt(scanner.nextLine());
                                if(idIP>0 || idIP==0) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        if (idIP != 0) ReadFind(idIP, "Inpatient");
                        break;
                    case "2":
                        int idOP;
                        do{
                            System.out.print("Mã hồ sơ (nhấn phím 0 để quay lại): ");
                            try {
                                idOP =Integer.parseInt(scanner.nextLine());
                                if(idOP>0 || idOP==0) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        if (idOP != 0) ReadFind(idOP, "Outpatient");
                        break;
                    case "3":
                        int idTP;
                        do{
                            System.out.print("Mã hồ sơ (nhấn phím 0 để quay lại): ");
                            try {
                                idTP =Integer.parseInt(scanner.nextLine());
                                if(idTP>0 || idTP == 0) break;
                            }catch (Exception ignored){}
                            System.out.println("nhập sai");
                        }while (true);

                        if (idTP != 0) ReadFind(idTP, "TransferPatient");
                        break;
                    case "4":
                        check = false;
                        break;
                    default:
                        break StartDelete;
                }
            }

        }while (check);
    }
    public static void ReadFind(int id,String file){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/"+file+".txt");
            ObjectInputStream dis = new ObjectInputStream(fi);


            if(file.equals("Inpatient")){
                while (fi.available() > 0) {
                    Inpatient ip = (Inpatient) dis.readObject();
                    if (ip.getMaHS() != id){
                        arrIn.add(ip);
                    }
                }
                WriteInpatient(arrIn);
                arrIn.clear();
            }else if (file.equals("Outpatient")){
                while (fi.available() > 0) {
                    Outpatient op = (Outpatient) dis.readObject();
                    if (op.getMaHS() != id){
                        arrOut.add(op);
                    }
                }
                WriteOutpatient(arrOut);
                arrOut.clear();
            }else if (file.equals("TransferPatient")){
                while (fi.available() > 0) {
                    TransferPatient tp = (TransferPatient) dis.readObject();
                    if (tp.getMaHS() != id){
                        arrTran.add(tp);
                    }
                }
                WriteTransferPatient(arrTran);
                arrTran.clear();
            }
            System.out.println("Xóa Thông tin Bệnh nhân thành công");
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
