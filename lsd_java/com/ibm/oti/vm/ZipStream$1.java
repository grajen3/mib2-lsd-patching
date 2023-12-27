/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.vm.ZipStream;
import java.security.PrivilegedAction;

final class ZipStream$1
implements PrivilegedAction {
    ZipStream$1() {
    }

    @Override
    public Object run() {
        Class clazz = ZipStream.class$0;
        if (clazz == null) {
            try {
                clazz = ZipStream.class$0 = Class.forName("java.util.zip.ZipFile");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        Class clazz2 = clazz;
        try {
            ZipStream.access$0(clazz2.getDeclaredField("descriptor"));
            ZipStream.access$1().setAccessible(true);
            ZipStream.access$2(clazz2.getDeclaredField("lock"));
            ZipStream.access$3().setAccessible(true);
            return null;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new Error();
        }
    }
}

