/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.organizer.DSIAdbVCardExchange;

public final class LR2ea66fe38
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1982387028: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1561840676: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1436268152: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1162471198: {
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
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 12;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 13;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 14;
                    break;
                }
                n3 = 12;
                break;
            }
            case -244820613: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 269720529: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 993046141: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1239727402: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 2060466311: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 2095337004: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2104560697: {
                if (bl) {
                    if (n2 != 1395289481) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1258485222: {
                if (bl) {
                    if (n2 != -290076452) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 21;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 22;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 23;
                    break;
                }
                n3 = 21;
                break;
            }
            case -990415832: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -948729267: {
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
            case -503352449: {
                if (bl) {
                    if (n2 != 517707016) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1275036758: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1459217014: {
                if (bl) {
                    if (n2 != -619545686) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
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
            case -1320102487: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -206275148: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAdbUserProfile)object).downloadToProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIAdbUserProfile)object).restartDownload();
                return null;
            }
            case 2: {
                ((DSIAdbUserProfile)object).setProfileName((String)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIAdbUserProfile)object).deleteProfiles((int[])objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIAdbUserProfile)object).commonEntryCount();
                return null;
            }
            case 5: {
                ((DSIAdbUserProfile)object).entryMeter();
                return null;
            }
            case 6: {
                ((DSIAdbUserProfile)object).setPairingCode((String)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIAdbUserProfile)object).setHomeId(((Number)objectArray[0]).longValue());
                return null;
            }
            case 8: {
                ((DSIAdbUserProfile)object).setSOSButton((Boolean)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIAdbUserProfile)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIAdbUserProfile)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIAdbUserProfile)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIAdbUserProfile)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIAdbUserProfile)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIAdbUserProfile)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSIAdbVCardExchange)object).importVCard((ResourceLocator[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIAdbVCardExchange)object).exportVCard(((Number)objectArray[0]).intValue(), (String)objectArray[1], (long[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 17: {
                ((DSIAdbVCardExchange)object).exportSpellerVCard(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], (long[])objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 18: {
                ((DSIAdbVCardExchange)object).createVCard(((Number)objectArray[0]).intValue(), (long[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((DSIAdbVCardExchange)object).parseVCard((String)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSIAdbVCardExchange)object).requestAbort(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIAdbVCardExchange)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIAdbVCardExchange)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIAdbVCardExchange)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSIAdbVCardExchange)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSIAdbVCardExchange)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIAdbVCardExchange)object).clearNotification((DSIListener)objectArray[0]);
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

