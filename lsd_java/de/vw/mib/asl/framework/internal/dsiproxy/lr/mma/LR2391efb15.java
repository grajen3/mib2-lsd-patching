/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;
import org.dsi.ifc.carhybrid.DSICarHybrid;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public final class LR2391efb15
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2027637733: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1912522698: {
                if (bl) {
                    if (n2 != 294157049) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1884161853: {
                if (bl) {
                    if (n2 != -1373705172) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -1820803733: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1712529471: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1692558890: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1580282037: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1431199929: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1427681555: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1406964073: {
                if (bl) {
                    if (n2 != 294157049) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1397978365: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1393894588: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 48;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 49;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 50;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1134696415: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -948729267: {
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
            case -927756295: {
                if (bl) {
                    if (n2 != -1020699596) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -901405448: {
                if (bl) {
                    if (n2 != 294157049) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -679203424: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -660561210: {
                if (bl) {
                    if (n2 != -938859196) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -656620835: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -596141688: {
                if (bl) {
                    if (n2 != -1262174599) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -386401346: {
                if (bl) {
                    if (n2 != 2103651840) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -375098294: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -345085004: {
                if (bl) {
                    if (n2 != 1855698157) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -333840269: {
                if (bl) {
                    if (n2 != 344255931) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -308267557: {
                if (bl) {
                    if (n2 != 2103651840) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -201882362: {
                if (bl) {
                    if (n2 != 927175622) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -137783669: {
                if (bl) {
                    if (n2 != 2119254695) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -137783668: {
                if (bl) {
                    if (n2 != -111852889) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -137783648: {
                if (bl) {
                    if (n2 != 680965869) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -75765457: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -35201895: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 35016480: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 148479954: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 362694590: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 531642389: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 586959156: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 663833707: {
                if (bl) {
                    if (n2 != 344255931) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 758672911: {
                if (bl) {
                    if (n2 != -1905420432) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 770636295: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 828352933: {
                if (bl) {
                    if (n2 != 1869594488) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 954618783: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 985204172: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1382765594: {
                if (bl) {
                    if (n2 != -235534979) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1452550029: {
                if (bl) {
                    if (n2 != -1695919016) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1629948321: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1724895674: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 2077850960: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 2126075431: {
                if (bl) {
                    if (n2 != 1702896932) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 2140075002: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2054635349: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -1184194630: {
                if (bl) {
                    if (n2 != -13766565) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 79;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 80;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 81;
                    break;
                }
                n3 = 79;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 82;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 83;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 84;
                    break;
                }
                n3 = 82;
                break;
            }
            case -538187811: {
                if (bl) {
                    if (n2 != 982829280) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 213350728: {
                if (bl) {
                    if (n2 != -1989669492) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 374909939: {
                if (bl) {
                    if (n2 != 509509303) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 442439946: {
                if (bl) {
                    if (n2 != 2127266687) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 714034226: {
                if (bl) {
                    if (n2 != 704123126) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 714034227: {
                if (bl) {
                    if (n2 != -1526984458) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 714034228: {
                if (bl) {
                    if (n2 != 520163830) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 714034247: {
                if (bl) {
                    if (n2 != 1079382518) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case 714034248: {
                if (bl) {
                    if (n2 != 952534399) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 1208824003: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 1451278755: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1460969436: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 1489495933: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1610525825: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 1668489025: {
                if (bl) {
                    if (n2 != -466692679) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 1668489026: {
                if (bl) {
                    if (n2 != 1597232569) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 1668489027: {
                if (bl) {
                    if (n2 != -633875015) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 1668489028: {
                if (bl) {
                    if (n2 != 1430050233) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 1668489029: {
                if (bl) {
                    if (n2 != -801057351) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 1668489030: {
                if (bl) {
                    if (n2 != 1262867897) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 1668489031: {
                if (bl) {
                    if (n2 != -968239687) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 1668489032: {
                if (bl) {
                    if (n2 != 1095685561) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 1668489047: {
                if (bl) {
                    if (n2 != -191968544) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
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
            case 359475279: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 542648863: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarKombi)object).resetSIAValue(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSICarKombi)object).requestSIAHistoryList((CarArrayListUpdateInfo)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSICarKombi)object).setSIADistanceOilUser(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSICarKombi)object).setSIADistanceAirFilterUser(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSICarKombi)object).setSIADistanceOilFilterUser(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSICarKombi)object).setSIAInspectionDistanceUser(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSICarKombi)object).setBCVZADisplay((Boolean)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSICarKombi)object).setBCLifeTipsDisplay((Boolean)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSICarKombi)object).setBCConsumerDisplay((Boolean)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSICarKombi)object).setBCMenueConfig((BCMenueConfiguration)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSICarKombi)object).resetBCMenue(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSICarKombi)object).setBCOilTemperature((Boolean)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSICarKombi)object).setBCDigitalSpeed((Boolean)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSICarKombi)object).setBCStopwatch((Boolean)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSICarKombi)object).setBCVzaMFA((Boolean)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSICarKombi)object).setBCSpeedWarning((BCSpeedWarningSettings)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSICarKombi)object).setBCGearRecommendation((Boolean)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSICarKombi)object).setBCRearSeatbeltWarning((Boolean)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSICarKombi)object).requestVehicleStateList((BCVehicleStateUpdateInfoAH)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSICarKombi)object).setBcSetFactoryDefault();
                return null;
            }
            case 20: {
                ((DSICarKombi)object).resetBCStatistics((BCStatisticsReset)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSICarKombi)object).setBCAstaMFA((Boolean)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSICarKombi)object).setHUDHeightAdjustment((byte)((Number)objectArray[0]).intValue());
                return null;
            }
            case 23: {
                ((DSICarKombi)object).setHUDBrightness((byte)((Number)objectArray[0]).intValue());
                return null;
            }
            case 24: {
                ((DSICarKombi)object).setHUDContent((HUDContent)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSICarKombi)object).setHUDRotationAdjustment(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSICarKombi)object).setHUDColour(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSICarKombi)object).setHUDSetFactoryDefault();
                return null;
            }
            case 28: {
                ((DSICarKombi)object).setHUDSystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 29: {
                ((DSICarKombi)object).setDCSetFactoryDefault();
                return null;
            }
            case 30: {
                ((DSICarKombi)object).setDCBrightness(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((DSICarKombi)object).setDCVolume(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarKombi)object).setDCDisplay1MainSelection((DCMainItems)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSICarKombi)object).setDCDisplay2MainSelection((DCMainItems)objectArray[0]);
                return null;
            }
            case 34: {
                ((DSICarKombi)object).setDCDisplay3MainSelection((DCMainItems)objectArray[0]);
                return null;
            }
            case 35: {
                ((DSICarKombi)object).requestDCElementContentSelectionList((DCElementContentSelectionListUpdateInfo)objectArray[0]);
                return null;
            }
            case 36: {
                ((DSICarKombi)object).setDCElementContentSelectionListRA1((DCElementContentSelectionListUpdateInfo)objectArray[0], (DCElementContentSelectionListRA1[])objectArray[1]);
                return null;
            }
            case 37: {
                ((DSICarKombi)object).setDCElementContentSelectionListRA2((DCElementContentSelectionListUpdateInfo)objectArray[0], (DCElementContentSelectionListRA2[])objectArray[1]);
                return null;
            }
            case 38: {
                ((DSICarKombi)object).setDCElementContentSelectionListRAF((DCElementContentSelectionListUpdateInfo)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 39: {
                ((DSICarKombi)object).setDCAdditionalInstrumentSetup((DCAdditionalInstrument)objectArray[0]);
                return null;
            }
            case 40: {
                ((DSICarKombi)object).setDCAdditionalInstrument2Setup((DCAdditionalInstrument2)objectArray[0]);
                return null;
            }
            case 41: {
                ((DSICarKombi)object).requestDCDisplayPresetsList((CarArrayListUpdateInfo)objectArray[0]);
                return null;
            }
            case 42: {
                ((DSICarKombi)object).setDCDisplayPresetsList((CarArrayListUpdateInfo)objectArray[0], (DCDisplayPresetsListRecord[])objectArray[1]);
                return null;
            }
            case 43: {
                ((DSICarKombi)object).setDCDisplayDependencySetup((DCDisplayDependency)objectArray[0]);
                return null;
            }
            case 44: {
                ((DSICarKombi)object).setDCActiveDisplayPreset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 45: {
                ((DSICarKombi)object).setDCDisplayViewConfiguration((DCDisplayViewConfiguration)objectArray[0]);
                return null;
            }
            case 46: {
                ((DSICarKombi)object).setHUDLicense((Boolean)objectArray[0]);
                return null;
            }
            case 47: {
                ((DSICarKombi)object).setDCLEDConfiguration((Boolean)objectArray[0]);
                return null;
            }
            case 48: {
                ((DSICarKombi)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 49: {
                ((DSICarKombi)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 50: {
                ((DSICarKombi)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 51: {
                ((DSICarKombi)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 52: {
                ((DSICarKombi)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 53: {
                ((DSICarKombi)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 54: {
                ((DSICarHybrid)object).setBatteryControlImmediately(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSICarHybrid)object).setBatteryControlTimerState((BatteryControlProgrammedTimer)objectArray[0]);
                return null;
            }
            case 56: {
                ((DSICarHybrid)object).setBatteryControlTimer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), (BatteryControlWeekdays)objectArray[6], ((Number)objectArray[7]).intValue());
                return null;
            }
            case 57: {
                ((DSICarHybrid)object).setBatteryControlSetFactoryDefault();
                return null;
            }
            case 58: {
                ((DSICarHybrid)object).setHybridTargetRange((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSICarHybrid)object).setHybridEnergyAssistControl((Boolean)objectArray[0]);
                return null;
            }
            case 60: {
                ((DSICarHybrid)object).requestBatteryControlProfileList((BatteryControlProfilesAH)objectArray[0]);
                return null;
            }
            case 61: {
                ((DSICarHybrid)object).setBatteryControlProfileListRA0((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA0[])objectArray[1]);
                return null;
            }
            case 62: {
                ((DSICarHybrid)object).setBatteryControlProfileListRA1((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA1[])objectArray[1]);
                return null;
            }
            case 63: {
                ((DSICarHybrid)object).setBatteryControlProfileListRA2((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA2[])objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarHybrid)object).setBatteryControlProfileListRA3((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA3[])objectArray[1]);
                return null;
            }
            case 65: {
                ((DSICarHybrid)object).setBatteryControlProfileListRA4((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA4[])objectArray[1]);
                return null;
            }
            case 66: {
                ((DSICarHybrid)object).setBatteryControlProfileListRA5((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA5[])objectArray[1]);
                return null;
            }
            case 67: {
                ((DSICarHybrid)object).setBatteryControlProfileListRA6((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA6[])objectArray[1]);
                return null;
            }
            case 68: {
                ((DSICarHybrid)object).setBatteryControlProfileListRA7((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA7[])objectArray[1]);
                return null;
            }
            case 69: {
                ((DSICarHybrid)object).setBatteryControlProfileListRAF((BatteryControlProfilesAH)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 70: {
                ((DSICarHybrid)object).setBatteryControlPowerProviderRA0((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRA0[])objectArray[1]);
                return null;
            }
            case 71: {
                ((DSICarHybrid)object).setBatteryControlPowerProviderRA1((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRA1[])objectArray[1]);
                return null;
            }
            case 72: {
                ((DSICarHybrid)object).setBatteryControlPowerProviderRA2((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRA2[])objectArray[1]);
                return null;
            }
            case 73: {
                ((DSICarHybrid)object).setBatteryControlPowerProviderRAE((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRAE[])objectArray[1]);
                return null;
            }
            case 74: {
                ((DSICarHybrid)object).setBatteryControlPowerProviderRAF((BatteryControlPowerProviderAH)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 75: {
                ((DSICarHybrid)object).requestBatteryControlPowerProviderList((BatteryControlPowerProviderAH)objectArray[0]);
                return null;
            }
            case 76: {
                ((DSICarHybrid)object).setBatteryControlPastErrorReason(((Number)objectArray[0]).intValue());
                return null;
            }
            case 77: {
                ((DSICarHybrid)object).setBatteryControlRemainingChargeTime(((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue());
                return null;
            }
            case 78: {
                ((DSICarHybrid)object).setHybridActivePedal((Boolean)objectArray[0]);
                return null;
            }
            case 79: {
                ((DSICarHybrid)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 80: {
                ((DSICarHybrid)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 81: {
                ((DSICarHybrid)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 82: {
                ((DSICarHybrid)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 83: {
                ((DSICarHybrid)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 84: {
                ((DSICarHybrid)object).clearNotification((DSIListener)objectArray[0]);
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

