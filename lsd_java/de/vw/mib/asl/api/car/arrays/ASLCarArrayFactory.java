/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.arrays;

import de.vw.mib.asl.api.car.arrays.ASLCarBAPArrayConverter;
import de.vw.mib.asl.api.car.arrays.ArraySlider;
import de.vw.mib.asl.api.car.arrays.ArraySliderDelegate;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;

public interface ASLCarArrayFactory {
    default public Timer createBapArrayTimer(TimerNotifier timerNotifier, long l) {
    }

    default public BAPChangedArray createBapChangedArray() {
    }

    default public BAPGetArray createBapGetArray() {
    }

    default public BAPSetGetArray createBapSetGetArray(Class clazz) {
    }

    default public BAPStatusArray createBapStatusArray() {
    }

    default public ASLCarBAPArrayConverter getBAPArrayConverter() {
    }

    default public ArraySlider createArraySlider(ArraySliderDelegate arraySliderDelegate, int n) {
    }
}

