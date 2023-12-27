/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Sorter$Comparator;
import java.lang.reflect.Field;

final class ObjectStreamClass$2
implements Sorter$Comparator {
    ObjectStreamClass$2() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Field)object).getName().compareTo(((Field)object2).getName());
    }
}

