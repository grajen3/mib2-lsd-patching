/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Sorter$Comparator;
import java.io.ObjectStreamField;

final class ObjectStreamField$1
implements Sorter$Comparator {
    ObjectStreamField$1() {
    }

    @Override
    public int compare(Object object, Object object2) {
        ObjectStreamField objectStreamField = (ObjectStreamField)object;
        ObjectStreamField objectStreamField2 = (ObjectStreamField)object2;
        return objectStreamField.compareTo(objectStreamField2);
    }
}

