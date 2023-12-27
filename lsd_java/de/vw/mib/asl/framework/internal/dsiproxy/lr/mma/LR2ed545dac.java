/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSITIMTuner;
import org.dsi.ifc.radio.DSITunerAnnouncement;

public final class LR2ed545dac
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1859771682: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 3;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 4;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 5;
                    break;
                }
                n3 = 3;
                break;
            }
            case -948729267: {
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
            case 108404676: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1879169168: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
            case 92612005: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 206906607: {
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
            case -1745959947: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -137228872: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSITIMTuner)object).reset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSITIMTuner)object).playback(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSITIMTuner)object).jumpPlayback(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSITIMTuner)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSITIMTuner)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSITIMTuner)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSITIMTuner)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSITIMTuner)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSITIMTuner)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSITunerAnnouncement)object).setFilter(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSITunerAnnouncement)object).abort(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSITunerAnnouncement)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSITunerAnnouncement)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSITunerAnnouncement)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSITunerAnnouncement)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSITunerAnnouncement)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSITunerAnnouncement)object).clearNotification((DSIListener)objectArray[0]);
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

