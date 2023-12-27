/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.reflection.generated.mca;

import de.vw.mib.asl.framework.internal.diagnosis.reflection.generated.mma.LR29971bd8;
import de.vw.mib.asl.framework.internal.diagnosis.reflection.generated.mma.LR2c056bb6c;
import de.vw.mib.reflection.MultipleConstructorAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR42c10d354
extends MultipleConstructorAccessibleObject {
    private int a0(int n) {
        switch (n) {
            case 17: {
                return 0;
            }
        }
        return -1;
    }

    private int a1(int n) {
        switch (n) {
            case 17: {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public int getIndex(String string, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case 1304503567: {
                if (bl) {
                    n2 = this.a0(n);
                    break;
                }
                n2 = 0;
                break;
            }
            case 1958087602: {
                if (bl) {
                    n2 = this.a1(n);
                    break;
                }
                n2 = 1;
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object[] objectArray) {
        switch (n) {
            case 0: {
                return new LR2c056bb6c();
            }
            case 1: {
                return new LR29971bd8();
            }
        }
        return null;
    }

    @Override
    public Object newInstance(int n, Object[] objectArray) {
        try {
            switch (n >> 5) {
                case 0: {
                    return this.f0(n, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

