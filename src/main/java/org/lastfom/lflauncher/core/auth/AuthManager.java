package org.lastfom.lflauncher.core.auth;

/**
 * AuthManager - Xử lý đăng nhập Microsoft/Offline
 * TODO: Implement Microsoft OAuth and offline authentication
 */
public class AuthManager {
    
    /**
     * Đăng nhập bằng tài khoản Microsoft
     */
    public boolean loginMicrosoft() {
        // TODO: Implement Microsoft OAuth flow
        System.out.println("Microsoft login not yet implemented");
        return false;
    }
    
    /**
     * Đăng nhập Offline
     */
    public boolean loginOffline(String username) {
        // TODO: Implement offline login
        System.out.println("Offline login: " + username);
        return true;
    }
    
    /**
     * Đăng xuất
     */
    public void logout() {
        // TODO: Clear tokens and user data
        System.out.println("User logged out");
    }
    
    /**
     * Kiểm tra token còn hiệu lực
     */
    public boolean validateToken(String token) {
        // TODO: Validate access token
        return false;
    }
}
