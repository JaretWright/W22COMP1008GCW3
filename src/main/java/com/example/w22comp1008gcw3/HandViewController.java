package com.example.w22comp1008gcw3;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HandViewController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView deckImageView;

    private DeckOfCards deck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new DeckOfCards();
        deck.shuffle();
    }

    @FXML
    private void dealCards()
    {
        //establish where the "deck" of cards ImageView is
        Bounds boundsForImageView = deckImageView.localToScene(deckImageView.getBoundsInLocal());
        double deckPositionX = boundsForImageView.getMinX();
        double deckPositionY = boundsForImageView.getMinY();

        for (int i=1 ; i<=10 ; i++)
        {
            //create a new card and place the card Image in an ImageView
            Card card = deck.dealTopCard();
            ImageView imageView = new ImageView();
            imageView.setFitWidth(190);
            imageView.setFitHeight(287);
            imageView.setLayoutX(deckPositionX);
            imageView.setLayoutY(deckPositionY);

            imageView.setImage(card.getCardImage());

            anchorPane.getChildren().add(imageView);

            //animate the card to move right
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(imageView);
            transition.setDuration(Duration.millis(2000));
            transition.setByX(300 + (i*50));
            transition.play();
        }

    }
}
