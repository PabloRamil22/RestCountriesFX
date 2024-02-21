package com.ceica.restcountriesfx;

import com.ceica.restcountriesfx.Models.CountryDTO;
import com.ceica.restcountriesfx.Services.FakeRestCountriesService;
import com.ceica.restcountriesfx.Services.RestCountriesService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RestCountriesController {

    @FXML
    protected ComboBox comboRegion;
    @FXML
    protected TextField txtCountryName;
    @FXML
    protected TextField txtCountryPopulation;
    @FXML
    protected  TextField txtCountryCoin;
    @FXML
    protected TextField txtCountryCapital;
    @FXML
    protected TableView <CountryDTO> countryColum;
    @FXML
    protected TableColumn <CountryDTO, String> countryNameColum;
    @FXML
    protected ImageView imgFlag;
    private ObservableList<CountryDTO> observableList= FXCollections.observableArrayList();

    @FXML
public void initialize() {
        RestCountriesService fakeRestCountriesService = new RestCountriesService();
        comboRegion.getItems().addAll(fakeRestCountriesService.getRegions());
        comboRegion.setOnAction(e -> {
            if (comboRegion.getSelectionModel().getSelectedItem() != null) {
                String region = comboRegion.getSelectionModel().getSelectedItem().toString();
                observableList.clear();
                observableList.addAll(fakeRestCountriesService.getCountriesByRegion(region));
                countryColum.setItems(observableList);
            }
        });
        //Evento para poder clickar en la interfaz de JavaFX
        countryColum.setOnMouseClicked(e -> {
            String countryCca3 = countryColum.getSelectionModel().getSelectedItem().getCca3();
            CountryDTO countryDTO = fakeRestCountriesService.getCountryByCca3(countryCca3);
            txtCountryName.setText(countryDTO.getName());
            txtCountryCapital.setText(countryDTO.getCapital());
            txtCountryPopulation.setText(String.valueOf(countryDTO.getPopulation()));
            txtCountryCoin.setText(countryDTO.getCoin());
            Image image = new Image(countryDTO.getFlag());
            imgFlag.setImage(image);

        });
        //Evento para navegar en la interfaz mediante las flechas del teclado sube arriba y abajo
        countryColum.setOnKeyPressed(e ->{
            String countryCca3 = countryColum.getSelectionModel().getSelectedItem().getCca3();
            CountryDTO countryDTO = fakeRestCountriesService.getCountryByCca3(countryCca3);
            txtCountryName.setText(countryDTO.getName());
            txtCountryCapital.setText(countryDTO.getCapital());
            txtCountryPopulation.setText(String.valueOf(countryDTO.getPopulation()));
            txtCountryCoin.setText(countryDTO.getCoin());
            Image image = new Image(countryDTO.getFlag());
            imgFlag.setImage(image);
        });

        countryNameColum.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));

    }

    @FXML
    public void btnClear(ActionEvent actionEvent) {
        observableList.clear();
        countryColum.refresh();
        comboRegion.getSelectionModel().clearSelection();
        txtCountryName.setText("");
        txtCountryCapital.setText("");
        txtCountryCoin.setText("");
        txtCountryPopulation.setText("");
        imgFlag.setImage(null);
    }
}