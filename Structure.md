src/main/java/com/yourname/launcher/
│
├── core/                # Logic lõi của Launcher (không liên quan UI)
│   ├── auth/            # Xử lý đăng nhập (Microsoft/Offline)
│   ├── download/        # Quản lý tải Library, Assets, JAR
│   ├── game/            # Xử lý khởi tạo Process, tham số JVM, JNI
│   └── utils/           # Các công cụ hỗ trợ (File, Hash, OS detection)
│
├── ui/                  # Tầng giao diện (Pure Java Code)
│   ├── components/      # Các thành phần UI tái sử dụng (Button, Card, Sidebar)
│   ├── scenes/          # Các màn hình lớn (LoginScene, MainScene, SettingsScene)
│   ├── styles/          # Quản lý theme (Tích hợp AtlantaFX, Font, Color)
│   └── ViewManager.java # Quản lý chuyển đổi giữa các màn hình
│
├── models/              # Các đối tượng dữ liệu (User, Version, ServerInfo)
│
├── viewmodels/          # Trung gian kết nối UI và Core (Data Binding)
│
└── Main.java            # Điểm khởi chạy ứng dụng (Entry Point)