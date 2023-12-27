/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistance;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.global.CarBCSpeed;

public final class LR23c8a19ad
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2125374354: {
                if (bl) {
                    if (n2 != -1605271559) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -2113382575: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -2049510532: {
                if (bl) {
                    if (n2 != -1358970210) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -2048305302: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -1955608305: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1908932803: {
                if (bl) {
                    if (n2 != 2103651840) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -1901336955: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -1881635018: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -1761828974: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1666721284: {
                if (bl) {
                    if (n2 != 170942325) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1649060568: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -1524586305: {
                if (bl) {
                    if (n2 != -850984441) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1350044566: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1308412754: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1292244569: {
                if (bl) {
                    if (n2 != -1142651250) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -1292244568: {
                if (bl) {
                    if (n2 != 921273998) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -1292244567: {
                if (bl) {
                    if (n2 != -1309833586) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1292244566: {
                if (bl) {
                    if (n2 != 754091662) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1292244565: {
                if (bl) {
                    if (n2 != -1477015922) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -1292244564: {
                if (bl) {
                    if (n2 != 586909326) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -1292244547: {
                if (bl) {
                    if (n2 != 65940093) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1186655094: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 88;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 89;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 90;
                    break;
                }
                n3 = 88;
                break;
            }
            case -1152029209: {
                if (bl) {
                    if (n2 != 1964211751) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1080679274: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1041896105: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -953862594: {
                if (bl) {
                    if (n2 != -1351144006) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 91;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 92;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 93;
                    break;
                }
                n3 = 91;
                break;
            }
            case -871870833: {
                if (bl) {
                    if (n2 != -1057754382) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -869227968: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -835688232: {
                if (bl) {
                    if (n2 != 237381767) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -824383980: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -814130355: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -757461146: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -705976697: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -692317662: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -692227263: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -506361480: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -489034571: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case -405926441: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -383696886: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -329876618: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -298852513: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -297472968: {
                if (bl) {
                    if (n2 != -956351906) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -247926100: {
                if (bl) {
                    if (n2 != -1166067322) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -226739077: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -223516132: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -92153449: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -77898287: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 81826765: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 85104679: {
                if (bl) {
                    if (n2 != 562629727) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 107340978: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 135169389: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 449495947: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 553915308: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 602881251: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 733668401: {
                if (bl) {
                    if (n2 != 1240672381) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 871227141: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 987226442: {
                if (bl) {
                    if (n2 != 562629727) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 989999206: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 992358525: {
                if (bl) {
                    if (n2 != -1351144006) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 1069070445: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1105713455: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1129088359: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1171116838: {
                if (bl) {
                    if (n2 != -415378654) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1179020527: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1265853636: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1278739083: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1471452884: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1472426663: {
                if (bl) {
                    if (n2 != 1040330213) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1472426684: {
                if (bl) {
                    if (n2 != -937416057) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 1502009513: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 1520186949: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1575242893: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 1599400962: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1613817920: {
                if (bl) {
                    if (n2 != -226402707) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1636188431: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 1670239713: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1732016900: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 1748139648: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 1768575116: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 1771744584: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1860342097: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 1889356396: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 1934183217: {
                if (bl) {
                    if (n2 != -415378654) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1970962976: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1989643558: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 2017420070: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 2047156142: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 2142709699: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2084310694: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case -2052021877: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case -2015841264: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case -1835041281: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case -1789198226: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -1777745930: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -1735433843: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case -1700653379: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -1688340237: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -1683389877: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case -1683248595: {
                if (bl) {
                    if (n2 != 1337086519) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case -1532449597: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case -1304608533: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case -1249404027: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case -1180344212: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 161;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 162;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 163;
                    break;
                }
                n3 = 161;
                break;
            }
            case -1112823251: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case -1091043969: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -989829823: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case -977264709: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 164;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 165;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 166;
                    break;
                }
                n3 = 164;
                break;
            }
            case -948459832: {
                if (bl) {
                    if (n2 != -2079242941) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case -909261411: {
                if (bl) {
                    if (n2 != -1144977501) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -732206740: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case -723086018: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -622786347: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case -599376751: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case -527675538: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -388159744: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case -372328079: {
                if (bl) {
                    if (n2 != -1816038011) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case -217424315: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case -200023835: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case 28593382: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case 62038010: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case 0x4BBBBBA: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 215682062: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case 261554541: {
                if (bl) {
                    if (n2 != -1895219541) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case 295098896: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case 370190768: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case 407454044: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case 499737813: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case 531429206: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case 600548974: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case 786714617: {
                if (bl) {
                    if (n2 != 745743666) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case 817878833: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case 823052674: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 967974831: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 1000193645: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case 1057629313: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case 1073356041: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case 1099291831: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case 1165820522: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case 1190902591: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case 1247996100: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case 1328750033: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case 1378781120: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 1439594356: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 1567241280: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 1588980201: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case 1735087480: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case 1844264527: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 1862277803: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case 1868563286: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case 1932145239: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case 1932340974: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case 1945722555: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case 1975340691: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case 1989143875: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 2113318881: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
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
            case -1650974737: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1972207255: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarComfort)object).setRGSBeltPretensionerDataFront((RGSBeltPretensionData)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSICarComfort)object).setRGSBeltPretensionerDataRear((RGSBeltPretensionData)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSICarComfort)object).setRGSPreCrashSystem((Boolean)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSICarComfort)object).setRgsSetFactoryDefault();
                return null;
            }
            case 4: {
                ((DSICarComfort)object).setRGSPreSenseSystem((Boolean)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSICarComfort)object).setRGSPreSenseWarning(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSICarComfort)object).setRGSLocalHazardInformation((RGSLocalHazardInformation)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSICarComfort)object).setDoorLockingComfortOpenSettings((DoorLockingComfortOpenSettings)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSICarComfort)object).setDoorLockingTheftWarningSettings((DoorLockingTheftWarningSettings)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSICarComfort)object).setDoorLockingClBootOpen((Boolean)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSICarComfort)object).setDoorLockingBootOpen((Boolean)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSICarComfort)object).setDoorLockingBootClose((Boolean)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSICarComfort)object).startDoorLockingRemoteLockUnlock((String)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSICarComfort)object).abortDoorLockingRemoteLockUnlock();
                return null;
            }
            case 14: {
                ((DSICarComfort)object).sendDoorLockingRemoteLockUnlockSignature((String)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSICarComfort)object).startDoorLockingRemoteBlinking(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSICarComfort)object).startDoorLockingRemoteHorn(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSICarComfort)object).setDoorLockingUnlockingMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSICarComfort)object).setDoorLockingAutoLock(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSICarComfort)object).setDoorLockingAutoUnlock((Boolean)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSICarComfort)object).setDoorLockingClBootLock((Boolean)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSICarComfort)object).setDoorLockingMirrorProtection((Boolean)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSICarComfort)object).setDoorLockingConfirmation((Boolean)objectArray[0]);
                return null;
            }
            case 23: {
                ((DSICarComfort)object).setDoorLockingRainClosing((Boolean)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSICarComfort)object).setDoorLockingRearBlind((DoorLockingRearBlind)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSICarComfort)object).setDoorLockingSetFactoryDefault();
                return null;
            }
            case 26: {
                ((DSICarComfort)object).requestDoorLockingUserList((DoorLockingUserListUpdateInfo)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSICarComfort)object).setDoorLockingUserListRA1((DoorLockingUserListUpdateInfo)objectArray[0], (DoorLockingUserListRA1[])objectArray[1]);
                return null;
            }
            case 28: {
                ((DSICarComfort)object).setDoorLockingUserListRAF((DoorLockingUserListUpdateInfo)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 29: {
                ((DSICarComfort)object).setDoorLockingActiveUser(((Number)objectArray[0]).intValue());
                return null;
            }
            case 30: {
                ((DSICarComfort)object).setDoorLockingUserProfileOnOff((DoorLockingUserProfileOnOff)objectArray[0]);
                return null;
            }
            case 31: {
                ((DSICarComfort)object).startDoorLockingUserProfileControl(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarComfort)object).abortDoorLockingUserProfileControl();
                return null;
            }
            case 33: {
                ((DSICarComfort)object).setDoorLockingWindowAutoClose((Boolean)objectArray[0]);
                return null;
            }
            case 34: {
                ((DSICarComfort)object).setDoorlockingBlindsControl(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSICarComfort)object).setDoorlockingBlindsControlExtended(((Number)objectArray[0]).intValue());
                return null;
            }
            case 36: {
                ((DSICarComfort)object).setDoorLockingLeftSideBlindControl(((Number)objectArray[0]).intValue());
                return null;
            }
            case 37: {
                ((DSICarComfort)object).setDoorLockingRightSideBlindControl(((Number)objectArray[0]).intValue());
                return null;
            }
            case 38: {
                ((DSICarComfort)object).setDoorLockingTurnIndRepeat((Boolean)objectArray[0]);
                return null;
            }
            case 39: {
                ((DSICarComfort)object).setDoorLockingKeyless((Boolean)objectArray[0]);
                return null;
            }
            case 40: {
                ((DSICarComfort)object).setWiperServicePosition((Boolean)objectArray[0]);
                return null;
            }
            case 41: {
                ((DSICarComfort)object).setWiperRainSensorOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 42: {
                ((DSICarComfort)object).setWiperRainSensorConfig(((Number)objectArray[0]).intValue());
                return null;
            }
            case 43: {
                ((DSICarComfort)object).setWiperRearWiping((Boolean)objectArray[0]);
                return null;
            }
            case 44: {
                ((DSICarComfort)object).setWiperTearsWiping((Boolean)objectArray[0]);
                return null;
            }
            case 45: {
                ((DSICarComfort)object).setWiperWinterPosition((Boolean)objectArray[0]);
                return null;
            }
            case 46: {
                ((DSICarComfort)object).setEasyEntrySteeringColumn((Boolean)objectArray[0]);
                return null;
            }
            case 47: {
                ((DSICarComfort)object).setWiperSetFactoryDefault();
                return null;
            }
            case 48: {
                ((DSICarComfort)object).setUGDOLearningData((UGDOLearningData)objectArray[0]);
                return null;
            }
            case 49: {
                ((DSICarComfort)object).showUGDOPopup((UGDOContent)objectArray[0]);
                return null;
            }
            case 50: {
                ((DSICarComfort)object).cancelUGDOPopup((UGDOContent)objectArray[0]);
                return null;
            }
            case 51: {
                ((DSICarComfort)object).deleteUGDOButton((UGDOSoftkeys)objectArray[0]);
                return null;
            }
            case 52: {
                ((DSICarComfort)object).setUGDOSetFactoryDefault();
                return null;
            }
            case 53: {
                ((DSICarComfort)object).setUGDODestinationReached((UGDODestinationReached)objectArray[0]);
                return null;
            }
            case 54: {
                ((DSICarComfort)object).setUGDOOpenDoor((UGDOOpenDoor)objectArray[0]);
                return null;
            }
            case 55: {
                ((DSICarComfort)object).setUGDOSynchronisation((UGDOSynchronisation)objectArray[0]);
                return null;
            }
            case 56: {
                ((DSICarComfort)object).responseUGDOSynchronisation((UGDOSynchronisation)objectArray[0]);
                return null;
            }
            case 57: {
                ((DSICarComfort)object).startUGDOLearning(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSICarComfort)object).abortUGDOLearning();
                return null;
            }
            case 59: {
                ((DSICarComfort)object).requestUGDOButtonList((UGDOButtonListUpdateInfo)objectArray[0]);
                return null;
            }
            case 60: {
                ((DSICarComfort)object).setUGDOButtonListRA0((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA0[])objectArray[1]);
                return null;
            }
            case 61: {
                ((DSICarComfort)object).setUGDOButtonListRA1((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA1[])objectArray[1]);
                return null;
            }
            case 62: {
                ((DSICarComfort)object).setUGDOButtonListRA2((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA2[])objectArray[1]);
                return null;
            }
            case 63: {
                ((DSICarComfort)object).setUGDOButtonListRA3((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA3[])objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarComfort)object).setUGDOButtonListRA4((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA4[])objectArray[1]);
                return null;
            }
            case 65: {
                ((DSICarComfort)object).setUGDOButtonListRA5((UGDOButtonListUpdateInfo)objectArray[0], (UGDOButtonListRA5[])objectArray[1]);
                return null;
            }
            case 66: {
                ((DSICarComfort)object).setUGDOButtonListRAF((UGDOButtonListUpdateInfo)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 67: {
                ((DSICarComfort)object).setRDKSystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 68: {
                ((DSICarComfort)object).setRDKTireSetupSelectedTire(((Number)objectArray[0]).intValue());
                return null;
            }
            case 69: {
                ((DSICarComfort)object).setRDKSpeedLimit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 70: {
                ((DSICarComfort)object).setRDKTireChanged();
                return null;
            }
            case 71: {
                ((DSICarComfort)object).setRDKPressureChanged();
                return null;
            }
            case 72: {
                ((DSICarComfort)object).requestRDKLifeMonitoring();
                return null;
            }
            case 73: {
                ((DSICarComfort)object).setRDKPressureLevel((byte)((Number)objectArray[0]).intValue());
                return null;
            }
            case 74: {
                ((DSICarComfort)object).setRDKSetFactoryDefault();
                return null;
            }
            case 75: {
                ((DSICarComfort)object).setMirrorLowering((Boolean)objectArray[0]);
                return null;
            }
            case 76: {
                ((DSICarComfort)object).setMirrorSyncAdjust((Boolean)objectArray[0]);
                return null;
            }
            case 77: {
                ((DSICarComfort)object).setMirrorFolding((Boolean)objectArray[0]);
                return null;
            }
            case 78: {
                ((DSICarComfort)object).setMirrorDimming((Boolean)objectArray[0]);
                return null;
            }
            case 79: {
                ((DSICarComfort)object).setMirrorHeating((Boolean)objectArray[0]);
                return null;
            }
            case 80: {
                ((DSICarComfort)object).setMirrorSetFactoryDefault();
                return null;
            }
            case 81: {
                ((DSICarComfort)object).setBrakeElectricalParking((Boolean)objectArray[0]);
                return null;
            }
            case 82: {
                ((DSICarComfort)object).setBrakeAutoHold(((Number)objectArray[0]).intValue());
                return null;
            }
            case 83: {
                ((DSICarComfort)object).setBrakeEscMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 84: {
                ((DSICarComfort)object).setBrakeHdcMode((Boolean)objectArray[0]);
                return null;
            }
            case 85: {
                ((DSICarComfort)object).setHMIIsReady((Boolean)objectArray[0]);
                return null;
            }
            case 86: {
                ((DSICarComfort)object).showDoorLockingPrompt(((Number)objectArray[0]).intValue());
                return null;
            }
            case 87: {
                ((DSICarComfort)object).cancelDoorLockingPrompt(((Number)objectArray[0]).intValue());
                return null;
            }
            case 88: {
                ((DSICarComfort)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 89: {
                ((DSICarComfort)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 90: {
                ((DSICarComfort)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 91: {
                ((DSICarComfort)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 92: {
                ((DSICarComfort)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 93: {
                ((DSICarComfort)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 94: {
                ((DSICarDriverAssistance)object).setACCGongState((Boolean)objectArray[0]);
                return null;
            }
            case 95: {
                ((DSICarDriverAssistance)object).setACCGongVolume(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSICarDriverAssistance)object).setACCDrivingProgram(((Number)objectArray[0]).intValue());
                return null;
            }
            case 97: {
                ((DSICarDriverAssistance)object).setACCTimeGap(((Number)objectArray[0]).intValue());
                return null;
            }
            case 98: {
                ((DSICarDriverAssistance)object).setACCDefaultMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 99: {
                ((DSICarDriverAssistance)object).setACCCurveAssist((Boolean)objectArray[0]);
                return null;
            }
            case 100: {
                ((DSICarDriverAssistance)object).setACCSpeedLimitAdoption((Boolean)objectArray[0]);
                return null;
            }
            case 101: {
                ((DSICarDriverAssistance)object).setACCTrafficJamAssist((Boolean)objectArray[0]);
                return null;
            }
            case 102: {
                ((DSICarDriverAssistance)object).setACCSpeedLimitOffset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 103: {
                ((DSICarDriverAssistance)object).setACCDistanceWarning((ACCDistanceWarning)objectArray[0]);
                return null;
            }
            case 104: {
                ((DSICarDriverAssistance)object).setACCSetFactoryDefault();
                return null;
            }
            case 105: {
                ((DSICarDriverAssistance)object).setPACCSensibility((Boolean)objectArray[0]);
                return null;
            }
            case 106: {
                ((DSICarDriverAssistance)object).setPACCMaxSpeed(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 107: {
                ((DSICarDriverAssistance)object).setPACCDrivingProgram(((Number)objectArray[0]).intValue());
                return null;
            }
            case 108: {
                ((DSICarDriverAssistance)object).setAWVSystem(((Number)objectArray[0]).intValue());
                return null;
            }
            case 109: {
                ((DSICarDriverAssistance)object).setAWVWarning((Boolean)objectArray[0]);
                return null;
            }
            case 110: {
                ((DSICarDriverAssistance)object).setAWVGong((Boolean)objectArray[0]);
                return null;
            }
            case 111: {
                ((DSICarDriverAssistance)object).setAWVGongVolume(((Number)objectArray[0]).intValue());
                return null;
            }
            case 112: {
                ((DSICarDriverAssistance)object).setAWVBrakeJerk((Boolean)objectArray[0]);
                return null;
            }
            case 113: {
                ((DSICarDriverAssistance)object).setAWVEmergencyBrake((AWVEmergencyBrake)objectArray[0]);
                return null;
            }
            case 114: {
                ((DSICarDriverAssistance)object).setAWVDistanceWarning((Boolean)objectArray[0]);
                return null;
            }
            case 115: {
                ((DSICarDriverAssistance)object).setAWVWarningTimegap(((Number)objectArray[0]).intValue());
                return null;
            }
            case 116: {
                ((DSICarDriverAssistance)object).setAWVSetFactoryDefault();
                return null;
            }
            case 117: {
                ((DSICarDriverAssistance)object).setSWABrightness(((Number)objectArray[0]).intValue());
                return null;
            }
            case 118: {
                ((DSICarDriverAssistance)object).setSWAWarningTime(((Number)objectArray[0]).intValue());
                return null;
            }
            case 119: {
                ((DSICarDriverAssistance)object).setSWAFrequency(((Number)objectArray[0]).intValue());
                return null;
            }
            case 120: {
                ((DSICarDriverAssistance)object).setSWASystem(((Number)objectArray[0]).intValue());
                return null;
            }
            case 121: {
                ((DSICarDriverAssistance)object).setSWAGongState((Boolean)objectArray[0]);
                return null;
            }
            case 122: {
                ((DSICarDriverAssistance)object).setSWAGongVolume(((Number)objectArray[0]).intValue());
                return null;
            }
            case 123: {
                ((DSICarDriverAssistance)object).setSWARCTA((Boolean)objectArray[0]);
                return null;
            }
            case 124: {
                ((DSICarDriverAssistance)object).setSWAExitAssist((Boolean)objectArray[0]);
                return null;
            }
            case 125: {
                ((DSICarDriverAssistance)object).setNVActivation((Boolean)objectArray[0]);
                return null;
            }
            case 126: {
                ((DSICarDriverAssistance)object).setNVContrast(((Number)objectArray[0]).intValue());
                return null;
            }
            case 127: {
                ((DSICarDriverAssistance)object).setNVBrightness(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((DSICarDriverAssistance)object).setNVObjectDetection((NVObjectDetection)objectArray[0]);
                return null;
            }
            case 129: {
                ((DSICarDriverAssistance)object).setNVColorPA(((Number)objectArray[0]).intValue());
                return null;
            }
            case 130: {
                ((DSICarDriverAssistance)object).setNVDesignPA(((Number)objectArray[0]).intValue());
                return null;
            }
            case 131: {
                ((DSICarDriverAssistance)object).setNVDisplay(((Number)objectArray[0]).intValue());
                return null;
            }
            case 132: {
                ((DSICarDriverAssistance)object).setNVZoomPanning(((Number)objectArray[0]).intValue());
                return null;
            }
            case 133: {
                ((DSICarDriverAssistance)object).setNVSound(((Number)objectArray[0]).intValue());
                return null;
            }
            case 134: {
                ((DSICarDriverAssistance)object).setNVSymbol((Boolean)objectArray[0]);
                return null;
            }
            case 135: {
                ((DSICarDriverAssistance)object).setNVSetFactoryDefault();
                return null;
            }
            case 136: {
                ((DSICarDriverAssistance)object).setNVWarningTimegap(((Number)objectArray[0]).intValue());
                return null;
            }
            case 137: {
                ((DSICarDriverAssistance)object).setNVSystem((Boolean)objectArray[0]);
                return null;
            }
            case 138: {
                ((DSICarDriverAssistance)object).setLDWWarningTime(((Number)objectArray[0]).intValue());
                return null;
            }
            case 139: {
                ((DSICarDriverAssistance)object).setLDWSteeringWheelVibration(((Number)objectArray[0]).intValue());
                return null;
            }
            case 140: {
                ((DSICarDriverAssistance)object).setHCAInterventionStyle(((Number)objectArray[0]).intValue());
                return null;
            }
            case 141: {
                ((DSICarDriverAssistance)object).setHCAToleranceLevel(((Number)objectArray[0]).intValue());
                return null;
            }
            case 142: {
                ((DSICarDriverAssistance)object).setLdwhcaSetFactoryDefault();
                return null;
            }
            case 143: {
                ((DSICarDriverAssistance)object).setLDWHCASystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 144: {
                ((DSICarDriverAssistance)object).setLDWHCAWarningSound((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 145: {
                ((DSICarDriverAssistance)object).setTSDSystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 146: {
                ((DSICarDriverAssistance)object).setTSDRoadSignFilter((TSDRoadSignFilter)objectArray[0]);
                return null;
            }
            case 147: {
                ((DSICarDriverAssistance)object).setTsdSetFactoryDefault();
                return null;
            }
            case 148: {
                ((DSICarDriverAssistance)object).setTSDSpeedWarningThreshold((Boolean)objectArray[0], (CarBCSpeed)objectArray[1]);
                return null;
            }
            case 149: {
                ((DSICarDriverAssistance)object).setTSDTrailerSpeedLimit((CarBCSpeed)objectArray[0]);
                return null;
            }
            case 150: {
                ((DSICarDriverAssistance)object).setTSDSpeedWarningAcoustics((Boolean)objectArray[0]);
                return null;
            }
            case 151: {
                ((DSICarDriverAssistance)object).setMKESystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 152: {
                ((DSICarDriverAssistance)object).setMKESetFactoryDefault();
                return null;
            }
            case 153: {
                ((DSICarDriverAssistance)object).setPASystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 154: {
                ((DSICarDriverAssistance)object).setPASetFactoryDefault();
                return null;
            }
            case 155: {
                ((DSICarDriverAssistance)object).setPAConfigInformation((Boolean)objectArray[0]);
                return null;
            }
            case 156: {
                ((DSICarDriverAssistance)object).setPAConfigWarning((Boolean)objectArray[0]);
                return null;
            }
            case 157: {
                ((DSICarDriverAssistance)object).setPAWarningTimegap(((Number)objectArray[0]).intValue());
                return null;
            }
            case 158: {
                ((DSICarDriverAssistance)object).setCurveAssistSystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 159: {
                ((DSICarDriverAssistance)object).setCurveAssistSetFactoryDefault();
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((DSICarDriverAssistance)object).setFTASystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 161: {
                ((DSICarDriverAssistance)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 162: {
                ((DSICarDriverAssistance)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 163: {
                ((DSICarDriverAssistance)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 164: {
                ((DSICarDriverAssistance)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 165: {
                ((DSICarDriverAssistance)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 166: {
                ((DSICarDriverAssistance)object).clearNotification((DSIListener)objectArray[0]);
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

