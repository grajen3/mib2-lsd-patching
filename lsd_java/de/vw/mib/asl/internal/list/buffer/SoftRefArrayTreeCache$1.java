/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.buffer;

import de.vw.mib.asl.internal.list.buffer.SoftRefArrayTreeCache$Key;
import java.util.Comparator;

final class SoftRefArrayTreeCache$1
implements Comparator {
    SoftRefArrayTreeCache$1() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((SoftRefArrayTreeCache$Key)object).startIndex - ((SoftRefArrayTreeCache$Key)object2).startIndex;
    }
}

