/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
import org.dsi.ifc.carcomfort.DoorLockingBootBlindState;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingLockStatus;
import org.dsi.ifc.carcomfort.DoorLockingMessage;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingWindowStatus;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.carcomfort.RDKResidualBatteryLifetime;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardDetection;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.carcomfort.UGDOVersionData;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.carcomfort.WiperViewOptions;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener;
import org.dsi.ifc.cardriverassistance.FTASensorData;
import org.dsi.ifc.cardriverassistance.FTAViewOptions;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.NVViewOptions;
import org.dsi.ifc.cardriverassistance.PAViewOptions;
import org.dsi.ifc.cardriverassistance.SWARCTASensorData;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.cardriverassistance.TSDSignFct;
import org.dsi.ifc.cardriverassistance.TSDSystemMessages;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCSpeed;

public final class LR28448d4c5
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2037751802: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -2031326164: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -2021380397: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -1985566554: {
                if (bl) {
                    if (n2 != 1308659255) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -1938466453: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -1926008217: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1914814286: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -1875829201: {
                if (bl) {
                    if (n2 != 1599592267) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -1746672098: {
                if (bl) {
                    if (n2 != -969028795) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1713555101: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1691183548: {
                if (bl) {
                    if (n2 != -1173404765) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1640227523: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -1505008155: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1446694490: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1255956039: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1229664777: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1173594250: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1159524843: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1141109610: {
                if (bl) {
                    if (n2 != -1931910444) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1112505390: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -1005663423: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case -998016840: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -925121045: {
                if (bl) {
                    if (n2 != -1826765962) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -897213390: {
                if (bl) {
                    if (n2 != 734093362) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -819027212: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -767990061: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -706937136: {
                if (bl) {
                    if (n2 != -959757330) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -690477703: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -674646038: {
                if (bl) {
                    if (n2 != -1844465275) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -616064404: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -510169366: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -447232595: {
                if (bl) {
                    if (n2 != 1762879402) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -447232594: {
                if (bl) {
                    if (n2 != 1762879402) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -447232593: {
                if (bl) {
                    if (n2 != 1762879402) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -447232592: {
                if (bl) {
                    if (n2 != 1762879402) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -447232591: {
                if (bl) {
                    if (n2 != 1762879402) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -430357848: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -341298372: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -324984700: {
                if (bl) {
                    if (n2 != 2062354181) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case -319227935: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -299040848: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -261630793: {
                if (bl) {
                    if (n2 != -1381904888) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -247528401: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -134063508: {
                if (bl) {
                    if (n2 != 347269541) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -112610893: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -91830863: {
                if (bl) {
                    if (n2 != 734093362) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -64228427: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -40763418: {
                if (bl) {
                    if (n2 != -1906869845) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -7219063: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 35956696: {
                if (bl) {
                    if (n2 != 1996663052) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 41033159: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 72824276: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 163390140: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 190647522: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 192995907: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 221699921: {
                if (bl) {
                    if (n2 != 2141253554) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 463945124: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 489181435: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 657840541: {
                if (bl) {
                    if (n2 != -982651138) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 658989224: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 714986202: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 798010789: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 812478746: {
                if (bl) {
                    if (n2 != 272553032) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 812996542: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 813192277: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 814769869: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 846553242: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 857031352: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 909880419: {
                if (bl) {
                    if (n2 != -1958677491) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 934513173: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 963904393: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 978817760: {
                if (bl) {
                    if (n2 != 734093362) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 1026432074: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1219597386: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1264945453: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1317605693: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1362585285: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 1364185020: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 1443849510: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1494767975: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 1526361949: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1545063656: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 1576700602: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 1590503786: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1655264724: {
                if (bl) {
                    if (n2 != -51814086) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 1867780306: {
                if (bl) {
                    if (n2 != -924992889) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 1951997009: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 2107128981: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 2126054776: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2102402138: {
                if (bl) {
                    if (n2 != -560061485) break;
                    n3 = 179;
                    break;
                }
                n3 = 179;
                break;
            }
            case -2009771750: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case -2002235513: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case -1922256239: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case -1887367250: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
            case -1818868417: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case -1785758424: {
                if (bl) {
                    if (n2 != 550979423) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case -1780544499: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -1776773909: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 189;
                    break;
                }
                n3 = 189;
                break;
            }
            case -1750488097: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case -1750460256: {
                if (bl) {
                    if (n2 != 1602759608) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 196;
                    break;
                }
                n3 = 196;
                break;
            }
            case -1569543627: {
                if (bl) {
                    if (n2 != -1387397474) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1561149311: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case -1552188402: {
                if (bl) {
                    if (n2 != 1952561447) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -1539383283: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case -1529023704: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -1514124897: {
                if (bl) {
                    if (n2 != 1334887783) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case -1352406736: {
                if (bl) {
                    if (n2 != -1351144006) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case -1332483162: {
                if (bl) {
                    if (n2 != -862634745) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -1331013358: {
                if (bl) {
                    if (n2 != -1970955323) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -1244056233: {
                if (bl) {
                    if (n2 != -815674678) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -1165619023: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -1157941423: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case -1116309611: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -1016386584: {
                if (bl) {
                    if (n2 != 1625381423) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case -1014644978: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case -920936181: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case -798885616: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case -749616723: {
                if (bl) {
                    if (n2 != 1536069676) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case -697492602: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case -690918488: {
                if (bl) {
                    if (n2 != -1142651250) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case -690918487: {
                if (bl) {
                    if (n2 != 921273998) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case -690918486: {
                if (bl) {
                    if (n2 != -1309833586) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case -690918485: {
                if (bl) {
                    if (n2 != 754091662) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case -690918484: {
                if (bl) {
                    if (n2 != -1477015922) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case -690918483: {
                if (bl) {
                    if (n2 != 586909326) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case -690918466: {
                if (bl) {
                    if (n2 != 65940093) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case -648069292: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case -637400762: {
                if (bl) {
                    if (n2 != 1040330213) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case -637400741: {
                if (bl) {
                    if (n2 != -937416057) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -618273579: {
                if (bl) {
                    if (n2 != 562629727) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case -587581017: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case -561929876: {
                if (bl) {
                    if (n2 != 309827049) break;
                    n3 = 186;
                    break;
                }
                n3 = 186;
                break;
            }
            case -490793538: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case -436287915: {
                if (bl) {
                    if (n2 != 225731463) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case -408333473: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 184;
                    break;
                }
                n3 = 184;
                break;
            }
            case -406412898: {
                if (bl) {
                    if (n2 != 70637142) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case -369946273: {
                if (bl) {
                    if (n2 != -984779170) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case -305971630: {
                if (bl) {
                    if (n2 != 179657573) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case -295989437: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 187;
                    break;
                }
                n3 = 187;
                break;
            }
            case -264493865: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -253960167: {
                if (bl) {
                    if (n2 != 2138303583) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -227545625: {
                if (bl) {
                    if (n2 != -268456735) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case -163199725: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 185;
                    break;
                }
                n3 = 185;
                break;
            }
            case -153327094: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 195;
                    break;
                }
                n3 = 195;
                break;
            }
            case -81591646: {
                if (bl) {
                    if (n2 != 1212245117) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case -60911167: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 47035240: {
                if (bl) {
                    if (n2 != 562629727) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case 88451429: {
                if (bl) {
                    if (n2 != -427094493) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 114828053: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case 138368935: {
                if (bl) {
                    if (n2 != -1616921863) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case 141745778: {
                if (bl) {
                    if (n2 != -427094493) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 147177988: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 230287260: {
                if (bl) {
                    if (n2 != -2106602812) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 260827086: {
                if (bl) {
                    if (n2 != 874778500) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 303854961: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case 351369714: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case 370242437: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 188;
                    break;
                }
                n3 = 188;
                break;
            }
            case 449538255: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 456299869: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 190;
                    break;
                }
                n3 = 190;
                break;
            }
            case 462009418: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 183;
                    break;
                }
                n3 = 183;
                break;
            }
            case 530569579: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case 538250387: {
                if (bl) {
                    if (n2 != -1177717626) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case 586158038: {
                if (bl) {
                    if (n2 != -1128237253) break;
                    n3 = 192;
                    break;
                }
                n3 = 192;
                break;
            }
            case 599664966: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 193;
                    break;
                }
                n3 = 193;
                break;
            }
            case 672922889: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case 741785701: {
                if (bl) {
                    if (n2 != 1890980438) break;
                    n3 = 191;
                    break;
                }
                n3 = 191;
                break;
            }
            case 829203528: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case 846099782: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case 861639747: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case 931262545: {
                if (bl) {
                    if (n2 != -911904349) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case 956440651: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 963535677: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 963959811: {
                if (bl) {
                    if (n2 != -1351144006) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case 967912475: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 968002874: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 1023856049: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case 1068771212: {
                if (bl) {
                    if (n2 != 855492426) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case 1106547222: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 1129926791: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
                break;
            }
            case 1411989622: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case 1439359309: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case 1485962909: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
            case 1544998308: {
                if (bl) {
                    if (n2 != 2092001536) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case 1584962995: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 194;
                    break;
                }
                n3 = 194;
                break;
            }
            case 1596408716: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case 1652778188: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case 1663556027: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 1787209827: {
                if (bl) {
                    if (n2 != 159292021) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case 1796821287: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case 1867523150: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case 1950186476: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 1970396554: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case 2027406649: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case 2079367867: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case 2084132837: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
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
            case -1015061141: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1121922755: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarDriverAssistanceListener)object).updateACCViewOptions((ACCViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSICarDriverAssistanceListener)object).updateACCGongState((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSICarDriverAssistanceListener)object).updateACCGongVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSICarDriverAssistanceListener)object).updateACCDrivingProgram(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSICarDriverAssistanceListener)object).updateACCTimeGap(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSICarDriverAssistanceListener)object).updateACCDefaultMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSICarDriverAssistanceListener)object).updateACCCurveAssist((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSICarDriverAssistanceListener)object).updateACCSpeedLimitAdoption((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSICarDriverAssistanceListener)object).updateACCTrafficJamAssist((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSICarDriverAssistanceListener)object).updateACCSpeedLimitOffset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSICarDriverAssistanceListener)object).updateACCDistanceWarning((ACCDistanceWarning)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSICarDriverAssistanceListener)object).updatePACCSensibility((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSICarDriverAssistanceListener)object).updatePACCMaxSpeed((CarBCSpeed)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSICarDriverAssistanceListener)object).updatePACCMeanVelocity((CarBCSpeed)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSICarDriverAssistanceListener)object).updatePACCMeanConsumption((CarBCConsumption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSICarDriverAssistanceListener)object).updatePACCCoastingPercentage(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSICarDriverAssistanceListener)object).updatePACCDrivingProgram(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSICarDriverAssistanceListener)object).updatePACCSystemState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSICarDriverAssistanceListener)object).acknowledgeACCSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSICarDriverAssistanceListener)object).updateAWVDistanceWarning((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSICarDriverAssistanceListener)object).updateAWVViewOptions((AWVViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSICarDriverAssistanceListener)object).updateAWVSystem(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSICarDriverAssistanceListener)object).updateAWVWarning((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSICarDriverAssistanceListener)object).updateAWVGong((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSICarDriverAssistanceListener)object).updateAWVGongVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSICarDriverAssistanceListener)object).updateAWVBrakeJerk((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSICarDriverAssistanceListener)object).updateAWVEmergencyBrake((AWVEmergencyBrake)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSICarDriverAssistanceListener)object).updateAWVWarningTimegap(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSICarDriverAssistanceListener)object).acknowledgeAWVSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 29: {
                ((DSICarDriverAssistanceListener)object).updateSWAViewOptions((SWAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSICarDriverAssistanceListener)object).updateSWABrightness(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSICarDriverAssistanceListener)object).updateSWAWarningTime(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarDriverAssistanceListener)object).updateSWAFrequency(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSICarDriverAssistanceListener)object).updateSWASystem(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSICarDriverAssistanceListener)object).updateSWAGongState((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSICarDriverAssistanceListener)object).updateSWAGongVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSICarDriverAssistanceListener)object).updateSWARCTASensorData((SWARCTASensorData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSICarDriverAssistanceListener)object).updateSWARCTA((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSICarDriverAssistanceListener)object).updateSWAExitAssist((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSICarDriverAssistanceListener)object).updateNVViewOptions((NVViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSICarDriverAssistanceListener)object).updateNVActivation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSICarDriverAssistanceListener)object).updateNVContrast(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSICarDriverAssistanceListener)object).updateNVBrightness(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((DSICarDriverAssistanceListener)object).updateNVObjectDetection((NVObjectDetection)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 44: {
                ((DSICarDriverAssistanceListener)object).updateNVColorPA(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSICarDriverAssistanceListener)object).updateNVDesignPA(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSICarDriverAssistanceListener)object).updateNVDisplay(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 47: {
                ((DSICarDriverAssistanceListener)object).updateNVZoomPanning(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 48: {
                ((DSICarDriverAssistanceListener)object).updateNVSound(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSICarDriverAssistanceListener)object).updateNVSymbol((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((DSICarDriverAssistanceListener)object).acknowledgeNVSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 51: {
                ((DSICarDriverAssistanceListener)object).updateNVSystem((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSICarDriverAssistanceListener)object).updateNVWarningTimegap(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((DSICarDriverAssistanceListener)object).updateLDWHCAViewOptions((LDWHCAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSICarDriverAssistanceListener)object).updateLDWWarningTime(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSICarDriverAssistanceListener)object).updateLDWSteeringWheelVibration(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSICarDriverAssistanceListener)object).updateHCAInterventionStyle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSICarDriverAssistanceListener)object).updateHCAToleranceLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSICarDriverAssistanceListener)object).acknowledgeLdwhcaSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 59: {
                ((DSICarDriverAssistanceListener)object).updateLDWHCASystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 60: {
                ((DSICarDriverAssistanceListener)object).updateLDWHCAWarningSound((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 61: {
                ((DSICarDriverAssistanceListener)object).updateTSDViewOptions((TSDViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((DSICarDriverAssistanceListener)object).updateTSDSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSICarDriverAssistanceListener)object).updateTSDTrailerDetection((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarDriverAssistanceListener)object).updateTSDSign1((TSDSignFct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((DSICarDriverAssistanceListener)object).updateTSDSign2((TSDSignFct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 66: {
                ((DSICarDriverAssistanceListener)object).updateTSDSign3((TSDSignFct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((DSICarDriverAssistanceListener)object).updateTSDSign4((TSDSignFct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((DSICarDriverAssistanceListener)object).updateTSDSign5((TSDSignFct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((DSICarDriverAssistanceListener)object).updateTSDRoadSignFilter((TSDRoadSignFilter)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 70: {
                ((DSICarDriverAssistanceListener)object).acknowledgeTsdSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 71: {
                ((DSICarDriverAssistanceListener)object).updateTSDSpeedWarningThreshold((Boolean)objectArray[0], (CarBCSpeed)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 72: {
                ((DSICarDriverAssistanceListener)object).updateTSDTrailerSpeedLimit((CarBCSpeed)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 73: {
                ((DSICarDriverAssistanceListener)object).updateTSDSystemMessages((TSDSystemMessages)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 74: {
                ((DSICarDriverAssistanceListener)object).updateTSDSpeedWarningAcoustics((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((DSICarDriverAssistanceListener)object).updateMKEViewOptions((MKEViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 76: {
                ((DSICarDriverAssistanceListener)object).updateMKESystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 77: {
                ((DSICarDriverAssistanceListener)object).acknowledgeMKESetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 78: {
                ((DSICarDriverAssistanceListener)object).updatePAViewOptions((PAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 79: {
                ((DSICarDriverAssistanceListener)object).updatePASystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 80: {
                ((DSICarDriverAssistanceListener)object).acknowledgePASetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 81: {
                ((DSICarDriverAssistanceListener)object).updatePAConfigInformation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 82: {
                ((DSICarDriverAssistanceListener)object).updatePAConfigWarning((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 83: {
                ((DSICarDriverAssistanceListener)object).updatePAWarningTimegap(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 84: {
                ((DSICarDriverAssistanceListener)object).updateCurveAssistSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 85: {
                ((DSICarDriverAssistanceListener)object).acknowledgeCurveAssistSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 86: {
                ((DSICarDriverAssistanceListener)object).updateFTAViewOptions((FTAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 87: {
                ((DSICarDriverAssistanceListener)object).updateFTASystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 88: {
                ((DSICarDriverAssistanceListener)object).updateFTASensorData((FTASensorData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((DSICarDriverAssistanceListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 90: {
                ((DSICarComfortListener)object).updateRGSViewOptions((RGSViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 91: {
                ((DSICarComfortListener)object).updateRGSBeltPretensionDataFront((RGSBeltPretensionData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 92: {
                ((DSICarComfortListener)object).updateRGSBeltPretensionDataRear((RGSBeltPretensionData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 93: {
                ((DSICarComfortListener)object).updateRGSPreCrashSystem((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 94: {
                ((DSICarComfortListener)object).acknowledgeRgsSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 95: {
                ((DSICarComfortListener)object).updateRGSPreSenseSystem((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSICarComfortListener)object).updateRGSPreSenseWarning(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 97: {
                ((DSICarComfortListener)object).updateRGSLocalHazardDetection((RGSLocalHazardDetection)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 98: {
                ((DSICarComfortListener)object).updateDoorLockingViewOptions((DoorLockingViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 99: {
                ((DSICarComfortListener)object).updateDoorLockingMessage((DoorLockingMessage)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 100: {
                ((DSICarComfortListener)object).updateDoorLockingLockStatus((DoorLockingLockStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 101: {
                ((DSICarComfortListener)object).updateDoorLockingWindowStatus((DoorLockingWindowStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 102: {
                ((DSICarComfortListener)object).updateDoorLockingComfortOpenSettings((DoorLockingComfortOpenSettings)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 103: {
                ((DSICarComfortListener)object).updateDoorLockingTheftWarningSettings((DoorLockingTheftWarningSettings)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 104: {
                ((DSICarComfortListener)object).updateDoorLockingClBootOpen((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 105: {
                ((DSICarComfortListener)object).updateDoorLockingBootOpen((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 106: {
                ((DSICarComfortListener)object).updateDoorLockingBootClose((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 107: {
                ((DSICarComfortListener)object).updateDoorLockingUnlockingMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 108: {
                ((DSICarComfortListener)object).updateDoorLockingAutoLock(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 109: {
                ((DSICarComfortListener)object).updateDoorLockingAutoUnlock((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 110: {
                ((DSICarComfortListener)object).updateDoorLockingClBootLock((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 111: {
                ((DSICarComfortListener)object).updateDoorLockingMirrorProtection((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 112: {
                ((DSICarComfortListener)object).updateDoorLockingConfirmation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 113: {
                ((DSICarComfortListener)object).updateDoorLockingRainClosing((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 114: {
                ((DSICarComfortListener)object).updateDoorLockingRearBlind((DoorLockingRearBlind)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 115: {
                ((DSICarComfortListener)object).acknowledgeDoorLockingSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 116: {
                ((DSICarComfortListener)object).acknowledgeDoorLockingRemoteLockUnlock((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 117: {
                ((DSICarComfortListener)object).acknowledgeDoorLockingRemoteBlinking((Boolean)objectArray[0]);
                return null;
            }
            case 118: {
                ((DSICarComfortListener)object).acknowledgeDoorLockingRemoteHorn((Boolean)objectArray[0]);
                return null;
            }
            case 119: {
                ((DSICarComfortListener)object).receivedDoorLockingRemoteLockUnlockSignatureVerification((String)objectArray[0]);
                return null;
            }
            case 120: {
                ((DSICarComfortListener)object).receivedDoorLockingRemoteLockUnlockAuthentification((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 121: {
                ((DSICarComfortListener)object).responseDoorLockingUserListRA1((DoorLockingUserListUpdateInfo)objectArray[0], (DoorLockingUserListRA1[])objectArray[1]);
                return null;
            }
            case 122: {
                ((DSICarComfortListener)object).responseDoorLockingUserListRAF((DoorLockingUserListUpdateInfo)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 123: {
                ((DSICarComfortListener)object).updateDoorLockingUserListUpdateInfo((DoorLockingUserListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 124: {
                ((DSICarComfortListener)object).updateDoorLockingUserListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 125: {
                ((DSICarComfortListener)object).updateDoorLockingActiveUser(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 126: {
                ((DSICarComfortListener)object).updateDoorLockingUserProfileOnOff((DoorLockingUserProfileOnOff)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 127: {
                ((DSICarComfortListener)object).acknowledgeDoorLockingUserProfileControl(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((DSICarComfortListener)object).updateDoorLockingUserProfileControlProcessing((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 129: {
                ((DSICarComfortListener)object).updateDoorLockingWindowAutoClose((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 130: {
                ((DSICarComfortListener)object).updateDoorLockingBlindsControl(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 131: {
                ((DSICarComfortListener)object).updateDoorLockingBlindsControlExtended((DoorLockingBootBlindState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 132: {
                ((DSICarComfortListener)object).updateDoorLockingLeftSideBlindControl(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 133: {
                ((DSICarComfortListener)object).updateDoorLockingRightSideBlindControl(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 134: {
                ((DSICarComfortListener)object).updateDoorLockingTurnIndRepeat((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 135: {
                ((DSICarComfortListener)object).updateDoorLockingKeyless((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 136: {
                ((DSICarComfortListener)object).updateWiperViewOptions((WiperViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 137: {
                ((DSICarComfortListener)object).updateWiperServicePosition((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 138: {
                ((DSICarComfortListener)object).updateWiperRainSensorOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 139: {
                ((DSICarComfortListener)object).updateWiperRainSensorConfig(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 140: {
                ((DSICarComfortListener)object).updateWiperRearWiping((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 141: {
                ((DSICarComfortListener)object).updateWiperTearsWiping((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 142: {
                ((DSICarComfortListener)object).updateWiperWinterPosition((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 143: {
                ((DSICarComfortListener)object).updateEasyEntrySteeringColumn((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 144: {
                ((DSICarComfortListener)object).acknowledgeWiperSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 145: {
                ((DSICarComfortListener)object).updateUGDOViewOptions((UGDOViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 146: {
                ((DSICarComfortListener)object).updateUGDOLearningData((UGDOLearningData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 147: {
                ((DSICarComfortListener)object).updateUGDODestinationReached((UGDODestinationReached)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 148: {
                ((DSICarComfortListener)object).updateUGDOOpenDoor((UGDOOpenDoor)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 149: {
                ((DSICarComfortListener)object).updateUGDOContent((UGDOContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 150: {
                ((DSICarComfortListener)object).updateUGDOVersionData((UGDOVersionData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 151: {
                ((DSICarComfortListener)object).acknowledgeUGDOSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 152: {
                ((DSICarComfortListener)object).updateUGDOButtonListUpdateInfo((UGDOButtonListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 153: {
                ((DSICarComfortListener)object).updateUGDOButtonListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 154: {
                ((DSICarComfortListener)object).requestUGDOPopup((UGDOContent)objectArray[0]);
                return null;
            }
            case 155: {
                ((DSICarComfortListener)object).acknowledgeUGDOPopup((UGDOContent)objectArray[0]);
                return null;
            }
            case 156: {
                ((DSICarComfortListener)object).acknowledgeUGDODeleteButton((Boolean)objectArray[0]);
                return null;
            }
            case 157: {
                ((DSICarComfortListener)object).acknowledgeUGDOSynchronisation((UGDOSynchronisation)objectArray[0]);
                return null;
            }
            case 158: {
                ((DSICarComfortListener)object).acknowledgeUGDOLearning(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 159: {
                ((DSICarComfortListener)object).requestUGDOSynchronisation((UGDOSynchronisation)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((DSICarComfortListener)object).responseUGDOButtonListRA0((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA0[])objectArray[1]);
                return null;
            }
            case 161: {
                ((DSICarComfortListener)object).responseUGDOButtonListRA1((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA1[])objectArray[1]);
                return null;
            }
            case 162: {
                ((DSICarComfortListener)object).responseUGDOButtonListRA2((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA2[])objectArray[1]);
                return null;
            }
            case 163: {
                ((DSICarComfortListener)object).responseUGDOButtonListRA3((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA3[])objectArray[1]);
                return null;
            }
            case 164: {
                ((DSICarComfortListener)object).responseUGDOButtonListRA4((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA4[])objectArray[1]);
                return null;
            }
            case 165: {
                ((DSICarComfortListener)object).responseUGDOButtonListRA5((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA5[])objectArray[1]);
                return null;
            }
            case 166: {
                ((DSICarComfortListener)object).responseUGDOButtonListRAF((UGDOButtonListUpdateInfo)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 167: {
                ((DSICarComfortListener)object).updateRDKViewOptions((RDKViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 168: {
                ((DSICarComfortListener)object).updateRDKSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 169: {
                ((DSICarComfortListener)object).updateRDKTireSetupTireList((RDKTireInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 170: {
                ((DSICarComfortListener)object).updateRDKTireSetupSelectedTire(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 171: {
                ((DSICarComfortListener)object).updateRDKTireDisplay((RDKTireDisplayData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 172: {
                ((DSICarComfortListener)object).updateRDKSpeedLimit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 173: {
                ((DSICarComfortListener)object).responseRDKTireChanged(((Number)objectArray[0]).intValue());
                return null;
            }
            case 174: {
                ((DSICarComfortListener)object).responseRDKPressureChanged(((Number)objectArray[0]).intValue());
                return null;
            }
            case 175: {
                ((DSICarComfortListener)object).responseRDKLifeMonitoring();
                return null;
            }
            case 176: {
                ((DSICarComfortListener)object).updateRDKPressureLevel((byte)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 177: {
                ((DSICarComfortListener)object).acknowledgeRDKSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 178: {
                ((DSICarComfortListener)object).acknowledgeRDKPressureChanged((Boolean)objectArray[0]);
                return null;
            }
            case 179: {
                ((DSICarComfortListener)object).updateMirrorViewOptions((MirrorViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 180: {
                ((DSICarComfortListener)object).updateMirrorLowering((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 181: {
                ((DSICarComfortListener)object).updateMirrorSyncAdjust((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 182: {
                ((DSICarComfortListener)object).updateMirrorFolding((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 183: {
                ((DSICarComfortListener)object).updateMirrorDimming((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 184: {
                ((DSICarComfortListener)object).updateMirrorHeating((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 185: {
                ((DSICarComfortListener)object).acknowledgeMirrorSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 186: {
                ((DSICarComfortListener)object).updateBrakeViewOptions((BrakeViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 187: {
                ((DSICarComfortListener)object).updateBrakeElectricalParking((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 188: {
                ((DSICarComfortListener)object).updateBrakeAutoHold(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 189: {
                ((DSICarComfortListener)object).updateBrakeEscMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 190: {
                ((DSICarComfortListener)object).updateBrakeHdcMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 191: {
                ((DSICarComfortListener)object).updateRDKDifferentialPressure((RDKWheelPressures)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f6(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 192: {
                ((DSICarComfortListener)object).updateRDKResidualBatteryLifetime((RDKResidualBatteryLifetime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 193: {
                ((DSICarComfortListener)object).acknowledgeDoorLockingPrompt(((Number)objectArray[0]).intValue());
                return null;
            }
            case 194: {
                ((DSICarComfortListener)object).requestDoorLockingPrompt(((Number)objectArray[0]).intValue());
                return null;
            }
            case 195: {
                ((DSICarComfortListener)object).updateDoorLockingPromptContent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 196: {
                ((DSICarComfortListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
                case 6: {
                    return this.f6(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

