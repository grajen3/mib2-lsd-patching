/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;
import org.dsi.ifc.komoview.DSIKOMOView;
import org.dsi.ifc.komoview.RouteInfoElement;

public final class LR21d51f8b3
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1769525412: {
                if (bl) {
                    if (n2 != 399416174) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 5;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 6;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 7;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1052791847: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 8;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 9;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 10;
                    break;
                }
                n3 = 8;
                break;
            }
            case 800450275: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1706717898: {
                if (bl) {
                    if (n2 != -541996280) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1786122672: {
                if (bl) {
                    if (n2 != -1653679357) break;
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
            case -2138173883: {
                if (bl) {
                    if (n2 != 134146313) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1797352312: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 24;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 25;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 26;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1073509677: {
                if (bl) {
                    if (n2 != -1673404256) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 27;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 28;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 29;
                    break;
                }
                n3 = 27;
                break;
            }
            case -905813947: {
                if (bl) {
                    if (n2 != 1284528019) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -905801435: {
                if (bl) {
                    if (n2 != -47233896) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -816011646: {
                if (bl) {
                    if (n2 != 599185780) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -705929201: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -156707627: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 567638925: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 944564722: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1049665453: {
                if (bl) {
                    if (n2 != 3540) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1058902993: {
                if (bl) {
                    if (n2 != -1673404256) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1088448035: {
                if (bl) {
                    if (n2 != -799149515) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
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
            case -994295139: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 736648943: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIKOMOView)object).enableKomoView((Boolean)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIKOMOView)object).notifyVisibility((Boolean)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSIKOMOView)object).setRouteInfoElement((RouteInfoElement)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIKOMOView)object).setRouteInfo((RouteInfoElement[])objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIKOMOView)object).setKomoViewStyle(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSIKOMOView)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIKOMOView)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIKOMOView)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIKOMOView)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIKOMOView)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIKOMOView)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIKOMONavInfo)object).setDistanceToNextManeuver(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 12: {
                ((DSIKOMONavInfo)object).setETA(((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue(), (Boolean)objectArray[4], (Boolean)objectArray[5]);
                return null;
            }
            case 13: {
                ((DSIKOMONavInfo)object).setCurrentStreet((String)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIKOMONavInfo)object).setTurnToStreet((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIKOMONavInfo)object).setCityName((String)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIKOMONavInfo)object).setDistanceToDestination(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 17: {
                ((DSIKOMONavInfo)object).setSemiDynRoute((Boolean)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIKOMONavInfo)object).setTrafficOffset(((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue(), (Boolean)objectArray[4]);
                return null;
            }
            case 19: {
                ((DSIKOMONavInfo)object).setRTT((short)((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 20: {
                ((DSIKOMONavInfo)object).setRgSelect(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIKOMONavInfo)object).setCapabilities((boolean[])objectArray[0]);
                return null;
            }
            case 22: {
                ((DSIKOMONavInfo)object).setMapScale(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (boolean[])objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 23: {
                ((DSIKOMONavInfo)object).setMapScaleResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (boolean[])objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), (boolean[])objectArray[5], (Boolean)objectArray[6]);
                return null;
            }
            case 24: {
                ((DSIKOMONavInfo)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSIKOMONavInfo)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIKOMONavInfo)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSIKOMONavInfo)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSIKOMONavInfo)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIKOMONavInfo)object).clearNotification((DSIListener)objectArray[0]);
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

