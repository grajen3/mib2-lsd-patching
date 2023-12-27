/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbDataResolution;
import org.dsi.ifc.organizer.DSIAdbEdit;

public final class LR2792e8bbd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1796345126: {
                if (bl) {
                    if (n2 != -1633563384) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1678650089: {
                if (bl) {
                    if (n2 != -1938851384) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
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
            case -927250936: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -860761759: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -554712369: {
                if (bl) {
                    if (n2 != -1633563384) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -393156500: {
                if (bl) {
                    if (n2 != -1633563384) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -127327314: {
                if (bl) {
                    if (n2 != -1938851384) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -103597942: {
                if (bl) {
                    if (n2 != -1927201080) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1481493618: {
                if (bl) {
                    if (n2 != -238538240) break;
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
            case -1229241452: {
                if (bl) {
                    if (n2 != -1166448617) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1175001219: {
                if (bl) {
                    if (n2 != -1166448617) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
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
            case -1429566103: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 441826005: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAdbEdit)object).getEntries((long[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 1: {
                ((DSIAdbEdit)object).insertEntry((AdbEntry)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIAdbEdit)object).getEntryDataSets((long[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIAdbEdit)object).changeEntry((AdbEntry)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIAdbEdit)object).copyEntry(((Number)objectArray[0]).longValue());
                return null;
            }
            case 5: {
                ((DSIAdbEdit)object).deleteEntries((long[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSIAdbEdit)object).setSpeedDial((AdbEntry)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIAdbEdit)object).deleteSpeedDial(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSIAdbEdit)object).getEntryByReferenceId((String)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIAdbEdit)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIAdbEdit)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIAdbEdit)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIAdbEdit)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIAdbEdit)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIAdbEdit)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSIAdbDataResolution)object).resolveMailAddresses((String[])objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIAdbDataResolution)object).resolvePhoneNumbers((String[])objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIAdbDataResolution)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIAdbDataResolution)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIAdbDataResolution)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSIAdbDataResolution)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIAdbDataResolution)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIAdbDataResolution)object).clearNotification((DSIListener)objectArray[0]);
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

