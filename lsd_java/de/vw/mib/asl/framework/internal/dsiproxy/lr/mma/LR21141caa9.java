/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.ddp20.DSIDDP20Listener;
import org.dsi.ifc.ddp20.DisplayStatus;
import org.dsi.ifc.ddp20.VersionInfo;
import org.dsi.ifc.diagnose.DSIComponentProtectionListener;

public final class LR21141caa9
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1811799471: {
                if (bl) {
                    if (n2 != 1931103883) break;
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
            case -1862532224: {
                if (bl) {
                    if (n2 != -1565518548) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
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
            case -698943677: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -450948206: {
                if (bl) {
                    if (n2 != 1949137921) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1270204976: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
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
            case -1049941821: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 482666735: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIComponentProtectionListener)object).authStringResponse((String)objectArray[0], (String)objectArray[1], (byte)((Number)objectArray[2]).intValue());
                return null;
            }
            case 1: {
                ((DSIComponentProtectionListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSIDDP20Listener)object).updateVersionInfo((VersionInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIDDP20Listener)object).updatePowerStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIDDP20Listener)object).updateDisplayStatus((DisplayStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIDDP20Listener)object).updateBufferStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIDDP20Listener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

