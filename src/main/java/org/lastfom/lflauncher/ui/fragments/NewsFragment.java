package org.lastfom.lflauncher.ui.fragments;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class NewsFragment extends BaseFragment {
    
    public NewsFragment() {
        super("News");
    }
    
    @Override
    protected void initializeFragment() {
        StackPane contentArea = new StackPane();
        VBox newsContainer = new VBox(20);
        newsContainer.setAlignment(Pos.CENTER);
        newsContainer.setMaxWidth(800);

        Label newsTitle = new Label("LAUNCHER NEWS");
        newsTitle.setStyle("-fx-text-fill: white; -fx-font-size: 42px; -fx-font-weight: bold;");
        
        Label newsDescription = new Label("Stay updated with the latest news and updates from the launcher");
        newsDescription.setStyle("-fx-text-fill: #cccccc; -fx-font-size: 16px;");
        newsDescription.setWrapText(true);
        newsDescription.setAlignment(Pos.CENTER);
        
        Label versionInfo = new Label("Version 1.0.0 - Latest Updates");
        versionInfo.setStyle("-fx-text-fill: #999999; -fx-font-size: 14px;");
        
        newsContainer.getChildren().addAll(newsTitle, newsDescription, versionInfo);
        contentArea.getChildren().add(newsContainer);
        
        this.setCenter(contentArea);
    }
}
