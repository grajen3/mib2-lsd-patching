/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navservicesapi.AddressDataSDIS;
import org.dsi.ifc.navservicesapi.DSINavAsiaRemoteHMI;
import org.dsi.ifc.navservicesapi.DSINavAsiaSDIS;

public final class LR259251112
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 1;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 2;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 3;
                    break;
                }
                n3 = 1;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 4;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 5;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 6;
                    break;
                }
                n3 = 4;
                break;
            }
            case -18097361: {
                if (bl) {
                    if (n2 != 363018741) break;
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
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 7;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 8;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 9;
                    break;
                }
                n3 = 7;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 10;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 11;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 12;
                    break;
                }
                n3 = 10;
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
            case -1005241711: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 34839698: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSINavAsiaSDIS)object).startGuidanceToDestinations((AddressDataSDIS[])objectArray[0]);
                return null;
            }
            case 1: {
                ((DSINavAsiaSDIS)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 2: {
                ((DSINavAsiaSDIS)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSINavAsiaSDIS)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSINavAsiaSDIS)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSINavAsiaSDIS)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSINavAsiaSDIS)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSINavAsiaRemoteHMI)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSINavAsiaRemoteHMI)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSINavAsiaRemoteHMI)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSINavAsiaRemoteHMI)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSINavAsiaRemoteHMI)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSINavAsiaRemoteHMI)object).clearNotification((DSIListener)objectArray[0]);
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

