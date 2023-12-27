/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.reflection.generated.ma;

import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionSubject;
import de.vw.mib.reflection.MethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR19964b56b
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
            case -1789895108: {
                if (bl) {
                    if (n != -638526483) break;
                    n2 = 0;
                    break;
                }
                n2 = 0;
                break;
            }
            case -1776921375: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 7;
                    break;
                }
                n2 = 7;
                break;
            }
            case -1436755036: {
                if (bl) {
                    if (n != -638526483) break;
                    n2 = 1;
                    break;
                }
                n2 = 1;
                break;
            }
            case -1295482316: {
                if (bl) {
                    if (n != 142371135) break;
                    n2 = 6;
                    break;
                }
                n2 = 6;
                break;
            }
            case -1039689282: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 10;
                    break;
                }
                n2 = 10;
                break;
            }
            case 3642346: {
                if (bl) {
                    if (n == -238538240) {
                        n2 = 3;
                        break;
                    }
                    if (n == -266965504) {
                        n2 = 4;
                        break;
                    }
                    if (n != 17) break;
                    n2 = 5;
                    break;
                }
                n2 = 3;
                break;
            }
            case 147697296: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 8;
                    break;
                }
                n2 = 8;
                break;
            }
            case 1465402121: {
                if (bl) {
                    if (n != -638526483) break;
                    n2 = 2;
                    break;
                }
                n2 = 2;
                break;
            }
            case 1902066701: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 11;
                    break;
                }
                n2 = 11;
                break;
            }
            case 1950569015: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 9;
                    break;
                }
                n2 = 9;
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
                    return RuntimeUtil.valueOf(((AbstractReflectionSubject)object).handleBefore((String)objectArray[0], (Class[])objectArray[1], (Object[])objectArray[2]));
                }
                case 1: {
                    ((AbstractReflectionSubject)object).handleNormal((String)objectArray[0], (Class[])objectArray[1], (Object[])objectArray[2]);
                    return null;
                }
                case 2: {
                    ((AbstractReflectionSubject)object).handleAfter((String)objectArray[0], (Class[])objectArray[1], (Object[])objectArray[2]);
                    return null;
                }
                case 3: {
                    ((AbstractReflectionSubject)object).wait(((Number)objectArray[0]).longValue());
                    return null;
                }
                case 4: {
                    ((AbstractReflectionSubject)object).wait(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 5: {
                    ((AbstractReflectionSubject)object).wait();
                    return null;
                }
                case 6: {
                    return RuntimeUtil.valueOf(((AbstractReflectionSubject)object).equals(objectArray[0]));
                }
                case 7: {
                    return ((AbstractReflectionSubject)object).toString();
                }
                case 8: {
                    return RuntimeUtil.valueOf(((AbstractReflectionSubject)object).hashCode());
                }
                case 9: {
                    return ((AbstractReflectionSubject)object).getClass();
                }
                case 10: {
                    ((AbstractReflectionSubject)object).notify();
                    return null;
                }
                case 11: {
                    ((AbstractReflectionSubject)object).notifyAll();
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

