/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;

public class VicsTrafficLists {
    TrafficInformation[] trafficInfos = new TrafficInformation[0];
    TunerData[] tunerDatas = new TunerData[0];
    TrafficMessage[] currentPageFmGraphicMessages = new TrafficMessage[0];
    TrafficMessage[] dsrcMessages = new TrafficMessage[0];
    TrafficMessage[] emergencyMessages = new TrafficMessage[0];

    public void updateTrafficMessages(TrafficInformation[] trafficInformationArray) {
        if (trafficInformationArray == null) {
            return;
        }
        this.trafficInfos = new TrafficInformation[trafficInformationArray.length];
        for (int i2 = 0; i2 < trafficInformationArray.length; ++i2) {
            this.trafficInfos[i2] = trafficInformationArray[i2];
        }
    }

    public void updateTunerDatas(TunerData[] tunerDataArray) {
        if (tunerDataArray == null) {
            return;
        }
        this.tunerDatas = new TunerData[tunerDataArray.length];
        for (int i2 = 0; i2 < tunerDataArray.length; ++i2) {
            this.tunerDatas[i2] = tunerDataArray[i2];
        }
    }

    public TrafficMessage[] getFmTextMessages() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.trafficInfos.length; ++i2) {
            TrafficInformation trafficInformation = this.trafficInfos[i2];
            if (trafficInformation.getTrafficType() != 4) continue;
            arrayList.addAll(Arrays.asList(trafficInformation.getTrafficMessages()));
        }
        TrafficMessage[] trafficMessageArray = new TrafficMessage[arrayList.size()];
        for (int i3 = 0; i3 < trafficMessageArray.length; ++i3) {
            trafficMessageArray[i3] = (TrafficMessage)arrayList.get(i3);
        }
        return trafficMessageArray;
    }

    public TrafficMessage[] getFmGraphicMessages() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.trafficInfos.length; ++i2) {
            TrafficInformation trafficInformation = this.trafficInfos[i2];
            if (trafficInformation.getTrafficType() != 3) continue;
            arrayList.addAll(Arrays.asList(trafficInformation.getTrafficMessages()));
        }
        TrafficMessage[] trafficMessageArray = new TrafficMessage[arrayList.size()];
        for (int i3 = 0; i3 < trafficMessageArray.length; ++i3) {
            trafficMessageArray[i3] = (TrafficMessage)arrayList.get(i3);
        }
        return trafficMessageArray;
    }

    public TrafficMessage[] getDsrcMessages() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.trafficInfos.length; ++i2) {
            TrafficInformation trafficInformation = this.trafficInfos[i2];
            if (trafficInformation.getTrafficType() != 2) continue;
            arrayList.addAll(Arrays.asList(trafficInformation.getTrafficMessages()));
        }
        TrafficMessage[] trafficMessageArray = new TrafficMessage[arrayList.size()];
        for (int i3 = 0; i3 < trafficMessageArray.length; ++i3) {
            trafficMessageArray[i3] = (TrafficMessage)arrayList.get(i3);
        }
        return trafficMessageArray;
    }

    public TrafficMessage[] getEmergencyMessages() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.trafficInfos.length; ++i2) {
            TrafficInformation trafficInformation = this.trafficInfos[i2];
            if (trafficInformation.getTrafficType() != 5) continue;
            arrayList.addAll(Arrays.asList(trafficInformation.getTrafficMessages()));
        }
        TrafficMessage[] trafficMessageArray = new TrafficMessage[arrayList.size()];
        for (int i3 = 0; i3 < trafficMessageArray.length; ++i3) {
            trafficMessageArray[i3] = (TrafficMessage)arrayList.get(i3);
        }
        return trafficMessageArray;
    }
}

