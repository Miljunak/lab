package agh.ics.oop;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

public class GuiElementBox {
    public VBox genVBox(IMapElement element) throws FileNotFoundException {

        Image image = element.getImage();

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);

        Label label = new Label( (element instanceof Animal) ? "Z " + element.getPos() : "TRAWA" );

        return new VBox(imageView, label);
    }
}
