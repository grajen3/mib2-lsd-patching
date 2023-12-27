/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.bluetooth.DSIObexAuthentication;

public final class LR2aa55317d
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1599006013: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 17;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 18;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 19;
                    break;
                }
                n3 = 17;
                break;
            }
            case -992311248: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -973010196: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 20;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 21;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 22;
                    break;
                }
                n3 = 20;
                break;
            }
            case -302373318: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -264600241: {
                if (bl) {
                    if (n2 != -1261696176) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -201951969: {
                if (bl) {
                    if (n2 != -1261696176) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -188522580: {
                if (bl) {
                    if (n2 != -2051937305) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -122054705: {
                if (bl) {
                    if (n2 != -1432102577) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -118498774: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 15193845: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 99615405: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 114604041: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 226285009: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 829011440: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 960327736: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 2019048991: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 2086845376: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 24;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 25;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 26;
                    break;
                }
                n3 = 24;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 27;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 28;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 29;
                    break;
                }
                n3 = 27;
                break;
            }
            case 271361469: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
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
            case 447575279: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 761619975: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIBluetooth)object).abortConnectService((String)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIBluetooth)object).abortInquiry();
                return null;
            }
            case 2: {
                ((DSIBluetooth)object).requestAcceptIncomingServiceRequest((String)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 3: {
                ((DSIBluetooth)object).requestConnectService((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIBluetooth)object).requestConnectServiceToInstance((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIBluetooth)object).requestDisconnectService((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIBluetooth)object).requestGetServices((String)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIBluetooth)object).requestInquiry(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIBluetooth)object).requestPasskeyResponse((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((DSIBluetooth)object).requestReconnectSuspend((Boolean)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIBluetooth)object).requestRemoveAuthentication((String)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIBluetooth)object).requestRestoreFactorySettings();
                return null;
            }
            case 12: {
                ((DSIBluetooth)object).requestSetA2DPUserSetting((Boolean)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIBluetooth)object).requestSwitchBTState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIBluetooth)object).setAccessibleMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSIBluetooth)object).setUserFriendlyName((String)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIBluetooth)object).requestSetPriorizedDeviceReconnect((Boolean)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIBluetooth)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIBluetooth)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIBluetooth)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSIBluetooth)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIBluetooth)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIBluetooth)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 23: {
                ((DSIObexAuthentication)object).setAuthenticationInfo(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 24: {
                ((DSIObexAuthentication)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSIObexAuthentication)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIObexAuthentication)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSIObexAuthentication)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSIObexAuthentication)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIObexAuthentication)object).clearNotification((DSIListener)objectArray[0]);
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

