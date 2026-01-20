package org.lastfom.lflauncher.viewmodels;

import org.lastfom.lflauncher.models.User;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * MainViewModel - Trung gian kết nối UI và Core cho màn hình chính
 * Sử dụng JavaFX Properties để hỗ trợ data binding
 */
public class MainViewModel {
    
    private final ObjectProperty<User> currentUser = new SimpleObjectProperty<>();
    private final StringProperty selectedGame = new SimpleStringProperty("Dungeons");
    private final StringProperty selectedTab = new SimpleStringProperty("Play");
    private final BooleanProperty isGameRunning = new SimpleBooleanProperty(false);
    
    public MainViewModel() {
        // Initialize with default user
        currentUser.set(new User("MinecraftDigBug", "Microsoft"));
    }
    
    // User properties
    public ObjectProperty<User> currentUserProperty() {
        return currentUser;
    }
    
    public User getCurrentUser() {
        return currentUser.get();
    }
    
    public void setCurrentUser(User user) {
        currentUser.set(user);
    }
    
    // Selected game properties
    public StringProperty selectedGameProperty() {
        return selectedGame;
    }
    
    public String getSelectedGame() {
        return selectedGame.get();
    }
    
    public void setSelectedGame(String game) {
        selectedGame.set(game);
    }
    
    // Selected tab properties
    public StringProperty selectedTabProperty() {
        return selectedTab;
    }
    
    public String getSelectedTab() {
        return selectedTab.get();
    }
    
    public void setSelectedTab(String tab) {
        selectedTab.set(tab);
    }
    
    // Game running state
    public BooleanProperty isGameRunningProperty() {
        return isGameRunning;
    }
    
    public boolean isGameRunning() {
        return isGameRunning.get();
    }
    
    public void setGameRunning(boolean running) {
        isGameRunning.set(running);
    }
    
    /**
     * Launch game action
     */
    public void launchGame() {
        System.out.println("Launching " + selectedGame.get() + "...");
        // TODO: Implement game launch logic from core package
        setGameRunning(true);
    }
}
