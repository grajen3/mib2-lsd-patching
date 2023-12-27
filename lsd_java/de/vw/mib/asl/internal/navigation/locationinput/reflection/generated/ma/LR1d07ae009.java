/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.reflection.generated.ma;

import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.api.navigation.locationinput.ILocationinputResultListener;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.reflection.MethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public final class LR1d07ae009
extends MethodAccessibleObject {
    @Override
    public int getIndex(String string, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case -2142640248: {
                if (bl) {
                    if (n != 769423948) break;
                    n2 = 8;
                    break;
                }
                n2 = 8;
                break;
            }
            case -2107695365: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 92;
                    break;
                }
                n2 = 92;
                break;
            }
            case -2107554528: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 40;
                    break;
                }
                n2 = 40;
                break;
            }
            case -2105852194: {
                if (bl) {
                    if (n != 1687814400) break;
                    n2 = 76;
                    break;
                }
                n2 = 76;
                break;
            }
            case -2057147421: {
                if (bl) {
                    if (n != 941556127) break;
                    n2 = 22;
                    break;
                }
                n2 = 22;
                break;
            }
            case -2037823258: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 65;
                    break;
                }
                n2 = 65;
                break;
            }
            case -1777055755: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 17;
                    break;
                }
                n2 = 17;
                break;
            }
            case -1776921375: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 26;
                    break;
                }
                n2 = 26;
                break;
            }
            case -1751737551: {
                if (bl) {
                    if (n != 941556127) break;
                    n2 = 80;
                    break;
                }
                n2 = 80;
                break;
            }
            case -1693928994: {
                if (bl) {
                    if (n != 536494077) break;
                    n2 = 6;
                    break;
                }
                n2 = 6;
                break;
            }
            case -1602234589: {
                if (bl) {
                    if (n != 119221243) break;
                    n2 = 88;
                    break;
                }
                n2 = 88;
                break;
            }
            case -1601049455: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 14;
                    break;
                }
                n2 = 14;
                break;
            }
            case -1583627656: {
                if (bl) {
                    if (n == 1146276422) {
                        n2 = 81;
                        break;
                    }
                    if (n == 545081975) {
                        n2 = 82;
                        break;
                    }
                    if (n != 1892534951) break;
                    n2 = 83;
                    break;
                }
                n2 = 81;
                break;
            }
            case -1317534195: {
                if (bl) {
                    if (n != 769423948) break;
                    n2 = 9;
                    break;
                }
                n2 = 9;
                break;
            }
            case -1295482316: {
                if (bl) {
                    if (n != 142371135) break;
                    n2 = 100;
                    break;
                }
                n2 = 100;
                break;
            }
            case -1267019238: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 23;
                    break;
                }
                n2 = 23;
                break;
            }
            case -1245843985: {
                if (bl) {
                    if (n != 1687814400) break;
                    n2 = 60;
                    break;
                }
                n2 = 60;
                break;
            }
            case -1188210659: {
                if (bl) {
                    if (n != -645498553) break;
                    n2 = 18;
                    break;
                }
                n2 = 18;
                break;
            }
            case -1039745188: {
                if (bl) {
                    if (n == 17) {
                        n2 = 47;
                        break;
                    }
                    if (n == -633848249) {
                        n2 = 48;
                        break;
                    }
                    if (n == -645498553) {
                        n2 = 49;
                        break;
                    }
                    if (n != -412271469) break;
                    n2 = 50;
                    break;
                }
                n2 = 47;
                break;
            }
            case -1039689282: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 103;
                    break;
                }
                n2 = 103;
                break;
            }
            case -1037974651: {
                if (bl) {
                    if (n != -1789419218) break;
                    n2 = 21;
                    break;
                }
                n2 = 21;
                break;
            }
            case -1031920601: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 67;
                    break;
                }
                n2 = 67;
                break;
            }
            case -1021236453: {
                if (bl) {
                    if (n != 812283452) break;
                    n2 = 15;
                    break;
                }
                n2 = 15;
                break;
            }
            case -1004925137: {
                if (bl) {
                    if (n != 3523) break;
                    n2 = 91;
                    break;
                }
                n2 = 91;
                break;
            }
            case -1002704747: {
                if (bl) {
                    if (n != 1687814400) break;
                    n2 = 74;
                    break;
                }
                n2 = 74;
                break;
            }
            case -934829276: {
                if (bl) {
                    if (n != 1687814400) break;
                    n2 = 24;
                    break;
                }
                n2 = 24;
                break;
            }
            case -930384543: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 7;
                    break;
                }
                n2 = 7;
                break;
            }
            case -902467299: {
                if (bl) {
                    if (n != 1676164096) break;
                    n2 = 52;
                    break;
                }
                n2 = 52;
                break;
            }
            case -872176832: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 56;
                    break;
                }
                n2 = 56;
                break;
            }
            case -867854447: {
                if (bl) {
                    if (n != -171986214) break;
                    n2 = 3;
                    break;
                }
                n2 = 3;
                break;
            }
            case -856560405: {
                if (bl) {
                    if (n != 1687814400) break;
                    n2 = 71;
                    break;
                }
                n2 = 71;
                break;
            }
            case -793335424: {
                if (bl) {
                    if (n == 1146276422) {
                        n2 = 72;
                        break;
                    }
                    if (n != 1892534951) break;
                    n2 = 73;
                    break;
                }
                n2 = 72;
                break;
            }
            case -690212584: {
                if (bl) {
                    if (n == 529159989) {
                        n2 = 27;
                        break;
                    }
                    if (n != -8237007) break;
                    n2 = 28;
                    break;
                }
                n2 = 27;
                break;
            }
            case -648752264: {
                if (bl) {
                    if (n != 1676164096) break;
                    n2 = 85;
                    break;
                }
                n2 = 85;
                break;
            }
            case -648752155: {
                if (bl) {
                    if (n == 929905823) {
                        n2 = 86;
                        break;
                    }
                    if (n != 1687814400) break;
                    n2 = 87;
                    break;
                }
                n2 = 86;
                break;
            }
            case -625671924: {
                if (bl) {
                    if (n == 1687814400) {
                        n2 = 57;
                        break;
                    }
                    if (n != 1676164096) break;
                    n2 = 58;
                    break;
                }
                n2 = 57;
                break;
            }
            case -579218292: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 51;
                    break;
                }
                n2 = 51;
                break;
            }
            case -89496179: {
                if (bl) {
                    if (n != 1687814400) break;
                    n2 = 75;
                    break;
                }
                n2 = 75;
                break;
            }
            case 3237667: {
                if (bl) {
                    if (n == 17) {
                        n2 = 41;
                        break;
                    }
                    if (n == -633848249) {
                        n2 = 42;
                        break;
                    }
                    if (n == -645498553) {
                        n2 = 43;
                        break;
                    }
                    if (n != -412271469) break;
                    n2 = 44;
                    break;
                }
                n2 = 41;
                break;
            }
            case 3527165: {
                if (bl) {
                    if (n == 1043255048) {
                        n2 = 29;
                        break;
                    }
                    if (n != 941556127) break;
                    n2 = 30;
                    break;
                }
                n2 = 29;
                break;
            }
            case 3642346: {
                if (bl) {
                    if (n == -238538240) {
                        n2 = 97;
                        break;
                    }
                    if (n == -266965504) {
                        n2 = 98;
                        break;
                    }
                    if (n != 17) break;
                    n2 = 99;
                    break;
                }
                n2 = 97;
                break;
            }
            case 3642619: {
                if (bl) {
                    if (n == 17) {
                        n2 = 36;
                        break;
                    }
                    if (n == -633848249) {
                        n2 = 37;
                        break;
                    }
                    if (n == -645498553) {
                        n2 = 38;
                        break;
                    }
                    if (n != -412271469) break;
                    n2 = 39;
                    break;
                }
                n2 = 36;
                break;
            }
            case 33523374: {
                if (bl) {
                    if (n != 3523) break;
                    n2 = 61;
                    break;
                }
                n2 = 61;
                break;
            }
            case 35807427: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 53;
                    break;
                }
                n2 = 53;
                break;
            }
            case 72298373: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 4;
                    break;
                }
                n2 = 4;
                break;
            }
            case 77113527: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 64;
                    break;
                }
                n2 = 64;
                break;
            }
            case 96785533: {
                if (bl) {
                    if (n == 17) {
                        n2 = 31;
                        break;
                    }
                    if (n == -633848249) {
                        n2 = 32;
                        break;
                    }
                    if (n == -645498553) {
                        n2 = 33;
                        break;
                    }
                    if (n == -412271469) {
                        n2 = 34;
                        break;
                    }
                    if (n != -504091551) break;
                    n2 = 35;
                    break;
                }
                n2 = 31;
                break;
            }
            case 97204089: {
                if (bl) {
                    if (n == 17) {
                        n2 = 45;
                        break;
                    }
                    if (n != -633848249) break;
                    n2 = 46;
                    break;
                }
                n2 = 45;
                break;
            }
            case 110621626: {
                if (bl) {
                    if (n == 17) {
                        n2 = 93;
                        break;
                    }
                    if (n == -633848249) {
                        n2 = 94;
                        break;
                    }
                    if (n == -645498553) {
                        n2 = 95;
                        break;
                    }
                    if (n != -412271469) break;
                    n2 = 96;
                    break;
                }
                n2 = 93;
                break;
            }
            case 147697296: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 101;
                    break;
                }
                n2 = 101;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 1;
                    break;
                }
                n2 = 1;
                break;
            }
            case 834463203: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 25;
                    break;
                }
                n2 = 25;
                break;
            }
            case 836015793: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 89;
                    break;
                }
                n2 = 89;
                break;
            }
            case 913196443: {
                if (bl) {
                    if (n != -298597974) break;
                    n2 = 19;
                    break;
                }
                n2 = 19;
                break;
            }
            case 937414990: {
                if (bl) {
                    if (n != 1687814400) break;
                    n2 = 90;
                    break;
                }
                n2 = 90;
                break;
            }
            case 989766402: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 12;
                    break;
                }
                n2 = 12;
                break;
            }
            case 1050475726: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 13;
                    break;
                }
                n2 = 13;
                break;
            }
            case 1092786220: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 62;
                    break;
                }
                n2 = 62;
                break;
            }
            case 1115162348: {
                if (bl) {
                    if (n != -1789419218) break;
                    n2 = 20;
                    break;
                }
                n2 = 20;
                break;
            }
            case 1148211862: {
                if (bl) {
                    if (n != -16271474) break;
                    n2 = 70;
                    break;
                }
                n2 = 70;
                break;
            }
            case 1246906116: {
                if (bl) {
                    if (n != 941556127) break;
                    n2 = 79;
                    break;
                }
                n2 = 79;
                break;
            }
            case 1247412650: {
                if (bl) {
                    if (n != 941556127) break;
                    n2 = 78;
                    break;
                }
                n2 = 78;
                break;
            }
            case 1333867741: {
                if (bl) {
                    if (n != -1653679357) break;
                    n2 = 16;
                    break;
                }
                n2 = 16;
                break;
            }
            case 1348766600: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 66;
                    break;
                }
                n2 = 66;
                break;
            }
            case 1409347744: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 10;
                    break;
                }
                n2 = 10;
                break;
            }
            case 1411644586: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 2;
                    break;
                }
                n2 = 2;
                break;
            }
            case 1416259875: {
                if (bl) {
                    if (n != 1676164096) break;
                    n2 = 5;
                    break;
                }
                n2 = 5;
                break;
            }
            case 1442884091: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 63;
                    break;
                }
                n2 = 63;
                break;
            }
            case 1547369347: {
                if (bl) {
                    if (n != 1687814400) break;
                    n2 = 55;
                    break;
                }
                n2 = 55;
                break;
            }
            case 1619641048: {
                if (bl) {
                    if (n != 1687814400) break;
                    n2 = 84;
                    break;
                }
                n2 = 84;
                break;
            }
            case 1635949175: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 54;
                    break;
                }
                n2 = 54;
                break;
            }
            case 1658266712: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 11;
                    break;
                }
                n2 = 11;
                break;
            }
            case 1729664393: {
                if (bl) {
                    if (n != 1676164096) break;
                    n2 = 0;
                    break;
                }
                n2 = 0;
                break;
            }
            case 1838155015: {
                if (bl) {
                    if (n == 1687814400) {
                        n2 = 68;
                        break;
                    }
                    if (n != -1600866162) break;
                    n2 = 69;
                    break;
                }
                n2 = 68;
                break;
            }
            case 1902066701: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 104;
                    break;
                }
                n2 = 104;
                break;
            }
            case 1916831157: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 77;
                    break;
                }
                n2 = 77;
                break;
            }
            case 1950569015: {
                if (bl) {
                    if (n != 17) break;
                    n2 = 102;
                    break;
                }
                n2 = 102;
                break;
            }
            case 2078988081: {
                if (bl) {
                    if (n != 3523) break;
                    n2 = 59;
                    break;
                }
                n2 = 59;
                break;
            }
        }
        return n2;
    }

    @Override
    public Object invoke(int n, Object object, Object[] objectArray) {
        try {
            switch (n) {
                case 0: {
                    return XSpellerTarget.getHandler(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                }
                case 1: {
                    return ((XSpellerTarget)object).getLogger();
                }
                case 2: {
                    return ((XSpellerTarget)object).getDefaultWorkState();
                }
                case 3: {
                    ((XSpellerTarget)object).setSpellerContext((SpellerContext)objectArray[0]);
                    return null;
                }
                case 4: {
                    return ((XSpellerTarget)object).getSpellerContext();
                }
                case 5: {
                    ((XSpellerTarget)object).selectHandler(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 6: {
                    XSpellerTarget.addHandler(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (SpellerHandler)objectArray[2]);
                    return null;
                }
                case 7: {
                    return ((XSpellerTarget)object).getCurrentContext();
                }
                case 8: {
                    XSpellerTarget.startSpeller((SpellerHandler)objectArray[0]);
                    return null;
                }
                case 9: {
                    XSpellerTarget.saveSpeller((SpellerHandler)objectArray[0]);
                    return null;
                }
                case 10: {
                    ((XSpellerTarget)object).freezeAllLists();
                    return null;
                }
                case 11: {
                    return XSpellerTarget.getExtCurrentLocation();
                }
                case 12: {
                    return XSpellerTarget.getExtAvailableSelectionCriteria();
                }
                case 13: {
                    return RuntimeUtil.valueOf(XSpellerTarget.isExtInputActive());
                }
                case 14: {
                    return RuntimeUtil.valueOf(XSpellerTarget.getExtIsFullPostalCode());
                }
                case 15: {
                    XSpellerTarget.changeExtInterfaceList((LIValueList)objectArray[0], ((Number)objectArray[1]).longValue(), (IHnrFlags)objectArray[2]);
                    return null;
                }
                case 16: {
                    XSpellerTarget.changeExtInterfaceInputActive((Boolean)objectArray[0]);
                    return null;
                }
                case 17: {
                    XSpellerTarget.extInputHapticTakesOver();
                    return null;
                }
                case 18: {
                    XSpellerTarget.extInputErrorMessage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 19: {
                    XSpellerTarget.changeExtLocation((NavLocation)objectArray[0], (int[])objectArray[1], (Boolean)objectArray[2]);
                    return null;
                }
                case 20: {
                    XSpellerTarget.registerListener((ILocationinputResultListener)objectArray[0]);
                    return null;
                }
                case 21: {
                    XSpellerTarget.unregisterListener((ILocationinputResultListener)objectArray[0]);
                    return null;
                }
                case 22: {
                    ((XSpellerTarget)object).gotEvent((EventGeneric)objectArray[0]);
                    return null;
                }
                case 23: {
                    return ((XSpellerTarget)object).getMyShortName();
                }
                case 24: {
                    ((XSpellerTarget)object).regEvt(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 25: {
                    return RuntimeUtil.valueOf(((XSpellerTarget)object).isFuntionNameTracing());
                }
                case 26: {
                    return ((XSpellerTarget)object).toString();
                }
                case 27: {
                    ((XSpellerTarget)object).register((GenericEvents)objectArray[0]);
                    return null;
                }
                case 28: {
                    ((XSpellerTarget)object).register((GenericEvents)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                    return null;
                }
                case 29: {
                    ((XSpellerTarget)object).send(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                    return null;
                }
                case 30: {
                    ((XSpellerTarget)object).send((EventGeneric)objectArray[0]);
                    return null;
                }
                case 31: {
                    return ((XSpellerTarget)object).error();
                }
                case 32: {
                    ((XSpellerTarget)object).error((String)objectArray[0]);
                    return null;
                }
                case 33: {
                    ((XSpellerTarget)object).error((String)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 34: {
                    ((XSpellerTarget)object).error((String)objectArray[0], (String)objectArray[1]);
                    return null;
                }
                case 35: {
                    ((XSpellerTarget)object).error((Throwable)objectArray[0]);
                    return null;
                }
                case 36: {
                    return ((XSpellerTarget)object).warn();
                }
                case 37: {
                    ((XSpellerTarget)object).warn((String)objectArray[0]);
                    return null;
                }
                case 38: {
                    ((XSpellerTarget)object).warn((String)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 39: {
                    ((XSpellerTarget)object).warn((String)objectArray[0], (String)objectArray[1]);
                    return null;
                }
                case 40: {
                    return ((XSpellerTarget)object).getEventDispatcher();
                }
                case 41: {
                    return ((XSpellerTarget)object).info();
                }
                case 42: {
                    ((XSpellerTarget)object).info((String)objectArray[0]);
                    return null;
                }
                case 43: {
                    ((XSpellerTarget)object).info((String)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 44: {
                    ((XSpellerTarget)object).info((String)objectArray[0], (String)objectArray[1]);
                    return null;
                }
                case 45: {
                    return ((XSpellerTarget)object).fatal();
                }
                case 46: {
                    ((XSpellerTarget)object).fatal((String)objectArray[0]);
                    return null;
                }
                case 47: {
                    return ((XSpellerTarget)object).normal();
                }
                case 48: {
                    ((XSpellerTarget)object).normal((String)objectArray[0]);
                    return null;
                }
                case 49: {
                    ((XSpellerTarget)object).normal((String)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 50: {
                    ((XSpellerTarget)object).normal((String)objectArray[0], (String)objectArray[1]);
                    return null;
                }
                case 51: {
                    return RuntimeUtil.valueOf(((XSpellerTarget)object).getClassifier());
                }
                case 52: {
                    ((XSpellerTarget)object).signal(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 53: {
                    return ((XSpellerTarget)object).getMainObject();
                }
                case 54: {
                    return RuntimeUtil.valueOf(((XSpellerTarget)object).getTargetId());
                }
                case 55: {
                    ((XSpellerTarget)object).setTargetId(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 56: {
                    return RuntimeUtil.valueOf(((XSpellerTarget)object).getSubClassifier());
                }
                case 57: {
                    ((XSpellerTarget)object).addObserver(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 58: {
                    ((XSpellerTarget)object).addObserver(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 59: {
                    ((XSpellerTarget)object).addObservers((int[])objectArray[0]);
                    return null;
                }
                case 60: {
                    ((XSpellerTarget)object).removeObserver(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 61: {
                    ((XSpellerTarget)object).removeObservers((int[])objectArray[0]);
                    return null;
                }
                case 62: {
                    return RuntimeUtil.valueOf(((XSpellerTarget)object).getDefaultTargetId());
                }
                case 63: {
                    return ((XSpellerTarget)object).getEventFactory();
                }
                case 64: {
                    return ((XSpellerTarget)object).getServiceRegister();
                }
                case 65: {
                    return ((XSpellerTarget)object).getShortName();
                }
                case 66: {
                    return ((XSpellerTarget)object).getTextLogger();
                }
                case 67: {
                    return ((XSpellerTarget)object).getTimerServer();
                }
                case 68: {
                    ((XSpellerTarget)object).registerService(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 69: {
                    ((XSpellerTarget)object).registerService(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                    return null;
                }
                case 70: {
                    ((XSpellerTarget)object).registerServices((int[])objectArray[0], (Boolean)objectArray[1]);
                    return null;
                }
                case 71: {
                    ((XSpellerTarget)object).restartTimer(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 72: {
                    ((XSpellerTarget)object).retriggerOrStartTimer((EventGeneric)objectArray[0], ((Number)objectArray[1]).longValue(), (boolean)((Boolean)objectArray[2]));
                    return null;
                }
                case 73: {
                    ((XSpellerTarget)object).retriggerOrStartTimer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (boolean)((Boolean)objectArray[2]));
                    return null;
                }
                case 74: {
                    ((XSpellerTarget)object).retriggerTimer(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 75: {
                    ((XSpellerTarget)object).resumeTimer(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 76: {
                    ((XSpellerTarget)object).suspendTimer(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 77: {
                    return RuntimeUtil.valueOf(((XSpellerTarget)object).isQueueOverloaded());
                }
                case 78: {
                    ((XSpellerTarget)object).sendSafe((EventGeneric)objectArray[0]);
                    return null;
                }
                case 79: {
                    ((XSpellerTarget)object).sendBack((EventGeneric)objectArray[0]);
                    return null;
                }
                case 80: {
                    ((XSpellerTarget)object).sendBackSafe((EventGeneric)objectArray[0]);
                    return null;
                }
                case 81: {
                    ((XSpellerTarget)object).startTimer((EventGeneric)objectArray[0], ((Number)objectArray[1]).longValue(), (boolean)((Boolean)objectArray[2]));
                    return null;
                }
                case 82: {
                    ((XSpellerTarget)object).startTimer((EventGeneric)objectArray[0], ((Number)objectArray[1]).longValue(), (Boolean)objectArray[2], (Boolean)objectArray[3]);
                    return null;
                }
                case 83: {
                    ((XSpellerTarget)object).startTimer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (boolean)((Boolean)objectArray[2]));
                    return null;
                }
                case 84: {
                    ((XSpellerTarget)object).stopTimer(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 85: {
                    ((XSpellerTarget)object).triggerIt(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 86: {
                    ((XSpellerTarget)object).triggerMe((EventGeneric)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 87: {
                    ((XSpellerTarget)object).triggerMe(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 88: {
                    ((XSpellerTarget)object).triggerObserver(((Number)objectArray[0]).intValue(), (EventGeneric)objectArray[1]);
                    return null;
                }
                case 89: {
                    ((XSpellerTarget)object).unregister();
                    return null;
                }
                case 90: {
                    ((XSpellerTarget)object).unregisterService(((Number)objectArray[0]).intValue());
                    return null;
                }
                case 91: {
                    ((XSpellerTarget)object).unregisterServices((int[])objectArray[0]);
                    return null;
                }
                case 92: {
                    return RuntimeUtil.valueOf(((XSpellerTarget)object).isTraceEnabled());
                }
                case 93: {
                    return ((XSpellerTarget)object).trace();
                }
                case 94: {
                    ((XSpellerTarget)object).trace((String)objectArray[0]);
                    return null;
                }
                case 95: {
                    ((XSpellerTarget)object).trace((String)objectArray[0], ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 96: {
                    ((XSpellerTarget)object).trace((String)objectArray[0], (String)objectArray[1]);
                    return null;
                }
                case 97: {
                    ((XSpellerTarget)object).wait(((Number)objectArray[0]).longValue());
                    return null;
                }
                case 98: {
                    ((XSpellerTarget)object).wait(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                    return null;
                }
                case 99: {
                    ((XSpellerTarget)object).wait();
                    return null;
                }
                case 100: {
                    return RuntimeUtil.valueOf(((XSpellerTarget)object).equals(objectArray[0]));
                }
                case 101: {
                    return RuntimeUtil.valueOf(((XSpellerTarget)object).hashCode());
                }
                case 102: {
                    return ((XSpellerTarget)object).getClass();
                }
                case 103: {
                    ((XSpellerTarget)object).notify();
                    return null;
                }
                case 104: {
                    ((XSpellerTarget)object).notifyAll();
                    return null;
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

