/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.pnav;

import de.vw.mib.asl.api.navigation.IPnavLikelyDestination;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.ResourceLocator;

public class DefaultPnavLikelyDestination
implements IPnavLikelyDestination {
    @Override
    public int getCalculationState() {
        return 0;
    }

    @Override
    public void setCalculationState(int n) {
    }

    @Override
    public int getCalculationProgress() {
        return 0;
    }

    @Override
    public void setCalculationProgress(int n) {
    }

    @Override
    public int getLikelyHood() {
        return 0;
    }

    @Override
    public void setLikelyHood(int n) {
    }

    @Override
    public long getDtd() {
        return 0L;
    }

    @Override
    public void setDtd(long l) {
    }

    @Override
    public long getRtt() {
        return 0L;
    }

    @Override
    public void setRtt(long l) {
    }

    @Override
    public long getTimeDelay() {
        return 0L;
    }

    @Override
    public void setTimeDelay(long l) {
    }

    @Override
    public int getRouteColor() {
        return 0;
    }

    @Override
    public void setRouteColor(int n) {
    }

    @Override
    public ResourceLocator getColorIcon() {
        return null;
    }

    @Override
    public void setColorIcon(ResourceLocator resourceLocator) {
    }

    @Override
    public String getStreet() {
        return "";
    }

    @Override
    public void setStreet(String string) {
    }

    @Override
    public String getHousenumber() {
        return "";
    }

    @Override
    public void setHousenumber(String string) {
    }

    @Override
    public String getStreetRefinement() {
        return "";
    }

    @Override
    public void setStreetRefinement(String string) {
    }

    @Override
    public String getCity() {
        return "";
    }

    @Override
    public void setCity(String string) {
    }

    @Override
    public String getCityRefinement() {
        return "";
    }

    @Override
    public void setCityRefinement(String string) {
    }

    @Override
    public String getCrossStreet() {
        return "";
    }

    @Override
    public void setCrossStreet(String string) {
    }

    @Override
    public int getLatitude() {
        return 0;
    }

    @Override
    public void setLatitude(int n) {
    }

    @Override
    public int getLongitude() {
        return 0;
    }

    @Override
    public void setLongitude(int n) {
    }

    @Override
    public FixFormatterFieldData getLikelyDestAddressData() {
        return null;
    }

    @Override
    public void setLikelyDestAddressData(FixFormatterFieldData fixFormatterFieldData) {
    }
}

