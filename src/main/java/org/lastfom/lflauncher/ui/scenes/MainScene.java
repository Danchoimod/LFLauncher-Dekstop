package org.lastfom.lflauncher.ui.scenes;

import java.util.ArrayList;
import java.util.List;

import org.lastfom.lflauncher.ui.components.NavigationTab;
import org.lastfom.lflauncher.ui.components.PlayButton;
import org.lastfom.lflauncher.ui.components.SidebarButton;
import org.lastfom.lflauncher.ui.styles.Theme;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainScene extends StackPane {
    
    private List<SidebarButton> sidebarButtons = new ArrayList<>();
    private List<NavigationTab> navigationTabs = new ArrayList<>();
    private BorderPane mainLayout = new BorderPane();
    
    public MainScene() {
        // 1. Background Cover (Luôn phủ kín khi phóng to)
        Region backgroundRegion = new Region();
        try {
            String imagePath = getClass().getResource("/assets/images/wallpaper.png").toExternalForm();
            backgroundRegion.setStyle(
                "-fx-background-image: url('" + imagePath + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: no-repeat; " +
                "-fx-background-size: cover;" 
            );
        } catch (Exception e) {
            backgroundRegion.setStyle("-fx-background-color: #1a1a1a;");
        }

        Region overlay = new Region();
        overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6);");

        mainLayout.setLeft(createSidebar());
        mainLayout.setCenter(createMainContent());
        
        this.getChildren().addAll(backgroundRegion, overlay, mainLayout);
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
        SidebarButton javaBtn = createSidebarButton("MINECRAFT", "Java Edition");
        SidebarButton windowsBtn = createSidebarButton("MINECRAFT", "for Windows");
        sidebarButtons.addAll(List.of(newsBtn, javaBtn, windowsBtn));
        
        for (SidebarButton btn : sidebarButtons) {
            btn.setOnMouseClicked(e -> selectSidebarButton(btn));
            btn.setMaxWidth(Double.MAX_VALUE); // Cho phép button rộng theo sidebar
        }
        
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        
        SidebarButton settingsBtn = createSidebarButton("Settings", "");
        settingsBtn.setMaxWidth(Double.MAX_VALUE);
        
        sidebar.getChildren().addAll(userSection, newsBtn, javaBtn, windowsBtn, spacer, settingsBtn);
        return sidebar;
    }

    private SidebarButton createSidebarButton(String title, String subtitle) {
        return new SidebarButton("", title, subtitle);
    }
    
    private void selectSidebarButton(SidebarButton selected) {
        for (SidebarButton btn : sidebarButtons) {
            btn.setSelected(btn == selected);
        }
    }
    
    private BorderPane createMainContent() {
        BorderPane content = new BorderPane();
        content.setTop(createNavigationBar());
        content.setCenter(createGameContent());
        content.setBottom(createBottomBar());
        return content;
    }
    
    private HBox createNavigationBar() {
        HBox navbar = new HBox(20);
        navbar.setAlignment(Pos.CENTER_LEFT);
        navbar.setPadding(new Insets(25, 30, 10, 30));
        
        // TỰ ĐỘNG CHIỀU CAO: Navbar chiếm 10% chiều cao màn hình
        navbar.prefHeightProperty().bind(this.heightProperty().multiply(0.1));
        
        NavigationTab playTab = new NavigationTab("Play");
        NavigationTab dlcTab = new NavigationTab("DLC");
        NavigationTab faqTab = new NavigationTab("FAQ");
        NavigationTab installTab = new NavigationTab("Installation");
        NavigationTab patchTab = new NavigationTab("Patch Notes");
        
        playTab.setSelected(true);
        navigationTabs.addAll(List.of(playTab, dlcTab, faqTab, installTab, patchTab));
        
        for (NavigationTab tab : navigationTabs) {
            tab.setOnMouseClicked(e -> selectNavigationTab(tab));
        }
        
        navbar.getChildren().addAll(navigationTabs);
        return navbar;
    }
    
    private void selectNavigationTab(NavigationTab selected) {
        for (NavigationTab tab : navigationTabs) {
            tab.setSelected(tab == selected);
        }
    }
    
    private StackPane createGameContent() {
        StackPane contentArea = new StackPane();
        VBox titleContainer = new VBox();
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setMouseTransparent(true); 

        try {
            Image titleImg = new Image(getClass().getResourceAsStream("/assets/icons/title.png"));
            ImageView titleView = new ImageView(titleImg);
            titleView.setPreserveRatio(true);
            titleView.setTranslateY(-170); 
            titleView.setFitWidth(300);
            
            titleContainer.getChildren().add(titleView);
        } catch (Exception e) {
            Label fallbackTitle = new Label("LF LAUNCHER");
            fallbackTitle.setStyle("-fx-text-fill: white; -fx-font-size: 40px; -fx-font-weight: bold;");
            titleContainer.getChildren().add(fallbackTitle);
        }

        contentArea.getChildren().add(titleContainer);
        return contentArea;
    }
    
    private StackPane createBottomBar() {
        StackPane bottomBar = new StackPane();
        bottomBar.setPadding(new Insets(0, 40, 0, 40));
        
        // TỰ ĐỘNG CHIỀU CAO: Bottombar chiếm 15% chiều cao màn hình
        bottomBar.prefHeightProperty().bind(this.heightProperty().multiply(0.1));
        bottomBar.setMinHeight(80);
        
        bottomBar.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);");
        
        // Nút PLAY
        PlayButton playBtn = new PlayButton("PLAY");
        
        // Kích thước nút Play cũng giãn nhẹ theo màn hình
        playBtn.prefWidthProperty().bind(bottomBar.widthProperty().multiply(0.2)); 
        playBtn.setPrefHeight(55);
        playBtn.setMaxWidth(250);
        
        // Màu xanh Minecraft và hiệu ứng
        playBtn.setStyle(Theme.Styles.PLAY_BUTTON_STYLE);
        playBtn.setOnMouseEntered(e -> playBtn.setStyle(Theme.Styles.PLAY_BUTTON_HOVER_STYLE));
        playBtn.setOnMouseExited(e -> playBtn.setStyle(Theme.Styles.PLAY_BUTTON_STYLE));
        playBtn.setOnMousePressed(e -> playBtn.setStyle(Theme.Styles.PLAY_BUTTON_PRESSED_STYLE));
        playBtn.setOnMouseReleased(e -> playBtn.setStyle(Theme.Styles.PLAY_BUTTON_HOVER_STYLE));
        
        StackPane.setAlignment(playBtn, Pos.CENTER);
        
        // Container phải
        HBox rightContainer = new HBox();
        rightContainer.setAlignment(Pos.CENTER_RIGHT);
        rightContainer.setPickOnBounds(false);
        
        Label playerBtn = new Label("Player Settings");
        playerBtn.setStyle("-fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 12 25; " +
                          "-fx-background-color: rgba(255, 255, 255, 0.1); -fx-background-radius: 5;");
        playerBtn.setCursor(javafx.scene.Cursor.HAND);
        rightContainer.getChildren().add(playerBtn);
        
        bottomBar.getChildren().addAll(rightContainer, playBtn);
        return bottomBar;
    }
}