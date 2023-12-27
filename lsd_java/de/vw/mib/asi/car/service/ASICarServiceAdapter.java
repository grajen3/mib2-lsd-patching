/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.service;

import de.vw.mib.asi.car.service.ASICarService;
import de.vw.mib.asi.car.service.ASICarServiceListener;

public class ASICarServiceAdapter
implements ASICarService {
    protected ASICarServiceListener listener;

    @Override
    public ASICarServiceListener getASICarServiceListener() {
        return this.listener;
    }

    @Override
    public void setASICarServiceListener(ASICarServiceListener aSICarServiceListener) {
        this.listener = aSICarServiceListener;
    }
}

