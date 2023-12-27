/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic.reflection.generated.mma;

import de.vw.mib.asl.internal.navigation.traffic.TrafficTargetHSM;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.dsi.ifc.tmc.TmcMessage;

public final class LR23239067f
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1979587614: {
                if (bl) {
                    if (n2 != -1666704538) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
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
            case 842598015: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((TrafficTargetHSM)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 1: {
                return RuntimeUtil.valueOf(TrafficTargetHSM.isMessageOnRoute((TmcMessage)objectArray[0]));
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

