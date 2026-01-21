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

    // Accent colors (Minecraft Green)
    public static final Color ACCENT_PRIMARY = Color.rgb(60, 170, 60);
    public static final Color ACCENT_HOVER = Color.rgb(80, 200, 80);
    public static final Color ACCENT_PRESSED = Color.rgb(40, 130, 40);

    public static String toHex(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255)
        );
    }

    public static class Styles {

        public static final String SIDEBAR_STYLE
                = "-fx-background-color: " + toHex(BG_DARKER) + ";";

        public static final String CONTENT_STYLE
                = "-fx-background-color: " + toHex(BG_DARK) + ";";

        // Đã đổi sang màu xanh Minecraft
        public static final String PLAY_BUTTON_STYLE
                = "-fx-background-color: linear-gradient(to bottom, #3CAA3C, #288228); "
                + "-fx-background-radius: 5; "
                + "-fx-text-fill: white; "
                + "-fx-font-size: 16px; "
                + "-fx-font-weight: bold;";

        public static final String PLAY_BUTTON_HOVER_STYLE
                = "-fx-background-color: linear-gradient(to bottom, #50C850, #3CAA3C); "
                + "-fx-background-radius: 5; "
                + "-fx-text-fill: white; "
                + "-fx-font-size: 16px; "
                + "-fx-font-weight: bold;";
        public static final String PLAY_BUTTON_PRESSED_STYLE
                = "-fx-background-color: #206120; "
                + "-fx-background-radius: 5; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;";
    }

}
