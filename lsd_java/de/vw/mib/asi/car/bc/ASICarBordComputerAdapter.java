/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.bc;

import de.vw.mib.asi.car.bc.ASICarBordComputer;
import de.vw.mib.asi.car.bc.ASICarBordComputerListener;

public class ASICarBordComputerAdapter
implements ASICarBordComputer {
    protected ASICarBordComputerListener listener;

    @Override
    public ASICarBordComputerListener getASICarBordComputerListener() {
        return this.listener;
    }

    @Override
    public void setASICarBordComputerListener(ASICarBordComputerListener aSICarBordComputerListener) {
        this.listener = aSICarBordComputerListener;
    }
}

