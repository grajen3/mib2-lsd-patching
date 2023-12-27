/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.ResourceLocator;

public interface IPnavLikelyDestination {
    default public int getCalculationState() {
    }

    default public void setCalculationState(int n) {
    }

    default public int getCalculationProgress() {
    }

    default public void setCalculationProgress(int n) {
    }

    default public int getLikelyHood() {
    }

    default public void setLikelyHood(int n) {
    }

    default public long getDtd() {
    }

    default public void setDtd(long l) {
    }

    default public long getRtt() {
    }

    default public void setRtt(long l) {
    }

    default public long getTimeDelay() {
    }

    default public void setTimeDelay(long l) {
    }

    default public int getRouteColor() {
    }

    default public void setRouteColor(int n) {
    }

    default public ResourceLocator getColorIcon() {
    }

    default public void setColorIcon(ResourceLocator resourceLocator) {
    }

    default public String getStreet() {
    }

    default public void setStreet(String string) {
    }

    default public String getHousenumber() {
    }

    default public void setHousenumber(String string) {
    }

    default public String getStreetRefinement() {
    }

    default public void setStreetRefinement(String string) {
    }

    default public String getCity() {
    }

    default public void setCity(String string) {
    }

    default public String getCityRefinement() {
    }

    default public void setCityRefinement(String string) {
    }

    default public String getCrossStreet() {
    }

    default public void setCrossStreet(String string) {
    }

    default public int getLatitude() {
    }

    default public void setLatitude(int n) {
    }

    default public int getLongitude() {
    }

    default public void setLongitude(int n) {
    }

    default public FixFormatterFieldData getLikelyDestAddressData() {
    }

    default public void setLikelyDestAddressData(FixFormatterFieldData fixFormatterFieldData) {
    }
}

