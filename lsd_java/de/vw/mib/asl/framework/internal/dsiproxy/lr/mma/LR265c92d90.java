/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.radio.DSITIMTunerListener;
import org.dsi.ifc.radio.DSITunerAnnouncementListener;
import org.dsi.ifc.radio.TIMMemoUsage;
import org.dsi.ifc.radio.TIMMessage;
import org.dsi.ifc.radio.TIMStatus;

public final class LR265c92d90
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1322747882: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -940737392: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 102137803: {
                if (bl) {
                    if (n2 != 1624584596) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1026015033: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
            case -1819975082: {
                if (bl) {
                    if (n2 != -2050863390) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 245720237: {
                if (bl) {
                    if (n2 != 2083706773) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1879169168: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 2054281515: {
                if (bl) {
                    if (n2 != 906631395) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 2107130607: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
            case -672371511: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 412566412: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSITunerAnnouncementListener)object).updateAvailability(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSITunerAnnouncementListener)object).updateFilter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSITunerAnnouncementListener)object).updateStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSITunerAnnouncementListener)object).updateStationName((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).longValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 4: {
                ((DSITunerAnnouncementListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSITIMTunerListener)object).playback(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSITIMTunerListener)object).updateTIMMessageList((TIMMessage[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSITIMTunerListener)object).updateTIMStatus((TIMStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSITIMTunerListener)object).updateTIMMemoUsage((TIMMemoUsage)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSITIMTunerListener)object).updateTIMAvailable(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSITIMTunerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

