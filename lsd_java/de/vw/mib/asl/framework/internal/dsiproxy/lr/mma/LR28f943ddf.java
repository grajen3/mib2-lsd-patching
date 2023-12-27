/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DSICombinedRouteListListener;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.NavVersionInfo;
import org.dsi.ifc.navigation.PoiExtendedInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.PosTimeInfo;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RgTurnToInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;
import org.dsi.ifc.navigation.TourImportStatus;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;
import org.dsi.ifc.tmc.TmcMessage;

public final class LR28f943ddf
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1921530444: {
                if (bl) {
                    if (n2 != 1564608395) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1873423591: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1782506374: {
                if (bl) {
                    if (n2 != 1831678472) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -98208583: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -53042625: {
                if (bl) {
                    if (n2 != 1828738848) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1277448801: {
                if (bl) {
                    if (n2 != -1678354842) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1307116084: {
                if (bl) {
                    if (n2 != 920388178) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2130753523: {
                if (bl) {
                    if (n2 != -900640479) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -2102092964: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case -2084621470: {
                if (bl) {
                    if (n2 != 1416158467) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case -2077573631: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case -2007644382: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -1972368229: {
                if (bl) {
                    if (n2 != -141377623) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case -1966445585: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -1964591421: {
                if (bl) {
                    if (n2 != -912290783) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1902462856: {
                if (bl) {
                    if (n2 != -1191841119) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -1886713904: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1854680207: {
                if (bl) {
                    if (n2 != -638790105) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1823027655: {
                if (bl) {
                    if (n2 != 1138497487) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1782227917: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -1723754267: {
                if (bl) {
                    if (n2 != -47897083) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1721720167: {
                if (bl) {
                    if (n2 != -1557790221) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case -1688334462: {
                if (bl) {
                    if (n2 != 284106918) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case -1629202171: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case -1627343727: {
                if (bl) {
                    if (n2 != -494801057) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 183;
                    break;
                }
                n3 = 183;
                break;
            }
            case -1618612322: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -1520022462: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1490850233: {
                if (bl) {
                    if (n2 != -462836873) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case -1462191177: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1414563717: {
                if (bl) {
                    if (n2 != 1372686599) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1405916490: {
                if (bl) {
                    if (n2 != 1466890078) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case -1400788155: {
                if (bl) {
                    if (n2 != 2043315704) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1364318689: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1357007370: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1348216097: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -1261690455: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case -1254948161: {
                if (bl) {
                    if (n2 != -900640479) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -1247373650: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -1237668915: {
                if (bl) {
                    if (n2 != 487638186) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1230385213: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case -1229017563: {
                if (bl) {
                    if (n2 != -654615933) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -1195047537: {
                if (bl) {
                    if (n2 != -1953394071) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -1182718075: {
                if (bl) {
                    if (n2 != 259283458) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1181451900: {
                if (bl) {
                    if (n2 != -69669298) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -1177366766: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -1145982982: {
                if (bl) {
                    if (n2 != 1147312894) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -1122125420: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case -1076605344: {
                if (bl) {
                    if (n2 != 1410340865) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case -1045808009: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1036760729: {
                if (bl) {
                    if (n2 != -1966171079) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
            case -1027020002: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1022859326: {
                if (bl) {
                    if (n2 != -1006107495) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1016651511: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -979682501: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case -964155444: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case -954073691: {
                if (bl) {
                    if (n2 != 253782595) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case -948563826: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
            case -947755853: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -939962027: {
                if (bl) {
                    if (n2 != 553619691) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -873375852: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case -867024848: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case -866661259: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case -791775339: {
                if (bl) {
                    if (n2 != 1159578057) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case -790362344: {
                if (bl) {
                    if (n2 != -972423086) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case -745428961: {
                if (bl) {
                    if (n2 != -1401574038) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case -743417418: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -730359808: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case -719091602: {
                if (bl) {
                    if (n2 != -243759138) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -718336323: {
                if (bl) {
                    if (n2 != -2053992272) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case -678622269: {
                if (bl) {
                    if (n2 != -1145889529) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -678533979: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case -635709718: {
                if (bl) {
                    if (n2 != -1006107495) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -606740939: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -594976902: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case -561927671: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case -519142424: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -479829192: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case -468459743: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case -451786751: {
                if (bl) {
                    if (n2 != 341124178) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case -416854998: {
                if (bl) {
                    if (n2 != 53949725) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -379470343: {
                if (bl) {
                    if (n2 != -1622239583) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -364413426: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -353057651: {
                if (bl) {
                    if (n2 != -2023978998) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -256349577: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case -253495902: {
                if (bl) {
                    if (n2 != -796524928) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -153397335: {
                if (bl) {
                    if (n2 != -1749998467) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case -139135787: {
                if (bl) {
                    if (n2 != 448199346) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case -128971164: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -107791238: {
                if (bl) {
                    if (n2 != -1365707824) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -94022317: {
                if (bl) {
                    if (n2 != -585071033) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -90180800: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -37223917: {
                if (bl) {
                    if (n2 != -593361741) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 3711032: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case 0x631111: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case 23021139: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case 125379710: {
                if (bl) {
                    if (n2 != -534202681) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 157736628: {
                if (bl) {
                    if (n2 != 977376590) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 163734487: {
                if (bl) {
                    if (n2 != -115882523) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 185695509: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case 191583276: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 203083237: {
                if (bl) {
                    if (n2 != -2023978998) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 224254108: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 232599299: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 241276486: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 290138257: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case 296323076: {
                if (bl) {
                    if (n2 != 1587919693) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 315826473: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 333479132: {
                if (bl) {
                    if (n2 != -1249243306) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case 365835900: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case 377663781: {
                if (bl) {
                    if (n2 != 407939732) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case 380582686: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case 387969647: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 392312432: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 447961304: {
                if (bl) {
                    if (n2 != 259283458) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case 448095160: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case 479889703: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case 521580306: {
                if (bl) {
                    if (n2 != -1006107495) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 524060783: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 179;
                    break;
                }
                n3 = 179;
                break;
            }
            case 540125238: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case 555793993: {
                if (bl) {
                    if (n2 != -70755089) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 601788384: {
                if (bl) {
                    if (n2 != 746133882) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 630838163: {
                if (bl) {
                    if (n2 != 1587919693) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 662851925: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 716273541: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case 741132838: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 751614175: {
                if (bl) {
                    if (n2 != 18961586) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 754183110: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 780679608: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 797965358: {
                if (bl) {
                    if (n2 != 293113262) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 847170246: {
                if (bl) {
                    if (n2 != -2023978998) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 861537273: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 877574685: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case 894671413: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case 942934410: {
                if (bl) {
                    if (n2 != -192055600) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 978366857: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1143952616: {
                if (bl) {
                    if (n2 != 341124178) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1150213765: {
                if (bl) {
                    if (n2 != 1588906783) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 1157933509: {
                if (bl) {
                    if (n2 != 1679287589) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case 1169402795: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1225688664: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 1228316107: {
                if (bl) {
                    if (n2 != -14292859) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case 1242824715: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 1252945163: {
                if (bl) {
                    if (n2 != -457258613) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case 1258174821: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 1281722151: {
                if (bl) {
                    if (n2 != -1290860902) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 1285136140: {
                if (bl) {
                    if (n2 != -1166448617) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case 1303861920: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case 1318732747: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1325043556: {
                if (bl) {
                    if (n2 != 618681725) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 1361407982: {
                if (bl) {
                    if (n2 != 664485980) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case 1362097342: {
                if (bl) {
                    if (n2 != -1365027086) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
                break;
            }
            case 1376047412: {
                if (bl) {
                    if (n2 != 1587919693) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1395629698: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 1423031919: {
                if (bl) {
                    if (n2 != 528007529) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 1423267600: {
                if (bl) {
                    if (n2 != 1801798329) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1462529167: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case 1498869585: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case 1507012856: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case 1513779268: {
                if (bl) {
                    if (n2 != -585071033) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case 1615930907: {
                if (bl) {
                    if (n2 != -653036081) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 1620431281: {
                if (bl) {
                    if (n2 != -866436352) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1678360400: {
                if (bl) {
                    if (n2 != 1313881078) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case 1683670458: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 1697916367: {
                if (bl) {
                    if (n2 != -141377623) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1704719883: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1730547727: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1758198010: {
                if (bl) {
                    if (n2 != -1290860902) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 1861835491: {
                if (bl) {
                    if (n2 != -912290783) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1904641290: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 1920026002: {
                if (bl) {
                    if (n2 != -47897083) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1920409344: {
                if (bl) {
                    if (n2 != 775630887) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case 1928172835: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1948510049: {
                if (bl) {
                    if (n2 != 218596504) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case 1952022324: {
                if (bl) {
                    if (n2 != 1677270394) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 1982068574: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 2061349978: {
                if (bl) {
                    if (n2 != 560644816) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 2074338854: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case 2075759049: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 2113841962: {
                if (bl) {
                    if (n2 != -2079390645) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 2144748432: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
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
            case 1532029379: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1558345509: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICombinedRouteListListener)object).windowChanged(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSICombinedRouteListListener)object).combinedRouteListResult(((Number)objectArray[0]).longValue(), (CombinedRouteListElement[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSICombinedRouteListListener)object).trafficInformationResult((TmcMessage)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSICombinedRouteListListener)object).poiInformationResult((NavPoiInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSICombinedRouteListListener)object).updateElementsTotal(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSICombinedRouteListListener)object).getBoundingRectangleOfCombinedRouteListElementsResult((long[])objectArray[0], (NavRectangle)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSICombinedRouteListListener)object).requestPriceInfoResult((NavPriceInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSICombinedRouteListListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSINavigationListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSINavigationListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSINavigationListener)object).liValueListOutputMethod(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSINavigationListener)object).createExportFileResult(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSINavigationListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSINavigationListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSINavigationListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSINavigationListener)object).updateAudioRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSINavigationListener)object).updateAvailableLanguages((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSINavigationListener)object).updateAfaMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSINavigationListener)object).updateAfaSpeaking((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSINavigationListener)object).updateEtcDemoModeState((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSINavigationListener)object).updateEtcLanguageLoadProgress(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSINavigationListener)object).updateEtcLanguageLoadStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSINavigationListener)object).updateEtcMetricSystem(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSINavigationListener)object).updateDmLastDestinationsList((LDListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSINavigationListener)object).updateDmRecentRoutesList((RRListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSINavigationListener)object).updateLispIsSpellerActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSINavigationListener)object).updateRgActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSINavigationListener)object).updateRgInfoForNextDestination((RgInfoForNextDestination)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSINavigationListener)object).updateRgCurrentRoute((Route)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSINavigationListener)object).updateRgCurrentRouteOptions((RouteOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSINavigationListener)object).updateRgLaneGuidance((NavLaneGuidanceData[])objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 31: {
                ((DSINavigationListener)object).updateRgTurnToStreet((String)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSINavigationListener)object).updateRgUnfulfilledRouteOptions((RouteOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSINavigationListener)object).updateRgDestinationInfo((NavRouteListData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSINavigationListener)object).updateRgStreetList((NavRouteListData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSINavigationListener)object).updateRgPoiInfo((NavPoiInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSINavigationListener)object).rgException(((Number)objectArray[0]).intValue());
                return null;
            }
            case 37: {
                ((DSINavigationListener)object).updateRgRouteProperties((RouteProperties)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSINavigationListener)object).updateSoPosPosition((PosPosition)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSINavigationListener)object).updateSoPosPositionDescription((NavLocation)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 40: {
                ((DSINavigationListener)object).updateSoPosTimeInformation((PosTimeInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSINavigationListener)object).updateRrdActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSINavigationListener)object).updateRrdCalculationInfo((RrdCalculationInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((DSINavigationListener)object).updateEtcVersionInfo((NavVersionInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 44: {
                ((DSINavigationListener)object).updateEtcAvailableNavDataBases((NavDataBase[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSINavigationListener)object).updateBapManeuverDescriptor((BapManeuverDescriptor[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSINavigationListener)object).updateBapTurnToInfo((BapTurnToInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 47: {
                ((DSINavigationListener)object).updateRgiString((short[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 48: {
                ((DSINavigationListener)object).updateRgDetailedStreetList((NavRouteListData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSINavigationListener)object).updateRmPersistentRoute((Route)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((DSINavigationListener)object).updateRgTimeAfaToDestination(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((DSINavigationListener)object).etcSensorDataReplayRoute((Route)objectArray[0]);
                return null;
            }
            case 52: {
                ((DSINavigationListener)object).etcSensorDataReplayGuidance((Boolean)objectArray[0]);
                return null;
            }
            case 53: {
                ((DSINavigationListener)object).updateRgCalculatedRoutes((CalculatedRouteListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSINavigationListener)object).updateRgRouteCostChangeInformation((RgRouteCostChangeInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSINavigationListener)object).updateTrMemoryUtilization((NavTraceMemoryUtilization)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSINavigationListener)object).updateTrOperatingMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSINavigationListener)object).updateTrTraceList((NavTraceListData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSINavigationListener)object).updateRmRouteList((NavRmRouteListArrayData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSINavigationListener)object).updateRgRouteCalculationState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 60: {
                ((DSINavigationListener)object).updateNavstateOfOperation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((DSINavigationListener)object).updateNavMedia((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((DSINavigationListener)object).updateRgTurnList((TurnListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSINavigationListener)object).updateLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSINavigationListener)object).updateDistanceToNextManeuver((DistanceToNextManeuver)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((DSINavigationListener)object).updateEtcCurrentNavDataBase((NavDataBase)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 66: {
                ((DSINavigationListener)object).updateTrDirectionToWaypoint((DirectionToWaypoint)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((DSINavigationListener)object).updatePoiSubstringSearchStatus((ValueListStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((DSINavigationListener)object).updateTrRecordingState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((DSINavigationListener)object).rgSetRouteGuidanceModeResult();
                return null;
            }
            case 70: {
                ((DSINavigationListener)object).dmLastDestinationsGetResult(((Number)objectArray[0]).longValue(), (NavLocation)objectArray[1]);
                return null;
            }
            case 71: {
                ((DSINavigationListener)object).dmRecentRoutesGetResult(((Number)objectArray[0]).longValue(), (Route)objectArray[1]);
                return null;
            }
            case 72: {
                ((DSINavigationListener)object).dmResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 73: {
                ((DSINavigationListener)object).liGetStateResult((LISpellerData)objectArray[0]);
                return null;
            }
            case 74: {
                ((DSINavigationListener)object).liResult(((Number)objectArray[0]).longValue());
                return null;
            }
            case 75: {
                ((DSINavigationListener)object).lispUpdateSpellerResult((String)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (Boolean)objectArray[3], (String)objectArray[4], ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), (Boolean)objectArray[7], (Boolean)objectArray[8], ((Number)objectArray[9]).intValue(), ((Number)objectArray[10]).longValue());
                return null;
            }
            case 76: {
                ((DSINavigationListener)object).liCurrentState((NavLocation)objectArray[0], (int[])objectArray[1], (int[])objectArray[2], ((Number)objectArray[3]).longValue());
                return null;
            }
            case 77: {
                ((DSINavigationListener)object).liValueList((LIValueList)objectArray[0], ((Number)objectArray[1]).longValue());
                return null;
            }
            case 78: {
                ((DSINavigationListener)object).poiValueList((LIValueList)objectArray[0], ((Number)objectArray[1]).longValue());
                return null;
            }
            case 79: {
                ((DSINavigationListener)object).liGetLocationDescriptionTransformResult((NavLocation)objectArray[0]);
                return null;
            }
            case 80: {
                ((DSINavigationListener)object).rmMakeRoutePersistentResult(((Number)objectArray[0]).longValue());
                return null;
            }
            case 81: {
                ((DSINavigationListener)object).liTryBestMatchResult((TryBestMatchResultData[])objectArray[0]);
                return null;
            }
            case 82: {
                ((DSINavigationListener)object).etcGetCountryAbbreviationResult((String)objectArray[0], ((Number)objectArray[1]).longValue());
                return null;
            }
            case 83: {
                ((DSINavigationListener)object).trStartTraceRecordingResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 84: {
                ((DSINavigationListener)object).trStopTraceRecordingResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 85: {
                ((DSINavigationListener)object).trStoreTraceResult(((Number)objectArray[0]).intValue(), (NavSegmentID)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 86: {
                ((DSINavigationListener)object).trRenameTraceResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 87: {
                ((DSINavigationListener)object).trDeleteTraceResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 88: {
                ((DSINavigationListener)object).trDeleteAllTracesResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((DSINavigationListener)object).rmRouteAddResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 90: {
                ((DSINavigationListener)object).rmRouteDeleteResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 91: {
                ((DSINavigationListener)object).rmRouteDeleteAllResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 92: {
                ((DSINavigationListener)object).rmRouteGetResult(((Number)objectArray[0]).intValue(), (Route)objectArray[1]);
                return null;
            }
            case 93: {
                ((DSINavigationListener)object).rmRouteRenameResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 94: {
                ((DSINavigationListener)object).importFileResult(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 95: {
                ((DSINavigationListener)object).languageSpellableCharactersResult((String)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSINavigationListener)object).rgNotPossible(((Number)objectArray[0]).intValue());
                return null;
            }
            case 97: {
                ((DSINavigationListener)object).translateRouteResult((Route)objectArray[0]);
                return null;
            }
            case 98: {
                ((DSINavigationListener)object).locationToStreamResult((Boolean)objectArray[0], (byte[])objectArray[1]);
                return null;
            }
            case 99: {
                ((DSINavigationListener)object).streamToLocationResult((Boolean)objectArray[0], (NavLocation)objectArray[1]);
                return null;
            }
            case 100: {
                ((DSINavigationListener)object).liValueListFileStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 101: {
                ((DSINavigationListener)object).updateDmFlagDestination((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 102: {
                ((DSINavigationListener)object).liGetLastCityHistoryEntryResult((NavLocation)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 103: {
                ((DSINavigationListener)object).liGetLastStreetHistoryEntryResult((NavLocation)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 104: {
                ((DSINavigationListener)object).updateLiCityHistory((LICityHistoryEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 105: {
                ((DSINavigationListener)object).updateLiCountryForCityAndStreetHistory((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 106: {
                ((DSINavigationListener)object).liLastCityAndStreetHistoryResult(((Number)objectArray[0]).longValue());
                return null;
            }
            case 107: {
                ((DSINavigationListener)object).updateLiStreetHistory((LIStreetHistoryEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 108: {
                ((DSINavigationListener)object).updateLiStateHistory((LIStateHistoryEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 109: {
                ((DSINavigationListener)object).liHistoryResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 110: {
                ((DSINavigationListener)object).liGetLastStateHistoryEntryResult((NavLocation)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 111: {
                ((DSINavigationListener)object).updateRgTurnListCalculationHorizon(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 112: {
                ((DSINavigationListener)object).updateRgPoiInfoCalculationHorizon(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 113: {
                ((DSINavigationListener)object).soPosPositionDescriptionVehicleResult((NavLocation)objectArray[0]);
                return null;
            }
            case 114: {
                ((DSINavigationListener)object).liStripLocationResult((NavLocation)objectArray[0]);
                return null;
            }
            case 115: {
                ((DSINavigationListener)object).responseAudioTrigger(((Number)objectArray[0]).intValue());
                return null;
            }
            case 116: {
                ((DSINavigationListener)object).liSetCountryForCityAndStreetHistoryResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 117: {
                ((DSINavigationListener)object).rgStartGuidanceCalculatedRouteResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 118: {
                ((DSINavigationListener)object).rgSwitchToNextPossibleRoadResult((Boolean)objectArray[0]);
                return null;
            }
            case 119: {
                ((DSINavigationListener)object).liThesaurusHistoryAddResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 120: {
                ((DSINavigationListener)object).liThesaurusHistoryGetEntryResult((ThesaurusHistoryEntry)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 121: {
                ((DSINavigationListener)object).liThesaurusHistoryDeleteResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 122: {
                ((DSINavigationListener)object).liThesaurusHistoryDeleteAllResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 123: {
                ((DSINavigationListener)object).updateLIThesaurusHistory((ThesaurusHistoryEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 124: {
                ((DSINavigationListener)object).updateCountryInfo((CountryInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 125: {
                ((DSINavigationListener)object).requestCountryInfoResult((CountryInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 126: {
                ((DSINavigationListener)object).ehGetAllCategoriesResult(((Number)objectArray[0]).intValue(), (Category[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 127: {
                ((DSINavigationListener)object).ehGetAllBrandsOfCategoryResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Brand[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((DSINavigationListener)object).ehResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 129: {
                ((DSINavigationListener)object).setRemainingRangeOfVehicleResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 130: {
                ((DSINavigationListener)object).setVehicleConsumptionInfoResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 131: {
                ((DSINavigationListener)object).setUserDefinedPOIsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 132: {
                ((DSINavigationListener)object).setTrailerStatusResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 133: {
                ((DSINavigationListener)object).liGetViaPointListResult(((Number)objectArray[0]).intValue(), (ViaPointListElement[])objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 134: {
                ((DSINavigationListener)object).liSelectViaPointResult((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 135: {
                ((DSINavigationListener)object).updateStyleDBPaths((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 136: {
                ((DSINavigationListener)object).updateRouteResumePossible((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 137: {
                ((DSINavigationListener)object).rgStartGuidanceCalculatedRouteByUIDResult((NavSegmentID)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 138: {
                ((DSINavigationListener)object).updatePOIsEnteringProximityRange((NavLocation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 139: {
                ((DSINavigationListener)object).liGetSpellableCharactersResult((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 140: {
                ((DSINavigationListener)object).updateEtcAvailablePersonalPOIDataBases((NavDataBase[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 141: {
                ((DSINavigationListener)object).updatePersonalPOISearchStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 142: {
                ((DSINavigationListener)object).deletePersonalPOIDataBasesResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 143: {
                ((DSINavigationListener)object).setVehicleFuelTypeResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 144: {
                ((DSINavigationListener)object).createNavLocationOfPOIUIDResult(((Number)objectArray[0]).longValue(), (NavLocation)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 145: {
                ((DSINavigationListener)object).rmRouteReplaceResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 146: {
                ((DSINavigationListener)object).setNavInternalDataToFactorySettingsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 147: {
                ((DSINavigationListener)object).liTryMatchLocationResult((TryMatchLocationResultData[])objectArray[0]);
                return null;
            }
            case 148: {
                ((DSINavigationListener)object).updateNavDbRegionsState(((Number)objectArray[0]).intValue(), (String[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 149: {
                ((DSINavigationListener)object).trImportTrailsResult((NavSegmentID[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 150: {
                ((DSINavigationListener)object).trExportTrailsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 151: {
                ((DSINavigationListener)object).updateTrInfoForNextWaypoint((NavNextWayPointInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 152: {
                ((DSINavigationListener)object).rgStartRubberbandManipulationResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 153: {
                ((DSINavigationListener)object).rgGetRouteBoundingRectangleResult((NavRectangle)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 154: {
                ((DSINavigationListener)object).rgGetLocationOnRouteResult((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 155: {
                ((DSINavigationListener)object).rgResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 156: {
                ((DSINavigationListener)object).rgGetRubberBandPointPositionResult((NavLocationWgs84)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 157: {
                ((DSINavigationListener)object).updateRgEnhancedSignPostInfoStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 158: {
                ((DSINavigationListener)object).etcSetDemoModeResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 159: {
                ((DSINavigationListener)object).lispGetLocationFromLiValueListResult(((Number)objectArray[0]).intValue(), (NavLocation)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((DSINavigationListener)object).lispGetMatchingNVCResult((String)objectArray[0]);
                return null;
            }
            case 161: {
                ((DSINavigationListener)object).poiGetXt9LDBsResult((String[])objectArray[0]);
                return null;
            }
            case 162: {
                ((DSINavigationListener)object).updateRgMotorwayInfo((NavPoiInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 163: {
                ((DSINavigationListener)object).updateRgVirtualDestinationInfo((RgInfoForNextDestination)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 164: {
                ((DSINavigationListener)object).rgTriggerRCCIUpdateResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 165: {
                ((DSINavigationListener)object).liGetLocationDescriptionTransformNearByResult((NavLocation)objectArray[0]);
                return null;
            }
            case 166: {
                ((DSINavigationListener)object).updateRgTurnToInfo((RgTurnToInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 167: {
                ((DSINavigationListener)object).etcGetPositionTimeInfoResult((PosTimeInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 168: {
                ((DSINavigationListener)object).poiGetCategoryTypesFromUIdResult((int[])objectArray[0]);
                return null;
            }
            case 169: {
                ((DSINavigationListener)object).updateRgPersistedRouteDataAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 170: {
                ((DSINavigationListener)object).liDisambiguateLocationResult((int[])objectArray[0], (NavLocation[])objectArray[1]);
                return null;
            }
            case 171: {
                ((DSINavigationListener)object).triggerEventAudioMessageResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 172: {
                ((DSINavigationListener)object).updateMapIntegrationState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 173: {
                ((DSINavigationListener)object).updateMapIntegrationProgress(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 174: {
                ((DSINavigationListener)object).etcTriggerNavigationRestartResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 175: {
                ((DSINavigationListener)object).lispRequestNVCListResult(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 176: {
                ((DSINavigationListener)object).updateBapManeuverState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 177: {
                ((DSINavigationListener)object).rmImportToursFromGpxFileResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 178: {
                ((DSINavigationListener)object).updateRmImportToursFromGpxFileStatus((TourImportStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 179: {
                ((DSINavigationListener)object).importRouteFromGpxFileResult((NavLocation)objectArray[0]);
                return null;
            }
            case 180: {
                ((DSINavigationListener)object).updateBapManeuverInformation((BapManeuverDescriptor[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 181: {
                ((DSINavigationListener)object).poiRequestExtendedInfoResult((PoiExtendedInfo)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 182: {
                ((DSINavigationListener)object).trClearRecordedTraceCacheResult();
                return null;
            }
            case 183: {
                ((DSINavigationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

