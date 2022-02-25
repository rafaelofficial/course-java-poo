package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController {

	@FXML
	private TextField txtNumberOne;

	@FXML
	private TextField txtNumberTwo;

	@FXML
	private Label labelResult;

	@FXML
	private Button btnSum;

	@FXML
	public void btnSumAction() {
		try {
			double numberOne = Double.parseDouble(txtNumberOne.getText());
			double numberTwo = Double.parseDouble(txtNumberTwo.getText());
			double sum = numberOne + numberTwo;

			labelResult.setText(String.format("%.2f", sum));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Parse error", null, e.getMessage(), AlertType.ERROR);
		}
	}
}
