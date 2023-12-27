/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.carplay;

import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayServiceListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.CarPlayDeviceState;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.iterator.elements.CarPlayCall;
import java.util.Iterator;

public interface CarPlayService {
    default public void addCarPlayServiceListener(CarPlayServiceListener carPlayServiceListener, int[] nArray) {
    }

    default public void removeCarPlayServiceListener(CarPlayServiceListener carPlayServiceListener, int[] nArray) {
    }

    default public boolean isCarPlayActive() {
    }

    default public CarPlayDeviceState getCarPlayDeviceState() {
    }

    default public boolean isCarPlayRouteGuidanceActive() {
    }

    default public Iterator getCarPlayCalls() {
    }

    default public void hangUpCall(CarPlayCall carPlayCall) {
    }

    default public void acceptCall(int n) {
    }
}

