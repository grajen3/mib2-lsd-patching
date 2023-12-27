/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sdars.DSISDARSSeek;
import org.dsi.ifc.sdars.DSISDARSTuner;

public final class LR2ce06c823
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1292997461: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1173679347: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 11;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 12;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 13;
                    break;
                }
                n3 = 11;
                break;
            }
            case -948729267: {
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
            case -888088509: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -118017247: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -75121224: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 299720925: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1943706245: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1800755214: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1162471198: {
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
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 30;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 31;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 32;
                    break;
                }
                n3 = 30;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 0xAA0CCA: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 971877990: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1087320675: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
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
            case -1465059609: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1829182261: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISDARSTuner)object).reset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSISDARSTuner)object).getTime();
                return null;
            }
            case 2: {
                ((DSISDARSTuner)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSISDARSTuner)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSISDARSTuner)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSISDARSTuner)object).profileResetAll();
                return null;
            }
            case 6: {
                ((DSISDARSTuner)object).selectStation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSISDARSTuner)object).getEPG24Hour(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSISDARSTuner)object).getEPGDescription(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSISDARSTuner)object).notifyHMIReady(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSISDARSTuner)object).setRadioText2Config(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSISDARSTuner)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSISDARSTuner)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSISDARSTuner)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSISDARSTuner)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSISDARSTuner)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSISDARSTuner)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSISDARSSeek)object).reset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSISDARSSeek)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSISDARSSeek)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSISDARSSeek)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSISDARSSeek)object).profileResetAll();
                return null;
            }
            case 22: {
                ((DSISDARSSeek)object).setSeekCommand(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 23: {
                ((DSISDARSSeek)object).manageSeek(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSISDARSSeek)object).manageSeek2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 25: {
                ((DSISDARSSeek)object).getTeamsOfLeague(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSISDARSSeek)object).getLeagues();
                return null;
            }
            case 27: {
                ((DSISDARSSeek)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSISDARSSeek)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSISDARSSeek)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSISDARSSeek)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSISDARSSeek)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSISDARSSeek)object).clearNotification((DSIListener)objectArray[0]);
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

