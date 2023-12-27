/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.list.DynamicListDataRowItemTransformer;

public interface ItemTransformer
extends DynamicListDataRowItemTransformer {
    public static final int COMPLIANCE_LEVEL_1;
    public static final int COMPLIANCE_LEVEL_2;

    default public String[] getRowValuesAsStrings(Object object) {
    }

    default public int[] getColumnIds() {
    }

    default public int getColumnCount() {
    }

    default public boolean isColumnIdSupported(int n) {
    }
}

