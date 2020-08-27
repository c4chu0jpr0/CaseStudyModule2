import CategoryMain.*;
import Interface.IService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CategoryMenu categoryMenu= CategoryMenu.getInstance();
        IService iService = IService.getInstance();
        String choice;

        do {
            StartApp:{
                categoryMenu.Menu();
                choice= scanner.nextLine();
                switch (choice){
                    case "1":
                        iService.add();
                        break;
                    case "2":
                        iService.modify();
                        break;
                    case "3":
                        iService.delete();
                        break;
                    case "4":
                        iService.showList();
                        break;
                    case "5":
                        iService.find();
                        break;
                    case "6":
                        iService.showListH();
                        break;
                    case "0":
                        System.exit(0);
                    default:
                        break StartApp;
                }
            }
        }while (true);
    }
}
