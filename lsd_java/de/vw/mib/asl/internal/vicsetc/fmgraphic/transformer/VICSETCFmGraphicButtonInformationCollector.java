/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer;

import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VICSETCFmGraphicButtonInformationCollector {
    private final TrafficMessage trafficMessage;
    private final int index;

    public VICSETCFmGraphicButtonInformationCollector(TrafficMessage trafficMessage, int n) {
        this.trafficMessage = trafficMessage;
        this.index = n;
    }

    public TrafficMessage getTrafficMessage() {
        return this.trafficMessage;
    }

    public int getIndex() {
        return this.index;
    }
}

