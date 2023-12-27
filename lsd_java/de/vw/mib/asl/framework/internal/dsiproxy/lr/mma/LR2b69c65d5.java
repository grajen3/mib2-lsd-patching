/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.tpegservices.DSITPEGServices;
import org.dsi.ifc.trafficregulation.DSITrafficRegulation;

public final class LR2b69c65d5
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1367643167: {
                if (bl) {
                    if (n2 != -203993492) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1162471198: {
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
            case -1135469701: {
                if (bl) {
                    if (n2 != -1263655781) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -948729267: {
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
            case 417760312: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1339493710: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2137958866: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1712403030: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1340268358: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 21;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 22;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 23;
                    break;
                }
                n3 = 21;
                break;
            }
            case -956688321: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -948729267: {
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
            case -888384546: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -41589388: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 221985700: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 661966632: {
                if (bl) {
                    if (n2 != 1654790675) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 917650611: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1575909789: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
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
            case -1014984513: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1963424943: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSITrafficRegulation)object).setTrailerStatus((Boolean)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSITrafficRegulation)object).setSpeedLimitWarning((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSITrafficRegulation)object).requestRoadClassSpeedInfoForCountry((String)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSITrafficRegulation)object).setWarningStatus(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], (Boolean)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 4: {
                ((DSITrafficRegulation)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSITrafficRegulation)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSITrafficRegulation)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSITrafficRegulation)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSITrafficRegulation)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSITrafficRegulation)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSITPEGServices)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSITPEGServices)object).requestResourceInformation(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSITPEGServices)object).requestSimpleMapList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSITPEGServices)object).addSimpleMapBookmark(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSITPEGServices)object).deleteSimpleMapBookmark(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSITPEGServices)object).deleteAllSimpleMapBookmarks();
                return null;
            }
            case 16: {
                ((DSITPEGServices)object).requestLocationDetails(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSITPEGServices)object).requestFuelPriceInformation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSITPEGServices)object).requestSortedFuelPriceInformation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((DSITPEGServices)object).requestNewsInformation(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSITPEGServices)object).requestWeatherInfo((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 21: {
                ((DSITPEGServices)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSITPEGServices)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSITPEGServices)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSITPEGServices)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSITPEGServices)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSITPEGServices)object).clearNotification((DSIListener)objectArray[0]);
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

