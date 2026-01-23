package org.lastfom.lflauncher.ui.fragments;

import javafx.scene.layout.BorderPane;

public abstract class BaseFragment extends BorderPane {
    
    protected String fragmentName;
    
    public BaseFragment(String fragmentName) {
        this.fragmentName = fragmentName;
        initializeFragment();
    }
    
    protected abstract void initializeFragment();
    
    public String getFragmentName() {
        return fragmentName;
    }
    
    public void onShow() {
        // Override nếu cần xử lý khi fragment được hiển thị
    }
    
    public void onHide() {
        // Override nếu cần xử lý khi fragment bị ẩn
    }
}
