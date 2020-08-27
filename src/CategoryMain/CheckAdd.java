package CategoryMain;

import IOFile.IO_File_Inpatient;
import Objects.*;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CheckAdd {
    private static CheckAdd instance = new CheckAdd();
    public static CheckAdd getInstance(){return instance;}
    ArrayList<Inpatient> arrIn= new ArrayList<>();
    ArrayList<Outpatient> arrOut = new ArrayList<>();
    ArrayList<TransferPatient> arrTran= new ArrayList<>();
    public static ID_Compare_IP compare_ip= new ID_Compare_IP();
    public static ID_Compare_OP compare_op= new ID_Compare_OP();
    public static IP_Compare_TransP compare_transP= new IP_Compare_TransP();
    public void check(){
        IO_File_Inpatient readfile = IO_File_Inpatient.getInstance();
        boolean check = true;
        Scanner scanner = new Scanner(System.in);


        do {
            startAdd:
            {
                System.out.println("1. Thêm vào Danh sách Nội trú");
                System.out.println("2. Thêm vào Danh sách Ngoại trú");
                System.out.println("3. Thêm vào Danh sách Chuyển tuyến");
                System.out.println("4. Lưu trữ và Quay lại Menu");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        try {
                            int id;
                            do{
                                System.out.print("Mã hồ sơ: ");
                                try {
                                    id =Integer.parseInt(scanner.nextLine());
                                    if(id>0) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);


                            String name;
                            do {
                                System.out.print("Họ Tên: ");
                                try {
                                    name = scanner.nextLine();
                                    if (!name.equals("")) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);

                            String birthday;
                            do {
                                System.out.print("Ngày sinh(dd/mm/yyyy): ");
                                try {
                                    birthday = scanner.nextLine();
                                    String [] str = birthday.split("/");
                                    LocalDate myDate = LocalDate.of(Integer.parseInt(str[2]),Integer.parseInt(str[1]),Integer.parseInt(str[0]));
                                    if (!myDate.equals("")) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);

                            String inputHospital;
                            do {
                                System.out.print("Ngày nhập viện(dd/mm/yyyy): ");
                                try{
                                    inputHospital = scanner.nextLine();
                                    String[] strH= inputHospital.split("/");
                                    LocalDate myD = LocalDate.of(Integer.parseInt(strH[2]),Integer.parseInt(strH[1]),Integer.parseInt(strH[0]));
                                    if (!myD.equals("")) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);

                            String outHospital;
                            do {
                                System.out.print("Ngày ra viện(dd/mm/yyyy): ");
                                try {
                                    outHospital = scanner.nextLine();
                                    String[] strO= outHospital.split("/");
                                    LocalDate myO = LocalDate.of(Integer.parseInt(strO[2]),Integer.parseInt(strO[1]),Integer.parseInt(strO[0]));
                                    if (!myO.equals("")) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);

                            String chuanDoanBenh;
                            do {
                                System.out.print("Chuẩn đoán bệnh: ");
                                try {
                                    chuanDoanBenh = scanner.nextLine();
                                    if(chuanDoanBenh!=null) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);

                            String TenKhoa;
                            do {
                                System.out.print("Tên khoa: ");
                                try {
                                    TenKhoa = scanner.nextLine();
                                    if (TenKhoa!=null) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);

                            int soGiuong;
                            do {
                                System.out.print("Số giường: ");
                                try {
                                    soGiuong = Integer.parseInt(scanner.nextLine());
                                    if (soGiuong>0) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);


                            Inpatient inpatient = new Inpatient(id, name, birthday, inputHospital, outHospital, chuanDoanBenh, TenKhoa, soGiuong);
                            readfile.ReadIn(arrIn);
                            arrIn.add(inpatient);
                            Collections.sort(arrIn,compare_ip);
                            readfile.WriteInpatient(arrIn);

                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "2":
                        try {
                            int idOut;
                            do {
                                System.out.print("Mã hồ sơ: ");
                                try {
                                    idOut = Integer.parseInt(scanner.nextLine());
                                    if (idOut > 0) break;
                                } catch (Exception ignored) {}
                                System.out.println("nhập sai");
                            } while (true);

                            String nameOut;
                            do {
                                System.out.print("Nhập Họ và Tên: ");
                                try {
                                    nameOut = scanner.nextLine();
                                    if (!nameOut.equals("")) break;
                                } catch (Exception ignored) {}
                                System.out.println("nhập sai");
                            } while (true);

                            String birthdayOut;
                            do {
                                System.out.print("Ngày sinh(dd/mm/yyyy): ");
                                try {
                                    birthdayOut = scanner.nextLine();
                                    String[] strBOut = birthdayOut.split("/");
                                    LocalDate myDateOut = LocalDate.of(Integer.parseInt(strBOut[2]), Integer.parseInt(strBOut[1]), Integer.parseInt(strBOut[0]));
                                    if (!myDateOut.equals("")) break;
                                } catch (Exception ignored) {}
                                System.out.println("nhập sai");
                            } while (true);

                            String ngayKhamOut;
                            do {
                                System.out.print("Ngày khám(dd/mm/yyyy): ");
                                try {
                                    ngayKhamOut = scanner.nextLine();
                                    String[] strOut = ngayKhamOut.split("/");
                                    LocalDate myOut = LocalDate.of(Integer.parseInt(strOut[2]), Integer.parseInt(strOut[1]), Integer.parseInt(strOut[0]));
                                    if (!myOut.equals("")) break;
                                } catch (Exception ignored) {}
                                System.out.println("nhập sai");
                            } while (true);

                            String chuanDoanBenhOut;
                            do {
                                System.out.print("Chuẩn đoán bệnh: ");
                                try {
                                    chuanDoanBenhOut = scanner.nextLine();
                                    if(chuanDoanBenhOut!=null) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);

                            String Sobaohiem;
                            do {
                                System.out.print("Sổ bảo hiểm: ");
                                try {
                                    Sobaohiem = scanner.nextLine();
                                    if (Sobaohiem!=null) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);

                            int idthuoc;
                            do {
                                System.out.print("Mã Toa thuốc: ");
                                try {
                                    idthuoc = Integer.parseInt(scanner.nextLine());
                                    if (idthuoc>0) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);

                            Outpatient outpatient = new Outpatient(idOut, nameOut, birthdayOut, ngayKhamOut, chuanDoanBenhOut, Sobaohiem, idthuoc);
                            readfile.ReadOut(arrOut);
                            arrOut.add(outpatient);
                            Collections.sort(arrOut,compare_op);
                            readfile.WriteOutpatient(arrOut);

                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "3":
                        try {
                            int idTrans;
                            do {
                                System.out.print("Mã hồ sơ: ");
                                try {
                                    idTrans = Integer.parseInt(scanner.nextLine());
                                    if (idTrans > 0) break;
                                } catch (Exception ignored) {}
                                System.out.println("nhập sai");
                            } while (true);

                            String nameTrans;
                            do {
                                System.out.print("Nhập Họ và Tên: ");
                                try {
                                    nameTrans = scanner.nextLine();
                                    if (!nameTrans.equals("")) break;
                                } catch (Exception ignored) {}
                                System.out.println("nhập sai");
                            } while (true);

                            String birthdayTrans;
                            do {
                                System.out.print("Ngày sinh(dd/mm/yyyy): ");
                                try {
                                    birthdayTrans = scanner.nextLine();
                                    String[] strTrans = birthdayTrans.split("/");
                                    LocalDate myDateTrans = LocalDate.of(Integer.parseInt(strTrans[2]), Integer.parseInt(strTrans[1]), Integer.parseInt(strTrans[0]));
                                    if (!myDateTrans.equals("")) break;
                                } catch (Exception ignored) {}
                                System.out.println("nhập sai");
                            } while (true);

                            String chuanDoanTrans;
                            do {
                                System.out.print("Chuẩn đoán bệnh: ");
                                try {
                                    chuanDoanTrans = scanner.nextLine();
                                    if(chuanDoanTrans!=null) break;
                                }catch (Exception ignored){}
                                System.out.println("nhập sai");
                            }while (true);

                            String ngayTrans;
                            do {
                                System.out.print("Ngày chuyển(dd/mm/yyyy): ");
                                try {
                                    ngayTrans = scanner.nextLine();
                                    String[] strTransD= ngayTrans.split("/");
                                    LocalDate myTD = LocalDate.of(Integer.parseInt(strTransD[2]), Integer.parseInt(strTransD[1]), Integer.parseInt(strTransD[0]));
                                    if (!myTD.equals("")) break;
                                }catch (Exception ignored) {}
                                System.out.println("nhập sai");
                            }while (true);

                            String noiTrans;
                            do {
                                System.out.print("Nơi chuyển: ");
                                try{
                                    noiTrans = scanner.nextLine();
                                    if(!noiTrans.equals(""))break ;
                                }catch (Exception ignored) {}
                                System.out.println("nhập sai");
                            }while (true);

                            TransferPatient transferPatient = new TransferPatient(idTrans, nameTrans, birthdayTrans, chuanDoanTrans, ngayTrans, noiTrans);
                            readfile.ReadTrans(arrTran);
                            arrTran.add(transferPatient);
                            Collections.sort(arrTran,compare_transP);
                            readfile.WriteTransferPatient(arrTran);

                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "4":
                        check = false;
                        break;
                    default:
                        break startAdd;
                }
            }
        }while (check);
    }
}
