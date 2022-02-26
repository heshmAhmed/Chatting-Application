package gov.iti.jets.server.presentation.controllers;

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
import javafx.scene.layout.VBox;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.security.Key;
import java.util.Map;
import java.util.ResourceBundle;

public class StaticsController implements Initializable {

    StatisticServiceImpl statistic = StatisticServiceImpl.getInstance();
    Map<String, Integer> genderMap = statistic.getGenderStatistic();
    Map<String, Integer> countryMap = statistic.getCountryStatistic();
    Map<String, Integer> statusMap = statistic.getStatusStatistic();




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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();
        for ( Map.Entry<String,Integer> entry : genderMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            chartData.add(new PieChart.Data(key , value));
        }

        pieChart.setData(chartData);



        for ( Map.Entry<String,Integer> entry : countryMap.entrySet()) {
            XYChart.Series series1 = new XYChart.Series();
            String key = entry.getKey();
            Integer value = entry.getValue();
            series1.getData().add(new XYChart.Data(key,value));
            barChart.getData().addAll(series1);

        }


        for ( Map.Entry<String,Integer> entry : statusMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
             if(key.equals("available")) {
                 noAvailableLabel.setText(String.valueOf(value));
             }
            else if(key.equals("busy")) {
                 noBusyLabel.setText(String.valueOf(value));
            }

            else if(key.equals("away")) {
                 noAwayLabel.setText(String.valueOf(value));
            }

             else if(key.equals("offline")) {
                 noOflineLabel.setText(String.valueOf(value));
             }

        }


    }
}
