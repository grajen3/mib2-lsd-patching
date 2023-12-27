/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dynamicresourcedata.internal;

import de.vw.mib.dynamicresourcedata.internal.DynamicResourceDataImpl;

public class NullDynamicResourceData
extends DynamicResourceDataImpl {
    private static final String NULL_STRING;
    private static final int[] NULL_MAPPING;

    NullDynamicResourceData() {
    }

    @Override
    public int[] map(int[] nArray) {
        return NULL_MAPPING;
    }

    @Override
    public String mapImagePath(int n) {
        return "";
    }

    static {
        NULL_MAPPING = new int[0];
    }
}

