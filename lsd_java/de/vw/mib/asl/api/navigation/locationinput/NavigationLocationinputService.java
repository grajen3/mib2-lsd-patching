/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.locationinput;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListener;
import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;

public interface NavigationLocationinputService {
    public static final int FIELD_NONE;
    public static final int FIELD_COUNTRY;
    public static final int FIELD_STATE;
    public static final int FIELD_CITY;
    public static final int FIELD_CITY_LP;
    public static final int FIELD_STREET;
    public static final int FIELD_CROSSING;
    public static final int FIELD_HNR;
    public static final int FIELD_HNR_ALT;
    public static final int FIELD_ZIPCODE;
    public static final int FIELD_STREET_DISAMBIGUATION;
    public static final int FIELD_PREFECTURE;
    public static final int FIELD_MUNICIPALITY;
    public static final int FIELD_WARD;
    public static final int FIELD_PLACE;
    public static final int FIELD_CHOME;
    public static final int FIELD_HOUSENUMBER_BY_SDS;

    default public void lockInput(int n) {
    }

    default public void lockInput() {
    }

    default public void weakLockInput() {
    }

    default public void unlockInput() {
    }

    default public INavigationLocation getCurrentLocation() {
    }

    default public void setCurrentLocation(INavigationLocation iNavigationLocation) {
    }

    default public void startInput(int n) {
    }

    default public void setInput(String string) {
    }

    default public void getValueListBlock(int n) {
    }

    default public void selectEntry(int n) {
    }

    default public void selectEntry(String string) {
    }

    default public void resolveContact(INavigationContactAddress iNavigationContactAddress, Object object) {
    }

    default public void freeService() {
    }

    default public void requestCountryIcon(INavigationLocation iNavigationLocation) {
    }

    default public void requestStartupState(NavigationLocationinputListener navigationLocationinputListener) {
    }
}

