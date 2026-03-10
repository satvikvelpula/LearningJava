package controller;

import dao.CurrencyDao;
import dao.TransactionDao;
import entity.Currency;
import entity.Transaction;
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
    private final TransactionDao transactionRepository;
    private final ExchangeRate apiModel;
    private final String baseCurrency = "USD";

    public Controller(GUI gui) {
        this.gui = gui;
        this.repository = new CurrencyDao();
        this.transactionRepository = new TransactionDao();
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

    public void addCurrency(Currency currency) throws Exception {
        repository.insertCurrency(currency);
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

        String fromCode = from.split(" - ")[0];
        String toCode = to.split(" - ")[0];

        BigDecimal amount;
        try {
            amount = new BigDecimal(gui.getAmount().getText());
        } catch (NumberFormatException e) {
            resultField.setText("Invalid number");
            return;
        }

        Currency fromCurrency = repository.findCurrency(fromCode);
        Currency toCurrency = repository.findCurrency(toCode);

        BigDecimal fromRate = BigDecimal.valueOf(repository.getRate(fromCode));
        BigDecimal toRate = BigDecimal.valueOf(repository.getRate(toCode));

        BigDecimal result = amount.divide(fromRate, 8, BigDecimal.ROUND_HALF_UP)
                .multiply(toRate)
                .setScale(2, BigDecimal.ROUND_HALF_UP);

        Transaction transaction = new Transaction(fromCurrency, toCurrency, result);
        transactionRepository.insertTransaction(transaction);

        resultField.setText(result.toString());
    }
}
