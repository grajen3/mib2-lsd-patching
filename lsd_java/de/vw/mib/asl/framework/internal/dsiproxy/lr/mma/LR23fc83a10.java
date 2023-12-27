/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travelguide.DSITravelGuide;
import org.dsi.ifc.travellink.DSITravelLinkCommon;
import org.dsi.ifc.travellink.GenericProperty;

public final class LR23fc83a10
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 1;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 2;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 3;
                    break;
                }
                n3 = 1;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 4;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 5;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 6;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1292926668: {
                if (bl) {
                    if (n2 != 1294717150) break;
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
            case -249190452: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1635785106: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
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
            case 1098586522: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1972593103: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSITravelLinkCommon)object).requestToApp(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (GenericProperty[])objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue());
                return null;
            }
            case 1: {
                ((DSITravelLinkCommon)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 2: {
                ((DSITravelLinkCommon)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSITravelLinkCommon)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSITravelLinkCommon)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSITravelLinkCommon)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSITravelLinkCommon)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSITravelGuide)object).importTravelGuide((ResourceLocator)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSITravelGuide)object).deleteTravelGuide(((Number)objectArray[0]).longValue());
                return null;
            }
            case 9: {
                ((DSITravelGuide)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSITravelGuide)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSITravelGuide)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSITravelGuide)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSITravelGuide)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSITravelGuide)object).clearNotification((DSIListener)objectArray[0]);
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

