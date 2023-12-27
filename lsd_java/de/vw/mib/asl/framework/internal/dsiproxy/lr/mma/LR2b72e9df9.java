/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener;
import org.dsi.ifc.online.DSIOnlineTrafficListener;
import org.dsi.ifc.online.FCDPosition;
import org.dsi.ifc.online.LocatablePosition;

public final class LR2b72e9df9
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 738675397: {
                if (bl) {
                    if (n2 != 514058505) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 738998500: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1433375578: {
                if (bl) {
                    if (n2 != 734093362) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2012997823: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1876218664: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -867180710: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -595555234: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -351684743: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -188113972: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 878034928: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 964262118: {
                if (bl) {
                    if (n2 != -1514310245) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1773740001: {
                if (bl) {
                    if (n2 != -794014703) break;
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
            case -150455058: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 50188808: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIOnlineTrafficLightInfoListener)object).updateTrafficLightInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (int[])objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 1: {
                ((DSIOnlineTrafficLightInfoListener)object).updateTrafficLightSpeed((CarBCSpeed)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIOnlineTrafficLightInfoListener)object).updateTrafficLightTime(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIOnlineTrafficLightInfoListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIOnlineTrafficListener)object).updateConsumerReady(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIOnlineTrafficListener)object).updateWantOnlineTrafficData(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIOnlineTrafficListener)object).getNewDataResult(((Number)objectArray[0]).intValue(), (LocatablePosition[])objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIOnlineTrafficListener)object).setNewDataResult((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIOnlineTrafficListener)object).getNewSession();
                return null;
            }
            case 9: {
                ((DSIOnlineTrafficListener)object).setTimeoutForFallbackResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSIOnlineTrafficListener)object).getNewFCDInformationResult((FCDPosition)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIOnlineTrafficListener)object).getInventoryResult((String)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIOnlineTrafficListener)object).getDownloadFileResult((String)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIOnlineTrafficListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

