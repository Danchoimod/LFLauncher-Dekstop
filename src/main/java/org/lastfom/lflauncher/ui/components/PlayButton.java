package org.lastfom.lflauncher.ui.components;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class PlayButton extends Label {
    
    public PlayButton(String text) {
        super(text);
        
        setPrefSize(160, 45);
        setAlignment(Pos.CENTER);
        setCursor(Cursor.HAND);
        
        // Orange gradient background with shadow
        setStyle("-fx-background-color: linear-gradient(to bottom, #FF9933, #FF7700); " +
                "-fx-background-radius: 5; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 16px; " +
                "-fx-font-weight: bold;");
        
        // Drop shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.5));
        shadow.setRadius(10);
        shadow.setOffsetY(3);
        setEffect(shadow);
        
        // Hover effects
        setOnMouseEntered(e -> {
            setStyle("-fx-background-color: linear-gradient(to bottom, #FFB366, #FF8833); " +
                    "-fx-background-radius: 5; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-weight: bold;");
        });
        
        setOnMouseExited(e -> {
            setStyle("-fx-background-color: linear-gradient(to bottom, #FF9933, #FF7700); " +
                    "-fx-background-radius: 5; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-weight: bold;");
        });
        
        setOnMousePressed(e -> {
            setStyle("-fx-background-color: linear-gradient(to bottom, #FF7700, #FF6600); " +
                    "-fx-background-radius: 5; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-weight: bold;");
        });
        
        setOnMouseReleased(e -> {
            setStyle("-fx-background-color: linear-gradient(to bottom, #FFB366, #FF8833); " +
                    "-fx-background-radius: 5; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-weight: bold;");
        });
    }
}
