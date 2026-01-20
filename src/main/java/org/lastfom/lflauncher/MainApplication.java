package org.lastfom.lflauncher;

import java.util.Objects;

import org.lastfom.lflauncher.ui.ViewManager;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Main Entry Point - Điểm khởi chạy ứng dụng
 * Pure JavaFX - không sử dụng FXML
 */
public class MainApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // 1. Thêm Icon cho ứng dụng (Hiển thị ở Taskbar và góc cửa sổ)
        try {
            // Sử dụng đường dẫn tuyệt đối tính từ thư mục resources
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/icons/icon.png")));
            primaryStage.getIcons().add(icon);
        } catch (Exception e) {
            System.err.println("Không thể tải icon: " + e.getMessage());
            // Ứng dụng vẫn tiếp tục chạy dù không load được icon
        }
        // 2. Khởi tạo ViewManager với Stage chính
        ViewManager viewManager = ViewManager.getInstance();
        viewManager.init(primaryStage);
        
        // 4. Hiển thị màn hình chính
        viewManager.showMainScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}