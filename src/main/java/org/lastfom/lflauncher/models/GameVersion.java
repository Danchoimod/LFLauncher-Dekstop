package org.lastfom.lflauncher.models;

/**
 * GameVersion Model - Đại diện cho phiên bản game Minecraft
 */
public class GameVersion {
    private String id;
    private String type; // "release", "snapshot", "old_beta", etc.
    private String releaseTime;
    private boolean isInstalled;
    
    public GameVersion(String id, String type) {
        this.id = id;
        this.type = type;
        this.isInstalled = false;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getReleaseTime() {
        return releaseTime;
    }
    
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
    
    public boolean isInstalled() {
        return isInstalled;
    }
    
    public void setInstalled(boolean installed) {
        isInstalled = installed;
    }
}
