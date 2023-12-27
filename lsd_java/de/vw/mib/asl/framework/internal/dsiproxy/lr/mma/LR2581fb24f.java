/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener;
import org.dsi.ifc.cardrivingcharacteristics.SoundViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerState;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlActuatorInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlHeightInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControleABCPreview;
import org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.careco.BCmEEnergyFlowComfort;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmERangeGainTotal;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.DSICarEcoListener;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.careco.RangeDataResidualEnergy;
import org.dsi.ifc.careco.RangeDataViewOptions;
import org.dsi.ifc.careco.StartStopListUpdateInfo;
import org.dsi.ifc.careco.StartStopProhibitList;
import org.dsi.ifc.careco.StartStopRestartList;
import org.dsi.ifc.careco.StartStopRestartProhibitList;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;

public final class LR2581fb24f
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2116673749: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1939951582: {
                if (bl) {
                    if (n2 != -194482013) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1897108742: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1892410642: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1885207262: {
                if (bl) {
                    if (n2 != -1568627599) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -1548921972: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1548921971: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1541628791: {
                if (bl) {
                    if (n2 != -2013242426) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1541628790: {
                if (bl) {
                    if (n2 != 50682822) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1541628769: {
                if (bl) {
                    if (n2 != -397522097) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -1419586333: {
                if (bl) {
                    if (n2 != -282023319) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1390856928: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1381219338: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1237006703: {
                if (bl) {
                    if (n2 != 765625423) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1166819686: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1102769717: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -1069595270: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1069595269: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -850360165: {
                if (bl) {
                    if (n2 != 475418797) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -794880872: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -794880871: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -751367623: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -751367622: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -677624343: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -655682143: {
                if (bl) {
                    if (n2 != -1568627599) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -500451801: {
                if (bl) {
                    if (n2 != -1298847283) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -500451800: {
                if (bl) {
                    if (n2 != 765077965) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -500451799: {
                if (bl) {
                    if (n2 != -1466029619) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -500451779: {
                if (bl) {
                    if (n2 != -397522097) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -452872005: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -448277415: {
                if (bl) {
                    if (n2 != 2070788862) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -366142709: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -306407434: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -133828770: {
                if (bl) {
                    if (n2 != -1114586992) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -133828769: {
                if (bl) {
                    if (n2 != -1114586992) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 115849947: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 115849948: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 270443373: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 587730505: {
                if (bl) {
                    if (n2 != 115110034) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 666189342: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 850060329: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 970925666: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1000521460: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1068889362: {
                if (bl) {
                    if (n2 != 1217466906) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1068889363: {
                if (bl) {
                    if (n2 != 1217466906) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1107587961: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1196664208: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1196664209: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1217378568: {
                if (bl) {
                    if (n2 != -1568627599) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1319546156: {
                if (bl) {
                    if (n2 != 765625423) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1349295276: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1349295277: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1369766195: {
                if (bl) {
                    if (n2 != 765625423) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1453400707: {
                if (bl) {
                    if (n2 != -423051988) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1455706867: {
                if (bl) {
                    if (n2 != -1855654628) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1505770271: {
                if (bl) {
                    if (n2 != 540057178) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 1795624691: {
                if (bl) {
                    if (n2 != 1951127501) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1940281462: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1991686028: {
                if (bl) {
                    if (n2 != -913457456) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 2037966932: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 2125202921: {
                if (bl) {
                    if (n2 != -1506414482) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1862997647: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1821129351: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case -1816917197: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -1811851827: {
                if (bl) {
                    if (n2 != 1920772571) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case -1809616697: {
                if (bl) {
                    if (n2 != 1118062494) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -1805178339: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -1641124001: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case -1637210624: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case -1514098635: {
                if (bl) {
                    if (n2 != 1514320187) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -1484777005: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case -1440900160: {
                if (bl) {
                    if (n2 != -449776951) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case -1191371392: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -1139449948: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -1134612159: {
                if (bl) {
                    if (n2 != -628787065) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -1019482825: {
                if (bl) {
                    if (n2 != -603497900) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -968794693: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -966076589: {
                if (bl) {
                    if (n2 != 1827478610) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -962019141: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -681789097: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -580916075: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case -570600338: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -556001028: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -272337843: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case -262648705: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -164609553: {
                if (bl) {
                    if (n2 != 1157836657) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case -95323372: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -22114159: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 7466493: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 10412924: {
                if (bl) {
                    if (n2 != -149503222) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 23051226: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 29097345: {
                if (bl) {
                    if (n2 != -1500344287) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 38094319: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 186739870: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case 253941023: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case 287271575: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 321135000: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 367287455: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 466341492: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 472263578: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 502387304: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case 555636870: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 594593520: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case 634913758: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case 885673224: {
                if (bl) {
                    if (n2 != -1380947501) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 932965639: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case 994013577: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 1012746407: {
                if (bl) {
                    if (n2 != -866704464) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 1038326016: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 1092398721: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 1146722411: {
                if (bl) {
                    if (n2 != 1298276815) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 1235459238: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 1262175729: {
                if (bl) {
                    if (n2 != -1965790868) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 1389193430: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1481508092: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1517890842: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case 1667933694: {
                if (bl) {
                    if (n2 != 590896121) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 1716107697: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 1717532177: {
                if (bl) {
                    if (n2 != 922517002) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 1837647594: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 1904739249: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 2056527172: {
                if (bl) {
                    if (n2 != 250065082) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
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
            case -1688006475: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1539542237: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarEcoListener)object).updateBCmEViewOptions((BCmEViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSICarEcoListener)object).updateBCmEListUpdateInfo((BCmEListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSICarEcoListener)object).updateBCmEConsumption(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 3: {
                ((DSICarEcoListener)object).updateBCmELiveTip(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSICarEcoListener)object).responseBCmEConsumerList((BCmEListUpdateInfo)objectArray[0], (BCmEConsumerList[])objectArray[1]);
                return null;
            }
            case 5: {
                ((DSICarEcoListener)object).acknowledgeBcmeSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSICarEcoListener)object).updateStartStopProhibitReasonListUpdateInfo((StartStopListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSICarEcoListener)object).responseStartStopProhibitReasonList((StartStopListUpdateInfo)objectArray[0], (StartStopProhibitList[])objectArray[1]);
                return null;
            }
            case 8: {
                ((DSICarEcoListener)object).updateStartStopRestartReasonListUpdateInfo((StartStopListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSICarEcoListener)object).responseStartStopRestartReasonList((StartStopListUpdateInfo)objectArray[0], (StartStopRestartList[])objectArray[1]);
                return null;
            }
            case 10: {
                ((DSICarEcoListener)object).updateStartStopRestartProhibitReasonListUpdateInfo((StartStopListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSICarEcoListener)object).responseStartStopRestartProhibitReasonList((StartStopListUpdateInfo)objectArray[0], (StartStopRestartProhibitList[])objectArray[1]);
                return null;
            }
            case 12: {
                ((DSICarEcoListener)object).updateStartStopState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSICarEcoListener)object).updateStartStopProhibitReasonListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSICarEcoListener)object).updateStartStopRestartReasonListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSICarEcoListener)object).updateStartStopRestartProhibitReasonListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSICarEcoListener)object).updateStartStopViewOptions((StartStopViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSICarEcoListener)object).updateStartStopCollectedReasons(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSICarEcoListener)object).updateRDViewOptions((RangeDataViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSICarEcoListener)object).updateRDConsumptionMotorway1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSICarEcoListener)object).updateRDConsumptionMotorway2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSICarEcoListener)object).updateRDConsumptionHighway1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSICarEcoListener)object).updateRDConsumptionHighway2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSICarEcoListener)object).updateRDConsumptionCountryRoad1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSICarEcoListener)object).updateRDConsumptionCountryRoad2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSICarEcoListener)object).updateRDConsumptionDistrictRoad1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSICarEcoListener)object).updateRDConsumptionDistrictRoad2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSICarEcoListener)object).updateRDConsumptionLocalRoad1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSICarEcoListener)object).updateRDConsumptionLocalRoad2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSICarEcoListener)object).updateRDConsumptionRuralRoad1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSICarEcoListener)object).updateRDConsumptionRuralRoad2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSICarEcoListener)object).updateRDConsumptionUnclassifiedRoad1((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarEcoListener)object).updateRDConsumptionUnclassifiedRoad2((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSICarEcoListener)object).updateRDMaxRange1((CarBCCurrentRange)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSICarEcoListener)object).updateRDMaxRange2((CarBCCurrentRange)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSICarEcoListener)object).updateRDResidualEnergy1((RangeDataResidualEnergy)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSICarEcoListener)object).updateRDResidualEnergy2((RangeDataResidualEnergy)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSICarEcoListener)object).acknowledgeRDSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 38: {
                ((DSICarEcoListener)object).updateBCmEConsumerListConsumptionUpdateInfo((BCmEListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSICarEcoListener)object).updateBCmEConsumerListRangeUpdateInfo((BCmEListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSICarEcoListener)object).updateBCmEEnergyFlowComfort((BCmEEnergyFlowComfort)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSICarEcoListener)object).updateBCmERangeGainTotal((BCmERangeGainTotal)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSICarEcoListener)object).responseBCmEConsumerListConsumptionRA0((BCmEListUpdateInfo)objectArray[0], (BCmEConsumerListConsumptionRA0[])objectArray[1]);
                return null;
            }
            case 43: {
                ((DSICarEcoListener)object).responseBCmEConsumerListConsumptionRA1((BCmEListUpdateInfo)objectArray[0], (BCmEConsumerListConsumptionRA1[])objectArray[1]);
                return null;
            }
            case 44: {
                ((DSICarEcoListener)object).responseBCmEConsumerListConsumptionRAF((BCmEListUpdateInfo)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 45: {
                ((DSICarEcoListener)object).responseBCmEConsumerListRangeRA0((BCmEListUpdateInfo)objectArray[0], (BCmEConsumerListRangeRA0[])objectArray[1]);
                return null;
            }
            case 46: {
                ((DSICarEcoListener)object).responseBCmEConsumerListRangeRA1((BCmEListUpdateInfo)objectArray[0], (BCmEConsumerListRangeRA1[])objectArray[1]);
                return null;
            }
            case 47: {
                ((DSICarEcoListener)object).responseBCmEConsumerListRangeRA2((BCmEListUpdateInfo)objectArray[0], (BCmEConsumerListRangeRA2[])objectArray[1]);
                return null;
            }
            case 48: {
                ((DSICarEcoListener)object).responseBCmEConsumerListRangeRAF((BCmEListUpdateInfo)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 49: {
                ((DSICarEcoListener)object).updateBCmECurrentRange((BCmECurrentRange)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((DSICarEcoListener)object).updateBCmEConsumerListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((DSICarEcoListener)object).updateBCmEConsumerListConsumptionTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSICarEcoListener)object).updateBCmEConsumerListRangeTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((DSICarEcoListener)object).updateBCmECurrentRangeSOC(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 54: {
                ((DSICarEcoListener)object).updateBCmECatalogueRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 55: {
                ((DSICarEcoListener)object).updateEAViewOptions((EAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSICarEcoListener)object).updateEASystem((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSICarEcoListener)object).updateEAPedalJerk((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSICarEcoListener)object).acknowledgeEASetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 59: {
                ((DSICarEcoListener)object).updateEAFreeWheeling((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 60: {
                ((DSICarEcoListener)object).updateEAStartStop((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((DSICarEcoListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 62: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlViewOptions((SuspensionControlViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlLiftMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlCarJackMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlTrailerMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 66: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlLoadingMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlActiveProfile(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlAccessibleAirProfiles((SuspensionControlAirProfiles)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlAccessibleDRCProfiles((SuspensionControlDRCProfiles)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 70: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlVehicleStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 71: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlCurrentLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlTargetLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 73: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlHeightInfo((SuspensionControlHeightInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 74: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlOperationMessages((SuspensionControlOperationMessages)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlSnowChainMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 76: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlVehicleStateControl((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 77: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlActiveMode(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 78: {
                ((DSICarDrivingCharacteristicsListener)object).updateeABCEasyEntry((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 79: {
                ((DSICarDrivingCharacteristicsListener)object).updateeABCPitchControl((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 80: {
                ((DSICarDrivingCharacteristicsListener)object).updateeABCSpecialPosition((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 81: {
                ((DSICarDrivingCharacteristicsListener)object).updateeABCPreview(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 82: {
                ((DSICarDrivingCharacteristicsListener)object).updateeABCPreviewState((SuspensionControleABCPreview)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 83: {
                ((DSICarDrivingCharacteristicsListener)object).updateSuspensionControlActuatorInfo((SuspensionControlActuatorInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 84: {
                ((DSICarDrivingCharacteristicsListener)object).updateCharismaViewOptions((CharismaViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 85: {
                ((DSICarDrivingCharacteristicsListener)object).updateCharismaActiveProfile(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 86: {
                ((DSICarDrivingCharacteristicsListener)object).updateCharismaActiveOperationMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 87: {
                ((DSICarDrivingCharacteristicsListener)object).updateCharismaListUpdateInfo((CharismaListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 88: {
                ((DSICarDrivingCharacteristicsListener)object).updateCharismaContent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((DSICarDrivingCharacteristicsListener)object).updateCharismaTrailerDetection((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 90: {
                ((DSICarDrivingCharacteristicsListener)object).updateCharismaTrailerSetting((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 91: {
                ((DSICarDrivingCharacteristicsListener)object).updateCharismaProgButton((CharismaProgButton)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 92: {
                ((DSICarDrivingCharacteristicsListener)object).responseCharismaListWithOptionMask(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CharismaSetupTableWithOptionMask[])objectArray[3]);
                return null;
            }
            case 93: {
                ((DSICarDrivingCharacteristicsListener)object).responseCharismaListWithoutOptionMask(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CharismaSetupTableWithoutOptionMask[])objectArray[3]);
                return null;
            }
            case 94: {
                ((DSICarDrivingCharacteristicsListener)object).requestCharismaPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 95: {
                ((DSICarDrivingCharacteristicsListener)object).acknowledgeCharismaPopup(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSICarDrivingCharacteristicsListener)object).acknowledgeCharismaSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 97: {
                ((DSICarDrivingCharacteristicsListener)object).updateCharismaSound((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 98: {
                ((DSICarDrivingCharacteristicsListener)object).updateTADViewOptions((TADViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 99: {
                ((DSICarDrivingCharacteristicsListener)object).updateTADContent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 100: {
                ((DSICarDrivingCharacteristicsListener)object).requestTADPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 101: {
                ((DSICarDrivingCharacteristicsListener)object).acknowledgeTADPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 102: {
                ((DSICarDrivingCharacteristicsListener)object).acknowledgeTADSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 103: {
                ((DSICarDrivingCharacteristicsListener)object).acknowledgeTADMaxMinAngleReset((Boolean)objectArray[0]);
                return null;
            }
            case 104: {
                ((DSICarDrivingCharacteristicsListener)object).updateTADVehicleInfo((TADVehicleInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 105: {
                ((DSICarDrivingCharacteristicsListener)object).updateTADCurrentRollAngle(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 106: {
                ((DSICarDrivingCharacteristicsListener)object).updateTADCurrentPitchAngle(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 107: {
                ((DSICarDrivingCharacteristicsListener)object).updateTADPosMaxRollAngle(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 108: {
                ((DSICarDrivingCharacteristicsListener)object).updateTADNegMaxRollAngle(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 109: {
                ((DSICarDrivingCharacteristicsListener)object).updateTADPosMaxPitchAngle(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 110: {
                ((DSICarDrivingCharacteristicsListener)object).updateTADNegMaxPitchAngle(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 111: {
                ((DSICarDrivingCharacteristicsListener)object).updateSpoilerViewOptions((SpoilerViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 112: {
                ((DSICarDrivingCharacteristicsListener)object).updateSpoilerPositionSelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 113: {
                ((DSICarDrivingCharacteristicsListener)object).updateSpoilerState((SpoilerState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 114: {
                ((DSICarDrivingCharacteristicsListener)object).updateSpoilerActuation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 115: {
                ((DSICarDrivingCharacteristicsListener)object).updateSpoilerMessages(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 116: {
                ((DSICarDrivingCharacteristicsListener)object).updateSpoilerSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 117: {
                ((DSICarDrivingCharacteristicsListener)object).acknowledgeSpoilerSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 118: {
                ((DSICarDrivingCharacteristicsListener)object).updateSoundViewOptions((SoundViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 119: {
                ((DSICarDrivingCharacteristicsListener)object).updateSoundStyle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 120: {
                ((DSICarDrivingCharacteristicsListener)object).updateSoundSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 121: {
                ((DSICarDrivingCharacteristicsListener)object).updateSoundOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 122: {
                ((DSICarDrivingCharacteristicsListener)object).acknowledgeSoundSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 123: {
                ((DSICarDrivingCharacteristicsListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

