package org.lastfom.lflauncher.ui.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class SidebarButton extends VBox {
    private boolean isSelected = false;
    private final String gameTitle;
    private final String gameSubtitle;
    
    public SidebarButton(String iconPath, String title, String subtitle) {
        this.gameTitle = title;
        this.gameSubtitle = subtitle;
        
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(10, 15, 10, 15));
        setSpacing(5);
        setPrefWidth(130);
        setCursor(Cursor.HAND);
        
        // Icon
        ImageView icon = new ImageView();
        icon.setFitWidth(32);
        icon.setFitHeight(32);
        icon.setPreserveRatio(true);
        
        // Title
        Label titleLabel = new Label(title.toUpperCase());
        titleLabel.setStyle("-fx-text-fill: #B8B8B8; -fx-font-size: 9px; -fx-font-weight: bold;");
        
        // Subtitle
        Label subtitleLabel = new Label(subtitle);
        subtitleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 11px; -fx-font-weight: normal;");
        
        getChildren().addAll(icon, titleLabel, subtitleLabel);
        
        updateStyle();
        
        // Hover effects
        setOnMouseEntered(e -> {
            if (!isSelected) {
                setStyle("-fx-background-color: rgba(255, 255, 255, 0.05); -fx-background-radius: 5;");
            }
        });
        
        setOnMouseExited(e -> {
            if (!isSelected) {
                updateStyle();
            }
        });
    }
    
    public void setSelected(boolean selected) {
        this.isSelected = selected;
        updateStyle();
    }
    
    private void updateStyle() {
        if (isSelected) {
            setStyle("-fx-background-color: rgba(255, 255, 255, 0.1); -fx-background-radius: 5;");
        } else {
            setStyle("-fx-background-color: transparent;");
        }
    }
    
    public String getGameTitle() {
        return gameTitle;
    }
}
