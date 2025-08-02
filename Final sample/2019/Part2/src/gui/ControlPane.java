package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

//You might need to do something to the following line
public class ControlPane extends VBox{
	
	private Text drawnNumberText;
	private Text drawCountText;
	private Text bingoText;
	private Button drawButton;
	private Button newRoundButton;
	private NumberGrid numberGrid;

	
	public ControlPane(NumberGrid numberGrid) {
		// TODO
		this.numberGrid = numberGrid;
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(20);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,  BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.drawnNumberText = new Text();
		this.drawnNumberText.setFont(Font.font(20));
		this.drawCountText = new Text();
		this.initializeBingoText();
		this.initializeDrawButton();
		this.initializeNewRoundButton();
		this.getChildren().addAll(this.getDrawnNumberText(), this.getDrawButton(), this.getNewRoundButton(), this.getBingoText(), this.getDrawCountText());
		BingoUtil.setTextsBeginning(getDrawnNumberText(), getDrawCountText());
	}
	
	private void initializeBingoText() {
		// TODO
		this.bingoText = new Text("Bingo!!");
		this.bingoText.setFont(Font.font(40));
		this.getBingoText().setVisible(false);
	}

	private void initializeDrawButton() {
		// TODO
		this.drawButton = new Button("Draw a number");
		this.drawButton.setPrefWidth(100);
		this.drawButton.setOnAction(events -> this.drawButtonHandler());
	}

	private void initializeNewRoundButton() {
		// TODO
		this.newRoundButton = new Button("New Round");
		this.newRoundButton.setPrefWidth(100);
		this.newRoundButton.setDisable(true);
		this.newRoundButton.setOnAction(events -> this.newRoundButtonHandler());
	}
	
	private void drawButtonHandler() {
		// TODO
		int drawNumber = BingoUtil.drawNumber();
		this.getNumberGrid().highlightNumber(drawNumber);
		
		if (BingoUtil.isBingo(numberGrid)) {
			this.getBingoText().setVisible(true);
			this.getDrawButton().setDisable(true);
			this.getNewRoundButton().setDefaultButton(false);
		}
		BingoUtil.updateTextsAfterDrawn(drawNumber, this.getDrawnNumberText(), this.getDrawCountText());
	}
	
	private void newRoundButtonHandler() {
		// TODO
		BingoUtil.assignRandomNumbers(this.getNumberGrid().getNumberSquares());
		this.getBingoText().setVisible(false);
		this.getDrawButton().setDisable(false);
		this.getNewRoundButton().setDisable(true);
		BingoUtil.setTextsBeginning(this.getDrawnNumberText(), this.getDrawCountText());
	}

	public Text getDrawnNumberText() {
		return drawnNumberText;
	}

	public Text getDrawCountText() {
		return drawCountText;
	}

	public Text getBingoText() {
		return bingoText;
	}

	public Button getDrawButton() {
		return drawButton;
	}

	public Button getNewRoundButton() {
		return newRoundButton;
	}

	public NumberGrid getNumberGrid() {
		return numberGrid;
	}
	
}
