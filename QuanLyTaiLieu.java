import java.util.ArrayList;
import java.util.List;

public class QuanLyTaiLieu {
    private List<TaiLieu> danhSach;

    public QuanLyTaiLieu() {
        this.danhSach = new ArrayList<>();
    }

    public void themTaiLieu(TaiLieu taiLieu) {
        this.danhSach.add(taiLieu);
        System.out.println("Them thanh cong!");
    }

    public boolean xoaTaiLieu(String maTaiLieu) {
        TaiLieu taiLieu = this.danhSach.stream()
                .filter(tl -> tl.getMaTaiLieu().equalsIgnoreCase(maTaiLieu))
                .findFirst()
                .orElse(null);
        if (taiLieu != null) {
            this.danhSach.remove(taiLieu);
            return true;
        }
        return false;
    }

    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach trong!");
            return;
        }
        for (TaiLieu tl : danhSach) {
            tl.hienThiThongTin();
        }
    }

    public void timKiemTheoLoai(int loai) {
        boolean timThay = false;
        for (TaiLieu tl : danhSach) {
            if (loai == 1 && tl instanceof Sach) {
                tl.hienThiThongTin();
                timThay = true;
            } else if (loai == 2 && tl instanceof TapChi) {
                tl.hienThiThongTin();
                timThay = true;
            } else if (loai == 3 && tl instanceof Bao) {
                tl.hienThiThongTin();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay tai lieu thuoc loai nay!");
        }
    }
}