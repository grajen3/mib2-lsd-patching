/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.dsi.ifc.tollcollect.DSITollCollect;

public final class LR214a11a9b
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1998376440: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1328024546: {
                if (bl) {
                    if (n2 != 571278) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 5;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 6;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 7;
                    break;
                }
                n3 = 5;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 8;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 9;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 10;
                    break;
                }
                n3 = 8;
                break;
            }
            case -582671508: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -119574210: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 813805751: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
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
                        n3 = 14;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 15;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 16;
                    break;
                }
                n3 = 14;
                break;
            }
            case -948729267: {
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
            case -271584806: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 677544144: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
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
            case -2088631761: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 316066885: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSITmcOnRoute)object).getTmcMessage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSITmcOnRoute)object).setTmcWarningMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSITmcOnRoute)object).blockTMCMessages((long[])objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSITmcOnRoute)object).unblockTMCMessages((long[])objectArray[0]);
                return null;
            }
            case 4: {
                ((DSITmcOnRoute)object).unblockAllTMCMessages();
                return null;
            }
            case 5: {
                ((DSITmcOnRoute)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSITmcOnRoute)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSITmcOnRoute)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSITmcOnRoute)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSITmcOnRoute)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSITmcOnRoute)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSITollCollect)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSITollCollect)object).requestPaymentHistoryList();
                return null;
            }
            case 13: {
                ((DSITollCollect)object).requestPaymentHistoryDetails(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSITollCollect)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSITollCollect)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSITollCollect)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSITollCollect)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSITollCollect)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSITollCollect)object).clearNotification((DSIListener)objectArray[0]);
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

