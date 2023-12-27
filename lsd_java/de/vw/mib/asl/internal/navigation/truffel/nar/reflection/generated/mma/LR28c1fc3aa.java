/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.truffel.nar.reflection.generated.mma;

import de.vw.mib.asl.internal.navigation.caching.IconKey;
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
import de.vw.mib.asl.internal.navigation.shield.nar.ShieldDsiHandler;
import de.vw.mib.asl.internal.navigation.shield.nar.TargetShield;
import de.vw.mib.asl.internal.navigation.slde.SldeProxyTarget;
import de.vw.mib.asl.internal.navigation.slde.SldeSpellerDsiHandler;
import de.vw.mib.asl.internal.navigation.slde.SldeSpellerHandler;
import de.vw.mib.asl.internal.navigation.slde.SpellerDataChangedListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.SearchResult;

public final class LR28c1fc3aa
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2120679617: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
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
            case -1814427883: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -1706131336: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1586048005: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1584531229: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1441951967: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1428654636: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1425030276: {
                if (bl) {
                    if (n2 != -773629047) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -836984971: {
                if (bl) {
                    if (n2 != -2121650919) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -832720443: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -726172846: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -671168975: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -530447682: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 71571456: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 84172398: {
                if (bl) {
                    if (n2 != 746133882) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 88531858: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
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
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 1021167960: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1034780132: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 1170085656: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 1771084069: {
                if (bl) {
                    if (n2 != 2088095711) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1797058246: {
                if (bl) {
                    if (n2 != 686423297) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 2025979178: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 2104796517: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -2140770425: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case -1872226770: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -1762191551: {
                if (bl) {
                    if (n2 != 757849721) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case -1679832100: {
                if (bl) {
                    if (n2 != 1163568566) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case -1397098457: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -1247909547: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case -1077557351: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case -963105286: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case -541589646: {
                if (bl) {
                    if (n2 != -597552106) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -535206303: {
                if (bl) {
                    if (n2 != -274966112) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -404602708: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -247816122: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case -144940140: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case 290761107: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 328132300: {
                if (bl) {
                    if (n2 != 1314865490) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case 476513739: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case 491015142: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case 761602346: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 977393059: {
                if (bl) {
                    if (n2 != -1172496671) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case 1098221099: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 1244919775: {
                if (bl) {
                    if (n2 != -1985511187) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 1263831384: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 1273409167: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 1358541925: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case 1670275095: {
                if (bl) {
                    if (n2 != -1172496671) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case 1845314727: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 1908999551: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2038368502: {
                if (bl) {
                    if (n2 != -79405049) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case -1397098457: {
                if (bl) {
                    if (n2 != -79405049) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -144940140: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case 25224473: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 185;
                    break;
                }
                n3 = 185;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 183;
                    break;
                }
                n3 = 183;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case -1039676199: {
                if (bl) {
                    if (n2 != 941556127) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 186;
                    break;
                }
                n3 = 186;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 179;
                    break;
                }
                n3 = 179;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 184;
                    break;
                }
                n3 = 184;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2083810794: {
                if (bl) {
                    if (n2 != 941556127) break;
                    n3 = 188;
                    break;
                }
                n3 = 188;
                break;
            }
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 209;
                    break;
                }
                n3 = 209;
                break;
            }
            case -2062103523: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 202;
                    break;
                }
                n3 = 202;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 215;
                    break;
                }
                n3 = 215;
                break;
            }
            case -1990015225: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 198;
                    break;
                }
                n3 = 198;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 224;
                    break;
                }
                n3 = 224;
                break;
            }
            case -1948547021: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 203;
                    break;
                }
                n3 = 203;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 232;
                    break;
                }
                n3 = 232;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 223;
                    break;
                }
                n3 = 223;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 236;
                    break;
                }
                n3 = 236;
                break;
            }
            case -1661938560: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 187;
                    break;
                }
                n3 = 187;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 221;
                    break;
                }
                n3 = 221;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 217;
                    break;
                }
                n3 = 217;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 245;
                    break;
                }
                n3 = 245;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 225;
                    break;
                }
                n3 = 225;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 213;
                    break;
                }
                n3 = 213;
                break;
            }
            case -1358041988: {
                if (bl) {
                    if (n2 != 232068942) break;
                    n3 = 196;
                    break;
                }
                n3 = 196;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 243;
                    break;
                }
                n3 = 243;
                break;
            }
            case -1046128545: {
                if (bl) {
                    if (n2 != 232068942) break;
                    n3 = 199;
                    break;
                }
                n3 = 199;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 211;
                    break;
                }
                n3 = 211;
                break;
            }
            case -1039676199: {
                if (bl) {
                    if (n2 != 941556127) break;
                    n3 = 197;
                    break;
                }
                n3 = 197;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 242;
                    break;
                }
                n3 = 242;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 231;
                    break;
                }
                n3 = 231;
                break;
            }
            case -751282892: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 189;
                    break;
                }
                n3 = 189;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 226;
                    break;
                }
                n3 = 226;
                break;
            }
            case -225173922: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 193;
                    break;
                }
                n3 = 193;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 220;
                    break;
                }
                n3 = 220;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 190;
                    break;
                }
                n3 = 190;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 214;
                    break;
                }
                n3 = 214;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 219;
                    break;
                }
                n3 = 219;
                break;
            }
            case 138313610: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 192;
                    break;
                }
                n3 = 192;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 234;
                    break;
                }
                n3 = 234;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 235;
                    break;
                }
                n3 = 235;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 208;
                    break;
                }
                n3 = 208;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 206;
                    break;
                }
                n3 = 206;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 233;
                    break;
                }
                n3 = 233;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 222;
                    break;
                }
                n3 = 222;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 246;
                    break;
                }
                n3 = 246;
                break;
            }
            case 503227765: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 204;
                    break;
                }
                n3 = 204;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 230;
                    break;
                }
                n3 = 230;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 240;
                    break;
                }
                n3 = 240;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 228;
                    break;
                }
                n3 = 228;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 241;
                    break;
                }
                n3 = 241;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 239;
                    break;
                }
                n3 = 239;
                break;
            }
            case 1168679988: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 205;
                    break;
                }
                n3 = 205;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 212;
                    break;
                }
                n3 = 212;
                break;
            }
            case 1212712607: {
                if (bl) {
                    if (n2 != 232068942) break;
                    n3 = 201;
                    break;
                }
                n3 = 201;
                break;
            }
            case 1265462368: {
                if (bl) {
                    if (n2 == -1261696176) {
                        n3 = 194;
                        break;
                    }
                    if (n2 != 941556127) break;
                    n3 = 195;
                    break;
                }
                n3 = 194;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 227;
                    break;
                }
                n3 = 227;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 216;
                    break;
                }
                n3 = 216;
                break;
            }
            case 1524626050: {
                if (bl) {
                    if (n2 != 232068942) break;
                    n3 = 200;
                    break;
                }
                n3 = 200;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 207;
                    break;
                }
                n3 = 207;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 229;
                    break;
                }
                n3 = 229;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 237;
                    break;
                }
                n3 = 237;
                break;
            }
            case 1948326914: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 191;
                    break;
                }
                n3 = 191;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 218;
                    break;
                }
                n3 = 218;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 210;
                    break;
                }
                n3 = 210;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 238;
                    break;
                }
                n3 = 238;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 244;
                    break;
                }
                n3 = 244;
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
            case -1037252533: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -402328962: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 675096349: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1982464849: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 2020072595: {
                n2 = this.a4(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((ShieldDsiHandler)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 1: {
                ((ShieldDsiHandler)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((ShieldDsiHandler)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((ShieldDsiHandler)object).dsiSearchSearchResult(((Number)objectArray[0]).intValue(), (SearchResult)objectArray[1]);
                return null;
            }
            case 4: {
                ((ShieldDsiHandler)object).dsiSearchUpdateSearchIsActive(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((ShieldDsiHandler)object).dsiSearchCancelQueryResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((ShieldDsiHandler)object).dsiSearchSetCurrentPositionResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((ShieldDsiHandler)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 8: {
                ((ShieldDsiHandler)object).dsiSearchRequestSupportedCountriesResult(((Number)objectArray[0]).intValue(), (Country[])objectArray[1]);
                return null;
            }
            case 9: {
                ((ShieldDsiHandler)object).dsiSearchSetActiveSearchCountriesResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((ShieldDsiHandler)object).dsiNavigationUpdateDmLastDestinationsList((LDListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((ShieldDsiHandler)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 12: {
                ((ShieldDsiHandler)object).startQuery((String)objectArray[0]);
                return null;
            }
            case 13: {
                return ((ShieldDsiHandler)object).createNewQueryUsingNeedle((String)objectArray[0]);
            }
            case 14: {
                ((ShieldDsiHandler)object).setCurrentPosition((NavPosition)objectArray[0]);
                return null;
            }
            case 15: {
                ((ShieldDsiHandler)object).cancelQuery();
                return null;
            }
            case 16: {
                ((ShieldDsiHandler)object).configureDsiSearch();
                return null;
            }
            case 17: {
                ((ShieldDsiHandler)object).dsiAsiaInputResponseSegmentationForTruffles((String)objectArray[0]);
                return null;
            }
            case 18: {
                ((ShieldDsiHandler)object).dsiSearchSetEnvironmentResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((ShieldDsiHandler)object).dsiSearchPrepareSourcesResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((ShieldDsiHandler)object).dsiSearchSetLanguageResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((ShieldDsiHandler)object).dsiSearchSetActiveProfileResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 22: {
                ((ShieldDsiHandler)object).dmLastDestionsGet(((Number)objectArray[0]).longValue());
                return null;
            }
            case 23: {
                ((ShieldDsiHandler)object).liSetCurrentLd((NavLocation)objectArray[0]);
                return null;
            }
            case 24: {
                ((ShieldDsiHandler)object).resetSettingsForNavi();
                return null;
            }
            case 25: {
                ((ShieldDsiHandler)object).resetSettingsForFullFactoryReset();
                return null;
            }
            case 26: {
                ((ShieldDsiHandler)object).setEnvironment((Environment)objectArray[0]);
                return null;
            }
            case 27: {
                return ((ShieldDsiHandler)object).getEnvironment();
            }
            case 28: {
                ((ShieldDsiHandler)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 29: {
                ((ShieldDsiHandler)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 30: {
                ((ShieldDsiHandler)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 31: {
                ((ShieldDsiHandler)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((ShieldDsiHandler)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 33: {
                ((ShieldDsiHandler)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 34: {
                ((ShieldDsiHandler)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 35: {
                ((ShieldDsiHandler)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 36: {
                ((ShieldDsiHandler)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 37: {
                ((ShieldDsiHandler)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 38: {
                ((ShieldDsiHandler)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 39: {
                ((ShieldDsiHandler)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 40: {
                ((ShieldDsiHandler)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 41: {
                ((ShieldDsiHandler)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 42: {
                ((ShieldDsiHandler)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 43: {
                ((ShieldDsiHandler)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 44: {
                ((ShieldDsiHandler)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 45: {
                ((ShieldDsiHandler)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 46: {
                ((ShieldDsiHandler)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 47: {
                ((ShieldDsiHandler)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 48: {
                ((ShieldDsiHandler)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 49: {
                ((ShieldDsiHandler)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 50: {
                ((ShieldDsiHandler)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 51: {
                ((ShieldDsiHandler)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 52: {
                ((ShieldDsiHandler)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 53: {
                ((ShieldDsiHandler)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 54: {
                ((ShieldDsiHandler)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 55: {
                ((ShieldDsiHandler)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 56: {
                ((ShieldDsiHandler)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 57: {
                ((ShieldDsiHandler)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 58: {
                ((ShieldDsiHandler)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 59: {
                ((ShieldDsiHandler)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 60: {
                ((ShieldDsiHandler)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 61: {
                ((ShieldDsiHandler)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 62: {
                ((ShieldDsiHandler)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 63: {
                ((ShieldDsiHandler)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((ShieldDsiHandler)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 65: {
                ((ShieldDsiHandler)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 66: {
                ((ShieldDsiHandler)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 67: {
                ((ShieldDsiHandler)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 68: {
                ((TargetShield)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 69: {
                ((TargetShield)object).handleSearchResultReceived((SearchResult)objectArray[0]);
                return null;
            }
            case 70: {
                ((TargetShield)object).handleSearchIsActive((Boolean)objectArray[0]);
                return null;
            }
            case 71: {
                ((TargetShield)object).handleCancelQueryResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((TargetShield)object).handleSetCurrentPositionResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 73: {
                ((TargetShield)object).handleLiCurrentState((int[])objectArray[0], (int[])objectArray[1], (NavLocation)objectArray[2]);
                return null;
            }
            case 74: {
                ((TargetShield)object).handleCountriesSet();
                return null;
            }
            case 75: {
                ((TargetShield)object).handleLastDestinationsUpdate((LDListElement[])objectArray[0]);
                return null;
            }
            case 76: {
                ((TargetShield)object).handleLastDestionationUpdate((NavLocation)objectArray[0]);
                return null;
            }
            case 77: {
                ((TargetShield)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 78: {
                ((TargetShield)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 79: {
                ((TargetShield)object).updateSearchPosition();
                return null;
            }
            case 80: {
                ((TargetShield)object).handleCancelSearch();
                return null;
            }
            case 81: {
                ((TargetShield)object).spellerTextChanged();
                return null;
            }
            case 82: {
                ((TargetShield)object).handleIconCacheUpdate((IconKey)objectArray[0], (ResourceLocator)objectArray[1], objectArray[2]);
                return null;
            }
            case 83: {
                TargetShield.setSHIELDHousenumber((String)objectArray[0]);
                return null;
            }
            case 84: {
                TargetShield.resetSHIELDHousenumber();
                return null;
            }
            case 85: {
                TargetShield.setLocation((NavLocation)objectArray[0]);
                return null;
            }
            case 86: {
                TargetShield.setSelectedSearchResult((SearchResult)objectArray[0]);
                return null;
            }
            case 87: {
                ((TargetShield)object).setSearchResults((Vector)objectArray[0], (Boolean)objectArray[1], (NavLocation)objectArray[2], (Boolean)objectArray[3]);
                return null;
            }
            case 88: {
                ((TargetShield)object).switchToResultMapView((Boolean)objectArray[0]);
                return null;
            }
            case 89: {
                return ((TargetShield)object).getDefaultIcon();
            }
            case 90: {
                ((TargetShield)object).handleNavigationSettingsReset();
                return null;
            }
            case 91: {
                ((TargetShield)object).handleFullFacotryReset();
                return null;
            }
            case 92: {
                return RuntimeUtil.valueOf(((TargetShield)object).isWaitingForTryMatchLocationResults());
            }
            case 93: {
                return ((TargetShield)object).getResultListHandler();
            }
            case 94: {
                ((TargetShield)object).setSelectedSearchResultFromExternal((NavLocation)objectArray[0], (Integer)objectArray[1]);
                return null;
            }
            case 95: {
                ((TargetShield)object).setAllowReceivingEvents((Boolean)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((TargetShield)object).initXt9Finished();
                return null;
            }
            case 97: {
                ((TargetShield)object).setSearchResult((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue(), (NavLocation)objectArray[2], (Boolean)objectArray[3], (NavLocation)objectArray[4], (Boolean)objectArray[5]);
                return null;
            }
            case 98: {
                ((TargetShield)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 99: {
                ((TargetShield)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 100: {
                ((TargetShield)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 101: {
                ((TargetShield)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 102: {
                ((TargetShield)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 103: {
                ((TargetShield)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 104: {
                ((TargetShield)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 105: {
                ((TargetShield)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 106: {
                ((TargetShield)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 107: {
                ((TargetShield)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 108: {
                ((TargetShield)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 109: {
                ((TargetShield)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 110: {
                ((TargetShield)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 111: {
                ((TargetShield)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 112: {
                ((TargetShield)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 113: {
                ((TargetShield)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 114: {
                ((TargetShield)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 115: {
                ((TargetShield)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 116: {
                ((TargetShield)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 117: {
                ((TargetShield)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 118: {
                ((TargetShield)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 119: {
                ((TargetShield)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 120: {
                ((TargetShield)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 121: {
                ((TargetShield)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 122: {
                ((TargetShield)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 123: {
                ((TargetShield)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 124: {
                ((TargetShield)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 125: {
                ((TargetShield)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 126: {
                ((TargetShield)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 127: {
                ((TargetShield)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((TargetShield)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 129: {
                ((TargetShield)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 130: {
                ((TargetShield)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 131: {
                ((TargetShield)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 132: {
                ((TargetShield)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 133: {
                ((TargetShield)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 134: {
                ((TargetShield)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 135: {
                ((TargetShield)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 136: {
                ((TargetShield)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 137: {
                ((TargetShield)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 138: {
                ((SldeProxyTarget)object).spellerTextChanged((SpellerData)objectArray[0]);
                return null;
            }
            case 139: {
                ((SldeProxyTarget)object).initXt9Finished();
                return null;
            }
            case 140: {
                ((SldeProxyTarget)object).spellerDataChanged((SpellerData)objectArray[0]);
                return null;
            }
            case 141: {
                ((SldeProxyTarget)object).reloadPersistedData();
                return null;
            }
            case 142: {
                ((SldeSpellerDsiHandler)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 143: {
                ((SldeSpellerDsiHandler)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 144: {
                ((SldeSpellerDsiHandler)object).handleHwrSpellerModeEnabled((EventGeneric)objectArray[0]);
                return null;
            }
            case 145: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 146: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 147: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 148: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 149: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 150: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 151: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 152: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 153: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 154: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 155: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 156: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 157: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 158: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 159: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 161: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 162: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 163: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 164: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 165: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 166: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 167: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 168: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 169: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 170: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 171: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 172: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 173: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 174: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 175: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 176: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 177: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 178: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 179: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 180: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 181: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 182: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 183: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 184: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 185: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 186: {
                ((SldeSpellerDsiHandler)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 187: {
                return SldeSpellerHandler.getInstance();
            }
            case 188: {
                ((SldeSpellerHandler)object).setCursorPosition((EventGeneric)objectArray[0]);
                return null;
            }
            case 189: {
                ((SldeSpellerHandler)object).setMatchCompletion((String)objectArray[0]);
                return null;
            }
            case 190: {
                ((SldeSpellerHandler)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 191: {
                ((SldeSpellerHandler)object).initXt9((NavLocation)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f6(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 192: {
                return RuntimeUtil.valueOf(((SldeSpellerHandler)object).isSpellerTextEmpty());
            }
            case 193: {
                return ((SldeSpellerHandler)object).getSpellerData();
            }
            case 194: {
                ((SldeSpellerHandler)object).addCharacters((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 195: {
                ((SldeSpellerHandler)object).addCharacters((EventGeneric)objectArray[0]);
                return null;
            }
            case 196: {
                ((SldeSpellerHandler)object).addSpellerTextChangedListener((SpellerDataChangedListener)objectArray[0]);
                return null;
            }
            case 197: {
                ((SldeSpellerHandler)object).handleHwrSpellerModeEnabled((EventGeneric)objectArray[0]);
                return null;
            }
            case 198: {
                ((SldeSpellerHandler)object).clearSpellerData();
                return null;
            }
            case 199: {
                ((SldeSpellerHandler)object).addSpellerDataChangedListener((SpellerDataChangedListener)objectArray[0]);
                return null;
            }
            case 200: {
                ((SldeSpellerHandler)object).removeSpellerDataChangedListener((SpellerDataChangedListener)objectArray[0]);
                return null;
            }
            case 201: {
                ((SldeSpellerHandler)object).removeSpellerTextChangedListener((SpellerDataChangedListener)objectArray[0]);
                return null;
            }
            case 202: {
                ((SldeSpellerHandler)object).removeSuggestion();
                return null;
            }
            case 203: {
                ((SldeSpellerHandler)object).deleteCharacter();
                return null;
            }
            case 204: {
                ((SldeSpellerHandler)object).deleteAllCharacters();
                return null;
            }
            case 205: {
                ((SldeSpellerHandler)object).clearSelection();
                return null;
            }
            case 206: {
                ((SldeSpellerHandler)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 207: {
                ((SldeSpellerHandler)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 208: {
                ((SldeSpellerHandler)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 209: {
                ((SldeSpellerHandler)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 210: {
                ((SldeSpellerHandler)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 211: {
                ((SldeSpellerHandler)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 212: {
                ((SldeSpellerHandler)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 213: {
                ((SldeSpellerHandler)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 214: {
                ((SldeSpellerHandler)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 215: {
                ((SldeSpellerHandler)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 216: {
                ((SldeSpellerHandler)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 217: {
                ((SldeSpellerHandler)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 218: {
                ((SldeSpellerHandler)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 219: {
                ((SldeSpellerHandler)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 220: {
                ((SldeSpellerHandler)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 221: {
                ((SldeSpellerHandler)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 222: {
                ((SldeSpellerHandler)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 223: {
                ((SldeSpellerHandler)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f7(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 224: {
                ((SldeSpellerHandler)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 225: {
                ((SldeSpellerHandler)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 226: {
                ((SldeSpellerHandler)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 227: {
                ((SldeSpellerHandler)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 228: {
                ((SldeSpellerHandler)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 229: {
                ((SldeSpellerHandler)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 230: {
                ((SldeSpellerHandler)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 231: {
                ((SldeSpellerHandler)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 232: {
                ((SldeSpellerHandler)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 233: {
                ((SldeSpellerHandler)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 234: {
                ((SldeSpellerHandler)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 235: {
                ((SldeSpellerHandler)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 236: {
                ((SldeSpellerHandler)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 237: {
                ((SldeSpellerHandler)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 238: {
                ((SldeSpellerHandler)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 239: {
                ((SldeSpellerHandler)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 240: {
                ((SldeSpellerHandler)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 241: {
                ((SldeSpellerHandler)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 242: {
                ((SldeSpellerHandler)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 243: {
                ((SldeSpellerHandler)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 244: {
                ((SldeSpellerHandler)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 245: {
                ((SldeSpellerHandler)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 246: {
                ((SldeSpellerHandler)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
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
                case 7: {
                    return this.f7(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

