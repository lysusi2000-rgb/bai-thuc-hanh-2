import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyTaiLieu quanLy = new QuanLyTaiLieu();

        while (true) {
            System.out.println("\n--- QUAN LY THU VIEN ---");
            System.out.println("1. Them moi tai lieu");
            System.out.println("2. Xoa tai lieu theo ma");
            System.out.println("3. Hien thi thong tin tai lieu");
            System.out.println("4. Tim kiem tai lieu theo loai");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang (1-5): ");

            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    System.out.println("Chon loai tai lieu (1: Sach, 2: Tap chi, 3: Bao): ");
                    int loai = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhap ma tai lieu: ");
                    String ma = scanner.nextLine();
                    System.out.print("Nhap ten NXB: ");
                    String nxb = scanner.nextLine();
                    System.out.print("Nhap so ban phat hanh: ");
                    int soBan = scanner.nextInt();
                    scanner.nextLine();

                    if (loai == 1) {
                        System.out.print("Nhap ten tac gia: ");
                        String tacGia = scanner.nextLine();
                        System.out.print("Nhap so trang: ");
                        int soTrang = scanner.nextInt();
                        quanLy.themTaiLieu(new Sach(ma, nxb, soBan, tacGia, soTrang));
                    } else if (loai == 2) {
                        System.out.print("Nhap so phat hanh: ");
                        int soPH = scanner.nextInt();
                        System.out.print("Nhap thang phat hanh: ");
                        int thangPH = scanner.nextInt();
                        quanLy.themTaiLieu(new TapChi(ma, nxb, soBan, soPH, thangPH));
                    } else if (loai == 3) {
                        System.out.print("Nhap ngay phat hanh: ");
                        int ngayPH = scanner.nextInt();
                        quanLy.themTaiLieu(new Bao(ma, nxb, soBan, ngayPH));
                    } else {
                        System.out.println("Loai khong hop le!");
                    }
                    break;

                case 2:
                    System.out.print("Nhap ma tai lieu can xoa: ");
                    String maXoa = scanner.nextLine();
                    if (quanLy.xoaTaiLieu(maXoa)) {
                        System.out.println("Xoa thanh cong!");
                    } else {
                        System.out.println("Khong tim thay ma tai lieu can xoa!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- DANH SACH TAI LIEU ---");
                    quanLy.hienThiDanhSach();
                    break;

                case 4:
                    System.out.println("Nhap loai can tim (1: Sach, 2: Tap chi, 3: Bao): ");
                    int loaiTim = scanner.nextInt();
                    quanLy.timKiemTheoLoai(loaiTim);
                    break;

                case 5:
                    System.out.println("Thoat chuong trinh.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        }
    }
}