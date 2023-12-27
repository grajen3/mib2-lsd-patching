/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.careco.StartStopListUpdateInfo;

public final class LR24838a15f
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2046433692: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1963668978: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1954075618: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1845111465: {
                if (bl) {
                    if (n2 != 619323385) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1552331688: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1551888595: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1449098730: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1440466386: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1293269407: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 34;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 35;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 36;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1051263231: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1023256202: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -990223731: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -967155737: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 37;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 38;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 39;
                    break;
                }
                n3 = 37;
                break;
            }
            case -936557063: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -782235197: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -166220717: {
                if (bl) {
                    if (n2 != 187343945) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 110567624: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 118949816: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 122863193: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 137510488: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 144446966: {
                if (bl) {
                    if (n2 != -854988625) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 266741395: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 270435847: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 535991512: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1040197360: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1162171185: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1181310392: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1435629705: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1450307932: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1492557914: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1546289556: {
                if (bl) {
                    if (n2 != 1728467928) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1672718018: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1765620134: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1889356396: {
                if (bl) {
                    if (n2 != -1653679357) break;
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
            case -2139183919: {
                if (bl) {
                    if (n2 != 777275727) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1666018957: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1630567092: {
                if (bl) {
                    if (n2 != -1556977295) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1362458214: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1162471198: {
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
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 57;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 58;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 59;
                    break;
                }
                n3 = 57;
                break;
            }
            case -606097179: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -302269235: {
                if (bl) {
                    if (n2 != -1556977295) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -301360855: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -278008720: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 669083462: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 765680411: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 822461110: {
                if (bl) {
                    if (n2 != 777275727) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1142630932: {
                if (bl) {
                    if (n2 != 777275727) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1835081703: {
                if (bl) {
                    if (n2 != -1556977295) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1969209026: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
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
            case 355451983: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 487461857: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarDrivingCharacteristics)object).setHMIIsReady((Boolean)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSICarDrivingCharacteristics)object).setSuspensionControlLiftMode((Boolean)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSICarDrivingCharacteristics)object).setSuspensionControlCarJackMode((Boolean)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSICarDrivingCharacteristics)object).setSuspensionControlTrailerMode((Boolean)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSICarDrivingCharacteristics)object).setSuspensionControlLoadingMode((Boolean)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSICarDrivingCharacteristics)object).setSuspensionControlActiveProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSICarDrivingCharacteristics)object).setSuspensionControlSnowChainMode((Boolean)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSICarDrivingCharacteristics)object).setSuspensionControlActiveMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSICarDrivingCharacteristics)object).seteABCEasyEntry((Boolean)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSICarDrivingCharacteristics)object).seteABCPitchControl((Boolean)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSICarDrivingCharacteristics)object).seteABCSpecialPosition((Boolean)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSICarDrivingCharacteristics)object).seteABCPreview(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSICarDrivingCharacteristics)object).setCharismaActiveProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSICarDrivingCharacteristics)object).setCharismaActiveOperationMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSICarDrivingCharacteristics)object).setCharismaTrailerSetting((Boolean)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSICarDrivingCharacteristics)object).setCharismaProgButton((CharismaProgButton)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSICarDrivingCharacteristics)object).requestCharismaProfileFunction(((Number)objectArray[0]).intValue(), (CharismaSetupTableWithoutOptionMask[])objectArray[1]);
                return null;
            }
            case 17: {
                ((DSICarDrivingCharacteristics)object).requestCharismaList((CharismaListUpdateInfo)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSICarDrivingCharacteristics)object).showCharismaPopup(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSICarDrivingCharacteristics)object).cancelCharismaPopup(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSICarDrivingCharacteristics)object).setCharismaSetFactoryDefault();
                return null;
            }
            case 21: {
                ((DSICarDrivingCharacteristics)object).setCharismaSound((Boolean)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSICarDrivingCharacteristics)object).showTADPopup(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSICarDrivingCharacteristics)object).cancelTADPopup(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSICarDrivingCharacteristics)object).setTADSetFactoryDefault();
                return null;
            }
            case 25: {
                ((DSICarDrivingCharacteristics)object).setTADMaxMinAngleReset((TADMaxMinAngleReset)objectArray[0]);
                return null;
            }
            case 26: {
                ((DSICarDrivingCharacteristics)object).setSpoilerSetFactoryDefault();
                return null;
            }
            case 27: {
                ((DSICarDrivingCharacteristics)object).setSpoilerPositionSelection(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSICarDrivingCharacteristics)object).setSpoilerActuation((Boolean)objectArray[0]);
                return null;
            }
            case 29: {
                ((DSICarDrivingCharacteristics)object).setSpoilerSystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSICarDrivingCharacteristics)object).setSoundSetFactoryDefault();
                return null;
            }
            case 31: {
                ((DSICarDrivingCharacteristics)object).setSoundStyle(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarDrivingCharacteristics)object).setSoundSystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSICarDrivingCharacteristics)object).setSoundOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 34: {
                ((DSICarDrivingCharacteristics)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 35: {
                ((DSICarDrivingCharacteristics)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 36: {
                ((DSICarDrivingCharacteristics)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSICarDrivingCharacteristics)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 38: {
                ((DSICarDrivingCharacteristics)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 39: {
                ((DSICarDrivingCharacteristics)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 40: {
                ((DSICarEco)object).requestBCmEConsumerList((BCmEListUpdateInfo)objectArray[0]);
                return null;
            }
            case 41: {
                ((DSICarEco)object).setBCmELiveTip(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 42: {
                ((DSICarEco)object).setBcmeSetFactoryDefault();
                return null;
            }
            case 43: {
                ((DSICarEco)object).requestStartStopProhibitList((StartStopListUpdateInfo)objectArray[0]);
                return null;
            }
            case 44: {
                ((DSICarEco)object).requestStartStopRestartList((StartStopListUpdateInfo)objectArray[0]);
                return null;
            }
            case 45: {
                ((DSICarEco)object).requestStartStopRestartProhibitList((StartStopListUpdateInfo)objectArray[0]);
                return null;
            }
            case 46: {
                ((DSICarEco)object).requestBCmEConsumerListConsumption((BCmEListUpdateInfo)objectArray[0]);
                return null;
            }
            case 47: {
                ((DSICarEco)object).requestBCmEConsumerListRange((BCmEListUpdateInfo)objectArray[0]);
                return null;
            }
            case 48: {
                ((DSICarEco)object).setRDSetFactoryDefault();
                return null;
            }
            case 49: {
                ((DSICarEco)object).setEASystem((Boolean)objectArray[0]);
                return null;
            }
            case 50: {
                ((DSICarEco)object).setEAPedalJerk((Boolean)objectArray[0]);
                return null;
            }
            case 51: {
                ((DSICarEco)object).setEASetFactoryDefault();
                return null;
            }
            case 52: {
                ((DSICarEco)object).setEAFreeWheeling((Boolean)objectArray[0]);
                return null;
            }
            case 53: {
                ((DSICarEco)object).setEAStartStop((Boolean)objectArray[0]);
                return null;
            }
            case 54: {
                ((DSICarEco)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 55: {
                ((DSICarEco)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 56: {
                ((DSICarEco)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 57: {
                ((DSICarEco)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 58: {
                ((DSICarEco)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 59: {
                ((DSICarEco)object).clearNotification((DSIListener)objectArray[0]);
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

