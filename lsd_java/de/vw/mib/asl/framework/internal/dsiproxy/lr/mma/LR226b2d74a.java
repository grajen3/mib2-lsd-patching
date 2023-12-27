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
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrl;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.PoiListElement;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public final class LR226b2d74a
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2086995057: {
                if (bl) {
                    if (n2 != 295822757) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -2065259885: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -2042810658: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -2002013072: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -1920302518: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -1904208139: {
                if (bl) {
                    if (n2 != 1020542967) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1830792258: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -1782980263: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -1780560107: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -1741431948: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1724451792: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1586206242: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -1565720460: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1490925282: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1431628129: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1421940745: {
                if (bl) {
                    if (n2 != 1371138611) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1389790448: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1368844644: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1293787004: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -1284630315: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1254737777: {
                if (bl) {
                    if (n2 != 228217929) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1240149662: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1234402544: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 103;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 104;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 105;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1155173655: {
                if (bl) {
                    if (n2 != 228217929) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1141481763: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -1120720988: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1113589710: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1109785482: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1068228460: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1050072955: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 106;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 107;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 108;
                    break;
                }
                n3 = 106;
                break;
            }
            case -935907222: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -882432560: {
                if (bl) {
                    if (n2 != 228217929) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -830299513: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -814350237: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -797370196: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -777382429: {
                if (bl) {
                    if (n2 != 228217929) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -654579608: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -633287368: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -540074190: {
                if (bl) {
                    if (n2 != -1405998801) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -483058615: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -404602708: {
                if (bl) {
                    if (n2 != -1005039887) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -362477613: {
                if (bl) {
                    if (n2 != -1941743767) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -323438614: {
                if (bl) {
                    if (n2 != 1359336183) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -314535947: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -157508508: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case -142115402: {
                if (bl) {
                    if (n2 != 1689297601) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -121643018: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 45894061: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 55025866: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 70234051: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 95291271: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 113831717: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 126193684: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 405247216: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 416438397: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 429704594: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 429990945: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 430175543: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 443462275: {
                if (bl) {
                    if (n2 != -790938727) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 461448014: {
                if (bl) {
                    if (n2 != -1009636604) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 463492508: {
                if (bl) {
                    if (n2 != 1159578057) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 469759938: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 499413487: {
                if (bl) {
                    if (n2 != -211582805) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 578529521: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 605755008: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 654748582: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 659551029: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 662211717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 687637702: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 694712238: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 729154975: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 787027408: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 885401848: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 893114350: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 896543876: {
                if (bl) {
                    if (n2 != 1371138611) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 917875552: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 940955657: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 1119888615: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1149752388: {
                if (bl) {
                    if (n2 != -382972672) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 1234017069: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case 1257705717: {
                if (bl) {
                    if (n2 != 17850877) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 1304732844: {
                if (bl) {
                    if (n2 != -803680282) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1305146821: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1329748570: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1359871873: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 1478972455: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 1503681780: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 1673058828: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 1684937274: {
                if (bl) {
                    if (n2 != 228217929) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1724837970: {
                if (bl) {
                    if (n2 != -1868542303) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 1741918477: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 1773176710: {
                if (bl) {
                    if (n2 != 1371138611) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1814031083: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 1831037925: {
                if (bl) {
                    if (n2 != 1371138611) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 1870767908: {
                if (bl) {
                    if (n2 != -1771371888) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1912505853: {
                if (bl) {
                    if (n2 != 1359336183) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1933592746: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1942831960: {
                if (bl) {
                    if (n2 != 17850877) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1949020277: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1956556412: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 1984785306: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 2038347755: {
                if (bl) {
                    if (n2 != 17850877) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 2058425361: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1774792458: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 115;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 116;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 117;
                    break;
                }
                n3 = 115;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 118;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 119;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 120;
                    break;
                }
                n3 = 118;
                break;
            }
            case -72560991: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case 336622329: {
                if (bl) {
                    if (n2 != -1166448617) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 504961945: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 604786755: {
                if (bl) {
                    if (n2 != 726513724) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
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
            case -159319226: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1763056325: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMapViewerControl)object).setMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIMapViewerControl)object).setBrandIconStyle((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIMapViewerControl)object).configureFlags(((Number)objectArray[0]).intValue(), (MapFlag[])objectArray[1]);
                return null;
            }
            case 3: {
                ((DSIMapViewerControl)object).dragMap((short)((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIMapViewerControl)object).ensureTMCVisibility(((Number)objectArray[0]).longValue());
                return null;
            }
            case 5: {
                ((DSIMapViewerControl)object).getInfoForPosition();
                return null;
            }
            case 6: {
                ((DSIMapViewerControl)object).getInfoForScreenPosition((Point)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIMapViewerControl)object).getNumberOfPOIs();
                return null;
            }
            case 8: {
                ((DSIMapViewerControl)object).goToTMCMessage(((Number)objectArray[0]).longValue());
                return null;
            }
            case 9: {
                ((DSIMapViewerControl)object).packPOIContainer();
                return null;
            }
            case 10: {
                ((DSIMapViewerControl)object).rbSelectAlternativeRoute(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIMapViewerControl)object).rbSelectNextSegment();
                return null;
            }
            case 12: {
                ((DSIMapViewerControl)object).rbSelectPreviousSegment();
                return null;
            }
            case 13: {
                ((DSIMapViewerControl)object).rbSetPosition(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIMapViewerControl)object).scrollToDirection((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSIMapViewerControl)object).selectNextPOI();
                return null;
            }
            case 16: {
                ((DSIMapViewerControl)object).selectPrevPOI();
                return null;
            }
            case 17: {
                ((DSIMapViewerControl)object).set3DLandmarksVisible((Boolean)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIMapViewerControl)object).setCarPosition((Point)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSIMapViewerControl)object).setDayView();
                return null;
            }
            case 20: {
                ((DSIMapViewerControl)object).setEnableRouteCalcMode((Boolean)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIMapViewerControl)object).setEnableSoftJump((Boolean)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSIMapViewerControl)object).setEnableSoftRotation((Boolean)objectArray[0]);
                return null;
            }
            case 23: {
                ((DSIMapViewerControl)object).setEnableSoftTilt((Boolean)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSIMapViewerControl)object).setEnableSoftZoom((Boolean)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSIMapViewerControl)object).setHotPoint((Point)objectArray[0]);
                return null;
            }
            case 26: {
                ((DSIMapViewerControl)object).setLocation(((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSIMapViewerControl)object).setLocationByLocation((NavLocation)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIMapViewerControl)object).setLocationByLocationAndView((NavLocation)objectArray[0], (short)((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 29: {
                ((DSIMapViewerControl)object).setMapPosition((NavLocationWgs84)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSIMapViewerControl)object).setMapViewPort((NavLocationWgs84)objectArray[0], (short)((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 31: {
                ((DSIMapViewerControl)object).setMapViewPortByLD((NavLocation)objectArray[0], (NavLocation)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIMapViewerControl)object).setNightView();
                return null;
            }
            case 33: {
                ((DSIMapViewerControl)object).setOrientation(((Number)objectArray[0]).intValue(), (Point)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSIMapViewerControl)object).setRotation((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSIMapViewerControl)object).setViewType(((Number)objectArray[0]).intValue());
                return null;
            }
            case 36: {
                ((DSIMapViewerControl)object).setZoomArea((Rect)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSIMapViewerControl)object).setZoomLevel(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSIMapViewerControl)object).setCountryOverviewCountry((String)objectArray[0]);
                return null;
            }
            case 39: {
                ((DSIMapViewerControl)object).showTMCMessages((Boolean)objectArray[0]);
                return null;
            }
            case 40: {
                ((DSIMapViewerControl)object).startScrollToDirection(((Number)objectArray[0]).intValue());
                return null;
            }
            case 41: {
                ((DSIMapViewerControl)object).stopScrollToDirection();
                return null;
            }
            case 42: {
                ((DSIMapViewerControl)object).unpackPOIContainer(((Number)objectArray[0]).longValue());
                return null;
            }
            case 43: {
                ((DSIMapViewerControl)object).viewFreeze((Boolean)objectArray[0]);
                return null;
            }
            case 44: {
                ((DSIMapViewerControl)object).viewSetScreenViewport((Rect)objectArray[0]);
                return null;
            }
            case 45: {
                ((DSIMapViewerControl)object).viewSetScreenViewportMaximum((Rect)objectArray[0]);
                return null;
            }
            case 46: {
                ((DSIMapViewerControl)object).viewSetVisible((Boolean)objectArray[0]);
                return null;
            }
            case 47: {
                ((DSIMapViewerControl)object).setMetricSystem(((Number)objectArray[0]).intValue());
                return null;
            }
            case 48: {
                ((DSIMapViewerControl)object).setViewFocusOnBlock((long[])objectArray[0]);
                return null;
            }
            case 49: {
                ((DSIMapViewerControl)object).setViewFocusOnPoi((PoiListElement[])objectArray[0]);
                return null;
            }
            case 50: {
                ((DSIMapViewerControl)object).startToDrawNewRectangleInMap();
                return null;
            }
            case 51: {
                ((DSIMapViewerControl)object).editRectangleInMap(((Number)objectArray[0]).longValue());
                return null;
            }
            case 52: {
                ((DSIMapViewerControl)object).setSouthWestCornerOfRectangleInMap((Point)objectArray[0]);
                return null;
            }
            case 53: {
                ((DSIMapViewerControl)object).setNorthEastCornerOfRectangleInMap((Point)objectArray[0]);
                return null;
            }
            case 54: {
                ((DSIMapViewerControl)object).finishDrawRectangleInMap();
                return null;
            }
            case 55: {
                ((DSIMapViewerControl)object).setCityModelMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 56: {
                ((DSIMapViewerControl)object).displayRemainingRangeOfVehicle((Boolean)objectArray[0]);
                return null;
            }
            case 57: {
                ((DSIMapViewerControl)object).touchApproach((Boolean)objectArray[0]);
                return null;
            }
            case 58: {
                ((DSIMapViewerControl)object).startScrollByVector(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSIMapViewerControl)object).setGuidanceSymbol(((Number)objectArray[0]).intValue());
                return null;
            }
            case 60: {
                ((DSIMapViewerControl)object).setHOVLaneVisibility((Boolean)objectArray[0]);
                return null;
            }
            case 61: {
                ((DSIMapViewerControl)object).rbGetIDOfSelectedSegment();
                return null;
            }
            case 62: {
                ((DSIMapViewerControl)object).rbGetRRDToSelectedSegment(((Number)objectArray[0]).longValue());
                return null;
            }
            case 63: {
                ((DSIMapViewerControl)object).setTollRoadHighLighting((Boolean)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSIMapViewerControl)object).setMountainPeakMarker((Boolean)objectArray[0]);
                return null;
            }
            case 65: {
                ((DSIMapViewerControl)object).setViewFocusOnCombinedRouteListElements((long[])objectArray[0]);
                return null;
            }
            case 66: {
                ((DSIMapViewerControl)object).setFrameRateMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 67: {
                ((DSIMapViewerControl)object).setScrollByCrossHairs((Boolean)objectArray[0]);
                return null;
            }
            case 68: {
                ((DSIMapViewerControl)object).setScrollByCrossHairsBoundingBox((Rect)objectArray[0]);
                return null;
            }
            case 69: {
                ((DSIMapViewerControl)object).setRouteColoringPolicy(((Number)objectArray[0]).intValue());
                return null;
            }
            case 70: {
                ((DSIMapViewerControl)object).setWeatherVisualization((Boolean)objectArray[0]);
                return null;
            }
            case 71: {
                ((DSIMapViewerControl)object).setPictureNavigationIconVisibility((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((DSIMapViewerControl)object).setMobilityHorizonVisibility((Boolean)objectArray[0]);
                return null;
            }
            case 73: {
                ((DSIMapViewerControl)object).setTrafficMapStyle((Boolean)objectArray[0]);
                return null;
            }
            case 74: {
                ((DSIMapViewerControl)object).showSpeedAndFlowFreeFlow((Boolean)objectArray[0]);
                return null;
            }
            case 75: {
                ((DSIMapViewerControl)object).showSpeedAndFlowCongestions((Boolean)objectArray[0]);
                return null;
            }
            case 76: {
                ((DSIMapViewerControl)object).showRichContent((Boolean)objectArray[0]);
                return null;
            }
            case 77: {
                ((DSIMapViewerControl)object).setGeneralPoiVisibility((Boolean)objectArray[0]);
                return null;
            }
            case 78: {
                ((DSIMapViewerControl)object).setCrossHairsColor(((Number)objectArray[0]).intValue());
                return null;
            }
            case 79: {
                ((DSIMapViewerControl)object).setViewPortBorder(((Number)objectArray[0]).intValue());
                return null;
            }
            case 80: {
                ((DSIMapViewerControl)object).setTerrainElevation((Boolean)objectArray[0]);
                return null;
            }
            case 81: {
                ((DSIMapViewerControl)object).ensurePoiVisibility((NavLocation[])objectArray[0]);
                return null;
            }
            case 82: {
                ((DSIMapViewerControl)object).suspendMapViewer();
                return null;
            }
            case 83: {
                ((DSIMapViewerControl)object).wakeupMapViewer();
                return null;
            }
            case 84: {
                ((DSIMapViewerControl)object).setMobilityHorizonZoomMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 85: {
                ((DSIMapViewerControl)object).isDetailedMapMaterialAvailable((NavLocationWgs84)objectArray[0]);
                return null;
            }
            case 86: {
                ((DSIMapViewerControl)object).setHorizonMarkerVisibility((Boolean)objectArray[0]);
                return null;
            }
            case 87: {
                ((DSIMapViewerControl)object).ensureTrafficEventIconsVisibility((long[])objectArray[0]);
                return null;
            }
            case 88: {
                ((DSIMapViewerControl)object).setMapViewPortByWGS84Rectangle((NavRectangle)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((DSIMapViewerControl)object).startRouteDragging((NavLocationWgs84)objectArray[0]);
                return null;
            }
            case 90: {
                ((DSIMapViewerControl)object).dragRoute((short)((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue());
                return null;
            }
            case 91: {
                ((DSIMapViewerControl)object).setDragRouteMarker(((Number)objectArray[0]).intValue());
                return null;
            }
            case 92: {
                ((DSIMapViewerControl)object).highlightRouteBasedOnLength(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 93: {
                ((DSIMapViewerControl)object).ehSetCategoryVisibility(((Number)objectArray[0]).intValue(), (int[])objectArray[1], (boolean[])objectArray[2]);
                return null;
            }
            case 94: {
                ((DSIMapViewerControl)object).ehSetCategoryVisibilityToDefault(((Number)objectArray[0]).intValue());
                return null;
            }
            case 95: {
                ((DSIMapViewerControl)object).setMapOverlays(((Number)objectArray[0]).intValue(), (MapOverlay[])objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSIMapViewerControl)object).setMapLayerVisible((int[])objectArray[0]);
                return null;
            }
            case 97: {
                ((DSIMapViewerControl)object).setTemperatureScale(((Number)objectArray[0]).intValue());
                return null;
            }
            case 98: {
                ((DSIMapViewerControl)object).setSoftAnimationSpeed(((Number)objectArray[0]).intValue());
                return null;
            }
            case 99: {
                ((DSIMapViewerControl)object).setSpeedAndFlowRoadClass(((Number)objectArray[0]).intValue());
                return null;
            }
            case 100: {
                ((DSIMapViewerControl)object).setRouteVisibility((Boolean)objectArray[0]);
                return null;
            }
            case 101: {
                ((DSIMapViewerControl)object).setVisibleRoutes((NavSegmentID[])objectArray[0]);
                return null;
            }
            case 102: {
                ((DSIMapViewerControl)object).showTrafficEventListView((long[])objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 103: {
                ((DSIMapViewerControl)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 104: {
                ((DSIMapViewerControl)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 105: {
                ((DSIMapViewerControl)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 106: {
                ((DSIMapViewerControl)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 107: {
                ((DSIMapViewerControl)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 108: {
                ((DSIMapViewerControl)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 109: {
                ((DSIMapViewerGoogleCtrl)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 110: {
                ((DSIMapViewerGoogleCtrl)object).requestClearCache();
                return null;
            }
            case 111: {
                ((DSIMapViewerGoogleCtrl)object).setLayerVisibility((int[])objectArray[0]);
                return null;
            }
            case 112: {
                ((DSIMapViewerGoogleCtrl)object).setConnectionInformation(((Number)objectArray[0]).intValue());
                return null;
            }
            case 113: {
                ((DSIMapViewerGoogleCtrl)object).loadKml((String[])objectArray[0]);
                return null;
            }
            case 114: {
                ((DSIMapViewerGoogleCtrl)object).setCopyrightPosition((Rect)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 115: {
                ((DSIMapViewerGoogleCtrl)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 116: {
                ((DSIMapViewerGoogleCtrl)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 117: {
                ((DSIMapViewerGoogleCtrl)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 118: {
                ((DSIMapViewerGoogleCtrl)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 119: {
                ((DSIMapViewerGoogleCtrl)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 120: {
                ((DSIMapViewerGoogleCtrl)object).clearNotification((DSIListener)objectArray[0]);
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

