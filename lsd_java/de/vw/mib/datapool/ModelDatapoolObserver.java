/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool;

import de.vw.mib.datapool.ModelDatapoolObserver$1;

public interface ModelDatapoolObserver {
    public static final ModelDatapoolObserver EMPTY_OBSERVER = new ModelDatapoolObserver$1();

    default public void datapoolValueChanged(int n) {
    }
}

