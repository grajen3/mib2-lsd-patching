/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.telephone.CallDuration;
import org.dsi.ifc.telephone.DSITelephoneListener;
import org.dsi.ifc.telephone.DisconnectReason;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephone.MailboxDialingNumber;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.SuppServiceResponseStruct;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.MissedCallIndicator;
import org.dsi.ifc.telephoneng.NADTemperatureStruct;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.SIMAliasInformation;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.ServiceProvider;

public final class LR2dae727ac
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2067924324: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -2035071097: {
                if (bl) {
                    if (n2 != -315766685) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1950100369: {
                if (bl) {
                    if (n2 != -764191791) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1863277689: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -1767619826: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case -1745511364: {
                if (bl) {
                    if (n2 != 163960979) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case -1524026420: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1493295391: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -1478287781: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -1453614118: {
                if (bl) {
                    if (n2 != -2138292360) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1408931105: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -1374892685: {
                if (bl) {
                    if (n2 != -1068424016) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1301834822: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1297490190: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1293476197: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1277924181: {
                if (bl) {
                    if (n2 != -953657099) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1276568223: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1273043613: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1266731160: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1249807793: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -1249482044: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case -1190354646: {
                if (bl) {
                    if (n2 != 1487807011) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1130554378: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case -1121773759: {
                if (bl) {
                    if (n2 != 64549546) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1113845529: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -1023887832: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -921501980: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -861457124: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -834797181: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -826904575: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -812984285: {
                if (bl) {
                    if (n2 != -541580181) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -746741296: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -728694848: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -676792105: {
                if (bl) {
                    if (n2 != -1541305133) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -668881557: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case -648682156: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -635681906: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -579721725: {
                if (bl) {
                    if (n2 != -1956160842) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -576680434: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -528316626: {
                if (bl) {
                    if (n2 != -711598809) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -457462713: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -306927007: {
                if (bl) {
                    if (n2 != 1813396576) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -277588663: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -195577421: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -194880640: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -188006104: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -181948062: {
                if (bl) {
                    if (n2 != -745942425) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -175237177: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -61250232: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -55428726: {
                if (bl) {
                    if (n2 != -764191791) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 0x5020522: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 118034175: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 122630695: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 139922165: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 191906518: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 210977825: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 264457682: {
                if (bl) {
                    if (n2 != 2028839530) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 363468599: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 398172722: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 450566176: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 580215967: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 696165598: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 697304698: {
                if (bl) {
                    if (n2 != -1979792155) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 705134733: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 756920655: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 799459520: {
                if (bl) {
                    if (n2 != 1725401550) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 900318879: {
                if (bl) {
                    if (n2 != 278877352) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 909694812: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 922061478: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 926212778: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case 988393505: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1031685315: {
                if (bl) {
                    if (n2 != -2145510134) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 1069161270: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1105575774: {
                if (bl) {
                    if (n2 != 736675901) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 1110794662: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 1139804979: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 1214636148: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1226924594: {
                if (bl) {
                    if (n2 != -1555888253) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1252494336: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 1276905152: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 1308811505: {
                if (bl) {
                    if (n2 != -541580181) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1346457352: {
                if (bl) {
                    if (n2 != -1362069442) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 1361999707: {
                if (bl) {
                    if (n2 != -541580181) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1397170023: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1438689672: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1639559627: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 1666711035: {
                if (bl) {
                    if (n2 != -112335262) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1826392083: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1846605311: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1883716167: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1940213019: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 1948712827: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1982912360: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 1983939679: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 2079876731: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 2125444061: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case 2125803708: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 2129755534: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2067924324: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -2035071097: {
                if (bl) {
                    if (n2 != 1960351444) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case -1950100369: {
                if (bl) {
                    if (n2 != -710961892) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case -1863277689: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case -1767619826: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case -1745511364: {
                if (bl) {
                    if (n2 != 576851223) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 190;
                    break;
                }
                n3 = 190;
                break;
            }
            case -1524026420: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case -1493295391: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case -1478287781: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case -1453614118: {
                if (bl) {
                    if (n2 != -953354753) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -1408931105: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case -1374892685: {
                if (bl) {
                    if (n2 != 425844661) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case -1301834822: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -1293476197: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case -1277924181: {
                if (bl) {
                    if (n2 != 248057213) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case -1276568223: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case -1273043613: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case -1266731160: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case -1249807793: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 185;
                    break;
                }
                n3 = 185;
                break;
            }
            case -1249482044: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case -1190354646: {
                if (bl) {
                    if (n2 != -1314144535) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -1130554378: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 184;
                    break;
                }
                n3 = 184;
                break;
            }
            case -1121773759: {
                if (bl) {
                    if (n2 != -1673465575) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -1113845529: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case -1096954617: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 186;
                    break;
                }
                n3 = 186;
                break;
            }
            case -1023887832: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case -928872735: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 189;
                    break;
                }
                n3 = 189;
                break;
            }
            case -921501980: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -861457124: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case -834797181: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case -826904575: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case -746741296: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case -728694848: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case -676792105: {
                if (bl) {
                    if (n2 != -1111572394) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case -668881557: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case -635681906: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case -579721725: {
                if (bl) {
                    if (n2 != 1389146091) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case -576680434: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case -528316626: {
                if (bl) {
                    if (n2 != 473945398) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case -306927007: {
                if (bl) {
                    if (n2 != 92224207) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case -195577421: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case -194880640: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -188006104: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case -175237177: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case -61250232: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -55428726: {
                if (bl) {
                    if (n2 != -710961892) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case 0x5020522: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case 118034175: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case 122630695: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 139922165: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 158943789: {
                if (bl) {
                    if (n2 != 1960351444) break;
                    n3 = 188;
                    break;
                }
                n3 = 188;
                break;
            }
            case 191906518: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case 210977825: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case 264457682: {
                if (bl) {
                    if (n2 != 1070156060) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 363468599: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case 450566176: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
            case 580215967: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case 696165598: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 179;
                    break;
                }
                n3 = 179;
                break;
            }
            case 697304698: {
                if (bl) {
                    if (n2 != -486842196) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case 705134733: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case 756920655: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case 775662441: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 187;
                    break;
                }
                n3 = 187;
                break;
            }
            case 799459520: {
                if (bl) {
                    if (n2 != 1843814795) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case 900318879: {
                if (bl) {
                    if (n2 != 1463749168) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case 909694812: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case 922061478: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case 926212778: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 183;
                    break;
                }
                n3 = 183;
                break;
            }
            case 988393505: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case 1031685315: {
                if (bl) {
                    if (n2 != -946841986) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case 1069161270: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 1105575774: {
                if (bl) {
                    if (n2 != 1149631936) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case 1110794662: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case 1139804979: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case 1214636148: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case 1226924594: {
                if (bl) {
                    if (n2 != 1780461108) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case 1252494336: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case 1276905152: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case 1346457352: {
                if (bl) {
                    if (n2 != 897271727) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 1397170023: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 1438689672: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case 1639559627: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case 1666711035: {
                if (bl) {
                    if (n2 != -2134796142) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case 1826392083: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 1846605311: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case 1940213019: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
            case 1982912360: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 1983939679: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case 2079876731: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 2125444061: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case 2125803708: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 2129755534: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
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
            case 63512451: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1322622002: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMobileEquipmentListener)object).updateMicGainLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIMobileEquipmentListener)object).responseRestoreFactorySettings(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIMobileEquipmentListener)object).responseNetworkSearch((org.dsi.ifc.telephoneng.NetworkProvider[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIMobileEquipmentListener)object).updateSignalQuality(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIMobileEquipmentListener)object).updateLastAnsweredNumbers((CallStackEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIMobileEquipmentListener)object).updateLastDialedNumbers((CallStackEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIMobileEquipmentListener)object).updateMissedNumbers((CallStackEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIMobileEquipmentListener)object).updateMEDataValidity(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIMobileEquipmentListener)object).updateMissedCallIndicator((MissedCallIndicator)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIMobileEquipmentListener)object).updateSpeechRecognitionAvailable(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIMobileEquipmentListener)object).updateSpeechRecognitionActive(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIMobileEquipmentListener)object).updateSpeechRecognitionType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIMobileEquipmentListener)object).responseStartSpeechRecognition(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSIMobileEquipmentListener)object).responseStopSpeechRecognition(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIMobileEquipmentListener)object).responseAbortNetworkRegistration(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSIMobileEquipmentListener)object).responseAbortNetworkSearch(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSIMobileEquipmentListener)object).responseChangeSIMCode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIMobileEquipmentListener)object).responseSIMPINRequired(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSIMobileEquipmentListener)object).updateSIMPINRequired((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIMobileEquipmentListener)object).responseNetworkRegistration(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSIMobileEquipmentListener)object).responseUnlockSIM(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIMobileEquipmentListener)object).responseCheckSIMPINCode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 22: {
                ((DSIMobileEquipmentListener)object).responseTelPower(((Number)objectArray[0]).intValue());
                return null;
            }
            case 23: {
                ((DSIMobileEquipmentListener)object).responseSetAutomaticPinEntryActive(((Number)objectArray[0]).intValue());
                return null;
            }
            case 24: {
                ((DSIMobileEquipmentListener)object).updateActivationState((ActivationStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIMobileEquipmentListener)object).updateAutomaticPinEntryActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSIMobileEquipmentListener)object).updateLockState((LockStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSIMobileEquipmentListener)object).updateNADTemperature((NADTemperatureStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSIMobileEquipmentListener)object).updatePhoneInformation((org.dsi.ifc.telephoneng.PhoneInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSIMobileEquipmentListener)object).updateNetworkProvider((org.dsi.ifc.telephoneng.NetworkProviderName)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSIMobileEquipmentListener)object).updateNetworkType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSIMobileEquipmentListener)object).updateRegisterState((RegisterStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIMobileEquipmentListener)object).updateServiceProvider((ServiceProvider)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSIMobileEquipmentListener)object).responseAcceptCall(((Number)objectArray[0]).intValue());
                return null;
            }
            case 34: {
                ((DSIMobileEquipmentListener)object).responseCallForward((CFResponseData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSIMobileEquipmentListener)object).responseCallWaiting(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSIMobileEquipmentListener)object).responseCLIR(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 37: {
                ((DSIMobileEquipmentListener)object).responseDialNumber(((Number)objectArray[0]).intValue(), (org.dsi.ifc.telephoneng.SuppServiceResponseStruct)objectArray[1]);
                return null;
            }
            case 38: {
                ((DSIMobileEquipmentListener)object).responseDialOperator(((Number)objectArray[0]).intValue(), (org.dsi.ifc.telephoneng.SuppServiceResponseStruct)objectArray[1]);
                return null;
            }
            case 39: {
                ((DSIMobileEquipmentListener)object).responseSendDTMF(((Number)objectArray[0]).intValue());
                return null;
            }
            case 40: {
                ((DSIMobileEquipmentListener)object).updateDTMFTonePlaying((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSIMobileEquipmentListener)object).updateEmergencyNumbers((EmergencyNumbers)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSIMobileEquipmentListener)object).responseRemoveOtherSIM(((Number)objectArray[0]).intValue());
                return null;
            }
            case 43: {
                ((DSIMobileEquipmentListener)object).updateOtherSIMAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 44: {
                ((DSIMobileEquipmentListener)object).responseHangupCall(((Number)objectArray[0]).intValue());
                return null;
            }
            case 45: {
                ((DSIMobileEquipmentListener)object).responseJoinCalls(((Number)objectArray[0]).intValue());
                return null;
            }
            case 46: {
                ((DSIMobileEquipmentListener)object).responseUnlockOtherSIM(((Number)objectArray[0]).intValue());
                return null;
            }
            case 47: {
                ((DSIMobileEquipmentListener)object).responseSetHandsFreeMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 48: {
                ((DSIMobileEquipmentListener)object).responseSetAutomaticRedialActive(((Number)objectArray[0]).intValue());
                return null;
            }
            case 49: {
                ((DSIMobileEquipmentListener)object).responseServiceCodeAbort(((Number)objectArray[0]).intValue());
                return null;
            }
            case 50: {
                ((DSIMobileEquipmentListener)object).responseSplitCall(((Number)objectArray[0]).intValue());
                return null;
            }
            case 51: {
                ((DSIMobileEquipmentListener)object).responseSwapCalls(((Number)objectArray[0]).intValue());
                return null;
            }
            case 52: {
                ((DSIMobileEquipmentListener)object).updateAutomaticRedialActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((DSIMobileEquipmentListener)object).updateBatteryChargeLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSIMobileEquipmentListener)object).updateCallDurationList((org.dsi.ifc.telephoneng.CallDuration[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSIMobileEquipmentListener)object).updateCallList((CallInformation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSIMobileEquipmentListener)object).updateCDMAThreeWayCallingSetting((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSIMobileEquipmentListener)object).updateCradlePlugInState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSIMobileEquipmentListener)object).updateDisconnectReason((org.dsi.ifc.telephoneng.DisconnectReason)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSIMobileEquipmentListener)object).updateEmergencyCallActive((EmergencyCallSetting)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 60: {
                ((DSIMobileEquipmentListener)object).updateEnhancedPrivacyMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((DSIMobileEquipmentListener)object).updateHandsFreeMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((DSIMobileEquipmentListener)object).updateMailboxContent((org.dsi.ifc.telephoneng.MailboxDialingNumber[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSIMobileEquipmentListener)object).updateMICMuteState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSIMobileEquipmentListener)object).updatePrivacyMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((DSIMobileEquipmentListener)object).updateServiceCodeType((ServiceCodeTypeStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 66: {
                ((DSIMobileEquipmentListener)object).updateServiceNumbers((ServiceNumbers)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((DSIMobileEquipmentListener)object).updateSuppServiceResponse((org.dsi.ifc.telephoneng.SuppServiceResponseStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((DSIMobileEquipmentListener)object).updateNADMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((DSIMobileEquipmentListener)object).responseSetCDMAThreeWayCallingSetting(((Number)objectArray[0]).intValue());
                return null;
            }
            case 70: {
                ((DSIMobileEquipmentListener)object).responseSetAutomaticEmergencyCallActive(((Number)objectArray[0]).intValue());
                return null;
            }
            case 71: {
                ((DSIMobileEquipmentListener)object).responseSetMailboxContent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 72: {
                ((DSIMobileEquipmentListener)object).responseSetPrivacyMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 73: {
                ((DSIMobileEquipmentListener)object).responseSetSIMAliases(((Number)objectArray[0]).intValue());
                return null;
            }
            case 74: {
                ((DSIMobileEquipmentListener)object).responseSetMICMuteState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 75: {
                ((DSIMobileEquipmentListener)object).responseSetOptimizationMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 76: {
                ((DSIMobileEquipmentListener)object).responseSetNADMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 77: {
                ((DSIMobileEquipmentListener)object).updateSIMAliasInformation((SIMAliasInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 78: {
                ((DSIMobileEquipmentListener)object).updateOptimizationMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 79: {
                ((DSIMobileEquipmentListener)object).responseSetPhoneReminderSetting(((Number)objectArray[0]).intValue());
                return null;
            }
            case 80: {
                ((DSIMobileEquipmentListener)object).responseSetPrefixActivated(((Number)objectArray[0]).intValue());
                return null;
            }
            case 81: {
                ((DSIMobileEquipmentListener)object).responseSetPrefixContent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 82: {
                ((DSIMobileEquipmentListener)object).updatePhoneReminderSetting((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 83: {
                ((DSIMobileEquipmentListener)object).updatePrefixActivated((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 84: {
                ((DSIMobileEquipmentListener)object).updatePrefixContent((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 85: {
                ((DSIMobileEquipmentListener)object).updateWidebandSpeech((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 86: {
                ((DSIMobileEquipmentListener)object).responseSetPhoneRingtone(((Number)objectArray[0]).intValue());
                return null;
            }
            case 87: {
                ((DSIMobileEquipmentListener)object).updatePhoneRingtone(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 88: {
                ((DSIMobileEquipmentListener)object).responseSetFavorites(((Number)objectArray[0]).intValue());
                return null;
            }
            case 89: {
                ((DSIMobileEquipmentListener)object).updateFavorites((org.dsi.ifc.telephoneng.Favorite[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 90: {
                ((DSIMobileEquipmentListener)object).updateSAPUpgradeActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 91: {
                ((DSIMobileEquipmentListener)object).responseSetSIMName(((Number)objectArray[0]).intValue());
                return null;
            }
            case 92: {
                ((DSIMobileEquipmentListener)object).responseSetESIMActive(((Number)objectArray[0]).intValue());
                return null;
            }
            case 93: {
                ((DSIMobileEquipmentListener)object).updateEUICCID((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 94: {
                ((DSIMobileEquipmentListener)object).updateESIMMSISDN((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 95: {
                ((DSIMobileEquipmentListener)object).updateESimActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSIMobileEquipmentListener)object).updateESimB2BMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 97: {
                ((DSIMobileEquipmentListener)object).updateCallstacksIsReverted((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 98: {
                ((DSIMobileEquipmentListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 99: {
                ((DSITelephoneListener)object).updateMicGainLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 100: {
                ((DSITelephoneListener)object).responseRestoreFactorySettings(((Number)objectArray[0]).intValue());
                return null;
            }
            case 101: {
                ((DSITelephoneListener)object).responseNetworkSearch((NetworkProvider[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 102: {
                ((DSITelephoneListener)object).updateSignalQuality(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 103: {
                ((DSITelephoneListener)object).responseAbortNetworkRegistration(((Number)objectArray[0]).intValue());
                return null;
            }
            case 104: {
                ((DSITelephoneListener)object).responseAbortNetworkSearch(((Number)objectArray[0]).intValue());
                return null;
            }
            case 105: {
                ((DSITelephoneListener)object).responseChangeSIMCode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 106: {
                ((DSITelephoneListener)object).responseSIMPINRequired(((Number)objectArray[0]).intValue());
                return null;
            }
            case 107: {
                ((DSITelephoneListener)object).updateSIMPINRequired((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 108: {
                ((DSITelephoneListener)object).responseNetworkRegistration(((Number)objectArray[0]).intValue());
                return null;
            }
            case 109: {
                ((DSITelephoneListener)object).responseUnlockSIM(((Number)objectArray[0]).intValue());
                return null;
            }
            case 110: {
                ((DSITelephoneListener)object).responseCheckSIMPINCode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 111: {
                ((DSITelephoneListener)object).responseTelPower(((Number)objectArray[0]).intValue());
                return null;
            }
            case 112: {
                ((DSITelephoneListener)object).responseSetAutomaticPinEntryActive(((Number)objectArray[0]).intValue());
                return null;
            }
            case 113: {
                ((DSITelephoneListener)object).updateActivationState((org.dsi.ifc.telephone.ActivationStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 114: {
                ((DSITelephoneListener)object).updateAutomaticPinEntryActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 115: {
                ((DSITelephoneListener)object).updateLockState((org.dsi.ifc.telephone.LockStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 116: {
                ((DSITelephoneListener)object).updateNADTemperature((org.dsi.ifc.telephone.NADTemperatureStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 117: {
                ((DSITelephoneListener)object).updatePhoneInformation((PhoneInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 118: {
                ((DSITelephoneListener)object).updateNetworkProvider((NetworkProviderName)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 119: {
                ((DSITelephoneListener)object).updateNetworkType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 120: {
                ((DSITelephoneListener)object).updateRegisterState((org.dsi.ifc.telephone.RegisterStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 121: {
                ((DSITelephoneListener)object).updateServiceProvider((org.dsi.ifc.telephone.ServiceProvider)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 122: {
                ((DSITelephoneListener)object).responseAcceptCall(((Number)objectArray[0]).intValue());
                return null;
            }
            case 123: {
                ((DSITelephoneListener)object).responseCallForward((org.dsi.ifc.telephone.CFResponseData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 124: {
                ((DSITelephoneListener)object).responseCallWaiting(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 125: {
                ((DSITelephoneListener)object).responseCLIR(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 126: {
                ((DSITelephoneListener)object).responseDialNumber(((Number)objectArray[0]).intValue(), (SuppServiceResponseStruct)objectArray[1]);
                return null;
            }
            case 127: {
                ((DSITelephoneListener)object).responseDialOperator(((Number)objectArray[0]).intValue(), (SuppServiceResponseStruct)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((DSITelephoneListener)object).responseSendDTMF(((Number)objectArray[0]).intValue());
                return null;
            }
            case 129: {
                ((DSITelephoneListener)object).updateDTMFTonePlaying((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 130: {
                ((DSITelephoneListener)object).updateEmergencyNumbers((org.dsi.ifc.telephone.EmergencyNumbers)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 131: {
                ((DSITelephoneListener)object).responseRemoveOtherSIM(((Number)objectArray[0]).intValue());
                return null;
            }
            case 132: {
                ((DSITelephoneListener)object).updateOtherSIMAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 133: {
                ((DSITelephoneListener)object).responseHangupCall(((Number)objectArray[0]).intValue());
                return null;
            }
            case 134: {
                ((DSITelephoneListener)object).responseJoinCalls(((Number)objectArray[0]).intValue());
                return null;
            }
            case 135: {
                ((DSITelephoneListener)object).responseUnlockOtherSIM(((Number)objectArray[0]).intValue());
                return null;
            }
            case 136: {
                ((DSITelephoneListener)object).responseSetHandsFreeMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 137: {
                ((DSITelephoneListener)object).responseSetAutomaticRedialActive(((Number)objectArray[0]).intValue());
                return null;
            }
            case 138: {
                ((DSITelephoneListener)object).responseServiceCodeAbort(((Number)objectArray[0]).intValue());
                return null;
            }
            case 139: {
                ((DSITelephoneListener)object).responseSplitCall(((Number)objectArray[0]).intValue());
                return null;
            }
            case 140: {
                ((DSITelephoneListener)object).responseSwapCalls(((Number)objectArray[0]).intValue());
                return null;
            }
            case 141: {
                ((DSITelephoneListener)object).updateAutomaticRedialActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 142: {
                ((DSITelephoneListener)object).updateBatteryChargeLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 143: {
                ((DSITelephoneListener)object).updateCallDurationList((CallDuration[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 144: {
                ((DSITelephoneListener)object).updateCallList((org.dsi.ifc.telephone.CallInformation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 145: {
                ((DSITelephoneListener)object).updateCDMAThreeWayCallingSetting((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 146: {
                ((DSITelephoneListener)object).updateCradlePlugInState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 147: {
                ((DSITelephoneListener)object).updateDisconnectReason((DisconnectReason)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 148: {
                ((DSITelephoneListener)object).updateEmergencyCallActive((org.dsi.ifc.telephone.EmergencyCallSetting)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 149: {
                ((DSITelephoneListener)object).updateEnhancedPrivacyMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 150: {
                ((DSITelephoneListener)object).updateHandsFreeMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 151: {
                ((DSITelephoneListener)object).updateMailboxContent((MailboxDialingNumber[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 152: {
                ((DSITelephoneListener)object).updateMICMuteState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 153: {
                ((DSITelephoneListener)object).updatePrivacyMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 154: {
                ((DSITelephoneListener)object).updateServiceCodeType((org.dsi.ifc.telephone.ServiceCodeTypeStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 155: {
                ((DSITelephoneListener)object).updateServiceNumbers((org.dsi.ifc.telephone.ServiceNumbers)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 156: {
                ((DSITelephoneListener)object).updateSuppServiceResponse((SuppServiceResponseStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 157: {
                ((DSITelephoneListener)object).updateNADMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 158: {
                ((DSITelephoneListener)object).responseSetCDMAThreeWayCallingSetting(((Number)objectArray[0]).intValue());
                return null;
            }
            case 159: {
                ((DSITelephoneListener)object).responseSetAutomaticEmergencyCallActive(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((DSITelephoneListener)object).responseSetMailboxContent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 161: {
                ((DSITelephoneListener)object).responseSetPrivacyMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 162: {
                ((DSITelephoneListener)object).responseSetSIMAliases(((Number)objectArray[0]).intValue());
                return null;
            }
            case 163: {
                ((DSITelephoneListener)object).responseSetMICMuteState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 164: {
                ((DSITelephoneListener)object).responseSetOptimizationMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 165: {
                ((DSITelephoneListener)object).responseSetNADMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 166: {
                ((DSITelephoneListener)object).updateSIMAliasInformation((org.dsi.ifc.telephone.SIMAliasInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 167: {
                ((DSITelephoneListener)object).updateOptimizationMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 168: {
                ((DSITelephoneListener)object).responseSetPhoneReminderSetting(((Number)objectArray[0]).intValue());
                return null;
            }
            case 169: {
                ((DSITelephoneListener)object).responseSetPrefixActivated(((Number)objectArray[0]).intValue());
                return null;
            }
            case 170: {
                ((DSITelephoneListener)object).responseSetPrefixContent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 171: {
                ((DSITelephoneListener)object).updatePhoneReminderSetting((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 172: {
                ((DSITelephoneListener)object).updatePrefixActivated((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 173: {
                ((DSITelephoneListener)object).updatePrefixContent((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 174: {
                ((DSITelephoneListener)object).updateWidebandSpeech((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 175: {
                ((DSITelephoneListener)object).responseSetPhoneRingtone(((Number)objectArray[0]).intValue());
                return null;
            }
            case 176: {
                ((DSITelephoneListener)object).updatePhoneRingtone(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 177: {
                ((DSITelephoneListener)object).responseSetFavorites(((Number)objectArray[0]).intValue());
                return null;
            }
            case 178: {
                ((DSITelephoneListener)object).updateFavorites((Favorite[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 179: {
                ((DSITelephoneListener)object).updateSAPUpgradeActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 180: {
                ((DSITelephoneListener)object).responseSetSIMName(((Number)objectArray[0]).intValue());
                return null;
            }
            case 181: {
                ((DSITelephoneListener)object).responseSetESIMActive(((Number)objectArray[0]).intValue());
                return null;
            }
            case 182: {
                ((DSITelephoneListener)object).updateEUICCID((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 183: {
                ((DSITelephoneListener)object).updateESIMMSISDN((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 184: {
                ((DSITelephoneListener)object).updateESimActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 185: {
                ((DSITelephoneListener)object).updateESimB2BMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 186: {
                ((DSITelephoneListener)object).responseAbortAlternatePhoneActivity(((Number)objectArray[0]).intValue());
                return null;
            }
            case 187: {
                ((DSITelephoneListener)object).responseTogglePrioritizedPhoneDevice(((Number)objectArray[0]).intValue());
                return null;
            }
            case 188: {
                ((DSITelephoneListener)object).updateActivationStateAssociated((org.dsi.ifc.telephone.ActivationStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 189: {
                ((DSITelephoneListener)object).updateAlternatePhoneActivity((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 190: {
                ((DSITelephoneListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

