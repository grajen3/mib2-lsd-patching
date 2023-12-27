/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.system.DSIHMIWatchDogListener;
import org.dsi.ifc.telephone.CallStackEntry;
import org.dsi.ifc.telephone.DSICallStacksListener;
import org.dsi.ifc.telephone.MissedCallIndicator;

public final class LR211b8a484
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -812984285: {
                if (bl) {
                    if (n2 != 1714214810) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -181948062: {
                if (bl) {
                    if (n2 != 438995183) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 398172722: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1308811505: {
                if (bl) {
                    if (n2 != 1714214810) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1361999707: {
                if (bl) {
                    if (n2 != 1714214810) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1953506539: {
                if (bl) {
                    if (n2 != -1665395196) break;
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
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1532801870: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 949474429: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
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
            case -1135642823: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -633574468: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICallStacksListener)object).updateIsReverted((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSICallStacksListener)object).updateLastAnsweredNumbers((CallStackEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSICallStacksListener)object).updateLastDialedNumbers((CallStackEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSICallStacksListener)object).updateMissedNumbers((CallStackEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSICallStacksListener)object).updateMEDataValidity(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSICallStacksListener)object).updateMissedCallIndicator((MissedCallIndicator)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSICallStacksListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSIHMIWatchDogListener)object).triggerErrorLogDump();
                return null;
            }
            case 8: {
                ((DSIHMIWatchDogListener)object).updateQueryHeartbeat(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIHMIWatchDogListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

