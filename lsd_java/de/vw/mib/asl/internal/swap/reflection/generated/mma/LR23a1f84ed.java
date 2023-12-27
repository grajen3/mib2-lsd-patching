/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.swap.reflection.generated.mma;

import de.vw.mib.asl.internal.swap.AslTargetSWaP;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscStatus;

public final class LR23a1f84ed
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1548484813: {
                if (bl) {
                    if (n2 != 377723601) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1303578567: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 272277953: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 957768627: {
                if (bl) {
                    if (n2 != -14666978) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1774394165: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
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
            case 975144173: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                return RuntimeUtil.valueOf(AslTargetSWaP.convertFscStateFromDSIValues(((Number)objectArray[0]).intValue()));
            }
            case 1: {
                ((AslTargetSWaP)object).dsiSWaPUpdateFscList((SFscStatus[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((AslTargetSWaP)object).dsiSWaPGetFscDetail((SFscDetails)objectArray[0]);
                return null;
            }
            case 3: {
                ((AslTargetSWaP)object).dsiSWaPAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                return AslTargetSWaP.getFECCodeString(((Number)objectArray[0]).intValue());
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

