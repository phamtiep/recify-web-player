# Báo cáo dự án Công nghệ phần mềm

## Thành viên nhóm:

22022560 - Phạm Khắc Tiệp

22022650 - Bùi Việt Anh

22022673 - Long Hoàng Vinh

## 1. Tổng quan về ứng dụng:

- Recify là một trang web nghe nhạc trực tuyến, dành cho tất cả mọi người, thuộc tất cả mọi lứa tuổi và tất cả mọi ngành nghề. Recify cung cấp một kho tàng dữ liệu âm nhạc khổng lồ có thể đáp ứng nhu cầu sử dụng của đa dạng thể loại người dùng. Không giống những nền tảng nghe nhạc trên thị trường, Recify cho phép người dùng nghe nhạc miễn phí mà không có quảng cáo giữa chừng.

## 2. Tính năng sản phẩm:

### a. Quản lí người dùng:

- **Đăng nhập/ Đăng kí:** Cho phép người dùng tự tạo tài khoản và đăng nhập vào hệ thống.
- **Quản lý Hồ sơ Người dùng:** Hệ thống lưu dữ liệu về playlist của từng người dùng.

### b. Quản lí sản phẩm:

- **Tạo/Xóa playlist:** Người dùng có thể tạo và xóa playlist cá nhân.
- **Thêm/Xóa nhạc khỏi playlist:** Người dùng có thể thêm và xóa nhạc khỏi playlist.
- **Hiển thị lượt xem:** Hệ thống hiển thị lượt xem của bài nhạc hiện tại.
- **Tải lên/Xóa nhạc khỏi hệ thống:** Đối với Admin, có thể tải nhạc lên và xóa nhạc khỏi hệ thống.

### c. Gợi ý nhạc:

- **Đưa ra gợi ý cho bài nhạc đang phát:** Hệ thống đưa ra 5 bài nhạc đề xuất dựa trên thông tin về bài nhạc đang được phát.

## 3. Yêu cầu phi chức năng:

### a. Hiệu suất:

- **Thời gian phản hồi:** Hệ thống phản hồi với người dùng dưới 5 giây.
- **Không bị gián đoạn:** Recify tạo cho người dùng trải nghiệm nghe nhạc liền mạch.

### b. Bảo mật:

- **Bảo mật dữ liệu người dùng:** Tuân thủ các chuẩn mực bảo mật.
- **Xác thực và ủy quyền:** Đảm bảo rằng chỉ những người dùng có quyền mới có thể truy cập vào các chức năng nhất định.

### c. Khả năng sử dụng:

- **Giao diện:** Giao diện dễ sử dụng, trực quan cho mọi đối tượng người dùng.

## 4. Công nghệ sử dụng:

### a. Frontend:

- Với giao diện thân thiện và dễ sử dụng, Recify cho phép người dùng dễ dàng tìm kiếm và phát nhạc yêu thích của mình.

### b. Backend:

### c. Model:

- Mô hình sử dụng thuật toán Collaborative filtering, mô hình K-nearest neighbor và thuật toán cosine similarity, đưa ra đề xuất dựa trên sự tương quan giữa lượt nghe của mỗi người dùng với mỗi bài nhạc.
- Đối với mỗi bài nhạc, mô hình KNN và thuật toán cosine similarity sẽ trả về 5 bài nhạc có độ tương quan lớn nhất về số lượng lượt nghe giữa các người dùng.

## 5. Kiến trúc phần mềm:

- Database

## 6. Bảo mật:
