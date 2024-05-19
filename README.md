# Báo cáo dự án Công nghệ phần mềm

## Thành viên nhóm:

22022560 - Phạm Khắc Tiệp

22022650 - Bùi Việt Anh

22022673 - Long Hoàng Vinh

## 1. Tổng quan về ứng dụng:

- Recify là một trang web nghe nhạc trực tuyến, dành cho tất cả mọi người, thuộc tất cả mọi lứa tuổi và tất cả mọi ngành nghề. Recify cung cấp một kho tàng dữ liệu âm nhạc khổng lồ có thể đáp ứng nhu cầu sử dụng của đa dạng thể loại người dùng. Không giống những nền tảng nghe nhạc trên thị trường, Recify cho phép người dùng nghe nhạc miễn phí mà không có quảng cáo giữa chừng.

## Personas

**Dũng, lập trình viên**

- Anh Nguyễn Hùng Dũng, tuổi 24, là một lập trình viên tại công ty Mona Media, một công ty phát triển phần mềm và website hàng đầu. Dũng thành thạo nhiều ngôn ngữ lập trình. Anh cũng có kinh nghiệm sâu rộng với các framework và công nghệ hiện đại. Ngoài ra, Dũng còn có kiến thức vững chắc về cơ sở dữ liệu và bảo mật thông tin. Ngoài công việc, Dũng là một người yêu thích âm nhạc và thể thao. Anh thường chơi guitar và tham gia các hoạt động thể thao như đá bóng và bơi lội. Với tính cách hòa đồng và nhiệt huyết, Dũng luôn là người bạn đồng hành tuyệt vời trong mọi hoạt động tập thể.
 
- Dũng là một con người luôn hết mình vì công việc, tuy là một lập trình viên rất giỏi nhưng các tác vụ khó khăn vẫn đôi lần làm khó anh. Những lúc như vậy anh Dũng thường tìm đến âm nhạc để giải tỏa tâm trí, thể loại nhạc yêu thích của anh là lofi và indie, những bài nhạc thuộc các thể loại này giúp anh tập trung hơn khi làm việc cũng như thư giãn sau những giờ làm việc căng thẳng. Anh Dũng mong muốn nền tảng âm nhạc Recify có thể mang lại cho anh thật nhiều bài nhạc lofi và indie để thưởng thức.


**Đức, nhạc sĩ nổi tiếng**

- Anh Ngô Công Đức, tuổi 40, là một nhạc sĩ người Việt Nam. Sinh ra và lớn lên tại Thành phố Hồ Chí Minh, từ nhỏ, Đức đã bộc lộ niềm đam mê với âm nhạc. Anh bắt đầu học piano và guitar từ khi mới 5 tuổi và nhanh chóng thể hiện năng khiếu đặc biệt. Trong suốt thời gian học tập tại trường, Đức thường xuyên tham gia các hoạt động âm nhạc và giành nhiều giải thưởng ở các cuộc thi âm nhạc dành cho học sinh. Đức bắt đầu sự nghiệp của mình bằng việc hợp tác với nhiều ca sĩ nổi tiếng và sáng tác hàng loạt ca khúc hit. Anh nhanh chóng được công nhận với phong cách âm nhạc độc đáo, kết hợp giữa truyền thống và hiện đại.
 
- Phong cách âm nhạc của Đức hòa quyện giữa âm nhạc truyền thống Việt Nam và các xu hướng âm nhạc hiện đại. Anh luôn tìm kiếm và khám phá những âm thanh mới, không ngừng đổi mới để mang đến cho khán giả những trải nghiệm âm nhạc độc đáo. Đức đặc biệt yêu thích việc sáng tác những ca khúc mang đậm nét văn hóa và tâm hồn người Việt, truyền tải những thông điệp sâu sắc và ý nghĩa. Anh Đức có hứng thú với nền tảng âm nhạc Recify vì nền tảng này có thể cung cấp cho anh nhiều bài hát thuộc nhiều thể loại nhạc, tạo cảm hứng sáng tác cho anh.

## 3. Tính năng sản phẩm:

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

## 4. Yêu cầu phi chức năng:

### a. Hiệu suất:

- **Thời gian phản hồi:** Hệ thống phản hồi với người dùng dưới 5 giây.
- **Không bị gián đoạn:** Recify tạo cho người dùng trải nghiệm nghe nhạc liền mạch.

### b. Bảo mật:

- **Bảo mật dữ liệu người dùng:** Tuân thủ các chuẩn mực bảo mật.
- **Xác thực và ủy quyền:** Đảm bảo rằng chỉ những người dùng có quyền mới có thể truy cập vào các chức năng nhất định.

### c. Khả năng sử dụng:

- **Giao diện:** Giao diện dễ sử dụng, trực quan cho mọi đối tượng người dùng.

## 5. Công nghệ sử dụng:

### a. Frontend:

- Với giao diện thân thiện và dễ sử dụng, Recify cho phép người dùng dễ dàng tìm kiếm và phát nhạc yêu thích của mình.

### b. Backend:

### c. Model:

- Mô hình sử dụng thuật toán Collaborative filtering, mô hình K-nearest neighbor và thuật toán cosine similarity, đưa ra đề xuất dựa trên sự tương quan giữa lượt nghe của mỗi người dùng với mỗi bài nhạc.
- Đối với mỗi bài nhạc, mô hình KNN và thuật toán cosine similarity sẽ trả về 5 bài nhạc có độ tương quan lớn nhất về số lượng lượt nghe giữa các người dùng.

## 5. Kiến trúc phần mềm:

- Database

## 6. Bảo mật:
