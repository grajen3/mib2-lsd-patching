/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.DSIUnifiedTuner;
import org.dsi.ifc.radiodata.DSIRadioData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public final class LR2dbe2e30
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
            case -1489597295: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 12;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 13;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 14;
                    break;
                }
                n3 = 12;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 15;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 16;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 17;
                    break;
                }
                n3 = 15;
                break;
            }
            case -423903449: {
                if (bl) {
                    if (n2 != -2091232198) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
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
            case -248330603: {
                if (bl) {
                    if (n2 != -2069928368) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -213223709: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 96596415: {
                if (bl) {
                    if (n2 != -322254790) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
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
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1212999342: {
                if (bl) {
                    if (n2 != -2035976393) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1672609946: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1742880533: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1370022004: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1173679347: {
                if (bl) {
                    if (n2 != 2019970585) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 29;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 30;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 31;
                    break;
                }
                n3 = 29;
                break;
            }
            case -960200616: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 32;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 33;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 34;
                    break;
                }
                n3 = 32;
                break;
            }
            case -911979761: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -236025846: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1201442612: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1814470903: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
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
            case 1291420271: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1364290686: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIRadioData)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIRadioData)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIRadioData)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIRadioData)object).profileResetAll();
                return null;
            }
            case 4: {
                ((DSIRadioData)object).requestRadioStationData((RadioStationDataRequest[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIRadioData)object).requestRadioStationLogos((RadioStationLogoRequest[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIRadioData)object).requestDynamicDatabaseAlteration((RadioStationData)objectArray[0], (ResourceLocator)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 7: {
                ((DSIRadioData)object).requestCountryListUpdate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSIRadioData)object).requestDatabaseVersionInfo(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSIRadioData)object).requestPersistStationLogos((RadioStationData[])objectArray[0], (ResourceLocator[])objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 10: {
                ((DSIRadioData)object).requestCountryRegionData(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIRadioData)object).requestCountryRegionTranslationData(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSIRadioData)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIRadioData)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIRadioData)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSIRadioData)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIRadioData)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIRadioData)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIUnifiedTuner)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIUnifiedTuner)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIUnifiedTuner)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIUnifiedTuner)object).profileResetAll();
                return null;
            }
            case 22: {
                ((DSIUnifiedTuner)object).selectStation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 23: {
                ((DSIUnifiedTuner)object).enableRadioTextPlus((int[])objectArray[0]);
                return null;
            }
            case 24: {
                ((DSIUnifiedTuner)object).setStationFollowingMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 25: {
                ((DSIUnifiedTuner)object).setListMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSIUnifiedTuner)object).setSoftLinkSwitch(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((DSIUnifiedTuner)object).setRegMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSIUnifiedTuner)object).switchDeviceUsage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSIUnifiedTuner)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIUnifiedTuner)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSIUnifiedTuner)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIUnifiedTuner)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 33: {
                ((DSIUnifiedTuner)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSIUnifiedTuner)object).clearNotification((DSIListener)objectArray[0]);
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
                case 1: {
                    return this.f1(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

