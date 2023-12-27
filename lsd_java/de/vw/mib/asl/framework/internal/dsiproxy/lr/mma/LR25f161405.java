/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;
import org.dsi.ifc.androidauto2.ServiceConfiguration;
import org.dsi.ifc.androidauto2.TouchEvent;
import org.dsi.ifc.asiainput.DSIAsiaInput;
import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;
import org.dsi.ifc.base.DSIListener;

public final class LR25f161405
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1390052850: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 11;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 12;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 13;
                    break;
                }
                n3 = 11;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 14;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 15;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 16;
                    break;
                }
                n3 = 14;
                break;
            }
            case -643729347: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -184960222: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 241043882: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 807207197: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 962744693: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1048150480: {
                if (bl) {
                    if (n2 != 201029681) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1310899205: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1368900880: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1777707422: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1849707112: {
                if (bl) {
                    if (n2 != 1783944774) break;
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
            case -2131904371: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -2122476712: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -2056641080: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1714262957: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1709058629: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 42;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 43;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 44;
                    break;
                }
                n3 = 42;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 45;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 46;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 47;
                    break;
                }
                n3 = 45;
                break;
            }
            case -848959055: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -578748852: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -306619254: {
                if (bl) {
                    if (n2 != -576316636) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -46570075: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -34972068: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -15462701: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 5316622: {
                if (bl) {
                    if (n2 != -879415808) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 48501477: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 94746818: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 110096336: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 164796527: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 174915898: {
                if (bl) {
                    if (n2 != 641951291) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 263108664: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 541871461: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 678021847: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 682784531: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1223496702: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1452623985: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 1598055499: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
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
            case -1478344177: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 459442767: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAndroidAuto2)object).startService((ServiceConfiguration)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIAndroidAuto2)object).postButtonEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIAndroidAuto2)object).postTouchEvent(((Number)objectArray[0]).intValue(), (TouchEvent[])objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 3: {
                ((DSIAndroidAuto2)object).postRotaryEvent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIAndroidAuto2)object).videoFocusNotification(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIAndroidAuto2)object).audioFocusNotification(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIAndroidAuto2)object).microphoneNotification(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIAndroidAuto2)object).navFocusNotification(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIAndroidAuto2)object).setNightMode((Boolean)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIAndroidAuto2)object).bluetoothPairingResponse((Boolean)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIAndroidAuto2)object).bluetoothAuthenticationData((String)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIAndroidAuto2)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIAndroidAuto2)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIAndroidAuto2)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIAndroidAuto2)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIAndroidAuto2)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIAndroidAuto2)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIAsiaInput)object).clear();
                return null;
            }
            case 18: {
                ((DSIAsiaInput)object).initialize(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIAsiaInput)object).addSymbol(((Character)objectArray[0]).charValue());
                return null;
            }
            case 20: {
                ((DSIAsiaInput)object).addSymbols((String)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIAsiaInput)object).removeSymbol();
                return null;
            }
            case 22: {
                ((DSIAsiaInput)object).removeAllSymbols();
                return null;
            }
            case 23: {
                ((DSIAsiaInput)object).buildCandidates();
                return null;
            }
            case 24: {
                ((DSIAsiaInput)object).getSpelling();
                return null;
            }
            case 25: {
                ((DSIAsiaInput)object).getCandidates(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSIAsiaInput)object).selectCandidate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((DSIAsiaInput)object).setBooleanParameter(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSIAsiaInput)object).setIntParameter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSIAsiaInput)object).getBooleanParameter(((Number)objectArray[0]).intValue());
                return null;
            }
            case 30: {
                ((DSIAsiaInput)object).getIntParameter(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((DSIAsiaInput)object).getVersionInfo();
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIAsiaInput)object).setStringParameter(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 33: {
                ((DSIAsiaInput)object).getStringParameter(((Number)objectArray[0]).intValue());
                return null;
            }
            case 34: {
                ((DSIAsiaInput)object).setPredictionContext((String)objectArray[0]);
                return null;
            }
            case 35: {
                ((DSIAsiaInput)object).clearPredictionContext();
                return null;
            }
            case 36: {
                ((DSIAsiaInput)object).addUserDefinedEntry((UserDefinedEntry)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSIAsiaInput)object).setAdditionalWordDatabases((WordDatabase[])objectArray[0]);
                return null;
            }
            case 38: {
                ((DSIAsiaInput)object).setUserDatabaseState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSIAsiaInput)object).resetToFactorySettings();
                return null;
            }
            case 40: {
                ((DSIAsiaInput)object).getSegmentation((String)objectArray[0]);
                return null;
            }
            case 41: {
                ((DSIAsiaInput)object).requestSegmentationForTruffles((String)objectArray[0]);
                return null;
            }
            case 42: {
                ((DSIAsiaInput)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 43: {
                ((DSIAsiaInput)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 44: {
                ((DSIAsiaInput)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 45: {
                ((DSIAsiaInput)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 46: {
                ((DSIAsiaInput)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 47: {
                ((DSIAsiaInput)object).clearNotification((DSIListener)objectArray[0]);
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

