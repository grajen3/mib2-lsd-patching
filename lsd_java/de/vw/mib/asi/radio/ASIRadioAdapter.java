/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.radio;

import de.vw.mib.asi.radio.ASIRadio;
import de.vw.mib.asi.radio.ASIRadioListener;
import de.vw.mib.asi.radio.ASIRadioResponse;

public class ASIRadioAdapter
implements ASIRadio {
    protected ASIRadioListener listener;

    @Override
    public ASIRadioListener getASIRadioListener() {
        return this.listener;
    }

    @Override
    public void setASIRadioListener(ASIRadioListener aSIRadioListener) {
        this.listener = aSIRadioListener;
    }

    @Override
    public void selectStation(long l, ASIRadioResponse aSIRadioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void selectBand(int n, ASIRadioResponse aSIRadioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void seekStation(int n, ASIRadioResponse aSIRadioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void enableStationDetails(boolean bl, ASIRadioResponse aSIRadioResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}

