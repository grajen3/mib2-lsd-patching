/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.Coverage;
import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListDataTransaction;
import de.vw.mib.list.Range;
import de.vw.mib.list.StringIndex;
import de.vw.mib.list.impl.CoverageImpl;
import de.vw.mib.list.impl.CoverageImpl$RangeImpl;
import de.vw.mib.list.impl.HMIListDataTransactionImpl;
import de.vw.mib.list.impl.StringIndexImpl;

class HMIListDataFactoryImpl
implements HMIListDataFactory {
    HMIListDataFactoryImpl() {
    }

    @Override
    public Coverage createCoverage() {
        return CoverageImpl.create(true);
    }

    @Override
    public Range createRange(int n, int n2) {
        return CoverageImpl$RangeImpl.create(n, n2, null);
    }

    @Override
    public HMIListDataTransaction createDataTransaction(HMIListDataObserver hMIListDataObserver) {
        return HMIListDataTransactionImpl.create(hMIListDataObserver);
    }

    @Override
    public StringIndex createStringIndex(int[] nArray, String[] stringArray) {
        return StringIndexImpl.borrow(nArray, stringArray);
    }
}

