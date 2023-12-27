/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public final class LR2a5afefdd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1980612655: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1966643958: {
                if (bl) {
                    if (n2 != 1030378054) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -136746969: {
                if (bl) {
                    if (n2 != 1094169551) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -135453574: {
                if (bl) {
                    if (n2 != 337895296) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 395900773: {
                if (bl) {
                    if (n2 != 1030378054) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 568674067: {
                if (bl) {
                    if (n2 != 761336800) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 723522569: {
                if (bl) {
                    if (n2 != 1292143943) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 880173181: {
                if (bl) {
                    if (n2 != -1050339275) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1369056634: {
                if (bl) {
                    if (n2 != -24365529) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1438410589: {
                if (bl) {
                    if (n2 != 1498250642) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1588113820: {
                if (bl) {
                    if (n2 != -1605396596) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1683072759: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1983076373: {
                if (bl) {
                    if (n2 != 1877862961) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 2061353222: {
                if (bl) {
                    if (n2 != 551226169) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 2103583265: {
                if (bl) {
                    if (n2 != 1030378054) break;
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
            case -2056341579: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -2048785661: {
                if (bl) {
                    if (n2 != -1984965103) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1959755529: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1854566054: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1234178172: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1188973399: {
                if (bl) {
                    if (n2 != 1099873457) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1128445597: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -982481889: {
                if (bl) {
                    if (n2 != -1218638914) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -836452264: {
                if (bl) {
                    if (n2 != -1628171818) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -668537088: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -436957673: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -295958437: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 166678798: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 218063687: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 270025864: {
                if (bl) {
                    if (n2 != 250678428) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 270509991: {
                if (bl) {
                    if (n2 != 760485020) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 452369567: {
                if (bl) {
                    if (n2 != -1514740036) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 688918811: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 695723957: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1222488808: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1458735068: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1553990714: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 1794191526: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1866352529: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 2032534968: {
                if (bl) {
                    if (n2 != -1065139711) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
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
            case 1190902279: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1666060111: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarVehicleStatesListener)object).updateOilLevelViewOption((CarViewOption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSICarVehicleStatesListener)object).updateOilLevelData((OilLevelData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSICarVehicleStatesListener)object).updateVINViewOption((CarViewOption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSICarVehicleStatesListener)object).updateVINData((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSICarVehicleStatesListener)object).updateKeyViewOption((CarViewOption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSICarVehicleStatesListener)object).updateKeyData((KeyData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSICarVehicleStatesListener)object).updateDrvSchoolSystem((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSICarVehicleStatesListener)object).updateVehicleInfoViewOptions((VehicleInfoViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSICarVehicleStatesListener)object).updateDynamicVehicleInfoHighFrequentViewOptions((DynamicVehicleInfoHighFrequentViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSICarVehicleStatesListener)object).updateDynamicVehicleInfoMidFrequentViewOptions((DynamicVehicleInfoMidFrequentViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSICarVehicleStatesListener)object).updateDynamicVehicleInfoHighFrequent((DynamicVehicleInfoHighFrequent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSICarVehicleStatesListener)object).updateDynamicVehicleInfoMidFrequent((DynamicVehicleInfoMidFrequent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSICarVehicleStatesListener)object).updateSemiStaticVehicleDataViewOptions((SemiStaticDataViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSICarVehicleStatesListener)object).updateSemiStaticVehicleData((SemiStaticVehicleData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSICarVehicleStatesListener)object).updateDynamicVehicleInfoSCR((DynamicVehicleInfoSCR)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSICarVehicleStatesListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSICarTimeUnitsLanguageListener)object).updateUnitmasterViewOptions((UnitmasterViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSICarTimeUnitsLanguageListener)object).updateMenuLanguage(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSICarTimeUnitsLanguageListener)object).updateTemperatureUnit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSICarTimeUnitsLanguageListener)object).updateDistanceUnit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSICarTimeUnitsLanguageListener)object).updateSpeedUnit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSICarTimeUnitsLanguageListener)object).updatePressureUnit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSICarTimeUnitsLanguageListener)object).updateVolumeUnit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSICarTimeUnitsLanguageListener)object).updateConsumptionPetrolUnit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSICarTimeUnitsLanguageListener)object).updateConsumptionGasUnit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSICarTimeUnitsLanguageListener)object).updateConsumptionElectricUnit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSICarTimeUnitsLanguageListener)object).updateClockFormat(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSICarTimeUnitsLanguageListener)object).updateDateFormat(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSICarTimeUnitsLanguageListener)object).updateClockViewOptions((ClockViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSICarTimeUnitsLanguageListener)object).updateClockDate((ClockDate)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSICarTimeUnitsLanguageListener)object).updateClockTime((ClockTime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSICarTimeUnitsLanguageListener)object).updateClockSource(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarTimeUnitsLanguageListener)object).updateClockDayLightSaving((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSICarTimeUnitsLanguageListener)object).updateClockDayLightSavingData((ClockDayLightSavingData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSICarTimeUnitsLanguageListener)object).updateClockTimeZoneOffset(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSICarTimeUnitsLanguageListener)object).updateClockTimeSourcesAvailable((ClockSources)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSICarTimeUnitsLanguageListener)object).updateClockGPSSyncData((ClockGPSSyncData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSICarTimeUnitsLanguageListener)object).acknowledgeUmSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 38: {
                ((DSICarTimeUnitsLanguageListener)object).updateUTCOffset((UTCOffset)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSICarTimeUnitsLanguageListener)object).updateSkin(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSICarTimeUnitsLanguageListener)object).updateWeightUnit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSICarTimeUnitsLanguageListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

