/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.callcenterservice.reflection.generated.mma;

import de.vw.mib.asl.internal.online.states.OnlineCallCenterServiceTarget;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.online.OperatorCallResult;

public final class LR2f55913ef
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -595700028: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 35196810: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1076168763: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1614176747: {
                if (bl) {
                    if (n2 != -645867850) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1636642193: {
                if (bl) {
                    if (n2 != -794511114) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1916002242: {
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
            case -178711569: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((OnlineCallCenterServiceTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((OnlineCallCenterServiceTarget)object).updateServiceStatusOnChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                return ((OnlineCallCenterServiceTarget)object).getDSIOperatorCall();
            }
            case 3: {
                ((OnlineCallCenterServiceTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                return ((OnlineCallCenterServiceTarget)object).getOnlineCallCenterServiceController();
            }
            case 5: {
                ((OnlineCallCenterServiceTarget)object).dsiOperatorCallResponseOperatorCallResult(((Number)objectArray[0]).intValue(), (OperatorCallResult[])objectArray[1]);
                return null;
            }
            case 6: {
                ((OnlineCallCenterServiceTarget)object).dsiOperatorCallResponseOperatorPhoneNumber(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 7: {
                ((OnlineCallCenterServiceTarget)object).dsiOperatorCallAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

