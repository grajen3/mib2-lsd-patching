/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.mastercontrol;

import de.vw.mib.asi.mastercontrol.ASIMasterControl;
import de.vw.mib.asi.mastercontrol.ASIMasterControlListener;

public class ASIMasterControlAdapter
implements ASIMasterControl {
    protected ASIMasterControlListener listener;

    @Override
    public ASIMasterControlListener getASIMasterControlListener() {
        return this.listener;
    }

    @Override
    public void setASIMasterControlListener(ASIMasterControlListener aSIMasterControlListener) {
        this.listener = aSIMasterControlListener;
    }
}

