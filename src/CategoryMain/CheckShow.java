package CategoryMain;

import IOFile.IO_File_Inpatient;

import java.util.Scanner;

public class CheckShow {
    private static CheckShow instance= new CheckShow();
    public static CheckShow getInstance(){ return instance; }

    public void readFile(){
        IO_File_Inpatient readfile = IO_File_Inpatient.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean check= true;
        do {
            startRead:{
                System.out.println("1. Danh sách bệnh nhân nội trú");
                System.out.println("2. Danh sach bệnh nhân ngoại trú");
                System.out.println("3. Danh sách bệnh nhân chuyển tuyến");
                System.out.println("4. Trở về");
                System.out.print("Nhập lựa chọn: ");
                String choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        String a= "Inpatient";
                        readfile.ReadObject(a);
                        break;
                    case "2":
                        String b = "Outpatient";
                        readfile.ReadObject(b);
                        break;
                    case "3":
                        String c= "TransferPatient";
                        readfile.ReadObject(c);
                        break;
                    case "4":
                        check= false;
                    default:
                        break startRead;
                }
            }
        }while (check);
    }
}
