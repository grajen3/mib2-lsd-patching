/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices;

import org.dsi.ifc.global.NavLocation;

public interface DSITPEGServicesC {
    default public void requestSimpleMapList(int n, int n2) {
    }

    default public void addSimpleMapBookmark(int n) {
    }

    default public void deleteSimpleMapBookmark(int n) {
    }

    default public void deleteAllSimpleMapBookmarks() {
    }

    default public void requestLocationDetails(int n) {
    }

    default public void requestFuelPriceInformation(int n, int n2) {
    }

    default public void requestSortedFuelPriceInformation(int n, int n2, int n3) {
    }

    default public void requestNewsInformation(int n) {
    }

    default public void requestResourceInformation(int n) {
    }

    default public void setLanguage(String string) {
    }

    default public void requestWeatherInfo(NavLocation navLocation, int n, int n2) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

