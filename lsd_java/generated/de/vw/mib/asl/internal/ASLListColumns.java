/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal;

import generated.de.vw.mib.asl.internal.StartUpUtil;

public final class ASLListColumns {
    private ASLListColumns() {
    }

    public static int[] getColumnsForASLList(int n) {
        return StartUpUtil.getRegistry().getASLListColumns(n);
    }
}

