/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.offclock.reflection.generated.mca;

import de.vw.mib.asl.internal.offclock.reflection.generated.mma.LR211;
import de.vw.mib.asl.internal.offclock.reflection.generated.mma.LR2cd7dae29;
import de.vw.mib.reflection.MultipleConstructorAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR44527b28c
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
            case 429698501: {
                if (bl) {
                    n2 = this.a0(n);
                    break;
                }
                n2 = 0;
                break;
            }
            case 948385676: {
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
                return new LR2cd7dae29();
            }
            case 1: {
                return new LR211();
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

