package org.lastfom.lflauncher.ui.scenes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lastfom.lflauncher.ui.components.SidebarButton;
import org.lastfom.lflauncher.ui.fragments.BaseFragment;
import org.lastfom.lflauncher.ui.fragments.JavaEditionFragment;
import org.lastfom.lflauncher.ui.fragments.NewsFragment;
import org.lastfom.lflauncher.ui.fragments.SettingsFragment;
import org.lastfom.lflauncher.ui.fragments.WindowsEditionFragment;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainScene extends StackPane {
    
    private List<SidebarButton> sidebarButtons = new ArrayList<>();
    private BorderPane mainLayout = new BorderPane();
    private Region backgroundRegion;
    private Region overlay;
    
    // Fragment management
    private Map<String, BaseFragment> fragments = new HashMap<>();
    private BaseFragment currentFragment;
    private StackPane settingsOverlay;
    
    public MainScene() {
        // Initialize fragments
        initializeFragments();
        
        // 1. Background Cover (Luôn phủ kín khi phóng to)
        backgroundRegion = new Region();
        setBackground("news");

        overlay = new Region();
        overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6);");

        mainLayout.setLeft(createSidebar());
        
        // Load default fragment
        loadFragment("news");
        
        this.getChildren().addAll(backgroundRegion, overlay, mainLayout);
    }
    
    private void initializeFragments() {
        fragments.put("news", new NewsFragment());
        fragments.put("java", new JavaEditionFragment());
        fragments.put("windows", new WindowsEditionFragment());
        fragments.put("settings", new SettingsFragment());
    }
    
    private void setBackground(String fragmentKey) {
        try {
            String imagePath;
            switch (fragmentKey) {
                case "java":
                    imagePath = getClass().getResource("/assets/images/wallpaper_java.png").toExternalForm();
                    break;
                case "windows":
                    imagePath = getClass().getResource("/assets/images/wallpaper_windows.png").toExternalForm();
                    break;
                default: // news
                    imagePath = getClass().getResource("/assets/images/wallpaper.png").toExternalForm();
            }
            backgroundRegion.setStyle(
                "-fx-background-image: url('" + imagePath + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: no-repeat; " +
                "-fx-background-size: cover;" 
            );
        } catch (Exception e) {
            backgroundRegion.setStyle("-fx-background-color: #1a1a1a;");
        }
    }
    
    private void loadFragment(String fragmentKey) {
        BaseFragment fragment = fragments.get(fragmentKey);
        if (fragment != null) {
            if (currentFragment != null) {
                currentFragment.onHide();
            }
            
            currentFragment = fragment;
            mainLayout.setCenter(fragment);
            fragment.onShow();
            
            // Update background
            setBackground(fragmentKey);
        }
    }
    
    private VBox createSidebar() {
        VBox sidebar = new VBox(5);
        
        // TỰ ĐỘNG GIÃN CHIỀU RỘNG: Sidebar chiếm khoảng 18% chiều rộng màn hình
        sidebar.prefWidthProperty().bind(this.widthProperty().multiply(0.1));
        sidebar.setMinWidth(150); // Giới hạn tối thiểu để không bị quá nhỏ
        sidebar.setMaxWidth(300); // Giới hạn tối đa để không bị quá to trên màn 4K
        
        sidebar.setPadding(new Insets(20, 15, 20, 15));
        sidebar.setStyle("-fx-background-color: rgba(15, 15, 15, 0.8);");
        
        VBox userSection = new VBox(5);
        userSection.setPadding(new Insets(0, 0, 25, 0));
        
        ImageView userAvatar = new ImageView();
        userAvatar.setFitWidth(45);
        userAvatar.setFitHeight(45);
        
        Label userName = new Label("Mod2090");
        userName.setStyle("-fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;");
        
        Label accountType = new Label("Microsoft account");
        accountType.setStyle("-fx-text-fill: #888888; -fx-font-size: 11px;");
        
        userSection.getChildren().addAll(userAvatar, userName, accountType);
        
        SidebarButton newsBtn = createSidebarButton("News", "");
        newsBtn.setUserData("news");
        
        SidebarButton javaBtn = createSidebarButton("MINECRAFT", "Java Edition");
        javaBtn.setUserData("java");
        
        SidebarButton windowsBtn = createSidebarButton("MINECRAFT", "for Windows");
        windowsBtn.setUserData("windows");
        
        sidebarButtons.addAll(List.of(newsBtn, javaBtn, windowsBtn));
        
        for (SidebarButton btn : sidebarButtons) {
            btn.setOnMouseClicked(e -> {
                String fragmentKey = (String) btn.getUserData();
                loadFragment(fragmentKey);
            });
            btn.setMaxWidth(Double.MAX_VALUE);
        }
        
        // Select default button
        newsBtn.setSelected(true);
        
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        
        SidebarButton settingsBtn = createSidebarButton("Settings", "");
        settingsBtn.setMaxWidth(Double.MAX_VALUE);
        settingsBtn.setOnMouseClicked(e -> {
            loadFragment("settings");
            setBackground("news");
        });
        
        sidebar.getChildren().addAll(userSection, newsBtn, javaBtn, windowsBtn, spacer, settingsBtn);
        return sidebar;
    }

    private SidebarButton createSidebarButton(String title, String subtitle) {
        return new SidebarButton("", title, subtitle);
    }
}