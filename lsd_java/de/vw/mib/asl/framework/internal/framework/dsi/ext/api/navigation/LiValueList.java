/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.navigation;

import org.dsi.ifc.navigation.LIValueList;

public final class LiValueList {
    private final LIValueList lispValueList;
    private final long lispValueListCount;

    public LiValueList(Object[] objectArray) {
        this.lispValueList = (LIValueList)objectArray[0];
        this.lispValueListCount = (Long)objectArray[1];
    }

    public LIValueList getLispValueList() {
        return this.lispValueList;
    }

    public long getLispValueListCount() {
        return this.lispValueListCount;
    }
}

