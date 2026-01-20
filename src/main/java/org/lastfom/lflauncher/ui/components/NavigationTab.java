package org.lastfom.lflauncher.ui.components;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;

public class NavigationTab extends Label {
    private boolean isSelected = false;
    
    public NavigationTab(String text) {
        super(text);
        setPadding(new Insets(10, 20, 10, 20));
        setCursor(Cursor.HAND);
        updateStyle();
        
        // Hover effects
        setOnMouseEntered(e -> {
            if (!isSelected) {
                setStyle("-fx-text-fill: white; -fx-font-size: 13px; -fx-background-color: rgba(255, 255, 255, 0.05);");
            }
        });
        
        setOnMouseExited(e -> {
            updateStyle();
        });
    }
    
    public void setSelected(boolean selected) {
        this.isSelected = selected;
        updateStyle();
    }
    
    private void updateStyle() {
        if (isSelected) {
            setStyle("-fx-text-fill: white; -fx-font-size: 13px; -fx-font-weight: bold; " +
                    "-fx-background-color: transparent; -fx-border-color: transparent transparent white transparent; " +
                    "-fx-border-width: 0 0 2 0;");
        } else {
            setStyle("-fx-text-fill: #B8B8B8; -fx-font-size: 13px; -fx-background-color: transparent;");
        }
    }
}
