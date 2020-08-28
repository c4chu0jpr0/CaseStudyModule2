package IOFile;

import Objects.Inpatient;
import Objects.Outpatient;
import Objects.TransferPatient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class IOFileID {
    private static IOFileID instance = new IOFileID();
    public static IOFileID getInstance(){return instance;}


    public boolean ReadIn(int id) {
        try {
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/Inpatient.txt");
            ObjectInputStream dis = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                Inpatient ip = (Inpatient) dis.readObject();
                if (ip.getMaHS() == id){
                    return false;
                }
            }
            dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
        return true;
    }

    public boolean ReadOut(int id){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/Outpatient.txt");
            ObjectInputStream dis = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                Outpatient op = (Outpatient) dis.readObject();
                if(op.getMaHS() == id){
                    return false;
                }
            }
            dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
        return true;
    }

    public boolean ReadTrans(int id){
        try{
            FileInputStream fi = new FileInputStream("CaseStudyCG/src/FileSave/TransferPatient.txt");
            ObjectInputStream dis = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                TransferPatient tp = (TransferPatient) dis.readObject();
                if (tp.getMaHS() == id){
                    return false;
                }
            }
            dis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("không đọc được file");
        }
        return true;
    }
}
