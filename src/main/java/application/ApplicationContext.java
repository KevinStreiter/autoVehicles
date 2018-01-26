package application;



import grid.GridWorldVehicle;
import grid.impl.LightLayer;
import grid.impl.VehicleLayer;
import javafx.scene.image.Image;
import logic.SettingsController;
import logic.impl.SettingsControllerImpl;
import logic.vehicle.Creature;
/**
 * This class holds all the important information for the whole Application
 * @author Kevin Streiter, Andreas Ott, Joël Zimmerli,Sahin Bayram, Matthias Meichtry
 *
 */

public class ApplicationContext {

    private int WINDOWWIDTH = 1000;
    private int WINDOWHEIGHT = 800;
    private SettingsController settingsController;
    private LightLayer lightLayer;
    private GridWorldVehicle<Creature,Creature>vehicleLayer;
    private Image imageVehicle;
    public ApplicationContext(){
        settingsController = new SettingsControllerImpl();
        lightLayer = new LightLayer();
        vehicleLayer = new VehicleLayer<>(this);
        imageVehicle = new Image("VehicleImage.jpg");
    }

    public LightLayer getLightGrid() {
		return lightLayer;
	}

	public GridWorldVehicle<Creature,Creature> getVehicleGrid() {
		return vehicleLayer;
	}
    public SettingsController getSettingsController(){
        return this.settingsController;
    }

    public Image getImageVehicle(){
        return imageVehicle;
    }

    public int getWindowWidth() {
        return WINDOWWIDTH;
    }

    public int getWindowHeight() {
        return WINDOWHEIGHT;
    }
}
