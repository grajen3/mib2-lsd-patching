/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.collections.ints.IntPairArrayList;
import de.vw.mib.genericevents.EventGeneric;

public interface ServiceRegister {
    default public void addObserver(int n, int n2) {
    }

    default public void addObserver(int n, int n2, int n3) {
    }

    default public void addObserver(int n, int n2, int n3, int n4) {
    }

    default public void addObserver(int[] nArray, int n) {
    }

    default public void addObserver(IntPairArrayList intPairArrayList) {
    }

    default public void removeObserver(int n, int n2) {
    }

    default public void removeObserver(int n, int n2, int n3, int n4) {
    }

    default public void removeObservers(int[] nArray, int n) {
    }

    default public void addServiceMonitor(int n, int n2, int n3) {
    }

    default public void removeServiceMonitor(int n, int n2, int n3) {
    }

    default public boolean existService(int n) {
    }

    default public void registerService(int n, int n2) {
    }

    default public void registerService(int n, int n2, int n3, boolean bl) {
    }

    default public void registerService(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
    }

    default public void registerServicesWithoutCheck(int[] nArray, int n, boolean bl) {
    }

    default public void registerServicesWithoutCheck(int[][] nArray, boolean bl, boolean bl2) {
    }

    default public void registerServicesWithoutCheck(IntPairArrayList intPairArrayList, boolean bl, boolean bl2) {
    }

    default public void unregisterService(int n) {
    }

    default public void unregisterServices(int[] nArray) {
    }

    default public boolean triggerObserver(int n) {
    }

    default public boolean triggerObserver(int n, EventGeneric eventGeneric) {
    }

    default public boolean triggerLastEvent(int n) {
    }
}

