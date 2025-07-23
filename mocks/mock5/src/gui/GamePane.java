package gui;

import javafx.scene.layout.GridPane;
import logic.GameSystem;
import logic.Map;

import java.util.ArrayList;
import java.util.List;

public class GamePane extends GridPane { // 23.18 min
    private static final int GAME_SIZE = 620;
    private static GamePane instance;
    private List<List<CellPane>> gridCellPane;
    private double tileSize;

    private GamePane() {
        super();
        this.setPrefWidth(GAME_SIZE);
        this.setPrefHeight(GAME_SIZE);
    }

    public static GamePane getInstance() {
        if (instance == null) {
            instance = new GamePane();
        }
        return instance;
    }

    public void initTiles() {
        this.getChildren().clear();
        Map map = GameSystem.getInstance().getCurrentMap();
        this.tileSize = GAME_SIZE / (Math.max(map.getWidth(), map.getHeight()) * 1.0);
        this.gridCellPane = new ArrayList<List<CellPane>>();

        // TODO: Complete the remaining code for this method
        for (int row = 0; row < map.getHeight(); row++) {
        	ArrayList<CellPane> rowList = new ArrayList<>();
        	for (int col = 0; col < map.getWidth(); col++) {
        		CellPane cellPane = new CellPane(this.tileSize, this.tileSize, row, col);
        		rowList.add(cellPane);
        		this.add(cellPane, col, row);
        	}
        	this.gridCellPane.add(rowList);
        }
    }

    public CellPane getCellPane(int row,int col){
        return this.gridCellPane.get(row).get(col);
    }


}
