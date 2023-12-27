/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.radio;

import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.vw.mib.asi.ASIResponse;

public interface ASIRadioResponse
extends ASIResponse {
    default public void stationDetailsUpdated(CurrentStation[] currentStationArray) {
    }
}

