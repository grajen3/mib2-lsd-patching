/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection;

import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.Method;

final class RuntimeUtil$ClassMethodKeys {
    private final Method[] methods;
    private final int[] nameKeys;
    private final int[] paramKeys;

    static RuntimeUtil$ClassMethodKeys create(Method[] methodArray) {
        int[] nArray = new int[methodArray.length];
        int[] nArray2 = new int[methodArray.length];
        for (int i2 = 0; i2 < methodArray.length; ++i2) {
            Method method = methodArray[i2];
            nArray[i2] = RuntimeUtil.buildKey(method.getName());
            nArray2[i2] = RuntimeUtil.buildKey(method.getParameterTypes());
        }
        return new RuntimeUtil$ClassMethodKeys(methodArray, nArray, nArray2);
    }

    private RuntimeUtil$ClassMethodKeys(Method[] methodArray, int[] nArray, int[] nArray2) {
        this.methods = methodArray;
        this.nameKeys = nArray;
        this.paramKeys = nArray2;
    }

    Method findMethod(int n, int n2) {
        for (int i2 = 0; i2 < this.methods.length; ++i2) {
            if (n != this.nameKeys[i2] || n2 != this.paramKeys[i2]) continue;
            return this.methods[i2];
        }
        return null;
    }
}

