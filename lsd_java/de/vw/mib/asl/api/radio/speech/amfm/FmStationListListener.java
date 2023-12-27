/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.speech.amfm;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;

public interface FmStationListListener {
    default public void updateStationList(AmFmStation[] amFmStationArray) {
    }
}

