/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa;

import de.vw.mib.asl.api.car.arrays.ArraySlider;
import de.vw.mib.asl.api.car.arrays.ArraySliderDelegate;
import de.vw.mib.asl.internal.car.fpa.StateWork;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;

public class DCCController
implements ArraySliderDelegate {
    private ArraySlider dccArraySlider = BapArrayFactory.getInstance().createArraySlider(this, 0);
    private StateWork stateWork;

    public DCCController(StateWork stateWork) {
        this.stateWork = stateWork;
    }

    @Override
    public void fakeValue(ArraySlider arraySlider, Object object) {
        this.stateWork.informDCCSliderHMI((Integer)object);
    }

    @Override
    public void updateValue(ArraySlider arraySlider, Object object) {
        this.stateWork.informDCCSliderHMI((Integer)object);
    }

    @Override
    public void sendNewValue(ArraySlider arraySlider, Object object) {
        this.stateWork.sendDCCSliderDSI((Integer)object);
    }

    public void sendDSIValue(Integer n) {
        this.dccArraySlider.requestNewValue(n);
    }

    public void receiveDSIValue(Integer n) {
        this.dccArraySlider.receivedNewValue(n);
    }

    public void resetArraySlider() {
        this.dccArraySlider.reset();
    }
}

