/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.model;

import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;

public class CountryStateModel {
    private static final ViewModelItem EMPTY_VIEW_MODEL_ITEM = new ViewModelItem(-1, "");
    private final int size;
    private final int index;
    private final String title;
    public ViewModelItem country;
    public ViewModelItem state;

    public CountryStateModel() {
        this(-1, EMPTY_VIEW_MODEL_ITEM, EMPTY_VIEW_MODEL_ITEM);
    }

    public CountryStateModel(int n) {
        this(n, EMPTY_VIEW_MODEL_ITEM, EMPTY_VIEW_MODEL_ITEM);
    }

    public CountryStateModel(int n, ViewModelItem viewModelItem, ViewModelItem viewModelItem2) {
        this.index = n;
        this.size = -1;
        this.title = "no group";
        this.country = viewModelItem;
        this.state = viewModelItem2;
    }

    public CountryStateModel(int n, int n2, String string) {
        this.index = n;
        this.size = n2;
        this.title = string;
        this.country = new ViewModelItem(n2, string);
        this.state = new ViewModelItem(n2, string);
    }

    public boolean isCountryValid() {
        return this.country != null && this.country.recognizedString != null && this.country.recognizedString.length() > 0;
    }

    public boolean isStateValid() {
        return this.state != null && this.state.recognizedString != null && this.state.recognizedString.length() > 0;
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

    public String getCountryTitle() {
        return this.isCountryValid() ? this.country.recognizedString : "";
    }

    public String getStateTitle() {
        return this.isStateValid() ? this.state.recognizedString : "";
    }

    public String getCountryStateTitle() {
        return new StringBuffer().append(this.getStateTitle()).append(" ").append(this.getCountryTitle()).toString();
    }
}

