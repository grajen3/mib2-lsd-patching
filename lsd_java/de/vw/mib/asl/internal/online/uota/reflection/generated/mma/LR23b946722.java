/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.reflection.generated.mma;

import de.vw.mib.asl.internal.online.ocu.states.OCUUpdateServiceTarget;
import de.vw.mib.asl.internal.online.states.OnlineUotATarget;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR23b946722
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -629596053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1422734460: {
                if (bl) {
                    if (n2 != 17) break;
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
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1645091874: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -821031927: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -538564205: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -166898601: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 20580406: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 539732108: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 628509090: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1117183153: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1868752686: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 2039195008: {
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
            case -1650963578: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -403504904: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case 303148010: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                return ((OCUUpdateServiceTarget)object).getUpdateServiceProvider();
            }
            case 1: {
                return ((OCUUpdateServiceTarget)object).getUpdateService();
            }
            case 2: {
                ((OnlineUotATarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((OnlineUotATarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((UotATarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((UotATarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                return ((UotATarget)object).getStateActive();
            }
            case 7: {
                return ((UotATarget)object).getStateActiveDownload();
            }
            case 8: {
                return ((UotATarget)object).getStateNotActive();
            }
            case 9: {
                return ((UotATarget)object).getStateActiveSWDL();
            }
            case 10: {
                return ((UotATarget)object).getStatePending();
            }
            case 11: {
                return ((UotATarget)object).getCurrentStateName();
            }
            case 12: {
                ((UotATarget)object).setRemainingNotifications();
                return null;
            }
            case 13: {
                return ((UotATarget)object).getDSIUotA();
            }
            case 14: {
                return ((UotATarget)object).getPropertyManager();
            }
            case 15: {
                ((UotATarget)object).updateUOTAServiceStatus((Boolean)objectArray[0]);
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

