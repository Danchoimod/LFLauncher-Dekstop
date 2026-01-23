package org.lastfom.lflauncher.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import org.lastfom.lflauncher.ui.components.NavigationTab;
import org.lastfom.lflauncher.ui.components.PlayButton;
import org.lastfom.lflauncher.ui.styles.Theme;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class WindowsEditionFragment extends BaseFragment {
    
    private List<NavigationTab> navigationTabs;
    
    public WindowsEditionFragment() {
        super("Windows Edition");
    }
    
    @Override
    protected void initializeFragment() {
        this.navigationTabs = new ArrayList<>();
        this.setTop(createNavigationBar());
        this.setCenter(createGameContent());
        this.setBottom(createBottomBar());
    }
    
    private HBox createNavigationBar() {
        HBox navbar = new HBox(20);
        navbar.setAlignment(Pos.CENTER_LEFT);
        navbar.setPadding(new Insets(25, 30, 10, 30));
        navbar.setMinHeight(60);
        
        NavigationTab playTab = new NavigationTab("Play");
        NavigationTab dlcTab = new NavigationTab("DLC");
        NavigationTab storeTab = new NavigationTab("Store");
        NavigationTab realmsTab = new NavigationTab("Realms");
        
        playTab.setSelected(true);
        navigationTabs.addAll(List.of(playTab, dlcTab, storeTab, realmsTab));
        
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
        VBox titleContainer = new VBox(10);
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setMouseTransparent(true); 

        Label title = new Label("MINECRAFT");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 40px; -fx-font-weight: bold;");
        
        Label subtitle = new Label("for Windows");
        subtitle.setStyle("-fx-text-fill: #888888; -fx-font-size: 20px;");
        
        titleContainer.getChildren().addAll(title, subtitle);
        contentArea.getChildren().add(titleContainer);
        return contentArea;
    }
    
    private StackPane createBottomBar() {
        StackPane bottomBar = new StackPane();
        bottomBar.setPadding(new Insets(0, 40, 0, 40));
        bottomBar.setMinHeight(80);
        bottomBar.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);");
        
        PlayButton playBtn = new PlayButton("PLAY");
        playBtn.setPrefWidth(220);
        playBtn.setPrefHeight(55);
        playBtn.setMaxWidth(250);
        
        playBtn.setStyle(Theme.Styles.PLAY_BUTTON_STYLE);
        playBtn.setOnMouseEntered(e -> playBtn.setStyle(Theme.Styles.PLAY_BUTTON_HOVER_STYLE));
        playBtn.setOnMouseExited(e -> playBtn.setStyle(Theme.Styles.PLAY_BUTTON_STYLE));
        playBtn.setOnMousePressed(e -> playBtn.setStyle(Theme.Styles.PLAY_BUTTON_PRESSED_STYLE));
        playBtn.setOnMouseReleased(e -> playBtn.setStyle(Theme.Styles.PLAY_BUTTON_HOVER_STYLE));
        
        StackPane.setAlignment(playBtn, Pos.CENTER);
        
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
