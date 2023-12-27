/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang.reflect;

import com.ibm.oti.util.Msg;
import java.lang.reflect.Method;

class ProxyMethod {
    Method method;
    Class[] commonExceptions;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;

    ProxyMethod(Method method) {
        this.method = method;
        this.commonExceptions = method.getExceptionTypes();
    }

    Class[] getCheckedExceptions() {
        Class[] classArray = (Class[])this.commonExceptions.clone();
        int n = classArray.length;
        int n2 = 0;
        int n3 = n;
        while (n2 < n3) {
            block25: {
                block24: {
                    Class clazz = classArray[n2];
                    Class clazz2 = class$0;
                    if (clazz2 == null) {
                        try {
                            clazz2 = Class.forName("java.lang.Throwable");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    if (clazz2 == clazz) {
                        return new Class[0];
                    }
                    Class clazz3 = class$1;
                    if (clazz3 == null) {
                        try {
                            clazz3 = Class.forName("java.lang.Error");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    if (clazz3.isAssignableFrom(clazz)) break block24;
                    Class clazz4 = class$2;
                    if (clazz4 == null) {
                        try {
                            clazz4 = Class.forName("java.lang.RuntimeException");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    if (!clazz4.isAssignableFrom(clazz)) break block25;
                }
                classArray[n2] = null;
                --n;
            }
            ++n2;
        }
        Class[] classArray2 = new Class[n + 2];
        n3 = 0;
        int n4 = n3++;
        Class clazz = class$1;
        if (clazz == null) {
            try {
                clazz = class$1 = Class.forName("java.lang.Error");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        classArray2[n4] = clazz;
        int n5 = n3++;
        Class clazz5 = class$2;
        if (clazz5 == null) {
            try {
                clazz5 = class$2 = Class.forName("java.lang.RuntimeException");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        classArray2[n5] = clazz5;
        int n6 = 0;
        int n7 = classArray.length;
        while (n6 < n7) {
            Class clazz6 = classArray[n6];
            if (clazz6 != null) {
                classArray2[n3++] = clazz6;
            }
            ++n6;
        }
        return classArray2;
    }

    /*
     * Unable to fully structure code
     */
    boolean matchMethod(Method var1_1) {
        if (!this.method.getName().equals(var1_1.getName())) {
            return false;
        }
        var2_2 = this.method.getParameterTypes();
        var4_4 = var2_2.length;
        if (var4_4 == (var3_3 = var1_1.getParameterTypes()).length) ** GOTO lbl9
        return false;
lbl-1000:
        // 1 sources

        {
            if (var2_2[var4_4] == var3_3[var4_4]) continue;
            return false;
lbl9:
            // 2 sources

            ** while (--var4_4 >= 0)
        }
lbl10:
        // 1 sources

        if (this.method.getReturnType() != var1_1.getReturnType()) {
            throw new IllegalArgumentException(Msg.getString("K00f2", this.method.getName()));
        }
        if (this.commonExceptions.length != 0) {
            var5_5 = var1_1.getExceptionTypes();
            if (var5_5.length == 0) {
                this.commonExceptions = var5_5;
            } else {
                var6_6 = this.commonExceptions.length;
                var7_7 = 0;
                var8_9 = var6_6;
                var9_10 = var5_5.length;
                while (var7_7 < var8_9) {
                    block12: {
                        var10_11 = this.commonExceptions[var7_7];
                        var11_13 = 0;
                        while (var11_13 < var9_10) {
                            var12_16 = var5_5[var11_13];
                            if (var10_11 == var12_16 || var12_16.isAssignableFrom(var10_11)) break block12;
                            if (var10_11.isAssignableFrom(var12_16)) {
                                this.commonExceptions[var7_7] = var10_11 = var12_16;
                                break block12;
                            }
                            ++var11_13;
                        }
                        this.commonExceptions[var7_7] = null;
                        --var6_6;
                    }
                    ++var7_7;
                }
                if (var6_6 != this.commonExceptions.length) {
                    var7_8 = new Class[var6_6];
                    var8_9 = 0;
                    var9_10 = 0;
                    var10_12 = this.commonExceptions.length;
                    while (var8_9 < var10_12) {
                        var11_15 = this.commonExceptions[var8_9];
                        if (var11_15 != null) {
                            var7_8[var9_10++] = var11_15;
                        }
                        ++var8_9;
                    }
                    this.commonExceptions = var7_8;
                }
            }
        }
        return true;
    }
}

