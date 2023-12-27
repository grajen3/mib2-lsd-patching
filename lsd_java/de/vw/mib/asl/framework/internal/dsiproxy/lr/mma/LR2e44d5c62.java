/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.bap.DSIBAP;
import org.dsi.ifc.base.DSIListener;

public final class LR2e44d5c62
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1273258099: {
                if (bl) {
                    if (n2 != -577675501) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 6;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 7;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 8;
                    break;
                }
                n3 = 6;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 9;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 10;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 11;
                    break;
                }
                n3 = 9;
                break;
            }
            case 346441700: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1003355883: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1095693572: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1150147384: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1279210286: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2115230193: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -2001184537: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1912048891: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -1660487025: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1602892619: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -1573625709: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -1527575678: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -1506128839: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1434543195: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1273310571: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -1162471198: {
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
            case -1160159917: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -1136822210: {
                if (bl) {
                    if (n2 != -1627529622) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1058446765: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -977904465: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -966480785: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -956978615: {
                if (bl) {
                    if (n2 != -1627529622) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 94;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 95;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 96;
                    break;
                }
                n3 = 94;
                break;
            }
            case -833083703: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -651648451: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -625247743: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case -527813139: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -504362941: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -372145909: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case -292229073: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case -218877199: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -217901925: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -157528833: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -75664950: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -40040710: {
                if (bl) {
                    if (n2 != -1627529622) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -2691445: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 36057370: {
                if (bl) {
                    if (n2 != -1627529622) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 57295678: {
                if (bl) {
                    if (n2 != 252948384) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 96804551: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 122482761: {
                if (bl) {
                    if (n2 != 826925271) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 151981292: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 259950354: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 329331411: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 360724907: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 397988363: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case 407057164: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 415439473: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 577247075: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 615800779: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 621674240: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 630744475: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 670515345: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 697675035: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 702131727: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 707727955: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 712659138: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 764040326: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 801238966: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 830417855: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 833925777: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 885132421: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 932217493: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 1011580975: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 1019770841: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 1025434184: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1028981273: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1031982501: {
                if (bl) {
                    if (n2 != 252948384) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1116534621: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 1184426597: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 1214762277: {
                if (bl) {
                    if (n2 != -1627529622) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 1234177799: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1288892365: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1391901865: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1440866485: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 1781188767: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 1912670902: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1918003107: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 1939972396: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1953014325: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 1984444630: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 2034300897: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 2124842294: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
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
            case 765536296: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1275236623: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIBAP)object).request(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 1: {
                ((DSIBAP)object).getBAPState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIBAP)object).setHMIState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIBAP)object).requestVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIBAP)object).requestByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (byte[])objectArray[3]);
                return null;
            }
            case 5: {
                ((DSIBAP)object).requestError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSIBAP)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIBAP)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIBAP)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIBAP)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIBAP)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIBAP)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSISound)object).getVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSISound)object).setVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSISound)object).decreaseVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSISound)object).increaseVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSISound)object).getBalance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSISound)object).setBalance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSISound)object).decreaseBalance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((DSISound)object).increaseBalance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 20: {
                ((DSISound)object).getBass(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSISound)object).setBass(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 22: {
                ((DSISound)object).decreaseBass(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 23: {
                ((DSISound)object).increaseBass(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 24: {
                ((DSISound)object).getTreble(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSISound)object).setTreble(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 26: {
                ((DSISound)object).decreaseTreble(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 27: {
                ((DSISound)object).increaseTreble(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 28: {
                ((DSISound)object).getFader(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSISound)object).setFader(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 30: {
                ((DSISound)object).decreaseFader(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 31: {
                ((DSISound)object).increaseFader(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSISound)object).getSubwoofer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSISound)object).setSubwoofer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 34: {
                ((DSISound)object).getInputGainOffset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSISound)object).setInputGainOffset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 36: {
                ((DSISound)object).getInputGainOffsetRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSISound)object).getLoweringEntertainment(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 38: {
                ((DSISound)object).setLoweringEntertainment(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue());
                return null;
            }
            case 39: {
                ((DSISound)object).getMenuVolEntRange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 40: {
                ((DSISound)object).getMenuVolumeRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSISound)object).getVolumeRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSISound)object).getSurroundLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((DSISound)object).setSurroundLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 44: {
                ((DSISound)object).setSurroundOnOff(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 45: {
                ((DSISound)object).revertToFactorySettings(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSISound)object).createExportFile((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 47: {
                ((DSISound)object).importFile((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 48: {
                ((DSISound)object).getMiddle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSISound)object).setMiddle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 50: {
                ((DSISound)object).decreaseMiddle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 51: {
                ((DSISound)object).increaseMiddle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 52: {
                ((DSISound)object).setEqualizer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 53: {
                ((DSISound)object).increaseEqualizer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue());
                return null;
            }
            case 54: {
                ((DSISound)object).decreaseEqualizer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue());
                return null;
            }
            case 55: {
                ((DSISound)object).getEqualizer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSISound)object).setOnVolumeLimit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 57: {
                ((DSISound)object).increaseOnVolumeLimit((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 58: {
                ((DSISound)object).decreaseOnVolumeLimit((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 59: {
                ((DSISound)object).decreaseSubwoofer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 60: {
                ((DSISound)object).increaseSubwoofer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 61: {
                ((DSISound)object).decreaseInputGainOffset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 62: {
                ((DSISound)object).increaseInputGainOffset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 63: {
                ((DSISound)object).decreaseLoweringEntertainment(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSISound)object).increaseLoweringEntertainment(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue());
                return null;
            }
            case 65: {
                ((DSISound)object).decreaseSurroundLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 66: {
                ((DSISound)object).increaseSurroundLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 67: {
                ((DSISound)object).setMicGainLevel(((Number)objectArray[0]).intValue());
                return null;
            }
            case 68: {
                ((DSISound)object).decreaseMicGainLevel((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 69: {
                ((DSISound)object).increaseMicGainLevel((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 70: {
                ((DSISound)object).getNoiseCompensation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 71: {
                ((DSISound)object).setNoiseCompensation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 72: {
                ((DSISound)object).increaseNoiseCompensation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 73: {
                ((DSISound)object).decreaseNoiseCompensation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 74: {
                ((DSISound)object).getPresetEQ(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((DSISound)object).setPresetEQ(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 76: {
                ((DSISound)object).getPresetPosition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 77: {
                ((DSISound)object).setPresetPosition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 78: {
                ((DSISound)object).get3DMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 79: {
                ((DSISound)object).set3DMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 80: {
                ((DSISound)object).setSubwooferActivity(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 81: {
                ((DSISound)object).setWidebandSpeech(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 82: {
                ((DSISound)object).setDuration(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 83: {
                ((DSISound)object).getSoundShapeActive();
                return null;
            }
            case 84: {
                ((DSISound)object).setSoundShapeActive((Boolean)objectArray[0]);
                return null;
            }
            case 85: {
                ((DSISound)object).getSoundShape();
                return null;
            }
            case 86: {
                ((DSISound)object).setSoundShape((short)((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 87: {
                ((DSISound)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 88: {
                ((DSISound)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((DSISound)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 90: {
                ((DSISound)object).profileResetAll();
                return null;
            }
            case 91: {
                ((DSISound)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 92: {
                ((DSISound)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 93: {
                ((DSISound)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 94: {
                ((DSISound)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 95: {
                ((DSISound)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSISound)object).clearNotification((DSIListener)objectArray[0]);
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

