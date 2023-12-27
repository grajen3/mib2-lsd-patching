/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.online.DSIOnlineESIMTrafficNotificationListener;
import org.dsi.ifc.online.DSIOnlinePicNavListener;
import org.dsi.ifc.online.PicNavSyncInfo;

public final class LR297c4d7c8
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
            case 535889011: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 771520392: {
                if (bl) {
                    if (n2 != -1418507585) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 818914955: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1782882306: {
                if (bl) {
                    if (n2 != -1418507585) break;
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
            case -1924064869: {
                if (bl) {
                    if (n2 != -1261696176) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
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
            case 399174119: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 661720026: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIOnlinePicNavListener)object).updateSyncStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIOnlinePicNavListener)object).synchronizeResult(((Number)objectArray[0]).intValue(), (PicNavSyncInfo)objectArray[1]);
                return null;
            }
            case 2: {
                ((DSIOnlinePicNavListener)object).getPendingTransactionsResult(((Number)objectArray[0]).intValue(), (PicNavSyncInfo)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSIOnlinePicNavListener)object).setActiveProfileResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIOnlinePicNavListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIOnlineESIMTrafficNotificationListener)object).updateESIMNotification((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSIOnlineESIMTrafficNotificationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

