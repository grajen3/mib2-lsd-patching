/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.RadioData;
import org.dsi.ifc.radio.TIMMessage;

public class RadioTIMListCollector {
    private TIMMessage mMessage;
    private boolean mActivated;

    public RadioTIMListCollector(TIMMessage tIMMessage, boolean bl) {
        if (tIMMessage != null) {
            this.mMessage = tIMMessage;
            this.mActivated = bl;
        } else {
            this.mMessage = new TIMMessage();
            this.mActivated = false;
        }
    }

    public TIMMessage getMessage() {
        return this.mMessage;
    }

    public void setMessage(TIMMessage tIMMessage) {
        this.mMessage = tIMMessage;
    }

    public boolean isActivated() {
        return this.mActivated;
    }

    public void setActivated(boolean bl) {
        this.mActivated = bl;
    }

    public void setFixName() {
        String string = RadioData.getAmfmDatabase().getFixedStationList().getName(this.mMessage.pi, (int)this.mMessage.frequency);
        if (string != null && string.length() > 0) {
            this.mMessage.name = string;
        }
    }
}

