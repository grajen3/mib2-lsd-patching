/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;
import org.dsi.ifc.tmc.DSITmc;

public final class LR2bfb2f7bb
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1498388224: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1162471198: {
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
            case -948729267: {
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
            case -593855598: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 317812593: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 691386944: {
                if (bl) {
                    if (n2 != 193699049) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1767583018: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1786178460: {
                if (bl) {
                    if (n2 != -1653679357) break;
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
            case -1162471198: {
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
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 16;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 17;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 18;
                    break;
                }
                n3 = 16;
                break;
            }
            case -145021661: {
                if (bl) {
                    if (n2 != 3523) break;
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
            case -975005203: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 636664559: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSITmc)object).requestTmcWindow(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (int[])objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 1: {
                ((DSITmc)object).setMessageFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSITmc)object).getMessageIdsForListElement(((Number)objectArray[0]).longValue());
                return null;
            }
            case 3: {
                ((DSITmc)object).getBoundingRectangleForTrafficMessages((long[])objectArray[0]);
                return null;
            }
            case 4: {
                ((DSITmc)object).enableAreaWarnings((Boolean)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSITmc)object).enableTrafficFlowStatistics((Boolean)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSITmc)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSITmc)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSITmc)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSITmc)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSITmc)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSITmc)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIMobileEquipmentTopology)object).requestChangeTopology((int[])objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIMobileEquipmentTopology)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIMobileEquipmentTopology)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIMobileEquipmentTopology)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIMobileEquipmentTopology)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIMobileEquipmentTopology)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIMobileEquipmentTopology)object).clearNotification((DSIListener)objectArray[0]);
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

