/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import generated.de.vw.mib.asl.internal.StartUpUtil;

public final class ListManager {
    private ListManager() {
    }

    public static GenericASLList getGenericASLList(int n) {
        return (GenericASLList)StartUpUtil.getRegistry().getASLList(n);
    }

    public static ASLList getASLList(int n) {
        return StartUpUtil.getRegistry().getASLList(n);
    }
}

