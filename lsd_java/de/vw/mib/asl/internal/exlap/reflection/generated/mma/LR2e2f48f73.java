/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exlap.reflection.generated.mma;

import de.vw.mib.asl.api.exlap.callback.ExlapExternalAppsUpdate;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.exlap.ExlapTarget;
import de.vw.mib.has.HASInvocation;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.exlap.Service;

public final class LR2e2f48f73
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2133313908: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1652351418: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1014942899: {
                if (bl) {
                    if (n2 != -2086398341) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -968698819: {
                if (bl) {
                    if (n2 != -1868270135) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -860212059: {
                if (bl) {
                    if (n2 != -150851648) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -277050464: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -235283043: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -48205386: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != -1200638929) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1941889602: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -487288973: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((ExlapTarget)object).reset((FactoryResetCallback)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((ExlapTarget)object).registerDSI();
                return null;
            }
            case 2: {
                ((ExlapTarget)object).dsiExlapAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((ExlapTarget)object).dsiExlapStopResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((ExlapTarget)object).dsiExlapStartResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((ExlapTarget)object).dsiExlapUpdateAvailableServices((Service[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((ExlapTarget)object).handleInvocation((HASInvocation)objectArray[0]);
                return null;
            }
            case 7: {
                return RuntimeUtil.valueOf(((ExlapTarget)object).isChauffeurModeActive());
            }
            case 8: {
                return RuntimeUtil.valueOf(((ExlapTarget)object).getTimeout());
            }
            case 9: {
                ((ExlapTarget)object).registerExlapExternalAppsUpdates((ExlapExternalAppsUpdate)objectArray[0]);
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

