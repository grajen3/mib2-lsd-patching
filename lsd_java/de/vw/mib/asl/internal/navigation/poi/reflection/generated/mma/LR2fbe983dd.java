/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.reflection.generated.mma;

import de.vw.mib.asl.api.navigation.poi.IPoiOnboardSearchResultListener;
import de.vw.mib.asl.api.navigation.poi.IPoiOnlineSearchResultListener;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.Command;
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
import de.vw.mib.asl.internal.navigation.poi.jpn.PoiJpnTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.PoiTargetFuelWarning;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.HsmTargetBattery;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiSDSTarget;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget;
import de.vw.mib.asl.internal.navigation.poi.setup.HsmTargetPoiSetupFuelOptions;
import de.vw.mib.asl.internal.navigation.poi.setup.HsmTargetPoiSetupMapCategories;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.HsmTargetPoiSetupMapThreeLevelCategories;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupMultiLevelPoiListCollector;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public final class LR2fbe983dd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2017642719: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1716359698: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1693891804: {
                if (bl) {
                    if (n2 != -448785786) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -1516718953: {
                if (bl) {
                    if (n2 != 930100107) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1453706226: {
                if (bl) {
                    if (n2 != 1186915237) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -663517209: {
                if (bl) {
                    if (n2 != 1186915237) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 115927446: {
                if (bl) {
                    if (n2 != 728228330) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 328559045: {
                if (bl) {
                    if (n2 != 1381362322) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 912688495: {
                if (bl) {
                    if (n2 != 47388850) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 1242260271: {
                if (bl) {
                    if (n2 != 941815946) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1256096364: {
                if (bl) {
                    if (n2 != 941815946) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1426115117: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1485013553: {
                if (bl) {
                    if (n2 != 1163392726) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 1498849646: {
                if (bl) {
                    if (n2 != 1163392726) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 1512614019: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1834127156: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 1844501277: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 2098019436: {
                if (bl) {
                    if (n2 != -665529320) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -66038698: {
                if (bl) {
                    if (n2 != 785816057) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 1358541925: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 1625098718: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1994008442: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -1759188960: {
                if (bl) {
                    if (n2 != 1163392726) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1516723141: {
                if (bl) {
                    if (n2 != 941815946) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != 1163392726) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 1948306687: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case -1716359698: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 115927446: {
                if (bl) {
                    if (n2 != 1871085702) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 1242260271: {
                if (bl) {
                    if (n2 != 941815946) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 1256096364: {
                if (bl) {
                    if (n2 != 941815946) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 1426115117: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 1485013553: {
                if (bl) {
                    if (n2 != 1163392726) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1498849646: {
                if (bl) {
                    if (n2 != 1163392726) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 1834127156: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
        }
        return n3;
    }

    private int a5(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2134688367: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case -142493909: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case 723742767: {
                if (bl) {
                    if (n2 != -260983825) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 1550912691: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case 2083726120: {
                if (bl) {
                    if (n2 != -260983825) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 2114572485: {
                if (bl) {
                    if (n2 != 2014368050) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
        }
        return n3;
    }

    private int a6(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2134688367: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 189;
                    break;
                }
                n3 = 189;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case -1247496836: {
                if (bl) {
                    if (n2 != 664485980) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
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
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case -441565393: {
                if (bl) {
                    if (n2 != 554665125) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 185;
                    break;
                }
                n3 = 185;
                break;
            }
            case -144940140: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case -142493909: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 187;
                    break;
                }
                n3 = 187;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 190;
                    break;
                }
                n3 = 190;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 184;
                    break;
                }
                n3 = 184;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 188;
                    break;
                }
                n3 = 188;
                break;
            }
            case 609700894: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 179;
                    break;
                }
                n3 = 179;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 1273409167: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 1550912691: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case 1916002242: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 186;
                    break;
                }
                n3 = 186;
                break;
            }
            case 2114572485: {
                if (bl) {
                    if (n2 != 2014368050) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
        }
        return n3;
    }

    private int a7(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 191;
                    break;
                }
                n3 = 191;
                break;
            }
            case 1426115117: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 192;
                    break;
                }
                n3 = 192;
                break;
            }
        }
        return n3;
    }

    private int a8(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 193;
                    break;
                }
                n3 = 193;
                break;
            }
        }
        return n3;
    }

    private int a9(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1459880413: {
                if (bl) {
                    if (n2 != 1741484205) break;
                    n3 = 196;
                    break;
                }
                n3 = 196;
                break;
            }
            case -1077557351: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 199;
                    break;
                }
                n3 = 199;
                break;
            }
            case -423269597: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 195;
                    break;
                }
                n3 = 195;
                break;
            }
            case -58459958: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 194;
                    break;
                }
                n3 = 194;
                break;
            }
            case 488004116: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 197;
                    break;
                }
                n3 = 197;
                break;
            }
            case 1244919775: {
                if (bl) {
                    if (n2 != -1985511187) break;
                    n3 = 198;
                    break;
                }
                n3 = 198;
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
            case -1762923199: {
                n2 = this.a8(n4, bl, n);
                break;
            }
            case -1470095064: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case -1119006888: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -515179101: {
                n2 = this.a5(n4, bl, n);
                break;
            }
            case -145430095: {
                n2 = this.a7(n4, bl, n);
                break;
            }
            case 274632970: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case 515229483: {
                n2 = this.a6(n4, bl, n);
                break;
            }
            case 565929403: {
                n2 = this.a9(n4, bl, n);
                break;
            }
            case 1400667411: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1653525454: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((PoiJpnTarget)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 1: {
                ((PoiJpnTarget)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 2: {
                ((PoiJpnTarget)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 3: {
                ((PoiJpnTarget)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 4: {
                ((PoiJpnTarget)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 5: {
                ((PoiJpnTarget)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 6: {
                ((PoiJpnTarget)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 7: {
                ((PoiJpnTarget)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 8: {
                ((PoiJpnTarget)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 9: {
                ((PoiJpnTarget)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 10: {
                ((PoiJpnTarget)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 11: {
                ((PoiJpnTarget)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 12: {
                ((PoiJpnTarget)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 13: {
                ((PoiJpnTarget)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 14: {
                ((PoiJpnTarget)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 15: {
                ((PoiJpnTarget)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 16: {
                ((PoiJpnTarget)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 17: {
                ((PoiJpnTarget)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 18: {
                ((PoiJpnTarget)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 19: {
                ((PoiJpnTarget)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 20: {
                ((PoiJpnTarget)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 21: {
                ((PoiJpnTarget)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 22: {
                ((PoiJpnTarget)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 23: {
                ((PoiJpnTarget)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 24: {
                ((PoiJpnTarget)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 25: {
                ((PoiJpnTarget)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 26: {
                ((PoiJpnTarget)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 27: {
                ((PoiJpnTarget)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 28: {
                ((PoiJpnTarget)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 29: {
                ((PoiJpnTarget)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 30: {
                ((PoiJpnTarget)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 31: {
                ((PoiJpnTarget)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((PoiJpnTarget)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 33: {
                ((PoiJpnTarget)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 34: {
                ((PoiJpnTarget)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 35: {
                ((PoiJpnTarget)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 36: {
                ((PoiJpnTarget)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 37: {
                ((PoiJpnTarget)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 38: {
                ((PoiJpnTarget)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 39: {
                ((PoiJpnTarget)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 40: {
                ((PoiJpnTarget)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 41: {
                ((PoiJpnTarget)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 42: {
                ((PoiHsmTarget)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 43: {
                ((PoiHsmTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 44: {
                return ((PoiHsmTarget)object).makeTrace((AbstractHsmState)objectArray[0]);
            }
            case 45: {
                return ((PoiHsmTarget)object).getDsiNavigation();
            }
            case 46: {
                PoiHsmTarget.registerPoiOnboardSearchResultListener((IPoiOnboardSearchResultListener)objectArray[0]);
                return null;
            }
            case 47: {
                PoiHsmTarget.unregisterPoiOnboardSearchResultListener((IPoiOnboardSearchResultListener)objectArray[0]);
                return null;
            }
            case 48: {
                PoiHsmTarget.handleOnboardPoiStatusResult((ValueListStatus)objectArray[0]);
                return null;
            }
            case 49: {
                PoiHsmTarget.handleOnboardValueList((LIValueList)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                PoiHsmTarget.handleOnboardPoiResult((NavLocation)objectArray[0]);
                return null;
            }
            case 51: {
                return ((PoiHsmTarget)object).makeError((AbstractHsmState)objectArray[0]);
            }
            case 52: {
                ((PoiHsmTarget)object).myTrace((AbstractHsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 53: {
                ((PoiHsmTarget)object).myError((AbstractHsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 54: {
                ((PoiHsmTarget)object).myCmdTrace((AbstractHsmState)objectArray[0], (Command)objectArray[1]);
                return null;
            }
            case 55: {
                ((PoiHsmTarget)object).handleLIResult((AbstractHsmState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                return RuntimeUtil.valueOf(((PoiHsmTarget)object).selectCriterionInPOIValueList((PoiAbstractHsmState)objectArray[0], (LIValueList)objectArray[1], ((Number)objectArray[2]).intValue()));
            }
            case 57: {
                ((PoiHsmTarget)object).clearAllModelData();
                return null;
            }
            case 58: {
                ((PoiHsmTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((PoiHsmTarget)object).setSortOrder((Boolean)objectArray[0]);
                return null;
            }
            case 60: {
                ((PoiHsmTarget)object).initXt9OnboardFinished();
                return null;
            }
            case 61: {
                ((PoiHsmTarget)object).setLiValueListWindowSize((PoiAbstractHsmState)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 62: {
                return RuntimeUtil.valueOf(((PoiHsmTarget)object).getLastLiValueWindowSize());
            }
            case 63: {
                ((PoiTargetFuelWarning)object).reset((HashMap)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((PoiTargetFuelWarning)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((PoiTargetFuelWarning)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 66: {
                ((PoiTargetFuelWarning)object).traceState((String)objectArray[0]);
                return null;
            }
            case 67: {
                ((PoiTargetFuelWarning)object).errorState((String)objectArray[0]);
                return null;
            }
            case 68: {
                ((PoiTargetFuelWarning)object).dsiGeneralVehicleStatesUpdateTankInfo((TankInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((PoiTargetFuelWarning)object).handleNavigationSettingsReset();
                return null;
            }
            case 70: {
                ((HsmTargetBattery)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 71: {
                ((HsmTargetBattery)object).traceState((AbstractHsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 72: {
                ((HsmTargetBattery)object).warnState((AbstractHsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 73: {
                ((HsmTargetBattery)object).initDSI();
                return null;
            }
            case 74: {
                ((HsmTargetBattery)object).resetGuidanceData();
                return null;
            }
            case 75: {
                ((HsmTargetBattery)object).preventValueInconsistence((AbstractHsmState)objectArray[0]);
                return null;
            }
            case 76: {
                ((PPoiHsmTarget)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 77: {
                ((PPoiHsmTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 78: {
                return ((PPoiHsmTarget)object).getDsiNavigation();
            }
            case 79: {
                ((PPoiHsmTarget)object).clearAllModelData();
                return null;
            }
            case 80: {
                ((PPoiHsmTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 81: {
                ((PPoiHsmTarget)object).setLiValueListWindowSize((PPoiAbstractHsmState)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 82: {
                return RuntimeUtil.valueOf(((PPoiHsmTarget)object).getLastLiValueWindowSize());
            }
            case 83: {
                return ((PPoiHsmTarget)object).makeTrace((AbstractHsmState)objectArray[0]);
            }
            case 84: {
                return ((PPoiHsmTarget)object).makeError((AbstractHsmState)objectArray[0]);
            }
            case 85: {
                ((PPoiHsmTarget)object).myTrace((AbstractHsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 86: {
                ((PPoiHsmTarget)object).myError((AbstractHsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 87: {
                ((OnlinePoiSDSTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 88: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 89: {
                ((OnlinePoiSDSTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 90: {
                return RuntimeUtil.valueOf(OnlinePoiSDSTarget.isOnlinePoiReady());
            }
            case 91: {
                OnlinePoiSDSTarget.registerPoiOnlineSearchResultListener((IPoiOnlineSearchResultListener)objectArray[0]);
                return null;
            }
            case 92: {
                OnlinePoiSDSTarget.unregisterPoiOnlineSearchResultListener((IPoiOnlineSearchResultListener)objectArray[0]);
                return null;
            }
            case 93: {
                ((OnlinePoiSDSTarget)object).dsiPoiOnlineSearchPoiResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 94: {
                ((OnlinePoiSDSTarget)object).dsiPoiOnlineSearchPoiValueList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (PoiOnlineSearchValuelist)objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 95: {
                ((OnlinePoiSDSTarget)object).dsiPoiOnlineSearchAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 97: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 98: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 99: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 100: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 101: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 102: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 103: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 104: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 105: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 106: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 107: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 108: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 109: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 110: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 111: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 112: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 113: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 114: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 115: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 116: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 117: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 118: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 119: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 120: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 121: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 122: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 123: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 124: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 125: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 126: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 127: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 129: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 130: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 131: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 132: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 133: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 134: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 135: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 136: {
                ((OnlinePoiSDSTarget)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 137: {
                ((OnlinePoiTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 138: {
                ((OnlinePoiTarget)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 139: {
                ((OnlinePoiTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 140: {
                return RuntimeUtil.valueOf(OnlinePoiTarget.isOnlinePoiReady());
            }
            case 141: {
                ((OnlinePoiTarget)object).dsiPoiOnlineSearchPoiResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 142: {
                ((OnlinePoiTarget)object).dsiPoiOnlineSearchPoiValueList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (PoiOnlineSearchValuelist)objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 143: {
                ((OnlinePoiTarget)object).dsiPoiOnlineSearchAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 144: {
                ((OnlinePoiTarget)object).updateSearchPosition();
                return null;
            }
            case 145: {
                ((OnlinePoiTarget)object).dsiPoiOnlineSearchPrecheckDynamicPOICategoryResponse(((Number)objectArray[0]).intValue(), (OSRServiceState)objectArray[1]);
                return null;
            }
            case 146: {
                ((OnlinePoiTarget)object).dsiNavigationLiTryMatchLocationResult((TryMatchLocationResultData[])objectArray[0]);
                return null;
            }
            case 147: {
                ((OnlinePoiTarget)object).initXt9Finished();
                return null;
            }
            case 148: {
                return ((OnlinePoiTarget)object).getSelectedOnlinePoiUrl();
            }
            case 149: {
                ((OnlinePoiTarget)object).updateServiceStatusOnChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 150: {
                ((OnlinePoiTarget)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 151: {
                ((OnlinePoiTarget)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 152: {
                ((OnlinePoiTarget)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 153: {
                ((OnlinePoiTarget)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 154: {
                ((OnlinePoiTarget)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 155: {
                ((OnlinePoiTarget)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 156: {
                ((OnlinePoiTarget)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 157: {
                ((OnlinePoiTarget)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 158: {
                ((OnlinePoiTarget)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 159: {
                ((OnlinePoiTarget)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((OnlinePoiTarget)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 161: {
                ((OnlinePoiTarget)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 162: {
                ((OnlinePoiTarget)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 163: {
                ((OnlinePoiTarget)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 164: {
                ((OnlinePoiTarget)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 165: {
                ((OnlinePoiTarget)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 166: {
                ((OnlinePoiTarget)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 167: {
                ((OnlinePoiTarget)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 168: {
                ((OnlinePoiTarget)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 169: {
                ((OnlinePoiTarget)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 170: {
                ((OnlinePoiTarget)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 171: {
                ((OnlinePoiTarget)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 172: {
                ((OnlinePoiTarget)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 173: {
                ((OnlinePoiTarget)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 174: {
                ((OnlinePoiTarget)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 175: {
                ((OnlinePoiTarget)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 176: {
                ((OnlinePoiTarget)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 177: {
                ((OnlinePoiTarget)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 178: {
                ((OnlinePoiTarget)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 179: {
                ((OnlinePoiTarget)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 180: {
                ((OnlinePoiTarget)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 181: {
                ((OnlinePoiTarget)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 182: {
                ((OnlinePoiTarget)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 183: {
                ((OnlinePoiTarget)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 184: {
                ((OnlinePoiTarget)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 185: {
                ((OnlinePoiTarget)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 186: {
                ((OnlinePoiTarget)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 187: {
                ((OnlinePoiTarget)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 188: {
                ((OnlinePoiTarget)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 189: {
                ((OnlinePoiTarget)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 190: {
                ((OnlinePoiTarget)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 191: {
                ((HsmTargetPoiSetupFuelOptions)object).reset((HashMap)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f6(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 192: {
                return ((HsmTargetPoiSetupFuelOptions)object).getDsiNavigation();
            }
            case 193: {
                ((HsmTargetPoiSetupMapCategories)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 194: {
                ((HsmTargetPoiSetupMapThreeLevelCategories)object).deleteAllCategorySelectionsAndUpdateDsi();
                return null;
            }
            case 195: {
                ((HsmTargetPoiSetupMapThreeLevelCategories)object).updateCategorySelections((int[])objectArray[0]);
                return null;
            }
            case 196: {
                ((HsmTargetPoiSetupMapThreeLevelCategories)object).togglePoiCategoryAndUpdateDsi((PoiSetupMultiLevelPoiListCollector)objectArray[0]);
                return null;
            }
            case 197: {
                ((HsmTargetPoiSetupMapThreeLevelCategories)object).traceIfEnabled((String)objectArray[0]);
                return null;
            }
            case 198: {
                ((HsmTargetPoiSetupMapThreeLevelCategories)object).handleIconCacheUpdate((IconKey)objectArray[0], (ResourceLocator)objectArray[1], objectArray[2]);
                return null;
            }
            case 199: {
                return ((HsmTargetPoiSetupMapThreeLevelCategories)object).getDefaultIcon();
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

