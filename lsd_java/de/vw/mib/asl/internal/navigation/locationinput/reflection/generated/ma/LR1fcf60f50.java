/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.reflection.generated.ma;

import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionState;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionSubject;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.reflection.MethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR1fcf60f50
extends MethodAccessibleObject {
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
            case -1776921375: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 2;
                    break;
                }
                n2 = 2;
                break;
            }
            case -1295482316: {
                if (bl) {
                    if (n != 142371135) break;
                    n2 = 9;
                    break;
                }
                n2 = 9;
                break;
            }
            case -1224576867: {
                if (bl) {
                    if (n != 941556127) break;
                    n2 = 0;
                    break;
                }
                n2 = 0;
                break;
            }
            case -1039689282: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 12;
                    break;
                }
                n2 = 12;
                break;
            }
            case -75307658: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 3;
                    break;
                }
                n2 = 3;
                break;
            }
            case 3642346: {
                if (bl) {
                    if (n == -238538240) {
                        n2 = 6;
                        break;
                    }
                    if (n == -266965504) {
                        n2 = 7;
                        break;
                    }
                    if (n != 17) break;
                    n2 = 8;
                    break;
                }
                n2 = 6;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n != 1807049881) break;
                    n2 = 1;
                    break;
                }
                n2 = 1;
                break;
            }
            case 110621981: {
                if (bl) {
                    if (n != -155067449) break;
                    n2 = 5;
                    break;
                }
                n2 = 5;
                break;
            }
            case 147697296: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 10;
                    break;
                }
                n2 = 10;
                break;
            }
            case 700591637: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 4;
                    break;
                }
                n2 = 4;
                break;
            }
            case 1902066701: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 13;
                    break;
                }
                n2 = 13;
                break;
            }
            case 1950569015: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 11;
                    break;
                }
                n2 = 11;
                break;
            }
        }
        return n2;
    }

    @Override
    public Object invoke(int n, Object object, Object[] objectArray) {
        try {
            switch (n) {
                case 0: {
                    return ((AbstractReflectionState)object).handle((EventGeneric)objectArray[0]);
                }
                case 1: {
                    ((AbstractReflectionState)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                    return null;
                }
                case 2: {
                    return ((AbstractReflectionState)object).toString();
                }
                case 3: {
                    return ((AbstractReflectionState)object).getName();
                }
                case 4: {
                    return ((AbstractReflectionState)object).getParent();
                }
                case 5: {
                    ((AbstractReflectionState)object).trans((HsmState)objectArray[0]);
                    return null;
                }
                case 6: {
                    ((AbstractReflectionState)object).wait(((Number)objectArray[0]).longValue());
                    return null;
                }
                case 7: {
                    ((AbstractReflectionState)object).wait(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 8: {
                    ((AbstractReflectionState)object).wait();
                    return null;
                }
                case 9: {
                    return RuntimeUtil.valueOf(((AbstractReflectionState)object).equals(objectArray[0]));
                }
                case 10: {
                    return RuntimeUtil.valueOf(((AbstractReflectionState)object).hashCode());
                }
                case 11: {
                    return ((AbstractReflectionState)object).getClass();
                }
                case 12: {
                    ((AbstractReflectionState)object).notify();
                    return null;
                }
                case 13: {
                    ((AbstractReflectionState)object).notifyAll();
                    return null;
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

