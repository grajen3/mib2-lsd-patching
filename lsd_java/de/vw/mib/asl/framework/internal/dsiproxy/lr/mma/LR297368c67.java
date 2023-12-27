/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.DSICombinedRouteList;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public final class LR297368c67
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1225386138: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 5;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 6;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 7;
                    break;
                }
                n3 = 5;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 8;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 9;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 10;
                    break;
                }
                n3 = 8;
                break;
            }
            case 304518739: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 824204861: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1630198722: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1968409208: {
                if (bl) {
                    if (n2 != -17567424) break;
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
            case -2143353444: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -2105408756: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case -2104706548: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -2101813972: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case -2074230059: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -2048823218: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case -2014977368: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case -2001044683: {
                if (bl) {
                    if (n2 != 53949725) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1977863752: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1970444680: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case -1955348603: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1888596459: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -1795969875: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1754177244: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case -1735346844: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
            case -1735187868: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case -1731925419: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1701606419: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1656514935: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1652750213: {
                if (bl) {
                    if (n2 != 363410995) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case -1646024900: {
                if (bl) {
                    if (n2 != 1964896540) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -1618894401: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -1618794181: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -1603629199: {
                if (bl) {
                    if (n2 != 1707714853) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -1587105108: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 184;
                    break;
                }
                n3 = 184;
                break;
            }
            case -1584151771: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1486621275: {
                if (bl) {
                    if (n2 != 686467679) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -1441951999: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -1417405041: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1341169244: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -1321834962: {
                if (bl) {
                    if (n2 != -1166448617) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case -1284056710: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -1281954816: {
                if (bl) {
                    if (n2 != -791421351) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -1275420472: {
                if (bl) {
                    if (n2 != -491970200) break;
                    n3 = 183;
                    break;
                }
                n3 = 183;
                break;
            }
            case -1271550066: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case -1228117667: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1182664835: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case -1176899986: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 192;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 193;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 194;
                    break;
                }
                n3 = 192;
                break;
            }
            case -1142238217: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1102334130: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case -1093849441: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case -1042203658: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -1023446000: {
                if (bl) {
                    if (n2 != -900640479) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case -1018939840: {
                if (bl) {
                    if (n2 != -1514946156) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -962034472: {
                if (bl) {
                    if (n2 != -382972672) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 195;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 196;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 197;
                    break;
                }
                n3 = 195;
                break;
            }
            case -941404726: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case -940450524: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case -935428152: {
                if (bl) {
                    if (n2 != 1707714853) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case -900387033: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case -880003481: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case -854108457: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -797370196: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -763145684: {
                if (bl) {
                    if (n2 != -900640479) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case -683975583: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -661378102: {
                if (bl) {
                    if (n2 != -1166448617) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case -624432604: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case -621212805: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case -609951298: {
                if (bl) {
                    if (n2 != 1929291633) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case -555255618: {
                if (bl) {
                    if (n2 != -1529287658) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -534661751: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case -521113324: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case -507235215: {
                if (bl) {
                    if (n2 != -911205591) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -503532933: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -478361433: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -452302968: {
                if (bl) {
                    if (n2 != -679063699) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -452297155: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -416085919: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -395696570: {
                if (bl) {
                    if (n2 != 1976237761) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case -357203183: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -301709464: {
                if (bl) {
                    if (n2 != 34963660) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -301703651: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -292462313: {
                if (bl) {
                    if (n2 != -19404284) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -281255646: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case -268725308: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -251185819: {
                if (bl) {
                    if (n2 != 3516) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case -226921257: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -206634423: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case -196534779: {
                if (bl) {
                    if (n2 != 93000569) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -185178212: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -181563608: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case -166282981: {
                if (bl) {
                    if (n2 != 17850877) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case -138833518: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -134838198: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case -84099014: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case -79745347: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -7467565: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 7650584: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 17167044: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case 22673397: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 186;
                    break;
                }
                n3 = 186;
                break;
            }
            case 25206068: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
                break;
            }
            case 48684628: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case 149393478: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 163692712: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 183154255: {
                if (bl) {
                    if (n2 != -2023978998) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case 183962777: {
                if (bl) {
                    if (n2 != 696049932) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 203638753: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case 204717127: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 207115742: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 222932021: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case 283127839: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case 323105730: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 355002140: {
                if (bl) {
                    if (n2 != 47747735) break;
                    n3 = 189;
                    break;
                }
                n3 = 189;
                break;
            }
            case 357914801: {
                if (bl) {
                    if (n2 != -758739631) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 417760312: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case 429838095: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case 525376470: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 538064709: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case 569277260: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 578177677: {
                if (bl) {
                    if (n2 != -912290783) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 593091470: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case 610919157: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 617123488: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 650454514: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 187;
                    break;
                }
                n3 = 187;
                break;
            }
            case 703971184: {
                if (bl) {
                    if (n2 != 17850877) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case 724198616: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 728503128: {
                if (bl) {
                    if (n2 != 2040115428) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 732621208: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case 781418508: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 785664848: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case 802558083: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 811613096: {
                if (bl) {
                    if (n2 != -2023978998) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 815015653: {
                if (bl) {
                    if (n2 != -2023978998) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case 816444352: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 859123194: {
                if (bl) {
                    if (n2 != -1941743767) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case 860583863: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 884074761: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 900235695: {
                if (bl) {
                    if (n2 != -382972672) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case 916110569: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 941023549: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case 978366857: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 978514257: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 190;
                    break;
                }
                n3 = 190;
                break;
            }
            case 1006306885: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 1029941618: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 1040929203: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1060509050: {
                if (bl) {
                    if (n2 != -234225152) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case 1068851110: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case 1071263451: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case 1072451728: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case 1074214714: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case 1118762423: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 1149752388: {
                if (bl) {
                    if (n2 != -382972672) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1208320654: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1213681792: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case 1258225898: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 179;
                    break;
                }
                n3 = 179;
                break;
            }
            case 1280978173: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 1313403680: {
                if (bl) {
                    if (n2 != -1514946156) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1323525881: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
            case 1331751289: {
                if (bl) {
                    if (n2 != 696049932) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 1346726734: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 1365819127: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 1432441003: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 1477448173: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1590884784: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 1595135726: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case 1609184289: {
                if (bl) {
                    if (n2 != -1521674749) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case 1660486838: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 1682989056: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case 1685529647: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 1714821275: {
                if (bl) {
                    if (n2 != -1891388980) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1715898923: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case 1730105364: {
                if (bl) {
                    if (n2 != 517399537) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 1753549815: {
                if (bl) {
                    if (n2 != -1217415725) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 1794038648: {
                if (bl) {
                    if (n2 != -382972672) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case 1799534104: {
                if (bl) {
                    if (n2 != -1790751914) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1801661397: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case 1854887646: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1855115312: {
                if (bl) {
                    if (n2 != -128339745) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1970938889: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case 2004866167: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 2008181755: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 185;
                    break;
                }
                n3 = 185;
                break;
            }
            case 2029691410: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 2033955181: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 191;
                    break;
                }
                n3 = 191;
                break;
            }
            case 2034300897: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 2104183848: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case 2107095425: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 188;
                    break;
                }
                n3 = 188;
                break;
            }
            case 2124842294: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
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
            case -808261039: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -722150673: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICombinedRouteList)object).requestCombinedRouteListWindow(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (long[])objectArray[2], ((Number)objectArray[3]).longValue());
                return null;
            }
            case 1: {
                ((DSICombinedRouteList)object).requestTrafficInformation(((Number)objectArray[0]).longValue());
                return null;
            }
            case 2: {
                ((DSICombinedRouteList)object).requestPOIInformation(((Number)objectArray[0]).longValue());
                return null;
            }
            case 3: {
                ((DSICombinedRouteList)object).getBoundingRectangleOfCombinedRouteListElements((long[])objectArray[0]);
                return null;
            }
            case 4: {
                ((DSICombinedRouteList)object).requestPriceInfo(((Number)objectArray[0]).longValue());
                return null;
            }
            case 5: {
                ((DSICombinedRouteList)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSICombinedRouteList)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSICombinedRouteList)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSICombinedRouteList)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSICombinedRouteList)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSICombinedRouteList)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSINavigation)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSINavigation)object).createExportFile((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSINavigation)object).importFile((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSINavigation)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSINavigation)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSINavigation)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSINavigation)object).profileResetAll();
                return null;
            }
            case 18: {
                ((DSINavigation)object).ehSetCategoryVisibility(((Number)objectArray[0]).intValue(), (int[])objectArray[1], (boolean[])objectArray[2]);
                return null;
            }
            case 19: {
                ((DSINavigation)object).ehSetCategoryVisibilityToDefault(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSINavigation)object).afaRepeat(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSINavigation)object).dmFlagDestinationSet((NavLocation)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSINavigation)object).dmFlagDestinationRemove();
                return null;
            }
            case 23: {
                ((DSINavigation)object).dmFlagDestinationSetName((String)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSINavigation)object).dmLastDestinationsAddList((NavLastDest[])objectArray[0]);
                return null;
            }
            case 25: {
                ((DSINavigation)object).dmLastDestinationsDelete(((Number)objectArray[0]).longValue());
                return null;
            }
            case 26: {
                ((DSINavigation)object).dmLastDestinationsDeleteAll();
                return null;
            }
            case 27: {
                ((DSINavigation)object).dmLastDestinationsGet(((Number)objectArray[0]).longValue());
                return null;
            }
            case 28: {
                ((DSINavigation)object).dmLastDestinationsReplace(((Number)objectArray[0]).longValue(), (NavLocation)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 29: {
                ((DSINavigation)object).dmRecentRoutesAdd((Route)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSINavigation)object).dmRecentRoutesDelete(((Number)objectArray[0]).longValue());
                return null;
            }
            case 31: {
                ((DSINavigation)object).dmRecentRoutesDeleteAll();
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSINavigation)object).dmRecentRoutesGet(((Number)objectArray[0]).longValue());
                return null;
            }
            case 33: {
                ((DSINavigation)object).dmRecentRoutesReplace(((Number)objectArray[0]).longValue(), (Route)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 34: {
                ((DSINavigation)object).enableRgStreetLists((Boolean)objectArray[0]);
                return null;
            }
            case 35: {
                ((DSINavigation)object).enableRgLaneGuidance((Boolean)objectArray[0]);
                return null;
            }
            case 36: {
                ((DSINavigation)object).enableRgPoiInfo((Boolean)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSINavigation)object).etcGetCountryAbbreviation((String)objectArray[0]);
                return null;
            }
            case 38: {
                ((DSINavigation)object).etcSetDemoMode((Boolean)objectArray[0]);
                return null;
            }
            case 39: {
                ((DSINavigation)object).etcSetDemoModeSpeed(((Number)objectArray[0]).longValue());
                return null;
            }
            case 40: {
                ((DSINavigation)object).etcSetMetricSystem(((Number)objectArray[0]).intValue());
                return null;
            }
            case 41: {
                ((DSINavigation)object).etcSelectDatabase(((Number)objectArray[0]).intValue());
                return null;
            }
            case 42: {
                ((DSINavigation)object).etcSelectNavDataBase(((Number)objectArray[0]).intValue());
                return null;
            }
            case 43: {
                ((DSINavigation)object).languageSpellableCharacters((String)objectArray[0]);
                return null;
            }
            case 44: {
                ((DSINavigation)object).liGetCurrentState();
                return null;
            }
            case 45: {
                ((DSINavigation)object).liGetLastCityHistoryEntry(((Number)objectArray[0]).longValue());
                return null;
            }
            case 46: {
                ((DSINavigation)object).liGetLastStreetHistoryEntry(((Number)objectArray[0]).longValue());
                return null;
            }
            case 47: {
                ((DSINavigation)object).liGetLocationDescriptionTransform((NavLocation)objectArray[0]);
                return null;
            }
            case 48: {
                ((DSINavigation)object).liGetLocationDescriptionTransformNearBy((NavLocation)objectArray[0]);
                return null;
            }
            case 49: {
                ((DSINavigation)object).liGetState();
                return null;
            }
            case 50: {
                ((DSINavigation)object).liGetLastStateHistoryEntry(((Number)objectArray[0]).longValue());
                return null;
            }
            case 51: {
                ((DSINavigation)object).liLastStateHistoryAdd((NavLocation)objectArray[0], (Boolean)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 52: {
                ((DSINavigation)object).liLastStateHistoryAddExtended((NavLocation)objectArray[0], (Boolean)objectArray[1], (String)objectArray[2], (LIExtData[])objectArray[3]);
                return null;
            }
            case 53: {
                ((DSINavigation)object).liLastStateHistoryDelete(((Number)objectArray[0]).longValue());
                return null;
            }
            case 54: {
                ((DSINavigation)object).liLastStateHistoryDeleteAll();
                return null;
            }
            case 55: {
                ((DSINavigation)object).liLastCityHistoryAdd((NavLocation)objectArray[0], (Boolean)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 56: {
                ((DSINavigation)object).liLastCityHistoryAddExtended((NavLocation)objectArray[0], (Boolean)objectArray[1], (String)objectArray[2], (LIExtData[])objectArray[3]);
                return null;
            }
            case 57: {
                ((DSINavigation)object).liLastCityHistoryDelete(((Number)objectArray[0]).longValue());
                return null;
            }
            case 58: {
                ((DSINavigation)object).liLastCityHistoryDeleteAll();
                return null;
            }
            case 59: {
                ((DSINavigation)object).liLastStreetHistoryAdd((NavLocation)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 60: {
                ((DSINavigation)object).liLastStreetHistoryAddExtended((NavLocation)objectArray[0], (String)objectArray[1], (LIExtData[])objectArray[2]);
                return null;
            }
            case 61: {
                ((DSINavigation)object).liLastStreetHistoryDelete(((Number)objectArray[0]).longValue());
                return null;
            }
            case 62: {
                ((DSINavigation)object).liLastStreetHistoryDeleteAll();
                return null;
            }
            case 63: {
                ((DSINavigation)object).liRestoreState((LISpellerData)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSINavigation)object).liSetCountryForCityAndStreetHistory((String)objectArray[0]);
                return null;
            }
            case 65: {
                ((DSINavigation)object).liSetHistory((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 66: {
                ((DSINavigation)object).liSetStreetForCityHistory((String)objectArray[0]);
                return null;
            }
            case 67: {
                ((DSINavigation)object).liDeleteHistory();
                return null;
            }
            case 68: {
                ((DSINavigation)object).liSetCurrentLD((NavLocation)objectArray[0]);
                return null;
            }
            case 69: {
                ((DSINavigation)object).lispAddCharacter((String)objectArray[0]);
                return null;
            }
            case 70: {
                ((DSINavigation)object).lispCancelSpeller();
                return null;
            }
            case 71: {
                ((DSINavigation)object).lispDeleteAllCharacters();
                return null;
            }
            case 72: {
                ((DSINavigation)object).lispRequestValueListByListIndex(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 73: {
                ((DSINavigation)object).lispSelectListItem(((Number)objectArray[0]).intValue());
                return null;
            }
            case 74: {
                ((DSINavigation)object).lispSelectItemFromLocation((NavLocation)objectArray[0]);
                return null;
            }
            case 75: {
                ((DSINavigation)object).lispSelectByCategoryUid(((Number)objectArray[0]).intValue());
                return null;
            }
            case 76: {
                ((DSINavigation)object).lispSelectByMultipleCategoryUids((int[])objectArray[0]);
                return null;
            }
            case 77: {
                ((DSINavigation)object).lispSetInput((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 78: {
                ((DSINavigation)object).lispGetMatchingNVC((String)objectArray[0]);
                return null;
            }
            case 79: {
                ((DSINavigation)object).lispUndoCharacter();
                return null;
            }
            case 80: {
                ((DSINavigation)object).liStartMultiCriteriaSpeller(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], (Boolean)objectArray[3], (Boolean)objectArray[4]);
                return null;
            }
            case 81: {
                ((DSINavigation)object).liStartSpeller(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], (Boolean)objectArray[2], (Boolean)objectArray[3]);
                return null;
            }
            case 82: {
                ((DSINavigation)object).liTryBestMatch((TryBestMatchData)objectArray[0]);
                return null;
            }
            case 83: {
                ((DSINavigation)object).liValueListFilename((String)objectArray[0]);
                return null;
            }
            case 84: {
                ((DSINavigation)object).liValueListOutputMethod(((Number)objectArray[0]).intValue());
                return null;
            }
            case 85: {
                ((DSINavigation)object).locationToStream((NavLocation)objectArray[0]);
                return null;
            }
            case 86: {
                ((DSINavigation)object).poiSelectSelectionCriteria(((Number)objectArray[0]).longValue());
                return null;
            }
            case 87: {
                ((DSINavigation)object).poiSetContext((NavLocation)objectArray[0]);
                return null;
            }
            case 88: {
                ((DSINavigation)object).poiSetSortOrder2(((Number)objectArray[0]).intValue());
                return null;
            }
            case 89: {
                ((DSINavigation)object).poiStartSpellerAlongRoute(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).longValue());
                return null;
            }
            case 90: {
                ((DSINavigation)object).poiStartSpellerAlongRouteAdvanced(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).longValue(), ((Number)objectArray[3]).longValue(), (Boolean)objectArray[4]);
                return null;
            }
            case 91: {
                ((DSINavigation)object).requestSoPosPositionDescriptionVehicle();
                return null;
            }
            case 92: {
                ((DSINavigation)object).rgCalculateRoute((Route)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 93: {
                ((DSINavigation)object).rgSetPosition((NavLocation)objectArray[0]);
                return null;
            }
            case 94: {
                ((DSINavigation)object).rgSetRouteGuidanceMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 95: {
                ((DSINavigation)object).rgSetRouteOptions((RouteOptions)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSINavigation)object).rgStartGuidanceCalculatedRoute(((Number)objectArray[0]).intValue());
                return null;
            }
            case 97: {
                ((DSINavigation)object).rgStopGuidance();
                return null;
            }
            case 98: {
                ((DSINavigation)object).rmMakeRoutePersistent((Route)objectArray[0]);
                return null;
            }
            case 99: {
                ((DSINavigation)object).rmRouteAdd(((Number)objectArray[0]).intValue(), (Route)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 100: {
                ((DSINavigation)object).rmRouteDelete(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 101: {
                ((DSINavigation)object).rmRouteDeleteAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 102: {
                ((DSINavigation)object).rmRouteGet(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 103: {
                ((DSINavigation)object).rmRouteRename(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (String)objectArray[2]);
                return null;
            }
            case 104: {
                ((DSINavigation)object).rrdStartCalculationByListIndex(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 105: {
                ((DSINavigation)object).rrdStartCalculationForPosition((NavLocationWgs84[])objectArray[0]);
                return null;
            }
            case 106: {
                ((DSINavigation)object).rrdStopCalculation();
                return null;
            }
            case 107: {
                ((DSINavigation)object).streamToLocation((byte[])objectArray[0]);
                return null;
            }
            case 108: {
                ((DSINavigation)object).translateRoute((Route)objectArray[0]);
                return null;
            }
            case 109: {
                ((DSINavigation)object).trCreateWaypoint();
                return null;
            }
            case 110: {
                ((DSINavigation)object).trDeleteAllTraces();
                return null;
            }
            case 111: {
                ((DSINavigation)object).trDeleteTrace((NavSegmentID)objectArray[0]);
                return null;
            }
            case 112: {
                ((DSINavigation)object).trRenameTrace((NavSegmentID)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 113: {
                ((DSINavigation)object).trStartTraceRecording(((Number)objectArray[0]).intValue());
                return null;
            }
            case 114: {
                ((DSINavigation)object).trStopTraceRecording();
                return null;
            }
            case 115: {
                ((DSINavigation)object).trStoreTrace((String)objectArray[0]);
                return null;
            }
            case 116: {
                ((DSINavigation)object).liStripLocation((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 117: {
                ((DSINavigation)object).liSetNVCRange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 118: {
                ((DSINavigation)object).liValueListWindowSize(((Number)objectArray[0]).intValue());
                return null;
            }
            case 119: {
                ((DSINavigation)object).requestAudioTrigger(((Number)objectArray[0]).intValue());
                return null;
            }
            case 120: {
                ((DSINavigation)object).liThesaurusHistoryAdd((String)objectArray[0]);
                return null;
            }
            case 121: {
                ((DSINavigation)object).liThesaurusHistoryGetEntry(((Number)objectArray[0]).intValue());
                return null;
            }
            case 122: {
                ((DSINavigation)object).liThesaurusHistoryDelete(((Number)objectArray[0]).intValue());
                return null;
            }
            case 123: {
                ((DSINavigation)object).liThesaurusHistoryDeleteAll();
                return null;
            }
            case 124: {
                ((DSINavigation)object).ehGetAllCategories(((Number)objectArray[0]).intValue());
                return null;
            }
            case 125: {
                ((DSINavigation)object).ehGetAllBrandsOfCategory(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 126: {
                ((DSINavigation)object).ehSetCategoryAudioWarning(((Number)objectArray[0]).intValue(), (int[])objectArray[1], (boolean[])objectArray[2]);
                return null;
            }
            case 127: {
                ((DSINavigation)object).ehSetCategoryMonitoring((int[])objectArray[0], (boolean[])objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((DSINavigation)object).ehSetBrandVisibility(((Number)objectArray[0]).intValue(), (int[])objectArray[1], (boolean[])objectArray[2]);
                return null;
            }
            case 129: {
                ((DSINavigation)object).ehSetBrandPreference(((Number)objectArray[0]).intValue(), (int[])objectArray[1], (boolean[])objectArray[2]);
                return null;
            }
            case 130: {
                ((DSINavigation)object).setRemainingRangeOfVehicle(((Number)objectArray[0]).intValue());
                return null;
            }
            case 131: {
                ((DSINavigation)object).setUserDefinedPOIs((NavLocation[])objectArray[0]);
                return null;
            }
            case 132: {
                ((DSINavigation)object).setTrailerStatus((Boolean)objectArray[0]);
                return null;
            }
            case 133: {
                ((DSINavigation)object).requestCountryInfo((String)objectArray[0]);
                return null;
            }
            case 134: {
                ((DSINavigation)object).jumpToNextManeuver();
                return null;
            }
            case 135: {
                ((DSINavigation)object).liGetViaPointCountryList();
                return null;
            }
            case 136: {
                ((DSINavigation)object).liSetViaPointCountry((String)objectArray[0]);
                return null;
            }
            case 137: {
                ((DSINavigation)object).liGetViaPointList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 138: {
                ((DSINavigation)object).liSelectViaPoint(((Number)objectArray[0]).intValue());
                return null;
            }
            case 139: {
                ((DSINavigation)object).rgStartGuidanceCalculatedRouteByUID((NavSegmentID)objectArray[0]);
                return null;
            }
            case 140: {
                ((DSINavigation)object).liGetSpellableCharacters((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 141: {
                ((DSINavigation)object).liStopSpeller();
                return null;
            }
            case 142: {
                ((DSINavigation)object).liValueListMaximumLength(((Number)objectArray[0]).intValue());
                return null;
            }
            case 143: {
                ((DSINavigation)object).setPathsToPersonalPOIDataBases((String[])objectArray[0]);
                return null;
            }
            case 144: {
                ((DSINavigation)object).deletePersonalPOIDataBases((String[])objectArray[0]);
                return null;
            }
            case 145: {
                ((DSINavigation)object).rgStopRouteCalculation();
                return null;
            }
            case 146: {
                ((DSINavigation)object).rgSwitchToNextPossibleRoad();
                return null;
            }
            case 147: {
                ((DSINavigation)object).setVehicleFuelType(((Number)objectArray[0]).intValue());
                return null;
            }
            case 148: {
                ((DSINavigation)object).createNavLocationOfPOIUID(((Number)objectArray[0]).longValue());
                return null;
            }
            case 149: {
                ((DSINavigation)object).lispSelectListItemByIdent((String)objectArray[0]);
                return null;
            }
            case 150: {
                ((DSINavigation)object).rmRouteReplace(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (Route)objectArray[2]);
                return null;
            }
            case 151: {
                ((DSINavigation)object).setNavInternalDataToFactorySettings();
                return null;
            }
            case 152: {
                ((DSINavigation)object).liTryMatchLocation((TryMatchLocationData)objectArray[0]);
                return null;
            }
            case 153: {
                ((DSINavigation)object).trImportTrails((String)objectArray[0]);
                return null;
            }
            case 154: {
                ((DSINavigation)object).trExportTrails((NavSegmentID[])objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 155: {
                ((DSINavigation)object).rgSkipNextWayPoints(((Number)objectArray[0]).intValue());
                return null;
            }
            case 156: {
                ((DSINavigation)object).rgReverseTrailDirection();
                return null;
            }
            case 157: {
                ((DSINavigation)object).rgPrepareRubberbandManipulation((Boolean)objectArray[0]);
                return null;
            }
            case 158: {
                ((DSINavigation)object).rgStartRubberbandManipulation(((Number)objectArray[0]).intValue());
                return null;
            }
            case 159: {
                ((DSINavigation)object).rgSetRubberbandPosition((NavLocationWgs84)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((DSINavigation)object).rgGetRouteBoundingRectangle((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 161: {
                ((DSINavigation)object).rgGetLocationOnRoute(((Number)objectArray[0]).longValue());
                return null;
            }
            case 162: {
                ((DSINavigation)object).rgStopRubberbandManipulation();
                return null;
            }
            case 163: {
                ((DSINavigation)object).rgDeleteCalculatedRubberbandPoint();
                return null;
            }
            case 164: {
                ((DSINavigation)object).rgGetRubberBandPointPosition();
                return null;
            }
            case 165: {
                ((DSINavigation)object).rgEnableEnhancedSignPostInfo((Boolean)objectArray[0]);
                return null;
            }
            case 166: {
                ((DSINavigation)object).lispGetLocationFromLiValueListElement(((Number)objectArray[0]).intValue());
                return null;
            }
            case 167: {
                ((DSINavigation)object).rgSetTurnListMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 168: {
                ((DSINavigation)object).liHistoryAddLocation((NavLocation)objectArray[0]);
                return null;
            }
            case 169: {
                ((DSINavigation)object).liLastCityHistorySetStreet((NavLocation)objectArray[0]);
                return null;
            }
            case 170: {
                ((DSINavigation)object).liLastStreetHistorySetCity((NavLocation)objectArray[0]);
                return null;
            }
            case 171: {
                ((DSINavigation)object).enableRgMotorwayInfo((Boolean)objectArray[0]);
                return null;
            }
            case 172: {
                ((DSINavigation)object).rgTriggerRCCIUpdate();
                return null;
            }
            case 173: {
                ((DSINavigation)object).poiGetXt9LDBs((NavLocation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 174: {
                ((DSINavigation)object).poiSetListStyle(((Number)objectArray[0]).intValue());
                return null;
            }
            case 175: {
                ((DSINavigation)object).etcGetPositionTimeInfo((NavLocationWgs84)objectArray[0]);
                return null;
            }
            case 176: {
                ((DSINavigation)object).poiGetCategoryTypesFromUId(((Number)objectArray[0]).intValue());
                return null;
            }
            case 177: {
                ((DSINavigation)object).rgDeletePersistedRouteData();
                return null;
            }
            case 178: {
                ((DSINavigation)object).rgCalculate1stRouteAndPostponeRemaining((Route)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 179: {
                ((DSINavigation)object).liDisambiguateLocation((NavLocation)objectArray[0]);
                return null;
            }
            case 180: {
                ((DSINavigation)object).triggerEventAudioMessage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 181: {
                ((DSINavigation)object).lispAddStroke((String)objectArray[0]);
                return null;
            }
            case 182: {
                ((DSINavigation)object).lispRequestNVCList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 183: {
                ((DSINavigation)object).poiConfigureContext((String)objectArray[0], ((Number)objectArray[1]).intValue(), (NavLocation)objectArray[2], (int[])objectArray[3]);
                return null;
            }
            case 184: {
                ((DSINavigation)object).etcTriggerNavigationRestart(((Number)objectArray[0]).intValue());
                return null;
            }
            case 185: {
                ((DSINavigation)object).rmImportToursFromGpxFile(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 186: {
                ((DSINavigation)object).rmAbortImportToursFromGpxFile();
                return null;
            }
            case 187: {
                ((DSINavigation)object).importRouteFromGpxFile((String)objectArray[0]);
                return null;
            }
            case 188: {
                ((DSINavigation)object).poiRequestExtendedInfo((NavLocation)objectArray[0]);
                return null;
            }
            case 189: {
                ((DSINavigation)object).rgConfigurePoiInfo((NavPoiInfoConfiguration)objectArray[0]);
                return null;
            }
            case 190: {
                ((DSINavigation)object).trClearRecordedTraceCache();
                return null;
            }
            case 191: {
                ((DSINavigation)object).setVirtualRouteGuidance((Boolean)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f6(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 192: {
                ((DSINavigation)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 193: {
                ((DSINavigation)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 194: {
                ((DSINavigation)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 195: {
                ((DSINavigation)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 196: {
                ((DSINavigation)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 197: {
                ((DSINavigation)object).clearNotification((DSIListener)objectArray[0]);
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

