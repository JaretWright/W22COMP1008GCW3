package com.example.w22comp1008gcw3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class CardViewController implements Initializable {

    @FXML
    private Label cardLabel;

    @FXML
    private Label faceNameLabel;

    @FXML
    private Label suitLabel;

    @FXML
    private Label cardValueLabel;

    @FXML
    private ImageView imageView;

    private DeckOfCards deck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //create a DeckOfCards
        deck = new DeckOfCards();
        viewNextCard();
    }

    @FXML
    private void viewNextCard() {
        Card card = deck.dealTopCard();

        //update the Labels with the Card information
        cardLabel.setText(card.toString());
        cardValueLabel.setText(Integer.toString(card.getFaceValue()));
        faceNameLabel.setText(card.getFaceName());
        suitLabel.setText(card.getSuit());
        imageView.setImage(card.getCardImage());
    }
}
