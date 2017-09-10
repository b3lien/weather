package com.ak.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private final static String surl="http://api.apixu.com/v1/current.json?key=d578c483ed8b494bad8170534161511&q=Warsaw";
    private final static String coldImage="http://www.personal.psu.edu/afr3/blogs/siowfa12/cold.jpg";
    private static final String hotImage="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQSmmmLN1JfEkCvdvbhIDsQw_xAJQ5QKjVxmQ0lXlq3pbJ-vts4";
    private static final String decentImage="https://d.iplsc.com/weather/svg-icons/2_d.svg";

    //referencje na kontrolki
    @FXML
    private ImageView image;

    @FXML
    private Label temperature;

    @FXML
    private Label temperaturef;

    public void initialize(URL location, ResourceBundle resources) {
        temperature.setText("Pobieranie danych pogody");
        try {
            URL url = new URL(surl);
            //jsonowy root
            JSONObject json = new JSONObject(IOUtils.toString(url));

            //chcemy pobrać zawartość taga "current"
            JSONObject json2 = (JSONObject) json.get("current");

            //pobieramy temperature w postaci tekstowej w C
            String sstemp = json2.get("temp_c").toString();
            String fstemp = json2.get("temp_f").toString();
            Double temp = Double.parseDouble(sstemp);
            Double tempf = Double.parseDouble(fstemp);
            Image im = null;
            if (temp < 15) {
                im = new Image(coldImage);
            }else if (temp > 15) {
                im = new Image(hotImage);
            } else {
                im = new Image(decentImage);
            }
            if (im !=null){
                image.setImage(im);
            }
            temperature.setText("Srednia temperatura: " + temp);
            temperaturef.setText("Srednia temperatura w F to: " + tempf);

            System.out.println(json.toString());
        } catch (MalformedURLException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
