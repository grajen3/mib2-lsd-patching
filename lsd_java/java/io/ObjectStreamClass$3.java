/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Sorter$Comparator;
import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;

final class ObjectStreamClass$3
implements Sorter$Comparator {
    ObjectStreamClass$3() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return ObjectStreamClass.getConstructorSignature((Constructor)object).compareTo(ObjectStreamClass.getConstructorSignature((Constructor)object2));
    }
}

