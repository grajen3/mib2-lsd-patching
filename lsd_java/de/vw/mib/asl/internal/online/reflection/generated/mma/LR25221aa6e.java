/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.reflection.generated.mma;

import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelTarget;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.states.CoreServiceMODTarget;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.states.CoreServiceOCUTarget;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineTrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.asl.internal.online.traffic.states.OnlineTrafficTarget;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public final class LR25221aa6e
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2047129271: {
                if (bl) {
                    if (n2 != 936783904) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1702686102: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1626157754: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1509360555: {
                if (bl) {
                    if (n2 != -1625298121) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1481466824: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1317655255: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1210634365: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1009009255: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -820754499: {
                if (bl) {
                    if (n2 != 1978939428) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -795725681: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -529204573: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -522946640: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -299881841: {
                if (bl) {
                    if (n2 != -155067449) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -65418165: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -32379787: {
                if (bl) {
                    if (n2 != 1978939428) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 122266563: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 279431861: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 290007501: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 363851590: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 427003477: {
                if (bl) {
                    if (n2 != -1003189943) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 488203297: {
                if (bl) {
                    if (n2 != 882735816) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 603453799: {
                if (bl) {
                    if (n2 != -1596870857) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 641091985: {
                if (bl) {
                    if (n2 != -1003189943) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 657834289: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1044339386: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1161710583: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1220713665: {
                if (bl) {
                    if (n2 != -370215360) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1226625759: {
                if (bl) {
                    if (n2 != 1620001206) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1386473555: {
                if (bl) {
                    if (n2 != 1990655267) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1433844169: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1438240960: {
                if (bl) {
                    if (n2 != 1608350902) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1589827509: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1623925415: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1715456457: {
                if (bl) {
                    if (n2 != 1978939428) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 2081505573: {
                if (bl) {
                    if (n2 != -370215360) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 2093296256: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2142549975: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -2062664968: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -2048083556: {
                if (bl) {
                    if (n2 != -361269682) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -1988508485: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case -1961548830: {
                if (bl) {
                    if (n2 != -1597567792) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -1897185006: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1842558006: {
                if (bl) {
                    if (n2 != -1750220564) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -1823566344: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1772230630: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -1744468455: {
                if (bl) {
                    if (n2 != 1775039192) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -1576278670: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1545561277: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case -1433804035: {
                if (bl) {
                    if (n2 != -47799197) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1395704005: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1252370185: {
                if (bl) {
                    if (n2 != -1539323744) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case -1107875364: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1085410481: {
                if (bl) {
                    if (n2 != -1232668240) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -982351390: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -816467935: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -624901804: {
                if (bl) {
                    if (n2 != 962051051) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -590772286: {
                if (bl) {
                    if (n2 != 472062299) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -505135180: {
                if (bl) {
                    if (n2 != 34843543) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -376936551: {
                if (bl) {
                    if (n2 != -564372616) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -349344407: {
                if (bl) {
                    if (n2 != -68790916) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -197055534: {
                if (bl) {
                    if (n2 != -671105604) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -189056093: {
                if (bl) {
                    if (n2 != -1813711490) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case -81741044: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -54813275: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -37973858: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -36037143: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1154749: {
                if (bl) {
                    if (n2 != -1674355153) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 19509985: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 30989135: {
                if (bl) {
                    if (n2 != -1750220564) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 105871070: {
                if (bl) {
                    if (n2 != 748367570) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 153843988: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 158873158: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 322808532: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 323040472: {
                if (bl) {
                    if (n2 != 1590952076) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 556159992: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 685841366: {
                if (bl) {
                    if (n2 != -1185929098) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 720186954: {
                if (bl) {
                    if (n2 != -47799197) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 798994391: {
                if (bl) {
                    if (n2 != -1895266515) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 829503428: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 858298304: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 1021463841: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 1138741390: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1598083261: {
                if (bl) {
                    if (n2 != 879382636) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 1598204606: {
                if (bl) {
                    if (n2 != 117412439) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 1629721482: {
                if (bl) {
                    if (n2 != -1898581697) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 1689056723: {
                if (bl) {
                    if (n2 != -892169136) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 1729372989: {
                if (bl) {
                    if (n2 != -789921790) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 1805609887: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1887939072: {
                if (bl) {
                    if (n2 != -1992762834) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 1992139125: {
                if (bl) {
                    if (n2 != 375633124) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 2070457296: {
                if (bl) {
                    if (n2 != -892169136) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1349867042: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -1107875364: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case -530889831: {
                if (bl) {
                    if (n2 != 1752413482) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case -327010065: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case -11557870: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 18161955: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case 366310126: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1897184014: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -169342773: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 20580406: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
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
            case -1870356374: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -482853908: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -200784588: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 534587419: {
                n2 = this.a3(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((CoreServiceModelTarget)object).setCurrentState((HsmState)objectArray[0]);
                return null;
            }
            case 1: {
                return ((CoreServiceModelTarget)object).getCurrentState();
            }
            case 2: {
                return ((CoreServiceModelTarget)object).getParentState();
            }
            case 3: {
                return ((CoreServiceModelTarget)object).getActiveState();
            }
            case 4: {
                return ((CoreServiceModelTarget)object).getAppActiveState();
            }
            case 5: {
                return ((CoreServiceModelTarget)object).getAuthenticationState();
            }
            case 6: {
                return ((CoreServiceModelTarget)object).getSpellerState();
            }
            case 7: {
                return ((CoreServiceModelTarget)object).getNotActiveState();
            }
            case 8: {
                ((CoreServiceModelTarget)object).updateRegisteredDeviceType(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((CoreServiceModelTarget)object).updateUserList((OnlineUser[])objectArray[0]);
                return null;
            }
            case 10: {
                ((CoreServiceModelTarget)object).updateServiceList((OnlineService[])objectArray[0]);
                return null;
            }
            case 11: {
                ((CoreServiceModelTarget)object).resetToFactorySettingsResponse(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((CoreServiceModelTarget)object).getUserListResponse((OnlineUser[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((CoreServiceModelTarget)object).setActiveUserResponse((OnlineUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((CoreServiceModelTarget)object).getActiveUserResponse((OnlineUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((CoreServiceModelTarget)object).validatePinResponse((OnlineUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((CoreServiceModelTarget)object).verifyUserResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((CoreServiceModelTarget)object).checkServiceStatusResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((CoreServiceModelTarget)object).getServiceResponse((String)objectArray[0], (OnlineService)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((CoreServiceModelTarget)object).getServiceURLResponse((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 20: {
                ((CoreServiceModelTarget)object).setStateResponse((String)objectArray[0], (OnlineService)objectArray[1]);
                return null;
            }
            case 21: {
                ((CoreServiceModelTarget)object).resetToFactorySettingsWithServiceNameResponse(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 22: {
                ((CoreServiceModelTarget)object).checkServiceStatusWithServiceNameResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((CoreServiceModelTarget)object).getServiceWithServiceNameResponse((String)objectArray[0], (OnlineService)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 24: {
                ((CoreServiceModelTarget)object).getServiceURLWithServiceNameResponse((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 25: {
                ((CoreServiceModelTarget)object).setStateWithServiceNameResponse((String)objectArray[0], (OnlineService)objectArray[1]);
                return null;
            }
            case 26: {
                ((CoreServiceModelTarget)object).updateRegistrationStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((CoreServiceModelTarget)object).updateDeviceReadyForUse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((CoreServiceModelTarget)object).updateTrackingServicesActivation((OnlineTrackingService[])objectArray[0]);
                return null;
            }
            case 29: {
                ((CoreServiceModelTarget)object).updatePrimaryUserPopupActivation((OnlineUser)objectArray[0]);
                return null;
            }
            case 30: {
                ((CoreServiceModelTarget)object).updateService((OnlineService)objectArray[0]);
                return null;
            }
            case 31: {
                ((CoreServiceModelTarget)object).updatePrivacyModeStatus((Boolean)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((CoreServiceModelTarget)object).updateCumulativeServiceListState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 33: {
                ((CoreServiceModelTarget)object).getOnlineServiceListResponse((OnlineService[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((CoreServiceModelTarget)object).sendPrivacyModeStatusResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                return ((CoreServiceModelTarget)object).getNavigationOnlinePoiListenerAdapter();
            }
            case 36: {
                ((CoreServiceMODTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((CoreServiceMODTarget)object).startUp();
                return null;
            }
            case 38: {
                return RuntimeUtil.valueOf(((CoreServiceMODTarget)object).getDeviceID());
            }
            case 39: {
                return ((CoreServiceMODTarget)object).getDSIOnlineServiceRegistration();
            }
            case 40: {
                ((CoreServiceMODTarget)object).tranformToInternalImage((String)objectArray[0]);
                return null;
            }
            case 41: {
                ((CoreServiceMODTarget)object).setApplicationProperty((String)objectArray[0]);
                return null;
            }
            case 42: {
                ((CoreServiceMODTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 44: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetOnlineApplicationListResponse((OSRApplication[])objectArray[0]);
                return null;
            }
            case 45: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetOnlineApplicationResponse((OSRApplication)objectArray[0]);
                return null;
            }
            case 46: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationActivateLicenseResponse((OSRLicense)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 47: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetServiceListResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 48: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationValidatePairingCodeResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationSetCredentialResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationCheckValidCredentialResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationDownloadResponse((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 52: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationDownloadRawResponse((String)objectArray[0], (String)objectArray[1], (String)objectArray[2], (ResourceLocator)objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 53: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationValidateOwnerResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 54: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationCheckOwnersVerificationResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 55: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationCreateUserWithPairingCodeResponse((String)objectArray[0], (OSRUser)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 56: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationCreateUserWithUserPasswordResponse((String)objectArray[0], (OSRUser)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 57: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationCheckPasswordResponse((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationCheckPairingCodeResponse((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationSetPrivacyFlagsResponse((OSRUser)objectArray[0]);
                return null;
            }
            case 60: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationSetAutoLoginResponse((OSRUser)objectArray[0], (OSRDevice[])objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 61: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationLoginResponse((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationLogoutResponse((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationLogoutAuthSchemeResult((String)objectArray[0], (OSRUser[])objectArray[1], (int[])objectArray[2]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetUsersResponse((OSRUser[])objectArray[0]);
                return null;
            }
            case 65: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationRemoveUserResponse((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 66: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationPerformPortalRegistrationResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationPrecheckOnlineServiceServiceIDResponse((String)objectArray[0], (OSRServiceState)objectArray[1]);
                return null;
            }
            case 68: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationPrecheckOnlineServiceSymbolicNameResponse((String)objectArray[0], (OSRServiceState)objectArray[1]);
                return null;
            }
            case 69: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationPrecheckOnlineServiceResponse((String)objectArray[0], (OSRServiceState[])objectArray[1]);
                return null;
            }
            case 70: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetLicenseResponse(((Number)objectArray[0]).intValue(), (OSRLicense)objectArray[1]);
                return null;
            }
            case 71: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetLicensesResponse(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], (Boolean)objectArray[2], (OSRLicense[])objectArray[3]);
                return null;
            }
            case 72: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetProfileFolderResponse(((Number)objectArray[0]).intValue(), (String)objectArray[1], (OSRUser)objectArray[2], (String)objectArray[3]);
                return null;
            }
            case 73: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetCredentialsFromHeaderResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3], (String)objectArray[4], (String)objectArray[5]);
                return null;
            }
            case 74: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetCredentialsFromAuthSchemeResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], (String)objectArray[3], (String)objectArray[4]);
                return null;
            }
            case 75: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetServiceURLResponse(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 76: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationResetToFactorySettingsResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 77: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationUpdateApplicationState((OSRNotifyProperties[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 78: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationUpdateProfileInfo(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 79: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationUpdateCoreProfileInfo((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 80: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationUpdateExternalProfileInfo((String)objectArray[0], (OSRUser)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 81: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationUpdateDeviceEnumerator((OSRDevice)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 82: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationUpdateServiceState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 83: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationUpdateServiceList((OSRServiceListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 84: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationUpdateServices((OSRNotifyPropertiesSL[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 85: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationSetServiceStateResponse((OSRServiceState)objectArray[0]);
                return null;
            }
            case 86: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationSetServiceStateSymbolicNameResponse((OSRServiceState)objectArray[0]);
                return null;
            }
            case 87: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationSetActivePrivacyCategoryMaskResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 88: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationSubmitServiceStateChangesToBackendResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 89: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationUpdateSPINRequired((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 90: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationSetSPINResponse((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 91: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationGetSPINHashResult((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), (String)objectArray[3], (String)objectArray[4], ((Number)objectArray[5]).intValue());
                return null;
            }
            case 92: {
                ((CoreServiceMODTarget)object).dsiOnlineServiceRegistrationSetInventoryFinishedResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 93: {
                return RuntimeUtil.valueOf(((CoreServiceOCUTarget)object).getDeviceID());
            }
            case 94: {
                return ((CoreServiceOCUTarget)object).getNetworkServiceProvider();
            }
            case 95: {
                return ((CoreServiceOCUTarget)object).getNetworkService();
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((CoreServiceOCUTarget)object).sendRegisteredDeviceType(((Number)objectArray[0]).intValue());
                return null;
            }
            case 97: {
                ((CoreServiceOCUTarget)object).sendDeviceAvailability(((Number)objectArray[0]).intValue());
                return null;
            }
            case 98: {
                ((CoreServiceOCUTarget)object).onSuccess((Access)objectArray[0]);
                return null;
            }
            case 99: {
                ((CoreServiceOCUTarget)object).onError();
                return null;
            }
            case 100: {
                ((OnlineTrafficTarget)object).shutdown();
                return null;
            }
            case 101: {
                ((OnlineTrafficTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 102: {
                ((OnlineTrafficTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 103: {
                ((OnlineTrafficTarget)object).startup();
                return null;
            }
            case 104: {
                return ((OnlineTrafficTarget)object).getStateActive();
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

