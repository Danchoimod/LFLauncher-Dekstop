package org.lastfom.lflauncher.core.utils;

/**
 * OSUtils - OS detection và system information
 */
public class OSUtils {
    
    public enum OS {
        WINDOWS, MAC, LINUX, UNKNOWN
    }
    
    /**
     * Phát hiện hệ điều hành
     */
    public static OS getOperatingSystem() {
        String os = System.getProperty("os.name").toLowerCase();
        
        if (os.contains("win")) {
            return OS.WINDOWS;
        } else if (os.contains("mac")) {
            return OS.MAC;
        } else if (os.contains("nux") || os.contains("nix")) {
            return OS.LINUX;
        }
        return OS.UNKNOWN;
    }
    
    /**
     * Lấy kiến trúc CPU
     */
    public static String getArchitecture() {
        return System.getProperty("os.arch");
    }
    
    /**
     * Kiểm tra xem có phải 64-bit không
     */
    public static boolean is64Bit() {
        return System.getProperty("os.arch").contains("64");
    }
    
    /**
     * Lấy số lượng RAM khả dụng (MB)
     */
    public static long getAvailableMemory() {
        return Runtime.getRuntime().maxMemory() / (1024 * 1024);
    }
}
