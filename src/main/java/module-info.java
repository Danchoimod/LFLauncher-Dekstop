module org.lastfom.lflauncher {
    requires javafx.controls;
    requires javafx.fxml;

    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens org.lastfom.lflauncher to javafx.fxml;
    exports org.lastfom.lflauncher;
}