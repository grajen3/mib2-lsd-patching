/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.service;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.car.service.ASICarServiceListener;

public interface ASICarService
extends ASIService {
    default public ASICarServiceListener getASICarServiceListener() {
    }

    default public void setASICarServiceListener(ASICarServiceListener aSICarServiceListener) {
    }
}

