package org.lastfom.lflauncher.ui.scenes;

import java.util.ArrayList;
import java.util.List;

import org.lastfom.lflauncher.ui.components.NavigationTab;
import org.lastfom.lflauncher.ui.components.PlayButton;
import org.lastfom.lflauncher.ui.components.SidebarButton;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainScene extends BorderPane {
    
    private List<SidebarButton> sidebarButtons = new ArrayList<>();
    private List<NavigationTab> navigationTabs = new ArrayList<>();
    
    public MainScene() {
        // Set dark background
        setStyle("-fx-background-color: #1a1a1a;");
        
        // Create main layout
        setLeft(createSidebar());
        setCenter(createMainContent());
    }
    
    private VBox createSidebar() {
        VBox sidebar = new VBox(5);
        sidebar.setPrefWidth(150);
        sidebar.setPadding(new Insets(20, 10, 20, 10));
        sidebar.setStyle("-fx-background-color: #0f0f0f;");
        
        // User section
        VBox userSection = new VBox(5);
        userSection.setPadding(new Insets(0, 0, 20, 0));
        
        ImageView userAvatar = new ImageView();
        userAvatar.setFitWidth(40);
        userAvatar.setFitHeight(40);
        
        Label userName = new Label("Mod2090");
        userName.setStyle("-fx-text-fill: white; -fx-font-size: 11px; -fx-font-weight: bold;");
        
        Label accountType = new Label("Microsoft account");
        accountType.setStyle("-fx-text-fill: #888888; -fx-font-size: 9px;");
        
        userSection.getChildren().addAll(userAvatar, userName, accountType);
        
        // Game selection buttons
        SidebarButton newsBtn = createSidebarButton("News", "");
        SidebarButton javaBtn = createSidebarButton("MINECRAFT", "Java Edition");
        SidebarButton windowsBtn = createSidebarButton("MINECRAFT", "for Windows");
        SidebarButton dungeonsBtn = createSidebarButton("MINECRAFT", "Dungeons");
        SidebarButton legendsBtn = createSidebarButton("MINECRAFT", "Legends");
        
        // Set Dungeons as selected by default
        dungeonsBtn.setSelected(true);
        
        sidebarButtons.addAll(List.of(newsBtn, javaBtn, windowsBtn, dungeonsBtn, legendsBtn));
        
        // Add click handlers
        for (SidebarButton btn : sidebarButtons) {
            btn.setOnMouseClicked(e -> {
                selectSidebarButton(btn);
            });
        }
        
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        
        sidebar.getChildren().addAll(userSection, newsBtn, javaBtn, windowsBtn, dungeonsBtn, legendsBtn, spacer);
        
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
        
        // Top navigation
        content.setTop(createNavigationBar());
        
        // Center - game banner/content
        content.setCenter(createGameContent());
        
        // Bottom - play button and player info
        content.setBottom(createBottomBar());
        
        return content;
    }
    
    private HBox createNavigationBar() {
        HBox navbar = new HBox(0);
        navbar.setPadding(new Insets(20, 30, 0, 30));
        navbar.setStyle("-fx-background-color: transparent;");
        navbar.setAlignment(Pos.CENTER_LEFT);
        
        NavigationTab playTab = new NavigationTab("Play");
        NavigationTab dlcTab = new NavigationTab("DLC");
        NavigationTab faqTab = new NavigationTab("FAQ");
        NavigationTab installTab = new NavigationTab("Installation");
        NavigationTab patchTab = new NavigationTab("Patch Notes");
        
        // Set Play as selected by default
        playTab.setSelected(true);
        
        navigationTabs.addAll(List.of(playTab, dlcTab, faqTab, installTab, patchTab));
        
        // Add click handlers
        for (NavigationTab tab : navigationTabs) {
            tab.setOnMouseClicked(e -> {
                selectNavigationTab(tab);
            });
        }
        
        navbar.getChildren().addAll(playTab, dlcTab, faqTab, installTab, patchTab);
        
        return navbar;
    }
    
    private void selectNavigationTab(NavigationTab selected) {
        for (NavigationTab tab : navigationTabs) {
            tab.setSelected(tab == selected);
        }
    }
    
    private StackPane createGameContent() {
        StackPane contentArea = new StackPane();
        contentArea.setStyle("-fx-background-color: #1a1a1a;");
        
        // Game banner - you can replace this with actual game image
        VBox banner = new VBox();
        banner.setAlignment(Pos.CENTER);
        banner.setStyle("-fx-background-color: linear-gradient(to bottom, rgba(255, 100, 50, 0.3), rgba(50, 20, 10, 0.8));");
        
        // Title
        Label gameTitle = new Label("LF LAUNCHER");
        gameTitle.setStyle("-fx-text-fill: white; -fx-font-size: 36px; -fx-font-weight: bold; " +
                          "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 0, 2);");
        
        // You can add an ImageView here for the actual game banner
        // ImageView bannerImage = new ImageView(new Image("path/to/dungeons-banner.png"));
        // bannerImage.setPreserveRatio(true);
        // bannerImage.setFitWidth(800);
        
        banner.getChildren().add(gameTitle);
        contentArea.getChildren().add(banner);
        
        return contentArea;
    }
    
    private HBox createBottomBar() {
        HBox bottomBar = new HBox();
        bottomBar.setPadding(new Insets(20, 30, 20, 30));
        bottomBar.setAlignment(Pos.CENTER);
        bottomBar.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3);");
        
        // Play button in center
        PlayButton playBtn = new PlayButton("PLAY");
        playBtn.setOnMouseClicked(e -> {
            System.out.println("Play button clicked!");
            // Add launch game logic here
        });
        
        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        
        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);
        
        // Player button on right
        Label playerBtn = new Label("Player");
        playerBtn.setStyle("-fx-text-fill: white; -fx-font-size: 12px; -fx-padding: 10; " +
                          "-fx-background-color: rgba(255, 255, 255, 0.1); -fx-background-radius: 5;");
        playerBtn.setCursor(javafx.scene.Cursor.HAND);
        
        bottomBar.getChildren().addAll(leftSpacer, playBtn, rightSpacer, playerBtn);
        
        return bottomBar;
    }
}
