/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.car.ASICarGenericListener;

public interface ASICarGeneric
extends ASIService {
    default public ASICarGenericListener getASICarGenericListener() {
    }

    default public void setASICarGenericListener(ASICarGenericListener aSICarGenericListener) {
    }
}

