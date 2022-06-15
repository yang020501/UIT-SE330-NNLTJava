# Chess Game with Minimax

## Để sử dụng được ứng dụng bạn cần cái các thứ sau: 
  - IDE: ` NetBeans` [Link](https://netbeans.apache.org/download/index.html)
  - Thiết lập môi trường `Java`(các bản mới thường sẽ tự đồng thiết lập môi trường): [Download JDK](https://www.oracle.com/java/technologies/downloads/) 
  - Hoặc bạn có thể xem hướng dẫn tại đây nếu như phần cài trên chưa thiết lập môi trường cho bạn: [Xem hướng dẫn](https://openplanning.net/10377/cai-dat-java-tren-windows)
  - Tải file nhạc và bỏ vào theo đường dẫn src/main/java/Music do file nhạc > 100mb nên không up Git được [Link](https://drive.google.com/drive/folders/1lKglUg3dL7QdSShwzg_Hn-mGUtqTXjNd?usp=sharing)
## Sau khi cài hoàn tất bạn có thể mở Project bằng NetBean nhưng vẫn cần thiết lập bước cài Database và liên kết Server cho NetBeans:
  - `Sql server` : [Hướng dẫn cài Sql Server](https://datapot.vn/huong-dan-cai-dat-sql-server-2019/)
  - Học và cách tạo database trong SQl server : [Link](https://openplanning.net/10991/sql-server)
  - Bạn có thể tạo nhanh theo file SDB.sql của project trong file Chess_Engine
  - Download Driver phù hợp với JDK version bạn chọn trên trong file Zip sau khi bạn tải về với đuôi .jre*.jar *=version Java JDK bạn chọn hoặc nhỏ hơn
 [Link](https://docs.microsoft.com/vi-vn/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-2017)
  - ### Liên kết với JDBC trogn NetBeans:
  1. Chọn database như hình

  ![image](https://user-images.githubusercontent.com/79902770/173601543-15238810-6db6-47f6-98ad-a8ddf419edb6.png)
  
  2. Chọn phần New Driver trong thanh scroll pane

  ![image](https://user-images.githubusercontent.com/79902770/173603607-ac2d3bee-f9c5-4ee5-9e90-ba4442d944a3.png)
  
  3. Tại phần Add bạn chọn đường dẫn thư mục tới File jdbs driver sau khi giải nén như hình :

  ![image](https://user-images.githubusercontent.com/79902770/173603820-1151ed5b-7dfd-4988-9232-4f56eaab0bdb.png)
  
  4. Click ok và open 
  ![image](https://user-images.githubusercontent.com/79902770/173604091-57440334-9304-4776-98da-22facdb8dfa4.png)
  
  5. Chọn 1 trong các bản bạn đã add nếu bạn add nhiều bản jdbc
  ![image](https://user-images.githubusercontent.com/79902770/173604236-6024b931-edc0-45ec-aa9e-5a89cd4a1ec1.png)
  
  6. Thiết lập các thuộc tính 
   Trong đó: 
   - host: tên host của máy bạn
   - port: mặc đinh sẽ là 1433 nhưng bạn có thể xem port của bạn tại dây [Hướng dẫn xem port](https://chuyengiamarketing.com/cach-thiet-lap-sql-server-ket-noi-tu-xa-qua-mang/)
   - Database name: ứng với Database name trong Sql server bạn đã tạo
   - Instance name:  để trống hoặc tùy chỉnh
   - Username: 
   - Password:  
   ### Đây là 2 field bắt  bạn cần mở chức năng dăng nhập để kết nối Sql Server  mặc định project sẽ là sa và sa trong class DBconnnection
   ### Hoặc bạn có thể mở qua [Xác thực Sql](https://www.engisv.info/?p=4982)
   ### Trong field Database Connection "jdbc=........" thêm `encrypt=false;`  vào đuôi chuỗi này để tránh lỗi 
  ![image](https://user-images.githubusercontent.com/79902770/173604580-aa7cfe90-1f76-4b55-a61b-f09d5ccffd44.png)
 
  7. Sau khi next bạn sẽ chọn định dạng bảng mà bạn dùng trong sql của mình là dbo
  ![image](https://user-images.githubusercontent.com/79902770/173606706-4de87a58-006d-46f1-8a38-0ba98a9c97b9.png)
  
  8. Chọn tên trong phần thể hiện database trong scroll pane ở hình 1
  
  ![image](https://user-images.githubusercontent.com/79902770/173606860-3e894495-7708-41bd-bbc1-7cfecd76b309.png) 
  
  # Vậy là bạn đã hoàn thành xong phần thiết lập  và run thôi ^^







