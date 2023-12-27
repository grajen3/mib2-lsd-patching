/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.reflection.generated.ma;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
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
import de.vw.mib.asl.internal.navigation.spellerx.subjects.ChinaMatchTextHnrSubject;
import de.vw.mib.reflection.MethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR1c384c991
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
            case -2074846649: {
                if (bl) {
                    if (n != -1773059229) break;
                    n2 = 26;
                    break;
                }
                n2 = 26;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n != 2035335274) break;
                    n2 = 4;
                    break;
                }
                n2 = 4;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n != 1022694776) break;
                    n2 = 35;
                    break;
                }
                n2 = 35;
                break;
            }
            case -1858508694: {
                if (bl) {
                    if (n != -1251231692) break;
                    n2 = 20;
                    break;
                }
                n2 = 20;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n != 830393176) break;
                    n2 = 10;
                    break;
                }
                n2 = 10;
                break;
            }
            case -1789895108: {
                if (bl) {
                    if (n != -638526483) break;
                    n2 = 56;
                    break;
                }
                n2 = 56;
                break;
            }
            case -1776921375: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 63;
                    break;
                }
                n2 = 63;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n != 1672310372) break;
                    n2 = 34;
                    break;
                }
                n2 = 34;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n != 198987640) break;
                    n2 = 38;
                    break;
                }
                n2 = 38;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n != 363071700) break;
                    n2 = 6;
                    break;
                }
                n2 = 6;
                break;
            }
            case -1460589831: {
                if (bl) {
                    if (n != -1029654912) break;
                    n2 = 16;
                    break;
                }
                n2 = 16;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n != 560998828) break;
                    n2 = 30;
                    break;
                }
                n2 = 30;
                break;
            }
            case -1436755036: {
                if (bl) {
                    if (n != -638526483) break;
                    n2 = 57;
                    break;
                }
                n2 = 57;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n != -663988092) break;
                    n2 = 54;
                    break;
                }
                n2 = 54;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n != -1970427507) break;
                    n2 = 8;
                    break;
                }
                n2 = 8;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n != -137593161) break;
                    n2 = 2;
                    break;
                }
                n2 = 2;
                break;
            }
            case -1295482316: {
                if (bl) {
                    if (n != 142371135) break;
                    n2 = 62;
                    break;
                }
                n2 = 62;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n != -552141675) break;
                    n2 = 48;
                    break;
                }
                n2 = 48;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n != 1221567354) break;
                    n2 = 28;
                    break;
                }
                n2 = 28;
                break;
            }
            case -1039689282: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 66;
                    break;
                }
                n2 = 66;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n != 1510966181) break;
                    n2 = 43;
                    break;
                }
                n2 = 43;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n != -986863828) break;
                    n2 = 47;
                    break;
                }
                n2 = 47;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n != 1080370689) break;
                    n2 = 40;
                    break;
                }
                n2 = 40;
                break;
            }
            case -470671263: {
                if (bl) {
                    if (n != -1251231692) break;
                    n2 = 17;
                    break;
                }
                n2 = 17;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n != 1075166657) break;
                    n2 = 5;
                    break;
                }
                n2 = 5;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n != 655582126) break;
                    n2 = 50;
                    break;
                }
                n2 = 50;
                break;
            }
            case -136351970: {
                if (bl) {
                    if (n != -1262881996) break;
                    n2 = 15;
                    break;
                }
                n2 = 15;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n != -1975613868) break;
                    n2 = 3;
                    break;
                }
                n2 = 3;
                break;
            }
            case -40965379: {
                if (bl) {
                    if (n != -1029654912) break;
                    n2 = 21;
                    break;
                }
                n2 = 21;
                break;
            }
            case 3642346: {
                if (bl) {
                    if (n == -238538240) {
                        n2 = 59;
                        break;
                    }
                    if (n == -266965504) {
                        n2 = 60;
                        break;
                    }
                    if (n != 17) break;
                    n2 = 61;
                    break;
                }
                n2 = 59;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n != 1644305410) break;
                    n2 = 32;
                    break;
                }
                n2 = 32;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n != -1930575647) break;
                    n2 = 52;
                    break;
                }
                n2 = 52;
                break;
            }
            case 147697296: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 64;
                    break;
                }
                n2 = 64;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n != 532675816) break;
                    n2 = 55;
                    break;
                }
                n2 = 55;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n != -1332779296) break;
                    n2 = 0;
                    break;
                }
                n2 = 0;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n != 204017891) break;
                    n2 = 33;
                    break;
                }
                n2 = 33;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n != 1526617814) break;
                    n2 = 49;
                    break;
                }
                n2 = 49;
                break;
            }
            case 437731210: {
                if (bl) {
                    if (n != 714090704) break;
                    n2 = 13;
                    break;
                }
                n2 = 13;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n != 622325284) break;
                    n2 = 7;
                    break;
                }
                n2 = 7;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n != -1257852358) break;
                    n2 = 53;
                    break;
                }
                n2 = 53;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n != -1097481635) break;
                    n2 = 9;
                    break;
                }
                n2 = 9;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n != 1725922795) break;
                    n2 = 45;
                    break;
                }
                n2 = 45;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n != -395758302) break;
                    n2 = 25;
                    break;
                }
                n2 = 25;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n != -1864762263) break;
                    n2 = 46;
                    break;
                }
                n2 = 46;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n != -1024602568) break;
                    n2 = 42;
                    break;
                }
                n2 = 42;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n != -467118332) break;
                    n2 = 1;
                    break;
                }
                n2 = 1;
                break;
            }
            case 1280701031: {
                if (bl) {
                    if (n != -1251231692) break;
                    n2 = 11;
                    break;
                }
                n2 = 11;
                break;
            }
            case 1293790807: {
                if (bl) {
                    if (n != -1251231692) break;
                    n2 = 14;
                    break;
                }
                n2 = 14;
                break;
            }
            case 1401139041: {
                if (bl) {
                    if (n != 1737467036) break;
                    n2 = 18;
                    break;
                }
                n2 = 18;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n != 714516851) break;
                    n2 = 41;
                    break;
                }
                n2 = 41;
                break;
            }
            case 1437274649: {
                if (bl) {
                    if (n != -1262881996) break;
                    n2 = 19;
                    break;
                }
                n2 = 19;
                break;
            }
            case 1465402121: {
                if (bl) {
                    if (n != -638526483) break;
                    n2 = 58;
                    break;
                }
                n2 = 58;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n != 1277656696) break;
                    n2 = 29;
                    break;
                }
                n2 = 29;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n != 2144179776) break;
                    n2 = 36;
                    break;
                }
                n2 = 36;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n != 986637335) break;
                    n2 = 44;
                    break;
                }
                n2 = 44;
                break;
            }
            case 1737278546: {
                if (bl) {
                    if (n != -1251231692) break;
                    n2 = 22;
                    break;
                }
                n2 = 22;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n != 588643339) break;
                    n2 = 39;
                    break;
                }
                n2 = 39;
                break;
            }
            case 1842438131: {
                if (bl) {
                    if (n != -1251231692) break;
                    n2 = 12;
                    break;
                }
                n2 = 12;
                break;
            }
            case 1902066701: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 67;
                    break;
                }
                n2 = 67;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n != 1779174193) break;
                    n2 = 31;
                    break;
                }
                n2 = 31;
                break;
            }
            case 1950569015: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 65;
                    break;
                }
                n2 = 65;
                break;
            }
            case 1976808247: {
                if (bl) {
                    if (n != -1029654912) break;
                    n2 = 24;
                    break;
                }
                n2 = 24;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n != -1073556674) break;
                    n2 = 27;
                    break;
                }
                n2 = 27;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n != 1196729427) break;
                    n2 = 37;
                    break;
                }
                n2 = 37;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n != 1669104671) break;
                    n2 = 51;
                    break;
                }
                n2 = 51;
                break;
            }
            case 2101122672: {
                if (bl) {
                    if (n != -1251231692) break;
                    n2 = 23;
                    break;
                }
                n2 = 23;
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
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                    return null;
                }
                case 1: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                    return null;
                }
                case 2: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                    return null;
                }
                case 3: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                    return null;
                }
                case 4: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                    return null;
                }
                case 5: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                    return null;
                }
                case 6: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                    return null;
                }
                case 7: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                    return null;
                }
                case 8: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                    return null;
                }
                case 9: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                    return null;
                }
                case 10: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                    return null;
                }
                case 11: {
                    ((ChinaMatchTextHnrSubject)object).evtHSM_ENTRY((ISpellerContext)objectArray[0]);
                    return null;
                }
                case 12: {
                    ((ChinaMatchTextHnrSubject)object).evtHSM_EXIT((ISpellerContext)objectArray[0]);
                    return null;
                }
                case 13: {
                    ((ChinaMatchTextHnrSubject)object).evtASL_NAVIGATION_LOCATIONINPUT_SET_HWR_SPELLER_MODE_ENABLED((AbstractReflectionContext)objectArray[0], (Boolean)objectArray[1]);
                    return null;
                }
                case 14: {
                    ((ChinaMatchTextHnrSubject)object).evtHSM_START((ISpellerContext)objectArray[0]);
                    return null;
                }
                case 15: {
                    ((ChinaMatchTextHnrSubject)object).evtEV_SELECT_VIA_INDEX((ISpellerContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 16: {
                    ((ChinaMatchTextHnrSubject)object).evtEV_SELECT_VIA_ID((ISpellerContext)objectArray[0], (String)objectArray[1]);
                    return null;
                }
                case 17: {
                    ((ChinaMatchTextHnrSubject)object).evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING((ISpellerContext)objectArray[0]);
                    return null;
                }
                case 18: {
                    ((ChinaMatchTextHnrSubject)object).evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER_HWR((ISpellerContext)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                    return null;
                }
                case 19: {
                    ((ChinaMatchTextHnrSubject)object).evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH((ISpellerContext)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 20: {
                    ((ChinaMatchTextHnrSubject)object).evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH((ISpellerContext)objectArray[0]);
                    return null;
                }
                case 21: {
                    ((ChinaMatchTextHnrSubject)object).evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_ADD_CHARACTER((ISpellerContext)objectArray[0], (String)objectArray[1]);
                    return null;
                }
                case 22: {
                    ((ChinaMatchTextHnrSubject)object).evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_CLEAR_ALL_CHARACTERS((ISpellerContext)objectArray[0]);
                    return null;
                }
                case 23: {
                    ((ChinaMatchTextHnrSubject)object).evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_FILTER_BY_UNDO_LAST_CHARACTERS((ISpellerContext)objectArray[0]);
                    return null;
                }
                case 24: {
                    ((ChinaMatchTextHnrSubject)object).evtEV_SET_INPUT((ISpellerContext)objectArray[0], (String)objectArray[1]);
                    return null;
                }
                case 25: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                    return null;
                }
                case 26: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                    return null;
                }
                case 27: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                    return null;
                }
                case 28: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                    return null;
                }
                case 29: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                    return null;
                }
                case 30: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                    return null;
                }
                case 31: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                    return null;
                }
                case 32: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                    return null;
                }
                case 33: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                    return null;
                }
                case 34: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                    return null;
                }
                case 35: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                    return null;
                }
                case 36: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                    return null;
                }
                case 37: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                    return null;
                }
                case 38: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                    return null;
                }
                case 39: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                    return null;
                }
                case 40: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                    return null;
                }
                case 41: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                    return null;
                }
                case 42: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                    return null;
                }
                case 43: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                    return null;
                }
                case 44: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                    return null;
                }
                case 45: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                    return null;
                }
                case 46: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                    return null;
                }
                case 47: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                    return null;
                }
                case 48: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                    return null;
                }
                case 49: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                    return null;
                }
                case 50: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                    return null;
                }
                case 51: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                    return null;
                }
                case 52: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                    return null;
                }
                case 53: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                    return null;
                }
                case 54: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                    return null;
                }
                case 55: {
                    ((ChinaMatchTextHnrSubject)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                    return null;
                }
                case 56: {
                    return RuntimeUtil.valueOf(((ChinaMatchTextHnrSubject)object).handleBefore((String)objectArray[0], (Class[])objectArray[1], (Object[])objectArray[2]));
                }
                case 57: {
                    ((ChinaMatchTextHnrSubject)object).handleNormal((String)objectArray[0], (Class[])objectArray[1], (Object[])objectArray[2]);
                    return null;
                }
                case 58: {
                    ((ChinaMatchTextHnrSubject)object).handleAfter((String)objectArray[0], (Class[])objectArray[1], (Object[])objectArray[2]);
                    return null;
                }
                case 59: {
                    ((ChinaMatchTextHnrSubject)object).wait(((Number)objectArray[0]).longValue());
                    return null;
                }
                case 60: {
                    ((ChinaMatchTextHnrSubject)object).wait(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 61: {
                    ((ChinaMatchTextHnrSubject)object).wait();
                    return null;
                }
                case 62: {
                    return RuntimeUtil.valueOf(((ChinaMatchTextHnrSubject)object).equals(objectArray[0]));
                }
                case 63: {
                    return ((ChinaMatchTextHnrSubject)object).toString();
                }
                case 64: {
                    return RuntimeUtil.valueOf(((ChinaMatchTextHnrSubject)object).hashCode());
                }
                case 65: {
                    return ((ChinaMatchTextHnrSubject)object).getClass();
                }
                case 66: {
                    ((ChinaMatchTextHnrSubject)object).notify();
                    return null;
                }
                case 67: {
                    ((ChinaMatchTextHnrSubject)object).notifyAll();
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

