/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.arrays;

import de.vw.mib.asl.api.car.arrays.ArraySlider;

public interface ArraySliderDelegate {
    default public void fakeValue(ArraySlider arraySlider, Object object) {
    }

    default public void updateValue(ArraySlider arraySlider, Object object) {
    }

    default public void sendNewValue(ArraySlider arraySlider, Object object) {
    }
}

