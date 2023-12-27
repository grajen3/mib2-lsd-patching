/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiatrafficinfomenu;

import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.global.DateTime;

public interface DSIAsiaTrafficInfoMenuReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateActiveInterrupts(Interrupt[] interruptArray, int n) {
    }

    default public void updateTrafficType(TrafficInformation[] trafficInformationArray, int n) {
    }

    default public void updatePrefecture(String string, int n) {
    }

    default public void updateProbeDataSetting(boolean bl, int n) {
    }

    default public void updateFrequency(int n, int n2) {
    }

    default public void updateReceptionStatus(int n, int n2) {
    }

    default public void updateReceptionDate(DateTime dateTime, int n) {
    }

    default public void requestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
    }

    default public void requestTrafficInformationDetailsResponse(int n, TrafficInformationDetails[] trafficInformationDetailsArray) {
    }

    default public void updateReceivableStations(TunerData[] tunerDataArray, int n) {
    }

    default public void setLanguageResponse(boolean bl) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

