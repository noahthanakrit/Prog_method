package gui.selector;

import io.MapParser;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.Map;

public class MapSelectorPane extends VBox {
    private static final String[] fileList = {"01.txt", "02.txt", "03.txt", "04.txt", "05.txt"};
    private static MapSelectorPane instance;

    private MapSelectorPane() {
        // TODO: Complete the remaining code of the constructor
    	super();
    	this.setPrefWidth(400);
    	this.setPrefHeight(600);
    	this.setAlignment(Pos.TOP_CENTER);
    	this.setSpacing(10);
    	this.setBackground(new Background(new BackgroundFill(Color.web("#EEF7FF"), null, null)));
    	this.setPadding(new Insets(10, 0, 10, 0));

        for (String file: fileList) {
            Map map = MapParser.readFile("maps/" + file);
            if (map == null) {
                continue;
            }
            // TODO: Add new MapButtonPane for each map here
            MapButtonPane MBP = new MapButtonPane(map);
            this.getChildren().add(MBP);


        }
    }

    public static MapSelectorPane getInstance() {
        if (instance == null) {
            instance = new MapSelectorPane();
        }
        return instance;
    }
}
