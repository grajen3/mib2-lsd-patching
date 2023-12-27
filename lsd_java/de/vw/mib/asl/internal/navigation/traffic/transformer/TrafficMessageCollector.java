/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic.transformer;

import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageIcon;
import org.dsi.ifc.tmc.TmcListElement;

public class TrafficMessageCollector {
    public final TmcListElement tmcListElement;
    public TrafficMessageIcon trafficMessageIcon;
    public final int index;

    public TrafficMessageCollector(TmcListElement tmcListElement, TrafficMessageIcon trafficMessageIcon, int n) {
        this.tmcListElement = tmcListElement;
        this.trafficMessageIcon = trafficMessageIcon;
        this.index = n;
    }

    public TrafficMessageCollector(TmcListElement tmcListElement, int n) {
        this.tmcListElement = tmcListElement;
        this.trafficMessageIcon = null;
        this.index = n;
    }
}

