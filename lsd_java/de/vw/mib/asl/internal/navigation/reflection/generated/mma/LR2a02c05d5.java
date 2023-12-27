/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.reflection.generated.mma;

import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListener;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListener;
import de.vw.mib.asl.api.navigation.map.NavigationMapListener;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapListener;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListener;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiListener;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListener;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficListener;
import de.vw.mib.asl.internal.navigation.api.impl.TargetASLNavigationServices;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavServiceLockable;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.map.NavigationMapServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.has.HsmTargetHas;
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
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.tmc.TrafficSource;

public final class LR2a02c05d5
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -2060994966: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
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
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1598005142: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1483787168: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1080060518: {
                if (bl) {
                    if (n2 != 815571355) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
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
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -376697182: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -252471458: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 363915840: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 392034375: {
                if (bl) {
                    if (n2 != 1420063289) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 614631194: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
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
            case 727335687: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 916038131: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1545094941: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 1803947196: {
                if (bl) {
                    if (n2 != 1349647600) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 2021804471: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 2114464324: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2138113217: {
                if (bl) {
                    if (n2 != -798997638) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case -2074577315: {
                if (bl) {
                    if (n2 != 1439836971) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -2046744643: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case -1918655273: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -1859525816: {
                if (bl) {
                    if (n2 != 22846106) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
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
            case -1609988129: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case -1382089000: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -1295859649: {
                if (bl) {
                    if (n2 != -93015095) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case -1190093268: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case -988338198: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -965536487: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
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
            case -940458235: {
                if (bl) {
                    if (n2 != 2010712203) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -808405881: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case -620118273: {
                if (bl) {
                    if (n2 != -1592768782) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case -467875849: {
                if (bl) {
                    if (n2 != 865013595) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -329399767: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case -171673451: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case -48786765: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case 57579672: {
                if (bl) {
                    if (n2 != -2070299083) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 84172398: {
                if (bl) {
                    if (n2 != 746133882) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 97432157: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case 161315793: {
                if (bl) {
                    if (n2 != -160064680) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 214873097: {
                if (bl) {
                    if (n2 != 551617679) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 305157592: {
                if (bl) {
                    if (n2 != -172729914) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 429643615: {
                if (bl) {
                    if (n2 != 667967026) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case 699408686: {
                if (bl) {
                    if (n2 != 865013595) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 700751342: {
                if (bl) {
                    if (n2 != -906693603) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 732666517: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 793816343: {
                if (bl) {
                    if (n2 != -137167945) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case 979970530: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 981412610: {
                if (bl) {
                    if (n2 != 1385999773) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 1369836373: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case 1545094941: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 1592414331: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 1594418672: {
                if (bl) {
                    if (n2 != -160064680) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
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
            case 1774592093: {
                if (bl) {
                    if (n2 != -15098812) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 1857184171: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case 1957644094: {
                if (bl) {
                    if (n2 != -730199412) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case 1969126943: {
                if (bl) {
                    if (n2 != -160064680) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 1978663920: {
                if (bl) {
                    if (n2 != -160064680) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 2115063637: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != 1163392726) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
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
            case -1941256251: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -415554369: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -122042597: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((TargetASLNavigationServices)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((TargetASLNavigationServices)object).dsiNavigationUpdateRgRouteCalculationState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((TargetASLNavigationServices)object).dsiNavigationUpdateRgActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((TargetASLNavigationServices)object).dsiNavigationUpdateNavstateOfOperation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((TargetASLNavigationServices)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 5: {
                ((TargetASLNavigationServices)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 6: {
                ((TargetASLNavigationServices)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 7: {
                ((TargetASLNavigationServices)object).dsiAdbEditUpdateNewPublicProfileEntryAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((TargetASLNavigationServices)object).dsiAdbEditInsertEntryResult(((Number)objectArray[0]).intValue(), (AdbEntry)objectArray[1]);
                return null;
            }
            case 9: {
                ((TargetASLNavigationServices)object).dsiAdbEditAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((TargetASLNavigationServices)object).dsiAdbListGetViewWindowResult(((Number)objectArray[0]).intValue(), (DataSet[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((TargetASLNavigationServices)object).dsiAdbListInvalidData(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((TargetASLNavigationServices)object).dsiAdbListUpdateViewSize((AdbViewSize)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((TargetASLNavigationServices)object).dsiAdbInitUpdateMaxLocalEntries(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((TargetASLNavigationServices)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                return RuntimeUtil.valueOf(((TargetASLNavigationServices)object).isNewEntryAvailable());
            }
            case 16: {
                ((TargetASLNavigationServices)object).setNewEntryAvailable((Boolean)objectArray[0]);
                return null;
            }
            case 17: {
                return ((TargetASLNavigationServices)object).getStartGudiancePhoneNumber();
            }
            case 18: {
                ((TargetASLNavigationServices)object).setStartGudiancePhoneNumber((String)objectArray[0]);
                return null;
            }
            case 19: {
                ((TargetASLNavigationServices)object).navStartupStatusChanged();
                return null;
            }
            case 20: {
                ((TargetASLNavigationServices)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 21: {
                ((TargetASLNavigationServices)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 22: {
                ((TargetASLNavigationServices)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 23: {
                ((TargetASLNavigationServices)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 24: {
                ((TargetASLNavigationServices)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 25: {
                ((TargetASLNavigationServices)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 26: {
                ((TargetASLNavigationServices)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 27: {
                ((TargetASLNavigationServices)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 28: {
                ((TargetASLNavigationServices)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 29: {
                ((TargetASLNavigationServices)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 30: {
                ((TargetASLNavigationServices)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 31: {
                ((TargetASLNavigationServices)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((TargetASLNavigationServices)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 33: {
                ((TargetASLNavigationServices)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 34: {
                ((TargetASLNavigationServices)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 35: {
                ((TargetASLNavigationServices)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 36: {
                ((TargetASLNavigationServices)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 37: {
                ((TargetASLNavigationServices)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 38: {
                ((TargetASLNavigationServices)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 39: {
                ((TargetASLNavigationServices)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 40: {
                ((TargetASLNavigationServices)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 41: {
                ((TargetASLNavigationServices)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 42: {
                ((TargetASLNavigationServices)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 43: {
                ((TargetASLNavigationServices)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 44: {
                ((TargetASLNavigationServices)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 45: {
                ((TargetASLNavigationServices)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 46: {
                ((TargetASLNavigationServices)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 47: {
                ((TargetASLNavigationServices)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 48: {
                ((TargetASLNavigationServices)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 49: {
                ((TargetASLNavigationServices)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 50: {
                ((TargetASLNavigationServices)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 51: {
                ((TargetASLNavigationServices)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 52: {
                ((TargetASLNavigationServices)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 53: {
                ((TargetASLNavigationServices)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 54: {
                ((TargetASLNavigationServices)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 55: {
                ((TargetASLNavigationServices)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 56: {
                ((TargetASLNavigationServices)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 57: {
                ((TargetASLNavigationServices)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 58: {
                ((TargetASLNavigationServices)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 59: {
                ((NavigationExtServiceImpl)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 60: {
                ((NavigationExtServiceImpl)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((NavigationExtServiceImpl)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((NavigationExtServiceImpl)object).navStartupStatusChanged();
                return null;
            }
            case 63: {
                ((NavigationExtServiceImpl)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).isMapServiceLockedByMe((NavigationMapServiceImpl)objectArray[0]));
            }
            case 65: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).isMapServiceLocked());
            }
            case 66: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).isLocationinputServiceLockedByMe((NavigationLocationinputServiceImpl)objectArray[0]));
            }
            case 67: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).isLocationinputServiceLocked());
            }
            case 68: {
                ((NavigationExtServiceImpl)object).acquireLocationinputLock(((Number)objectArray[0]).intValue(), (INavServiceLockable)objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 69: {
                ((NavigationExtServiceImpl)object).releaseLocationinputLock((INavServiceLockable)objectArray[0]);
                return null;
            }
            case 70: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).getNavigationServiceState());
            }
            case 71: {
                return ((NavigationExtServiceImpl)object).getNavigationGuidanceService((NavigationGuidanceListener)objectArray[0]);
            }
            case 72: {
                return ((NavigationExtServiceImpl)object).getNavigationMemoryService((NavigationMemoryListener)objectArray[0]);
            }
            case 73: {
                return ((NavigationExtServiceImpl)object).getNavigationLocationinputService((NavigationLocationinputListener)objectArray[0]);
            }
            case 74: {
                return ((NavigationExtServiceImpl)object).getNavigationMapService((NavigationMapListener)objectArray[0]);
            }
            case 75: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).getGuidanceState());
            }
            case 76: {
                return ((NavigationExtServiceImpl)object).getCalculationStates();
            }
            case 77: {
                return ((NavigationExtServiceImpl)object).getCalculationProgress();
            }
            case 78: {
                return ((NavigationExtServiceImpl)object).getCalculationRouteIds();
            }
            case 79: {
                ((NavigationExtServiceImpl)object).tryLockMapViwer((NavigationMapServiceImpl)objectArray[0]);
                return null;
            }
            case 80: {
                ((NavigationExtServiceImpl)object).checkLockMapViewer((NavigationMapServiceImpl)objectArray[0]);
                return null;
            }
            case 81: {
                ((NavigationExtServiceImpl)object).unlockMapViewer((NavigationMapServiceImpl)objectArray[0]);
                return null;
            }
            case 82: {
                ((NavigationExtServiceImpl)object).initDsiTmcOnRoute();
                return null;
            }
            case 83: {
                ((NavigationExtServiceImpl)object).initDsiTmc();
                return null;
            }
            case 84: {
                ((NavigationExtServiceImpl)object).initDsiAsiaTrafficInfoMenu();
                return null;
            }
            case 85: {
                ((NavigationExtServiceImpl)object).initDsiNavigation();
                return null;
            }
            case 86: {
                ((NavigationExtServiceImpl)object).dsiNavigationUpdateDmLastDestinationsList((LDListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 87: {
                ((NavigationExtServiceImpl)object).dsiAsiaTrafficInfoMenuUpdateReceivableStations((TunerData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 88: {
                ((NavigationExtServiceImpl)object).dsiTmcUpdateTrafficSourceInformation((TrafficSource[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((NavigationExtServiceImpl)object).dsiTmcOnRouteUpdateUrgentMessages((TmcMessage[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 90: {
                ((NavigationExtServiceImpl)object).dsiTmcOnRouteIndicateTrafficEventNoticeMap((TmcMessage)objectArray[0], (NavRectangle)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 91: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).isMapServiceReady());
            }
            case 92: {
                return ((NavigationExtServiceImpl)object).getNavigationTrafficService((NavigationTrafficListener)objectArray[0]);
            }
            case 93: {
                return ((NavigationExtServiceImpl)object).getNavigationOnlinePoiService((NavigationOnlinePoiListener)objectArray[0]);
            }
            case 94: {
                return ((NavigationExtServiceImpl)object).getNavigationOnboardPoiService((NavigationOnboardPoiListener)objectArray[0]);
            }
            case 95: {
                return ((NavigationExtServiceImpl)object).getNavigationSplitscreenService((NavigationSplitscreenListener)objectArray[0]);
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((NavigationExtServiceImpl)object).checkLockLocationInput((INavServiceLockable)objectArray[0]);
                return null;
            }
            case 97: {
                return ((NavigationExtServiceImpl)object).getICMapService((ICMapListener)objectArray[0]);
            }
            case 98: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).getMapSwitchState());
            }
            case 99: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).getMapVisibilityForFPKSwitch());
            }
            case 100: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).getICMapServiceState());
            }
            case 101: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).isMapSwitchFunctionAvailableInKombi());
            }
            case 102: {
                ((NavigationExtServiceImpl)object).setMapSwitchFunctionAvailableInKombi((Boolean)objectArray[0]);
                return null;
            }
            case 103: {
                return RuntimeUtil.valueOf(((NavigationExtServiceImpl)object).isMapTemporarilyInABT());
            }
            case 104: {
                ((NavigationExtServiceImpl)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 105: {
                ((NavigationExtServiceImpl)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 106: {
                ((NavigationExtServiceImpl)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 107: {
                ((NavigationExtServiceImpl)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 108: {
                ((NavigationExtServiceImpl)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 109: {
                ((NavigationExtServiceImpl)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 110: {
                ((NavigationExtServiceImpl)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 111: {
                ((NavigationExtServiceImpl)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 112: {
                ((NavigationExtServiceImpl)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 113: {
                ((NavigationExtServiceImpl)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 114: {
                ((NavigationExtServiceImpl)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 115: {
                ((NavigationExtServiceImpl)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 116: {
                ((NavigationExtServiceImpl)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 117: {
                ((NavigationExtServiceImpl)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 118: {
                ((NavigationExtServiceImpl)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 119: {
                ((NavigationExtServiceImpl)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 120: {
                ((NavigationExtServiceImpl)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 121: {
                ((NavigationExtServiceImpl)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 122: {
                ((NavigationExtServiceImpl)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 123: {
                ((NavigationExtServiceImpl)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 124: {
                ((NavigationExtServiceImpl)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 125: {
                ((NavigationExtServiceImpl)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 126: {
                ((NavigationExtServiceImpl)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 127: {
                ((NavigationExtServiceImpl)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((NavigationExtServiceImpl)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 129: {
                ((NavigationExtServiceImpl)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 130: {
                ((NavigationExtServiceImpl)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 131: {
                ((NavigationExtServiceImpl)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 132: {
                ((NavigationExtServiceImpl)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 133: {
                ((NavigationExtServiceImpl)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 134: {
                ((NavigationExtServiceImpl)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 135: {
                ((NavigationExtServiceImpl)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 136: {
                ((NavigationExtServiceImpl)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 137: {
                ((NavigationExtServiceImpl)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 138: {
                ((NavigationExtServiceImpl)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 139: {
                ((NavigationExtServiceImpl)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 140: {
                ((NavigationExtServiceImpl)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 141: {
                ((NavigationExtServiceImpl)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 142: {
                ((NavigationExtServiceImpl)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 143: {
                ((NavigationExtServiceImpl)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 144: {
                ((NavigationExtServiceImpl)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 145: {
                ((HsmTargetHas)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 146: {
                ((HsmTargetHas)object).traceState((AbstractHsmState)objectArray[0], (String)objectArray[1]);
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

