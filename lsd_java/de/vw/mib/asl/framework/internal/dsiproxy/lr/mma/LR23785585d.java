/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombisync2.DSIKombiSync;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.MenuState;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;

public final class LR23785585d
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1282133194: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
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
            case -1091436121: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
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
            case 1115627747: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -1981032958: {
                if (bl) {
                    if (n2 != -386125191) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1581429679: {
                if (bl) {
                    if (n2 != 1149447382) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1525845956: {
                if (bl) {
                    if (n2 != -140383835) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1384822486: {
                if (bl) {
                    if (n2 != 75879518) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
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
            case 1537701: {
                if (bl) {
                    if (n2 != -2031391656) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1428476076: {
                if (bl) {
                    if (n2 != 309965865) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1817673086: {
                if (bl) {
                    if (n2 != 1683920002) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1889356396: {
                if (bl) {
                    if (n2 != -1653679357) break;
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
            case -1237055705: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -542092753: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIKOMOGfxStreamSink)object).setFGLayer(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIKOMOGfxStreamSink)object).fadeIn(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSIKOMOGfxStreamSink)object).fadeOut(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIKOMOGfxStreamSink)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSIKOMOGfxStreamSink)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIKOMOGfxStreamSink)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIKOMOGfxStreamSink)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIKOMOGfxStreamSink)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIKOMOGfxStreamSink)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIKombiSync)object).setHMIIsReady((Boolean)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIKombiSync)object).setMMIDisplayStatus((DisplayStatus)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIKombiSync)object).setMenuState((MenuState)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIKombiSync)object).setMMIDisplayRequestResponse((DisplayRequestResponse)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIKombiSync)object).setMMIPopupRegisterRequest((PopupRegisterRequestResponse)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIKombiSync)object).setMMIPopupActionResponse((PopupActionRequestResponse)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSIKombiSync)object).setMMIPopupStatus((PopupStatus)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIKombiSync)object).setMMIDisplayIdentification((DisplayIdentification)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIKombiSync)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIKombiSync)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIKombiSync)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSIKombiSync)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIKombiSync)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIKombiSync)object).clearNotification((DSIListener)objectArray[0]);
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

