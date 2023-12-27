/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.internal;

import de.vw.mib.collections.ints.IntPairArrayList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

public class EmptyServiceRegister
implements ServiceRegister {
    @Override
    public void addObserver(int n, int n2) {
    }

    @Override
    public void addObserver(int n, int n2, int n3) {
    }

    @Override
    public void addObserver(int n, int n2, int n3, int n4) {
    }

    @Override
    public void addObserver(int[] nArray, int n) {
    }

    @Override
    public void addObserver(IntPairArrayList intPairArrayList) {
    }

    @Override
    public void removeObserver(int n, int n2) {
    }

    @Override
    public void removeObserver(int n, int n2, int n3, int n4) {
    }

    @Override
    public void removeObservers(int[] nArray, int n) {
    }

    @Override
    public void addServiceMonitor(int n, int n2, int n3) {
    }

    @Override
    public void removeServiceMonitor(int n, int n2, int n3) {
    }

    @Override
    public boolean existService(int n) {
        return false;
    }

    @Override
    public void registerService(int n, int n2) {
    }

    @Override
    public void registerService(int n, int n2, int n3, boolean bl) {
    }

    @Override
    public void registerService(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
    }

    @Override
    public void registerServicesWithoutCheck(int[] nArray, int n, boolean bl) {
    }

    @Override
    public void registerServicesWithoutCheck(int[][] nArray, boolean bl, boolean bl2) {
    }

    @Override
    public void registerServicesWithoutCheck(IntPairArrayList intPairArrayList, boolean bl, boolean bl2) {
    }

    @Override
    public void unregisterService(int n) {
    }

    @Override
    public void unregisterServices(int[] nArray) {
    }

    @Override
    public boolean triggerObserver(int n) {
        return false;
    }

    @Override
    public boolean triggerObserver(int n, EventGeneric eventGeneric) {
        return false;
    }

    @Override
    public boolean triggerLastEvent(int n) {
        return false;
    }
}

