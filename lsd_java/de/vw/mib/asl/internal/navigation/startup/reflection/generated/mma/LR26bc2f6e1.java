/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.reflection.generated.mma;

import de.vw.mib.asl.internal.navigation.startup.StateWork;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.navigation.BapManeuverDescriptor;

public final class LR26bc2f6e1
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1556032777: {
                if (bl) {
                    if (n2 != 2043315704) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1536037046: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -994124863: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
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
            case 1807939297: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((StateWork)object).dsiNavigationUpdateBapManeuverDescriptor((BapManeuverDescriptor[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((StateWork)object).dsiNavigationRgException(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((StateWork)object).dsiGeneralVehicleStatesUpdateVehicleStandstill((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
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

