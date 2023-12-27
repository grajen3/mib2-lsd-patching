/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.carplay;

import de.vw.mib.bap.mqbab2.common.api.asl.datatypes.iterator.DummyIterator;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayServiceListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.CarPlayDeviceState;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.iterator.elements.CarPlayCall;
import java.util.Iterator;

public class CarPlayDummyService
implements CarPlayService,
CarPlayDeviceState {
    private static String EMPTY_STRING = "";

    @Override
    public void addCarPlayServiceListener(CarPlayServiceListener carPlayServiceListener, int[] nArray) {
    }

    @Override
    public void removeCarPlayServiceListener(CarPlayServiceListener carPlayServiceListener, int[] nArray) {
    }

    @Override
    public boolean isCarPlayActive() {
        return false;
    }

    @Override
    public String getCarPlayCellularNetworkOperator() {
        return EMPTY_STRING;
    }

    @Override
    public int getCarPlayCellularNetworkSignalStrength() {
        return 0;
    }

    @Override
    public CarPlayDeviceState getCarPlayDeviceState() {
        return this;
    }

    @Override
    public boolean isCarPlayRouteGuidanceActive() {
        return false;
    }

    @Override
    public Iterator getCarPlayCalls() {
        return new DummyIterator();
    }

    @Override
    public boolean isCarPlayDeviceValid() {
        return false;
    }

    @Override
    public void hangUpCall(CarPlayCall carPlayCall) {
    }

    @Override
    public void acceptCall(int n) {
    }
}

