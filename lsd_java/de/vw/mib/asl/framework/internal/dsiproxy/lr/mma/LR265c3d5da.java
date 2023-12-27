/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.iconhandling.DSIIconExtractor;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder;

public final class LR265c3d5da
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2077782700: {
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
            case 59580714: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 341392617: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 918176320: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1097980939: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2031778739: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1781389178: {
                if (bl) {
                    if (n2 != -386243565) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 28;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 29;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 30;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1087488700: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 31;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 32;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 33;
                    break;
                }
                n3 = 31;
                break;
            }
            case -850787404: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -761467371: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -654579608: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -448927240: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -253455248: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -67007770: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 25448117: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 158279157: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 914477695: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1082079194: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1404317990: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1698568951: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1961312125: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 2102754590: {
                if (bl) {
                    if (n2 != 1043255048) break;
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
            case 1155205232: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1914413087: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIInfotainmentRecorder)object).logPanelName((String)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIInfotainmentRecorder)object).logKeyEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSIInfotainmentRecorder)object).backupTrigger(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIInfotainmentRecorder)object).enableTrigger((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIInfotainmentRecorder)object).logInit();
                return null;
            }
            case 5: {
                ((DSIInfotainmentRecorder)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIInfotainmentRecorder)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIInfotainmentRecorder)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIInfotainmentRecorder)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIInfotainmentRecorder)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIInfotainmentRecorder)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIIconExtractor)object).resourceIdForTMCEventIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSIIconExtractor)object).resourceIdForPOIIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSIIconExtractor)object).renderingInformationForRoadIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSIIconExtractor)object).resourceIdForTargetIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIIconExtractor)object).resourceIdForRoadClassIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSIIconExtractor)object).resourceIdForTrafficRegulationIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 17: {
                ((DSIIconExtractor)object).renderingInformationForExitIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSIIconExtractor)object).resourceIdForAdditionalIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((DSIIconExtractor)object).resourceIdForCountryIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIIconExtractor)object).resourceIdForTrafficRegulationIconWithSubindex(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 21: {
                ((DSIIconExtractor)object).renderingInformationForExitIconWithVariant(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 22: {
                ((DSIIconExtractor)object).setBrandIconStyle((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIIconExtractor)object).resourceIdForAdditionalTurnListIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 24: {
                ((DSIIconExtractor)object).resourceIdForTrafficSourceIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIIconExtractor)object).resourceIdForAreaWarningIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSIIconExtractor)object).resourceIdForComposedPOIIcon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (int[])objectArray[3]);
                return null;
            }
            case 27: {
                ((DSIIconExtractor)object).resourceIdForPOIIconFromRawData(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 28: {
                ((DSIIconExtractor)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIIconExtractor)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIIconExtractor)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 31: {
                ((DSIIconExtractor)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIIconExtractor)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 33: {
                ((DSIIconExtractor)object).clearNotification((DSIListener)objectArray[0]);
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

