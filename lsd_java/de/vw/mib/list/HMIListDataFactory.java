/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.Coverage;
import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListDataTransaction;
import de.vw.mib.list.Range;
import de.vw.mib.list.StringIndex;

public interface HMIListDataFactory {
    default public Coverage createCoverage() {
    }

    default public Range createRange(int n, int n2) {
    }

    default public HMIListDataTransaction createDataTransaction(HMIListDataObserver hMIListDataObserver) {
    }

    default public StringIndex createStringIndex(int[] nArray, String[] stringArray) {
    }
}

