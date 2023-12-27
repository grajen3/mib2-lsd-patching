/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Sorter$Comparator;

final class ObjectStreamClass$1
implements Sorter$Comparator {
    ObjectStreamClass$1() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Class)object).getName().compareTo(((Class)object2).getName());
    }
}

