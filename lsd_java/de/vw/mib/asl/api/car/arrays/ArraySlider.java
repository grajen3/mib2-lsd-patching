/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.arrays;

import de.vw.mib.asl.api.car.arrays.ArraySliderDelegate;
import de.vw.mib.bap.array.asg.ASGArrayList;

public interface ArraySlider {
    default public void requestNewValue(Object object) {
    }

    default public void receivedNewValue(Object object) {
    }

    default public void setCorrespondingArrayList(ASGArrayList aSGArrayList) {
    }

    default public ArraySliderDelegate getDelegate() {
    }

    default public int getId() {
    }

    default public void reset() {
    }
}

