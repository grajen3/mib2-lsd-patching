/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.reflection.generated.mma;

import de.vw.mib.asl.internal.navigation.startup.HsmTargetAslEventPrinter;
import de.vw.mib.asl.internal.navigation.startup.HsmTargetNavigation;
import de.vw.mib.asl.internal.navigation.startup.NavStartupTarget;
import de.vw.mib.asl.internal.navigation.startup.groups.NaviStartupGroup;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBase;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public final class LR2a904de28
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -924224178: {
                if (bl) {
                    if (n2 != 431709920) break;
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
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 363915840: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 694660662: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 738944297: {
                if (bl) {
                    if (n2 != 504480724) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1288519190: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2069003643: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1948234569: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1365379190: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -434290411: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -343589543: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -334433001: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -186826831: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -172355639: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -75307658: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 280769031: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1735809323: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1954531172: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
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
            case -1683020154: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -49270190: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 804945921: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 1863507990: {
                n2 = this.a2(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((HsmTargetAslEventPrinter)object).registerDevice((Class)objectArray[0]);
                return null;
            }
            case 1: {
                ((HsmTargetNavigation)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 2: {
                ((HsmTargetNavigation)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((HsmTargetNavigation)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((NavStartupTarget)object).changed((KnowledgeBase)objectArray[0]);
                return null;
            }
            case 5: {
                ((NavStartupTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((NavStartupTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((NavStartupTarget)object).dsiNavigationUpdateNavstateOfOperation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((NavStartupTarget)object).dsiStartupUpdateDomainStatusNav(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((NavStartupTarget)object).onStartupStateChanged(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                return ((NaviStartupGroup)object).getName();
            }
            case 11: {
                return RuntimeUtil.valueOf(((NaviStartupGroup)object).getTrafficLightState());
            }
            case 12: {
                return RuntimeUtil.valueOf(((NaviStartupGroup)object).getTransitionOldState());
            }
            case 13: {
                return RuntimeUtil.valueOf(((NaviStartupGroup)object).getTransitionNewState());
            }
            case 14: {
                return ((NaviStartupGroup)object).getGroupMembers();
            }
            case 15: {
                ((NaviStartupGroup)object).setTrafficLightState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((NaviStartupGroup)object).sendPowerOnSignal();
                return null;
            }
            case 17: {
                ((NaviStartupGroup)object).sendGreenToYellowSignal();
                return null;
            }
            case 18: {
                ((NaviStartupGroup)object).sendYellowToRedSignal();
                return null;
            }
            case 19: {
                ((NaviStartupGroup)object).sendRedToYellowSignal();
                return null;
            }
            case 20: {
                ((NaviStartupGroup)object).sendYellowToGreenSignal();
                return null;
            }
            case 21: {
                return ((NaviStartupGroup)object).getGuard();
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

