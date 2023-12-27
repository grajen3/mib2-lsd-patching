/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiatrafficinfomenu;

import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.DateTime;

public interface DSIAsiaTrafficInfoMenuListener
extends DSIListener {
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
}

