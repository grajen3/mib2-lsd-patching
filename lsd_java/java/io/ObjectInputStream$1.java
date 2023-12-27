/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Method;
import java.security.PrivilegedAction;

final class ObjectInputStream$1
implements PrivilegedAction {
    final /* synthetic */ ObjectInputStream this$0;
    private final /* synthetic */ Class val$implementationClass;
    private final /* synthetic */ Class val$thisClass;

    ObjectInputStream$1(ObjectInputStream objectInputStream, Class clazz, Class clazz2) {
        this.this$0 = objectInputStream;
        this.val$implementationClass = clazz;
        this.val$thisClass = clazz2;
    }

    @Override
    public Object run() {
        Method method;
        try {
            method = this.val$implementationClass.getMethod("readFields", ObjectStreamClass.EMPTY_CONSTRUCTOR_PARAM_TYPES);
            if (method.getDeclaringClass() != this.val$thisClass) {
                return Boolean.TRUE;
            }
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        try {
            method = this.val$implementationClass.getMethod("readUnshared", ObjectStreamClass.EMPTY_CONSTRUCTOR_PARAM_TYPES);
            if (method.getDeclaringClass() != this.val$thisClass) {
                return Boolean.TRUE;
            }
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        return Boolean.FALSE;
    }
}

