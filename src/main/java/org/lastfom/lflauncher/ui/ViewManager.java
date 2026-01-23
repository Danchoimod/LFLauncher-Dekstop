package org.lastfom.lflauncher.ui;

import org.lastfom.lflauncher.ui.scenes.MainScene;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * ViewManager - Quản lý chuyển đổi giữa các màn hình
 * Singleton pattern để duy trì một instance duy nhất
 */
public class ViewManager {
    
    private static ViewManager instance;
    private Stage primaryStage;
    private Scene currentScene;
    
    private ViewManager() {}
    
    public static ViewManager getInstance() {
        if (instance == null) {
            instance = new ViewManager();
        }
        return instance;
    }
    
    public void init(Stage stage) {
        this.primaryStage = stage;
        this.primaryStage.setTitle("LastFom Launcher (1.0.0_beta_1)");
        this.primaryStage.setWidth(960);
        this.primaryStage.setHeight(700);
        this.primaryStage.setMinWidth(960);
        this.primaryStage.setMinHeight(700);
    }
    
    /**
     * Chuyển đến màn hình chính (Main Scene)
     */
    public void showMainScene() {
        MainScene mainScene = new MainScene();
        switchScene(mainScene);
    }
    
    /**
     * Chuyển đến màn hình đăng nhập (Login Scene)
     * TODO: Implement LoginScene
     */
    public void showLoginScene() {
        // LoginScene loginScene = new LoginScene();
        // switchScene(loginScene);
        System.out.println("Login scene not yet implemented");
    }
    
    /**
     * Chuyển đến màn hình cài đặt (Settings Scene)
     * TODO: Implement SettingsScene
     */
    public void showSettingsScene() {
        // SettingsScene settingsScene = new SettingsScene();
        // switchScene(settingsScene);
        System.out.println("Settings scene not yet implemented");
    }
    
    /**
     * Chuyển đổi scene hiện tại
     */
    private void switchScene(Pane root) {
        if (currentScene == null) {
            currentScene = new Scene(root);
            primaryStage.setScene(currentScene);
        } else {
            currentScene.setRoot(root);
        }
        
        if (!primaryStage.isShowing()) {
            primaryStage.show();
        }
    }
    
    /**
     * Lấy Stage chính
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    /**
     * Đóng ứng dụng
     */
    public void close() {
        if (primaryStage != null) {
            primaryStage.close();
        }
    }
}
