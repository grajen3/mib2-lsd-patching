/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener;
import org.dsi.ifc.komoview.DSIKOMOViewListener;

public final class LR23170aaa3
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2138173883: {
                if (bl) {
                    if (n2 != 134146313) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1655946990: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1476845600: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1130039092: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1024315771: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -816011646: {
                if (bl) {
                    if (n2 != 599185780) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -186561425: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 123665866: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1760987626: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1623572126: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1382252483: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1135068502: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 657642288: {
                if (bl) {
                    if (n2 != -1665395196) break;
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
            case -482032783: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1484811715: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIKOMONavInfoListener)object).setMapScale(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (boolean[])objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 1: {
                ((DSIKOMONavInfoListener)object).setMapScaleResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (boolean[])objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), (boolean[])objectArray[5], (Boolean)objectArray[6]);
                return null;
            }
            case 2: {
                ((DSIKOMONavInfoListener)object).setCurrentStreetResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIKOMONavInfoListener)object).setTurnToStreetResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIKOMONavInfoListener)object).setCityNameResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSIKOMONavInfoListener)object).setSemiDynRouteResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSIKOMONavInfoListener)object).setTrafficOffsetResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((DSIKOMONavInfoListener)object).setRgSelectResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSIKOMONavInfoListener)object).setCapabilitiesResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSIKOMONavInfoListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((DSIKOMOViewListener)object).updateKomoViewEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIKOMOViewListener)object).updateVisibility((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIKOMOViewListener)object).komoViewResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSIKOMOViewListener)object).updateCurrentKomoViewType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIKOMOViewListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

