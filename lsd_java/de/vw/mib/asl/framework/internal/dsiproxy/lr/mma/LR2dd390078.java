/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.connectedradio.DSIHybridRadio;
import org.dsi.ifc.connectedradio.DSIOnlineRadio;
import org.dsi.ifc.connectedradio.RadioStation;

public final class LR2dd390078
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1234909419: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1162471198: {
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
            case -1149893535: {
                if (bl) {
                    if (n2 != 1706190718) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 13;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 14;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 15;
                    break;
                }
                n3 = 13;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -5545694: {
                if (bl) {
                    if (n2 != 1774564560) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 804025579: {
                if (bl) {
                    if (n2 != -481054408) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 952484847: {
                if (bl) {
                    if (n2 != 1141589977) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1487721665: {
                if (bl) {
                    if (n2 != -481054408) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2084079822: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 25;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 26;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 27;
                    break;
                }
                n3 = 25;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 28;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 29;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 30;
                    break;
                }
                n3 = 28;
                break;
            }
            case -325238386: {
                if (bl) {
                    if (n2 != -481054408) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 431838758: {
                if (bl) {
                    if (n2 != -481054408) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 952484847: {
                if (bl) {
                    if (n2 != -1097252031) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1152465048: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case 974085369: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 2030080752: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIHybridRadio)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIHybridRadio)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIHybridRadio)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIHybridRadio)object).profileResetAll();
                return null;
            }
            case 4: {
                ((DSIHybridRadio)object).getOnlineRadioAvailability(((Number)objectArray[0]).intValue(), (RadioStation[])objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIHybridRadio)object).getRadioStationLogo(((Number)objectArray[0]).intValue(), (RadioStation[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSIHybridRadio)object).cancelGetRadioStationLogo(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((DSIHybridRadio)object).getStream(((Number)objectArray[0]).intValue(), (RadioStation)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIHybridRadio)object).startSlideshow(((Number)objectArray[0]).intValue(), (RadioStation)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 9: {
                ((DSIHybridRadio)object).stopSlideshow(((Number)objectArray[0]).intValue(), (RadioStation)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIHybridRadio)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIHybridRadio)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIHybridRadio)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIHybridRadio)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIHybridRadio)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIHybridRadio)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIOnlineRadio)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSIOnlineRadio)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIOnlineRadio)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIOnlineRadio)object).profileResetAll();
                return null;
            }
            case 20: {
                ((DSIOnlineRadio)object).getRadioStationLogo(((Number)objectArray[0]).intValue(), (RadioStation)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 21: {
                ((DSIOnlineRadio)object).getStreamUrl(((Number)objectArray[0]).intValue(), (RadioStation)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIOnlineRadio)object).getMetaInformation(((Number)objectArray[0]).intValue(), (RadioStation)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIOnlineRadio)object).downloadDatabase(((Number)objectArray[0]).intValue());
                return null;
            }
            case 24: {
                ((DSIOnlineRadio)object).cancelDownloadDatabase(((Number)objectArray[0]).intValue());
                return null;
            }
            case 25: {
                ((DSIOnlineRadio)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIOnlineRadio)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 27: {
                ((DSIOnlineRadio)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIOnlineRadio)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIOnlineRadio)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIOnlineRadio)object).clearNotification((DSIListener)objectArray[0]);
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

