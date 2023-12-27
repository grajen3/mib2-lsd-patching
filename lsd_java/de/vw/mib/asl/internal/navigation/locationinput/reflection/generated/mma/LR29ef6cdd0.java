/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.reflection.generated.mma;

import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.api.navigation.locationinput.ILocationinputResultListener;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionSubject;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionTarget;
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
import de.vw.mib.asl.internal.navigation.speller.handler.DemoInputHandler;
import de.vw.mib.asl.internal.navigation.speller.handler.HomeInputHandler;
import de.vw.mib.asl.internal.navigation.speller.handler.MemoryInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTargetDecorator;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public final class LR29ef6cdd0
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1267019238: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -934829276: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 40349632: {
                if (bl) {
                    if (n2 != 1807049881) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 834463203: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
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
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -2007156411: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -951628120: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -360345634: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 173607207: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
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
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -2007156411: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -951628120: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case -360345634: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case 173607207: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2007156411: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -951628120: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case -360345634: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 173607207: {
                if (bl) {
                    if (n2 != 1298868472) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2142640248: {
                if (bl) {
                    if (n2 != 769423948) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case -1777055755: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case -1693928994: {
                if (bl) {
                    if (n2 != 536494077) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case -1601049455: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -1317534195: {
                if (bl) {
                    if (n2 != 769423948) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -1267019238: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case -1188210659: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -1037974651: {
                if (bl) {
                    if (n2 != -1789419218) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case -1021236453: {
                if (bl) {
                    if (n2 != 812283452) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -934829276: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case -930384543: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -867854447: {
                if (bl) {
                    if (n2 != -171986214) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case 72298373: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case 834463203: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case 913196443: {
                if (bl) {
                    if (n2 != -298597974) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case 989766402: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case 1050475726: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 1115162348: {
                if (bl) {
                    if (n2 != -1789419218) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case 1333867741: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 1409347744: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case 1411644586: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 1416259875: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case 1658266712: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 1729664393: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
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
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case -1365561861: {
                if (bl) {
                    if (n2 != -1970427507) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case -1364744154: {
                if (bl) {
                    if (n2 != -137593161) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case 166616976: {
                if (bl) {
                    if (n2 != 532675816) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case 1845314727: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
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
            case -1568918276: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1518357898: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -1168472296: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case -797253623: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case -305900166: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1355711356: {
                n2 = this.a5(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                return ((AbstractReflectionTarget)object).getMyShortName();
            }
            case 1: {
                ((AbstractReflectionTarget)object).regEvt(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                return RuntimeUtil.valueOf(((AbstractReflectionTarget)object).isFuntionNameTracing());
            }
            case 3: {
                ((AbstractReflectionTarget)object).addSubject((AbstractReflectionSubject)objectArray[0]);
                return null;
            }
            case 4: {
                ((DemoInputHandler)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DemoInputHandler)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DemoInputHandler)object).onActivated((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 7: {
                ((DemoInputHandler)object).onLocationDiscarded((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 8: {
                ((DemoInputHandler)object).onLocationSaved((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 9: {
                ((DemoInputHandler)object).onContext((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 10: {
                ((DemoInputHandler)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 11: {
                ((DemoInputHandler)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 12: {
                ((DemoInputHandler)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 13: {
                ((DemoInputHandler)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 14: {
                ((DemoInputHandler)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 15: {
                ((DemoInputHandler)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 16: {
                ((DemoInputHandler)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 17: {
                ((DemoInputHandler)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 18: {
                ((DemoInputHandler)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 19: {
                ((DemoInputHandler)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 20: {
                ((DemoInputHandler)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 21: {
                ((DemoInputHandler)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 22: {
                ((DemoInputHandler)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 23: {
                ((DemoInputHandler)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 24: {
                ((DemoInputHandler)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 25: {
                ((DemoInputHandler)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 26: {
                ((DemoInputHandler)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 27: {
                ((DemoInputHandler)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 28: {
                ((DemoInputHandler)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 29: {
                ((DemoInputHandler)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 30: {
                ((DemoInputHandler)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 31: {
                ((DemoInputHandler)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DemoInputHandler)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 33: {
                ((DemoInputHandler)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 34: {
                ((DemoInputHandler)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 35: {
                ((DemoInputHandler)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 36: {
                ((DemoInputHandler)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 37: {
                ((DemoInputHandler)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 38: {
                ((DemoInputHandler)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 39: {
                ((DemoInputHandler)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 40: {
                ((DemoInputHandler)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 41: {
                ((DemoInputHandler)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 42: {
                ((DemoInputHandler)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 43: {
                ((DemoInputHandler)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 44: {
                ((DemoInputHandler)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 45: {
                ((DemoInputHandler)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 46: {
                ((DemoInputHandler)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 47: {
                ((DemoInputHandler)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 48: {
                ((DemoInputHandler)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 49: {
                ((DemoInputHandler)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 50: {
                ((DemoInputHandler)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 51: {
                ((DemoInputHandler)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 52: {
                ((HomeInputHandler)object).onActivated((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 53: {
                ((HomeInputHandler)object).onLocationDiscarded((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 54: {
                ((HomeInputHandler)object).onLocationSaved((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 55: {
                ((HomeInputHandler)object).onContext((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 56: {
                ((HomeInputHandler)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 57: {
                ((HomeInputHandler)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 58: {
                ((HomeInputHandler)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 59: {
                ((HomeInputHandler)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 60: {
                ((HomeInputHandler)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 61: {
                ((HomeInputHandler)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 62: {
                ((HomeInputHandler)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 63: {
                ((HomeInputHandler)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((HomeInputHandler)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 65: {
                ((HomeInputHandler)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 66: {
                ((HomeInputHandler)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 67: {
                ((HomeInputHandler)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 68: {
                ((HomeInputHandler)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 69: {
                ((HomeInputHandler)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 70: {
                ((HomeInputHandler)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 71: {
                ((HomeInputHandler)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 72: {
                ((HomeInputHandler)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 73: {
                ((HomeInputHandler)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 74: {
                ((HomeInputHandler)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 75: {
                ((HomeInputHandler)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 76: {
                ((HomeInputHandler)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 77: {
                ((HomeInputHandler)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 78: {
                ((HomeInputHandler)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 79: {
                ((HomeInputHandler)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 80: {
                ((HomeInputHandler)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 81: {
                ((HomeInputHandler)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 82: {
                ((HomeInputHandler)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 83: {
                ((HomeInputHandler)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 84: {
                ((HomeInputHandler)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 85: {
                ((HomeInputHandler)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 86: {
                ((HomeInputHandler)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 87: {
                ((HomeInputHandler)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 88: {
                ((HomeInputHandler)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 89: {
                ((HomeInputHandler)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 90: {
                ((HomeInputHandler)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 91: {
                ((HomeInputHandler)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 92: {
                ((HomeInputHandler)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 93: {
                ((HomeInputHandler)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 94: {
                ((HomeInputHandler)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 95: {
                ((HomeInputHandler)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((HomeInputHandler)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 97: {
                ((HomeInputHandler)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 98: {
                ((MemoryInputHandler)object).onActivated((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 99: {
                ((MemoryInputHandler)object).onLocationDiscarded((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 100: {
                ((MemoryInputHandler)object).onLocationSaved((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 101: {
                ((MemoryInputHandler)object).onContext((de.vw.mib.asl.internal.navigation.speller.SpellerContext)objectArray[0]);
                return null;
            }
            case 102: {
                return XSpellerTarget.getHandler(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
            }
            case 103: {
                return ((XSpellerTarget)object).getLogger();
            }
            case 104: {
                return ((XSpellerTarget)object).getDefaultWorkState();
            }
            case 105: {
                ((XSpellerTarget)object).setSpellerContext((SpellerContext)objectArray[0]);
                return null;
            }
            case 106: {
                return ((XSpellerTarget)object).getSpellerContext();
            }
            case 107: {
                ((XSpellerTarget)object).selectHandler(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 108: {
                XSpellerTarget.addHandler(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (SpellerHandler)objectArray[2]);
                return null;
            }
            case 109: {
                return ((XSpellerTarget)object).getCurrentContext();
            }
            case 110: {
                XSpellerTarget.startSpeller((SpellerHandler)objectArray[0]);
                return null;
            }
            case 111: {
                XSpellerTarget.saveSpeller((SpellerHandler)objectArray[0]);
                return null;
            }
            case 112: {
                ((XSpellerTarget)object).freezeAllLists();
                return null;
            }
            case 113: {
                return XSpellerTarget.getExtCurrentLocation();
            }
            case 114: {
                return XSpellerTarget.getExtAvailableSelectionCriteria();
            }
            case 115: {
                return RuntimeUtil.valueOf(XSpellerTarget.isExtInputActive());
            }
            case 116: {
                return RuntimeUtil.valueOf(XSpellerTarget.getExtIsFullPostalCode());
            }
            case 117: {
                XSpellerTarget.changeExtInterfaceList((LIValueList)objectArray[0], ((Number)objectArray[1]).longValue(), (IHnrFlags)objectArray[2]);
                return null;
            }
            case 118: {
                XSpellerTarget.changeExtInterfaceInputActive((Boolean)objectArray[0]);
                return null;
            }
            case 119: {
                XSpellerTarget.extInputHapticTakesOver();
                return null;
            }
            case 120: {
                XSpellerTarget.extInputErrorMessage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 121: {
                XSpellerTarget.changeExtLocation((NavLocation)objectArray[0], (int[])objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 122: {
                XSpellerTarget.registerListener((ILocationinputResultListener)objectArray[0]);
                return null;
            }
            case 123: {
                XSpellerTarget.unregisterListener((ILocationinputResultListener)objectArray[0]);
                return null;
            }
            case 124: {
                return ((XSpellerTarget)object).getMyShortName();
            }
            case 125: {
                ((XSpellerTarget)object).regEvt(((Number)objectArray[0]).intValue());
                return null;
            }
            case 126: {
                return RuntimeUtil.valueOf(((XSpellerTarget)object).isFuntionNameTracing());
            }
            case 127: {
                ((XSpellerTargetDecorator)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((XSpellerTargetDecorator)object).handleFullFacotryReset();
                return null;
            }
            case 129: {
                ((XSpellerTargetDecorator)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 130: {
                ((XSpellerTargetDecorator)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 131: {
                ((XSpellerTargetDecorator)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 132: {
                ((XSpellerTargetDecorator)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 133: {
                ((XSpellerTargetDecorator)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 134: {
                ((XSpellerTargetDecorator)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 135: {
                ((XSpellerTargetDecorator)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 136: {
                ((XSpellerTargetDecorator)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 137: {
                ((XSpellerTargetDecorator)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 138: {
                ((XSpellerTargetDecorator)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 139: {
                ((XSpellerTargetDecorator)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 140: {
                ((XSpellerTargetDecorator)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 141: {
                ((XSpellerTargetDecorator)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 142: {
                ((XSpellerTargetDecorator)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 143: {
                ((XSpellerTargetDecorator)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 144: {
                ((XSpellerTargetDecorator)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 145: {
                ((XSpellerTargetDecorator)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 146: {
                ((XSpellerTargetDecorator)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 147: {
                ((XSpellerTargetDecorator)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 148: {
                ((XSpellerTargetDecorator)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 149: {
                ((XSpellerTargetDecorator)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 150: {
                ((XSpellerTargetDecorator)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 151: {
                ((XSpellerTargetDecorator)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 152: {
                ((XSpellerTargetDecorator)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 153: {
                ((XSpellerTargetDecorator)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
            case 154: {
                ((XSpellerTargetDecorator)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 155: {
                ((XSpellerTargetDecorator)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 156: {
                ((XSpellerTargetDecorator)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 157: {
                ((XSpellerTargetDecorator)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 158: {
                ((XSpellerTargetDecorator)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 159: {
                ((XSpellerTargetDecorator)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((XSpellerTargetDecorator)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 161: {
                ((XSpellerTargetDecorator)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 162: {
                ((XSpellerTargetDecorator)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 163: {
                ((XSpellerTargetDecorator)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 164: {
                ((XSpellerTargetDecorator)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 165: {
                ((XSpellerTargetDecorator)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 166: {
                ((XSpellerTargetDecorator)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 167: {
                ((XSpellerTargetDecorator)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 168: {
                ((XSpellerTargetDecorator)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 169: {
                ((XSpellerTargetDecorator)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

