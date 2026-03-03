package controller;

import dao.CurrencyDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import model.CurrencyDBHandler;
import model.ExchangeRate;
import view.GUI;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Controller {

    private final GUI gui;
    private final CurrencyDao repository;
    private final ExchangeRate apiModel;
    private final String baseCurrency = "USD";

    public Controller(GUI gui) {
        this.gui = gui;
        this.repository = new CurrencyDao();
        this.apiModel = new ExchangeRate();
    }

    // Fetch API and update DB
    public void updateDatabaseFromAPI() throws Exception {
        apiModel.fetchData(baseCurrency);
        Map<String, BigDecimal> rates = apiModel.getConversionRates();
        CurrencyDBHandler.updateCurrencies(rates);
    }

    // Populate ComboBoxes with DB currencies
    public void populateCurrencyComboBoxes() throws Exception {
        List<String> codes = repository.getAllCurrencyCodes();
        ObservableList<String> observable = FXCollections.observableArrayList(codes);
        gui.getFromCurrencies().setItems(observable);
        gui.getToCurrencies().setItems(observable);
    }

    // Perform conversion
    public void conversion() throws Exception {
        TextField resultField = gui.getResultField();
        String from = gui.getFromCurrencies().getValue();
        String to = gui.getToCurrencies().getValue();
        if (from == null || to == null || gui.getAmount().getText().trim().isEmpty()) {
            resultField.setText("Enter valid values");
            return;
        }

        BigDecimal amount;
        try {
            amount = new BigDecimal(gui.getAmount().getText());
        } catch (NumberFormatException e) {
            resultField.setText("Invalid number");
            return;
        }

        BigDecimal fromRate = BigDecimal.valueOf(repository.getRate(from));
        BigDecimal toRate = BigDecimal.valueOf(repository.getRate(to));

        BigDecimal result = amount.divide(fromRate, 8, BigDecimal.ROUND_HALF_UP)
                .multiply(toRate)
                .setScale(2, BigDecimal.ROUND_HALF_UP);

        resultField.setText(result.toString());
    }
}
