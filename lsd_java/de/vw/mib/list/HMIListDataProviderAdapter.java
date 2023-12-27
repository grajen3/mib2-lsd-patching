/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.HMIListDataProvider;
import de.vw.mib.list.StringIndex;

public abstract class HMIListDataProviderAdapter
implements HMIListDataProvider {
    @Override
    public int getFocusIndex() {
        return -1;
    }

    @Override
    public int getListState() {
        return 2;
    }

    @Override
    public StringIndex getStringIndex() {
        return null;
    }
}

