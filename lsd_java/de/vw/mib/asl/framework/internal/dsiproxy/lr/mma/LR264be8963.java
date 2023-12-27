/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.DSICarAirCondition;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public final class LR264be8963
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2138854039: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1350320226: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1339244746: {
                if (bl) {
                    if (n2 != 1208512944) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1339244745: {
                if (bl) {
                    if (n2 != 1208512944) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1339244744: {
                if (bl) {
                    if (n2 != 1208512944) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1167473268: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 16;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 17;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 18;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1147671489: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 19;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 20;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 21;
                    break;
                }
                n3 = 19;
                break;
            }
            case -728331453: {
                if (bl) {
                    if (n2 != -786116603) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -369495169: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 408330666: {
                if (bl) {
                    if (n2 != -413485701) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 569960143: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1187664718: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1337775024: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1338760524: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1570456450: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1705664653: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -2132521771: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -2132521770: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -2132521769: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -2059529537: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -2045575168: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1996566307: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1948413180: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -1905683006: {
                if (bl) {
                    if (n2 != 1438747621) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -1864758323: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -1619753504: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1479545648: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1223880035: {
                if (bl) {
                    if (n2 != 1093176124) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -1196363514: {
                if (bl) {
                    if (n2 != 900101400) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 77;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 78;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 79;
                    break;
                }
                n3 = 77;
                break;
            }
            case -1030617536: {
                if (bl) {
                    if (n2 != -203993492) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 80;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 81;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 82;
                    break;
                }
                n3 = 80;
                break;
            }
            case -833474654: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -724600268: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -717630633: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -686909523: {
                if (bl) {
                    if (n2 != -1997068910) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -648696880: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -642144786: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -628573393: {
                if (bl) {
                    if (n2 != -1493401699) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -603975117: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -529327795: {
                if (bl) {
                    if (n2 != -954151869) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -362207841: {
                if (bl) {
                    if (n2 != -372872443) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -283874546: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -276537311: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -274231064: {
                if (bl) {
                    if (n2 != -182019978) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -270589604: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -183571787: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -122827604: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -76058501: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 15806156: {
                if (bl) {
                    if (n2 != -1481751395) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 113481499: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 146436580: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 643038868: {
                if (bl) {
                    if (n2 != -1481751395) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 669608968: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 726322000: {
                if (bl) {
                    if (n2 != -743549655) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 737004066: {
                if (bl) {
                    if (n2 != 901202624) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 910519370: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 967389336: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 976488407: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 1222257699: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 1222758929: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 1236813054: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1279127473: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1300403985: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1325818385: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1494472141: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1675233636: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 1821423320: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1930141878: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 1999365199: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1999569199: {
                if (bl) {
                    if (n2 != -543989963) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 2012858932: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 2051883273: {
                if (bl) {
                    if (n2 != -79597027) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
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
            case 606089743: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 739725229: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerRunningTime((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerDefaultStartMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerEngineHeater((Boolean)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerActiveTimer(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerTimer1((AuxHeaterCoolerTimer)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerTimer2((AuxHeaterCoolerTimer)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerTimer3((AuxHeaterCoolerTimer)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterSetFactoryDefault();
                return null;
            }
            case 11: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerExtendedConditioning((AuxHeaterCoolerExtendedConditioning)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerWindowHeating((Boolean)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerUnlockClimating(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerTargetTemperature(((Number)objectArray[0]).floatValue());
                return null;
            }
            case 15: {
                ((DSICarAuxHeaterCooler)object).setAuxHeaterCoolerAirQuality((Boolean)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSICarAuxHeaterCooler)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSICarAuxHeaterCooler)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSICarAuxHeaterCooler)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSICarAuxHeaterCooler)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSICarAuxHeaterCooler)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSICarAuxHeaterCooler)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSICarAirCondition)object).setAirconAirCirculationMan((Boolean)objectArray[0]);
                return null;
            }
            case 23: {
                ((DSICarAirCondition)object).setAirconAirCirculationAuto((Boolean)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSICarAirCondition)object).setAirconMiddleExhaustion(((Number)objectArray[0]).intValue());
                return null;
            }
            case 25: {
                ((DSICarAirCondition)object).setAirconRearWindowHeater((Boolean)objectArray[0]);
                return null;
            }
            case 26: {
                ((DSICarAirCondition)object).setAirconIndirectVentilation((Boolean)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSICarAirCondition)object).setAirconPopupTime(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSICarAirCondition)object).setAirconHeater((Boolean)objectArray[0]);
                return null;
            }
            case 29: {
                ((DSICarAirCondition)object).setAirconRearAuxHeater((Boolean)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSICarAirCondition)object).setAirconFrontWindowHeater((Boolean)objectArray[0]);
                return null;
            }
            case 31: {
                ((DSICarAirCondition)object).setAirconDefrost((Boolean)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarAirCondition)object).setAirconMaxDefrost((Boolean)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSICarAirCondition)object).setAirconSolar((Boolean)objectArray[0]);
                return null;
            }
            case 34: {
                ((DSICarAirCondition)object).setAirconAC((Boolean)objectArray[0]);
                return null;
            }
            case 35: {
                ((DSICarAirCondition)object).setAirconMaxAC((Boolean)objectArray[0]);
                return null;
            }
            case 36: {
                ((DSICarAirCondition)object).setAirconEcoAC((Boolean)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSICarAirCondition)object).setAirconRearControl((Boolean)objectArray[0]);
                return null;
            }
            case 38: {
                ((DSICarAirCondition)object).setAirconRearControlFondPlus((Boolean)objectArray[0]);
                return null;
            }
            case 39: {
                ((DSICarAirCondition)object).setAirconSteeringWheelHeater((AirconSteeringWheelHeater)objectArray[0]);
                return null;
            }
            case 40: {
                ((DSICarAirCondition)object).setAirconFrontWindowHeaterAuto((Boolean)objectArray[0]);
                return null;
            }
            case 41: {
                ((DSICarAirCondition)object).setAirconBlowerCompensation((AirconBlowerCompensation)objectArray[0]);
                return null;
            }
            case 42: {
                ((DSICarAirCondition)object).setAirconSynchronisation((AirconSynchronisation)objectArray[0]);
                return null;
            }
            case 43: {
                ((DSICarAirCondition)object).setAirconSuppressVisualisation((Boolean)objectArray[0]);
                return null;
            }
            case 44: {
                ((DSICarAirCondition)object).setAirconSystemOnOffRow(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 45: {
                ((DSICarAirCondition)object).setAirconAirCirculationSensitivity(((Number)objectArray[0]).intValue());
                return null;
            }
            case 46: {
                ((DSICarAirCondition)object).setAirconResidualHeat((Boolean)objectArray[0]);
                return null;
            }
            case 47: {
                ((DSICarAirCondition)object).showAirconPopup((AirconContent)objectArray[0]);
                return null;
            }
            case 48: {
                ((DSICarAirCondition)object).cancelAirconPopup((AirconContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSICarAirCondition)object).setAirconContent((AirconContent)objectArray[0]);
                return null;
            }
            case 50: {
                ((DSICarAirCondition)object).setAirconTempZone(((Number)objectArray[0]).intValue(), (AirconTemp)objectArray[1]);
                return null;
            }
            case 51: {
                ((DSICarAirCondition)object).setAirconAirVolume(((Number)objectArray[0]).intValue(), (AirconAirVolume)objectArray[1]);
                return null;
            }
            case 52: {
                ((DSICarAirCondition)object).setAirconAirDistribution(((Number)objectArray[0]).intValue(), (AirconAirDistribution)objectArray[1]);
                return null;
            }
            case 53: {
                ((DSICarAirCondition)object).setAirconFootwellTemp(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSICarAirCondition)object).setAirconSeatHeater(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 55: {
                ((DSICarAirCondition)object).setAirconSeatVentilation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 56: {
                ((DSICarAirCondition)object).setAirconHMIIsReady((Boolean)objectArray[0]);
                return null;
            }
            case 57: {
                ((DSICarAirCondition)object).setAirconSeatHeaterDistribution(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSICarAirCondition)object).setAirconSeatVentilationDistribution(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSICarAirCondition)object).setAirconTempStep(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 60: {
                ((DSICarAirCondition)object).setAirconClimateStyle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((DSICarAirCondition)object).setAirconSetFactoryDefaultMaster();
                return null;
            }
            case 62: {
                ((DSICarAirCondition)object).setAirconSetFactoryDefaultRow(((Number)objectArray[0]).intValue());
                return null;
            }
            case 63: {
                ((DSICarAirCondition)object).setAirconNozzleControlRow1(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarAirCondition)object).setAirconNozzleControlRow2(((Number)objectArray[0]).intValue());
                return null;
            }
            case 65: {
                ((DSICarAirCondition)object).setAirconNozzleControlRow3(((Number)objectArray[0]).intValue());
                return null;
            }
            case 66: {
                ((DSICarAirCondition)object).requestAirconNozzleListRow(((Number)objectArray[0]).intValue(), (CarArrayListUpdateInfo)objectArray[1]);
                return null;
            }
            case 67: {
                ((DSICarAirCondition)object).setAirconNozzleListRow(((Number)objectArray[0]).intValue(), (CarArrayListUpdateInfo)objectArray[1], (AirconNozzleListRecord[])objectArray[2]);
                return null;
            }
            case 68: {
                ((DSICarAirCondition)object).setAirconSideWindowDefrost((Boolean)objectArray[0]);
                return null;
            }
            case 69: {
                ((DSICarAirCondition)object).setAirconPureAir((AirconPureAirSetup)objectArray[0]);
                return null;
            }
            case 70: {
                ((DSICarAirCondition)object).setAirconFreshAirConfig((AirconFreshAirConfiguration)objectArray[0]);
                return null;
            }
            case 71: {
                ((DSICarAirCondition)object).setAirconAirQuality(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((DSICarAirCondition)object).setAirconSeatNeckHeater(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 73: {
                ((DSICarAirCondition)object).setAirconSeatSurfaceHeater(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], (Boolean)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 74: {
                ((DSICarAirCondition)object).setAirconIndividualClimatisation(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 75: {
                ((DSICarAirCondition)object).setAirconIonisator(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 76: {
                ((DSICarAirCondition)object).setAirconBodyCloseMeasures(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], (AirconBCMeasuresConfiguration)objectArray[2]);
                return null;
            }
            case 77: {
                ((DSICarAirCondition)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 78: {
                ((DSICarAirCondition)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 79: {
                ((DSICarAirCondition)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 80: {
                ((DSICarAirCondition)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 81: {
                ((DSICarAirCondition)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 82: {
                ((DSICarAirCondition)object).clearNotification((DSIListener)objectArray[0]);
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
                case 2: {
                    return this.f2(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

