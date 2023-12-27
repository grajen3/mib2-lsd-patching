/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.reflection.generated.mma;

import de.vw.mib.asl.framework.api.persistence2.dsi.PersonalizedAppListener;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.HsmCacheHandler;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.NavGateway;
import de.vw.mib.asl.internal.navigation.util.personalization.HsmTargetProfileChange;
import de.vw.mib.asl.internal.navigation.util.update.MapRegionalUpdateTargetHSM;
import de.vw.mib.asl.navi.persistence.DsiNavigationAdapter;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.CountryInfo;
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

public final class LR29be3bc25
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1882186074: {
                if (bl) {
                    if (n2 != 461999728) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1620896420: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1148324562: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1087488700: {
                if (bl) {
                    if (n2 != -744080463) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -761467371: {
                if (bl) {
                    if (n2 != 1857331357) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -759237718: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -630578876: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -616974889: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -609849227: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -557955047: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -448927240: {
                if (bl) {
                    if (n2 != 1857331357) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -318099376: {
                if (bl) {
                    if (n2 != -710198328) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -270290931: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -159074389: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -144770906: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -67007770: {
                if (bl) {
                    if (n2 != 1857331357) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -39935092: {
                if (bl) {
                    if (n2 != 1857331357) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 25448117: {
                if (bl) {
                    if (n2 != 1857331357) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
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
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 288477382: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 872491428: {
                if (bl) {
                    if (n2 != 461999728) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 914477695: {
                if (bl) {
                    if (n2 != -744080463) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1082079194: {
                if (bl) {
                    if (n2 != 1857331357) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1500354702: {
                if (bl) {
                    if (n2 != 1857331357) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 1632476908: {
                if (bl) {
                    if (n2 != -2019292777) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1708424630: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1894342057: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1961312125: {
                if (bl) {
                    if (n2 != -744080463) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 2102754590: {
                if (bl) {
                    if (n2 != 1857331357) break;
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
            case -2130753523: {
                if (bl) {
                    if (n2 != -900640479) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -2119293631: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case -2117157213: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case -2116086560: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 206;
                    break;
                }
                n3 = 206;
                break;
            }
            case -2102092964: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 277;
                    break;
                }
                n3 = 277;
                break;
            }
            case -2091921944: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case -2085567165: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
            case -2084621470: {
                if (bl) {
                    if (n2 != 1416158467) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -2077573631: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 218;
                    break;
                }
                n3 = 218;
                break;
            }
            case -2007644382: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -2005569713: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case -2002299710: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 195;
                    break;
                }
                n3 = 195;
                break;
            }
            case -1972368229: {
                if (bl) {
                    if (n2 != -141377623) break;
                    n3 = 294;
                    break;
                }
                n3 = 294;
                break;
            }
            case -1966445585: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1964591421: {
                if (bl) {
                    if (n2 != -912290783) break;
                    n3 = 196;
                    break;
                }
                n3 = 196;
                break;
            }
            case -1948051951: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 203;
                    break;
                }
                n3 = 203;
                break;
            }
            case -1929959262: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case -1916801337: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case -1902462856: {
                if (bl) {
                    if (n2 != -1191841119) break;
                    n3 = 244;
                    break;
                }
                n3 = 244;
                break;
            }
            case -1897689908: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 223;
                    break;
                }
                n3 = 223;
                break;
            }
            case -1886713904: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case -1874091267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 216;
                    break;
                }
                n3 = 216;
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
            case -1854680207: {
                if (bl) {
                    if (n2 != -638790105) break;
                    n3 = 246;
                    break;
                }
                n3 = 246;
                break;
            }
            case -1823027655: {
                if (bl) {
                    if (n2 != 1138497487) break;
                    n3 = 224;
                    break;
                }
                n3 = 224;
                break;
            }
            case -1820350281: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case -1816626364: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 231;
                    break;
                }
                n3 = 231;
                break;
            }
            case -1782227917: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case -1754285676: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 201;
                    break;
                }
                n3 = 201;
                break;
            }
            case -1744008015: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 229;
                    break;
                }
                n3 = 229;
                break;
            }
            case -1743814058: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -1723754267: {
                if (bl) {
                    if (n2 != -47897083) break;
                    n3 = 199;
                    break;
                }
                n3 = 199;
                break;
            }
            case -1721720167: {
                if (bl) {
                    if (n2 != -1557790221) break;
                    n3 = 298;
                    break;
                }
                n3 = 298;
                break;
            }
            case -1712533362: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 232;
                    break;
                }
                n3 = 232;
                break;
            }
            case -1688334462: {
                if (bl) {
                    if (n2 != 284106918) break;
                    n3 = 280;
                    break;
                }
                n3 = 280;
                break;
            }
            case -1661938560: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1639200932: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1629202171: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 308;
                    break;
                }
                n3 = 308;
                break;
            }
            case -1627343727: {
                if (bl) {
                    if (n2 != -494801057) break;
                    n3 = 259;
                    break;
                }
                n3 = 259;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 260;
                    break;
                }
                n3 = 260;
                break;
            }
            case -1618612322: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -1610581601: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 220;
                    break;
                }
                n3 = 220;
                break;
            }
            case -1532906787: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case -1520022462: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 315;
                    break;
                }
                n3 = 315;
                break;
            }
            case -1516007996: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case -1499084408: {
                if (bl) {
                    if (n2 != 1794535380) break;
                    n3 = 262;
                    break;
                }
                n3 = 262;
                break;
            }
            case -1490850233: {
                if (bl) {
                    if (n2 != -462836873) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case -1462191177: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case -1459581221: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case -1414563717: {
                if (bl) {
                    if (n2 != 1372686599) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1405916490: {
                if (bl) {
                    if (n2 != 1466890078) break;
                    n3 = 309;
                    break;
                }
                n3 = 309;
                break;
            }
            case -1400788155: {
                if (bl) {
                    if (n2 != 2043315704) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -1364318689: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case -1361976387: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -1357007370: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 245;
                    break;
                }
                n3 = 245;
                break;
            }
            case -1348216097: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
                break;
            }
            case -1270450068: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 185;
                    break;
                }
                n3 = 185;
                break;
            }
            case -1270316619: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case -1261690455: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 303;
                    break;
                }
                n3 = 303;
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
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -1237668915: {
                if (bl) {
                    if (n2 != 487638186) break;
                    n3 = 249;
                    break;
                }
                n3 = 249;
                break;
            }
            case -1230385213: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 304;
                    break;
                }
                n3 = 304;
                break;
            }
            case -1229017563: {
                if (bl) {
                    if (n2 != -654615933) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -1217659679: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case -1195047537: {
                if (bl) {
                    if (n2 != -1953394071) break;
                    n3 = 264;
                    break;
                }
                n3 = 264;
                break;
            }
            case -1182718075: {
                if (bl) {
                    if (n2 != 259283458) break;
                    n3 = 288;
                    break;
                }
                n3 = 288;
                break;
            }
            case -1181451900: {
                if (bl) {
                    if (n2 == 1549857307) {
                        n3 = 73;
                        break;
                    }
                    if (n2 != -69669298) break;
                    n3 = 74;
                    break;
                }
                n3 = 73;
                break;
            }
            case -1177366766: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 257;
                    break;
                }
                n3 = 257;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1145982982: {
                if (bl) {
                    if (n2 != 1147312894) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case -1122125420: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 290;
                    break;
                }
                n3 = 290;
                break;
            }
            case -1101799778: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case -1076605344: {
                if (bl) {
                    if (n2 != 1410340865) break;
                    n3 = 310;
                    break;
                }
                n3 = 310;
                break;
            }
            case -1075464965: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -1070291380: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -1045808009: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 233;
                    break;
                }
                n3 = 233;
                break;
            }
            case -1036760729: {
                if (bl) {
                    if (n2 != -1966171079) break;
                    n3 = 302;
                    break;
                }
                n3 = 302;
                break;
            }
            case -1027020002: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1022859326: {
                if (bl) {
                    if (n2 != -1006107495) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -1016651511: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -1003326086: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -979682501: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -964155444: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 267;
                    break;
                }
                n3 = 267;
                break;
            }
            case -954073691: {
                if (bl) {
                    if (n2 != 253782595) break;
                    n3 = 266;
                    break;
                }
                n3 = 266;
                break;
            }
            case -948563826: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 312;
                    break;
                }
                n3 = 312;
                break;
            }
            case -947755853: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -939962027: {
                if (bl) {
                    if (n2 != 553619691) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -915173002: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case -903633686: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 192;
                    break;
                }
                n3 = 192;
                break;
            }
            case -876012174: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 207;
                    break;
                }
                n3 = 207;
                break;
            }
            case -873375852: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -867024848: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 270;
                    break;
                }
                n3 = 270;
                break;
            }
            case -866661259: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 296;
                    break;
                }
                n3 = 296;
                break;
            }
            case -845072699: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case -811354409: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -801904806: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 188;
                    break;
                }
                n3 = 188;
                break;
            }
            case -791775339: {
                if (bl) {
                    if (n2 != 1159578057) break;
                    n3 = 284;
                    break;
                }
                n3 = 284;
                break;
            }
            case -790362344: {
                if (bl) {
                    if (n2 != -972423086) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case -782979082: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 252;
                    break;
                }
                n3 = 252;
                break;
            }
            case -745428961: {
                if (bl) {
                    if (n2 != -1401574038) break;
                    n3 = 279;
                    break;
                }
                n3 = 279;
                break;
            }
            case -743417418: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case -730359808: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 301;
                    break;
                }
                n3 = 301;
                break;
            }
            case -719091602: {
                if (bl) {
                    if (n2 != -243759138) break;
                    n3 = 240;
                    break;
                }
                n3 = 240;
                break;
            }
            case -718336323: {
                if (bl) {
                    if (n2 != -2053992272) break;
                    n3 = 282;
                    break;
                }
                n3 = 282;
                break;
            }
            case -678622269: {
                if (bl) {
                    if (n2 != -1145889529) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case -678533979: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -656456036: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case -635709718: {
                if (bl) {
                    if (n2 != -1006107495) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -628918143: {
                if (bl) {
                    if (n2 != -1953394071) break;
                    n3 = 265;
                    break;
                }
                n3 = 265;
                break;
            }
            case -625798512: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 194;
                    break;
                }
                n3 = 194;
                break;
            }
            case -606740939: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case -596372792: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case -594976902: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -561927671: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 299;
                    break;
                }
                n3 = 299;
                break;
            }
            case -531972334: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case -529657498: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 186;
                    break;
                }
                n3 = 186;
                break;
            }
            case -519142424: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 221;
                    break;
                }
                n3 = 221;
                break;
            }
            case -479829192: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case -468459743: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 283;
                    break;
                }
                n3 = 283;
                break;
            }
            case -461412127: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 204;
                    break;
                }
                n3 = 204;
                break;
            }
            case -451786751: {
                if (bl) {
                    if (n2 != 341124178) break;
                    n3 = 269;
                    break;
                }
                n3 = 269;
                break;
            }
            case -416854998: {
                if (bl) {
                    if (n2 != 53949725) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -383772949: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case -379470343: {
                if (bl) {
                    if (n2 != -1622239583) break;
                    n3 = 253;
                    break;
                }
                n3 = 253;
                break;
            }
            case -364413426: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 184;
                    break;
                }
                n3 = 184;
                break;
            }
            case -353057651: {
                if (bl) {
                    if (n2 != -2023978998) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -320881599: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 228;
                    break;
                }
                n3 = 228;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 317;
                    break;
                }
                n3 = 317;
                break;
            }
            case -256349577: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case -253495902: {
                if (bl) {
                    if (n2 != -796524928) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -238141868: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -214512838: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 238;
                    break;
                }
                n3 = 238;
                break;
            }
            case -196475764: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 189;
                    break;
                }
                n3 = 189;
                break;
            }
            case -194598183: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case -169029971: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case -153397335: {
                if (bl) {
                    if (n2 != -1749998467) break;
                    n3 = 292;
                    break;
                }
                n3 = 292;
                break;
            }
            case -140487572: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 179;
                    break;
                }
                n3 = 179;
                break;
            }
            case -139135787: {
                if (bl) {
                    if (n2 != 448199346) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case -138357912: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 191;
                    break;
                }
                n3 = 191;
                break;
            }
            case -128971164: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case -107791238: {
                if (bl) {
                    if (n2 != -1365707824) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -94022317: {
                if (bl) {
                    if (n2 != -585071033) break;
                    n3 = 208;
                    break;
                }
                n3 = 208;
                break;
            }
            case -90180800: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 314;
                    break;
                }
                n3 = 314;
                break;
            }
            case -57436450: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -37286120: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 237;
                    break;
                }
                n3 = 237;
                break;
            }
            case -37223917: {
                if (bl) {
                    if (n2 != -593361741) break;
                    n3 = 227;
                    break;
                }
                n3 = 227;
                break;
            }
            case 3711032: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 271;
                    break;
                }
                n3 = 271;
                break;
            }
            case 0x631111: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 281;
                    break;
                }
                n3 = 281;
                break;
            }
            case 23021139: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 261;
                    break;
                }
                n3 = 261;
                break;
            }
            case 27160511: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 226;
                    break;
                }
                n3 = 226;
                break;
            }
            case 125379710: {
                if (bl) {
                    if (n2 != -534202681) break;
                    n3 = 273;
                    break;
                }
                n3 = 273;
                break;
            }
            case 157736628: {
                if (bl) {
                    if (n2 != 977376590) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 163734487: {
                if (bl) {
                    if (n2 != -115882523) break;
                    n3 = 212;
                    break;
                }
                n3 = 212;
                break;
            }
            case 185695509: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 191583276: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 203083237: {
                if (bl) {
                    if (n2 != -2023978998) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case 224254108: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 258;
                    break;
                }
                n3 = 258;
                break;
            }
            case 232599299: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 241276486: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 313;
                    break;
                }
                n3 = 313;
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
            case 290138257: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 293398879: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case 296323076: {
                if (bl) {
                    if (n2 != 1587919693) break;
                    n3 = 205;
                    break;
                }
                n3 = 205;
                break;
            }
            case 312011511: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 315826473: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 333479132: {
                if (bl) {
                    if (n2 != -1249243306) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 334614848: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case 351672292: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 365835900: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 377663781: {
                if (bl) {
                    if (n2 != 407939732) break;
                    n3 = 289;
                    break;
                }
                n3 = 289;
                break;
            }
            case 380582686: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 387969647: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 392312432: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 447961304: {
                if (bl) {
                    if (n2 != 259283458) break;
                    n3 = 300;
                    break;
                }
                n3 = 300;
                break;
            }
            case 448095160: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 307;
                    break;
                }
                n3 = 307;
                break;
            }
            case 457678296: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 214;
                    break;
                }
                n3 = 214;
                break;
            }
            case 464311107: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 479889703: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 286;
                    break;
                }
                n3 = 286;
                break;
            }
            case 482794978: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 213;
                    break;
                }
                n3 = 213;
                break;
            }
            case 510365367: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case 521580306: {
                if (bl) {
                    if (n2 != -1006107495) break;
                    n3 = 275;
                    break;
                }
                n3 = 275;
                break;
            }
            case 524060783: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 306;
                    break;
                }
                n3 = 306;
                break;
            }
            case 540125238: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 555793993: {
                if (bl) {
                    if (n2 != -70755089) break;
                    n3 = 255;
                    break;
                }
                n3 = 255;
                break;
            }
            case 601788384: {
                if (bl) {
                    if (n2 != 746133882) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case 630838163: {
                if (bl) {
                    if (n2 != 1587919693) break;
                    n3 = 202;
                    break;
                }
                n3 = 202;
                break;
            }
            case 662851925: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 694301005: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case 716273541: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 305;
                    break;
                }
                n3 = 305;
                break;
            }
            case 741132838: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 291;
                    break;
                }
                n3 = 291;
                break;
            }
            case 751614175: {
                if (bl) {
                    if (n2 != 18961586) break;
                    n3 = 187;
                    break;
                }
                n3 = 187;
                break;
            }
            case 754183110: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 757108928: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 210;
                    break;
                }
                n3 = 210;
                break;
            }
            case 780120599: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case 780679608: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case 797965358: {
                if (bl) {
                    if (n2 != 293113262) break;
                    n3 = 236;
                    break;
                }
                n3 = 236;
                break;
            }
            case 826559093: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 217;
                    break;
                }
                n3 = 217;
                break;
            }
            case 847170246: {
                if (bl) {
                    if (n2 != -2023978998) break;
                    n3 = 285;
                    break;
                }
                n3 = 285;
                break;
            }
            case 861537273: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 190;
                    break;
                }
                n3 = 190;
                break;
            }
            case 867531078: {
                if (bl) {
                    if (n2 != 823567806) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 877574685: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 254;
                    break;
                }
                n3 = 254;
                break;
            }
            case 887232784: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case 894671413: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 942934410: {
                if (bl) {
                    if (n2 != -192055600) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 957116880: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case 978366857: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 1026211586: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 198;
                    break;
                }
                n3 = 198;
                break;
            }
            case 1087208033: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
            case 1100742470: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 222;
                    break;
                }
                n3 = 222;
                break;
            }
            case 1143952616: {
                if (bl) {
                    if (n2 != 341124178) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case 1150213765: {
                if (bl) {
                    if (n2 != 1588906783) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case 1157933509: {
                if (bl) {
                    if (n2 != 1679287589) break;
                    n3 = 263;
                    break;
                }
                n3 = 263;
                break;
            }
            case 1169402795: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 272;
                    break;
                }
                n3 = 272;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 316;
                    break;
                }
                n3 = 316;
                break;
            }
            case 1225688664: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 1228316107: {
                if (bl) {
                    if (n2 != -14292859) break;
                    n3 = 268;
                    break;
                }
                n3 = 268;
                break;
            }
            case 1240524998: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 1242824715: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1252945163: {
                if (bl) {
                    if (n2 != -457258613) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1258174821: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 1281722151: {
                if (bl) {
                    if (n2 != -1290860902) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 1285136140: {
                if (bl) {
                    if (n2 != -1166448617) break;
                    n3 = 293;
                    break;
                }
                n3 = 293;
                break;
            }
            case 1296077239: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 235;
                    break;
                }
                n3 = 235;
                break;
            }
            case 1303861920: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 239;
                    break;
                }
                n3 = 239;
                break;
            }
            case 1304395984: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case 1312939157: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case 1318732747: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case 1325043556: {
                if (bl) {
                    if (n2 != 618681725) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1355292347: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 219;
                    break;
                }
                n3 = 219;
                break;
            }
            case 1361407982: {
                if (bl) {
                    if (n2 != 664485980) break;
                    n3 = 278;
                    break;
                }
                n3 = 278;
                break;
            }
            case 1362097342: {
                if (bl) {
                    if (n2 != -1365027086) break;
                    n3 = 311;
                    break;
                }
                n3 = 311;
                break;
            }
            case 1376047412: {
                if (bl) {
                    if (n2 != 1587919693) break;
                    n3 = 230;
                    break;
                }
                n3 = 230;
                break;
            }
            case 1395629698: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 1396539321: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 183;
                    break;
                }
                n3 = 183;
                break;
            }
            case 1400662171: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 225;
                    break;
                }
                n3 = 225;
                break;
            }
            case 1423031919: {
                if (bl) {
                    if (n2 != 528007529) break;
                    n3 = 256;
                    break;
                }
                n3 = 256;
                break;
            }
            case 1423267600: {
                if (bl) {
                    if (n2 != 1801798329) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case 1426115117: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 1433281428: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case 1450559542: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case 1462529167: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 297;
                    break;
                }
                n3 = 297;
                break;
            }
            case 1474675882: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case 1483555826: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case 1498869585: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 1502527396: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 209;
                    break;
                }
                n3 = 209;
                break;
            }
            case 1507012856: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 1513779268: {
                if (bl) {
                    if (n2 != -585071033) break;
                    n3 = 295;
                    break;
                }
                n3 = 295;
                break;
            }
            case 1544079526: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 200;
                    break;
                }
                n3 = 200;
                break;
            }
            case 1552104291: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case 1615930907: {
                if (bl) {
                    if (n2 != -653036081) break;
                    n3 = 193;
                    break;
                }
                n3 = 193;
                break;
            }
            case 1620431281: {
                if (bl) {
                    if (n2 != -866436352) break;
                    n3 = 242;
                    break;
                }
                n3 = 242;
                break;
            }
            case 1649422236: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case 1678360400: {
                if (bl) {
                    if (n2 != 1313881078) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case 1683670458: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 276;
                    break;
                }
                n3 = 276;
                break;
            }
            case 1697916367: {
                if (bl) {
                    if (n2 != -141377623) break;
                    n3 = 215;
                    break;
                }
                n3 = 215;
                break;
            }
            case 1704719883: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 1715063928: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 197;
                    break;
                }
                n3 = 197;
                break;
            }
            case 1730547727: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 1742778405: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case 1747238127: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case 1758198010: {
                if (bl) {
                    if (n2 != -1290860902) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1778023106: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case 1783907963: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 234;
                    break;
                }
                n3 = 234;
                break;
            }
            case 1838296204: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 251;
                    break;
                }
                n3 = 251;
                break;
            }
            case 1861835491: {
                if (bl) {
                    if (n2 != -912290783) break;
                    n3 = 243;
                    break;
                }
                n3 = 243;
                break;
            }
            case 1893432710: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 250;
                    break;
                }
                n3 = 250;
                break;
            }
            case 1904641290: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 1920026002: {
                if (bl) {
                    if (n2 != -47897083) break;
                    n3 = 241;
                    break;
                }
                n3 = 241;
                break;
            }
            case 1920409344: {
                if (bl) {
                    if (n2 != 775630887) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case 1927081498: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 248;
                    break;
                }
                n3 = 248;
                break;
            }
            case 1928172835: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case 1932561766: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case 1932571694: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 211;
                    break;
                }
                n3 = 211;
                break;
            }
            case 1948510049: {
                if (bl) {
                    if (n2 != 218596504) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1952022324: {
                if (bl) {
                    if (n2 != 1677270394) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 1982068574: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 1991485506: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case 1992106592: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 247;
                    break;
                }
                n3 = 247;
                break;
            }
            case 2038030040: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case 2061349978: {
                if (bl) {
                    if (n2 != 560644816) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 2074338854: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 287;
                    break;
                }
                n3 = 287;
                break;
            }
            case 2075759049: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 274;
                    break;
                }
                n3 = 274;
                break;
            }
            case 2097225560: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 2113841962: {
                if (bl) {
                    if (n2 != -2079390645) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 2144748432: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1966651000: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 326;
                    break;
                }
                n3 = 326;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 319;
                    break;
                }
                n3 = 319;
                break;
            }
            case -1689708524: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 328;
                    break;
                }
                n3 = 328;
                break;
            }
            case -1315981404: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 323;
                    break;
                }
                n3 = 323;
                break;
            }
            case -1237051658: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 324;
                    break;
                }
                n3 = 324;
                break;
            }
            case -727333836: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 327;
                    break;
                }
                n3 = 327;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 318;
                    break;
                }
                n3 = 318;
                break;
            }
            case 161077814: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 325;
                    break;
                }
                n3 = 325;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 320;
                    break;
                }
                n3 = 320;
                break;
            }
            case 730035378: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 321;
                    break;
                }
                n3 = 321;
                break;
            }
            case 1074018563: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 322;
                    break;
                }
                n3 = 322;
                break;
            }
            case 1807693807: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 329;
                    break;
                }
                n3 = 329;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1892065272: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 335;
                    break;
                }
                n3 = 335;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 331;
                    break;
                }
                n3 = 331;
                break;
            }
            case -874014742: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 336;
                    break;
                }
                n3 = 336;
                break;
            }
            case -625671924: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 332;
                    break;
                }
                n3 = 332;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 330;
                    break;
                }
                n3 = 330;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 333;
                    break;
                }
                n3 = 333;
                break;
            }
            case 291772872: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 334;
                    break;
                }
                n3 = 334;
                break;
            }
            case 692784497: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 337;
                    break;
                }
                n3 = 337;
                break;
            }
            case 1739625646: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 338;
                    break;
                }
                n3 = 338;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1974732855: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 348;
                    break;
                }
                n3 = 348;
                break;
            }
            case -1649020375: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 346;
                    break;
                }
                n3 = 346;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 341;
                    break;
                }
                n3 = 341;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 340;
                    break;
                }
                n3 = 340;
                break;
            }
            case -224382386: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 344;
                    break;
                }
                n3 = 344;
                break;
            }
            case -148731966: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 347;
                    break;
                }
                n3 = 347;
                break;
            }
            case -330892: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 345;
                    break;
                }
                n3 = 345;
                break;
            }
            case 3237765: {
                if (bl) {
                    if (n2 != -1419203957) break;
                    n3 = 349;
                    break;
                }
                n3 = 349;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 342;
                    break;
                }
                n3 = 342;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 339;
                    break;
                }
                n3 = 339;
                break;
            }
            case 2129632852: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 343;
                    break;
                }
                n3 = 343;
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
            case -1865945780: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -1129192443: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -1096161056: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 542295825: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case 1746898091: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((HsmCacheHandler)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 1: {
                HsmCacheHandler.clearCache();
                return null;
            }
            case 2: {
                ((HsmCacheHandler)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((HsmCacheHandler)object).initDsiIconExtractor();
                return null;
            }
            case 4: {
                ((HsmCacheHandler)object).dsiIconExtractorResourceIdForTMCEventIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 5: {
                ((HsmCacheHandler)object).dsiIconExtractorResourceIdForAdditionalIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 6: {
                ((HsmCacheHandler)object).dsiIconExtractorRenderingInformationForExitIcon((ResourceLocator)objectArray[0], (TextRenderingInfo)objectArray[1]);
                return null;
            }
            case 7: {
                ((HsmCacheHandler)object).dsiIconExtractorResourceIdForAdditionalTurnListIconResult((ResourceLocator)objectArray[0]);
                return null;
            }
            case 8: {
                ((HsmCacheHandler)object).dsiIconExtractorResourceIdForCountryIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 9: {
                ((HsmCacheHandler)object).dsiIconExtractorResourceIdForPOIIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 10: {
                ((HsmCacheHandler)object).dsiIconExtractorResourceIdForPOIIconFromRawDataResult((ResourceLocator)objectArray[0]);
                return null;
            }
            case 11: {
                ((HsmCacheHandler)object).dsiIconExtractorResourceIdForRoadClassIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 12: {
                ((HsmCacheHandler)object).dsiIconExtractorResourceIdForTargetIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 13: {
                ((HsmCacheHandler)object).dsiIconExtractorResourceIdForTrafficRegulationIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 14: {
                ((HsmCacheHandler)object).dsiIconExtractorResourceIdForAreaWarningIconResult((ResourceLocator)objectArray[0]);
                return null;
            }
            case 15: {
                ((HsmCacheHandler)object).dsiIconExtractorRenderingInformationForRoadIcon((ResourceLocator)objectArray[0], (TextRenderingInfo)objectArray[1]);
                return null;
            }
            case 16: {
                ((HsmCacheHandler)object).dsiIconExtractorAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 17: {
                return HsmCacheHandler.getTextRenderingInfo((IconKey)objectArray[0]);
            }
            case 18: {
                return HsmCacheHandler.resourceIdForTMCEventIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CacheClient)objectArray[3], objectArray[4]);
            }
            case 19: {
                return HsmCacheHandler.resourceIdForAdditionalIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CacheClient)objectArray[3], objectArray[4]);
            }
            case 20: {
                return HsmCacheHandler.resourceIdForAdditionalTurnlistIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (CacheClient)objectArray[4], objectArray[5]);
            }
            case 21: {
                return HsmCacheHandler.resourceIdForCountryIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (CacheClient)objectArray[2], objectArray[3]);
            }
            case 22: {
                return HsmCacheHandler.resourceIdForPOIIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CacheClient)objectArray[3], objectArray[4]);
            }
            case 23: {
                return HsmCacheHandler.resourceIdForPOIIconFromRawData(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CacheClient)objectArray[3], objectArray[4]);
            }
            case 24: {
                return HsmCacheHandler.resourceIdForRoadClassIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CacheClient)objectArray[3], objectArray[4]);
            }
            case 25: {
                return HsmCacheHandler.resourceIdForTargetIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (CacheClient)objectArray[2], objectArray[3]);
            }
            case 26: {
                return HsmCacheHandler.resourceIdForTrafficRegulationIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CacheClient)objectArray[3], objectArray[4]);
            }
            case 27: {
                return HsmCacheHandler.resourceIdForAreaWarningIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (CacheClient)objectArray[2], objectArray[3]);
            }
            case 28: {
                return HsmCacheHandler.resourceIdForRoadIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CacheClient)objectArray[3], objectArray[4]);
            }
            case 29: {
                return HsmCacheHandler.resourceIdForExitIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CacheClient)objectArray[3], objectArray[4]);
            }
            case 30: {
                ((HsmCacheHandler)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                return RuntimeUtil.valueOf(NavGateway.isInstance());
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                return ((NavGateway)object).getLanguage();
            }
            case 33: {
                return NavGateway.getInstance();
            }
            case 34: {
                ((NavGateway)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((NavGateway)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((NavGateway)object).lispRequestNVCListResult(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 37: {
                ((NavGateway)object).triggerEventAudioMessageResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 38: {
                ((NavGateway)object).setNotification();
                return null;
            }
            case 39: {
                ((NavGateway)object).handleNextCommands();
                return null;
            }
            case 40: {
                ((NavGateway)object).pushCommand((Command)objectArray[0]);
                return null;
            }
            case 41: {
                return ((NavGateway)object).getDsiNavigation();
            }
            case 42: {
                ((NavGateway)object).createExportFileResult(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 43: {
                ((NavGateway)object).dmLastDestinationsGetResult(((Number)objectArray[0]).longValue(), (NavLocation)objectArray[1]);
                return null;
            }
            case 44: {
                ((NavGateway)object).dmRecentRoutesGetResult(((Number)objectArray[0]).longValue(), (Route)objectArray[1]);
                return null;
            }
            case 45: {
                ((NavGateway)object).dmResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 46: {
                ((NavGateway)object).ehGetAllBrandsOfCategoryResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Brand[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 47: {
                ((NavGateway)object).ehGetAllCategoriesResult(((Number)objectArray[0]).intValue(), (Category[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 48: {
                ((NavGateway)object).ehResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((NavGateway)object).etcGetCountryAbbreviationResult((String)objectArray[0], ((Number)objectArray[1]).longValue());
                return null;
            }
            case 50: {
                ((NavGateway)object).etcSensorDataReplayGuidance((Boolean)objectArray[0]);
                return null;
            }
            case 51: {
                ((NavGateway)object).etcSensorDataReplayRoute((Route)objectArray[0]);
                return null;
            }
            case 52: {
                ((NavGateway)object).importFileResult(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 53: {
                ((NavGateway)object).languageSpellableCharactersResult((String)objectArray[0]);
                return null;
            }
            case 54: {
                ((NavGateway)object).liCurrentState((NavLocation)objectArray[0], (int[])objectArray[1], (int[])objectArray[2], ((Number)objectArray[3]).longValue());
                return null;
            }
            case 55: {
                ((NavGateway)object).liGetLastCityHistoryEntryResult((NavLocation)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 56: {
                ((NavGateway)object).liGetLastStreetHistoryEntryResult((NavLocation)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 57: {
                ((NavGateway)object).liGetLocationDescriptionTransformResult((NavLocation)objectArray[0]);
                return null;
            }
            case 58: {
                ((NavGateway)object).liGetStateResult((LISpellerData)objectArray[0]);
                return null;
            }
            case 59: {
                ((NavGateway)object).liGetViaPointListResult(((Number)objectArray[0]).intValue(), (ViaPointListElement[])objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 60: {
                ((NavGateway)object).liLastCityAndStreetHistoryResult(((Number)objectArray[0]).longValue());
                return null;
            }
            case 61: {
                ((NavGateway)object).liResult(((Number)objectArray[0]).longValue());
                return null;
            }
            case 62: {
                ((NavGateway)object).liSelectViaPointResult((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((NavGateway)object).liSetCountryForCityAndStreetHistoryResult(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((NavGateway)object).liStripLocationResult((NavLocation)objectArray[0]);
                return null;
            }
            case 65: {
                ((NavGateway)object).liThesaurusHistoryAddResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 66: {
                ((NavGateway)object).liThesaurusHistoryDeleteAllResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 67: {
                ((NavGateway)object).liThesaurusHistoryDeleteResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((NavGateway)object).liThesaurusHistoryGetEntryResult((ThesaurusHistoryEntry)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((NavGateway)object).liTryBestMatchResult((TryBestMatchResultData[])objectArray[0]);
                return null;
            }
            case 70: {
                ((NavGateway)object).liValueList((LIValueList)objectArray[0], ((Number)objectArray[1]).longValue());
                return null;
            }
            case 71: {
                ((NavGateway)object).liValueListFileStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 72: {
                ((NavGateway)object).liValueListOutputMethod(((Number)objectArray[0]).intValue());
                return null;
            }
            case 73: {
                ((NavGateway)object).lispUpdateSpellerResult((String)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (Boolean)objectArray[3], (String)objectArray[4], ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), (Boolean)objectArray[7], (Boolean)objectArray[8], ((Number)objectArray[9]).longValue());
                return null;
            }
            case 74: {
                ((NavGateway)object).lispUpdateSpellerResult((String)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (Boolean)objectArray[3], (String)objectArray[4], ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), (Boolean)objectArray[7], (Boolean)objectArray[8], ((Number)objectArray[9]).intValue(), ((Number)objectArray[10]).longValue());
                return null;
            }
            case 75: {
                ((NavGateway)object).locationToStreamResult((Boolean)objectArray[0], (byte[])objectArray[1]);
                return null;
            }
            case 76: {
                ((NavGateway)object).poiValueList((LIValueList)objectArray[0], ((Number)objectArray[1]).longValue());
                return null;
            }
            case 77: {
                ((NavGateway)object).requestCountryInfoResult((CountryInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 78: {
                ((NavGateway)object).responseAudioTrigger(((Number)objectArray[0]).intValue());
                return null;
            }
            case 79: {
                ((NavGateway)object).rgException(((Number)objectArray[0]).intValue());
                return null;
            }
            case 80: {
                ((NavGateway)object).rgNotPossible(((Number)objectArray[0]).intValue());
                return null;
            }
            case 81: {
                ((NavGateway)object).rgSetRouteGuidanceModeResult();
                return null;
            }
            case 82: {
                ((NavGateway)object).rgStartGuidanceCalculatedRouteResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 83: {
                ((NavGateway)object).rmMakeRoutePersistentResult(((Number)objectArray[0]).longValue());
                return null;
            }
            case 84: {
                ((NavGateway)object).rmRouteAddResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 85: {
                ((NavGateway)object).rmRouteDeleteAllResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 86: {
                ((NavGateway)object).rmRouteDeleteResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 87: {
                ((NavGateway)object).rmRouteGetResult(((Number)objectArray[0]).intValue(), (Route)objectArray[1]);
                return null;
            }
            case 88: {
                ((NavGateway)object).rmRouteRenameResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 89: {
                ((NavGateway)object).setRemainingRangeOfVehicleResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 90: {
                ((NavGateway)object).setTrailerStatusResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 91: {
                ((NavGateway)object).setUserDefinedPOIsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 92: {
                ((NavGateway)object).setVehicleConsumptionInfoResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 93: {
                ((NavGateway)object).soPosPositionDescriptionVehicleResult((NavLocation)objectArray[0]);
                return null;
            }
            case 94: {
                ((NavGateway)object).streamToLocationResult((Boolean)objectArray[0], (NavLocation)objectArray[1]);
                return null;
            }
            case 95: {
                ((NavGateway)object).trDeleteAllTracesResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((NavGateway)object).trDeleteTraceResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 97: {
                ((NavGateway)object).trRenameTraceResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 98: {
                ((NavGateway)object).trStartTraceRecordingResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 99: {
                ((NavGateway)object).trStopTraceRecordingResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 100: {
                ((NavGateway)object).trStoreTraceResult(((Number)objectArray[0]).intValue(), (NavSegmentID)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 101: {
                ((NavGateway)object).translateRouteResult((Route)objectArray[0]);
                return null;
            }
            case 102: {
                return RuntimeUtil.valueOf(((NavGateway)object).getAfaMode());
            }
            case 103: {
                return RuntimeUtil.valueOf(((NavGateway)object).isAfaModeValid());
            }
            case 104: {
                ((NavGateway)object).updateAfaMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 105: {
                return RuntimeUtil.valueOf(((NavGateway)object).isAfaSpeaking());
            }
            case 106: {
                return RuntimeUtil.valueOf(((NavGateway)object).isAfaSpeakingValid());
            }
            case 107: {
                ((NavGateway)object).updateAfaSpeaking((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 108: {
                return RuntimeUtil.valueOf(((NavGateway)object).getAudioState());
            }
            case 109: {
                return RuntimeUtil.valueOf(((NavGateway)object).isAudioStateValid());
            }
            case 110: {
                ((NavGateway)object).updateAudioRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 111: {
                return ((NavGateway)object).getAvailableLanguages();
            }
            case 112: {
                return RuntimeUtil.valueOf(((NavGateway)object).isAvailableLanguagesValid());
            }
            case 113: {
                ((NavGateway)object).updateAvailableLanguages((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 114: {
                return ((NavGateway)object).getBapManeuverDescriptor();
            }
            case 115: {
                return RuntimeUtil.valueOf(((NavGateway)object).isBapManeuverDescriptorValid());
            }
            case 116: {
                ((NavGateway)object).updateBapManeuverDescriptor((BapManeuverDescriptor[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 117: {
                return ((NavGateway)object).getBapTurnToInfo();
            }
            case 118: {
                return RuntimeUtil.valueOf(((NavGateway)object).isBapTurnToInfoValid());
            }
            case 119: {
                ((NavGateway)object).updateBapTurnToInfo((BapTurnToInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 120: {
                return ((NavGateway)object).getCityIndices();
            }
            case 121: {
                return RuntimeUtil.valueOf(((NavGateway)object).isCityIndicesValid());
            }
            case 122: {
                ((NavGateway)object).updateCityVignettes((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 123: {
                return ((NavGateway)object).getCountryInfo();
            }
            case 124: {
                return RuntimeUtil.valueOf(((NavGateway)object).isCountryInfoValid());
            }
            case 125: {
                ((NavGateway)object).updateCountryInfo((CountryInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 126: {
                return ((NavGateway)object).getCountryIndices();
            }
            case 127: {
                return RuntimeUtil.valueOf(((NavGateway)object).isCountryIndicesValid());
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((NavGateway)object).updateCountryVignettes((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 129: {
                return ((NavGateway)object).getDistanceToNextManeuver();
            }
            case 130: {
                return RuntimeUtil.valueOf(((NavGateway)object).isDistanceToNextManeuverValid());
            }
            case 131: {
                ((NavGateway)object).updateDistanceToNextManeuver((DistanceToNextManeuver)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 132: {
                return ((NavGateway)object).getFlagDestination();
            }
            case 133: {
                return RuntimeUtil.valueOf(((NavGateway)object).isFlagDestinationValid());
            }
            case 134: {
                ((NavGateway)object).updateDmFlagDestination((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 135: {
                return ((NavGateway)object).getDmLastDestinationsList();
            }
            case 136: {
                return RuntimeUtil.valueOf(((NavGateway)object).isDmLastDestinationsListValid());
            }
            case 137: {
                ((NavGateway)object).updateDmLastDestinationsList((LDListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 138: {
                return ((NavGateway)object).getDmRecentRoutesList();
            }
            case 139: {
                return RuntimeUtil.valueOf(((NavGateway)object).isDmRecentRoutesListValid());
            }
            case 140: {
                ((NavGateway)object).updateDmRecentRoutesList((RRListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 141: {
                return ((NavGateway)object).getNavDataBases();
            }
            case 142: {
                return RuntimeUtil.valueOf(((NavGateway)object).isNavDataBasesValid());
            }
            case 143: {
                ((NavGateway)object).updateEtcAvailableNavDataBases((NavDataBase[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 144: {
                return ((NavGateway)object).getCurrentNavDataBase();
            }
            case 145: {
                return RuntimeUtil.valueOf(((NavGateway)object).isCurrentNavDataBaseValid());
            }
            case 146: {
                ((NavGateway)object).updateEtcCurrentNavDataBase((NavDataBase)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 147: {
                return RuntimeUtil.valueOf(((NavGateway)object).getEtcDemoModeState());
            }
            case 148: {
                return RuntimeUtil.valueOf(((NavGateway)object).isEtcDemoModeStateValid());
            }
            case 149: {
                ((NavGateway)object).updateEtcDemoModeState((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 150: {
                return RuntimeUtil.valueOf(((NavGateway)object).getEtcLanguageLoadProgress());
            }
            case 151: {
                return RuntimeUtil.valueOf(((NavGateway)object).isEtcLanguageLoadProgressValid());
            }
            case 152: {
                ((NavGateway)object).updateEtcLanguageLoadProgress(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 153: {
                return RuntimeUtil.valueOf(((NavGateway)object).getEtcLanguageLoadStatus());
            }
            case 154: {
                return RuntimeUtil.valueOf(((NavGateway)object).isEtcLanguageLoadStatusValid());
            }
            case 155: {
                ((NavGateway)object).updateEtcLanguageLoadStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 156: {
                return RuntimeUtil.valueOf(((NavGateway)object).getEtcMetricSystem());
            }
            case 157: {
                return RuntimeUtil.valueOf(((NavGateway)object).isEtcMetricSystemValid());
            }
            case 158: {
                ((NavGateway)object).updateEtcMetricSystem(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 159: {
                return ((NavGateway)object).getEtcVersionInfo();
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                return RuntimeUtil.valueOf(((NavGateway)object).isEtcVersionInfoValid());
            }
            case 161: {
                ((NavGateway)object).updateEtcVersionInfo((NavVersionInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 162: {
                return ((NavGateway)object).getThesaurusHistory();
            }
            case 163: {
                return RuntimeUtil.valueOf(((NavGateway)object).isThesaurusHistoryValid());
            }
            case 164: {
                ((NavGateway)object).updateLIThesaurusHistory((ThesaurusHistoryEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 165: {
                return RuntimeUtil.valueOf(((NavGateway)object).isLanguageValid());
            }
            case 166: {
                ((NavGateway)object).updateLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 167: {
                return ((NavGateway)object).getCityHistory();
            }
            case 168: {
                return RuntimeUtil.valueOf(((NavGateway)object).isCityHistory());
            }
            case 169: {
                ((NavGateway)object).updateLiCityHistory((LICityHistoryEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 170: {
                return ((NavGateway)object).getCountryAbbreviation();
            }
            case 171: {
                return RuntimeUtil.valueOf(((NavGateway)object).isCountryAbbreviationValid());
            }
            case 172: {
                ((NavGateway)object).updateLiCountryForCityAndStreetHistory((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 173: {
                return ((NavGateway)object).getStreetHistory();
            }
            case 174: {
                return RuntimeUtil.valueOf(((NavGateway)object).isStreetHistoryValid());
            }
            case 175: {
                ((NavGateway)object).updateLiStreetHistory((LIStreetHistoryEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 176: {
                return RuntimeUtil.valueOf(((NavGateway)object).getLispIsSpellerActive());
            }
            case 177: {
                return RuntimeUtil.valueOf(((NavGateway)object).isLispIsSpellerActiveValid());
            }
            case 178: {
                ((NavGateway)object).updateLispIsSpellerActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 179: {
                return ((NavGateway)object).getNavMedia();
            }
            case 180: {
                return RuntimeUtil.valueOf(((NavGateway)object).isNavMediaValid());
            }
            case 181: {
                ((NavGateway)object).updateNavMedia((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 182: {
                return RuntimeUtil.valueOf(((NavGateway)object).getNavstateOfOperation());
            }
            case 183: {
                return RuntimeUtil.valueOf(((NavGateway)object).isNavstateOfOperationValid());
            }
            case 184: {
                ((NavGateway)object).updateNavstateOfOperation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 185: {
                return ((NavGateway)object).getPoiSubstringSearchStatus();
            }
            case 186: {
                return RuntimeUtil.valueOf(((NavGateway)object).isPoiSubstringSearchStatusValid());
            }
            case 187: {
                ((NavGateway)object).updatePoiSubstringSearchStatus((ValueListStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 188: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgActive());
            }
            case 189: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgActiveValid());
            }
            case 190: {
                ((NavGateway)object).updateRgActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 191: {
                return ((NavGateway)object).getRgCalculatedRoutes();
            }
        }
        return null;
    }

    private Object f6(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 192: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgCalculatedRoutesValid());
            }
            case 193: {
                ((NavGateway)object).updateRgCalculatedRoutes((CalculatedRouteListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 194: {
                return ((NavGateway)object).getRgCurrentRoute();
            }
            case 195: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgCurrentRouteValid());
            }
            case 196: {
                ((NavGateway)object).updateRgCurrentRoute((Route)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 197: {
                return ((NavGateway)object).getRgCurrentRouteOptions();
            }
            case 198: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgCurrentRouteOptionsValid());
            }
            case 199: {
                ((NavGateway)object).updateRgCurrentRouteOptions((RouteOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 200: {
                return ((NavGateway)object).getRgDestinationInfo();
            }
            case 201: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgDestinationInfoValid());
            }
            case 202: {
                ((NavGateway)object).updateRgDestinationInfo((NavRouteListData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 203: {
                return ((NavGateway)object).getRgDetailedStreetList();
            }
            case 204: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgDetailedStreetListValid());
            }
            case 205: {
                ((NavGateway)object).updateRgDetailedStreetList((NavRouteListData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 206: {
                return ((NavGateway)object).getRgInfoForNextDestination();
            }
            case 207: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgInfoForNextDestinationValid());
            }
            case 208: {
                ((NavGateway)object).updateRgInfoForNextDestination((RgInfoForNextDestination)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 209: {
                return ((NavGateway)object).getRgLaneGuidance();
            }
            case 210: {
                return RuntimeUtil.valueOf(((NavGateway)object).isShowLaneGuidance());
            }
            case 211: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgLaneGuidanceValid());
            }
            case 212: {
                ((NavGateway)object).updateRgLaneGuidance((NavLaneGuidanceData[])objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 213: {
                return ((NavGateway)object).getRgPoiInfo();
            }
            case 214: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgPoiInfoValid());
            }
            case 215: {
                ((NavGateway)object).updateRgPoiInfo((NavPoiInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 216: {
                return RuntimeUtil.valueOf(((NavGateway)object).getCalculationHorizon());
            }
            case 217: {
                return RuntimeUtil.valueOf(((NavGateway)object).isCalculationHorizonValid());
            }
            case 218: {
                ((NavGateway)object).updateRgPoiInfoCalculationHorizon(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 219: {
                return RuntimeUtil.valueOf(((NavGateway)object).getRgRouteCalculationState());
            }
            case 220: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgRouteCalculationStateValid());
            }
            case 221: {
                ((NavGateway)object).updateRgRouteCalculationState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 222: {
                return ((NavGateway)object).getRgRouteCostChangeInformation();
            }
            case 223: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgRouteCostChangeInformationValid());
            }
        }
        return null;
    }

    private Object f7(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 224: {
                ((NavGateway)object).updateRgRouteCostChangeInformation((RgRouteCostChangeInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 225: {
                return ((NavGateway)object).getRouteProperties();
            }
            case 226: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRoutePropertiesValid());
            }
            case 227: {
                ((NavGateway)object).updateRgRouteProperties((RouteProperties)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 228: {
                return ((NavGateway)object).getRgStreetList();
            }
            case 229: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgStreetListValid());
            }
            case 230: {
                ((NavGateway)object).updateRgStreetList((NavRouteListData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 231: {
                return RuntimeUtil.valueOf(((NavGateway)object).getRgTimeAfaToDestination());
            }
            case 232: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgTimeAfaToDestinationValid());
            }
            case 233: {
                ((NavGateway)object).updateRgTimeAfaToDestination(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 234: {
                return ((NavGateway)object).getRgTurnList();
            }
            case 235: {
                return RuntimeUtil.valueOf(((NavGateway)object).isRgTurnListValid());
            }
            case 236: {
                ((NavGateway)object).updateRgTurnList((TurnListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 237: {
                return RuntimeUtil.valueOf(((NavGateway)object).getTurnListCalculationHorizon());
            }
            case 238: {
                return RuntimeUtil.valueOf(((NavGateway)object).isTurnListCalculationHorizonValid());
            }
            case 239: {
                ((NavGateway)object).updateRgTurnListCalculationHorizon(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 240: {
                ((NavGateway)object).updateRgTurnToStreet((String)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 241: {
                ((NavGateway)object).updateRgUnfulfilledRouteOptions((RouteOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 242: {
                ((NavGateway)object).updateRgiString((short[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 243: {
                ((NavGateway)object).updateRmPersistentRoute((Route)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 244: {
                ((NavGateway)object).updateRmRouteList((NavRmRouteListArrayData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 245: {
                ((NavGateway)object).updateRrdActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 246: {
                ((NavGateway)object).updateRrdCalculationInfo((RrdCalculationInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 247: {
                return ((NavGateway)object).getSoPosPosition();
            }
            case 248: {
                return RuntimeUtil.valueOf(((NavGateway)object).isSoPosPositionValid());
            }
            case 249: {
                ((NavGateway)object).updateSoPosPosition((PosPosition)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 250: {
                return ((NavGateway)object).getSoPosPositionDescription();
            }
            case 251: {
                return RuntimeUtil.valueOf(((NavGateway)object).isSoPosPositionDescriptionValid());
            }
            case 252: {
                return RuntimeUtil.valueOf(((NavGateway)object).isSoPosPositionDescriptionInProgressData());
            }
            case 253: {
                ((NavGateway)object).updateSoPosPositionDescription((NavLocation)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 254: {
                ((NavGateway)object).updateStyleDBPaths((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 255: {
                ((NavGateway)object).updateTrDirectionToWaypoint((DirectionToWaypoint)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f8(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 256: {
                ((NavGateway)object).updateTrMemoryUtilization((NavTraceMemoryUtilization)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 257: {
                ((NavGateway)object).updateTrOperatingMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 258: {
                ((NavGateway)object).updateTrRecordingState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 259: {
                ((NavGateway)object).updateTrTraceList((NavTraceListData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 260: {
                ((NavGateway)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 261: {
                ((NavGateway)object).updateRouteResumePossible((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 262: {
                ((NavGateway)object).getSpellableCharactersResult((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), (String)objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 263: {
                ((NavGateway)object).rgStartGuidanceCalculatedRouteByUIDResult((NavSegmentID)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 264: {
                ((NavGateway)object).updatePOIsEnteringProximityRange((NavLocation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 265: {
                ((NavGateway)object).updatePOIsInsideProximityRange((NavLocation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 266: {
                ((NavGateway)object).liGetSpellableCharactersResult((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 267: {
                ((NavGateway)object).setVehicleFuelTypeResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 268: {
                ((NavGateway)object).createNavLocationOfPOIUIDResult(((Number)objectArray[0]).longValue(), (NavLocation)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 269: {
                ((NavGateway)object).updateEtcAvailablePersonalPOIDataBases((NavDataBase[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 270: {
                ((NavGateway)object).updatePersonalPOISearchStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 271: {
                ((NavGateway)object).rmRouteReplaceResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 272: {
                ((NavGateway)object).deletePersonalPOIDataBasesResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 273: {
                ((NavGateway)object).updateLiStateHistory((LIStateHistoryEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 274: {
                ((NavGateway)object).liHistoryResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 275: {
                ((NavGateway)object).liGetLastStateHistoryEntryResult((NavLocation)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 276: {
                ((NavGateway)object).rgSwitchToNextPossibleRoadResult((Boolean)objectArray[0]);
                return null;
            }
            case 277: {
                ((NavGateway)object).setNavInternalDataToFactorySettingsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 278: {
                ((NavGateway)object).liTryMatchLocationResult((TryMatchLocationResultData[])objectArray[0]);
                return null;
            }
            case 279: {
                ((NavGateway)object).updateNavDbRegionsState(((Number)objectArray[0]).intValue(), (String[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 280: {
                ((NavGateway)object).trImportTrailsResult((NavSegmentID[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 281: {
                ((NavGateway)object).trExportTrailsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 282: {
                ((NavGateway)object).updateTrInfoForNextWaypoint((NavNextWayPointInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 283: {
                ((NavGateway)object).rgStartRubberbandManipulationResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 284: {
                ((NavGateway)object).rgGetRouteBoundingRectangleResult((NavRectangle)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 285: {
                ((NavGateway)object).rgGetLocationOnRouteResult((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 286: {
                ((NavGateway)object).rgResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 287: {
                ((NavGateway)object).updateRgEnhancedSignPostInfoStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f9(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 288: {
                ((NavGateway)object).updateSoPosTimeInformation((PosTimeInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 289: {
                ((NavGateway)object).rgGetRubberBandPointPositionResult((NavLocationWgs84)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 290: {
                ((NavGateway)object).lispGetMatchingNVCResult((String)objectArray[0]);
                return null;
            }
            case 291: {
                ((NavGateway)object).etcSetDemoModeResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 292: {
                ((NavGateway)object).lispGetLocationFromLiValueListResult(((Number)objectArray[0]).intValue(), (NavLocation)objectArray[1]);
                return null;
            }
            case 293: {
                ((NavGateway)object).poiGetXt9LDBsResult((String[])objectArray[0]);
                return null;
            }
            case 294: {
                ((NavGateway)object).updateRgMotorwayInfo((NavPoiInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 295: {
                ((NavGateway)object).updateRgVirtualDestinationInfo((RgInfoForNextDestination)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 296: {
                ((NavGateway)object).rgTriggerRCCIUpdateResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 297: {
                ((NavGateway)object).liGetLocationDescriptionTransformNearByResult((NavLocation)objectArray[0]);
                return null;
            }
            case 298: {
                ((NavGateway)object).updateRgTurnToInfo((RgTurnToInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 299: {
                ((NavGateway)object).poiGetCategoryTypesFromUIdResult((int[])objectArray[0]);
                return null;
            }
            case 300: {
                ((NavGateway)object).etcGetPositionTimeInfoResult((PosTimeInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 301: {
                ((NavGateway)object).updateRgPersistedRouteDataAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 302: {
                ((NavGateway)object).liDisambiguateLocationResult((int[])objectArray[0], (NavLocation[])objectArray[1]);
                return null;
            }
            case 303: {
                ((NavGateway)object).etcTriggerNavigationRestartResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 304: {
                ((NavGateway)object).updateMapIntegrationProgress(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 305: {
                ((NavGateway)object).updateMapIntegrationState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 306: {
                ((NavGateway)object).importRouteFromGpxFileResult((NavLocation)objectArray[0]);
                return null;
            }
            case 307: {
                ((NavGateway)object).rmImportToursFromGpxFileResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 308: {
                ((NavGateway)object).updateBapManeuverState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 309: {
                ((NavGateway)object).updateRmImportToursFromGpxFileStatus((TourImportStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 310: {
                ((NavGateway)object).updateBapManeuverInformation((BapManeuverDescriptor[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 311: {
                ((NavGateway)object).poiRequestExtendedInfoResult((PoiExtendedInfo)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 312: {
                ((NavGateway)object).trClearRecordedTraceCacheResult();
                return null;
            }
            case 313: {
                ((NavGateway)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 314: {
                ((NavGateway)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 315: {
                ((NavGateway)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 316: {
                ((NavGateway)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 317: {
                ((NavGateway)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 318: {
                ((HsmTargetProfileChange)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 319: {
                ((HsmTargetProfileChange)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f10(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 320: {
                ((HsmTargetProfileChange)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 321: {
                ((HsmTargetProfileChange)object).transStateIdle();
                return null;
            }
            case 322: {
                ((HsmTargetProfileChange)object).transStatePrepareForProfileChange();
                return null;
            }
            case 323: {
                ((HsmTargetProfileChange)object).transStateProfileChangeRunning();
                return null;
            }
            case 324: {
                ((HsmTargetProfileChange)object).transStatePostDsiForProfileChange();
                return null;
            }
            case 325: {
                ((HsmTargetProfileChange)object).startGuidanceOfPreviousRoute();
                return null;
            }
            case 326: {
                return RuntimeUtil.valueOf(((HsmTargetProfileChange)object).isPreviousRoutePresent());
            }
            case 327: {
                ((HsmTargetProfileChange)object).recalculatePreviousRoute();
                return null;
            }
            case 328: {
                ((HsmTargetProfileChange)object).cacheCurrentRouteAndStopGuidance();
                return null;
            }
            case 329: {
                ((HsmTargetProfileChange)object).stopGuidance();
                return null;
            }
            case 330: {
                ((MapRegionalUpdateTargetHSM)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 331: {
                ((MapRegionalUpdateTargetHSM)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 332: {
                ((MapRegionalUpdateTargetHSM)object).addObserver();
                return null;
            }
            case 333: {
                ((MapRegionalUpdateTargetHSM)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 334: {
                ((MapRegionalUpdateTargetHSM)object).transStateMapIntegrationInProgress();
                return null;
            }
            case 335: {
                ((MapRegionalUpdateTargetHSM)object).transStateMapIntegrationFinished();
                return null;
            }
            case 336: {
                ((MapRegionalUpdateTargetHSM)object).transStateMapIntegrationIdle();
                return null;
            }
            case 337: {
                ((MapRegionalUpdateTargetHSM)object).handleNavigationRestartRequest();
                return null;
            }
            case 338: {
                ((MapRegionalUpdateTargetHSM)object).handleNavigationRestartRequestResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 339: {
                ((DsiNavigationAdapter)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 340: {
                ((DsiNavigationAdapter)object).profileResetAll();
                return null;
            }
            case 341: {
                ((DsiNavigationAdapter)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 342: {
                ((DsiNavigationAdapter)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 343: {
                ((DsiNavigationAdapter)object).dsiNavigationUpdateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 344: {
                ((DsiNavigationAdapter)object).dsiNavigationProfileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 345: {
                ((DsiNavigationAdapter)object).dsiNavigationProfileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 346: {
                ((DsiNavigationAdapter)object).dsiNavigationProfileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 347: {
                ((DsiNavigationAdapter)object).dsiNavigationProfileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 348: {
                return ((DsiNavigationAdapter)object).getDsiClass();
            }
            case 349: {
                ((DsiNavigationAdapter)object).init((PersonalizedAppListener)objectArray[0]);
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

