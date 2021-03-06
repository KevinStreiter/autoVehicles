package present.settings;

import application.ApplicationContext;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.SettingsController;
/**
 * This class provides the view of possible Settings in the Interface
 * @author Sahin Bayram, Andreas Ott, Gregor von Gunten, Mattias Meichtry
 *
 */

public class Settings extends StackPane {
    SettingsController settingsController;
    public Settings(ApplicationContext applicationContext){
        settingsController = applicationContext.getSettingsController();
        final HBox controlPanel = new HBox();
        controlPanel.setPadding(new Insets(0, 0, 10, 0));
        controlPanel.setAlignment(Pos.CENTER);
        final Label vehicleCountLabel = new Label("Number of vehicles: ");
        final Label vehicleSpeedLabel = new Label("Speed: ");
        Slider vehicleCount = new Slider();
        Slider vehicleSpeed = new Slider();
        Label count = new Label();
        vehicleCount.setMin(1);
        vehicleCount.setMax(100);
        vehicleCount.setValue(10);
        vehicleSpeed.setMin(1);
        vehicleSpeed.setMax(100);
        vehicleSpeed.setValue(10);

        settingsController.setVehicleCount(100);
        settingsController.setVehicleSpeed(50);
        settingsController.setSliders(vehicleCount, vehicleSpeed);
        vehicleCount.valueProperty().addListener((observable, oldValue, newValue) -> settingsController.setVehicleCount(newValue.intValue()));
        vehicleSpeed.valueProperty().addListener((observable, oldValue, newValue) -> settingsController.setVehicleSpeed(newValue.intValue()));
        count.setText(String.valueOf(settingsController.getVehicleCount()));
        settingsController.addListener(() -> {count.setText(String.valueOf(settingsController.getVehicleCount()));});

        controlPanel.getChildren().add(vehicleCountLabel);
        controlPanel.getChildren().add(vehicleCount);
        controlPanel.getChildren().add(count);
        controlPanel.getChildren().add(vehicleSpeedLabel);
        controlPanel.getChildren().add(vehicleSpeed);

        VBox vBox = new VBox();
        vBox.getChildren().add(controlPanel);
        vBox.setPadding(new Insets(10));
        getChildren().add(vBox);
    }

}
