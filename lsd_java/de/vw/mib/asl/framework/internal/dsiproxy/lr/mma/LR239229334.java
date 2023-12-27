/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephone.CFRequestData;
import org.dsi.ifc.telephone.DSITelephone;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;

public final class LR239229334
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2016516841: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1757351524: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1673602257: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -1652371607: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -1634432074: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1489283190: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1445104488: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1297951113: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1227496965: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1179261491: {
                if (bl) {
                    if (n2 != -2117017335) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 54;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 55;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 56;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1089241616: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 57;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 58;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 59;
                    break;
                }
                n3 = 57;
                break;
            }
            case -825719111: {
                if (bl) {
                    if (n2 != -1944510538) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -628247110: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -555105555: {
                if (bl) {
                    if (n2 != -500686037) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -547099374: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -536998695: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -520507072: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -368680620: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -273474620: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -219119310: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -186056209: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -172299149: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 41128983: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 183181933: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 222496322: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 337433819: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 367602345: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 403828493: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 406160156: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 527145493: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 622353664: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 705792921: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 710153718: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 712250520: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 780958752: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 911215168: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 933123622: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 962141574: {
                if (bl) {
                    if (n2 != -1335048711) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1090066340: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1134885049: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1149546710: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1209404366: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1238353525: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1246952486: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1429358049: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1505484466: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1532776610: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 1558447183: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 1562758656: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1681332589: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1819685377: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1835664346: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1974016857: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1978827086: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1757351524: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -1673602257: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case -1652371607: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1634432074: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -1489283190: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -1445844809: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -1445104488: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -1297951113: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -1227496965: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1179261491: {
                if (bl) {
                    if (n2 != -935191682) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 110;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 111;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 112;
                    break;
                }
                n3 = 110;
                break;
            }
            case -1089241616: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 113;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 114;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 115;
                    break;
                }
                n3 = 113;
                break;
            }
            case -825719111: {
                if (bl) {
                    if (n2 != 1400796395) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -628247110: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -555105555: {
                if (bl) {
                    if (n2 != 2074616059) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -547099374: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case -536998695: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case -520507072: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -368680620: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -273474620: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case -219119310: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -186056209: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case 41128983: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 183181933: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 337433819: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 367602345: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 403828493: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 527145493: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 622353664: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case 705792921: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 710153718: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case 712250520: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case 780958752: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case 911215168: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 933123622: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 962141574: {
                if (bl) {
                    if (n2 != -1335048711) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 1090066340: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 1149546710: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 1186688505: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 1209404366: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 1238353525: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 1246952486: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 1429358049: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 1505484466: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 1558447183: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 1562758656: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case 1681332589: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 1819685377: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case 1835664346: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1974016857: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 1978827086: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
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
            case -992030545: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -991007650: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMobileEquipment)object).restoreFactorySettings();
                return null;
            }
            case 1: {
                ((DSIMobileEquipment)object).requestNetworkSearch();
                return null;
            }
            case 2: {
                ((DSIMobileEquipment)object).requestSetMicGainLevel(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIMobileEquipment)object).resetMissedCallIndicator();
                return null;
            }
            case 4: {
                ((DSIMobileEquipment)object).revertCallstacks((Boolean)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIMobileEquipment)object).requestStartSpeechRecognition();
                return null;
            }
            case 6: {
                ((DSIMobileEquipment)object).requestStopSpeechRecognition();
                return null;
            }
            case 7: {
                ((DSIMobileEquipment)object).requestNetworkRegistration((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIMobileEquipment)object).requestAbortNetworkRegistration();
                return null;
            }
            case 9: {
                ((DSIMobileEquipment)object).requestAbortNetworkSearch();
                return null;
            }
            case 10: {
                ((DSIMobileEquipment)object).requestSetAutomaticPinEntryActive((Boolean)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIMobileEquipment)object).requestTelPower(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSIMobileEquipment)object).requestUnlockSIM(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 13: {
                ((DSIMobileEquipment)object).requestCheckSIMPINCode((String)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIMobileEquipment)object).requestChangeSIMCode(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 15: {
                ((DSIMobileEquipment)object).requestSIMPINRequired((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIMobileEquipment)object).acceptCall(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSIMobileEquipment)object).hangupCall(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSIMobileEquipment)object).swapCalls();
                return null;
            }
            case 19: {
                ((DSIMobileEquipment)object).splitCall((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSIMobileEquipment)object).joinCalls();
                return null;
            }
            case 21: {
                ((DSIMobileEquipment)object).dialNumber((String)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSIMobileEquipment)object).dialOperator(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIMobileEquipment)object).dialNumberFromDBEntry((String)objectArray[0], ((Number)objectArray[1]).longValue(), (String)objectArray[2], (short)((Number)objectArray[3]).intValue(), (short)((Number)objectArray[4]).intValue(), (ResourceLocator)objectArray[5], ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue());
                return null;
            }
            case 24: {
                ((DSIMobileEquipment)object).sendDTMF((String)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSIMobileEquipment)object).requestCallForward((org.dsi.ifc.telephoneng.CFRequestData[])objectArray[0]);
                return null;
            }
            case 26: {
                ((DSIMobileEquipment)object).requestCallWaiting(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((DSIMobileEquipment)object).requestCLIR(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSIMobileEquipment)object).requestServiceCodeAbort();
                return null;
            }
            case 29: {
                ((DSIMobileEquipment)object).requestSetAutomaticRedialActive((Boolean)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSIMobileEquipment)object).requestSetCDMAThreeWayCallingSetting((Boolean)objectArray[0]);
                return null;
            }
            case 31: {
                ((DSIMobileEquipment)object).requestSetAutomaticEmergencyCallActive((Boolean)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIMobileEquipment)object).requestSetEnhancedPrivacyMode((Boolean)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSIMobileEquipment)object).requestSetMailboxContent((MailboxDialingNumber[])objectArray[0]);
                return null;
            }
            case 34: {
                ((DSIMobileEquipment)object).requestSetPrivacyMode((Boolean)objectArray[0]);
                return null;
            }
            case 35: {
                ((DSIMobileEquipment)object).requestSetHandsFreeMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 36: {
                ((DSIMobileEquipment)object).requestSetMICMuteState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 37: {
                ((DSIMobileEquipment)object).requestSetLanguage((String)objectArray[0]);
                return null;
            }
            case 38: {
                ((DSIMobileEquipment)object).requestDecreaseMicGainLevel((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 39: {
                ((DSIMobileEquipment)object).requestIncreaseMicGainLevel((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 40: {
                ((DSIMobileEquipment)object).requestSetOptimizationMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 41: {
                ((DSIMobileEquipment)object).requestUnlockOtherSIM(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 42: {
                ((DSIMobileEquipment)object).requestSetSIMAliases((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 43: {
                ((DSIMobileEquipment)object).requestSetNADMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 44: {
                ((DSIMobileEquipment)object).requestRemoveOtherSIM();
                return null;
            }
            case 45: {
                ((DSIMobileEquipment)object).requestSetPhoneReminderSetting((Boolean)objectArray[0]);
                return null;
            }
            case 46: {
                ((DSIMobileEquipment)object).requestSetPrefixActivated((Boolean)objectArray[0]);
                return null;
            }
            case 47: {
                ((DSIMobileEquipment)object).requestSetPrefixContent((String)objectArray[0]);
                return null;
            }
            case 48: {
                ((DSIMobileEquipment)object).requestSetPhoneRingtone(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 49: {
                ((DSIMobileEquipment)object).requestSetFavorites((org.dsi.ifc.telephoneng.Favorite[])objectArray[0]);
                return null;
            }
            case 50: {
                ((DSIMobileEquipment)object).requestSetSIMName((String)objectArray[0]);
                return null;
            }
            case 51: {
                ((DSIMobileEquipment)object).requestSetESIMActive((Boolean)objectArray[0]);
                return null;
            }
            case 52: {
                ((DSIMobileEquipment)object).deleteCallstacksAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 53: {
                ((DSIMobileEquipment)object).deleteCallstacksEntry(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSIMobileEquipment)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 55: {
                ((DSIMobileEquipment)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 56: {
                ((DSIMobileEquipment)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 57: {
                ((DSIMobileEquipment)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 58: {
                ((DSIMobileEquipment)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 59: {
                ((DSIMobileEquipment)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 60: {
                ((DSITelephone)object).restoreFactorySettings();
                return null;
            }
            case 61: {
                ((DSITelephone)object).requestNetworkSearch();
                return null;
            }
            case 62: {
                ((DSITelephone)object).requestSetMicGainLevel(((Number)objectArray[0]).intValue());
                return null;
            }
            case 63: {
                ((DSITelephone)object).requestNetworkRegistration((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSITelephone)object).requestAbortNetworkRegistration();
                return null;
            }
            case 65: {
                ((DSITelephone)object).requestAbortNetworkSearch();
                return null;
            }
            case 66: {
                ((DSITelephone)object).requestSetAutomaticPinEntryActive((Boolean)objectArray[0]);
                return null;
            }
            case 67: {
                ((DSITelephone)object).requestTelPower(((Number)objectArray[0]).intValue());
                return null;
            }
            case 68: {
                ((DSITelephone)object).requestUnlockSIM(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 69: {
                ((DSITelephone)object).requestCheckSIMPINCode((String)objectArray[0]);
                return null;
            }
            case 70: {
                ((DSITelephone)object).requestChangeSIMCode(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 71: {
                ((DSITelephone)object).requestSIMPINRequired((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 72: {
                ((DSITelephone)object).acceptCall(((Number)objectArray[0]).intValue());
                return null;
            }
            case 73: {
                ((DSITelephone)object).hangupCall(((Number)objectArray[0]).intValue());
                return null;
            }
            case 74: {
                ((DSITelephone)object).swapCalls();
                return null;
            }
            case 75: {
                ((DSITelephone)object).splitCall((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 76: {
                ((DSITelephone)object).joinCalls();
                return null;
            }
            case 77: {
                ((DSITelephone)object).dialNumber((String)objectArray[0]);
                return null;
            }
            case 78: {
                ((DSITelephone)object).dialOperator(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 79: {
                ((DSITelephone)object).dialNumberFromDBEntry((String)objectArray[0], ((Number)objectArray[1]).longValue(), (String)objectArray[2], (short)((Number)objectArray[3]).intValue(), (short)((Number)objectArray[4]).intValue(), (ResourceLocator)objectArray[5], ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue());
                return null;
            }
            case 80: {
                ((DSITelephone)object).sendDTMF((String)objectArray[0]);
                return null;
            }
            case 81: {
                ((DSITelephone)object).requestCallForward((CFRequestData[])objectArray[0]);
                return null;
            }
            case 82: {
                ((DSITelephone)object).requestCallWaiting(((Number)objectArray[0]).intValue());
                return null;
            }
            case 83: {
                ((DSITelephone)object).requestCLIR(((Number)objectArray[0]).intValue());
                return null;
            }
            case 84: {
                ((DSITelephone)object).requestServiceCodeAbort();
                return null;
            }
            case 85: {
                ((DSITelephone)object).requestSetAutomaticRedialActive((Boolean)objectArray[0]);
                return null;
            }
            case 86: {
                ((DSITelephone)object).requestSetCDMAThreeWayCallingSetting((Boolean)objectArray[0]);
                return null;
            }
            case 87: {
                ((DSITelephone)object).requestSetAutomaticEmergencyCallActive((Boolean)objectArray[0]);
                return null;
            }
            case 88: {
                ((DSITelephone)object).requestSetEnhancedPrivacyMode((Boolean)objectArray[0]);
                return null;
            }
            case 89: {
                ((DSITelephone)object).requestSetMailboxContent((org.dsi.ifc.telephone.MailboxDialingNumber[])objectArray[0]);
                return null;
            }
            case 90: {
                ((DSITelephone)object).requestSetPrivacyMode((Boolean)objectArray[0]);
                return null;
            }
            case 91: {
                ((DSITelephone)object).requestSetHandsFreeMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 92: {
                ((DSITelephone)object).requestSetMICMuteState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 93: {
                ((DSITelephone)object).requestSetLanguage((String)objectArray[0]);
                return null;
            }
            case 94: {
                ((DSITelephone)object).requestDecreaseMicGainLevel((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 95: {
                ((DSITelephone)object).requestIncreaseMicGainLevel((short)((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSITelephone)object).requestSetOptimizationMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 97: {
                ((DSITelephone)object).requestUnlockOtherSIM(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 98: {
                ((DSITelephone)object).requestSetSIMAliases((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 99: {
                ((DSITelephone)object).requestSetNADMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 100: {
                ((DSITelephone)object).requestRemoveOtherSIM();
                return null;
            }
            case 101: {
                ((DSITelephone)object).requestSetPhoneReminderSetting((Boolean)objectArray[0]);
                return null;
            }
            case 102: {
                ((DSITelephone)object).requestSetPrefixActivated((Boolean)objectArray[0]);
                return null;
            }
            case 103: {
                ((DSITelephone)object).requestSetPrefixContent((String)objectArray[0]);
                return null;
            }
            case 104: {
                ((DSITelephone)object).requestSetPhoneRingtone(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 105: {
                ((DSITelephone)object).requestSetFavorites((Favorite[])objectArray[0]);
                return null;
            }
            case 106: {
                ((DSITelephone)object).requestSetSIMName((String)objectArray[0]);
                return null;
            }
            case 107: {
                ((DSITelephone)object).requestSetESIMActive((Boolean)objectArray[0]);
                return null;
            }
            case 108: {
                ((DSITelephone)object).requestAbortAlternatePhoneActivity();
                return null;
            }
            case 109: {
                ((DSITelephone)object).requestTogglePrioritizedPhoneDevice();
                return null;
            }
            case 110: {
                ((DSITelephone)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 111: {
                ((DSITelephone)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 112: {
                ((DSITelephone)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 113: {
                ((DSITelephone)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 114: {
                ((DSITelephone)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 115: {
                ((DSITelephone)object).clearNotification((DSIListener)objectArray[0]);
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

