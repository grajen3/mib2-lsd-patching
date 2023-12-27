/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model;

import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;

public class OneShotModel {
    private final int size;
    private final int index;
    private final String title;
    public ViewModelItem city;
    public ViewModelItem street;
    public HouseNumber houseNumber;
    protected static final ViewModelItem EMPTY_VIEW_MODEL_ITEM = new ViewModelItem(-1, "");
    protected static final HouseNumber EMPTY_HOUSENUMBER_ITEM = new HouseNumber(-1, "");

    public OneShotModel() {
        this(-1, new ViewModelItem(-1, ""), new ViewModelItem(-1, ""), new HouseNumber(-1, ""));
    }

    public OneShotModel(int n) {
        this(n, EMPTY_VIEW_MODEL_ITEM, EMPTY_VIEW_MODEL_ITEM, EMPTY_HOUSENUMBER_ITEM);
    }

    public OneShotModel(int n, ViewModelItem viewModelItem, ViewModelItem viewModelItem2, HouseNumber houseNumber) {
        this.index = n;
        this.size = -1;
        this.title = "no group";
        this.city = viewModelItem;
        this.street = viewModelItem2;
        this.houseNumber = houseNumber;
    }

    public OneShotModel(int n, int n2, String string) {
        this.index = n;
        this.size = n2;
        this.title = string;
        this.city = new ViewModelItem(n2, string);
        this.street = new ViewModelItem(n2, string);
        this.houseNumber = new HouseNumber(n2, string);
    }

    public boolean isCityValid() {
        return this.city != null && this.city.recognizedString != null && this.city.recognizedString.length() > 0;
    }

    public boolean isStreetValid() {
        return this.street != null && this.street.recognizedString != null && this.street.recognizedString.length() > 0;
    }

    public boolean isHouseNumberValid() {
        return this.houseNumber != null && this.houseNumber.recognizedString != null && this.houseNumber.recognizedString.length() > 0;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    public int getIndex() {
        return this.index;
    }

    public String getNbestHeadlineText(boolean bl) {
        String string = "";
        if (this.getSize() > 0) {
            if (this.isCityValid()) {
                string = this.city.recognizedString;
            }
        } else if (bl) {
            if (this.isCityValid()) {
                string = this.city.recognizedString;
            }
            if (this.isStreetValid()) {
                string = new StringBuffer().append(this.street.recognizedString).append(", ").append(string).toString();
            }
            if (this.isHouseNumberValid()) {
                string = new StringBuffer().append(this.houseNumber.recognizedString).append(" ").append(string).toString();
            }
        } else {
            if (this.isCityValid()) {
                string = this.city.recognizedString;
            }
            if (this.isStreetValid()) {
                string = new StringBuffer().append(string).append(", ").append(this.street.recognizedString).toString();
            }
            if (this.isHouseNumberValid()) {
                string = new StringBuffer().append(string).append(" ").append(this.houseNumber.recognizedString).toString();
            }
        }
        return string;
    }
}

