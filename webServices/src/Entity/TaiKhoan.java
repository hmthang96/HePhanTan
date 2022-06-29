package Entity;

public class TaiKhoan {
    private String maSV = "";
    private String matKhau = "";

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    @Override
    public TaiKhoan clone() throws CloneNotSupportedException {
        return (TaiKhoan) super.clone();
    }
}
