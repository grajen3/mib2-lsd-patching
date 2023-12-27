/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap.reflection.generated.mma;

import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.internal.navigation.bap.HsmBapListTarget;
import de.vw.mib.asl.internal.navigation.bap.HsmTargetBap;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAddChar;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdCancelSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsDeleteAll;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsGet;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLastCityHistoryEntry;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLastStreetHistoryEntry;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationFromLiValueListElement;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetMatchingNVC;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdHistoryAddLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastCityHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastStateHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastStreetHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdNavLocationToStream;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiGetXt9LDBs;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRoute;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRouteAdvanced;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRmRouteAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRmRouteDelete;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByCategoryUid;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByMultipleCategoryUids;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemByIdent;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemPoi;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCountryForCityAndStreetHistory;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCurrentLD;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetNVCRange;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStopSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStreamToNavLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStripLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTransformAndStrip;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTransformAndToStream;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryBestMatch;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryMatchLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdUndoChar;
import de.vw.mib.asl.internal.navigation.setup.HsmTargetSetup;
import de.vw.mib.asl.internal.navigation.setup.TargetHandleLsc;
import de.vw.mib.asl.internal.navigation.setup.TargetOnlineService;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DataSet;

public final class LR29cdbb889
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1981963883: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1080060518: {
                if (bl) {
                    if (n2 != 815571355) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -525585663: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -215985701: {
                if (bl) {
                    if (n2 != -1835876800) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -134402092: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -134188440: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -48786765: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 392034375: {
                if (bl) {
                    if (n2 != 1420063289) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 406794510: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 916038131: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1169798934: {
                if (bl) {
                    if (n2 != 618681725) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1347938500: {
                if (bl) {
                    if (n2 != 1436671998) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1519678342: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1747869026: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -1896963995: {
                if (bl) {
                    if (n2 != -115882523) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1663598968: {
                if (bl) {
                    if (n2 != 1147312894) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1556032777: {
                if (bl) {
                    if (n2 != 2043315704) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case -1080060518: {
                if (bl) {
                    if (n2 != 815571355) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -961837681: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -604813648: {
                if (bl) {
                    if (n2 != -796524928) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -215985701: {
                if (bl) {
                    if (n2 != -1835876800) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -171673451: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -134402092: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -134188440: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -48786765: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 84172398: {
                if (bl) {
                    if (n2 != 746133882) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 269677393: {
                if (bl) {
                    if (n2 != -912290783) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 392034375: {
                if (bl) {
                    if (n2 != 1420063289) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 407773447: {
                if (bl) {
                    if (n2 != -1622239583) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 498360182: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 916038131: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 1169798934: {
                if (bl) {
                    if (n2 != 618681725) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1415531835: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 1466803583: {
                if (bl) {
                    if (n2 != 487638186) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 2025850229: {
                if (bl) {
                    if (n2 != -1145889529) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2060762885: {
                if (bl) {
                    if (n2 != -234225152) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -1818077053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case -1734830855: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -1574401706: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -874233051: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -801341532: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case -691075860: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -440393909: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case -428900771: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case -259291812: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -129620653: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case -111424303: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 25224473: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 354394663: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 383168020: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 387936491: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 430069792: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 464239993: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != 66574611) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1031841020: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 1311856550: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 1626955637: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 1787774304: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 2112065749: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2041958526: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -877619004: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2142549975: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case -982882231: {
                if (bl) {
                    if (n2 != -1478650924) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case -1154749: {
                if (bl) {
                    if (n2 != -1674355153) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case 105871070: {
                if (bl) {
                    if (n2 != 748367570) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 153843988: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case 1375279829: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case 1887939072: {
                if (bl) {
                    if (n2 != -1992762834) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
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
            case 31780016: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case 445527573: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case 1176832149: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1324824770: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 1989235349: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((HsmBapListTarget)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 1: {
                ((HsmBapListTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((HsmBapListTarget)object).dsiAdbListSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue(), (String)objectArray[4], (String)objectArray[5]);
                return null;
            }
            case 3: {
                ((HsmBapListTarget)object).dsiAdbListStopSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((HsmBapListTarget)object).dsiAdbListInvalidData(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((HsmBapListTarget)object).dsiAdbListUpdateViewSize((AdbViewSize)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((HsmBapListTarget)object).dsiAdbListGetViewWindowResult(((Number)objectArray[0]).intValue(), (DataSet[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((HsmBapListTarget)object).dsiNavigationDmLastDestinationsGetResult(((Number)objectArray[0]).longValue(), (NavLocation)objectArray[1]);
                return null;
            }
            case 8: {
                ((HsmBapListTarget)object).dsiAdbEditGetEntriesResult(((Number)objectArray[0]).intValue(), (AdbEntry[])objectArray[1]);
                return null;
            }
            case 9: {
                ((HsmBapListTarget)object).dsiAdbListSetListStyleResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((HsmBapListTarget)object).initDsiNavigation();
                return null;
            }
            case 11: {
                ((HsmBapListTarget)object).initDsiAdbList();
                return null;
            }
            case 12: {
                ((HsmBapListTarget)object).initDsiAdbEdit();
                return null;
            }
            case 13: {
                ((HsmBapListTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                return RuntimeUtil.valueOf(((HsmBapListTarget)object).wasDsiNavigationResettet((HashMap)objectArray[0]));
            }
            case 15: {
                return RuntimeUtil.valueOf(((HsmBapListTarget)object).wasDsiAdbEditResettet((HashMap)objectArray[0]));
            }
            case 16: {
                return RuntimeUtil.valueOf(((HsmBapListTarget)object).wasDsiAdbListResettet((HashMap)objectArray[0]));
            }
            case 17: {
                ((HsmTargetBap)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 18: {
                ((HsmTargetBap)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((HsmTargetBap)object).dsiAdbListInvalidData(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((HsmTargetBap)object).dsiAdbListUpdateViewSize((AdbViewSize)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((HsmTargetBap)object).dsiAdbListGetViewWindowResult(((Number)objectArray[0]).intValue(), (DataSet[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 22: {
                ((HsmTargetBap)object).dsiNavigationDmLastDestinationsGetResult(((Number)objectArray[0]).longValue(), (NavLocation)objectArray[1]);
                return null;
            }
            case 23: {
                ((HsmTargetBap)object).dsiAdbEditGetEntriesResult(((Number)objectArray[0]).intValue(), (AdbEntry[])objectArray[1]);
                return null;
            }
            case 24: {
                ((HsmTargetBap)object).initDsiNavigation();
                return null;
            }
            case 25: {
                ((HsmTargetBap)object).initDsiAdbList();
                return null;
            }
            case 26: {
                ((HsmTargetBap)object).initDsiAdbEdit();
                return null;
            }
            case 27: {
                ((HsmTargetBap)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((HsmTargetBap)object).dsiNavigationUpdateDmLastDestinationsList((LDListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((HsmTargetBap)object).dsiNavigationUpdateBapManeuverDescriptor((BapManeuverDescriptor[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((HsmTargetBap)object).dsiNavigationUpdateDistanceToNextManeuver((DistanceToNextManeuver)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((HsmTargetBap)object).dsiNavigationUpdateRgLaneGuidance((NavLaneGuidanceData[])objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((HsmTargetBap)object).dsiNavigationUpdateBapTurnToInfo((BapTurnToInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((HsmTargetBap)object).dsiNavigationUpdateSoPosPositionDescription((NavLocation)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 34: {
                ((HsmTargetBap)object).dsiNavigationStreamToLocationResult((Boolean)objectArray[0], (NavLocation)objectArray[1]);
                return null;
            }
            case 35: {
                ((HsmTargetBap)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 36: {
                ((HsmTargetBap)object).dsiNavigationUpdateSoPosPosition((PosPosition)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((HsmTargetBap)object).dsiTmcUpdateActiveTrafficSources((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((HsmTargetBap)object).initDsiCarKombi();
                return null;
            }
            case 39: {
                ((HsmTargetBap)object).initDsiTmc();
                return null;
            }
            case 40: {
                ((HsmTargetBap)object).dsiCarKombiUpdateCompassInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 41: {
                ((HsmTargetBap)object).dsiNavigationUpdateRgCurrentRoute((Route)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((HsmTargetBap)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 43: {
                ((HsmTargetBap)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 44: {
                ((HsmTargetBap)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 45: {
                ((HsmTargetBap)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 46: {
                ((HsmTargetBap)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 47: {
                ((HsmTargetBap)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 48: {
                ((HsmTargetBap)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 49: {
                ((HsmTargetBap)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 50: {
                ((HsmTargetBap)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 51: {
                ((HsmTargetBap)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 52: {
                ((HsmTargetBap)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 53: {
                ((HsmTargetBap)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 54: {
                ((HsmTargetBap)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 55: {
                ((HsmTargetBap)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 56: {
                ((HsmTargetBap)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 57: {
                ((HsmTargetBap)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 58: {
                ((HsmTargetBap)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 59: {
                ((HsmTargetBap)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 60: {
                ((HsmTargetBap)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 61: {
                ((HsmTargetBap)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 62: {
                ((HsmTargetBap)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 63: {
                ((HsmTargetBap)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((HsmTargetBap)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 65: {
                ((HsmTargetBap)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 66: {
                ((HsmTargetBap)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 67: {
                ((HsmTargetBap)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 68: {
                ((HsmTargetBap)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 69: {
                ((HsmTargetBap)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 70: {
                ((HsmTargetBap)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 71: {
                ((HsmTargetBap)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 72: {
                ((HsmTargetBap)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 73: {
                ((HsmTargetBap)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 74: {
                ((HsmTargetBap)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 75: {
                ((HsmTargetBap)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 76: {
                ((HsmTargetBap)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 77: {
                ((HsmTargetBap)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 78: {
                ((HsmTargetBap)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 79: {
                ((HsmTargetBap)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 80: {
                ((HsmTargetBap)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 81: {
                ((HsmTargetBap)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 82: {
                ((HsmTargetBap)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 83: {
                ((HsmTargetSetup)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 84: {
                ((HsmTargetSetup)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 85: {
                ((HsmTargetSetup)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 86: {
                ((HsmTargetSetup)object).traceState((HsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 87: {
                ((HsmTargetSetup)object).setAudioVoiceAnnnouncementType(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 88: {
                ((HsmTargetSetup)object).setDsiDistanceUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 89: {
                ((HsmTargetSetup)object).setDSICurrentPPOIApproachWarningStatus();
                return null;
            }
            case 90: {
                return ((HsmTargetSetup)object).setCategoryUid();
            }
            case 91: {
                return RuntimeUtil.valueOf(((HsmTargetSetup)object).isCHNSpeedCameraWarning());
            }
            case 92: {
                return RuntimeUtil.valueOf(((HsmTargetSetup)object).isPPOIAWFeature());
            }
            case 93: {
                ((HsmTargetSetup)object).deleteMemoryWaypointMemory();
                return null;
            }
            case 94: {
                ((HsmTargetSetup)object).deleteMemoryBlocking();
                return null;
            }
            case 95: {
                ((HsmTargetSetup)object).deleteMemoryFlagDestination();
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((HsmTargetSetup)object).deleteMemoryHomeLocation();
                return null;
            }
            case 97: {
                ((HsmTargetSetup)object).deleteMemoryLastCitiesAndStreets();
                return null;
            }
            case 98: {
                ((HsmTargetSetup)object).deleteMemoryLastDestinations();
                return null;
            }
            case 99: {
                ((HsmTargetSetup)object).deleteMemoryTour();
                return null;
            }
            case 100: {
                ((HsmTargetSetup)object).deleteShieldHistory();
                return null;
            }
            case 101: {
                ((HsmTargetSetup)object).deleteNavInternalData();
                return null;
            }
            case 102: {
                ((HsmTargetSetup)object).getAllCategories();
                return null;
            }
            case 103: {
                ((HsmTargetSetup)object).setCategoryAudioWarning((int[])objectArray[0], (boolean[])objectArray[1]);
                return null;
            }
            case 104: {
                ((HsmTargetSetup)object).disableManeuverViewGeneration((Boolean)objectArray[0]);
                return null;
            }
            case 105: {
                ((HsmTargetSetup)object).reloadPersistedData();
                return null;
            }
            case 106: {
                ((HsmTargetSetup)object).setSpeedCameraWarning((Boolean)objectArray[0]);
                return null;
            }
            case 107: {
                ((HsmTargetSetup)object).setCategoryMonitoring((Boolean)objectArray[0]);
                return null;
            }
            case 108: {
                ((HsmTargetSetup)object).setApproachPPOIHint((Boolean)objectArray[0]);
                return null;
            }
            case 109: {
                return RuntimeUtil.valueOf(HsmTargetSetup.getLastModeDestinationInputDefault());
            }
            case 110: {
                ((TargetHandleLsc)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 111: {
                ((TargetHandleLsc)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 112: {
                ((TargetHandleLsc)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 113: {
                ((TargetHandleLsc)object).dsiNavigationUpdateLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 114: {
                ((TargetHandleLsc)object).dsiNavigationUpdateEtcLanguageLoadStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 115: {
                ((TargetOnlineService)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 116: {
                ((TargetOnlineService)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 117: {
                ((TargetOnlineService)object).dsiOnlineServiceRegistrationGetServiceListResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 118: {
                ((TargetOnlineService)object).dsiOnlineServiceRegistrationGetOnlineApplicationResponse((OSRApplication)objectArray[0]);
                return null;
            }
            case 119: {
                ((TargetOnlineService)object).dsiOnlineServiceRegistrationActivateLicenseResponse((OSRLicense)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 120: {
                ((TargetOnlineService)object).dsiOnlineServiceRegistrationAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 121: {
                ((TargetOnlineService)object).dsiOnlineServiceRegistrationUpdateApplicationState((OSRNotifyProperties[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 122: {
                return ((TargetOnlineService)object).getLocator();
            }
            case 123: {
                ((TargetOnlineService)object).setLocator((DSIServiceLocator)objectArray[0]);
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

