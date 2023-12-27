/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import de.vw.mib.asl.api.navigation.IPnavLikelyDestination;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.ResourceLocator;

public class ASLPnavLikelyDestination
implements IPnavLikelyDestination {
    int calculationState = 0;
    int calculationProgress = 0;
    int likelyHood = 0;
    long dtd = 0L;
    long rtt = 0L;
    long timeDelay = 0L;
    int routeColor = 0;
    ResourceLocator colorIcon = null;
    String street = "";
    String housenumber = "";
    String streetRefinement = "";
    String city = "";
    String cityRefinement = "";
    String crossStreet = "";
    int latitude = 0;
    int longitude = 0;
    FixFormatterFieldData likelyDestAddressData = null;

    @Override
    public int getCalculationState() {
        return this.calculationState;
    }

    @Override
    public void setCalculationState(int n) {
        this.calculationState = n;
    }

    @Override
    public int getCalculationProgress() {
        return this.calculationProgress;
    }

    @Override
    public void setCalculationProgress(int n) {
        this.calculationProgress = n;
    }

    @Override
    public int getLikelyHood() {
        return this.likelyHood;
    }

    @Override
    public void setLikelyHood(int n) {
        this.likelyHood = n;
    }

    @Override
    public long getDtd() {
        return this.dtd;
    }

    @Override
    public void setDtd(long l) {
        this.dtd = l;
    }

    @Override
    public long getRtt() {
        return this.rtt;
    }

    @Override
    public void setRtt(long l) {
        this.rtt = l;
    }

    @Override
    public long getTimeDelay() {
        return this.timeDelay;
    }

    @Override
    public void setTimeDelay(long l) {
        this.timeDelay = l;
    }

    @Override
    public int getRouteColor() {
        return this.routeColor;
    }

    @Override
    public void setRouteColor(int n) {
        this.routeColor = n;
    }

    @Override
    public ResourceLocator getColorIcon() {
        return this.colorIcon;
    }

    @Override
    public void setColorIcon(ResourceLocator resourceLocator) {
        this.colorIcon = resourceLocator;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public void setStreet(String string) {
        this.street = string;
    }

    @Override
    public String getHousenumber() {
        return this.housenumber;
    }

    @Override
    public void setHousenumber(String string) {
        this.housenumber = string;
    }

    @Override
    public String getStreetRefinement() {
        return this.streetRefinement;
    }

    @Override
    public void setStreetRefinement(String string) {
        this.streetRefinement = string;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public void setCity(String string) {
        this.city = string;
    }

    @Override
    public String getCityRefinement() {
        return this.cityRefinement;
    }

    @Override
    public void setCityRefinement(String string) {
        this.cityRefinement = string;
    }

    @Override
    public String getCrossStreet() {
        return this.crossStreet;
    }

    @Override
    public void setCrossStreet(String string) {
        this.crossStreet = string;
    }

    @Override
    public int getLatitude() {
        return this.latitude;
    }

    @Override
    public void setLatitude(int n) {
        this.latitude = n;
    }

    @Override
    public int getLongitude() {
        return this.longitude;
    }

    @Override
    public void setLongitude(int n) {
        this.longitude = n;
    }

    @Override
    public FixFormatterFieldData getLikelyDestAddressData() {
        return this.likelyDestAddressData;
    }

    @Override
    public void setLikelyDestAddressData(FixFormatterFieldData fixFormatterFieldData) {
        this.likelyDestAddressData = fixFormatterFieldData;
    }
}

