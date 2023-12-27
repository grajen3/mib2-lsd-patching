/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.radio.DSIDABTuner;

public final class LR2d8bfdffd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2075472267: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1997586260: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1951355184: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1173679347: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
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
            case -983406880: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
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
            case -881079831: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -613659083: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -524720404: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -85277490: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -85277119: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 412598102: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 446649272: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 536352273: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 625042269: {
                if (bl) {
                    if (n2 != -1008715669) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1023328084: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1136798484: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1238325521: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1417183988: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1429502479: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1651362613: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -2077149290: {
                if (bl) {
                    if (n2 != -1627964855) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1817439242: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -1591326652: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1587357554: {
                if (bl) {
                    if (n2 != 1478382248) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 51;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 52;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 53;
                    break;
                }
                n3 = 51;
                break;
            }
            case -1022863210: {
                if (bl) {
                    if (n2 != -365497012) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 54;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 55;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 56;
                    break;
                }
                n3 = 54;
                break;
            }
            case -524720404: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -84427766: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 122674066: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1201442612: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1238325521: {
                if (bl) {
                    if (n2 != 2019970585) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1426248850: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1542101659: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1651349558: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 1933332041: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 2054888324: {
                if (bl) {
                    if (n2 != -365497012) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
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
            case -1077405973: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 550802043: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAMFMTuner)object).reset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIAMFMTuner)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIAMFMTuner)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIAMFMTuner)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIAMFMTuner)object).profileResetAll();
                return null;
            }
            case 5: {
                ((DSIAMFMTuner)object).tuneFrequencySteps(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSIAMFMTuner)object).selectStation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSIAMFMTuner)object).prepareTuning(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIAMFMTuner)object).seekStation(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSIAMFMTuner)object).switchAF((Boolean)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIAMFMTuner)object).switchME((Boolean)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIAMFMTuner)object).switchREG(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSIAMFMTuner)object).switchLinkingDeviceUsage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSIAMFMTuner)object).selectFrequency(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIAMFMTuner)object).setAMBandRange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSIAMFMTuner)object).isOnPreset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
                return null;
            }
            case 16: {
                ((DSIAMFMTuner)object).forceFMUpdate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSIAMFMTuner)object).switchPiIgnore((Boolean)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIAMFMTuner)object).freePreset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIAMFMTuner)object).forceAMUpdate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSIAMFMTuner)object).switchRDSIgnore((Boolean)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIAMFMTuner)object).enableRadiotextPlus((int[])objectArray[0]);
                return null;
            }
            case 22: {
                ((DSIAMFMTuner)object).setModeHD(((Number)objectArray[0]).intValue());
                return null;
            }
            case 23: {
                ((DSIAMFMTuner)object).setERTPrefered((Boolean)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSIAMFMTuner)object).setERTDisplayable((Boolean)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSIAMFMTuner)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIAMFMTuner)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 27: {
                ((DSIAMFMTuner)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIAMFMTuner)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIAMFMTuner)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIAMFMTuner)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 31: {
                ((DSIDABTuner)object).reset(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIDABTuner)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 33: {
                ((DSIDABTuner)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSIDABTuner)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSIDABTuner)object).profileResetAll();
                return null;
            }
            case 36: {
                ((DSIDABTuner)object).prepareTuning(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 37: {
                ((DSIDABTuner)object).switchLinkingDeviceUsage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 38: {
                ((DSIDABTuner)object).selectService(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).longValue());
                return null;
            }
            case 39: {
                ((DSIDABTuner)object).seekService(((Number)objectArray[0]).intValue());
                return null;
            }
            case 40: {
                ((DSIDABTuner)object).tuneEnsemble(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).longValue());
                return null;
            }
            case 41: {
                ((DSIDABTuner)object).selectDataService(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).longValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 42: {
                ((DSIDABTuner)object).switchDRC((Boolean)objectArray[0]);
                return null;
            }
            case 43: {
                ((DSIDABTuner)object).switchLinking(((Number)objectArray[0]).intValue());
                return null;
            }
            case 44: {
                ((DSIDABTuner)object).switchFrequencyTable(((Number)objectArray[0]).intValue());
                return null;
            }
            case 45: {
                ((DSIDABTuner)object).forceLMUpdate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 46: {
                ((DSIDABTuner)object).enableRadioTextPlus((int[])objectArray[0]);
                return null;
            }
            case 47: {
                ((DSIDABTuner)object).setEpgMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 48: {
                ((DSIDABTuner)object).setSlideShowMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 49: {
                ((DSIDABTuner)object).setIntellitextMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 50: {
                ((DSIDABTuner)object).getEPGDetailData(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).longValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 51: {
                ((DSIDABTuner)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 52: {
                ((DSIDABTuner)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 53: {
                ((DSIDABTuner)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 54: {
                ((DSIDABTuner)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 55: {
                ((DSIDABTuner)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 56: {
                ((DSIDABTuner)object).clearNotification((DSIListener)objectArray[0]);
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

