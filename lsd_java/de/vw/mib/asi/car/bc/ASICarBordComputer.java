/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.bc;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.car.bc.ASICarBordComputerListener;

public interface ASICarBordComputer
extends ASIService {
    default public ASICarBordComputerListener getASICarBordComputerListener() {
    }

    default public void setASICarBordComputerListener(ASICarBordComputerListener aSICarBordComputerListener) {
    }
}

