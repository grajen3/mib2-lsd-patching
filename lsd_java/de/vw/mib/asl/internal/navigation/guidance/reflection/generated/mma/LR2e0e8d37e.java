/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.reflection.generated.mma;

import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.guidance.IOnlineTourImportListener;
import de.vw.mib.asl.internal.navigation.adjustposition.TargetAdjustPosition;
import de.vw.mib.asl.internal.navigation.borderchange.HsmTargetBorderChange;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.destinput.HsmTargetDestList;
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
import de.vw.mib.asl.internal.navigation.guidance.HsmTargetLaneGuidance;
import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.asl.internal.navigation.guidance.congestion.HsmTargetCongestionAhead;
import de.vw.mib.asl.internal.navigation.guidance.info.HsmTargetInfo;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.asl.internal.navigation.guidance.ppoi.proximity.TargetPPOIApproach;
import de.vw.mib.asl.internal.navigation.guidance.vza.HsmTargetVZA;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupHsmTarget;
import de.vw.mib.asl.internal.navigation.pnav.TargetPredictiveNavigationSplitscreen;
import de.vw.mib.asl.internal.navigation.routeoptions.HsmTargetRouteOptions;
import de.vw.mib.asl.internal.navigation.tourmode.TargetTourMemory;
import de.vw.mib.asl.internal.navigation.tourmode.TargetTourView;
import de.vw.mib.asl.internal.navigation.waypointmode.HsmTargetWayPointMode;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmInternalAPINotifier;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TourImportStatus;
import org.dsi.ifc.predictivenavigation.LikelyDestination;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public final class LR2e0e8d37e
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1984258744: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
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
            case -48786765: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
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
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 527085336: {
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
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1566698914: {
                if (bl) {
                    if (n2 != -200198824) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1077557351: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 398960634: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 407773447: {
                if (bl) {
                    if (n2 != -1622239583) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 727335687: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1244919775: {
                if (bl) {
                    if (n2 != -1985511187) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
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
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 269677393: {
                if (bl) {
                    if (n2 != -912290783) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 727335687: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != 66574611) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1896963995: {
                if (bl) {
                    if (n2 != -115882523) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
        }
        return n3;
    }

    private int a5(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != 1163392726) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
        }
        return n3;
    }

    private int a6(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != 66574611) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1327722151: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1948306687: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
        }
        return n3;
    }

    private int a7(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1896963995: {
                if (bl) {
                    if (n2 != -115882523) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
        }
        return n3;
    }

    private int a8(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1996989407: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1445425228: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -1180088041: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -516167094: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -316897211: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -94655905: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 341392519: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 341407623: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 973935975: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 == 1163392726) {
                        n3 = 38;
                        break;
                    }
                    if (n2 != -633848249) break;
                    n3 = 39;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1185585318: {
                if (bl) {
                    if (n2 != 1263127248) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1220554488: {
                if (bl) {
                    if (n2 != 1163392726) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 1877436552: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 2133986082: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
        }
        return n3;
    }

    private int a9(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -568009443: {
                if (bl) {
                    if (n2 != -1953394071) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
        }
        return n3;
    }

    private int a10(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1327722151: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
        }
        return n3;
    }

    private int a11(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
        }
        return n3;
    }

    private int a12(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2143807053: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1961930348: {
                if (bl) {
                    if (n2 != -372683487) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -1386389262: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -1077557351: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -48786765: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 25224473: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
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
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 798781092: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 1244919775: {
                if (bl) {
                    if (n2 != -1985511187) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 1358541925: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1845314727: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 1948306687: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 2083891433: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
        }
        return n3;
    }

    private int a13(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -171673451: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -48786765: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
        }
        return n3;
    }

    private int a14(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -1287358806: {
                if (bl) {
                    if (n2 != -1191841119) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case -1037974651: {
                if (bl) {
                    if (n2 != -155815654) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case -987206884: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -408892604: {
                if (bl) {
                    if (n2 != 1466890078) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case -347670083: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 1019231388: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 1115162348: {
                if (bl) {
                    if (n2 != -155815654) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 1235338950: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
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
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case -2056987450: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case -2016716374: {
                if (bl) {
                    if (n2 != 2035335274) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -1966853781: {
                if (bl) {
                    if (n2 != 1022694776) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -1807343454: {
                if (bl) {
                    if (n2 != 830393176) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case -1740089070: {
                if (bl) {
                    if (n2 != 1672310372) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case -1738553222: {
                if (bl) {
                    if (n2 != 198987640) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -1670077371: {
                if (bl) {
                    if (n2 != 1587919693) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -1536725116: {
                if (bl) {
                    if (n2 != 363071700) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -1452548656: {
                if (bl) {
                    if (n2 != 560998828) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -1422773111: {
                if (bl) {
                    if (n2 != -663988092) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
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
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case -1287358806: {
                if (bl) {
                    if (n2 != -1191841119) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case -1240726706: {
                if (bl) {
                    if (n2 != -552141675) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case -1077557351: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -1040213639: {
                if (bl) {
                    if (n2 != 1221567354) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case -963373045: {
                if (bl) {
                    if (n2 != 1510966181) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case -792417868: {
                if (bl) {
                    if (n2 != -986863828) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case -485226831: {
                if (bl) {
                    if (n2 != 1080370689) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case -174669585: {
                if (bl) {
                    if (n2 != 1075166657) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case -172040872: {
                if (bl) {
                    if (n2 != 655582126) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case -123487623: {
                if (bl) {
                    if (n2 != -1975613868) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 53219281: {
                if (bl) {
                    if (n2 != 1644305410) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 144356669: {
                if (bl) {
                    if (n2 != -1930575647) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
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
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 269677393: {
                if (bl) {
                    if (n2 != -912290783) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 339753823: {
                if (bl) {
                    if (n2 != -1332779296) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case 384423099: {
                if (bl) {
                    if (n2 != 204017891) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case 426788875: {
                if (bl) {
                    if (n2 != 1526617814) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case 471265876: {
                if (bl) {
                    if (n2 != 622325284) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case 480225318: {
                if (bl) {
                    if (n2 != -1257852358) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case 621097709: {
                if (bl) {
                    if (n2 != -1097481635) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case 693221473: {
                if (bl) {
                    if (n2 != -585071033) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 727335687: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case 853125527: {
                if (bl) {
                    if (n2 != 1725922795) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case 932145625: {
                if (bl) {
                    if (n2 != -395758302) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case 979084543: {
                if (bl) {
                    if (n2 != -1864762263) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 1060925107: {
                if (bl) {
                    if (n2 != -1024602568) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case 1176415189: {
                if (bl) {
                    if (n2 != -467118332) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case 1244919775: {
                if (bl) {
                    if (n2 != -1985511187) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 1435973531: {
                if (bl) {
                    if (n2 != 714516851) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case 1517013181: {
                if (bl) {
                    if (n2 != 1277656696) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 1570887344: {
                if (bl) {
                    if (n2 != 2144179776) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case 1598068843: {
                if (bl) {
                    if (n2 != 986637335) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case 1740808658: {
                if (bl) {
                    if (n2 != 588643339) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case 1942644712: {
                if (bl) {
                    if (n2 != 560644816) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case 1948538395: {
                if (bl) {
                    if (n2 != 1779174193) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case 2051908913: {
                if (bl) {
                    if (n2 != -1073556674) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 2055085048: {
                if (bl) {
                    if (n2 != 1196729427) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 2068515090: {
                if (bl) {
                    if (n2 != 1669104671) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
        }
        return n3;
    }

    private int a16(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2113556074: {
                if (bl) {
                    if (n2 != -377593821) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -861561590) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case 868282914: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
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
            case -2058479119: {
                n2 = this.a15(n4, bl, n);
                break;
            }
            case -1967872857: {
                n2 = this.a16(n4, bl, n);
                break;
            }
            case -1549305102: {
                n2 = this.a5(n4, bl, n);
                break;
            }
            case -1258869123: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -1145854999: {
                n2 = this.a13(n4, bl, n);
                break;
            }
            case -970382756: {
                n2 = this.a8(n4, bl, n);
                break;
            }
            case -575714495: {
                n2 = this.a10(n4, bl, n);
                break;
            }
            case -463353497: {
                n2 = this.a6(n4, bl, n);
                break;
            }
            case 245692833: {
                n2 = this.a12(n4, bl, n);
                break;
            }
            case 751797647: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 831492925: {
                n2 = this.a11(n4, bl, n);
                break;
            }
            case 1474741114: {
                n2 = this.a9(n4, bl, n);
                break;
            }
            case 1519764109: {
                n2 = this.a14(n4, bl, n);
                break;
            }
            case 1613307447: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1763104289: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case 1810083123: {
                n2 = this.a7(n4, bl, n);
                break;
            }
            case 1839782555: {
                n2 = this.a3(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((TargetAdjustPosition)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 1: {
                ((TargetAdjustPosition)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                return RuntimeUtil.valueOf(((TargetAdjustPosition)object).isReroutingSuccessful());
            }
            case 3: {
                ((TargetAdjustPosition)object).dsiNavigationRgSwitchToNextPossibleRoadResult((Boolean)objectArray[0]);
                return null;
            }
            case 4: {
                ((TargetAdjustPosition)object).initDsiNavigation();
                return null;
            }
            case 5: {
                ((TargetAdjustPosition)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((HsmTargetBorderChange)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 7: {
                ((HsmTargetBorderChange)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((HsmTargetBorderChange)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((HsmTargetBorderChange)object).traceState((String)objectArray[0]);
                return null;
            }
            case 10: {
                ((HsmTargetBorderChange)object).registerAsServiceStateListener();
                return null;
            }
            case 11: {
                ((HsmTargetBorderChange)object).dsiNavigationUpdateRgActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((HsmTargetBorderChange)object).dsiNavigationUpdateSoPosPositionDescription((NavLocation)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((HsmTargetBorderChange)object).dsiTrafficRegulationRequestRoadClassSpeedInfoForCountryResult((RoadClassSpeedInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                return ((HsmTargetBorderChange)object).getDefaultIcon();
            }
            case 15: {
                ((HsmTargetBorderChange)object).handleIconCacheUpdate((IconKey)objectArray[0], (ResourceLocator)objectArray[1], objectArray[2]);
                return null;
            }
            case 16: {
                ((HsmTargetDestList)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 17: {
                ((HsmTargetDestList)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((HsmTargetDestList)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((HsmTargetDestList)object).traceState((HsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 20: {
                ((HsmTargetDestList)object).dsiNavigationUpdateRgActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((HsmTargetDestList)object).dsiNavigationUpdateRgCurrentRoute((Route)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((HsmTargetLaneGuidance)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((HsmTargetLaneGuidance)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((HsmTargetLaneGuidance)object).dsiNavigationUpdateRgLaneGuidance((NavLaneGuidanceData[])objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 25: {
                ((HsmTargetAudio)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 26: {
                return HsmTargetAudio.getLogger();
            }
            case 27: {
                ((HsmTargetCongestionAhead)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 28: {
                ((HsmTargetCongestionAhead)object).traceState((AbstractHsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 29: {
                ((HsmTargetInfo)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 30: {
                ((HsmTargetInfo)object).traceState((HsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 31: {
                ((HsmTargetInfo)object).initDSI();
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                return ((HsmTargetInfo)object).getGuidanceAPINotifier();
            }
            case 33: {
                ((de.vw.mib.asl.internal.navigation.guidance.laneguidance.HsmTargetLaneGuidance)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 34: {
                ((de.vw.mib.asl.internal.navigation.guidance.laneguidance.HsmTargetLaneGuidance)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((de.vw.mib.asl.internal.navigation.guidance.laneguidance.HsmTargetLaneGuidance)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((de.vw.mib.asl.internal.navigation.guidance.laneguidance.HsmTargetLaneGuidance)object).dsiNavigationUpdateRgLaneGuidance((NavLaneGuidanceData[])objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 37: {
                ((HsmTargetGuidance)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 38: {
                ((HsmTargetGuidance)object).traceState((AbstractHsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 39: {
                ((HsmTargetGuidance)object).traceState((String)objectArray[0]);
                return null;
            }
            case 40: {
                return RuntimeUtil.valueOf(((HsmTargetGuidance)object).isFFNavRouteCalcAdjustRoute());
            }
            case 41: {
                ((HsmTargetGuidance)object).infoState((AbstractHsmState)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 42: {
                ((HsmTargetGuidance)object).logInfo((String)objectArray[0]);
                return null;
            }
            case 43: {
                return RuntimeUtil.valueOf(((HsmTargetGuidance)object).isTour());
            }
            case 44: {
                return RuntimeUtil.valueOf(((HsmTargetGuidance)object).isModelInDemoMode());
            }
            case 45: {
                return RuntimeUtil.valueOf(((HsmTargetGuidance)object).isRecalculation());
            }
            case 46: {
                return RuntimeUtil.valueOf(((HsmTargetGuidance)object).isSingleRouteCalculation());
            }
            case 47: {
                return RuntimeUtil.valueOf(((HsmTargetGuidance)object).isWPMCalculation());
            }
            case 48: {
                ((HsmTargetGuidance)object).updateErrorState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 49: {
                ((HsmTargetGuidance)object).updateGuidanceState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 50: {
                ((HsmTargetGuidance)object).updateCalculationState((ASLCalculationState[])objectArray[0]);
                return null;
            }
            case 51: {
                ((HsmTargetGuidance)object).setIsFFNavRouteCalcAdjustRoute();
                return null;
            }
            case 52: {
                ((HsmTargetGuidance)object).onNewPowerState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 53: {
                ((TargetPPOIApproach)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 54: {
                ((TargetPPOIApproach)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((TargetPPOIApproach)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((TargetPPOIApproach)object).traceState((String)objectArray[0]);
                return null;
            }
            case 57: {
                ((TargetPPOIApproach)object).dsiNavigationUpdatePOIsEnteringProximityRange((NavLocation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((HsmTargetVZA)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 59: {
                ((HsmTargetVZA)object).traceState((String)objectArray[0]);
                return null;
            }
            case 60: {
                return ((HsmTargetVZA)object).getGuidanceAPINotifier();
            }
            case 61: {
                ((JPNWarningSetupHsmTarget)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 62: {
                ((JPNWarningSetupHsmTarget)object).traceState((String)objectArray[0]);
                return null;
            }
            case 63: {
                ((TargetPredictiveNavigationSplitscreen)object).reset((HashMap)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((TargetPredictiveNavigationSplitscreen)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((TargetPredictiveNavigationSplitscreen)object).initDsiNavigation();
                return null;
            }
            case 66: {
                ((TargetPredictiveNavigationSplitscreen)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((TargetPredictiveNavigationSplitscreen)object).traceState((String)objectArray[0]);
                return null;
            }
            case 68: {
                return ((TargetPredictiveNavigationSplitscreen)object).getDefaultIcon();
            }
            case 69: {
                ((TargetPredictiveNavigationSplitscreen)object).handleIconCacheUpdate((IconKey)objectArray[0], (ResourceLocator)objectArray[1], objectArray[2]);
                return null;
            }
            case 70: {
                ((TargetPredictiveNavigationSplitscreen)object).initDSI();
                return null;
            }
            case 71: {
                ((TargetPredictiveNavigationSplitscreen)object).initDsiPredictiveNavigation();
                return null;
            }
            case 72: {
                ((TargetPredictiveNavigationSplitscreen)object).changePnavEnabled((Boolean)objectArray[0]);
                return null;
            }
            case 73: {
                ((TargetPredictiveNavigationSplitscreen)object).dsiPredictiveNavigationUpdateLikelyDestinations((LikelyDestination[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 74: {
                ((TargetPredictiveNavigationSplitscreen)object).dsiPredictiveNavigationUpdateOperationMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((TargetPredictiveNavigationSplitscreen)object).handleFullFacotryReset();
                return null;
            }
            case 76: {
                ((TargetPredictiveNavigationSplitscreen)object).handleNavigationSettingsReset();
                return null;
            }
            case 77: {
                ((TargetPredictiveNavigationSplitscreen)object).reloadPersistedData();
                return null;
            }
            case 78: {
                ((TargetPredictiveNavigationSplitscreen)object).initLocalVariablesPNav();
                return null;
            }
            case 79: {
                ((HsmTargetRouteOptions)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 80: {
                ((HsmTargetRouteOptions)object).initDsiNavigation();
                return null;
            }
            case 81: {
                ((HsmTargetRouteOptions)object).initDsiTmc();
                return null;
            }
            case 82: {
                ((TargetTourMemory)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 83: {
                ((TargetTourMemory)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 84: {
                ((TargetTourMemory)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 85: {
                ((TargetTourMemory)object).dsiNavigationRmImportToursFromGpxFileResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 86: {
                ((TargetTourMemory)object).dsiNavigationUpdateRmImportToursFromGpxFileStatus((TourImportStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 87: {
                ((TargetTourMemory)object).storeTourMemoryCapacityToCalculatedCapacity();
                return null;
            }
            case 88: {
                ((TargetTourMemory)object).dsiNavigationUpdateRmRouteList((NavRmRouteListArrayData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((TargetTourMemory)object).dsiNavigationRmRouteDeleteResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 90: {
                TargetTourMemory.registerListener((IOnlineTourImportListener)objectArray[0]);
                return null;
            }
            case 91: {
                TargetTourMemory.unregisterListener((IOnlineTourImportListener)objectArray[0]);
                return null;
            }
            case 92: {
                return ((TargetTourMemory)object).getCalculatedTourMemoryCapacity();
            }
            case 93: {
                ((TargetTourView)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 94: {
                ((TargetTourView)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 95: {
                ((TargetTourView)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((TargetTourView)object).dsiNavigationUpdateRgActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 97: {
                return ((TargetTourView)object).getDefaultIcon();
            }
            case 98: {
                ((TargetTourView)object).handleIconCacheUpdate((IconKey)objectArray[0], (ResourceLocator)objectArray[1], objectArray[2]);
                return null;
            }
            case 99: {
                ((TargetTourView)object).dsiNavigationUpdateRgCurrentRoute((Route)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 100: {
                ((TargetTourView)object).dsiNavigationUpdateRmRouteList((NavRmRouteListArrayData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 101: {
                ((TargetTourView)object).dsiNavigationUpdateRgInfoForNextDestination((RgInfoForNextDestination)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 102: {
                ((TargetTourView)object).dsiNavigationUpdateRgDestinationInfo((NavRouteListData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 103: {
                ((TargetTourView)object).dsiNavigationRmRouteGetResult(((Number)objectArray[0]).intValue(), (Route)objectArray[1]);
                return null;
            }
            case 104: {
                ((TargetTourView)object).dsiNavigationRmRouteReplaceResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 105: {
                ((TargetTourView)object).handleCommandCmdRmRouteDelete((CmdRmRouteDelete)objectArray[0]);
                return null;
            }
            case 106: {
                ((TargetTourView)object).handleCommandCmdRmRouteAdd((CmdRmRouteAdd)objectArray[0]);
                return null;
            }
            case 107: {
                ((TargetTourView)object).handleCommandCmdStartSpeller((CmdStartSpeller)objectArray[0]);
                return null;
            }
            case 108: {
                ((TargetTourView)object).handleCommandCmdPoiStartSpellerAlongRoute((CmdPoiStartSpellerAlongRoute)objectArray[0]);
                return null;
            }
            case 109: {
                ((TargetTourView)object).handleCommandCmdStopSpeller((CmdStopSpeller)objectArray[0]);
                return null;
            }
            case 110: {
                ((TargetTourView)object).handleCommandCmdCancelSpeller((CmdCancelSpeller)objectArray[0]);
                return null;
            }
            case 111: {
                ((TargetTourView)object).handleCommandCmdAddChar((CmdAddChar)objectArray[0]);
                return null;
            }
            case 112: {
                ((TargetTourView)object).handleCommandCmdUndoChar((CmdUndoChar)objectArray[0]);
                return null;
            }
            case 113: {
                ((TargetTourView)object).handleCommandCmdSelectListItem((CmdSelectListItem)objectArray[0]);
                return null;
            }
            case 114: {
                ((TargetTourView)object).handleCommandCmdSelectListItemByIdent((CmdSelectListItemByIdent)objectArray[0]);
                return null;
            }
            case 115: {
                ((TargetTourView)object).handleCommandCmdSelectByCategoryUid((CmdSelectByCategoryUid)objectArray[0]);
                return null;
            }
            case 116: {
                ((TargetTourView)object).handleCommandCmdSelectByMultipleCategoryUids((CmdSelectByMultipleCategoryUids)objectArray[0]);
                return null;
            }
            case 117: {
                ((TargetTourView)object).handleCommandCmdSelectListItemPoi((CmdSelectListItemPoi)objectArray[0]);
                return null;
            }
            case 118: {
                ((TargetTourView)object).handleCommandCmdPoiSelectSelectionCriteria((CmdPoiSelectSelectionCriteria)objectArray[0]);
                return null;
            }
            case 119: {
                ((TargetTourView)object).handleCommandCmdRestoreState((CmdRestoreState)objectArray[0]);
                return null;
            }
            case 120: {
                ((TargetTourView)object).handleCommandCmdLiGetState((CmdLiGetState)objectArray[0]);
                return null;
            }
            case 121: {
                ((TargetTourView)object).handleCommandCmdSetInput((CmdSetInput)objectArray[0]);
                return null;
            }
            case 122: {
                ((TargetTourView)object).handleCommandCmdSetCurrentLD((CmdSetCurrentLD)objectArray[0]);
                return null;
            }
            case 123: {
                ((TargetTourView)object).handleCommandCmdTryBestMatch((CmdTryBestMatch)objectArray[0]);
                return null;
            }
            case 124: {
                ((TargetTourView)object).handleCommandCmdTryMatchLocation((CmdTryMatchLocation)objectArray[0]);
                return null;
            }
            case 125: {
                ((TargetTourView)object).handleCommandCmdRequestValueListByListIndex((CmdRequestValueListByListIndex)objectArray[0]);
                return null;
            }
            case 126: {
                ((TargetTourView)object).handleCommandCmdNavLocationToStream((CmdNavLocationToStream)objectArray[0]);
                return null;
            }
            case 127: {
                ((TargetTourView)object).handleCommandCmdStreamToNavLocation((CmdStreamToNavLocation)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((TargetTourView)object).handleCommandCmdGetLocationDescriptionTransform((CmdGetLocationDescriptionTransform)objectArray[0]);
                return null;
            }
            case 129: {
                ((TargetTourView)object).handleCommandCmdStripLocation((CmdStripLocation)objectArray[0]);
                return null;
            }
            case 130: {
                ((TargetTourView)object).handleCommandCmdSetLiValueListWindowSize((CmdSetLiValueListWindowSize)objectArray[0]);
                return null;
            }
            case 131: {
                ((TargetTourView)object).handleCommandCmdGetMatchingNVC((CmdGetMatchingNVC)objectArray[0]);
                return null;
            }
            case 132: {
                ((TargetTourView)object).handleCommandCmdSetNVCRange((CmdSetNVCRange)objectArray[0]);
                return null;
            }
            case 133: {
                ((TargetTourView)object).handleCommandCmdTransformAndStrip((CmdTransformAndStrip)objectArray[0]);
                return null;
            }
            case 134: {
                ((TargetTourView)object).handleCommandCmdPoiGetXt9LDBs((CmdPoiGetXt9LDBs)objectArray[0]);
                return null;
            }
            case 135: {
                ((TargetTourView)object).handleCommandCmdGetLocationFromLiValueListElement((CmdGetLocationFromLiValueListElement)objectArray[0]);
                return null;
            }
            case 136: {
                ((TargetTourView)object).handleCommandCmdDmLastDestinationsDeleteAll((CmdDmLastDestinationsDeleteAll)objectArray[0]);
                return null;
            }
            case 137: {
                ((TargetTourView)object).handleCommandCmdDmLastDestinationsGet((CmdDmLastDestinationsGet)objectArray[0]);
                return null;
            }
            case 138: {
                ((TargetTourView)object).handleCommandCmdLastCityHistoryAdd((CmdLastCityHistoryAdd)objectArray[0]);
                return null;
            }
            case 139: {
                ((TargetTourView)object).handleCommandCmdLastStreetHistoryAdd((CmdLastStreetHistoryAdd)objectArray[0]);
                return null;
            }
            case 140: {
                ((TargetTourView)object).handleCommandCmdSetCountryForCityAndStreetHistory((CmdSetCountryForCityAndStreetHistory)objectArray[0]);
                return null;
            }
            case 141: {
                ((TargetTourView)object).handleCommandCmdGetLastCityHistoryEntry((CmdGetLastCityHistoryEntry)objectArray[0]);
                return null;
            }
            case 142: {
                ((TargetTourView)object).handleCommandCmdGetLastStreetHistoryEntry((CmdGetLastStreetHistoryEntry)objectArray[0]);
                return null;
            }
            case 143: {
                ((TargetTourView)object).handleCommandCmdHistoryAddLocation((CmdHistoryAddLocation)objectArray[0]);
                return null;
            }
            case 144: {
                ((TargetTourView)object).handleCommandCmdTransformAndToStream((CmdTransformAndToStream)objectArray[0]);
                return null;
            }
            case 145: {
                ((TargetTourView)object).handleCommandCmdPoiStartSpellerAlongRouteAdvanced((CmdPoiStartSpellerAlongRouteAdvanced)objectArray[0]);
                return null;
            }
            case 146: {
                ((TargetTourView)object).handleCommandCmdLastStateHistoryAdd((CmdLastStateHistoryAdd)objectArray[0]);
                return null;
            }
            case 147: {
                ((HsmTargetWayPointMode)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 148: {
                ((HsmTargetWayPointMode)object).registered((Class)objectArray[0], objectArray[1]);
                return null;
            }
            case 149: {
                return ((HsmTargetWayPointMode)object).getInternalAPINotifier();
            }
            case 150: {
                ((HsmTargetWayPointMode)object).setInternalAPINotifier((WpmInternalAPINotifier)objectArray[0]);
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

