package CategoryMain;

import CategoryMain.ModifyPatient.ModifyInpatient;
import CategoryMain.ModifyPatient.ModifyOutpatient;
import CategoryMain.ModifyPatient.ModifyTP;

import java.util.Scanner;

public class CheckModify {
    private static CheckModify instance = new CheckModify();
    public static CheckModify getInstance(){return instance;}
    public static final Scanner scanner= new Scanner(System.in);
    ModifyInpatient readFileMI = ModifyInpatient.getInstance();
    ModifyOutpatient readFileMO = ModifyOutpatient.getInstance();
    ModifyTP readFileTP= ModifyTP.getInstance();
    public void CheckModify(){
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        do {
            StartModify:{
                System.out.println("1. Sửa Danh sách bệnh nhân nội trú");
                System.out.println("2. Sửa Danh sách bệnh nhân ngoại trú");
                System.out.println("3. Sửa Danh sách bệnh nhân chuyển tuyến");
                System.out.println("4. Quay lại");
                System.out.print("Input number: ");
                String choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        int id;
                        do {
                            System.out.print("Nhập mã hồ sơ đối tượng muốn sửa: ");
                            try {
                                id = Integer.parseInt(scanner.nextLine());
                                if (id>0) break;
                            }catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        }while (true);

                        readFileMI.ReadFind(id);
                        break;
                    case "2":
                        int idOP;
                        do {
                            System.out.print("Nhập mã hồ sơ đối tượng muốn sửa: ");
                            try {
                                idOP = Integer.parseInt(scanner.nextLine());
                                if (idOP>0) break;
                            }catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        }while (true);

                        readFileMO.ReadFind(idOP);
                        break;
                    case "3":
                        int idTP;
                        do {
                            System.out.print("Nhập mã hồ sơ đối tượng muốn sửa: ");
                            try {
                                idTP = Integer.parseInt(scanner.nextLine());
                                if (idTP>0) break;
                            }catch (Exception ignored) {}
                            System.out.println("nhập sai");
                        }while (true);
                        readFileTP.ReadFind(idTP);
                        break;
                    case "4":
                        check=false;
                        break;
                    default:
                        break StartModify;
                }
            }
        }while (check);
    }

}
