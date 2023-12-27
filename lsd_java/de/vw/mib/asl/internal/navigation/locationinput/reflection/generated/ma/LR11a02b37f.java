/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.reflection.generated.ma;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionSubject;
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
import de.vw.mib.asl.internal.navigation.spellerx.states.StateTop;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.reflection.MethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public final class LR11a02b37f
extends MethodAccessibleObject {
    @Override
    public int getIndex(String string, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case -2146736866: {
                if (bl) {
                    if (n != -292196031) break;
                    n2 = 15;
                    break;
                }
                n2 = 15;
                break;
            }
            case -2074846649: {
                if (bl) {
                    if (n != -1773059229) break;
                    n2 = 37;
                    break;
                }
                n2 = 37;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n != 2035335274) break;
                    n2 = 43;
                    break;
                }
                n2 = 43;
                break;
            }
            case -2008145930: {
                if (bl) {
                    if (n != -303846335) break;
                    n2 = 29;
                    break;
                }
                n2 = 29;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n != 1022694776) break;
                    n2 = 50;
                    break;
                }
                n2 = 50;
                break;
            }
            case -1809478137: {
                if (bl) {
                    if (n != -816611101) break;
                    n2 = 9;
                    break;
                }
                n2 = 9;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n != 830393176) break;
                    n2 = 63;
                    break;
                }
                n2 = 63;
                break;
            }
            case -1787305278: {
                if (bl) {
                    if (n != -394077263) break;
                    n2 = 13;
                    break;
                }
                n2 = 13;
                break;
            }
            case -1776921375: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 73;
                    break;
                }
                n2 = 73;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n != 1672310372) break;
                    n2 = 49;
                    break;
                }
                n2 = 49;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n != 198987640) break;
                    n2 = 54;
                    break;
                }
                n2 = 54;
                break;
            }
            case -1664133069: {
                if (bl) {
                    if (n != -303846335) break;
                    n2 = 20;
                    break;
                }
                n2 = 20;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n != 363071700) break;
                    n2 = 2;
                    break;
                }
                n2 = 2;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n != 560998828) break;
                    n2 = 45;
                    break;
                }
                n2 = 45;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n != -663988092) break;
                    n2 = 69;
                    break;
                }
                n2 = 69;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n != -1970427507) break;
                    n2 = 51;
                    break;
                }
                n2 = 51;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n != -137593161) break;
                    n2 = 41;
                    break;
                }
                n2 = 41;
                break;
            }
            case -1295482316: {
                if (bl) {
                    if (n != 142371135) break;
                    n2 = 80;
                    break;
                }
                n2 = 80;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n != -552141675) break;
                    n2 = 6;
                    break;
                }
                n2 = 6;
                break;
            }
            case -1224576867: {
                if (bl) {
                    if (n != 941556127) break;
                    n2 = 71;
                    break;
                }
                n2 = 71;
                break;
            }
            case -1077557351: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 32;
                    break;
                }
                n2 = 32;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n != 1221567354) break;
                    n2 = 39;
                    break;
                }
                n2 = 39;
                break;
            }
            case -1039689282: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 83;
                    break;
                }
                n2 = 83;
                break;
            }
            case -1000060648: {
                if (bl) {
                    if (n != 26244328) break;
                    n2 = 14;
                    break;
                }
                n2 = 14;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n != 1510966181) break;
                    n2 = 58;
                    break;
                }
                n2 = 58;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n != -986863828) break;
                    n2 = 62;
                    break;
                }
                n2 = 62;
                break;
            }
            case -586502161: {
                if (bl) {
                    if (n != -1262881996) break;
                    n2 = 25;
                    break;
                }
                n2 = 25;
                break;
            }
            case -535487487: {
                if (bl) {
                    if (n != -1585401749) break;
                    n2 = 21;
                    break;
                }
                n2 = 21;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n != 1080370689) break;
                    n2 = 4;
                    break;
                }
                n2 = 4;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n != 1075166657) break;
                    n2 = 1;
                    break;
                }
                n2 = 1;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n != 655582126) break;
                    n2 = 65;
                    break;
                }
                n2 = 65;
                break;
            }
            case -143460498: {
                if (bl) {
                    if (n != -303846335) break;
                    n2 = 19;
                    break;
                }
                n2 = 19;
                break;
            }
            case -142779923: {
                if (bl) {
                    if (n != -1727127582) break;
                    n2 = 27;
                    break;
                }
                n2 = 27;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n != -1975613868) break;
                    n2 = 42;
                    break;
                }
                n2 = 42;
                break;
            }
            case -75307658: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 74;
                    break;
                }
                n2 = 74;
                break;
            }
            case -22682711: {
                if (bl) {
                    if (n != -1053066686) break;
                    n2 = 11;
                    break;
                }
                n2 = 11;
                break;
            }
            case 3642346: {
                if (bl) {
                    if (n == -238538240) {
                        n2 = 77;
                        break;
                    }
                    if (n == -266965504) {
                        n2 = 78;
                        break;
                    }
                    if (n != 17) break;
                    n2 = 79;
                    break;
                }
                n2 = 77;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n != -633848249) break;
                    n2 = 34;
                    break;
                }
                n2 = 34;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n != 1807049881) break;
                    n2 = 72;
                    break;
                }
                n2 = 72;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n != 1644305410) break;
                    n2 = 47;
                    break;
                }
                n2 = 47;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n != -633848249) break;
                    n2 = 33;
                    break;
                }
                n2 = 33;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n != -633848249) break;
                    n2 = 35;
                    break;
                }
                n2 = 35;
                break;
            }
            case 110621981: {
                if (bl) {
                    if (n != -155067449) break;
                    n2 = 76;
                    break;
                }
                n2 = 76;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n != -1930575647) break;
                    n2 = 67;
                    break;
                }
                n2 = 67;
                break;
            }
            case 147697296: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 81;
                    break;
                }
                n2 = 81;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n != 532675816) break;
                    n2 = 70;
                    break;
                }
                n2 = 70;
                break;
            }
            case 314603671: {
                if (bl) {
                    if (n != -292196031) break;
                    n2 = 28;
                    break;
                }
                n2 = 28;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n != -1332779296) break;
                    n2 = 36;
                    break;
                }
                n2 = 36;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n != 204017891) break;
                    n2 = 3;
                    break;
                }
                n2 = 3;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n != 1526617814) break;
                    n2 = 64;
                    break;
                }
                n2 = 64;
                break;
            }
            case 437731210: {
                if (bl) {
                    if (n != 714090704) break;
                    n2 = 26;
                    break;
                }
                n2 = 26;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n != 622325284) break;
                    n2 = 48;
                    break;
                }
                n2 = 48;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n != -1257852358) break;
                    n2 = 68;
                    break;
                }
                n2 = 68;
                break;
            }
            case 593523885: {
                if (bl) {
                    if (n != -1262881996) break;
                    n2 = 12;
                    break;
                }
                n2 = 12;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n != -1097481635) break;
                    n2 = 61;
                    break;
                }
                n2 = 61;
                break;
            }
            case 700591637: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 75;
                    break;
                }
                n2 = 75;
                break;
            }
            case 801808108: {
                if (bl) {
                    if (n != -303846335) break;
                    n2 = 10;
                    break;
                }
                n2 = 10;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n != 1725922795) break;
                    n2 = 59;
                    break;
                }
                n2 = 59;
                break;
            }
            case 921029134: {
                if (bl) {
                    if (n != -303846335) break;
                    n2 = 16;
                    break;
                }
                n2 = 16;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n != -395758302) break;
                    n2 = 0;
                    break;
                }
                n2 = 0;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n != -1864762263) break;
                    n2 = 60;
                    break;
                }
                n2 = 60;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n != -1024602568) break;
                    n2 = 57;
                    break;
                }
                n2 = 57;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n != -467118332) break;
                    n2 = 40;
                    break;
                }
                n2 = 40;
                break;
            }
            case 1244919775: {
                if (bl) {
                    if (n != -1985511187) break;
                    n2 = 31;
                    break;
                }
                n2 = 31;
                break;
            }
            case 1272313548: {
                if (bl) {
                    if (n != -292196031) break;
                    n2 = 23;
                    break;
                }
                n2 = 23;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n != -1251231692) break;
                    n2 = 7;
                    break;
                }
                n2 = 7;
                break;
            }
            case 1324303610: {
                if (bl) {
                    if (n != -936820918) break;
                    n2 = 22;
                    break;
                }
                n2 = 22;
                break;
            }
            case 1373693704: {
                if (bl) {
                    if (n != -303846335) break;
                    n2 = 24;
                    break;
                }
                n2 = 24;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n != 714516851) break;
                    n2 = 56;
                    break;
                }
                n2 = 56;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n != 1277656696) break;
                    n2 = 44;
                    break;
                }
                n2 = 44;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n != 2144179776) break;
                    n2 = 52;
                    break;
                }
                n2 = 52;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n != 986637335) break;
                    n2 = 5;
                    break;
                }
                n2 = 5;
                break;
            }
            case 1639307534: {
                if (bl) {
                    if (n != -829527491) break;
                    n2 = 17;
                    break;
                }
                n2 = 17;
                break;
            }
            case 1679423848: {
                if (bl) {
                    if (n != -303846335) break;
                    n2 = 30;
                    break;
                }
                n2 = 30;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n != 588643339) break;
                    n2 = 55;
                    break;
                }
                n2 = 55;
                break;
            }
            case 1817739933: {
                if (bl) {
                    if (n != -829527491) break;
                    n2 = 18;
                    break;
                }
                n2 = 18;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n != -292196031) break;
                    n2 = 8;
                    break;
                }
                n2 = 8;
                break;
            }
            case 1902066701: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 84;
                    break;
                }
                n2 = 84;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n != 1779174193) break;
                    n2 = 46;
                    break;
                }
                n2 = 46;
                break;
            }
            case 1950569015: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 82;
                    break;
                }
                n2 = 82;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n != -1073556674) break;
                    n2 = 38;
                    break;
                }
                n2 = 38;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n != 1196729427) break;
                    n2 = 53;
                    break;
                }
                n2 = 53;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n != 1669104671) break;
                    n2 = 66;
                    break;
                }
                n2 = 66;
                break;
            }
        }
        return n2;
    }

    @Override
    public Object invoke(int n, Object object, Object[] objectArray) {
        try {
            switch (n) {
                case 0: {
                    ((StateTop)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                    return null;
                }
                case 1: {
                    ((StateTop)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                    return null;
                }
                case 2: {
                    ((StateTop)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                    return null;
                }
                case 3: {
                    ((StateTop)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                    return null;
                }
                case 4: {
                    ((StateTop)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                    return null;
                }
                case 5: {
                    ((StateTop)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                    return null;
                }
                case 6: {
                    ((StateTop)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                    return null;
                }
                case 7: {
                    ((StateTop)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                    return null;
                }
                case 8: {
                    ((StateTop)object).evtHSM_EXIT((AbstractReflectionContext)objectArray[0]);
                    return null;
                }
                case 9: {
                    ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_COPY_LOCATION((SpellerContext)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                    return null;
                }
                case 10: {
                    ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_SET_LAST_INPUT_MODE((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 11: {
                    ((StateTop)object).evtEV_START_SPELLER_BY_HANDLER((ISpellerContext)objectArray[0], (SpellerHandler)objectArray[1]);
                    return null;
                }
                case 12: {
                    ((StateTop)object).evtEV_STRIP_BY_STRIP_ID((ISpellerContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 13: {
                    ((StateTop)object).evtEV_SET_CONTEXT_LOCATION((ISpellerContext)objectArray[0], (NavLocation)objectArray[1]);
                    return null;
                }
                case 14: {
                    ((StateTop)object).evtEV_SAVE_SPELLER_BY_HANDLER((SpellerContext)objectArray[0], (SpellerHandler)objectArray[1]);
                    return null;
                }
                case 15: {
                    ((StateTop)object).evtASL_NAVIGATION_HOMEDESTINPUT_INIT((AbstractReflectionContext)objectArray[0]);
                    return null;
                }
                case 16: {
                    ((StateTop)object).evtEV_LOCATION_INPUT_START_INPUT((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 17: {
                    ((StateTop)object).evtEV_LOCATION_INPUT_SET_INPUT((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                    return null;
                }
                case 18: {
                    ((StateTop)object).evtEV_LOCATION_INPUT_SELECT_ENTRY_VIA_ID((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                    return null;
                }
                case 19: {
                    ((StateTop)object).evtEV_LOCATION_INPUT_CANCEL_INPUT((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 20: {
                    ((StateTop)object).evtEV_LOCATION_INPUT_SELECT_NOTHING((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 21: {
                    ((StateTop)object).evtEV_LOCATION_INPUT_SET_CURRENT_LOCATION((AbstractReflectionContext)objectArray[0], objectArray[1]);
                    return null;
                }
                case 22: {
                    ((StateTop)object).evtEV_LOCATION_INPUT_SELECT_ENTRY_VIA_INDEX((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                    return null;
                }
                case 23: {
                    ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_INIT_LOCATION((AbstractReflectionContext)objectArray[0]);
                    return null;
                }
                case 24: {
                    ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_DELETE_FIELD((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 25: {
                    ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_SET_LOCATION_INPUT_PATH((ISpellerContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 26: {
                    ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_SET_HWR_SPELLER_MODE_ENABLED((AbstractReflectionContext)objectArray[0], (Boolean)objectArray[1]);
                    return null;
                }
                case 27: {
                    ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_INIT_FIELD((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                    return null;
                }
                case 28: {
                    ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_CANCEL_FIELD((AbstractReflectionContext)objectArray[0]);
                    return null;
                }
                case 29: {
                    ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_START_ROUTE_CALC_FROM_DETAILVIEW((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 30: {
                    ((StateTop)object).evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SET_MATCH_LIST_LIMIT((AbstractReflectionContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 31: {
                    ((StateTop)object).handleIconCacheUpdate((IconKey)objectArray[0], (ResourceLocator)objectArray[1], objectArray[2]);
                    return null;
                }
                case 32: {
                    return ((StateTop)object).getDefaultIcon();
                }
                case 33: {
                    ((StateTop)object).error((String)objectArray[0]);
                    return null;
                }
                case 34: {
                    ((StateTop)object).warn((String)objectArray[0]);
                    return null;
                }
                case 35: {
                    ((StateTop)object).trace((String)objectArray[0]);
                    return null;
                }
                case 36: {
                    ((StateTop)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                    return null;
                }
                case 37: {
                    ((StateTop)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                    return null;
                }
                case 38: {
                    ((StateTop)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                    return null;
                }
                case 39: {
                    ((StateTop)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                    return null;
                }
                case 40: {
                    ((StateTop)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                    return null;
                }
                case 41: {
                    ((StateTop)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                    return null;
                }
                case 42: {
                    ((StateTop)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                    return null;
                }
                case 43: {
                    ((StateTop)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                    return null;
                }
                case 44: {
                    ((StateTop)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                    return null;
                }
                case 45: {
                    ((StateTop)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                    return null;
                }
                case 46: {
                    ((StateTop)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                    return null;
                }
                case 47: {
                    ((StateTop)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                    return null;
                }
                case 48: {
                    ((StateTop)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                    return null;
                }
                case 49: {
                    ((StateTop)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                    return null;
                }
                case 50: {
                    ((StateTop)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                    return null;
                }
                case 51: {
                    ((StateTop)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                    return null;
                }
                case 52: {
                    ((StateTop)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                    return null;
                }
                case 53: {
                    ((StateTop)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                    return null;
                }
                case 54: {
                    ((StateTop)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                    return null;
                }
                case 55: {
                    ((StateTop)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                    return null;
                }
                case 56: {
                    ((StateTop)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                    return null;
                }
                case 57: {
                    ((StateTop)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                    return null;
                }
                case 58: {
                    ((StateTop)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                    return null;
                }
                case 59: {
                    ((StateTop)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                    return null;
                }
                case 60: {
                    ((StateTop)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                    return null;
                }
                case 61: {
                    ((StateTop)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                    return null;
                }
                case 62: {
                    ((StateTop)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                    return null;
                }
                case 63: {
                    ((StateTop)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                    return null;
                }
                case 64: {
                    ((StateTop)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                    return null;
                }
                case 65: {
                    ((StateTop)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                    return null;
                }
                case 66: {
                    ((StateTop)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                    return null;
                }
                case 67: {
                    ((StateTop)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                    return null;
                }
                case 68: {
                    ((StateTop)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                    return null;
                }
                case 69: {
                    ((StateTop)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                    return null;
                }
                case 70: {
                    ((StateTop)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                    return null;
                }
                case 71: {
                    return ((StateTop)object).handle((EventGeneric)objectArray[0]);
                }
                case 72: {
                    ((StateTop)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                    return null;
                }
                case 73: {
                    return ((StateTop)object).toString();
                }
                case 74: {
                    return ((StateTop)object).getName();
                }
                case 75: {
                    return ((StateTop)object).getParent();
                }
                case 76: {
                    ((StateTop)object).trans((HsmState)objectArray[0]);
                    return null;
                }
                case 77: {
                    ((StateTop)object).wait(((Number)objectArray[0]).longValue());
                    return null;
                }
                case 78: {
                    ((StateTop)object).wait(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 79: {
                    ((StateTop)object).wait();
                    return null;
                }
                case 80: {
                    return RuntimeUtil.valueOf(((StateTop)object).equals(objectArray[0]));
                }
                case 81: {
                    return RuntimeUtil.valueOf(((StateTop)object).hashCode());
                }
                case 82: {
                    return ((StateTop)object).getClass();
                }
                case 83: {
                    ((StateTop)object).notify();
                    return null;
                }
                case 84: {
                    ((StateTop)object).notifyAll();
                    return null;
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}
