/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.reflection.generated.mca;

import de.vw.mib.asl.internal.navigation.poi.reflection.generated.mma.LR2179ad4d1;
import de.vw.mib.asl.internal.navigation.poi.reflection.generated.mma.LR2fbe983dd;
import de.vw.mib.reflection.MultipleConstructorAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR4ab5c290f
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
            case -413049338: {
                if (bl) {
                    n2 = this.a1(n);
                    break;
                }
                n2 = 1;
                break;
            }
            case 977900710: {
                if (bl) {
                    n2 = this.a0(n);
                    break;
                }
                n2 = 0;
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object[] objectArray) {
        switch (n) {
            case 0: {
                return new LR2179ad4d1();
            }
            case 1: {
                return new LR2fbe983dd();
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

