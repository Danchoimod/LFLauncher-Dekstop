package org.lastfom.lflauncher.models;

/**
 * User Model - Đại diện cho thông tin người dùng
 */
public class User {
    private String username;
    private String accountType; // "Microsoft" or "Offline"
    private String uuid;
    private String accessToken;
    
    public User(String username, String accountType) {
        this.username = username;
        this.accountType = accountType;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getAccessToken() {
        return accessToken;
    }
    
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
