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
                while (fi.available()>0) {
                    Inpatient obj = (Inpatient) dis.readObject();
                    System.out.println(obj);
                }
            }
            else if ("Outpatient".equals(name)){
                while (fi.available()>0) {
                    Outpatient obj = (Outpatient) dis.readObject();
                    System.out.println(obj);
                }
            }
            else if ("TransferPatient".equals(name)){
                while (fi.available()>0) {
                    TransferPatient obj = (TransferPatient) dis.readObject();
                    System.out.println(obj);
                }
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
