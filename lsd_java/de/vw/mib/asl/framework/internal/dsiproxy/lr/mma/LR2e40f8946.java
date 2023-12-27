/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrument;
import org.dsi.ifc.navservicesapi.DSINavAsiaMapControl;

public final class LR2e40f8946
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1397036891: {
                if (bl) {
                    if (n2 != 17) break;
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
            case -1120720988: {
                if (bl) {
                    if (n2 != -786116603) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1109785482: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
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
            case -516658015: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 986924302: {
                if (bl) {
                    if (n2 != 17) break;
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
            case -2087789202: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1376832234: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 19;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 20;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 21;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1065716098: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 22;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 23;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 24;
                    break;
                }
                n3 = 22;
                break;
            }
            case -478361433: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -404330924: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -403497588: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1565443572: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1679818385: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
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
            case -1070769064: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1060992743: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSINavAsiaMapControl)object).setViewType(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSINavAsiaMapControl)object).setZoomLevel(((Number)objectArray[0]).floatValue());
                return null;
            }
            case 2: {
                ((DSINavAsiaMapControl)object).sendToResume();
                return null;
            }
            case 3: {
                ((DSINavAsiaMapControl)object).sendToSuspend();
                return null;
            }
            case 4: {
                ((DSINavAsiaMapControl)object).setDataRate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSINavAsiaMapControl)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSINavAsiaMapControl)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSINavAsiaMapControl)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSINavAsiaMapControl)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSINavAsiaMapControl)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSINavAsiaMapControl)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSINavAsiaBAPClusterInstrument)object).dmLastDestinationsGet(((Number)objectArray[0]).longValue());
                return null;
            }
            case 12: {
                ((DSINavAsiaBAPClusterInstrument)object).startRouteGuidance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 13: {
                ((DSINavAsiaBAPClusterInstrument)object).stopRouteGuidance();
                return null;
            }
            case 14: {
                ((DSINavAsiaBAPClusterInstrument)object).repeatLastNavAnnouncement();
                return null;
            }
            case 15: {
                ((DSINavAsiaBAPClusterInstrument)object).abortCurrentNavAnnouncement();
                return null;
            }
            case 16: {
                ((DSINavAsiaBAPClusterInstrument)object).setVoiceGuidanceState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSINavAsiaBAPClusterInstrument)object).setActiveRGType(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSINavAsiaBAPClusterInstrument)object).confirmTrafficInfoMessage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSINavAsiaBAPClusterInstrument)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSINavAsiaBAPClusterInstrument)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSINavAsiaBAPClusterInstrument)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSINavAsiaBAPClusterInstrument)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSINavAsiaBAPClusterInstrument)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSINavAsiaBAPClusterInstrument)object).clearNotification((DSIListener)objectArray[0]);
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

