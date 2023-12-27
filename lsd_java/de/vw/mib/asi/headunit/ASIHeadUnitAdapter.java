/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.headunit;

import de.vw.mib.asi.headunit.ASIHeadUnit;
import de.vw.mib.asi.headunit.ASIHeadUnitListener;

public class ASIHeadUnitAdapter
implements ASIHeadUnit {
    protected ASIHeadUnitListener listener;

    @Override
    public ASIHeadUnitListener getASIHeadUnitListener() {
        return this.listener;
    }

    @Override
    public void setASIHeadUnitListener(ASIHeadUnitListener aSIHeadUnitListener) {
        this.listener = aSIHeadUnitListener;
    }
}

