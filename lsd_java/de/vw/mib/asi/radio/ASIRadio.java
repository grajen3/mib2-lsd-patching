/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.radio;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.radio.ASIRadioListener;
import de.vw.mib.asi.radio.ASIRadioResponse;

public interface ASIRadio
extends ASIService {
    default public ASIRadioListener getASIRadioListener() {
    }

    default public void setASIRadioListener(ASIRadioListener aSIRadioListener) {
    }

    default public void selectStation(long l, ASIRadioResponse aSIRadioResponse) {
    }

    default public void selectBand(int n, ASIRadioResponse aSIRadioResponse) {
    }

    default public void seekStation(int n, ASIRadioResponse aSIRadioResponse) {
    }

    default public void enableStationDetails(boolean bl, ASIRadioResponse aSIRadioResponse) {
    }
}

