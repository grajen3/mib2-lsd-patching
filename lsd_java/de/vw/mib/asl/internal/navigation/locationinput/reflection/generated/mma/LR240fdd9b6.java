/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.reflection.generated.mma;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionState;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionSubject;
import de.vw.mib.asl.framework.internal.framework.asl.ReflectionStateTop;
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
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.states.NavReflectionState;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateChome;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateCity;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateCountry;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateCrossing;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateHousenumber;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateMapCode;
import de.vw.mib.asl.internal.navigation.spellerx.states.StatePhoneNumber;
import de.vw.mib.asl.internal.navigation.spellerx.states.StatePlace;
import de.vw.mib.asl.internal.navigation.spellerx.states.StatePointLocationHousenumber;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateProvince;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateState;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreet;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreet1stCity;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreet1stStreetWithBasenames;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreet1stZipCode;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreetDisambiguation;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateStreetWithBasenames;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateTop;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateWard;
import de.vw.mib.asl.internal.navigation.spellerx.states.StateZipCode;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public final class LR240fdd9b6
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != 941556127) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
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
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
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
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
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
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
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
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
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
                    n3 = 134;
                    break;
                }
                n3 = 134;
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
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
        }
        return n3;
    }

    private int a5(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 186;
                    break;
                }
                n3 = 186;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 193;
                    break;
                }
                n3 = 193;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 187;
                    break;
                }
                n3 = 187;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 185;
                    break;
                }
                n3 = 185;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 189;
                    break;
                }
                n3 = 189;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 195;
                    break;
                }
                n3 = 195;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 191;
                    break;
                }
                n3 = 191;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 194;
                    break;
                }
                n3 = 194;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 188;
                    break;
                }
                n3 = 188;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 192;
                    break;
                }
                n3 = 192;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 184;
                    break;
                }
                n3 = 184;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 183;
                    break;
                }
                n3 = 183;
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
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 190;
                    break;
                }
                n3 = 190;
                break;
            }
        }
        return n3;
    }

    private int a6(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 204;
                    break;
                }
                n3 = 204;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 210;
                    break;
                }
                n3 = 210;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 220;
                    break;
                }
                n3 = 220;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 235;
                    break;
                }
                n3 = 235;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 219;
                    break;
                }
                n3 = 219;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 224;
                    break;
                }
                n3 = 224;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 216;
                    break;
                }
                n3 = 216;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 212;
                    break;
                }
                n3 = 212;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 242;
                    break;
                }
                n3 = 242;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 221;
                    break;
                }
                n3 = 221;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 208;
                    break;
                }
                n3 = 208;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 236;
                    break;
                }
                n3 = 236;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 206;
                    break;
                }
                n3 = 206;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 229;
                    break;
                }
                n3 = 229;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 234;
                    break;
                }
                n3 = 234;
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
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 215;
                    break;
                }
                n3 = 215;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 238;
                    break;
                }
                n3 = 238;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 209;
                    break;
                }
                n3 = 209;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 200;
                    break;
                }
                n3 = 200;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 244;
                    break;
                }
                n3 = 244;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 214;
                    break;
                }
                n3 = 214;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 199;
                    break;
                }
                n3 = 199;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 201;
                    break;
                }
                n3 = 201;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 240;
                    break;
                }
                n3 = 240;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 243;
                    break;
                }
                n3 = 243;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 203;
                    break;
                }
                n3 = 203;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 218;
                    break;
                }
                n3 = 218;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 237;
                    break;
                }
                n3 = 237;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 217;
                    break;
                }
                n3 = 217;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 241;
                    break;
                }
                n3 = 241;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 233;
                    break;
                }
                n3 = 233;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 231;
                    break;
                }
                n3 = 231;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 202;
                    break;
                }
                n3 = 202;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 232;
                    break;
                }
                n3 = 232;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 228;
                    break;
                }
                n3 = 228;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 207;
                    break;
                }
                n3 = 207;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 196;
                    break;
                }
                n3 = 196;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 198;
                    break;
                }
                n3 = 198;
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
                    n3 = 211;
                    break;
                }
                n3 = 211;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 222;
                    break;
                }
                n3 = 222;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 230;
                    break;
                }
                n3 = 230;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 225;
                    break;
                }
                n3 = 225;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 197;
                    break;
                }
                n3 = 197;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 213;
                    break;
                }
                n3 = 213;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 205;
                    break;
                }
                n3 = 205;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 223;
                    break;
                }
                n3 = 223;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 239;
                    break;
                }
                n3 = 239;
                break;
            }
        }
        return n3;
    }

    private int a7(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 253;
                    break;
                }
                n3 = 253;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 259;
                    break;
                }
                n3 = 259;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 269;
                    break;
                }
                n3 = 269;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 284;
                    break;
                }
                n3 = 284;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 268;
                    break;
                }
                n3 = 268;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 273;
                    break;
                }
                n3 = 273;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 265;
                    break;
                }
                n3 = 265;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 261;
                    break;
                }
                n3 = 261;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 291;
                    break;
                }
                n3 = 291;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 270;
                    break;
                }
                n3 = 270;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 257;
                    break;
                }
                n3 = 257;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 285;
                    break;
                }
                n3 = 285;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 255;
                    break;
                }
                n3 = 255;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 278;
                    break;
                }
                n3 = 278;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 283;
                    break;
                }
                n3 = 283;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 275;
                    break;
                }
                n3 = 275;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 264;
                    break;
                }
                n3 = 264;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 287;
                    break;
                }
                n3 = 287;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 258;
                    break;
                }
                n3 = 258;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 249;
                    break;
                }
                n3 = 249;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 293;
                    break;
                }
                n3 = 293;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 263;
                    break;
                }
                n3 = 263;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 248;
                    break;
                }
                n3 = 248;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 250;
                    break;
                }
                n3 = 250;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 289;
                    break;
                }
                n3 = 289;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 292;
                    break;
                }
                n3 = 292;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 252;
                    break;
                }
                n3 = 252;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 267;
                    break;
                }
                n3 = 267;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 286;
                    break;
                }
                n3 = 286;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 266;
                    break;
                }
                n3 = 266;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 290;
                    break;
                }
                n3 = 290;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 282;
                    break;
                }
                n3 = 282;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 280;
                    break;
                }
                n3 = 280;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 251;
                    break;
                }
                n3 = 251;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 281;
                    break;
                }
                n3 = 281;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 277;
                    break;
                }
                n3 = 277;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 256;
                    break;
                }
                n3 = 256;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 245;
                    break;
                }
                n3 = 245;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 247;
                    break;
                }
                n3 = 247;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 276;
                    break;
                }
                n3 = 276;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 260;
                    break;
                }
                n3 = 260;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 271;
                    break;
                }
                n3 = 271;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 279;
                    break;
                }
                n3 = 279;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 274;
                    break;
                }
                n3 = 274;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 246;
                    break;
                }
                n3 = 246;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 262;
                    break;
                }
                n3 = 262;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 254;
                    break;
                }
                n3 = 254;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 272;
                    break;
                }
                n3 = 272;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 288;
                    break;
                }
                n3 = 288;
                break;
            }
        }
        return n3;
    }

    private int a8(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 302;
                    break;
                }
                n3 = 302;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 308;
                    break;
                }
                n3 = 308;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 318;
                    break;
                }
                n3 = 318;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 333;
                    break;
                }
                n3 = 333;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 317;
                    break;
                }
                n3 = 317;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 322;
                    break;
                }
                n3 = 322;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 314;
                    break;
                }
                n3 = 314;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 310;
                    break;
                }
                n3 = 310;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 340;
                    break;
                }
                n3 = 340;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 319;
                    break;
                }
                n3 = 319;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 306;
                    break;
                }
                n3 = 306;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 334;
                    break;
                }
                n3 = 334;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 304;
                    break;
                }
                n3 = 304;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 327;
                    break;
                }
                n3 = 327;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 332;
                    break;
                }
                n3 = 332;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 324;
                    break;
                }
                n3 = 324;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 313;
                    break;
                }
                n3 = 313;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 336;
                    break;
                }
                n3 = 336;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 307;
                    break;
                }
                n3 = 307;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 298;
                    break;
                }
                n3 = 298;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 342;
                    break;
                }
                n3 = 342;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 312;
                    break;
                }
                n3 = 312;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 297;
                    break;
                }
                n3 = 297;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 299;
                    break;
                }
                n3 = 299;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 338;
                    break;
                }
                n3 = 338;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 341;
                    break;
                }
                n3 = 341;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 301;
                    break;
                }
                n3 = 301;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 316;
                    break;
                }
                n3 = 316;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 335;
                    break;
                }
                n3 = 335;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 315;
                    break;
                }
                n3 = 315;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 339;
                    break;
                }
                n3 = 339;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 331;
                    break;
                }
                n3 = 331;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 329;
                    break;
                }
                n3 = 329;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 300;
                    break;
                }
                n3 = 300;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 330;
                    break;
                }
                n3 = 330;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 326;
                    break;
                }
                n3 = 326;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 305;
                    break;
                }
                n3 = 305;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 294;
                    break;
                }
                n3 = 294;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 296;
                    break;
                }
                n3 = 296;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 325;
                    break;
                }
                n3 = 325;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 309;
                    break;
                }
                n3 = 309;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 320;
                    break;
                }
                n3 = 320;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 328;
                    break;
                }
                n3 = 328;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 323;
                    break;
                }
                n3 = 323;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 295;
                    break;
                }
                n3 = 295;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 311;
                    break;
                }
                n3 = 311;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 303;
                    break;
                }
                n3 = 303;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 321;
                    break;
                }
                n3 = 321;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 337;
                    break;
                }
                n3 = 337;
                break;
            }
        }
        return n3;
    }

    private int a9(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 351;
                    break;
                }
                n3 = 351;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 357;
                    break;
                }
                n3 = 357;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 367;
                    break;
                }
                n3 = 367;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 382;
                    break;
                }
                n3 = 382;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 366;
                    break;
                }
                n3 = 366;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 371;
                    break;
                }
                n3 = 371;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 363;
                    break;
                }
                n3 = 363;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 359;
                    break;
                }
                n3 = 359;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 389;
                    break;
                }
                n3 = 389;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 368;
                    break;
                }
                n3 = 368;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 355;
                    break;
                }
                n3 = 355;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 383;
                    break;
                }
                n3 = 383;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 353;
                    break;
                }
                n3 = 353;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 376;
                    break;
                }
                n3 = 376;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 381;
                    break;
                }
                n3 = 381;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 373;
                    break;
                }
                n3 = 373;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 362;
                    break;
                }
                n3 = 362;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 385;
                    break;
                }
                n3 = 385;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 356;
                    break;
                }
                n3 = 356;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 347;
                    break;
                }
                n3 = 347;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 391;
                    break;
                }
                n3 = 391;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 361;
                    break;
                }
                n3 = 361;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 346;
                    break;
                }
                n3 = 346;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 348;
                    break;
                }
                n3 = 348;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 387;
                    break;
                }
                n3 = 387;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 390;
                    break;
                }
                n3 = 390;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 350;
                    break;
                }
                n3 = 350;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 365;
                    break;
                }
                n3 = 365;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 384;
                    break;
                }
                n3 = 384;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 364;
                    break;
                }
                n3 = 364;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 388;
                    break;
                }
                n3 = 388;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 380;
                    break;
                }
                n3 = 380;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 378;
                    break;
                }
                n3 = 378;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 349;
                    break;
                }
                n3 = 349;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 379;
                    break;
                }
                n3 = 379;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 375;
                    break;
                }
                n3 = 375;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 354;
                    break;
                }
                n3 = 354;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 343;
                    break;
                }
                n3 = 343;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 345;
                    break;
                }
                n3 = 345;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 374;
                    break;
                }
                n3 = 374;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 358;
                    break;
                }
                n3 = 358;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 369;
                    break;
                }
                n3 = 369;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 377;
                    break;
                }
                n3 = 377;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 372;
                    break;
                }
                n3 = 372;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 344;
                    break;
                }
                n3 = 344;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 360;
                    break;
                }
                n3 = 360;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 352;
                    break;
                }
                n3 = 352;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 370;
                    break;
                }
                n3 = 370;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 386;
                    break;
                }
                n3 = 386;
                break;
            }
        }
        return n3;
    }

    private int a10(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 400;
                    break;
                }
                n3 = 400;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 406;
                    break;
                }
                n3 = 406;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 416;
                    break;
                }
                n3 = 416;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 431;
                    break;
                }
                n3 = 431;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 415;
                    break;
                }
                n3 = 415;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 420;
                    break;
                }
                n3 = 420;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 412;
                    break;
                }
                n3 = 412;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 408;
                    break;
                }
                n3 = 408;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 438;
                    break;
                }
                n3 = 438;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 417;
                    break;
                }
                n3 = 417;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 404;
                    break;
                }
                n3 = 404;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 432;
                    break;
                }
                n3 = 432;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 402;
                    break;
                }
                n3 = 402;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 425;
                    break;
                }
                n3 = 425;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 430;
                    break;
                }
                n3 = 430;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 422;
                    break;
                }
                n3 = 422;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 411;
                    break;
                }
                n3 = 411;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 434;
                    break;
                }
                n3 = 434;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 405;
                    break;
                }
                n3 = 405;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 396;
                    break;
                }
                n3 = 396;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 440;
                    break;
                }
                n3 = 440;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 410;
                    break;
                }
                n3 = 410;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 395;
                    break;
                }
                n3 = 395;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 397;
                    break;
                }
                n3 = 397;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 436;
                    break;
                }
                n3 = 436;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 439;
                    break;
                }
                n3 = 439;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 399;
                    break;
                }
                n3 = 399;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 414;
                    break;
                }
                n3 = 414;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 433;
                    break;
                }
                n3 = 433;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 413;
                    break;
                }
                n3 = 413;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 437;
                    break;
                }
                n3 = 437;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 429;
                    break;
                }
                n3 = 429;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 427;
                    break;
                }
                n3 = 427;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 398;
                    break;
                }
                n3 = 398;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 428;
                    break;
                }
                n3 = 428;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 424;
                    break;
                }
                n3 = 424;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 403;
                    break;
                }
                n3 = 403;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 392;
                    break;
                }
                n3 = 392;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 394;
                    break;
                }
                n3 = 394;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 423;
                    break;
                }
                n3 = 423;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 407;
                    break;
                }
                n3 = 407;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 418;
                    break;
                }
                n3 = 418;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 426;
                    break;
                }
                n3 = 426;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 421;
                    break;
                }
                n3 = 421;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 393;
                    break;
                }
                n3 = 393;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 409;
                    break;
                }
                n3 = 409;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 401;
                    break;
                }
                n3 = 401;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 419;
                    break;
                }
                n3 = 419;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 435;
                    break;
                }
                n3 = 435;
                break;
            }
        }
        return n3;
    }

    private int a11(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 449;
                    break;
                }
                n3 = 449;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 455;
                    break;
                }
                n3 = 455;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 465;
                    break;
                }
                n3 = 465;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 480;
                    break;
                }
                n3 = 480;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 464;
                    break;
                }
                n3 = 464;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 469;
                    break;
                }
                n3 = 469;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 461;
                    break;
                }
                n3 = 461;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 457;
                    break;
                }
                n3 = 457;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 487;
                    break;
                }
                n3 = 487;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 466;
                    break;
                }
                n3 = 466;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 453;
                    break;
                }
                n3 = 453;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 481;
                    break;
                }
                n3 = 481;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 451;
                    break;
                }
                n3 = 451;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 474;
                    break;
                }
                n3 = 474;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 479;
                    break;
                }
                n3 = 479;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 471;
                    break;
                }
                n3 = 471;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 460;
                    break;
                }
                n3 = 460;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 483;
                    break;
                }
                n3 = 483;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 454;
                    break;
                }
                n3 = 454;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 445;
                    break;
                }
                n3 = 445;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 489;
                    break;
                }
                n3 = 489;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 459;
                    break;
                }
                n3 = 459;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 444;
                    break;
                }
                n3 = 444;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 446;
                    break;
                }
                n3 = 446;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 485;
                    break;
                }
                n3 = 485;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 488;
                    break;
                }
                n3 = 488;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 448;
                    break;
                }
                n3 = 448;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 463;
                    break;
                }
                n3 = 463;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 482;
                    break;
                }
                n3 = 482;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 462;
                    break;
                }
                n3 = 462;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 486;
                    break;
                }
                n3 = 486;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 478;
                    break;
                }
                n3 = 478;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 476;
                    break;
                }
                n3 = 476;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 447;
                    break;
                }
                n3 = 447;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 477;
                    break;
                }
                n3 = 477;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 473;
                    break;
                }
                n3 = 473;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 452;
                    break;
                }
                n3 = 452;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 441;
                    break;
                }
                n3 = 441;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 443;
                    break;
                }
                n3 = 443;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 472;
                    break;
                }
                n3 = 472;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 456;
                    break;
                }
                n3 = 456;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 467;
                    break;
                }
                n3 = 467;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 475;
                    break;
                }
                n3 = 475;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 470;
                    break;
                }
                n3 = 470;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 442;
                    break;
                }
                n3 = 442;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 458;
                    break;
                }
                n3 = 458;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 450;
                    break;
                }
                n3 = 450;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 468;
                    break;
                }
                n3 = 468;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 484;
                    break;
                }
                n3 = 484;
                break;
            }
        }
        return n3;
    }

    private int a12(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 498;
                    break;
                }
                n3 = 498;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 504;
                    break;
                }
                n3 = 504;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 514;
                    break;
                }
                n3 = 514;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 529;
                    break;
                }
                n3 = 529;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 513;
                    break;
                }
                n3 = 513;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 518;
                    break;
                }
                n3 = 518;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 510;
                    break;
                }
                n3 = 510;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 506;
                    break;
                }
                n3 = 506;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 536;
                    break;
                }
                n3 = 536;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 515;
                    break;
                }
                n3 = 515;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 502;
                    break;
                }
                n3 = 502;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 530;
                    break;
                }
                n3 = 530;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 500;
                    break;
                }
                n3 = 500;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 523;
                    break;
                }
                n3 = 523;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 528;
                    break;
                }
                n3 = 528;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 520;
                    break;
                }
                n3 = 520;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 509;
                    break;
                }
                n3 = 509;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 532;
                    break;
                }
                n3 = 532;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 503;
                    break;
                }
                n3 = 503;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 494;
                    break;
                }
                n3 = 494;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 538;
                    break;
                }
                n3 = 538;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 508;
                    break;
                }
                n3 = 508;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 493;
                    break;
                }
                n3 = 493;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 495;
                    break;
                }
                n3 = 495;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 534;
                    break;
                }
                n3 = 534;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 537;
                    break;
                }
                n3 = 537;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 497;
                    break;
                }
                n3 = 497;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 512;
                    break;
                }
                n3 = 512;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 531;
                    break;
                }
                n3 = 531;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 511;
                    break;
                }
                n3 = 511;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 535;
                    break;
                }
                n3 = 535;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 527;
                    break;
                }
                n3 = 527;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 525;
                    break;
                }
                n3 = 525;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 496;
                    break;
                }
                n3 = 496;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 526;
                    break;
                }
                n3 = 526;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 522;
                    break;
                }
                n3 = 522;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 501;
                    break;
                }
                n3 = 501;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 490;
                    break;
                }
                n3 = 490;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 492;
                    break;
                }
                n3 = 492;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 521;
                    break;
                }
                n3 = 521;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 505;
                    break;
                }
                n3 = 505;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 516;
                    break;
                }
                n3 = 516;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 524;
                    break;
                }
                n3 = 524;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 519;
                    break;
                }
                n3 = 519;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 491;
                    break;
                }
                n3 = 491;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 507;
                    break;
                }
                n3 = 507;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 499;
                    break;
                }
                n3 = 499;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 517;
                    break;
                }
                n3 = 517;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 533;
                    break;
                }
                n3 = 533;
                break;
            }
        }
        return n3;
    }

    private int a13(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 547;
                    break;
                }
                n3 = 547;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 553;
                    break;
                }
                n3 = 553;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 563;
                    break;
                }
                n3 = 563;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 578;
                    break;
                }
                n3 = 578;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 562;
                    break;
                }
                n3 = 562;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 567;
                    break;
                }
                n3 = 567;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 559;
                    break;
                }
                n3 = 559;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 555;
                    break;
                }
                n3 = 555;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 585;
                    break;
                }
                n3 = 585;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 564;
                    break;
                }
                n3 = 564;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 551;
                    break;
                }
                n3 = 551;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 579;
                    break;
                }
                n3 = 579;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 549;
                    break;
                }
                n3 = 549;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 572;
                    break;
                }
                n3 = 572;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 577;
                    break;
                }
                n3 = 577;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 569;
                    break;
                }
                n3 = 569;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 558;
                    break;
                }
                n3 = 558;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 581;
                    break;
                }
                n3 = 581;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 552;
                    break;
                }
                n3 = 552;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 543;
                    break;
                }
                n3 = 543;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 587;
                    break;
                }
                n3 = 587;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 557;
                    break;
                }
                n3 = 557;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 542;
                    break;
                }
                n3 = 542;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 544;
                    break;
                }
                n3 = 544;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 583;
                    break;
                }
                n3 = 583;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 586;
                    break;
                }
                n3 = 586;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 546;
                    break;
                }
                n3 = 546;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 561;
                    break;
                }
                n3 = 561;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 580;
                    break;
                }
                n3 = 580;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 560;
                    break;
                }
                n3 = 560;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 584;
                    break;
                }
                n3 = 584;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 576;
                    break;
                }
                n3 = 576;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 574;
                    break;
                }
                n3 = 574;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 545;
                    break;
                }
                n3 = 545;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 575;
                    break;
                }
                n3 = 575;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 571;
                    break;
                }
                n3 = 571;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 550;
                    break;
                }
                n3 = 550;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 539;
                    break;
                }
                n3 = 539;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 541;
                    break;
                }
                n3 = 541;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 570;
                    break;
                }
                n3 = 570;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 554;
                    break;
                }
                n3 = 554;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 565;
                    break;
                }
                n3 = 565;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 573;
                    break;
                }
                n3 = 573;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 568;
                    break;
                }
                n3 = 568;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 540;
                    break;
                }
                n3 = 540;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 556;
                    break;
                }
                n3 = 556;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 548;
                    break;
                }
                n3 = 548;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 566;
                    break;
                }
                n3 = 566;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 582;
                    break;
                }
                n3 = 582;
                break;
            }
        }
        return n3;
    }

    private int a14(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 596;
                    break;
                }
                n3 = 596;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 602;
                    break;
                }
                n3 = 602;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 612;
                    break;
                }
                n3 = 612;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 627;
                    break;
                }
                n3 = 627;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 611;
                    break;
                }
                n3 = 611;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 616;
                    break;
                }
                n3 = 616;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 608;
                    break;
                }
                n3 = 608;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 604;
                    break;
                }
                n3 = 604;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 634;
                    break;
                }
                n3 = 634;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 613;
                    break;
                }
                n3 = 613;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 600;
                    break;
                }
                n3 = 600;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 628;
                    break;
                }
                n3 = 628;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 598;
                    break;
                }
                n3 = 598;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 621;
                    break;
                }
                n3 = 621;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 626;
                    break;
                }
                n3 = 626;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 618;
                    break;
                }
                n3 = 618;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 607;
                    break;
                }
                n3 = 607;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 630;
                    break;
                }
                n3 = 630;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 601;
                    break;
                }
                n3 = 601;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 592;
                    break;
                }
                n3 = 592;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 636;
                    break;
                }
                n3 = 636;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 606;
                    break;
                }
                n3 = 606;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 591;
                    break;
                }
                n3 = 591;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 593;
                    break;
                }
                n3 = 593;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 632;
                    break;
                }
                n3 = 632;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 635;
                    break;
                }
                n3 = 635;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 595;
                    break;
                }
                n3 = 595;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 610;
                    break;
                }
                n3 = 610;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 629;
                    break;
                }
                n3 = 629;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 609;
                    break;
                }
                n3 = 609;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 633;
                    break;
                }
                n3 = 633;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 625;
                    break;
                }
                n3 = 625;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 623;
                    break;
                }
                n3 = 623;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 594;
                    break;
                }
                n3 = 594;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 624;
                    break;
                }
                n3 = 624;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 620;
                    break;
                }
                n3 = 620;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 599;
                    break;
                }
                n3 = 599;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 588;
                    break;
                }
                n3 = 588;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 590;
                    break;
                }
                n3 = 590;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 619;
                    break;
                }
                n3 = 619;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 603;
                    break;
                }
                n3 = 603;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 614;
                    break;
                }
                n3 = 614;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 622;
                    break;
                }
                n3 = 622;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 617;
                    break;
                }
                n3 = 617;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 589;
                    break;
                }
                n3 = 589;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 605;
                    break;
                }
                n3 = 605;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 597;
                    break;
                }
                n3 = 597;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 615;
                    break;
                }
                n3 = 615;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 631;
                    break;
                }
                n3 = 631;
                break;
            }
        }
        return n3;
    }

    private int a15(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 645;
                    break;
                }
                n3 = 645;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 651;
                    break;
                }
                n3 = 651;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 661;
                    break;
                }
                n3 = 661;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 676;
                    break;
                }
                n3 = 676;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 660;
                    break;
                }
                n3 = 660;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 665;
                    break;
                }
                n3 = 665;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 657;
                    break;
                }
                n3 = 657;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 653;
                    break;
                }
                n3 = 653;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 683;
                    break;
                }
                n3 = 683;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 662;
                    break;
                }
                n3 = 662;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 649;
                    break;
                }
                n3 = 649;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 677;
                    break;
                }
                n3 = 677;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 647;
                    break;
                }
                n3 = 647;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 670;
                    break;
                }
                n3 = 670;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 675;
                    break;
                }
                n3 = 675;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 667;
                    break;
                }
                n3 = 667;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 656;
                    break;
                }
                n3 = 656;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 679;
                    break;
                }
                n3 = 679;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 650;
                    break;
                }
                n3 = 650;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 641;
                    break;
                }
                n3 = 641;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 685;
                    break;
                }
                n3 = 685;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 655;
                    break;
                }
                n3 = 655;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 640;
                    break;
                }
                n3 = 640;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 642;
                    break;
                }
                n3 = 642;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 681;
                    break;
                }
                n3 = 681;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 684;
                    break;
                }
                n3 = 684;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 644;
                    break;
                }
                n3 = 644;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 659;
                    break;
                }
                n3 = 659;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 678;
                    break;
                }
                n3 = 678;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 658;
                    break;
                }
                n3 = 658;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 682;
                    break;
                }
                n3 = 682;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 674;
                    break;
                }
                n3 = 674;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 672;
                    break;
                }
                n3 = 672;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 643;
                    break;
                }
                n3 = 643;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 673;
                    break;
                }
                n3 = 673;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 669;
                    break;
                }
                n3 = 669;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 648;
                    break;
                }
                n3 = 648;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 637;
                    break;
                }
                n3 = 637;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 639;
                    break;
                }
                n3 = 639;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 668;
                    break;
                }
                n3 = 668;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 652;
                    break;
                }
                n3 = 652;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 663;
                    break;
                }
                n3 = 663;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 671;
                    break;
                }
                n3 = 671;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 666;
                    break;
                }
                n3 = 666;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 638;
                    break;
                }
                n3 = 638;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 654;
                    break;
                }
                n3 = 654;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 646;
                    break;
                }
                n3 = 646;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 664;
                    break;
                }
                n3 = 664;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 680;
                    break;
                }
                n3 = 680;
                break;
            }
        }
        return n3;
    }

    private int a16(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 694;
                    break;
                }
                n3 = 694;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 700;
                    break;
                }
                n3 = 700;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 710;
                    break;
                }
                n3 = 710;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 725;
                    break;
                }
                n3 = 725;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 709;
                    break;
                }
                n3 = 709;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 714;
                    break;
                }
                n3 = 714;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 706;
                    break;
                }
                n3 = 706;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 702;
                    break;
                }
                n3 = 702;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 732;
                    break;
                }
                n3 = 732;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 711;
                    break;
                }
                n3 = 711;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 698;
                    break;
                }
                n3 = 698;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 726;
                    break;
                }
                n3 = 726;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 696;
                    break;
                }
                n3 = 696;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 719;
                    break;
                }
                n3 = 719;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 724;
                    break;
                }
                n3 = 724;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 716;
                    break;
                }
                n3 = 716;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 705;
                    break;
                }
                n3 = 705;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 728;
                    break;
                }
                n3 = 728;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 699;
                    break;
                }
                n3 = 699;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 690;
                    break;
                }
                n3 = 690;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 734;
                    break;
                }
                n3 = 734;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 704;
                    break;
                }
                n3 = 704;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 689;
                    break;
                }
                n3 = 689;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 691;
                    break;
                }
                n3 = 691;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 730;
                    break;
                }
                n3 = 730;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 733;
                    break;
                }
                n3 = 733;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 693;
                    break;
                }
                n3 = 693;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 708;
                    break;
                }
                n3 = 708;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 727;
                    break;
                }
                n3 = 727;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 707;
                    break;
                }
                n3 = 707;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 731;
                    break;
                }
                n3 = 731;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 723;
                    break;
                }
                n3 = 723;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 721;
                    break;
                }
                n3 = 721;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 692;
                    break;
                }
                n3 = 692;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 722;
                    break;
                }
                n3 = 722;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 718;
                    break;
                }
                n3 = 718;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 697;
                    break;
                }
                n3 = 697;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 686;
                    break;
                }
                n3 = 686;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 688;
                    break;
                }
                n3 = 688;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 717;
                    break;
                }
                n3 = 717;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 701;
                    break;
                }
                n3 = 701;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 712;
                    break;
                }
                n3 = 712;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 720;
                    break;
                }
                n3 = 720;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 715;
                    break;
                }
                n3 = 715;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 687;
                    break;
                }
                n3 = 687;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 703;
                    break;
                }
                n3 = 703;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 695;
                    break;
                }
                n3 = 695;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 713;
                    break;
                }
                n3 = 713;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 729;
                    break;
                }
                n3 = 729;
                break;
            }
        }
        return n3;
    }

    private int a17(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 743;
                    break;
                }
                n3 = 743;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 749;
                    break;
                }
                n3 = 749;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 759;
                    break;
                }
                n3 = 759;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 774;
                    break;
                }
                n3 = 774;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 758;
                    break;
                }
                n3 = 758;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 763;
                    break;
                }
                n3 = 763;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 755;
                    break;
                }
                n3 = 755;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 751;
                    break;
                }
                n3 = 751;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 781;
                    break;
                }
                n3 = 781;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 760;
                    break;
                }
                n3 = 760;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 747;
                    break;
                }
                n3 = 747;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 775;
                    break;
                }
                n3 = 775;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 745;
                    break;
                }
                n3 = 745;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 768;
                    break;
                }
                n3 = 768;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 773;
                    break;
                }
                n3 = 773;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 765;
                    break;
                }
                n3 = 765;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 754;
                    break;
                }
                n3 = 754;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 777;
                    break;
                }
                n3 = 777;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 748;
                    break;
                }
                n3 = 748;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 739;
                    break;
                }
                n3 = 739;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 783;
                    break;
                }
                n3 = 783;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 753;
                    break;
                }
                n3 = 753;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 738;
                    break;
                }
                n3 = 738;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 740;
                    break;
                }
                n3 = 740;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 779;
                    break;
                }
                n3 = 779;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 782;
                    break;
                }
                n3 = 782;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 742;
                    break;
                }
                n3 = 742;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 757;
                    break;
                }
                n3 = 757;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 776;
                    break;
                }
                n3 = 776;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 756;
                    break;
                }
                n3 = 756;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 780;
                    break;
                }
                n3 = 780;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 772;
                    break;
                }
                n3 = 772;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 770;
                    break;
                }
                n3 = 770;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 741;
                    break;
                }
                n3 = 741;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 771;
                    break;
                }
                n3 = 771;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 767;
                    break;
                }
                n3 = 767;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 746;
                    break;
                }
                n3 = 746;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 735;
                    break;
                }
                n3 = 735;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 737;
                    break;
                }
                n3 = 737;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 766;
                    break;
                }
                n3 = 766;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 750;
                    break;
                }
                n3 = 750;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 761;
                    break;
                }
                n3 = 761;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 769;
                    break;
                }
                n3 = 769;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 764;
                    break;
                }
                n3 = 764;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 736;
                    break;
                }
                n3 = 736;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 752;
                    break;
                }
                n3 = 752;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 744;
                    break;
                }
                n3 = 744;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 762;
                    break;
                }
                n3 = 762;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 778;
                    break;
                }
                n3 = 778;
                break;
            }
        }
        return n3;
    }

    private int a18(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 792;
                    break;
                }
                n3 = 792;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 798;
                    break;
                }
                n3 = 798;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 808;
                    break;
                }
                n3 = 808;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 823;
                    break;
                }
                n3 = 823;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 807;
                    break;
                }
                n3 = 807;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 812;
                    break;
                }
                n3 = 812;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 804;
                    break;
                }
                n3 = 804;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 800;
                    break;
                }
                n3 = 800;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 830;
                    break;
                }
                n3 = 830;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 809;
                    break;
                }
                n3 = 809;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 796;
                    break;
                }
                n3 = 796;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 824;
                    break;
                }
                n3 = 824;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 794;
                    break;
                }
                n3 = 794;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 817;
                    break;
                }
                n3 = 817;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 822;
                    break;
                }
                n3 = 822;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 814;
                    break;
                }
                n3 = 814;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 803;
                    break;
                }
                n3 = 803;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 826;
                    break;
                }
                n3 = 826;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 797;
                    break;
                }
                n3 = 797;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 788;
                    break;
                }
                n3 = 788;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 832;
                    break;
                }
                n3 = 832;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 802;
                    break;
                }
                n3 = 802;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 787;
                    break;
                }
                n3 = 787;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 789;
                    break;
                }
                n3 = 789;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 828;
                    break;
                }
                n3 = 828;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 831;
                    break;
                }
                n3 = 831;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 791;
                    break;
                }
                n3 = 791;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 806;
                    break;
                }
                n3 = 806;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 825;
                    break;
                }
                n3 = 825;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 805;
                    break;
                }
                n3 = 805;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 829;
                    break;
                }
                n3 = 829;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 821;
                    break;
                }
                n3 = 821;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 819;
                    break;
                }
                n3 = 819;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 790;
                    break;
                }
                n3 = 790;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 820;
                    break;
                }
                n3 = 820;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 816;
                    break;
                }
                n3 = 816;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 795;
                    break;
                }
                n3 = 795;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 784;
                    break;
                }
                n3 = 784;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 786;
                    break;
                }
                n3 = 786;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 815;
                    break;
                }
                n3 = 815;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 799;
                    break;
                }
                n3 = 799;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 810;
                    break;
                }
                n3 = 810;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 818;
                    break;
                }
                n3 = 818;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 813;
                    break;
                }
                n3 = 813;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 785;
                    break;
                }
                n3 = 785;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 801;
                    break;
                }
                n3 = 801;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 793;
                    break;
                }
                n3 = 793;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 811;
                    break;
                }
                n3 = 811;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 827;
                    break;
                }
                n3 = 827;
                break;
            }
        }
        return n3;
    }

    private int a19(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 841;
                    break;
                }
                n3 = 841;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 847;
                    break;
                }
                n3 = 847;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 857;
                    break;
                }
                n3 = 857;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 872;
                    break;
                }
                n3 = 872;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 856;
                    break;
                }
                n3 = 856;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 861;
                    break;
                }
                n3 = 861;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 853;
                    break;
                }
                n3 = 853;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 849;
                    break;
                }
                n3 = 849;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 879;
                    break;
                }
                n3 = 879;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 858;
                    break;
                }
                n3 = 858;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 845;
                    break;
                }
                n3 = 845;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 873;
                    break;
                }
                n3 = 873;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 843;
                    break;
                }
                n3 = 843;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 866;
                    break;
                }
                n3 = 866;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 871;
                    break;
                }
                n3 = 871;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 863;
                    break;
                }
                n3 = 863;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 852;
                    break;
                }
                n3 = 852;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 875;
                    break;
                }
                n3 = 875;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 846;
                    break;
                }
                n3 = 846;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 837;
                    break;
                }
                n3 = 837;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 881;
                    break;
                }
                n3 = 881;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 851;
                    break;
                }
                n3 = 851;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 836;
                    break;
                }
                n3 = 836;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 838;
                    break;
                }
                n3 = 838;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 877;
                    break;
                }
                n3 = 877;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 880;
                    break;
                }
                n3 = 880;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 840;
                    break;
                }
                n3 = 840;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 855;
                    break;
                }
                n3 = 855;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 874;
                    break;
                }
                n3 = 874;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 854;
                    break;
                }
                n3 = 854;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 878;
                    break;
                }
                n3 = 878;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 870;
                    break;
                }
                n3 = 870;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 868;
                    break;
                }
                n3 = 868;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 839;
                    break;
                }
                n3 = 839;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 869;
                    break;
                }
                n3 = 869;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 865;
                    break;
                }
                n3 = 865;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 844;
                    break;
                }
                n3 = 844;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 833;
                    break;
                }
                n3 = 833;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 835;
                    break;
                }
                n3 = 835;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 864;
                    break;
                }
                n3 = 864;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 848;
                    break;
                }
                n3 = 848;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 859;
                    break;
                }
                n3 = 859;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 867;
                    break;
                }
                n3 = 867;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 862;
                    break;
                }
                n3 = 862;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 834;
                    break;
                }
                n3 = 834;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 850;
                    break;
                }
                n3 = 850;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 842;
                    break;
                }
                n3 = 842;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 860;
                    break;
                }
                n3 = 860;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 876;
                    break;
                }
                n3 = 876;
                break;
            }
        }
        return n3;
    }

    private int a20(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2146736866: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 897;
                    break;
                }
                n3 = 897;
                break;
            }
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 919;
                    break;
                }
                n3 = 919;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 925;
                    break;
                }
                n3 = 925;
                break;
            }
            case -2008145930: {
                if (bl) {
                    if (n2 != -303846335) break;
                    n3 = 911;
                    break;
                }
                n3 = 911;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 932;
                    break;
                }
                n3 = 932;
                break;
            }
            case -1809478137: {
                if (bl) {
                    if (n2 != -816611101) break;
                    n3 = 891;
                    break;
                }
                n3 = 891;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 945;
                    break;
                }
                n3 = 945;
                break;
            }
            case -1787305278: {
                if (bl) {
                    if (n2 != -394077263) break;
                    n3 = 895;
                    break;
                }
                n3 = 895;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 931;
                    break;
                }
                n3 = 931;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 936;
                    break;
                }
                n3 = 936;
                break;
            }
            case -1664133069: {
                if (bl) {
                    if (n2 != -303846335) break;
                    n3 = 902;
                    break;
                }
                n3 = 902;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 884;
                    break;
                }
                n3 = 884;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 927;
                    break;
                }
                n3 = 927;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 951;
                    break;
                }
                n3 = 951;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 933;
                    break;
                }
                n3 = 933;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 923;
                    break;
                }
                n3 = 923;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 888;
                    break;
                }
                n3 = 888;
                break;
            }
            case -1077557351: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 914;
                    break;
                }
                n3 = 914;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 921;
                    break;
                }
                n3 = 921;
                break;
            }
            case -1000060648: {
                if (bl) {
                    if (n2 != 26244328) break;
                    n3 = 896;
                    break;
                }
                n3 = 896;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 940;
                    break;
                }
                n3 = 940;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 944;
                    break;
                }
                n3 = 944;
                break;
            }
            case -586502161: {
                if (bl) {
                    if (n2 != -1262881996) break;
                    n3 = 907;
                    break;
                }
                n3 = 907;
                break;
            }
            case -535487487: {
                if (bl) {
                    if (n2 != -1585401749) break;
                    n3 = 903;
                    break;
                }
                n3 = 903;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 886;
                    break;
                }
                n3 = 886;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 883;
                    break;
                }
                n3 = 883;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 947;
                    break;
                }
                n3 = 947;
                break;
            }
            case -143460498: {
                if (bl) {
                    if (n2 != -303846335) break;
                    n3 = 901;
                    break;
                }
                n3 = 901;
                break;
            }
            case -142779923: {
                if (bl) {
                    if (n2 != -1727127582) break;
                    n3 = 909;
                    break;
                }
                n3 = 909;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 924;
                    break;
                }
                n3 = 924;
                break;
            }
            case -22682711: {
                if (bl) {
                    if (n2 != -1053066686) break;
                    n3 = 893;
                    break;
                }
                n3 = 893;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 916;
                    break;
                }
                n3 = 916;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 953;
                    break;
                }
                n3 = 953;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 929;
                    break;
                }
                n3 = 929;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 915;
                    break;
                }
                n3 = 915;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 917;
                    break;
                }
                n3 = 917;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 949;
                    break;
                }
                n3 = 949;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 952;
                    break;
                }
                n3 = 952;
                break;
            }
            case 314603671: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 910;
                    break;
                }
                n3 = 910;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 918;
                    break;
                }
                n3 = 918;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 885;
                    break;
                }
                n3 = 885;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 946;
                    break;
                }
                n3 = 946;
                break;
            }
            case 437731210: {
                if (bl) {
                    if (n2 != 714090704) break;
                    n3 = 908;
                    break;
                }
                n3 = 908;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 930;
                    break;
                }
                n3 = 930;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 950;
                    break;
                }
                n3 = 950;
                break;
            }
            case 593523885: {
                if (bl) {
                    if (n2 != -1262881996) break;
                    n3 = 894;
                    break;
                }
                n3 = 894;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 943;
                    break;
                }
                n3 = 943;
                break;
            }
            case 801808108: {
                if (bl) {
                    if (n2 != -303846335) break;
                    n3 = 892;
                    break;
                }
                n3 = 892;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 941;
                    break;
                }
                n3 = 941;
                break;
            }
            case 921029134: {
                if (bl) {
                    if (n2 != -303846335) break;
                    n3 = 898;
                    break;
                }
                n3 = 898;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 882;
                    break;
                }
                n3 = 882;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 942;
                    break;
                }
                n3 = 942;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 939;
                    break;
                }
                n3 = 939;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 922;
                    break;
                }
                n3 = 922;
                break;
            }
            case 1244919775: {
                if (bl) {
                    if (n2 != -1985511187) break;
                    n3 = 913;
                    break;
                }
                n3 = 913;
                break;
            }
            case 1272313548: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 905;
                    break;
                }
                n3 = 905;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 889;
                    break;
                }
                n3 = 889;
                break;
            }
            case 1324303610: {
                if (bl) {
                    if (n2 != -936820918) break;
                    n3 = 904;
                    break;
                }
                n3 = 904;
                break;
            }
            case 1373693704: {
                if (bl) {
                    if (n2 != -303846335) break;
                    n3 = 906;
                    break;
                }
                n3 = 906;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 938;
                    break;
                }
                n3 = 938;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 926;
                    break;
                }
                n3 = 926;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 934;
                    break;
                }
                n3 = 934;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 887;
                    break;
                }
                n3 = 887;
                break;
            }
            case 1639307534: {
                if (bl) {
                    if (n2 != -829527491) break;
                    n3 = 899;
                    break;
                }
                n3 = 899;
                break;
            }
            case 1679423848: {
                if (bl) {
                    if (n2 != -303846335) break;
                    n3 = 912;
                    break;
                }
                n3 = 912;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 937;
                    break;
                }
                n3 = 937;
                break;
            }
            case 1817739933: {
                if (bl) {
                    if (n2 != -829527491) break;
                    n3 = 900;
                    break;
                }
                n3 = 900;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 890;
                    break;
                }
                n3 = 890;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 928;
                    break;
                }
                n3 = 928;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 920;
                    break;
                }
                n3 = 920;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 935;
                    break;
                }
                n3 = 935;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 948;
                    break;
                }
                n3 = 948;
                break;
            }
        }
        return n3;
    }

    private int a21(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 962;
                    break;
                }
                n3 = 962;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 968;
                    break;
                }
                n3 = 968;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 978;
                    break;
                }
                n3 = 978;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 993;
                    break;
                }
                n3 = 993;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 977;
                    break;
                }
                n3 = 977;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 982;
                    break;
                }
                n3 = 982;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 974;
                    break;
                }
                n3 = 974;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 970;
                    break;
                }
                n3 = 970;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 1000;
                    break;
                }
                n3 = 1000;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 979;
                    break;
                }
                n3 = 979;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 966;
                    break;
                }
                n3 = 966;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 994;
                    break;
                }
                n3 = 994;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 964;
                    break;
                }
                n3 = 964;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 987;
                    break;
                }
                n3 = 987;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 992;
                    break;
                }
                n3 = 992;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 984;
                    break;
                }
                n3 = 984;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 973;
                    break;
                }
                n3 = 973;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 996;
                    break;
                }
                n3 = 996;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 967;
                    break;
                }
                n3 = 967;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 958;
                    break;
                }
                n3 = 958;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 1002;
                    break;
                }
                n3 = 1002;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 972;
                    break;
                }
                n3 = 972;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 957;
                    break;
                }
                n3 = 957;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 959;
                    break;
                }
                n3 = 959;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 998;
                    break;
                }
                n3 = 998;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 1001;
                    break;
                }
                n3 = 1001;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 961;
                    break;
                }
                n3 = 961;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 976;
                    break;
                }
                n3 = 976;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 995;
                    break;
                }
                n3 = 995;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 975;
                    break;
                }
                n3 = 975;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 999;
                    break;
                }
                n3 = 999;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 991;
                    break;
                }
                n3 = 991;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 989;
                    break;
                }
                n3 = 989;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 960;
                    break;
                }
                n3 = 960;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 990;
                    break;
                }
                n3 = 990;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 986;
                    break;
                }
                n3 = 986;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 965;
                    break;
                }
                n3 = 965;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 954;
                    break;
                }
                n3 = 954;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 956;
                    break;
                }
                n3 = 956;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 985;
                    break;
                }
                n3 = 985;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 969;
                    break;
                }
                n3 = 969;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 980;
                    break;
                }
                n3 = 980;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 988;
                    break;
                }
                n3 = 988;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 983;
                    break;
                }
                n3 = 983;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -292196031) break;
                    n3 = 955;
                    break;
                }
                n3 = 955;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 971;
                    break;
                }
                n3 = 971;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 963;
                    break;
                }
                n3 = 963;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 981;
                    break;
                }
                n3 = 981;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 997;
                    break;
                }
                n3 = 997;
                break;
            }
        }
        return n3;
    }

    private int a22(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2074846649: {
                if (bl) {
                    if (n2 != -1773059229) break;
                    n3 = 1011;
                    break;
                }
                n3 = 1011;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 1017;
                    break;
                }
                n3 = 1017;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 1027;
                    break;
                }
                n3 = 1027;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 1042;
                    break;
                }
                n3 = 1042;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 1026;
                    break;
                }
                n3 = 1026;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 1031;
                    break;
                }
                n3 = 1031;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 1023;
                    break;
                }
                n3 = 1023;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 1019;
                    break;
                }
                n3 = 1019;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 1049;
                    break;
                }
                n3 = 1049;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 1028;
                    break;
                }
                n3 = 1028;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 1015;
                    break;
                }
                n3 = 1015;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 1043;
                    break;
                }
                n3 = 1043;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 1013;
                    break;
                }
                n3 = 1013;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 1036;
                    break;
                }
                n3 = 1036;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 1041;
                    break;
                }
                n3 = 1041;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 1033;
                    break;
                }
                n3 = 1033;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 1022;
                    break;
                }
                n3 = 1022;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 1045;
                    break;
                }
                n3 = 1045;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 1016;
                    break;
                }
                n3 = 1016;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 1007;
                    break;
                }
                n3 = 1007;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 1051;
                    break;
                }
                n3 = 1051;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 1021;
                    break;
                }
                n3 = 1021;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 1006;
                    break;
                }
                n3 = 1006;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 1008;
                    break;
                }
                n3 = 1008;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 1047;
                    break;
                }
                n3 = 1047;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 1050;
                    break;
                }
                n3 = 1050;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 1010;
                    break;
                }
                n3 = 1010;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 1025;
                    break;
                }
                n3 = 1025;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 1044;
                    break;
                }
                n3 = 1044;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 1024;
                    break;
                }
                n3 = 1024;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 1048;
                    break;
                }
                n3 = 1048;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 1040;
                    break;
                }
                n3 = 1040;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 1038;
                    break;
                }
                n3 = 1038;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 1009;
                    break;
                }
                n3 = 1009;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 1039;
                    break;
                }
                n3 = 1039;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 1035;
                    break;
                }
                n3 = 1035;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 1014;
                    break;
                }
                n3 = 1014;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 1003;
                    break;
                }
                n3 = 1003;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 1005;
                    break;
                }
                n3 = 1005;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 1034;
                    break;
                }
                n3 = 1034;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 1018;
                    break;
                }
                n3 = 1018;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 1029;
                    break;
                }
                n3 = 1029;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 1037;
                    break;
                }
                n3 = 1037;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 1032;
                    break;
                }
                n3 = 1032;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n2 != -1251231692) break;
                    n3 = 1004;
                    break;
                }
                n3 = 1004;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 1020;
                    break;
                }
                n3 = 1020;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 1012;
                    break;
                }
                n3 = 1012;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 1030;
                    break;
                }
                n3 = 1030;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 1046;
                    break;
                }
                n3 = 1046;
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
            case -2063636672: {
                n2 = this.a5(n4, bl, n);
                break;
            }
            case -1964431487: {
                n2 = this.a9(n4, bl, n);
                break;
            }
            case -1557666644: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case -1545555471: {
                n2 = this.a10(n4, bl, n);
                break;
            }
            case -1542546053: {
                n2 = this.a13(n4, bl, n);
                break;
            }
            case -1347898494: {
                n2 = this.a6(n4, bl, n);
                break;
            }
            case -857685271: {
                n2 = this.a18(n4, bl, n);
                break;
            }
            case -602505768: {
                n2 = this.a19(n4, bl, n);
                break;
            }
            case -573814109: {
                n2 = this.a14(n4, bl, n);
                break;
            }
            case -479765729: {
                n2 = this.a17(n4, bl, n);
                break;
            }
            case -372669314: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -163723504: {
                n2 = this.a12(n4, bl, n);
                break;
            }
            case -151343708: {
                n2 = this.a11(n4, bl, n);
                break;
            }
            case -50983088: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 436384639: {
                n2 = this.a20(n4, bl, n);
                break;
            }
            case 522591789: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 642491083: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case 643079132: {
                n2 = this.a21(n4, bl, n);
                break;
            }
            case 781854052: {
                n2 = this.a15(n4, bl, n);
                break;
            }
            case 991400024: {
                n2 = this.a22(n4, bl, n);
                break;
            }
            case 1231107987: {
                n2 = this.a7(n4, bl, n);
                break;
            }
            case 1356944927: {
                n2 = this.a16(n4, bl, n);
                break;
            }
            case 2109720851: {
                n2 = this.a8(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((AbstractReflectionState)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 1: {
                ((ReflectionStateTop)object).evtHSM_ENTRY((EventGeneric)objectArray[0]);
                return null;
            }
            case 2: {
                ((ReflectionStateTop)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 3: {
                ((NavReflectionState)object).error((String)objectArray[0]);
                return null;
            }
            case 4: {
                ((NavReflectionState)object).warn((String)objectArray[0]);
                return null;
            }
            case 5: {
                ((NavReflectionState)object).trace((String)objectArray[0]);
                return null;
            }
            case 6: {
                ((NavReflectionState)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 7: {
                ((NavReflectionState)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 8: {
                ((NavReflectionState)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 9: {
                ((NavReflectionState)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 10: {
                ((NavReflectionState)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 11: {
                ((NavReflectionState)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 12: {
                ((NavReflectionState)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 13: {
                ((NavReflectionState)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 14: {
                ((NavReflectionState)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 15: {
                ((NavReflectionState)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 16: {
                ((NavReflectionState)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 17: {
                ((NavReflectionState)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 18: {
                ((NavReflectionState)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 19: {
                ((NavReflectionState)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 20: {
                ((NavReflectionState)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 21: {
                ((NavReflectionState)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 22: {
                ((NavReflectionState)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 23: {
                ((NavReflectionState)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 24: {
                ((NavReflectionState)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 25: {
                ((NavReflectionState)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 26: {
                ((NavReflectionState)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 27: {
                ((NavReflectionState)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 28: {
                ((NavReflectionState)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 29: {
                ((NavReflectionState)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 30: {
                ((NavReflectionState)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 31: {
                ((NavReflectionState)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((NavReflectionState)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 33: {
                ((NavReflectionState)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 34: {
                ((NavReflectionState)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 35: {
                ((NavReflectionState)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 36: {
                ((NavReflectionState)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 37: {
                ((NavReflectionState)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 38: {
                ((NavReflectionState)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 39: {
                ((NavReflectionState)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 40: {
                ((NavReflectionState)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 41: {
                ((NavReflectionState)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 42: {
                ((NavReflectionState)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 43: {
                ((NavReflectionState)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 44: {
                ((NavReflectionState)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 45: {
                ((NavReflectionState)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 46: {
                ((NavReflectionState)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 47: {
                ((NavReflectionState)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 48: {
                ((NavReflectionState)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 49: {
                ((StateChome)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 50: {
                ((StateChome)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 51: {
                ((StateChome)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 52: {
                ((StateChome)object).error((String)objectArray[0]);
                return null;
            }
            case 53: {
                ((StateChome)object).warn((String)objectArray[0]);
                return null;
            }
            case 54: {
                ((StateChome)object).trace((String)objectArray[0]);
                return null;
            }
            case 55: {
                ((StateChome)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 56: {
                ((StateChome)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 57: {
                ((StateChome)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 58: {
                ((StateChome)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 59: {
                ((StateChome)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 60: {
                ((StateChome)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 61: {
                ((StateChome)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 62: {
                ((StateChome)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 63: {
                ((StateChome)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((StateChome)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 65: {
                ((StateChome)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 66: {
                ((StateChome)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 67: {
                ((StateChome)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 68: {
                ((StateChome)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 69: {
                ((StateChome)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 70: {
                ((StateChome)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 71: {
                ((StateChome)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 72: {
                ((StateChome)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 73: {
                ((StateChome)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 74: {
                ((StateChome)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 75: {
                ((StateChome)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 76: {
                ((StateChome)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 77: {
                ((StateChome)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 78: {
                ((StateChome)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 79: {
                ((StateChome)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 80: {
                ((StateChome)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 81: {
                ((StateChome)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 82: {
                ((StateChome)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 83: {
                ((StateChome)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 84: {
                ((StateChome)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 85: {
                ((StateChome)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 86: {
                ((StateChome)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 87: {
                ((StateChome)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 88: {
                ((StateChome)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 89: {
                ((StateChome)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 90: {
                ((StateChome)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 91: {
                ((StateChome)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 92: {
                ((StateChome)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 93: {
                ((StateChome)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 94: {
                ((StateChome)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 95: {
                ((StateChome)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((StateChome)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 97: {
                ((StateChome)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 98: {
                ((StateCity)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 99: {
                ((StateCity)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 100: {
                ((StateCity)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 101: {
                ((StateCity)object).error((String)objectArray[0]);
                return null;
            }
            case 102: {
                ((StateCity)object).warn((String)objectArray[0]);
                return null;
            }
            case 103: {
                ((StateCity)object).trace((String)objectArray[0]);
                return null;
            }
            case 104: {
                ((StateCity)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 105: {
                ((StateCity)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 106: {
                ((StateCity)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 107: {
                ((StateCity)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 108: {
                ((StateCity)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 109: {
                ((StateCity)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 110: {
                ((StateCity)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 111: {
                ((StateCity)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 112: {
                ((StateCity)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 113: {
                ((StateCity)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 114: {
                ((StateCity)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 115: {
                ((StateCity)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 116: {
                ((StateCity)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 117: {
                ((StateCity)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 118: {
                ((StateCity)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 119: {
                ((StateCity)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 120: {
                ((StateCity)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 121: {
                ((StateCity)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 122: {
                ((StateCity)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 123: {
                ((StateCity)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 124: {
                ((StateCity)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 125: {
                ((StateCity)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 126: {
                ((StateCity)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 127: {
                ((StateCity)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((StateCity)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 129: {
                ((StateCity)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 130: {
                ((StateCity)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 131: {
                ((StateCity)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 132: {
                ((StateCity)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 133: {
                ((StateCity)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 134: {
                ((StateCity)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 135: {
                ((StateCity)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 136: {
                ((StateCity)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 137: {
                ((StateCity)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 138: {
                ((StateCity)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 139: {
                ((StateCity)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 140: {
                ((StateCity)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 141: {
                ((StateCity)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 142: {
                ((StateCity)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 143: {
                ((StateCity)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 144: {
                ((StateCity)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 145: {
                ((StateCity)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 146: {
                ((StateCity)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 147: {
                ((StateCountry)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 148: {
                ((StateCountry)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 149: {
                ((StateCountry)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 150: {
                ((StateCountry)object).error((String)objectArray[0]);
                return null;
            }
            case 151: {
                ((StateCountry)object).warn((String)objectArray[0]);
                return null;
            }
            case 152: {
                ((StateCountry)object).trace((String)objectArray[0]);
                return null;
            }
            case 153: {
                ((StateCountry)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 154: {
                ((StateCountry)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 155: {
                ((StateCountry)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 156: {
                ((StateCountry)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 157: {
                ((StateCountry)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 158: {
                ((StateCountry)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 159: {
                ((StateCountry)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((StateCountry)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 161: {
                ((StateCountry)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 162: {
                ((StateCountry)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 163: {
                ((StateCountry)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 164: {
                ((StateCountry)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 165: {
                ((StateCountry)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 166: {
                ((StateCountry)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 167: {
                ((StateCountry)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 168: {
                ((StateCountry)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 169: {
                ((StateCountry)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 170: {
                ((StateCountry)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 171: {
                ((StateCountry)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 172: {
                ((StateCountry)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 173: {
                ((StateCountry)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 174: {
                ((StateCountry)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 175: {
                ((StateCountry)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 176: {
                ((StateCountry)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 177: {
                ((StateCountry)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 178: {
                ((StateCountry)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 179: {
                ((StateCountry)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 180: {
                ((StateCountry)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 181: {
                ((StateCountry)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 182: {
                ((StateCountry)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 183: {
                ((StateCountry)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 184: {
                ((StateCountry)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 185: {
                ((StateCountry)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 186: {
                ((StateCountry)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 187: {
                ((StateCountry)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 188: {
                ((StateCountry)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 189: {
                ((StateCountry)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 190: {
                ((StateCountry)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 191: {
                ((StateCountry)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f6(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 192: {
                ((StateCountry)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 193: {
                ((StateCountry)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 194: {
                ((StateCountry)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 195: {
                ((StateCountry)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 196: {
                ((StateCrossing)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 197: {
                ((StateCrossing)object).evtHSM_EXIT((ISpellerContext)objectArray[0]);
                return null;
            }
            case 198: {
                ((StateCrossing)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 199: {
                ((StateCrossing)object).error((String)objectArray[0]);
                return null;
            }
            case 200: {
                ((StateCrossing)object).warn((String)objectArray[0]);
                return null;
            }
            case 201: {
                ((StateCrossing)object).trace((String)objectArray[0]);
                return null;
            }
            case 202: {
                ((StateCrossing)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 203: {
                ((StateCrossing)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 204: {
                ((StateCrossing)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 205: {
                ((StateCrossing)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 206: {
                ((StateCrossing)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 207: {
                ((StateCrossing)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 208: {
                ((StateCrossing)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 209: {
                ((StateCrossing)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 210: {
                ((StateCrossing)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 211: {
                ((StateCrossing)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 212: {
                ((StateCrossing)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 213: {
                ((StateCrossing)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 214: {
                ((StateCrossing)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 215: {
                ((StateCrossing)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 216: {
                ((StateCrossing)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 217: {
                ((StateCrossing)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 218: {
                ((StateCrossing)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 219: {
                ((StateCrossing)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 220: {
                ((StateCrossing)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 221: {
                ((StateCrossing)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 222: {
                ((StateCrossing)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 223: {
                ((StateCrossing)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f7(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 224: {
                ((StateCrossing)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 225: {
                ((StateCrossing)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 226: {
                ((StateCrossing)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 227: {
                ((StateCrossing)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 228: {
                ((StateCrossing)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 229: {
                ((StateCrossing)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 230: {
                ((StateCrossing)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 231: {
                ((StateCrossing)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 232: {
                ((StateCrossing)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 233: {
                ((StateCrossing)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 234: {
                ((StateCrossing)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 235: {
                ((StateCrossing)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 236: {
                ((StateCrossing)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 237: {
                ((StateCrossing)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 238: {
                ((StateCrossing)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 239: {
                ((StateCrossing)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 240: {
                ((StateCrossing)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 241: {
                ((StateCrossing)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 242: {
                ((StateCrossing)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 243: {
                ((StateCrossing)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 244: {
                ((StateCrossing)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 245: {
                ((StateHousenumber)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 246: {
                ((StateHousenumber)object).evtHSM_EXIT((ISpellerContext)objectArray[0]);
                return null;
            }
            case 247: {
                ((StateHousenumber)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 248: {
                ((StateHousenumber)object).error((String)objectArray[0]);
                return null;
            }
            case 249: {
                ((StateHousenumber)object).warn((String)objectArray[0]);
                return null;
            }
            case 250: {
                ((StateHousenumber)object).trace((String)objectArray[0]);
                return null;
            }
            case 251: {
                ((StateHousenumber)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 252: {
                ((StateHousenumber)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 253: {
                ((StateHousenumber)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 254: {
                ((StateHousenumber)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 255: {
                ((StateHousenumber)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f8(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 256: {
                ((StateHousenumber)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 257: {
                ((StateHousenumber)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 258: {
                ((StateHousenumber)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 259: {
                ((StateHousenumber)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 260: {
                ((StateHousenumber)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 261: {
                ((StateHousenumber)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 262: {
                ((StateHousenumber)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 263: {
                ((StateHousenumber)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 264: {
                ((StateHousenumber)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 265: {
                ((StateHousenumber)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 266: {
                ((StateHousenumber)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 267: {
                ((StateHousenumber)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 268: {
                ((StateHousenumber)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 269: {
                ((StateHousenumber)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 270: {
                ((StateHousenumber)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 271: {
                ((StateHousenumber)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 272: {
                ((StateHousenumber)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 273: {
                ((StateHousenumber)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 274: {
                ((StateHousenumber)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 275: {
                ((StateHousenumber)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 276: {
                ((StateHousenumber)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 277: {
                ((StateHousenumber)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 278: {
                ((StateHousenumber)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 279: {
                ((StateHousenumber)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 280: {
                ((StateHousenumber)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 281: {
                ((StateHousenumber)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 282: {
                ((StateHousenumber)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 283: {
                ((StateHousenumber)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 284: {
                ((StateHousenumber)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 285: {
                ((StateHousenumber)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 286: {
                ((StateHousenumber)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 287: {
                ((StateHousenumber)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f9(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 288: {
                ((StateHousenumber)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 289: {
                ((StateHousenumber)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 290: {
                ((StateHousenumber)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 291: {
                ((StateHousenumber)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 292: {
                ((StateHousenumber)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 293: {
                ((StateHousenumber)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 294: {
                ((StateMapCode)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 295: {
                ((StateMapCode)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 296: {
                ((StateMapCode)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 297: {
                ((StateMapCode)object).error((String)objectArray[0]);
                return null;
            }
            case 298: {
                ((StateMapCode)object).warn((String)objectArray[0]);
                return null;
            }
            case 299: {
                ((StateMapCode)object).trace((String)objectArray[0]);
                return null;
            }
            case 300: {
                ((StateMapCode)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 301: {
                ((StateMapCode)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 302: {
                ((StateMapCode)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 303: {
                ((StateMapCode)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 304: {
                ((StateMapCode)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 305: {
                ((StateMapCode)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 306: {
                ((StateMapCode)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 307: {
                ((StateMapCode)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 308: {
                ((StateMapCode)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 309: {
                ((StateMapCode)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 310: {
                ((StateMapCode)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 311: {
                ((StateMapCode)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 312: {
                ((StateMapCode)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 313: {
                ((StateMapCode)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 314: {
                ((StateMapCode)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 315: {
                ((StateMapCode)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 316: {
                ((StateMapCode)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 317: {
                ((StateMapCode)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 318: {
                ((StateMapCode)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 319: {
                ((StateMapCode)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f10(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 320: {
                ((StateMapCode)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 321: {
                ((StateMapCode)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 322: {
                ((StateMapCode)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 323: {
                ((StateMapCode)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 324: {
                ((StateMapCode)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 325: {
                ((StateMapCode)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 326: {
                ((StateMapCode)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 327: {
                ((StateMapCode)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 328: {
                ((StateMapCode)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 329: {
                ((StateMapCode)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 330: {
                ((StateMapCode)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 331: {
                ((StateMapCode)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 332: {
                ((StateMapCode)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 333: {
                ((StateMapCode)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 334: {
                ((StateMapCode)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 335: {
                ((StateMapCode)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 336: {
                ((StateMapCode)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 337: {
                ((StateMapCode)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 338: {
                ((StateMapCode)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 339: {
                ((StateMapCode)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 340: {
                ((StateMapCode)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 341: {
                ((StateMapCode)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 342: {
                ((StateMapCode)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 343: {
                ((StatePhoneNumber)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 344: {
                ((StatePhoneNumber)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 345: {
                ((StatePhoneNumber)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 346: {
                ((StatePhoneNumber)object).error((String)objectArray[0]);
                return null;
            }
            case 347: {
                ((StatePhoneNumber)object).warn((String)objectArray[0]);
                return null;
            }
            case 348: {
                ((StatePhoneNumber)object).trace((String)objectArray[0]);
                return null;
            }
            case 349: {
                ((StatePhoneNumber)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 350: {
                ((StatePhoneNumber)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 351: {
                ((StatePhoneNumber)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f11(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 352: {
                ((StatePhoneNumber)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 353: {
                ((StatePhoneNumber)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 354: {
                ((StatePhoneNumber)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 355: {
                ((StatePhoneNumber)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 356: {
                ((StatePhoneNumber)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 357: {
                ((StatePhoneNumber)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 358: {
                ((StatePhoneNumber)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 359: {
                ((StatePhoneNumber)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 360: {
                ((StatePhoneNumber)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 361: {
                ((StatePhoneNumber)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 362: {
                ((StatePhoneNumber)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 363: {
                ((StatePhoneNumber)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 364: {
                ((StatePhoneNumber)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 365: {
                ((StatePhoneNumber)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 366: {
                ((StatePhoneNumber)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 367: {
                ((StatePhoneNumber)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 368: {
                ((StatePhoneNumber)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 369: {
                ((StatePhoneNumber)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 370: {
                ((StatePhoneNumber)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 371: {
                ((StatePhoneNumber)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 372: {
                ((StatePhoneNumber)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 373: {
                ((StatePhoneNumber)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 374: {
                ((StatePhoneNumber)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 375: {
                ((StatePhoneNumber)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 376: {
                ((StatePhoneNumber)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 377: {
                ((StatePhoneNumber)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 378: {
                ((StatePhoneNumber)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 379: {
                ((StatePhoneNumber)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 380: {
                ((StatePhoneNumber)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 381: {
                ((StatePhoneNumber)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 382: {
                ((StatePhoneNumber)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 383: {
                ((StatePhoneNumber)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f12(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 384: {
                ((StatePhoneNumber)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 385: {
                ((StatePhoneNumber)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 386: {
                ((StatePhoneNumber)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 387: {
                ((StatePhoneNumber)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 388: {
                ((StatePhoneNumber)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 389: {
                ((StatePhoneNumber)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 390: {
                ((StatePhoneNumber)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 391: {
                ((StatePhoneNumber)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 392: {
                ((StatePlace)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 393: {
                ((StatePlace)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 394: {
                ((StatePlace)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 395: {
                ((StatePlace)object).error((String)objectArray[0]);
                return null;
            }
            case 396: {
                ((StatePlace)object).warn((String)objectArray[0]);
                return null;
            }
            case 397: {
                ((StatePlace)object).trace((String)objectArray[0]);
                return null;
            }
            case 398: {
                ((StatePlace)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 399: {
                ((StatePlace)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 400: {
                ((StatePlace)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 401: {
                ((StatePlace)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 402: {
                ((StatePlace)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 403: {
                ((StatePlace)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 404: {
                ((StatePlace)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 405: {
                ((StatePlace)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 406: {
                ((StatePlace)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 407: {
                ((StatePlace)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 408: {
                ((StatePlace)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 409: {
                ((StatePlace)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 410: {
                ((StatePlace)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 411: {
                ((StatePlace)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 412: {
                ((StatePlace)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 413: {
                ((StatePlace)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 414: {
                ((StatePlace)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 415: {
                ((StatePlace)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f13(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 416: {
                ((StatePlace)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 417: {
                ((StatePlace)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 418: {
                ((StatePlace)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 419: {
                ((StatePlace)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 420: {
                ((StatePlace)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 421: {
                ((StatePlace)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 422: {
                ((StatePlace)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 423: {
                ((StatePlace)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 424: {
                ((StatePlace)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 425: {
                ((StatePlace)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 426: {
                ((StatePlace)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 427: {
                ((StatePlace)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 428: {
                ((StatePlace)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 429: {
                ((StatePlace)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 430: {
                ((StatePlace)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 431: {
                ((StatePlace)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 432: {
                ((StatePlace)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 433: {
                ((StatePlace)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 434: {
                ((StatePlace)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 435: {
                ((StatePlace)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 436: {
                ((StatePlace)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 437: {
                ((StatePlace)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 438: {
                ((StatePlace)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 439: {
                ((StatePlace)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 440: {
                ((StatePlace)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 441: {
                ((StatePointLocationHousenumber)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 442: {
                ((StatePointLocationHousenumber)object).evtHSM_EXIT((ISpellerContext)objectArray[0]);
                return null;
            }
            case 443: {
                ((StatePointLocationHousenumber)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 444: {
                ((StatePointLocationHousenumber)object).error((String)objectArray[0]);
                return null;
            }
            case 445: {
                ((StatePointLocationHousenumber)object).warn((String)objectArray[0]);
                return null;
            }
            case 446: {
                ((StatePointLocationHousenumber)object).trace((String)objectArray[0]);
                return null;
            }
            case 447: {
                ((StatePointLocationHousenumber)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f14(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 448: {
                ((StatePointLocationHousenumber)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 449: {
                ((StatePointLocationHousenumber)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 450: {
                ((StatePointLocationHousenumber)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 451: {
                ((StatePointLocationHousenumber)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 452: {
                ((StatePointLocationHousenumber)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 453: {
                ((StatePointLocationHousenumber)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 454: {
                ((StatePointLocationHousenumber)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 455: {
                ((StatePointLocationHousenumber)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 456: {
                ((StatePointLocationHousenumber)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 457: {
                ((StatePointLocationHousenumber)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 458: {
                ((StatePointLocationHousenumber)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 459: {
                ((StatePointLocationHousenumber)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 460: {
                ((StatePointLocationHousenumber)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 461: {
                ((StatePointLocationHousenumber)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 462: {
                ((StatePointLocationHousenumber)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 463: {
                ((StatePointLocationHousenumber)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 464: {
                ((StatePointLocationHousenumber)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 465: {
                ((StatePointLocationHousenumber)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 466: {
                ((StatePointLocationHousenumber)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 467: {
                ((StatePointLocationHousenumber)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 468: {
                ((StatePointLocationHousenumber)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 469: {
                ((StatePointLocationHousenumber)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 470: {
                ((StatePointLocationHousenumber)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 471: {
                ((StatePointLocationHousenumber)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 472: {
                ((StatePointLocationHousenumber)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 473: {
                ((StatePointLocationHousenumber)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 474: {
                ((StatePointLocationHousenumber)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 475: {
                ((StatePointLocationHousenumber)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 476: {
                ((StatePointLocationHousenumber)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 477: {
                ((StatePointLocationHousenumber)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 478: {
                ((StatePointLocationHousenumber)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 479: {
                ((StatePointLocationHousenumber)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f15(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 480: {
                ((StatePointLocationHousenumber)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 481: {
                ((StatePointLocationHousenumber)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 482: {
                ((StatePointLocationHousenumber)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 483: {
                ((StatePointLocationHousenumber)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 484: {
                ((StatePointLocationHousenumber)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 485: {
                ((StatePointLocationHousenumber)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 486: {
                ((StatePointLocationHousenumber)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 487: {
                ((StatePointLocationHousenumber)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 488: {
                ((StatePointLocationHousenumber)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 489: {
                ((StatePointLocationHousenumber)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 490: {
                ((StateProvince)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 491: {
                ((StateProvince)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 492: {
                ((StateProvince)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 493: {
                ((StateProvince)object).error((String)objectArray[0]);
                return null;
            }
            case 494: {
                ((StateProvince)object).warn((String)objectArray[0]);
                return null;
            }
            case 495: {
                ((StateProvince)object).trace((String)objectArray[0]);
                return null;
            }
            case 496: {
                ((StateProvince)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 497: {
                ((StateProvince)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 498: {
                ((StateProvince)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 499: {
                ((StateProvince)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 500: {
                ((StateProvince)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 501: {
                ((StateProvince)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 502: {
                ((StateProvince)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 503: {
                ((StateProvince)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 504: {
                ((StateProvince)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 505: {
                ((StateProvince)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 506: {
                ((StateProvince)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 507: {
                ((StateProvince)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 508: {
                ((StateProvince)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 509: {
                ((StateProvince)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 510: {
                ((StateProvince)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 511: {
                ((StateProvince)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f16(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 512: {
                ((StateProvince)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 513: {
                ((StateProvince)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 514: {
                ((StateProvince)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 515: {
                ((StateProvince)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 516: {
                ((StateProvince)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 517: {
                ((StateProvince)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 518: {
                ((StateProvince)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 519: {
                ((StateProvince)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 520: {
                ((StateProvince)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 521: {
                ((StateProvince)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 522: {
                ((StateProvince)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 523: {
                ((StateProvince)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 524: {
                ((StateProvince)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 525: {
                ((StateProvince)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 526: {
                ((StateProvince)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 527: {
                ((StateProvince)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 528: {
                ((StateProvince)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 529: {
                ((StateProvince)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 530: {
                ((StateProvince)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 531: {
                ((StateProvince)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 532: {
                ((StateProvince)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 533: {
                ((StateProvince)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 534: {
                ((StateProvince)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 535: {
                ((StateProvince)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 536: {
                ((StateProvince)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 537: {
                ((StateProvince)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 538: {
                ((StateProvince)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 539: {
                ((StateState)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 540: {
                ((StateState)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 541: {
                ((StateState)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 542: {
                ((StateState)object).error((String)objectArray[0]);
                return null;
            }
            case 543: {
                ((StateState)object).warn((String)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f17(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 544: {
                ((StateState)object).trace((String)objectArray[0]);
                return null;
            }
            case 545: {
                ((StateState)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 546: {
                ((StateState)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 547: {
                ((StateState)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 548: {
                ((StateState)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 549: {
                ((StateState)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 550: {
                ((StateState)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 551: {
                ((StateState)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 552: {
                ((StateState)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 553: {
                ((StateState)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 554: {
                ((StateState)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 555: {
                ((StateState)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 556: {
                ((StateState)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 557: {
                ((StateState)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 558: {
                ((StateState)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 559: {
                ((StateState)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 560: {
                ((StateState)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 561: {
                ((StateState)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 562: {
                ((StateState)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 563: {
                ((StateState)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 564: {
                ((StateState)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 565: {
                ((StateState)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 566: {
                ((StateState)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 567: {
                ((StateState)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 568: {
                ((StateState)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 569: {
                ((StateState)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 570: {
                ((StateState)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 571: {
                ((StateState)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 572: {
                ((StateState)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 573: {
                ((StateState)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 574: {
                ((StateState)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 575: {
                ((StateState)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f18(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 576: {
                ((StateState)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 577: {
                ((StateState)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 578: {
                ((StateState)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 579: {
                ((StateState)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 580: {
                ((StateState)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 581: {
                ((StateState)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 582: {
                ((StateState)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 583: {
                ((StateState)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 584: {
                ((StateState)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 585: {
                ((StateState)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 586: {
                ((StateState)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 587: {
                ((StateState)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 588: {
                ((StateStreet)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 589: {
                ((StateStreet)object).evtHSM_EXIT((ISpellerContext)objectArray[0]);
                return null;
            }
            case 590: {
                ((StateStreet)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 591: {
                ((StateStreet)object).error((String)objectArray[0]);
                return null;
            }
            case 592: {
                ((StateStreet)object).warn((String)objectArray[0]);
                return null;
            }
            case 593: {
                ((StateStreet)object).trace((String)objectArray[0]);
                return null;
            }
            case 594: {
                ((StateStreet)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 595: {
                ((StateStreet)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 596: {
                ((StateStreet)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 597: {
                ((StateStreet)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 598: {
                ((StateStreet)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 599: {
                ((StateStreet)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 600: {
                ((StateStreet)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 601: {
                ((StateStreet)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 602: {
                ((StateStreet)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 603: {
                ((StateStreet)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 604: {
                ((StateStreet)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 605: {
                ((StateStreet)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 606: {
                ((StateStreet)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 607: {
                ((StateStreet)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f19(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 608: {
                ((StateStreet)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 609: {
                ((StateStreet)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 610: {
                ((StateStreet)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 611: {
                ((StateStreet)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 612: {
                ((StateStreet)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 613: {
                ((StateStreet)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 614: {
                ((StateStreet)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 615: {
                ((StateStreet)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 616: {
                ((StateStreet)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 617: {
                ((StateStreet)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 618: {
                ((StateStreet)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 619: {
                ((StateStreet)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 620: {
                ((StateStreet)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 621: {
                ((StateStreet)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 622: {
                ((StateStreet)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 623: {
                ((StateStreet)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 624: {
                ((StateStreet)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 625: {
                ((StateStreet)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 626: {
                ((StateStreet)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 627: {
                ((StateStreet)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 628: {
                ((StateStreet)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 629: {
                ((StateStreet)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 630: {
                ((StateStreet)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 631: {
                ((StateStreet)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 632: {
                ((StateStreet)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 633: {
                ((StateStreet)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 634: {
                ((StateStreet)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 635: {
                ((StateStreet)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 636: {
                ((StateStreet)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 637: {
                ((StateStreet1stCity)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 638: {
                ((StateStreet1stCity)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 639: {
                ((StateStreet1stCity)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f20(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 640: {
                ((StateStreet1stCity)object).error((String)objectArray[0]);
                return null;
            }
            case 641: {
                ((StateStreet1stCity)object).warn((String)objectArray[0]);
                return null;
            }
            case 642: {
                ((StateStreet1stCity)object).trace((String)objectArray[0]);
                return null;
            }
            case 643: {
                ((StateStreet1stCity)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 644: {
                ((StateStreet1stCity)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 645: {
                ((StateStreet1stCity)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 646: {
                ((StateStreet1stCity)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 647: {
                ((StateStreet1stCity)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 648: {
                ((StateStreet1stCity)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 649: {
                ((StateStreet1stCity)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 650: {
                ((StateStreet1stCity)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 651: {
                ((StateStreet1stCity)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 652: {
                ((StateStreet1stCity)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 653: {
                ((StateStreet1stCity)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 654: {
                ((StateStreet1stCity)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 655: {
                ((StateStreet1stCity)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 656: {
                ((StateStreet1stCity)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 657: {
                ((StateStreet1stCity)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 658: {
                ((StateStreet1stCity)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 659: {
                ((StateStreet1stCity)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 660: {
                ((StateStreet1stCity)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 661: {
                ((StateStreet1stCity)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 662: {
                ((StateStreet1stCity)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 663: {
                ((StateStreet1stCity)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 664: {
                ((StateStreet1stCity)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 665: {
                ((StateStreet1stCity)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 666: {
                ((StateStreet1stCity)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 667: {
                ((StateStreet1stCity)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 668: {
                ((StateStreet1stCity)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 669: {
                ((StateStreet1stCity)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 670: {
                ((StateStreet1stCity)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 671: {
                ((StateStreet1stCity)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f21(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 672: {
                ((StateStreet1stCity)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 673: {
                ((StateStreet1stCity)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 674: {
                ((StateStreet1stCity)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 675: {
                ((StateStreet1stCity)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 676: {
                ((StateStreet1stCity)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 677: {
                ((StateStreet1stCity)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 678: {
                ((StateStreet1stCity)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 679: {
                ((StateStreet1stCity)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 680: {
                ((StateStreet1stCity)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 681: {
                ((StateStreet1stCity)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 682: {
                ((StateStreet1stCity)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 683: {
                ((StateStreet1stCity)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 684: {
                ((StateStreet1stCity)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 685: {
                ((StateStreet1stCity)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 686: {
                ((StateStreet1stStreetWithBasenames)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 687: {
                ((StateStreet1stStreetWithBasenames)object).evtHSM_EXIT((ISpellerContext)objectArray[0]);
                return null;
            }
            case 688: {
                ((StateStreet1stStreetWithBasenames)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 689: {
                ((StateStreet1stStreetWithBasenames)object).error((String)objectArray[0]);
                return null;
            }
            case 690: {
                ((StateStreet1stStreetWithBasenames)object).warn((String)objectArray[0]);
                return null;
            }
            case 691: {
                ((StateStreet1stStreetWithBasenames)object).trace((String)objectArray[0]);
                return null;
            }
            case 692: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 693: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 694: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 695: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 696: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 697: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 698: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 699: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 700: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 701: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 702: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 703: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f22(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 704: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 705: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 706: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 707: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 708: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 709: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 710: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 711: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 712: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 713: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 714: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 715: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 716: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 717: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 718: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 719: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 720: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 721: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 722: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 723: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 724: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 725: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 726: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 727: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 728: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 729: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 730: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 731: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 732: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 733: {
                ((StateStreet1stStreetWithBasenames)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 734: {
                ((StateStreet1stStreetWithBasenames)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 735: {
                ((StateStreet1stZipCode)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f23(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 736: {
                ((StateStreet1stZipCode)object).evtHSM_EXIT((ISpellerContext)objectArray[0]);
                return null;
            }
            case 737: {
                ((StateStreet1stZipCode)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 738: {
                ((StateStreet1stZipCode)object).error((String)objectArray[0]);
                return null;
            }
            case 739: {
                ((StateStreet1stZipCode)object).warn((String)objectArray[0]);
                return null;
            }
            case 740: {
                ((StateStreet1stZipCode)object).trace((String)objectArray[0]);
                return null;
            }
            case 741: {
                ((StateStreet1stZipCode)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 742: {
                ((StateStreet1stZipCode)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 743: {
                ((StateStreet1stZipCode)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 744: {
                ((StateStreet1stZipCode)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 745: {
                ((StateStreet1stZipCode)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 746: {
                ((StateStreet1stZipCode)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 747: {
                ((StateStreet1stZipCode)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 748: {
                ((StateStreet1stZipCode)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 749: {
                ((StateStreet1stZipCode)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 750: {
                ((StateStreet1stZipCode)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 751: {
                ((StateStreet1stZipCode)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 752: {
                ((StateStreet1stZipCode)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 753: {
                ((StateStreet1stZipCode)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 754: {
                ((StateStreet1stZipCode)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 755: {
                ((StateStreet1stZipCode)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 756: {
                ((StateStreet1stZipCode)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 757: {
                ((StateStreet1stZipCode)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 758: {
                ((StateStreet1stZipCode)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 759: {
                ((StateStreet1stZipCode)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 760: {
                ((StateStreet1stZipCode)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 761: {
                ((StateStreet1stZipCode)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 762: {
                ((StateStreet1stZipCode)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 763: {
                ((StateStreet1stZipCode)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 764: {
                ((StateStreet1stZipCode)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 765: {
                ((StateStreet1stZipCode)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 766: {
                ((StateStreet1stZipCode)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 767: {
                ((StateStreet1stZipCode)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f24(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 768: {
                ((StateStreet1stZipCode)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 769: {
                ((StateStreet1stZipCode)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 770: {
                ((StateStreet1stZipCode)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 771: {
                ((StateStreet1stZipCode)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 772: {
                ((StateStreet1stZipCode)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 773: {
                ((StateStreet1stZipCode)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 774: {
                ((StateStreet1stZipCode)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 775: {
                ((StateStreet1stZipCode)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 776: {
                ((StateStreet1stZipCode)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 777: {
                ((StateStreet1stZipCode)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 778: {
                ((StateStreet1stZipCode)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 779: {
                ((StateStreet1stZipCode)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 780: {
                ((StateStreet1stZipCode)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 781: {
                ((StateStreet1stZipCode)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 782: {
                ((StateStreet1stZipCode)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 783: {
                ((StateStreet1stZipCode)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 784: {
                ((StateStreetDisambiguation)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 785: {
                ((StateStreetDisambiguation)object).evtHSM_EXIT((ISpellerContext)objectArray[0]);
                return null;
            }
            case 786: {
                ((StateStreetDisambiguation)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 787: {
                ((StateStreetDisambiguation)object).error((String)objectArray[0]);
                return null;
            }
            case 788: {
                ((StateStreetDisambiguation)object).warn((String)objectArray[0]);
                return null;
            }
            case 789: {
                ((StateStreetDisambiguation)object).trace((String)objectArray[0]);
                return null;
            }
            case 790: {
                ((StateStreetDisambiguation)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 791: {
                ((StateStreetDisambiguation)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 792: {
                ((StateStreetDisambiguation)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 793: {
                ((StateStreetDisambiguation)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 794: {
                ((StateStreetDisambiguation)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 795: {
                ((StateStreetDisambiguation)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 796: {
                ((StateStreetDisambiguation)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 797: {
                ((StateStreetDisambiguation)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 798: {
                ((StateStreetDisambiguation)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 799: {
                ((StateStreetDisambiguation)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f25(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 800: {
                ((StateStreetDisambiguation)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 801: {
                ((StateStreetDisambiguation)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 802: {
                ((StateStreetDisambiguation)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 803: {
                ((StateStreetDisambiguation)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 804: {
                ((StateStreetDisambiguation)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 805: {
                ((StateStreetDisambiguation)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 806: {
                ((StateStreetDisambiguation)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 807: {
                ((StateStreetDisambiguation)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 808: {
                ((StateStreetDisambiguation)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 809: {
                ((StateStreetDisambiguation)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 810: {
                ((StateStreetDisambiguation)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 811: {
                ((StateStreetDisambiguation)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 812: {
                ((StateStreetDisambiguation)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 813: {
                ((StateStreetDisambiguation)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 814: {
                ((StateStreetDisambiguation)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 815: {
                ((StateStreetDisambiguation)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 816: {
                ((StateStreetDisambiguation)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 817: {
                ((StateStreetDisambiguation)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 818: {
                ((StateStreetDisambiguation)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 819: {
                ((StateStreetDisambiguation)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 820: {
                ((StateStreetDisambiguation)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 821: {
                ((StateStreetDisambiguation)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 822: {
                ((StateStreetDisambiguation)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 823: {
                ((StateStreetDisambiguation)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 824: {
                ((StateStreetDisambiguation)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 825: {
                ((StateStreetDisambiguation)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 826: {
                ((StateStreetDisambiguation)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 827: {
                ((StateStreetDisambiguation)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 828: {
                ((StateStreetDisambiguation)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 829: {
                ((StateStreetDisambiguation)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 830: {
                ((StateStreetDisambiguation)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 831: {
                ((StateStreetDisambiguation)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f26(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 832: {
                ((StateStreetDisambiguation)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 833: {
                ((StateStreetWithBasenames)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 834: {
                ((StateStreetWithBasenames)object).evtHSM_EXIT((ISpellerContext)objectArray[0]);
                return null;
            }
            case 835: {
                ((StateStreetWithBasenames)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 836: {
                ((StateStreetWithBasenames)object).error((String)objectArray[0]);
                return null;
            }
            case 837: {
                ((StateStreetWithBasenames)object).warn((String)objectArray[0]);
                return null;
            }
            case 838: {
                ((StateStreetWithBasenames)object).trace((String)objectArray[0]);
                return null;
            }
            case 839: {
                ((StateStreetWithBasenames)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 840: {
                ((StateStreetWithBasenames)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 841: {
                ((StateStreetWithBasenames)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 842: {
                ((StateStreetWithBasenames)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 843: {
                ((StateStreetWithBasenames)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 844: {
                ((StateStreetWithBasenames)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 845: {
                ((StateStreetWithBasenames)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 846: {
                ((StateStreetWithBasenames)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 847: {
                ((StateStreetWithBasenames)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 848: {
                ((StateStreetWithBasenames)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 849: {
                ((StateStreetWithBasenames)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 850: {
                ((StateStreetWithBasenames)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 851: {
                ((StateStreetWithBasenames)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 852: {
                ((StateStreetWithBasenames)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 853: {
                ((StateStreetWithBasenames)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 854: {
                ((StateStreetWithBasenames)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 855: {
                ((StateStreetWithBasenames)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 856: {
                ((StateStreetWithBasenames)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 857: {
                ((StateStreetWithBasenames)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 858: {
                ((StateStreetWithBasenames)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 859: {
                ((StateStreetWithBasenames)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 860: {
                ((StateStreetWithBasenames)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 861: {
                ((StateStreetWithBasenames)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 862: {
                ((StateStreetWithBasenames)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 863: {
                ((StateStreetWithBasenames)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f27(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 864: {
                ((StateStreetWithBasenames)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 865: {
                ((StateStreetWithBasenames)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 866: {
                ((StateStreetWithBasenames)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 867: {
                ((StateStreetWithBasenames)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 868: {
                ((StateStreetWithBasenames)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 869: {
                ((StateStreetWithBasenames)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 870: {
                ((StateStreetWithBasenames)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 871: {
                ((StateStreetWithBasenames)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 872: {
                ((StateStreetWithBasenames)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 873: {
                ((StateStreetWithBasenames)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 874: {
                ((StateStreetWithBasenames)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 875: {
                ((StateStreetWithBasenames)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 876: {
                ((StateStreetWithBasenames)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 877: {
                ((StateStreetWithBasenames)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 878: {
                ((StateStreetWithBasenames)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 879: {
                ((StateStreetWithBasenames)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 880: {
                ((StateStreetWithBasenames)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 881: {
                ((StateStreetWithBasenames)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 882: {
                ((StateTop)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 883: {
                ((StateTop)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 884: {
                ((StateTop)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 885: {
                ((StateTop)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 886: {
                ((StateTop)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 887: {
                ((StateTop)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 888: {
                ((StateTop)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 889: {
                ((StateTop)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 890: {
                ((StateTop)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 891: {
                ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_COPY_LOCATION((SpellerContext)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 892: {
                ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_SET_LAST_INPUT_MODE((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 893: {
                ((StateTop)object).evtEV_START_SPELLER_BY_HANDLER((ISpellerContext)objectArray[0], (SpellerHandler)objectArray[1]);
                return null;
            }
            case 894: {
                ((StateTop)object).evtEV_STRIP_BY_STRIP_ID((ISpellerContext)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 895: {
                ((StateTop)object).evtEV_SET_CONTEXT_LOCATION((ISpellerContext)objectArray[0], (NavLocation)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f28(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 896: {
                ((StateTop)object).evtEV_SAVE_SPELLER_BY_HANDLER((SpellerContext)objectArray[0], (SpellerHandler)objectArray[1]);
                return null;
            }
            case 897: {
                ((StateTop)object).evtASL_NAVIGATION_HOMEDESTINPUT_INIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 898: {
                ((StateTop)object).evtEV_LOCATION_INPUT_START_INPUT((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 899: {
                ((StateTop)object).evtEV_LOCATION_INPUT_SET_INPUT((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 900: {
                ((StateTop)object).evtEV_LOCATION_INPUT_SELECT_ENTRY_VIA_ID((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 901: {
                ((StateTop)object).evtEV_LOCATION_INPUT_CANCEL_INPUT((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 902: {
                ((StateTop)object).evtEV_LOCATION_INPUT_SELECT_NOTHING((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 903: {
                ((StateTop)object).evtEV_LOCATION_INPUT_SET_CURRENT_LOCATION((AbstractReflectionContext)objectArray[0], objectArray[1]);
                return null;
            }
            case 904: {
                ((StateTop)object).evtEV_LOCATION_INPUT_SELECT_ENTRY_VIA_INDEX((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 905: {
                ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_INIT_LOCATION((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 906: {
                ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_DELETE_FIELD((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 907: {
                ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_SET_LOCATION_INPUT_PATH((ISpellerContext)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 908: {
                ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_SET_HWR_SPELLER_MODE_ENABLED((AbstractReflectionContext)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 909: {
                ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_INIT_FIELD((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 910: {
                ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_CANCEL_FIELD((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 911: {
                ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_START_ROUTE_CALC_FROM_DETAILVIEW((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 912: {
                ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SET_MATCH_LIST_LIMIT((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 913: {
                ((StateTop)object).handleIconCacheUpdate((IconKey)objectArray[0], (ResourceLocator)objectArray[1], objectArray[2]);
                return null;
            }
            case 914: {
                return ((StateTop)object).getDefaultIcon();
            }
            case 915: {
                ((StateTop)object).error((String)objectArray[0]);
                return null;
            }
            case 916: {
                ((StateTop)object).warn((String)objectArray[0]);
                return null;
            }
            case 917: {
                ((StateTop)object).trace((String)objectArray[0]);
                return null;
            }
            case 918: {
                ((StateTop)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 919: {
                ((StateTop)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 920: {
                ((StateTop)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 921: {
                ((StateTop)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 922: {
                ((StateTop)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 923: {
                ((StateTop)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 924: {
                ((StateTop)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 925: {
                ((StateTop)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 926: {
                ((StateTop)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 927: {
                ((StateTop)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f29(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 928: {
                ((StateTop)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 929: {
                ((StateTop)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 930: {
                ((StateTop)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 931: {
                ((StateTop)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 932: {
                ((StateTop)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 933: {
                ((StateTop)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 934: {
                ((StateTop)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 935: {
                ((StateTop)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 936: {
                ((StateTop)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 937: {
                ((StateTop)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 938: {
                ((StateTop)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 939: {
                ((StateTop)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 940: {
                ((StateTop)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 941: {
                ((StateTop)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 942: {
                ((StateTop)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 943: {
                ((StateTop)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 944: {
                ((StateTop)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 945: {
                ((StateTop)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 946: {
                ((StateTop)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 947: {
                ((StateTop)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 948: {
                ((StateTop)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 949: {
                ((StateTop)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 950: {
                ((StateTop)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 951: {
                ((StateTop)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 952: {
                ((StateTop)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 953: {
                ((StateTop)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 954: {
                ((StateWard)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 955: {
                ((StateWard)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                return null;
            }
            case 956: {
                ((StateWard)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 957: {
                ((StateWard)object).error((String)objectArray[0]);
                return null;
            }
            case 958: {
                ((StateWard)object).warn((String)objectArray[0]);
                return null;
            }
            case 959: {
                ((StateWard)object).trace((String)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f30(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 960: {
                ((StateWard)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 961: {
                ((StateWard)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 962: {
                ((StateWard)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 963: {
                ((StateWard)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 964: {
                ((StateWard)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 965: {
                ((StateWard)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 966: {
                ((StateWard)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 967: {
                ((StateWard)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 968: {
                ((StateWard)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 969: {
                ((StateWard)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 970: {
                ((StateWard)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 971: {
                ((StateWard)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 972: {
                ((StateWard)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 973: {
                ((StateWard)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 974: {
                ((StateWard)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 975: {
                ((StateWard)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 976: {
                ((StateWard)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 977: {
                ((StateWard)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 978: {
                ((StateWard)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 979: {
                ((StateWard)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 980: {
                ((StateWard)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 981: {
                ((StateWard)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 982: {
                ((StateWard)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 983: {
                ((StateWard)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 984: {
                ((StateWard)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 985: {
                ((StateWard)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 986: {
                ((StateWard)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 987: {
                ((StateWard)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 988: {
                ((StateWard)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 989: {
                ((StateWard)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 990: {
                ((StateWard)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 991: {
                ((StateWard)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f31(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 992: {
                ((StateWard)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 993: {
                ((StateWard)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 994: {
                ((StateWard)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 995: {
                ((StateWard)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 996: {
                ((StateWard)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 997: {
                ((StateWard)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 998: {
                ((StateWard)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 999: {
                ((StateWard)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 1000: {
                ((StateWard)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 1001: {
                ((StateWard)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 1002: {
                ((StateWard)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 1003: {
                ((StateZipCode)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                return null;
            }
            case 1004: {
                ((StateZipCode)object).evtHSM_EXIT((ISpellerContext)objectArray[0]);
                return null;
            }
            case 1005: {
                ((StateZipCode)object).evtHSM_START((ISpellerContext)objectArray[0]);
                return null;
            }
            case 1006: {
                ((StateZipCode)object).error((String)objectArray[0]);
                return null;
            }
            case 1007: {
                ((StateZipCode)object).warn((String)objectArray[0]);
                return null;
            }
            case 1008: {
                ((StateZipCode)object).trace((String)objectArray[0]);
                return null;
            }
            case 1009: {
                ((StateZipCode)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 1010: {
                ((StateZipCode)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 1011: {
                ((StateZipCode)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 1012: {
                ((StateZipCode)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 1013: {
                ((StateZipCode)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 1014: {
                ((StateZipCode)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 1015: {
                ((StateZipCode)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 1016: {
                ((StateZipCode)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 1017: {
                ((StateZipCode)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 1018: {
                ((StateZipCode)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 1019: {
                ((StateZipCode)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 1020: {
                ((StateZipCode)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 1021: {
                ((StateZipCode)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 1022: {
                ((StateZipCode)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 1023: {
                ((StateZipCode)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f32(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 1024: {
                ((StateZipCode)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 1025: {
                ((StateZipCode)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 1026: {
                ((StateZipCode)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 1027: {
                ((StateZipCode)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 1028: {
                ((StateZipCode)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 1029: {
                ((StateZipCode)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 1030: {
                ((StateZipCode)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 1031: {
                ((StateZipCode)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 1032: {
                ((StateZipCode)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 1033: {
                ((StateZipCode)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 1034: {
                ((StateZipCode)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 1035: {
                ((StateZipCode)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 1036: {
                ((StateZipCode)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 1037: {
                ((StateZipCode)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 1038: {
                ((StateZipCode)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 1039: {
                ((StateZipCode)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 1040: {
                ((StateZipCode)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 1041: {
                ((StateZipCode)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 1042: {
                ((StateZipCode)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 1043: {
                ((StateZipCode)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 1044: {
                ((StateZipCode)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 1045: {
                ((StateZipCode)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 1046: {
                ((StateZipCode)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 1047: {
                ((StateZipCode)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 1048: {
                ((StateZipCode)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 1049: {
                ((StateZipCode)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 1050: {
                ((StateZipCode)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 1051: {
                ((StateZipCode)object).addSubject((AbstractReflectionSubject)objectArray[0]);
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
                case 8: {
                    return this.f8(n, object, objectArray);
                }
                case 9: {
                    return this.f9(n, object, objectArray);
                }
                case 10: {
                    return this.f10(n, object, objectArray);
                }
                case 11: {
                    return this.f11(n, object, objectArray);
                }
                case 12: {
                    return this.f12(n, object, objectArray);
                }
                case 13: {
                    return this.f13(n, object, objectArray);
                }
                case 14: {
                    return this.f14(n, object, objectArray);
                }
                case 15: {
                    return this.f15(n, object, objectArray);
                }
                case 16: {
                    return this.f16(n, object, objectArray);
                }
                case 17: {
                    return this.f17(n, object, objectArray);
                }
                case 18: {
                    return this.f18(n, object, objectArray);
                }
                case 19: {
                    return this.f19(n, object, objectArray);
                }
                case 20: {
                    return this.f20(n, object, objectArray);
                }
                case 21: {
                    return this.f21(n, object, objectArray);
                }
                case 22: {
                    return this.f22(n, object, objectArray);
                }
                case 23: {
                    return this.f23(n, object, objectArray);
                }
                case 24: {
                    return this.f24(n, object, objectArray);
                }
                case 25: {
                    return this.f25(n, object, objectArray);
                }
                case 26: {
                    return this.f26(n, object, objectArray);
                }
                case 27: {
                    return this.f27(n, object, objectArray);
                }
                case 28: {
                    return this.f28(n, object, objectArray);
                }
                case 29: {
                    return this.f29(n, object, objectArray);
                }
                case 30: {
                    return this.f30(n, object, objectArray);
                }
                case 31: {
                    return this.f31(n, object, objectArray);
                }
                case 32: {
                    return this.f32(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

