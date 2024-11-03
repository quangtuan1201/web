-- Tạo database DATN_Fusion_Nhom7
CREATE DATABASE DATN_Fusion_Nhom7
GO

-- Use vào database DATN_Fusion_Nhom7 
USE DATN_Fusion_Nhom7
GO

-- Tạo bảng loại hàng
CREATE TABLE LoaiHang(
    MaLH        CHAR(5)        PRIMARY KEY,
    TenLH       NVARCHAR(50)   NULL
)
GO

-- Create the Accounts table
CREATE TABLE TaiKhoan(
    MaTK       BIGINT IDENTITY PRIMARY KEY,
    Username   NVARCHAR(50)   NULL,
    Password   NVARCHAR(50)   NULL,
    VaiTro     BIT            NULL,
)
GO

-- Tạo bảng khách hàng
CREATE TABLE KhachHang(
    MaKH        BIGINT IDENTITY PRIMARY KEY,
    TenKH       NVARCHAR(50)    NULL,
    NgaySinh    DATETIME        NULL,
    Email       NVARCHAR(50)    NULL,
    SDT         NVARCHAR(50)    NULL,
    GioiTinh    BIT             NULL,
	MaTK        BIGINT          NULL,
    Constraint FK_TaiKhoan1 FOREIGN KEY (MaTK) REFERENCES TaiKhoan(MaTK)
)
GO

-- Tạo bảng khách hàng
CREATE TABLE NhanVien(
    MaNV        BIGINT IDENTITY PRIMARY KEY,
    TenNV       NVARCHAR(50)    NULL,
    NgaySinh    DATETIME        NULL,
    Email       NVARCHAR(50)    NULL,
    SDT         NVARCHAR(50)    NULL,
    GioiTinh    BIT             NULL,
	ChucVu      BIT             NULL,
	MaTK        BIGINT          NULL,
    Constraint FK_TaiKhoan2 FOREIGN KEY (MaTK) REFERENCES TaiKhoan(MaTK)
)
GO
-- Tạo bảng nhà cung cấp
CREATE TABLE NhaCungCap(
    MaNCC        CHAR(5)        PRIMARY KEY,
    TenNCC       NVARCHAR(50)   NULL,
	Email        NVARCHAR(50)   NULL,
	SDT          NVARCHAR(50)   NULL,
	DiaChi       NVARCHAR(255)  NULL,
)
GO


-- Tạo bảng Sản phẩm
CREATE TABLE SanPham(
    MaSP        INT             PRIMARY KEY,
    TenSP       NVARCHAR(50)    NULL,
	XuatXu      NVARCHAR(50)    NULL,
	DonViTinh   NVARCHAR(50)    NULL,
	DonGia      FLOAT           NULL,
	LuotBan     INT             NULL,
	SoLuong     INT             NULL,
	MoTa        NVARCHAR(500)    NULL,
	MaLH        CHAR(5)         NULL,
    Constraint FK_LoaiHang FOREIGN KEY (MaLH) REFERENCES LoaiHang(MaLH)
)
GO

-- Tạo bảng Ảnh Sản Phẩm
CREATE TABLE AnhSanPham(
    MaAnh        CHAR(5)        PRIMARY KEY,
    Anh          NVARCHAR(50)   NULL,
	MaSP         INT            NULL,
	Constraint FK_SanPham1  FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
)
GO

-- Tạo bảng Khuyến Mãi
CREATE TABLE KhuyenMai(
    MaKM         CHAR(5)        PRIMARY KEY,
    Giam         NVARCHAR(50)   NULL,
	MaSP         INT            NULL,
	Constraint FK_SanPham2  FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
)
GO


-- Tạo bảng giỏ hàng
CREATE TABLE GioHang(
    MaGH          BIGINT IDENTITY PRIMARY KEY,
    MaKH          BIGINT             NULL,
   Constraint FK_KhachHang1  FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH)
)
GO


-- Tạo Bảng chi tiết giỏ hàng
CREATE TABLE GioHangChiTiet(
    Id          BIGINT IDENTITY PRIMARY KEY,
    MaGH        BIGINT          NULL,
	MaSP        INT             NULL,
	SoLuong     INT             NULL,
    Constraint FK_GioHang1 FOREIGN KEY (MaGH) REFERENCES GioHang(MaGH),
    Constraint FK_SanPham3 FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
)
GO

-- Tạo bản hóa đơn
CREATE TABLE HoaDon(
    MaHD          BIGINT IDENTITY PRIMARY KEY,
	PTTT          NVARCHAR(50)    NULL,
	TrangThaiTT   NVARCHAR(50)    NULL,
	TrangThaiNH   NVARCHAR(50)    NULL,
	TongTien      FLOAT           NULL,
	MaGH          BIGINT          NULL,
    MaKH          BIGINT          NULL,
	MaNV          BIGINT          NULL,
   Constraint FK_GioHang2  FOREIGN KEY (MaGH) REFERENCES GioHang(MaGH),
   Constraint FK_KhachHang2  FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
   Constraint FK_NhanVien1  FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)
GO


-- Tạo bản hóa đơn chi tiết
CREATE TABLE HoaDonChiTiet(
    Id          BIGINT IDENTITY PRIMARY KEY,
    MaHD        BIGINT          NULL,
    MaSP        INT             NULL,
    SoLuong     INT             NULL,
    Constraint FK_HoaDon1 FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
    Constraint FK_SanPham4 FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
)
GO

-- Tạo bảng Phiếu nhập kho
CREATE TABLE PhieuNhapKho(
    MaPNK          BIGINT IDENTITY PRIMARY KEY,
	NgayLapPNK     DATE               NULL,
	TongTien       FLOAT              NULL,
	TrangThaiTT    BIT                NULL,
	MaNCC          CHAR(5)            NULL,
    MaNV           BIGINT             NULL,
   Constraint FK_NhanVien2  FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
   Constraint FK_NhaCungCap  FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC)
)
GO


-- Tạo bảng chi tiết phiếu nhập kho
CREATE TABLE ChiTietPhieuNhapKho(
    Id          BIGINT IDENTITY PRIMARY KEY,
    MaPNK       BIGINT          NULL,
	MaSP        INT             NULL,
	SoLuong     INT             NULL,
	DonGia      FLOAT           NULL,
    Constraint FK_PhieuNhapKho1 FOREIGN KEY (MaPNK) REFERENCES PhieuNhapKho(MaPNK),
    Constraint FK_SanPham5 FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
)
GO
-- Thêm sản phẩm vào bảng LoaiHang
INSERT INTO LoaiHang(MaLH, TenLH) VALUES
('LH01', N'Khuyên Tai'),
('LH02', N'Nhẫn');

-- Thêm sản phẩm vào bảng SanPham
INSERT INTO SanPham (MaSP, TenSP, XuatXu, DonViTinh, DonGia, LuotBan, SoLuong, MoTa, MaLH)
VALUES 
(1, N'Khuyên Tai Bạc', N'Việt Nam', N'Cái', 150000, 50, 100, N'Khuyên tai làm từ bạc nguyên chất.', 'LH01'),
(2, N'Nhẫn Vàng', N'Ý', N'Chiếc', 500000, 30, 50, N'Nhẫn vàng 18k nhập khẩu từ Ý.', 'LH02');

INSERT INTO AnhSanPham(MaAnh, Anh, MaSP) VALUES
('MA01', N'fusion 1.jpg', 1),
('MA02', N'Rectangle 30.jpg',2);
