package org.lastfom.lflauncher.core.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * FileUtils - Các công cụ hỗ trợ xử lý File
 */
public class FileUtils {
    
    /**
     * Lấy thư mục .minecraft
     */
    public static Path getMinecraftDirectory() {
        String os = System.getProperty("os.name").toLowerCase();
        String home = System.getProperty("user.home");
        
        if (os.contains("win")) {
            return Paths.get(System.getenv("APPDATA"), ".minecraft");
        } else if (os.contains("mac")) {
            return Paths.get(home, "Library", "Application Support", "minecraft");
        } else {
            return Paths.get(home, ".minecraft");
        }
    }
    
    /**
     * Tạo thư mục nếu chưa tồn tại
     */
    public static boolean ensureDirectory(Path directory) {
        File dir = directory.toFile();
        if (!dir.exists()) {
            return dir.mkdirs();
        }
        return true;
    }
    
    /**
     * Xóa file/folder
     */
    public static boolean deleteRecursively(File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    deleteRecursively(child);
                }
            }
        }
        return file.delete();
    }
}
