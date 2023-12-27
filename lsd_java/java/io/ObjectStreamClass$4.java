/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Sorter$Comparator;
import java.io.ObjectStreamClass;
import java.lang.reflect.Method;

final class ObjectStreamClass$4
implements Sorter$Comparator {
    ObjectStreamClass$4() {
    }

    @Override
    public int compare(Object object, Object object2) {
        int n = ((Method)object).getName().compareTo(((Method)object2).getName());
        if (n == 0) {
            return ObjectStreamClass.getMethodSignature((Method)object).compareTo(ObjectStreamClass.getMethodSignature((Method)object2));
        }
        return n;
    }
}

