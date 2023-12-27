/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.carparkingsystem.ARACurrentTrailerAngle;
import org.dsi.ifc.carparkingsystem.ARAInfo;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCCrashWarning;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssistState;
import org.dsi.ifc.carparkingsystem.PDCPLABargraph;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;
import org.dsi.ifc.carparkingsystem.PDCWallDetection;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSCameraStates;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.carparkingsystem.VPSRimProtection;
import org.dsi.ifc.carparkingsystem.VPSVideoInfo;
import org.dsi.ifc.carparkingsystem.WCPanelInfo;
import org.dsi.ifc.carparkingsystem.WCPanelListRecord;
import org.dsi.ifc.carparkingsystem.WCPinPukState;
import org.dsi.ifc.carparkingsystem.WCVehiclePanelInfo;
import org.dsi.ifc.carparkingsystem.WCViewOptions;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DSICarplayListener;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.PlaybackInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.carplay.TrackData;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.ResourceLocator;

public final class LR2dbf5283b
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2078029656: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1989171965: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -1982366906: {
                if (bl) {
                    if (n2 != -531172280) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1886320460: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case -1874937697: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1779433149: {
                if (bl) {
                    if (n2 != 1450474234) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case -1775673433: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -1711626951: {
                if (bl) {
                    if (n2 != -531172280) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1667683824: {
                if (bl) {
                    if (n2 != 2067052858) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case -1621936570: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case -1518286710: {
                if (bl) {
                    if (n2 != -167892625) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1468476819: {
                if (bl) {
                    if (n2 != -2060490236) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -1464959737: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1443462972: {
                if (bl) {
                    if (n2 != 799104448) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -1423050907: {
                if (bl) {
                    if (n2 != 689095329) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1422872318: {
                if (bl) {
                    if (n2 != 689095329) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1388837952: {
                if (bl) {
                    if (n2 != -752834331) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -1328602915: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1313360233: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -1295537753: {
                if (bl) {
                    if (n2 != 316638189) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1290407960: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -1170284398: {
                if (bl) {
                    if (n2 != -374655301) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1170069291: {
                if (bl) {
                    if (n2 != 689095329) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1159478139: {
                if (bl) {
                    if (n2 != -1079767210) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1159263032: {
                if (bl) {
                    if (n2 != 689095329) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1082019807: {
                if (bl) {
                    if (n2 != 1348953182) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1071213548: {
                if (bl) {
                    if (n2 != 643841529) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1047951427: {
                if (bl) {
                    if (n2 != -728920870) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1047951303: {
                if (bl) {
                    if (n2 != -728920870) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -1047950931: {
                if (bl) {
                    if (n2 != -728920870) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1047950900: {
                if (bl) {
                    if (n2 != -728920870) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -912934138: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -909043577: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -827595802: {
                if (bl) {
                    if (n2 != 1362104892) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -809000171: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -800737457: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case -741181622: {
                if (bl) {
                    if (n2 != 428791695) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -735984466: {
                if (bl) {
                    if (n2 != 420579393) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -728828328: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case -719037104: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -575650389: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case -575435367: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case -517836581: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -431470591: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -386764054: {
                if (bl) {
                    if (n2 != 1075687367) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -361255340: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -354119771: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -321176634: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -258971470: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -180023507: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -140390887: {
                if (bl) {
                    if (n2 != 753602864) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -66799010: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -55992751: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -4412569: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 109035137: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 200289643: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 237834526: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 242151372: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 291171626: {
                if (bl) {
                    if (n2 != -1792927924) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 315839728: {
                if (bl) {
                    if (n2 != 1528865848) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 316965757: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 354670719: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 477661519: {
                if (bl) {
                    if (n2 != -1159063317) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 589753155: {
                if (bl) {
                    if (n2 != 1443403611) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 622576158: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 622754747: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 649424309: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 655152136: {
                if (bl) {
                    if (n2 != -1079767210) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 655330725: {
                if (bl) {
                    if (n2 != -374655301) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 709394810: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 790333213: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 790721608: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 796546713: {
                if (bl) {
                    if (n2 != 643841529) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 796725302: {
                if (bl) {
                    if (n2 != 1348953182) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 849582321: {
                if (bl) {
                    if (n2 != 1619717894) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 849776389: {
                if (bl) {
                    if (n2 != 1631368198) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 902983672: {
                if (bl) {
                    if (n2 != 199449754) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 945812054: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1007169041: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 1022756441: {
                if (bl) {
                    if (n2 != -1446739516) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 1102464138: {
                if (bl) {
                    if (n2 != -1656724295) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 1131156393: {
                if (bl) {
                    if (n2 != -1139860805) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1131282708: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1133186478: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 1138559288: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 1205019861: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1211036089: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1235526421: {
                if (bl) {
                    if (n2 != 428791695) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1265996528: {
                if (bl) {
                    if (n2 != 54259273) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1407108360: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 1523665351: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 1638920076: {
                if (bl) {
                    if (n2 != -1617483680) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 1670772161: {
                if (bl) {
                    if (n2 != 1514297429) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 1697849589: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1745068404: {
                if (bl) {
                    if (n2 != -539513807) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 1827470142: {
                if (bl) {
                    if (n2 != -1456428633) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1856085069: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case 1865185558: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 1908820600: {
                if (bl) {
                    if (n2 != 1631368198) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 1932499567: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 1937674428: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1937853017: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 2034983718: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 2055436682: {
                if (bl) {
                    if (n2 != -174462320) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 2114827580: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 2125633839: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1817560945: {
                if (bl) {
                    if (n2 != -1214164264) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case -1810956014: {
                if (bl) {
                    if (n2 != 232310419) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case -1742516583: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -1024892169: {
                if (bl) {
                    if (n2 != -1716859319) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -989177285: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case -982786206: {
                if (bl) {
                    if (n2 != -1457050854) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -502838206: {
                if (bl) {
                    if (n2 != 1692260465) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -323843182: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -296133503: {
                if (bl) {
                    if (n2 != -85186737) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case -63251488: {
                if (bl) {
                    if (n2 != -1123196354) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 16549539: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case 148365439: {
                if (bl) {
                    if (n2 != -1717684416) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 646131834: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case 1041293453: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case 1305053385: {
                if (bl) {
                    if (n2 != -85186737) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
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
            case -52882429: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1351960129: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarParkingSystemListener)object).updateParkingSystemViewOptions((ParkingSystemViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSICarParkingSystemListener)object).updatePDCDefaultParkingMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSICarParkingSystemListener)object).updatePDCFrequenceFront(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSICarParkingSystemListener)object).updatePDCFrequenceRear(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSICarParkingSystemListener)object).updatePDCFrequenceRight(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSICarParkingSystemListener)object).updatePDCFrequenceLeft(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSICarParkingSystemListener)object).updatePDCVolumeFront(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSICarParkingSystemListener)object).updatePDCVolumeRear(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSICarParkingSystemListener)object).updatePDCVolumeRight(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSICarParkingSystemListener)object).updatePDCVolumeLeft(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSICarParkingSystemListener)object).updatePDCMute((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSICarParkingSystemListener)object).updatePDCSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSICarParkingSystemListener)object).updatePDCTrailerHitched((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSICarParkingSystemListener)object).updatePDCDistanceValuesFront((PDCDistanceValuesFrontRear)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSICarParkingSystemListener)object).updatePDCDistanceValuesRear((PDCDistanceValuesFrontRear)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSICarParkingSystemListener)object).updatePDCDistanceValuesRight((PDCDistanceValuesRightLeft)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSICarParkingSystemListener)object).updatePDCDistanceValuesLeft((PDCDistanceValuesRightLeft)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSICarParkingSystemListener)object).updatePDCStatusLevelFront((PDCStatusLevelFrontRear)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSICarParkingSystemListener)object).updatePDCStatusLevelRear((PDCStatusLevelFrontRear)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSICarParkingSystemListener)object).updatePDCStatusLevelRight((PDCStatusLevelRightLeft)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSICarParkingSystemListener)object).updatePDCStatusLevelLeft((PDCStatusLevelRightLeft)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSICarParkingSystemListener)object).updatePDCOPSAutoActivation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSICarParkingSystemListener)object).updatePDCCrashWarning((PDCCrashWarning)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSICarParkingSystemListener)object).updatePDCSteeringInformation((PDCSteeringInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSICarParkingSystemListener)object).updatePDCFlankGuard((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSICarParkingSystemListener)object).updatePDCSoundReproduction((PDCSoundReproduction)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSICarParkingSystemListener)object).updatePDCInfo((PDCInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSICarParkingSystemListener)object).updatePDCFailure((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSICarParkingSystemListener)object).updatePDCDistanceValuesFrontExt((PDCDistanceValuesFrontRearExt)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSICarParkingSystemListener)object).updatePDCDistanceValuesRearExt((PDCDistanceValuesFrontRearExt)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSICarParkingSystemListener)object).updatePDCStatusLevelFrontExt((PDCStatusLevelFrontRearExt)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSICarParkingSystemListener)object).updatePDCStatusLevelRearExt((PDCStatusLevelFrontRearExt)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarParkingSystemListener)object).updatePDCWallDetection((PDCWallDetection)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSICarParkingSystemListener)object).updatePDCPLAMessage(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSICarParkingSystemListener)object).updatePDCSoundFront((PDCSound)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSICarParkingSystemListener)object).updatePDCSoundRear((PDCSound)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSICarParkingSystemListener)object).updatePDCSoundLeft((PDCSound)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSICarParkingSystemListener)object).updatePDCSoundRight((PDCSound)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSICarParkingSystemListener)object).updatePDCPLAStatus((PDCPLAStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSICarParkingSystemListener)object).updatePDCPLABargraph((PDCPLABargraph)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSICarParkingSystemListener)object).updatePDCPLAParkmodeSelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSICarParkingSystemListener)object).updatePDCPLASystemState((PDCPLASystemState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSICarParkingSystemListener)object).updatePDCOPSVisualisationPosition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((DSICarParkingSystemListener)object).updatePDCOffroadMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 44: {
                ((DSICarParkingSystemListener)object).updatePDCParkboxVisualisation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSICarParkingSystemListener)object).updateVPSFollowUpTime(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSICarParkingSystemListener)object).updateVPSVideoInfo((VPSVideoInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 47: {
                ((DSICarParkingSystemListener)object).updateVPSColor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 48: {
                ((DSICarParkingSystemListener)object).updateVPSContrast(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSICarParkingSystemListener)object).updateVPSBrightness(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((DSICarParkingSystemListener)object).updateVPSDefaultModeRV((VPSDefaultMode)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((DSICarParkingSystemListener)object).updateVPSDefaultModeSV((VPSDefaultMode)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSICarParkingSystemListener)object).updateVPSDefaultModeFV((VPSDefaultMode)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((DSICarParkingSystemListener)object).updateVPSDefaultModeBV((VPSDefaultMode)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSICarParkingSystemListener)object).updateVPSDefaultView(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSICarParkingSystemListener)object).updateVPSDynamicParkingMode((VPSDynParkingMode)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSICarParkingSystemListener)object).updateVPSOPSOverlay((VPSOPSOverlay)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSICarParkingSystemListener)object).updateVPSSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSICarParkingSystemListener)object).updateVPSFailure((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSICarParkingSystemListener)object).updateVPSExtCamConfig(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 60: {
                ((DSICarParkingSystemListener)object).updateVPSExtCamManActivation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((DSICarParkingSystemListener)object).updateVPS3DBirdview(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 62: {
                ((DSICarParkingSystemListener)object).updateVPSSystemState((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSICarParkingSystemListener)object).updateVPSCameraStates((VPSCameraStates)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarParkingSystemListener)object).updateParkingPopupContent((DisplayContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((DSICarParkingSystemListener)object).requestParkingPopup((DisplayContent)objectArray[0]);
                return null;
            }
            case 66: {
                ((DSICarParkingSystemListener)object).acknowledgeParkingPopup((DisplayContent)objectArray[0]);
                return null;
            }
            case 67: {
                ((DSICarParkingSystemListener)object).responseLifeMonitoring((Boolean)objectArray[0]);
                return null;
            }
            case 68: {
                ((DSICarParkingSystemListener)object).acknowledgePdcSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 69: {
                ((DSICarParkingSystemListener)object).acknowledgeVpsSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 70: {
                ((DSICarParkingSystemListener)object).updateARAFailure((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 71: {
                ((DSICarParkingSystemListener)object).updateARAInfo((ARAInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((DSICarParkingSystemListener)object).updateARACurrentTrailerAngle((ARACurrentTrailerAngle)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 73: {
                ((DSICarParkingSystemListener)object).updateARATargetTrailerAngle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 74: {
                ((DSICarParkingSystemListener)object).updatePDCManeuverAssistConfig(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((DSICarParkingSystemListener)object).updatePDCManeuverAssist((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 76: {
                ((DSICarParkingSystemListener)object).updatePDCManeuverAssistState((PDCManeuverAssistState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 77: {
                ((DSICarParkingSystemListener)object).updatePDCManeuverAssistMessage(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 78: {
                ((DSICarParkingSystemListener)object).updatePDCIPAMessage(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 79: {
                ((DSICarParkingSystemListener)object).updatePDCContinueDrivingAssist(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 80: {
                ((DSICarParkingSystemListener)object).updatePDCIpaConfig(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 81: {
                ((DSICarParkingSystemListener)object).updatePDCPiloPaSystemState((PDCPiloPaSystemState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 82: {
                ((DSICarParkingSystemListener)object).updateVPSCameraCleaning((VPSCameraCleaning)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 83: {
                ((DSICarParkingSystemListener)object).updateVPSRimProtection((VPSRimProtection)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 84: {
                ((DSICarParkingSystemListener)object).updateWCViewOptions((WCViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 85: {
                ((DSICarParkingSystemListener)object).updateWCSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 86: {
                ((DSICarParkingSystemListener)object).updateWCAutoActivation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 87: {
                ((DSICarParkingSystemListener)object).updateWCPopupContent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 88: {
                ((DSICarParkingSystemListener)object).updateWCMessage(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((DSICarParkingSystemListener)object).updateWCPanelPosition((WCPanelInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 90: {
                ((DSICarParkingSystemListener)object).acknowledgeWCSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 91: {
                ((DSICarParkingSystemListener)object).requestWCPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 92: {
                ((DSICarParkingSystemListener)object).acknowledgeWCPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 93: {
                ((DSICarParkingSystemListener)object).updateWCPanelListUpdateInfo((CarArrayListUpdateInfo)objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 94: {
                ((DSICarParkingSystemListener)object).updateWCPanelListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 95: {
                ((DSICarParkingSystemListener)object).updateWCVehiclePanelInfo((WCVehiclePanelInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSICarParkingSystemListener)object).updateWCPinPukState((WCPinPukState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 97: {
                ((DSICarParkingSystemListener)object).updateWCScanningProgress(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 98: {
                ((DSICarParkingSystemListener)object).updateWCSoftwareUpdateProgress(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 99: {
                ((DSICarParkingSystemListener)object).acknowledgeWCEnterPinPuk(((Number)objectArray[0]).intValue());
                return null;
            }
            case 100: {
                ((DSICarParkingSystemListener)object).acknowledgeWCScanning(((Number)objectArray[0]).intValue());
                return null;
            }
            case 101: {
                ((DSICarParkingSystemListener)object).acknowledgeWCPairing(((Number)objectArray[0]).intValue());
                return null;
            }
            case 102: {
                ((DSICarParkingSystemListener)object).acknowledgeWCSoftwareUpdate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 103: {
                ((DSICarParkingSystemListener)object).acknowledgeWCChangePin(((Number)objectArray[0]).intValue());
                return null;
            }
            case 104: {
                ((DSICarParkingSystemListener)object).acknowledgeWCChangePanelName(((Number)objectArray[0]).intValue());
                return null;
            }
            case 105: {
                ((DSICarParkingSystemListener)object).responseWCPanelList((CarArrayListUpdateInfo)objectArray[0], (WCPanelListRecord[])objectArray[1]);
                return null;
            }
            case 106: {
                ((DSICarParkingSystemListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 107: {
                ((DSICarplayListener)object).responseModeChange((Resource[])objectArray[0], (AppState[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 108: {
                ((DSICarplayListener)object).updateCallState((CallState[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 109: {
                ((DSICarplayListener)object).updateTelephonyState((TelephonyState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 110: {
                ((DSICarplayListener)object).updateNowPlayingData((TrackData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 111: {
                ((DSICarplayListener)object).updatePlaybackState((PlaybackInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 112: {
                ((DSICarplayListener)object).updatePlayposition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 113: {
                ((DSICarplayListener)object).updateCoverArtUrl((ResourceLocator)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 114: {
                ((DSICarplayListener)object).updateDeviceInfo((DeviceInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 115: {
                ((DSICarplayListener)object).updateMode((Resource[])objectArray[0], (AppState[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 116: {
                ((DSICarplayListener)object).requestBTDeactivation((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 117: {
                ((DSICarplayListener)object).updateTextInputState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 118: {
                ((DSICarplayListener)object).duckAudio(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).doubleValue());
                return null;
            }
            case 119: {
                ((DSICarplayListener)object).unduckAudio(((Number)objectArray[0]).intValue());
                return null;
            }
            case 120: {
                ((DSICarplayListener)object).oemAppSelected();
                return null;
            }
            case 121: {
                ((DSICarplayListener)object).updateMainAudioType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 122: {
                ((DSICarplayListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

