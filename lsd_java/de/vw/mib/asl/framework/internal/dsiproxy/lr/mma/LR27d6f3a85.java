/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;

public final class LR27d6f3a85
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1826167340: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1761237301: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1363538731: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1192549561: {
                if (bl) {
                    if (n2 != 1200215690) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
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
            case -1076158411: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -980902765: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -971311326: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
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
            case -825806033: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -568112800: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -141445704: {
                if (bl) {
                    if (n2 != -1206923075) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -103086434: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -90452530: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 113385049: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 263973997: {
                if (bl) {
                    if (n2 != -786116603) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 594066008: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 603897103: {
                if (bl) {
                    if (n2 != 262394267) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 604381230: {
                if (bl) {
                    if (n2 != -1519454978) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 631628220: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 966339196: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1549035280: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1984960372: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
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
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 31;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 32;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 33;
                    break;
                }
                n3 = 31;
                break;
            }
            case -535625483: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
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
            case -1962528973: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1283044229: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarTimeUnitsLanguage)object).setMenuLanguage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSICarTimeUnitsLanguage)object).setPressureUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSICarTimeUnitsLanguage)object).setVolumeUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSICarTimeUnitsLanguage)object).setTemperatureUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSICarTimeUnitsLanguage)object).setDistanceUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSICarTimeUnitsLanguage)object).setSpeedUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSICarTimeUnitsLanguage)object).setConsumptionPetrolUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((DSICarTimeUnitsLanguage)object).setConsumptionGasUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSICarTimeUnitsLanguage)object).setConsumptionElectricUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSICarTimeUnitsLanguage)object).setClockFormat(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSICarTimeUnitsLanguage)object).setDateFormat(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSICarTimeUnitsLanguage)object).setClockDate((ClockDate)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSICarTimeUnitsLanguage)object).setClockTime((byte)((Number)objectArray[0]).intValue(), (byte)((Number)objectArray[1]).intValue(), (byte)((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSICarTimeUnitsLanguage)object).setClockSource(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSICarTimeUnitsLanguage)object).setClockDayLightSaving((Boolean)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSICarTimeUnitsLanguage)object).setClockTimeZoneOffset(((Number)objectArray[0]).floatValue());
                return null;
            }
            case 16: {
                ((DSICarTimeUnitsLanguage)object).setClockGPSSyncData((ClockGPSSyncData)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSICarTimeUnitsLanguage)object).setClockSummerTimeData((ClockSummerTimeData)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSICarTimeUnitsLanguage)object).setUmSetFactoryDefault();
                return null;
            }
            case 19: {
                ((DSICarTimeUnitsLanguage)object).setSkin(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSICarTimeUnitsLanguage)object).setWeightUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSICarTimeUnitsLanguage)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSICarTimeUnitsLanguage)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSICarTimeUnitsLanguage)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSICarTimeUnitsLanguage)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSICarTimeUnitsLanguage)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSICarTimeUnitsLanguage)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSICarVehicleStates)object).setCarMenuState((Boolean)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSICarVehicleStates)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSICarVehicleStates)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSICarVehicleStates)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 31: {
                ((DSICarVehicleStates)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarVehicleStates)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 33: {
                ((DSICarVehicleStates)object).clearNotification((DSIListener)objectArray[0]);
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

