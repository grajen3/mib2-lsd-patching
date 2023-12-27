/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIHybridRadio
extends DSIBase {
    public static final String VERSION;
    public static final int IN_INDICATERADIOSTATIONLOGORESULT;
    public static final int ATTR_SLIDESHOW;
    public static final int ATTR_RADIOTEXT;
    public static final int ATTR_PROFILESTATE;
    public static final int RP_GETONLINERADIOAVAILABILITYRESULT;
    public static final int RP_GETRADIOSTATIONLOGORESULT;
    public static final int RP_GETSTREAMRESULT;
    public static final int RP_STARTSLIDESHOWRESULT;
    public static final int RP_STOPSLIDESHOWRESULT;
    public static final int RP_CANCELGETRADIOSTATIONLOGORESULT;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;
    public static final int RT_GETONLINERADIOAVAILABILITY;
    public static final int RT_GETRADIOSTATIONLOGO;
    public static final int RT_GETSTREAM;
    public static final int RT_STOPSLIDESHOW;
    public static final int RT_CANCELGETRADIOSTATIONLOGO;
    public static final int RT_STARTSLIDESHOW;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;

    default public void getOnlineRadioAvailability(int n, RadioStation[] radioStationArray) {
    }

    default public void getRadioStationLogo(int n, RadioStation[] radioStationArray, int n2) {
    }

    default public void cancelGetRadioStationLogo(int n) {
    }

    default public void getStream(int n, RadioStation radioStation) {
    }

    default public void startSlideshow(int n, RadioStation radioStation, int n2, int n3) {
    }

    default public void stopSlideshow(int n, RadioStation radioStation) {
    }

    default public void profileChange(int n) {
    }

    default public void profileCopy(int n, int n2) {
    }

    default public void profileReset(int n) {
    }

    default public void profileResetAll() {
    }
}

