package Model;

import Controller.DatabaseSQL;
import Entity.SinhVien;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SinhVienModel {
    public SinhVienModel() {
        DatabaseSQL db = new DatabaseSQL();
    }

    // check username va password trong csdl
    public ArrayList<SinhVien> getLoginSinhVien() throws Exception {
        ArrayList<SinhVien> arr = new ArrayList<SinhVien>();
        Statement stmt = null;
        ResultSet rs = null;
        Connection cn = null;
        try {
            cn = DatabaseSQL.getConnection();
            stmt = cn.createStatement();
            String SQL = "SELECT MaSV,MatKhau from SINHVIEN";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setMatKhau(rs.getString(2));
                arr.add(sv);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                DatabaseSQL.releaseConnection(cn, stmt, rs);
            } catch (Exception e) {
                throw e;
            }
        }
        return arr;
    }

    public boolean checkLogin(String username, String password) throws Exception {
        boolean isUserAvailable = false;
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "SELECT * FROM SINHVIEN WHERE MaSV = '" + username + "' AND MatKhau = '" + password + "'";
            conn = DatabaseSQL.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                isUserAvailable = true;
            }
        } catch (Exception ex) {
            throw new Exception();
        } finally {
            try {
                DatabaseSQL.releaseConnection(conn, stmt, rs);
            } catch (Exception ex) {
                throw new Exception();
            }
        }

        return isUserAvailable;
    }

    public ArrayList<SinhVien> getSinhVien() throws Exception {
        ArrayList<SinhVien> arr = new ArrayList<SinhVien>();
        Statement stmt = null;
        ResultSet rs = null;
        Connection cn = null;
        try {
            cn = DatabaseSQL.getConnection();
            stmt = cn.createStatement();
            String SQL = "SELECT * from SINHVIEN ";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setTenSV(rs.getString(2));
                sv.setNgaySinh(rs.getString(3));
                sv.setGioiTinh(rs.getString(4));
                sv.setSdt(rs.getString(5));
                sv.setDiaChi(rs.getString(6));
                sv.setQueQuan(rs.getString(7));
                sv.setEmail(rs.getString(8));
                sv.setMaLop(rs.getString(9));
                sv.setMatKhau(rs.getString(10));
                arr.add(sv);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                DatabaseSQL.releaseConnection(cn, stmt, rs);
            } catch (Exception e) {
                throw e;
            }
        }
        return arr;
    }

    public int addSinhVien(SinhVien sv) throws SQLException {
        int id = 0;
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            String SQL = "insert into SINHVIEN values(?,?,?,?,?,?,?,?,?)";
            conn = DatabaseSQL.getConnection();
            stmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, sv.getMaSV());
            stmt.setString(2, sv.getTenSV());
            stmt.setString(3, sv.getNgaySinh());
            stmt.setString(4, sv.getGioiTinh());
            stmt.setString(5, sv.getSdt());
            stmt.setString(6, sv.getDiaChi());
            stmt.setString(7, sv.getQueQuan());
            stmt.setString(8, sv.getEmail());
            stmt.setString(9, sv.getMaLop());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
            System.out.println("ID: " + id);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw ex;
            }
        }
        return id;
    }

    public boolean editSinhVien(String matkhau, String masv) throws SQLException {
        boolean updateStatus = false;
        PreparedStatement stmt = null;
        Connection conn = null;
        int count;
        try {
            String SQL = "UPDATE SINHVIEN SET MatKhau = ? WHERE MaSV = ?";
            conn = DatabaseSQL.getConnection();
            stmt= conn.prepareStatement(SQL);
            stmt.setString(1, matkhau);
            stmt.setString(2,masv);
            count= stmt.executeUpdate();
            if (count>0) {
                updateStatus = true;
            }


        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw ex;
            }
        }
        return updateStatus;
    }

    public void deleteSinhVien(String MaSV) throws SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            String SQL = "delete SINHVIEN  where MaSV = ?";
            conn = DatabaseSQL.getConnection();
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, MaSV);
            stmt.executeUpdate();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw ex;
            }
        }
    }

    public ArrayList<SinhVien> getInfoSinhVien(String MaSV) throws Exception {
        ArrayList<SinhVien> arr = new ArrayList<SinhVien>();
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "SELECT * FROM VIEW_INFO_SINHVIEN WHERE MaSV = ?";
            conn = DatabaseSQL.getConnection();
            stmt = conn.prepareStatement(SQL);
            stmt.setString(1, MaSV);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            rs = stmt.executeQuery();

            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setTenSV(rs.getString(2));
                sv.setNgaySinh(format.format(rs.getDate(3)));
                sv.setGioiTinh(rs.getString(4));
                sv.setSdt(rs.getString(5));
                sv.setDiaChi(rs.getString(6));
                sv.setQueQuan(rs.getString(7));
                sv.setEmail(rs.getString(8));
                sv.setMaLop(rs.getString(9));
                sv.setTenLop(rs.getString(10));
                sv.setNamNhapHoc(rs.getString(11));
                sv.setMaKhoaHoc(rs.getString(12));
                sv.setTenKhoaHoc(rs.getString(13));
                arr.add(sv);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                DatabaseSQL.releaseConnection(conn, stmt, rs);
            } catch (Exception e) {
                throw e;
            }
        }
        return arr;
    }
}
