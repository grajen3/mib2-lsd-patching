/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class StationLogoData {
    private RadioStationDataRequest radioStationData = null;
    private ResourceLocator resourceLocator = null;
    private RadioStationLogoResponse stationLogoResponse = null;
    private boolean responseContainedMoreThanOneLogo = false;

    public RadioStationDataRequest getRadioStationData() {
        return this.radioStationData;
    }

    public void setRadioStationData(RadioStationDataRequest radioStationDataRequest) {
        this.radioStationData = radioStationDataRequest;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    public void setResourceLocator(ResourceLocator resourceLocator) {
        this.resourceLocator = resourceLocator;
    }

    public RadioStationLogoResponse getStationLogoResponse() {
        return this.stationLogoResponse;
    }

    public void setStationLogoResponse(RadioStationLogoResponse radioStationLogoResponse) {
        this.stationLogoResponse = radioStationLogoResponse;
    }

    public boolean isResponseContainedMoreThanOneLogo() {
        return this.responseContainedMoreThanOneLogo;
    }

    public void setResponseContainedMoreThanOneLogo(boolean bl) {
        this.responseContainedMoreThanOneLogo = bl;
    }
}

