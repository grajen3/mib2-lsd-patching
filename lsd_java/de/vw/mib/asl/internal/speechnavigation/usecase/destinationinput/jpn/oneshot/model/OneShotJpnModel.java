/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.model;

import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;

public class OneShotJpnModel
extends OneShotModel {
    public ViewModelItem prefecture;
    public ViewModelItem municipality;
    public ViewModelItem place;
    public ViewModelItem chome;

    public OneShotJpnModel() {
        this(-1, EMPTY_VIEW_MODEL_ITEM, EMPTY_VIEW_MODEL_ITEM, EMPTY_VIEW_MODEL_ITEM, EMPTY_VIEW_MODEL_ITEM, new HouseNumber(-1, ""));
    }

    public OneShotJpnModel(int n) {
        this(n, EMPTY_VIEW_MODEL_ITEM, EMPTY_VIEW_MODEL_ITEM, EMPTY_VIEW_MODEL_ITEM, EMPTY_VIEW_MODEL_ITEM, EMPTY_HOUSENUMBER_ITEM);
    }

    public OneShotJpnModel(int n, ViewModelItem viewModelItem, ViewModelItem viewModelItem2, ViewModelItem viewModelItem3, ViewModelItem viewModelItem4, HouseNumber houseNumber) {
        super(n);
        this.prefecture = viewModelItem;
        this.municipality = viewModelItem2;
        this.place = viewModelItem3;
        this.chome = viewModelItem4;
        this.houseNumber = houseNumber;
    }

    public OneShotJpnModel(int n, int n2, String string) {
        super(n, n2, string);
        this.prefecture = EMPTY_VIEW_MODEL_ITEM;
        this.municipality = EMPTY_VIEW_MODEL_ITEM;
        this.place = EMPTY_VIEW_MODEL_ITEM;
        this.chome = EMPTY_VIEW_MODEL_ITEM;
        this.houseNumber = EMPTY_HOUSENUMBER_ITEM;
    }

    private boolean isViewModelItemValid(ViewModelItem viewModelItem) {
        return viewModelItem != null && viewModelItem.recognizedString != null && viewModelItem.recognizedString.length() > 0;
    }

    public boolean isPrefectureValid() {
        return this.isViewModelItemValid(this.prefecture);
    }

    public boolean isMunicipalityValid() {
        return this.isViewModelItemValid(this.municipality);
    }

    public boolean isPlaceValid() {
        return this.isViewModelItemValid(this.place);
    }

    public boolean isChomeValid() {
        return this.isViewModelItemValid(this.chome);
    }

    @Override
    public boolean isHouseNumberValid() {
        return this.isViewModelItemValid(this.houseNumber);
    }

    public String getNbestHeadlineText() {
        String string = "";
        if (this.isPrefectureValid()) {
            string = this.prefecture.recognizedString;
        }
        if (this.isMunicipalityValid()) {
            string = new StringBuffer().append(string).append(" ").append(this.municipality.recognizedString).toString();
        }
        if (this.isPlaceValid()) {
            string = new StringBuffer().append(string).append(" ").append(this.place.recognizedString).toString();
        }
        if (this.isChomeValid()) {
            string = new StringBuffer().append(string).append(" ").append(this.chome.recognizedString).toString();
        }
        if (this.isHouseNumberValid()) {
            string = new StringBuffer().append(string).append(" ").append(this.houseNumber.recognizedString).toString();
        }
        if (string.startsWith(" ")) {
            string = string.substring(1);
        }
        return string;
    }
}

