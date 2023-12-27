/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlPlug;
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
import org.dsi.ifc.carhybrid.BatteryControlRemainingChargeTime;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.DSICarHybridListener;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridInhibitReason;
import org.dsi.ifc.carhybrid.HybridTargetRange;
import org.dsi.ifc.carhybrid.HybridViewOptions;
import org.dsi.ifc.carkombi.BCAverageRecoveredEnergy;
import org.dsi.ifc.carkombi.BCComfortPowerConsumption;
import org.dsi.ifc.carkombi.BCCycleGeneralData;
import org.dsi.ifc.carkombi.BCIndications;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.carkombi.BCMaxValues;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCRefuelVolume;
import org.dsi.ifc.carkombi.BCResetTimeStamp;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsAC;
import org.dsi.ifc.carkombi.BCStatisticsConfig;
import org.dsi.ifc.carkombi.BCStatisticsDistanceEU;
import org.dsi.ifc.carkombi.BCStatisticsRE;
import org.dsi.ifc.carkombi.BCStatisticsZE;
import org.dsi.ifc.carkombi.BCTankLevel;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteTime;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.carkombi.DSICarKombiListener;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;
import org.dsi.ifc.carkombi.SIADistanceData;
import org.dsi.ifc.carkombi.SIAHistoryListRecord;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCTemperature;
import org.dsi.ifc.global.CarBCTime;

public final class LR226091fcd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1904693842: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1823239197: {
                if (bl) {
                    if (n2 != 704123126) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1823239196: {
                if (bl) {
                    if (n2 != -1526984458) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1823239195: {
                if (bl) {
                    if (n2 != 520163830) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1823239176: {
                if (bl) {
                    if (n2 != 1079382518) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1823239175: {
                if (bl) {
                    if (n2 != 952534399) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1783977702: {
                if (bl) {
                    if (n2 != 97989933) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1783977701: {
                if (bl) {
                    if (n2 != 97989933) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1783977700: {
                if (bl) {
                    if (n2 != 97989933) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1783977699: {
                if (bl) {
                    if (n2 != 97989933) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1752832533: {
                if (bl) {
                    if (n2 != 791841360) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1527367908: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1390115065: {
                if (bl) {
                    if (n2 != 319559816) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1370475934: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -910703141: {
                if (bl) {
                    if (n2 != 1608450191) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -827124427: {
                if (bl) {
                    if (n2 != -105458462) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -773267248: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -601622410: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -561535318: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -552459430: {
                if (bl) {
                    if (n2 != -200270971) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -247021317: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 37479504: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 502500403: {
                if (bl) {
                    if (n2 != 912563667) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 748865372: {
                if (bl) {
                    if (n2 != 910546598) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 758951701: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 841861552: {
                if (bl) {
                    if (n2 != -466692679) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 841861553: {
                if (bl) {
                    if (n2 != 1597232569) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 841861554: {
                if (bl) {
                    if (n2 != -633875015) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 841861555: {
                if (bl) {
                    if (n2 != 1430050233) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 841861556: {
                if (bl) {
                    if (n2 != -801057351) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 841861557: {
                if (bl) {
                    if (n2 != 1262867897) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 841861558: {
                if (bl) {
                    if (n2 != -968239687) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 841861559: {
                if (bl) {
                    if (n2 != 1095685561) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 841861574: {
                if (bl) {
                    if (n2 != -191968544) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 906506044: {
                if (bl) {
                    if (n2 != 6744080) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1010884075: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1095302202: {
                if (bl) {
                    if (n2 != 342845610) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1442629433: {
                if (bl) {
                    if (n2 != -43508118) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1453469805: {
                if (bl) {
                    if (n2 != -808166167) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1709448071: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1744606537: {
                if (bl) {
                    if (n2 != 231529538) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1938013988: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 2016124704: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2116489725: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case -2103094770: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case -2079729162: {
                if (bl) {
                    if (n2 != -1917070736) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case -2068061992: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -2026430129: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case -1973911318: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1973911317: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -1930547352: {
                if (bl) {
                    if (n2 != 1334994738) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -1930547104: {
                if (bl) {
                    if (n2 != -323253343) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -1829840018: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -1799503438: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -1706600236: {
                if (bl) {
                    if (n2 != 2092001536) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -1688817254: {
                if (bl) {
                    if (n2 != 1483909880) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case -1608680751: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case -1605717546: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1605717545: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -1563997494: {
                if (bl) {
                    if (n2 != -1755345336) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case -1563997246: {
                if (bl) {
                    if (n2 != -2016183794) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -1541381116: {
                if (bl) {
                    if (n2 != 1334994738) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case -1541380868: {
                if (bl) {
                    if (n2 != 872896471) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -1533336504: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case -1510832436: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case -1456080269: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case -1315380404: {
                if (bl) {
                    if (n2 != 1857944184) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case -1248070532: {
                if (bl) {
                    if (n2 != 674632799) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case -1248070258: {
                if (bl) {
                    if (n2 != 674632799) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case -1248070041: {
                if (bl) {
                    if (n2 != 674632799) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case -1242256800: {
                if (bl) {
                    if (n2 != 39962012) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case -1239317278: {
                if (bl) {
                    if (n2 != -2040689080) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -1239317277: {
                if (bl) {
                    if (n2 != -2040689080) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1201651143: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1186286671: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case -1129251731: {
                if (bl) {
                    if (n2 != 915525318) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case -1085296022: {
                if (bl) {
                    if (n2 != 2119254695) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case -1085296021: {
                if (bl) {
                    if (n2 != -111852889) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case -1085296001: {
                if (bl) {
                    if (n2 != 680965869) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case -1050462861: {
                if (bl) {
                    if (n2 != -111842013) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case -981521383: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -915562029: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -880155763: {
                if (bl) {
                    if (n2 != 152394615) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case -863873755: {
                if (bl) {
                    if (n2 != -938859196) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case -762210920: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case -671601982: {
                if (bl) {
                    if (n2 != -374586791) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case -652206279: {
                if (bl) {
                    if (n2 != 456735088) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -634463371: {
                if (bl) {
                    if (n2 != 1483909880) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -591806816: {
                if (bl) {
                    if (n2 != -2107705080) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -538209560: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case -538209559: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case -536319092: {
                if (bl) {
                    if (n2 != -235534979) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case -494662157: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case -435072180: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -435072179: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -368795420: {
                if (bl) {
                    if (n2 != -1554991284) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case -353931861: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case -194962981: {
                if (bl) {
                    if (n2 != -757996214) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -184930631: {
                if (bl) {
                    if (n2 != -111842013) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case -184930357: {
                if (bl) {
                    if (n2 != -111842013) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case -184930140: {
                if (bl) {
                    if (n2 != -111842013) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case -122666870: {
                if (bl) {
                    if (n2 != -2040689080) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case -122666869: {
                if (bl) {
                    if (n2 != -2040689080) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -112333733: {
                if (bl) {
                    if (n2 != -1474934342) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case -109433313: {
                if (bl) {
                    if (n2 != -1961859894) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -83704582: {
                if (bl) {
                    if (n2 != -1474934342) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case -55075431: {
                if (bl) {
                    if (n2 != -1474934342) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case -44675630: {
                if (bl) {
                    if (n2 != 1946429412) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1154852: {
                if (bl) {
                    if (n2 != -111842013) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 5551481: {
                if (bl) {
                    if (n2 != -455114596) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 5551482: {
                if (bl) {
                    if (n2 != -455114596) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 57834803: {
                if (bl) {
                    if (n2 != -757996214) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 60376631: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 66324081: {
                if (bl) {
                    if (n2 != -1385773887) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case 129555652: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 135772143: {
                if (bl) {
                    if (n2 != 282506745) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case 227119623: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 282539012: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case 282539013: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 297434066: {
                if (bl) {
                    if (n2 != 528164644) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 333275403: {
                if (bl) {
                    if (n2 != -788463319) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 351184589: {
                if (bl) {
                    if (n2 != -235534979) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 379581436: {
                if (bl) {
                    if (n2 != -1385421011) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 394630123: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 410337477: {
                if (bl) {
                    if (n2 != 528164644) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case 474038638: {
                if (bl) {
                    if (n2 != 1483909880) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 625153548: {
                if (bl) {
                    if (n2 != -1362357492) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 641330768: {
                if (bl) {
                    if (n2 != 282506745) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case 655158174: {
                if (bl) {
                    if (n2 != -374586791) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case 822364008: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case 848026184: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case 883859489: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 944677722: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 944677723: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 958702263: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case 976291140: {
                if (bl) {
                    if (n2 != -40655928) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 998577841: {
                if (bl) {
                    if (n2 != 64768246) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case 1010577696: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1053909940: {
                if (bl) {
                    if (n2 != -1724346280) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1060867741: {
                if (bl) {
                    if (n2 != -253238490) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1139298950: {
                if (bl) {
                    if (n2 != -2112373264) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case 1143816183: {
                if (bl) {
                    if (n2 != 2092001536) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case 1146889393: {
                if (bl) {
                    if (n2 != 282506745) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case 1159857025: {
                if (bl) {
                    if (n2 != 1840175177) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 1206381148: {
                if (bl) {
                    if (n2 != -1446739516) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 1238688270: {
                if (bl) {
                    if (n2 != -235534979) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 1282259862: {
                if (bl) {
                    if (n2 != -1043640351) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 1282259863: {
                if (bl) {
                    if (n2 != -1043640351) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1316036516: {
                if (bl) {
                    if (n2 != -959691099) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 1464800587: {
                if (bl) {
                    if (n2 != -757996214) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 1556812782: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case 1584464680: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case 1607137184: {
                if (bl) {
                    if (n2 != -1032349900) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 1652782050: {
                if (bl) {
                    if (n2 != -566732785) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 1726104964: {
                if (bl) {
                    if (n2 != -2146781421) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 1755082321: {
                if (bl) {
                    if (n2 != -1775390996) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case 1777840234: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 1786558187: {
                if (bl) {
                    if (n2 != 1165565472) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 1797159458: {
                if (bl) {
                    if (n2 != -1755345336) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case 1797159706: {
                if (bl) {
                    if (n2 != 1065922520) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 1805587473: {
                if (bl) {
                    if (n2 != -781955632) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case 1805587747: {
                if (bl) {
                    if (n2 != -781955632) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case 1805587964: {
                if (bl) {
                    if (n2 != -781955632) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case 1883255096: {
                if (bl) {
                    if (n2 != 1217466906) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 1883255097: {
                if (bl) {
                    if (n2 != 1217466906) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 1933458324: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case 1947444900: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 1973703339: {
                if (bl) {
                    if (n2 != -757996214) break;
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
            case -757737693: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 2127169779: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarHybridListener)object).updateHybridViewOptions((HybridViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSICarHybridListener)object).updateHybridCharge(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSICarHybridListener)object).updateHybridEnergyFlowState((HybridEnergyFlowState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSICarHybridListener)object).updateHybridRecoveredEnergy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSICarHybridListener)object).updateHybridEnergyFlow(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSICarHybridListener)object).updateHybridEnergyAssistControl((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSICarHybridListener)object).updateHybridEnergyAssistState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSICarHybridListener)object).updateBatteryControlViewOptions((BatteryControlViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSICarHybridListener)object).updateBatteryControlPlug((BatteryControlPlug)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSICarHybridListener)object).updateBatteryControlChargeState((BatteryControlChargeState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSICarHybridListener)object).updateBatteryControlClimateState((BatteryControlClimateState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSICarHybridListener)object).updateBatteryControlTimerState((BatteryControlTimerState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSICarHybridListener)object).updateBatteryControlTimer1((BatteryControlTimer)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSICarHybridListener)object).updateBatteryControlTimer2((BatteryControlTimer)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSICarHybridListener)object).updateBatteryControlTimer3((BatteryControlTimer)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSICarHybridListener)object).updateBatteryControlTimer4((BatteryControlTimer)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSICarHybridListener)object).updateBatteryControlTotalNumberOfProfiles(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSICarHybridListener)object).updateBatteryControlProfilesListUpdateInfo((BatteryControlProfilesAH)objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSICarHybridListener)object).updateBatteryControlTotalNumberOfPowerProvider(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSICarHybridListener)object).updateBatteryControlPowerProviderListUpdateInfo((BatteryControlPowerProviderAH)objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 20: {
                ((DSICarHybridListener)object).acknowledgeBatteryControlSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSICarHybridListener)object).acknowledgeBatteryControlImmediately((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSICarHybridListener)object).responseProfileListRA0((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA0[])objectArray[1]);
                return null;
            }
            case 23: {
                ((DSICarHybridListener)object).responseProfileListRA1((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA1[])objectArray[1]);
                return null;
            }
            case 24: {
                ((DSICarHybridListener)object).responseProfileListRA2((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA2[])objectArray[1]);
                return null;
            }
            case 25: {
                ((DSICarHybridListener)object).responseProfileListRA3((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA3[])objectArray[1]);
                return null;
            }
            case 26: {
                ((DSICarHybridListener)object).responseProfileListRA4((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA4[])objectArray[1]);
                return null;
            }
            case 27: {
                ((DSICarHybridListener)object).responseProfileListRA5((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA5[])objectArray[1]);
                return null;
            }
            case 28: {
                ((DSICarHybridListener)object).responseProfileListRA6((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA6[])objectArray[1]);
                return null;
            }
            case 29: {
                ((DSICarHybridListener)object).responseProfileListRA7((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA7[])objectArray[1]);
                return null;
            }
            case 30: {
                ((DSICarHybridListener)object).responseProfileListRAF((BatteryControlProfilesAH)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 31: {
                ((DSICarHybridListener)object).responsePowerProviderListRA0((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRA0[])objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarHybridListener)object).responsePowerProviderListRA1((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRA1[])objectArray[1]);
                return null;
            }
            case 33: {
                ((DSICarHybridListener)object).responsePowerProviderListRA2((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRA2[])objectArray[1]);
                return null;
            }
            case 34: {
                ((DSICarHybridListener)object).responsePowerProviderListRAE((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRAE[])objectArray[1]);
                return null;
            }
            case 35: {
                ((DSICarHybridListener)object).responsePowerProviderListRAF((BatteryControlPowerProviderAH)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 36: {
                ((DSICarHybridListener)object).updateHybridTargetRange((HybridTargetRange)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSICarHybridListener)object).updateBatteryControlPastErrorReason(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 38: {
                ((DSICarHybridListener)object).updateBatteryControlPlugDisplayState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 39: {
                ((DSICarHybridListener)object).updateBatteryControlRemainingChargeTime((BatteryControlRemainingChargeTime)objectArray[0], (BatteryControlRemainingChargeTime)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 40: {
                ((DSICarHybridListener)object).updateBatteryControlLowestMaxCurrent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSICarHybridListener)object).updateHybridInhibitReason((HybridInhibitReason)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSICarHybridListener)object).updateHybridActivePedal((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((DSICarHybridListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 44: {
                ((DSICarKombiListener)object).updateSIAViewOptions((SIAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSICarKombiListener)object).updateSIAServiceData((SIAServiceData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSICarKombiListener)object).updateSIAOilInspection((SIAOilInspection)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 47: {
                ((DSICarKombiListener)object).indicateEndOfSIAReset((Boolean)objectArray[0]);
                return null;
            }
            case 48: {
                ((DSICarKombiListener)object).updateSIAHistoryListUpdateInfo((CarArrayListUpdateInfo)objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 49: {
                ((DSICarKombiListener)object).responseSIAHistoryList((CarArrayListUpdateInfo)objectArray[0], (SIAHistoryListRecord[])objectArray[1]);
                return null;
            }
            case 50: {
                ((DSICarKombiListener)object).updateSIAHistoryListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((DSICarKombiListener)object).updateSIADistanceOilUser((SIADistanceData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSICarKombiListener)object).updateSIADistanceAirFilterUser((SIADistanceData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((DSICarKombiListener)object).updateSIADistanceOilFilterUser((SIADistanceData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSICarKombiListener)object).updateSIAInspectionDistanceUser((SIADistanceData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSICarKombiListener)object).updateSIADailyAverageMileage(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 56: {
                ((DSICarKombiListener)object).updateBCViewOptions((BCViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSICarKombiListener)object).updateBCIndications((BCIndications)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSICarKombiListener)object).updateBCCurrentConsumption1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSICarKombiListener)object).updateBCCurrentConsumption2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 60: {
                ((DSICarKombiListener)object).updateBCCurrentRange1((CarBCCurrentRange)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((DSICarKombiListener)object).updateBCCurrentRange2((CarBCCurrentRange)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((DSICarKombiListener)object).updateBCTotalDistance((CarBCDistance)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSICarKombiListener)object).updateBCShortTermAverageConsumption1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarKombiListener)object).updateBCShortTermAverageConsumption2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((DSICarKombiListener)object).updateBCShortTermGeneral((BCShortTermGeneralData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 66: {
                ((DSICarKombiListener)object).updateBCLongTermAverageConsumption1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((DSICarKombiListener)object).updateBCLongTermAverageConsumption2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((DSICarKombiListener)object).updateBCLongTermGeneral((BCLongTermGeneralData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((DSICarKombiListener)object).updateBCCycleAverageConsumption1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 70: {
                ((DSICarKombiListener)object).updateBCCycleAverageConsumption2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 71: {
                ((DSICarKombiListener)object).updateBCCycleGeneral((BCCycleGeneralData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((DSICarKombiListener)object).updateBCVZADisplay((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 73: {
                ((DSICarKombiListener)object).updateBCLifeTipsDisplay((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 74: {
                ((DSICarKombiListener)object).updateBCConsumerDisplay((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((DSICarKombiListener)object).updateBCTankLevel1((BCTankLevel)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 76: {
                ((DSICarKombiListener)object).updateBCTankLevel2((BCTankLevel)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 77: {
                ((DSICarKombiListener)object).updateBCRefuelVolume1((BCRefuelVolume)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 78: {
                ((DSICarKombiListener)object).updateBCRefuelVolume2((BCRefuelVolume)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 79: {
                ((DSICarKombiListener)object).updateBCMenue1Config((BCMenueConfiguration)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 80: {
                ((DSICarKombiListener)object).updateBCMenue2Config((BCMenueConfiguration)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 81: {
                ((DSICarKombiListener)object).updateBCMenue3Config((BCMenueConfiguration)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 82: {
                ((DSICarKombiListener)object).updateBCOilTemperature((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 83: {
                ((DSICarKombiListener)object).updateBCDigitalSpeed((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 84: {
                ((DSICarKombiListener)object).updateBCStopwatch((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 85: {
                ((DSICarKombiListener)object).updateBCVzaMFA((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 86: {
                ((DSICarKombiListener)object).updateBCSpeedWarning((BCSpeedWarningSettings)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 87: {
                ((DSICarKombiListener)object).updateBCGearRecommendation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 88: {
                ((DSICarKombiListener)object).updateBCRearSeatbeltWarning((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((DSICarKombiListener)object).updateBCOutsideTemperature((CarBCTemperature)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 90: {
                ((DSICarKombiListener)object).indicateEndOfBCMenuReset((Boolean)objectArray[0]);
                return null;
            }
            case 91: {
                ((DSICarKombiListener)object).updateBCVehicleStateListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 92: {
                ((DSICarKombiListener)object).responseVehicleStateUpdateInfo((BCVehicleStateUpdateInfoAH)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 93: {
                ((DSICarKombiListener)object).responseVehicleStateListWarningIDdynValueAlternativeText((BCVehicleStateUpdateInfoAH)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3], (String)objectArray[4]);
                return null;
            }
            case 94: {
                ((DSICarKombiListener)object).responseVehicleStateListWarningIDdynValue((BCVehicleStateUpdateInfoAH)objectArray[0], (ListWarningIDsDynValues[])objectArray[1]);
                return null;
            }
            case 95: {
                ((DSICarKombiListener)object).responseVehicleStateListAlternativeText((BCVehicleStateUpdateInfoAH)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSICarKombiListener)object).responseVehicleStateListdynValue((BCVehicleStateUpdateInfoAH)objectArray[0], (ListDynValues[])objectArray[1]);
                return null;
            }
            case 97: {
                ((DSICarKombiListener)object).responseVehicleStateListPos((BCVehicleStateUpdateInfoAH)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 98: {
                ((DSICarKombiListener)object).acknowledgeBcSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 99: {
                ((DSICarKombiListener)object).acknowledgeHUDSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 100: {
                ((DSICarKombiListener)object).acknowledgeDCSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 101: {
                ((DSICarKombiListener)object).acknowledgeBcStatisticsReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 102: {
                ((DSICarKombiListener)object).updateBCStatisticsDistanceAC1((BCStatisticsAC)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 103: {
                ((DSICarKombiListener)object).updateBCStatisticsDistanceAC2((BCStatisticsAC)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 104: {
                ((DSICarKombiListener)object).updateBCStatisticsDistanceRE((BCStatisticsRE)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 105: {
                ((DSICarKombiListener)object).updateBCStatisticsDistanceZE((BCStatisticsZE)objectArray[0], (BCZeroEmissionAbsoluteDistance)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 106: {
                ((DSICarKombiListener)object).updateBCStatisticsDistanceCurrentIntervalAC1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 107: {
                ((DSICarKombiListener)object).updateBCStatisticsDistanceCurrentIntervalAC2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 108: {
                ((DSICarKombiListener)object).updateBCStatisticsDistanceCurrentIntervalRE((BCAverageRecoveredEnergy)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 109: {
                ((DSICarKombiListener)object).updateBCStatisticsDistanceCurrentIntervalZE((BCZeroEmissionRelative)objectArray[0], (BCZeroEmissionAbsoluteDistance)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 110: {
                ((DSICarKombiListener)object).updateBCStatisticsTimeAC1((BCStatisticsAC)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 111: {
                ((DSICarKombiListener)object).updateBCStatisticsTimeAC2((BCStatisticsAC)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 112: {
                ((DSICarKombiListener)object).updateBCStatisticsTimeRE((BCStatisticsRE)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 113: {
                ((DSICarKombiListener)object).updateBCStatisticsTimeZE((BCStatisticsZE)objectArray[0], (BCZeroEmissionAbsoluteTime)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 114: {
                ((DSICarKombiListener)object).updateBCStatisticsTimeCurrentPeriodAC1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 115: {
                ((DSICarKombiListener)object).updateBCStatisticsTimeCurrentPeriodAC2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 116: {
                ((DSICarKombiListener)object).updateBCStatisticsTimeCurrentPeriodRE((BCAverageRecoveredEnergy)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 117: {
                ((DSICarKombiListener)object).updateBCStatisticsTimeCurrentPeriodZE((BCZeroEmissionRelative)objectArray[0], (BCZeroEmissionAbsoluteTime)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 118: {
                ((DSICarKombiListener)object).updateBCStatisticsConfig((BCStatisticsConfig)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 119: {
                ((DSICarKombiListener)object).updateBCStatisticDistanceEUkm((BCStatisticsDistanceEU)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 120: {
                ((DSICarKombiListener)object).updateBCStatisticDistanceEUmls((BCStatisticsDistanceEU)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 121: {
                ((DSICarKombiListener)object).updateBCOilTemperatureValue((CarBCTemperature)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 122: {
                ((DSICarKombiListener)object).updateBCCoolantTemperature((CarBCTemperature)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 123: {
                ((DSICarKombiListener)object).updateBCComfortPowerConsumption((BCComfortPowerConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 124: {
                ((DSICarKombiListener)object).updateBCTotalCurrentRange((CarBCDistance)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 125: {
                ((DSICarKombiListener)object).updateBCZeroEmissionDistanceST((CarBCDistance)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 126: {
                ((DSICarKombiListener)object).updateBCZeroEmissionDistanceLT((CarBCDistance)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 127: {
                ((DSICarKombiListener)object).updateBCZeroEmissionDistanceCY((CarBCDistance)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((DSICarKombiListener)object).updateBCZeroEmissionTimeST((CarBCTime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 129: {
                ((DSICarKombiListener)object).updateBCZeroEmissionTimeLT((CarBCTime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 130: {
                ((DSICarKombiListener)object).updateBCZeroEmissionTimeCY((CarBCTime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 131: {
                ((DSICarKombiListener)object).updateBCMaxValues((BCMaxValues)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 132: {
                ((DSICarKombiListener)object).updateBCResetTimeStampST((BCResetTimeStamp)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 133: {
                ((DSICarKombiListener)object).updateBCResetTimeStampLT((BCResetTimeStamp)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 134: {
                ((DSICarKombiListener)object).updateBCResetTimeStampCY((BCResetTimeStamp)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 135: {
                ((DSICarKombiListener)object).updateBCAstaMFA((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 136: {
                ((DSICarKombiListener)object).updateHUDViewOptions((HUDViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 137: {
                ((DSICarKombiListener)object).updateHUDHeightAdjustment((byte)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 138: {
                ((DSICarKombiListener)object).updateHUDBrightness((byte)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 139: {
                ((DSICarKombiListener)object).updateHUDColour(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 140: {
                ((DSICarKombiListener)object).updateHUDContent((HUDContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 141: {
                ((DSICarKombiListener)object).updateHUDInfo((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 142: {
                ((DSICarKombiListener)object).updateHUDSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 143: {
                ((DSICarKombiListener)object).updateHUDRotationAdjustment(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 144: {
                ((DSICarKombiListener)object).updateDCViewOptions((DCViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 145: {
                ((DSICarKombiListener)object).updateDCBrightness(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 146: {
                ((DSICarKombiListener)object).updateDCVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 147: {
                ((DSICarKombiListener)object).updateDCElementContentSelectionListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 148: {
                ((DSICarKombiListener)object).updateDCDisplay1Setup((DCMainItems)objectArray[0], (DCDisplayedAdditionalInfos)objectArray[1], (DCAdditionalInfo)objectArray[2], (DCAdditionalInfo)objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 149: {
                ((DSICarKombiListener)object).updateDCDisplay2Setup((DCMainItems)objectArray[0], (DCDisplayedAdditionalInfos)objectArray[1], (DCAdditionalInfo)objectArray[2], (DCAdditionalInfo)objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 150: {
                ((DSICarKombiListener)object).updateDCDisplay3Setup((DCMainItems)objectArray[0], (DCDisplayedAdditionalInfos)objectArray[1], (DCAdditionalInfo)objectArray[2], (DCAdditionalInfo)objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 151: {
                ((DSICarKombiListener)object).updateDCDisplay1MainSelection((DCMainItems)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 152: {
                ((DSICarKombiListener)object).updateDCDisplay2MainSelection((DCMainItems)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 153: {
                ((DSICarKombiListener)object).updateDCDisplay3MainSelection((DCMainItems)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 154: {
                ((DSICarKombiListener)object).responseDCElementContentSelectionListRAF((DCElementContentSelectionListUpdateInfo)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 155: {
                ((DSICarKombiListener)object).responseDCElementContentSelectionListRA1((DCElementContentSelectionListUpdateInfo)objectArray[0], (DCElementContentSelectionListRA1[])objectArray[1]);
                return null;
            }
            case 156: {
                ((DSICarKombiListener)object).responseDCElementContentSelectionListRA2((DCElementContentSelectionListUpdateInfo)objectArray[0], (DCElementContentSelectionListRA2[])objectArray[1]);
                return null;
            }
            case 157: {
                ((DSICarKombiListener)object).updateDCElementContentSelectionListUpdateInfo((DCElementContentSelectionListUpdateInfo)objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 158: {
                ((DSICarKombiListener)object).updateDCAdditionalInstrumentSetup((DCAdditionalInstrument)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 159: {
                ((DSICarKombiListener)object).updateDCAdditionalInstrument2Setup((DCAdditionalInstrument2)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((DSICarKombiListener)object).updateDCDisplayPresetsListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 161: {
                ((DSICarKombiListener)object).responseDCDisplayPresetsList((CarArrayListUpdateInfo)objectArray[0], (DCDisplayPresetsListRecord[])objectArray[1]);
                return null;
            }
            case 162: {
                ((DSICarKombiListener)object).updateDCDisplayPresetsListUpdateInfo((CarArrayListUpdateInfo)objectArray[0], (DCDisplayPresetsListRecord[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 163: {
                ((DSICarKombiListener)object).updateDCDisplayDependencySetup((DCDisplayDependency)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 164: {
                ((DSICarKombiListener)object).updateDCActiveDisplayPreset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 165: {
                ((DSICarKombiListener)object).updateDCDisplayViewConfiguration((DCDisplayViewConfiguration)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 166: {
                ((DSICarKombiListener)object).updateCompassInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 167: {
                ((DSICarKombiListener)object).updateHUDLicense((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 168: {
                ((DSICarKombiListener)object).updateDCLEDConfiguration((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 169: {
                ((DSICarKombiListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
                case 3: {
                    return this.f3(n, object, objectArray);
                }
                case 4: {
                    return this.f4(n, object, objectArray);
                }
                case 5: {
                    return this.f5(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

