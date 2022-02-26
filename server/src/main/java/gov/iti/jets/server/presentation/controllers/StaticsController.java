package gov.iti.jets.server.presentation.controllers;

import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.server.services.impls.StatisticServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.security.Key;
import java.util.Map;
import java.util.ResourceBundle;

public class StaticsController implements Initializable {
    StatisticServiceImpl statistic = StatisticServiceImpl.getInstance();
    @FXML
    private BarChart barChart;


    @FXML
    private Label noAvailableLabel;

    @FXML
    private Label noAwayLabel;

    @FXML
    private Label noBusyLabel;

    @FXML
    private Label noOflineLabel;

    @FXML
    private PieChart pieChart;


    @FXML
    private VBox staticsVBox;


    @FXML
    void handelRefreshActionIcon(MouseEvent event) {
        getStattistics();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getStattistics();
    }

    private void getStattistics(){
        Map<String, Integer> countryMap = statistic.getCountryStatistic();
        //System.out.println(barChart.getData().size());
        if(barChart.getData().size() > 0) {
            barChart.getData().clear();
        }
        //System.out.println("After clear "+barChart.getData().size());
        for (Map.Entry<String, Integer> entry : countryMap.entrySet()) {
            countryMap = statistic.getCountryStatistic();
            XYChart.Series series = new XYChart.Series();
            String key = entry.getKey();
            Integer value = entry.getValue();
            series.getData().add(new XYChart.Data(key, value));
            barChart.getData().addAll(series);
        }
        Map<String, Integer> genderMap = statistic.getGenderStatistic();
        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : genderMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            chartData.add(new PieChart.Data(key, value));
        }
        pieChart.setData(chartData);

        Map<String, Integer> statusMap = statistic.getStatusStatistic();
        for (Map.Entry<String, Integer> entry : statusMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (key.equals(Status.AVAILABLE.name())) {
                noAvailableLabel.setText(String.valueOf(value));
            } else if (key.equals(Status.BUSY.name())) {
                noBusyLabel.setText(String.valueOf(value));
            } else if (key.equals(Status.AWAY.name())) {
                noAwayLabel.setText(String.valueOf(value));
            } else if (key.equals(Status.OFFLINE.name())) {
                noOflineLabel.setText(String.valueOf(value));
            }

        }
    }

}
