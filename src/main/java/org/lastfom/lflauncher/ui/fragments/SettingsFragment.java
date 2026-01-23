package org.lastfom.lflauncher.ui.fragments;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SettingsFragment extends BaseFragment {
    
    public SettingsFragment() {
        super("Settings");
    }
    
    @Override
    protected void initializeFragment() {
        this.setStyle("-fx-background-color: #3a3a3a;");
        
        VBox content = createContent();
        this.setCenter(content);
    }
    
    private VBox createContent() {
        VBox content = new VBox(25);
        content.setPadding(new Insets(25, 30, 25, 30));
        
        VBox selectJavaSection = createSelectJavaSection();
        VBox javaSettingsSection = createJavaSettingsSection();
        
        content.getChildren().addAll(selectJavaSection, javaSettingsSection);
        return content;
    }
    
    private VBox createSelectJavaSection() {
        VBox section = new VBox(15);
        
        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER_LEFT);
        
        Label icon = new Label("⚙");
        icon.setStyle("-fx-text-fill: #999999; -fx-font-size: 18px;");
        
        Label title = new Label("Select Java");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        
        header.getChildren().addAll(icon, title);
        
        ToggleGroup group = new ToggleGroup();
        
        RadioButton recommendedRadio = new RadioButton("Recommended");
        recommendedRadio.setToggleGroup(group);
        recommendedRadio.setSelected(true);
        recommendedRadio.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        
        Label recommendedDesc = new Label("Launcher will handle everything automatically");
        recommendedDesc.setStyle("-fx-text-fill: #aaaaaa; -fx-font-size: 12px; -fx-padding: 0 0 0 25;");
        
        RadioButton currentOnlyRadio = new RadioButton("Current only");
        currentOnlyRadio.setToggleGroup(group);
        currentOnlyRadio.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        
        Label currentOnlyDesc = new Label("Use the same JRE this launcher runs on. Some versions may not start, because they require a different version of Java.");
        currentOnlyDesc.setStyle("-fx-text-fill: #aaaaaa; -fx-font-size: 12px; -fx-padding: 0 0 0 25;");
        currentOnlyDesc.setWrapText(true);
        currentOnlyDesc.setMaxWidth(600);
        
        RadioButton customRadio = new RadioButton("Custom");
        customRadio.setToggleGroup(group);
        customRadio.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        
        Label customDesc = new Label("If you need to install custom Java, this is for you");
        customDesc.setStyle("-fx-text-fill: #aaaaaa; -fx-font-size: 12px; -fx-padding: 0 0 0 25;");
        
        section.getChildren().addAll(
            header,
            recommendedRadio, recommendedDesc,
            currentOnlyRadio, currentOnlyDesc,
            customRadio, customDesc
        );
        
        return section;
    }
    
    private VBox createJavaSettingsSection() {
        VBox section = new VBox(15);
        
        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER_LEFT);
        
        Label icon = new Label("⚙");
        icon.setStyle("-fx-text-fill: #999999; -fx-font-size: 18px;");
        
        Label title = new Label("Java settings");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        
        header.getChildren().addAll(icon, title);
        
        VBox pathField = createLabeledField("Path", "Install selected Minecraft version to find out recommended Java here.");
        VBox javaArgsField = createInputField("Java arguments", "e.g. -agentlib, -Xms, -Dfml");
        
        CheckBox sslCheckbox = new CheckBox("Update outdated SSL certificate storage");
        sslCheckbox.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        sslCheckbox.setSelected(true);
        
        VBox jvmArgsField = createComboBoxField("Improved JVM arguments", "Default (will use G1 or CMS GC) (recommended)");
        VBox mcArgsField = createInputField("Minecraft arguments", "e.g. --server, --port");
        VBox wrapperField = createInputField("Wrapper command", "e.g. mangohud --dlsym %command%");
        
        section.getChildren().addAll(
            header,
            pathField,
            javaArgsField,
            sslCheckbox,
            jvmArgsField,
            mcArgsField,
            wrapperField
        );
        
        return section;
    }
    
    private VBox createLabeledField(String labelText, String valueText) {
        VBox field = new VBox(5);
        
        Label label = new Label(labelText);
        label.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        
        Label value = new Label(valueText);
        value.setStyle("-fx-text-fill: #aaaaaa; -fx-font-size: 12px;");
        value.setWrapText(true);
        value.setMaxWidth(600);
        
        field.getChildren().addAll(label, value);
        return field;
    }
    
    private VBox createInputField(String labelText, String placeholder) {
        VBox field = new VBox(5);
        
        Label label = new Label(labelText);
        label.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        
        TextField textField = new TextField();
        textField.setPromptText(placeholder);
        textField.setStyle(
            "-fx-background-color: #4a4a4a; " +
            "-fx-text-fill: white; " +
            "-fx-prompt-text-fill: #777777; " +
            "-fx-padding: 8 12; " +
            "-fx-font-size: 12px; " +
            "-fx-border-color: transparent; " +
            "-fx-background-radius: 3; " +
            "-fx-border-radius: 3;"
        );
        textField.setMaxWidth(600);
        
        field.getChildren().addAll(label, textField);
        return field;
    }
    
    private VBox createComboBoxField(String labelText, String defaultValue) {
        VBox field = new VBox(5);
        
        Label label = new Label(labelText);
        label.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
            "Default (will use G1 or CMS GC) (recommended)",
            "Custom G1 GC",
            "Custom CMS GC"
        );
        comboBox.setValue(defaultValue);
        comboBox.setStyle(
            "-fx-background-color: #4a4a4a; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 12px;"
        );
        comboBox.setMaxWidth(600);
        
        field.getChildren().addAll(label, comboBox);
        return field;
    }
}
