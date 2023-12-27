/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.drivingdatatiles;

import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.HMIListDataObserver;
import de.vw.mib.list.HMIListDataProvider;
import de.vw.mib.list.HMIListDataTransaction;
import de.vw.mib.list.StringIndex;
import java.util.Arrays;

public class IntermediateDataProvider
implements HMIListDataProvider {
    private Object[] content;
    private HMIListDataObserver observer;
    private final HMIListDataFactory dataFactory;

    public IntermediateDataProvider(HMIListDataFactory hMIListDataFactory) {
        this.dataFactory = hMIListDataFactory;
    }

    @Override
    public int getFocusIndex() {
        return -1;
    }

    @Override
    public int getListSize() {
        return this.content.length;
    }

    @Override
    public int getListState() {
        return 2;
    }

    @Override
    public StringIndex getStringIndex() {
        return null;
    }

    @Override
    public void fillItems(int n, Object[] objectArray) {
        int n2 = Math.min(this.content.length - n, objectArray.length);
        if (0 < n2) {
            System.arraycopy((Object)this.content, n, (Object)objectArray, 0, n2);
        }
        if (n2 < objectArray.length) {
            Arrays.fill(objectArray, Math.max(0, n2), objectArray.length, null);
        }
    }

    @Override
    public void setObserver(HMIListDataObserver hMIListDataObserver) {
        this.observer = hMIListDataObserver;
    }

    public void setContent(Object[] objectArray) {
        this.content = objectArray;
        HMIListDataTransaction hMIListDataTransaction = this.dataFactory.createDataTransaction(this.observer);
        hMIListDataTransaction.setContent(this.content);
        hMIListDataTransaction.commit();
    }
}

