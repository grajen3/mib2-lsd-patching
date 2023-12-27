/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.navservicesapi.AddressDataSDIS;
import org.dsi.ifc.navservicesapi.DSINavAsiaRemoteHMIListener;
import org.dsi.ifc.navservicesapi.DSINavAsiaSDISListener;

public final class LR249924bae
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1669648449: {
                if (bl) {
                    if (n2 != 1397658632) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -937795755: {
                if (bl) {
                    if (n2 != 293586473) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 918534004: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1725402618: {
                if (bl) {
                    if (n2 != -1706191864) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1907678335: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1992011081: {
                if (bl) {
                    if (n2 != -1263655781) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
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
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -779150264: {
                if (bl) {
                    if (n2 != 351368437) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 375890451: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 389853961: {
                if (bl) {
                    if (n2 != -1551912362) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 631479276: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1336267093: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 10;
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
            case -1984866202: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1659930469: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSINavAsiaRemoteHMIListener)object).updateDayNightView(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSINavAsiaRemoteHMIListener)object).updateCurrentCityAndStreet((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSINavAsiaRemoteHMIListener)object).updateDestination((double[])objectArray[0], (double[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSINavAsiaRemoteHMIListener)object).updateDestinationDistanceAndTime((double[])objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSINavAsiaRemoteHMIListener)object).updatePositionInfo(((Number)objectArray[0]).doubleValue(), ((Number)objectArray[1]).doubleValue(), ((Number)objectArray[2]).doubleValue(), ((Number)objectArray[3]).doubleValue(), ((Number)objectArray[4]).doubleValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 5: {
                ((DSINavAsiaRemoteHMIListener)object).updateNavigationState((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSINavAsiaRemoteHMIListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSINavAsiaSDISListener)object).updateCarPosition(((Number)objectArray[0]).doubleValue(), ((Number)objectArray[1]).doubleValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 8: {
                ((DSINavAsiaSDISListener)object).updateRouteGuidanceActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSINavAsiaSDISListener)object).updateDestinationInfo((AddressDataSDIS[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSINavAsiaSDISListener)object).updateNextDestinationInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 11: {
                ((DSINavAsiaSDISListener)object).startGuidanceToDestinationsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSINavAsiaSDISListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

