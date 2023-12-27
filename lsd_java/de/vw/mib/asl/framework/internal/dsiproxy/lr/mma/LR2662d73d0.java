/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.upnp.DSIUPNPPlayer;
import org.dsi.ifc.upnp.ListEntry;
import org.dsi.ifc.waveplayer.DSIWavePlayer;

public final class LR2662d73d0
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
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
            case -426881091: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1648719735: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 2045840230: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -934425950: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -402420139: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 3526893: {
                if (bl) {
                    if (n2 != -1261696176) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 3532788: {
                if (bl) {
                    if (n2 != -1261696176) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 106440811: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 415439473: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 670515345: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1288892365: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1391381413: {
                if (bl) {
                    if (n2 != -1422006502) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
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
            case -665322526: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 561385115: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIWavePlayer)object).audioTrigger(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIWavePlayer)object).audioTriggerDefaultTone(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIWavePlayer)object).setPlayTone(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIWavePlayer)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSIWavePlayer)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIWavePlayer)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIWavePlayer)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIWavePlayer)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIWavePlayer)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIUPNPPlayer)object).resume((String)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIUPNPPlayer)object).skip((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((DSIUPNPPlayer)object).setEntry((String[])objectArray[0], (String)objectArray[1], (ListEntry[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 12: {
                ((DSIUPNPPlayer)object).setVolume((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIUPNPPlayer)object).decreaseVolume((String)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIUPNPPlayer)object).increaseVolume((String)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSIUPNPPlayer)object).setPlaybackMode((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIUPNPPlayer)object).pause((String)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIUPNPPlayer)object).seek((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSIUPNPPlayer)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIUPNPPlayer)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIUPNPPlayer)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIUPNPPlayer)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIUPNPPlayer)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIUPNPPlayer)object).clearNotification((DSIListener)objectArray[0]);
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

