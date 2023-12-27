/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car;

import de.vw.mib.asi.car.ASICarGeneric;
import de.vw.mib.asi.car.ASICarGenericListener;

public class ASICarGenericAdapter
implements ASICarGeneric {
    protected ASICarGenericListener listener;

    @Override
    public ASICarGenericListener getASICarGenericListener() {
        return this.listener;
    }

    @Override
    public void setASICarGenericListener(ASICarGenericListener aSICarGenericListener) {
        this.listener = aSICarGenericListener;
    }
}

