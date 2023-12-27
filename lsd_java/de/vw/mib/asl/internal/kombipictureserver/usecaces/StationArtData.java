/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.usecaces;

import de.vw.mib.asl.internal.kombipictureserver.common.util.KombiPictureServerUtil;
import org.dsi.ifc.global.ResourceLocator;

public class StationArtData {
    static final int BAP_AUDIO_SD_STATION_NO_PRESET;
    static final int BAP_AUDIO_SD_STATION_INVALID_HANDLE;
    private final int bapPresetID;
    private final int radioPresetID;
    private ResourceLocator resourceLocator;
    private int sourceType;

    public StationArtData() {
        this(-1, -1, 0, null);
    }

    public StationArtData(int n, int n2, int n3, ResourceLocator resourceLocator) {
        this.bapPresetID = n;
        this.radioPresetID = n2;
        this.sourceType = n3;
        this.resourceLocator = resourceLocator;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        StationArtData stationArtData = (StationArtData)object;
        if (this.bapPresetID != stationArtData.bapPresetID) {
            return false;
        }
        if (this.radioPresetID != stationArtData.radioPresetID) {
            return false;
        }
        if (this.resourceLocator == null ? stationArtData.resourceLocator != null : !KombiPictureServerUtil.compareResourceLocator(this.resourceLocator, stationArtData.resourceLocator)) {
            return false;
        }
        return this.sourceType == stationArtData.sourceType;
    }

    public int getBapPresetID() {
        return this.bapPresetID;
    }

    public int getRadioPresetID() {
        return this.radioPresetID;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.bapPresetID;
        n2 = 31 * n2 + this.radioPresetID;
        n2 = 31 * n2 + (this.resourceLocator == null ? 0 : this.resourceLocator.hashCode());
        n2 = 31 * n2 + this.sourceType;
        return n2;
    }

    public void setResourceLocator(ResourceLocator resourceLocator) {
        this.resourceLocator = resourceLocator;
    }

    public void setSourceType(int n) {
        this.sourceType = n;
    }

    public String toString() {
        return new StringBuffer().append("StationArtData [bapPresetID=").append(this.bapPresetID).append(", radioPresetID=").append(this.radioPresetID).append(", resourceLocator=").append(this.resourceLocator).append(", sourceType=").append(this.sourceType).append("]").toString();
    }
}

