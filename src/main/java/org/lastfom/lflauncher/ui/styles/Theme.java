package org.lastfom.lflauncher.ui.styles;

import javafx.scene.paint.Color;

public class Theme {
    
    // Background colors
    public static final Color BG_DARK = Color.rgb(26, 26, 26);
    public static final Color BG_DARKER = Color.rgb(15, 15, 15);
    public static final Color BG_OVERLAY = Color.rgb(0, 0, 0, 0.3);
    
    // Text colors
    public static final Color TEXT_PRIMARY = Color.WHITE;
    public static final Color TEXT_SECONDARY = Color.rgb(184, 184, 184);
    public static final Color TEXT_MUTED = Color.rgb(136, 136, 136);
    
    // Accent colors (Minecraft Orange)
    public static final Color ACCENT_PRIMARY = Color.rgb(255, 153, 51);
    public static final Color ACCENT_HOVER = Color.rgb(255, 179, 102);
    public static final Color ACCENT_PRESSED = Color.rgb(255, 119, 0);
    
    // Utility methods
    public static String toRGBA(Color color) {
        return String.format("rgba(%d, %d, %d, %.2f)",
            (int)(color.getRed() * 255),
            (int)(color.getGreen() * 255),
            (int)(color.getBlue() * 255),
            color.getOpacity()
        );
    }
    
    public static String toHex(Color color) {
        return String.format("#%02X%02X%02X",
            (int)(color.getRed() * 255),
            (int)(color.getGreen() * 255),
            (int)(color.getBlue() * 255)
        );
    }
    
    // CSS Styles
    public static class Styles {
        public static final String SIDEBAR_STYLE = 
            "-fx-background-color: " + toHex(BG_DARKER) + ";";
        
        public static final String CONTENT_STYLE = 
            "-fx-background-color: " + toHex(BG_DARK) + ";";
        
        public static final String PLAY_BUTTON_STYLE = 
            "-fx-background-color: linear-gradient(to bottom, #FF9933, #FF7700); " +
            "-fx-background-radius: 5; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 16px; " +
            "-fx-font-weight: bold;";
        
        public static final String PLAY_BUTTON_HOVER_STYLE = 
            "-fx-background-color: linear-gradient(to bottom, #FFB366, #FF8833); " +
            "-fx-background-radius: 5; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 16px; " +
            "-fx-font-weight: bold;";
    }
}
