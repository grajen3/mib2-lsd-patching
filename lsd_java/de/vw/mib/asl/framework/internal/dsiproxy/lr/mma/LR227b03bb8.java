/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navfleetservices.DSINavFleetServices;
import org.dsi.ifc.navigation.DSIBlocking;

public final class LR227b03bb8
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1477172850: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1162471198: {
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
            case -1148836841: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -948729267: {
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
            case -844776830: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -354059119: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -302908378: {
                if (bl) {
                    if (n2 != -784138677) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 871890223: {
                if (bl) {
                    if (n2 != -1319278436) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1948341063: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 2028208113: {
                if (bl) {
                    if (n2 != 1372686599) break;
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
            case -1065212043: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
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
            case -95166414: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1416847287: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 2002328410: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case 1348378256: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1838836761: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIBlocking)object).blockArea((NavLocationWgs84)objectArray[0], (NavLocationWgs84)objectArray[1]);
                return null;
            }
            case 1: {
                ((DSIBlocking)object).blockRouteSegments(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 2: {
                ((DSIBlocking)object).blockRoadSegments((NavLocation)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIBlocking)object).blockRouteBasedOnLength(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIBlocking)object).persistBlock((long[])objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIBlocking)object).deleteBlock((long[])objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIBlocking)object).setBlockDescription((long[])objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIBlocking)object).getBoundingRectangleOfBlocks((long[])objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIBlocking)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIBlocking)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIBlocking)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIBlocking)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIBlocking)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIBlocking)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSINavFleetServices)object).setVZOTrackerState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSINavFleetServices)object).setVZODownloadState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSINavFleetServices)object).setLGITrackerState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSINavFleetServices)object).setLGIDownloadState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSINavFleetServices)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSINavFleetServices)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSINavFleetServices)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSINavFleetServices)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSINavFleetServices)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSINavFleetServices)object).clearNotification((DSIListener)objectArray[0]);
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

