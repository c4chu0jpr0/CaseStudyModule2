package CategoryMain;

public class CategoryMenu {
    private static CategoryMenu instance= new CategoryMenu();
    public static CategoryMenu getInstance() {
        return instance;
    }

    public void Menu(){
        System.out.println("Menu");
        System.out.println("1. Thêm bệnh nhân");
        System.out.println("2. Sửa thông tin");
        System.out.println("3. Xóa thông tin");
        System.out.println("4. Hiện Danh sách");
        System.out.println("5. Tìm kiếm bệnh nhân");
        System.out.println("6. Danh sách Hồ sơ bệnh án");
        System.out.println("0. Thoát chương trình");
        System.out.print("Nhập số: ");
    }
}
