/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.startup.DSIStartup;
import org.dsi.ifc.swap.DSISWaP;

public final class LR2d0d2563
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1381433595: {
                if (bl) {
                    if (n2 != 1094991504) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 10;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 11;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 12;
                    break;
                }
                n3 = 10;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 13;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 14;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 15;
                    break;
                }
                n3 = 13;
                break;
            }
            case -899182953: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -377407714: {
                if (bl) {
                    if (n2 != 1518699923) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -243775340: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 345387547: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 351986678: {
                if (bl) {
                    if (n2 != 1518699923) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 422372901: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1437295349: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1963795155: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 2124819895: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
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
                        n3 = 18;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 19;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 20;
                    break;
                }
                n3 = 18;
                break;
            }
            case -948729267: {
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
            case 1655814124: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1994602043: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
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
            case -1744321619: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1107740145: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISWaP)object).getPublicKey();
                return null;
            }
            case 1: {
                ((DSISWaP)object).getHistory();
                return null;
            }
            case 2: {
                ((DSISWaP)object).importFSCs(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSISWaP)object).encryptFile((String)objectArray[0], (String)objectArray[1], (byte[])objectArray[2]);
                return null;
            }
            case 4: {
                ((DSISWaP)object).checkSignature((String)objectArray[0], (short[])objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).longValue());
                return null;
            }
            case 5: {
                ((DSISWaP)object).checkSingleFsc(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSISWaP)object).decryptFile((String)objectArray[0], (String)objectArray[1], (byte[])objectArray[2]);
                return null;
            }
            case 7: {
                ((DSISWaP)object).getFscDetails(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSISWaP)object).triggerSoftwareEnabling();
                return null;
            }
            case 9: {
                ((DSISWaP)object).exportCCD(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSISWaP)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSISWaP)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSISWaP)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSISWaP)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSISWaP)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSISWaP)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIStartup)object).startDomain(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIStartup)object).hmiCompletelyStarted();
                return null;
            }
            case 18: {
                ((DSIStartup)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIStartup)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIStartup)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIStartup)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIStartup)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIStartup)object).clearNotification((DSIListener)objectArray[0]);
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

