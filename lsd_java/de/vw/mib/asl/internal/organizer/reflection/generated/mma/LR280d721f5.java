/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.organizer.reflection.generated.mma;

import de.vw.mib.asl.internal.organizer.TargetASLOrganizerBaseFunctionality;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR280d721f5
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -530099032: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 357400308: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 739023975: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1720462157: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1841567162: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -2133384715: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((TargetASLOrganizerBaseFunctionality)object).dsiAdbSetupUpdateAdbState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((TargetASLOrganizerBaseFunctionality)object).dsiAdbSetupSetLanguageResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((TargetASLOrganizerBaseFunctionality)object).dsiAdbSetupResetToFactorySettingsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((TargetASLOrganizerBaseFunctionality)object).dsiAdbInitSetDefaultSOSButtonResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                return RuntimeUtil.valueOf(((TargetASLOrganizerBaseFunctionality)object).getASLNameRepresentationFromConfigManager(((Number)objectArray[0]).intValue()));
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

