/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.gridmenu.reflection.generated.mma;

import de.vw.mib.asl.internal.gridmenu.api.impl.GridMenuStartupTarget;
import de.vw.mib.asl.internal.impl.gridmenu.GridMenuDebugTarget;
import de.vw.mib.asl.internal.impl.gridmenu.GridMenuValetParking;
import de.vw.mib.asl.internal.impl.gridmenu.MainMenuTarget;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR28249d8b9
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 113920: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
        }
        return n3;
    }

    @Override
    public int getIndex(String string, String string2, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        int n4 = RuntimeUtil.buildKey(string2);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case -2066558812: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -54902930: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 98665842: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case 1564748664: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                return ((GridMenuStartupTarget)object).getLogger();
            }
            case 1: {
                return ((GridMenuDebugTarget)object).getLogger();
            }
            case 2: {
                ((GridMenuValetParking)object).run();
                return null;
            }
            case 3: {
                return ((GridMenuValetParking)object).getLogger();
            }
            case 4: {
                return ((MainMenuTarget)object).getLogger();
            }
        }
        return null;
    }

    @Override
    public Object invoke(int n, Object object, Object[] objectArray) {
        try {
            switch (n >> 5) {
                case 0: {
                    return this.f0(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

