/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.reflection.generated.mma;

import de.vw.mib.asl.internal.carplay.target.HsmTarget;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;

public final class LR26095dea6
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1897184014: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1869954951: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1829309609: {
                if (bl) {
                    if (n2 != -85186737) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1717973306: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -586546608: {
                if (bl) {
                    if (n2 != 1692260465) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -386212156: {
                if (bl) {
                    if (n2 != 232310419) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -169342773: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 482268799: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 921253135: {
                if (bl) {
                    if (n2 != -85186737) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1053767493: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1254043825: {
                if (bl) {
                    if (n2 != -1717684416) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1635544533: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1636730827: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1919312389: {
                if (bl) {
                    if (n2 != -1716859319) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 2067272200: {
                if (bl) {
                    if (n2 != 17) break;
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
            case 1620434598: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((HsmTarget)object).shutdown();
                return null;
            }
            case 1: {
                ((HsmTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((HsmTarget)object).initializeDSI();
                return null;
            }
            case 3: {
                return ((HsmTarget)object).getDSICarPlay();
            }
            case 4: {
                ((HsmTarget)object).startup();
                return null;
            }
            case 5: {
                ((HsmTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((HsmTarget)object).dsiCarplayUpdateMode((Resource[])objectArray[0], (AppState[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((HsmTarget)object).dsiCarplayUpdateDeviceInfo((DeviceInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((HsmTarget)object).dsiCarplayUpdateCallState((CallState[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((HsmTarget)object).dsiCarplayUpdateTelephonyState((TelephonyState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((HsmTarget)object).dsiCarplayUpdateAnnouncementStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((HsmTarget)object).dsiCarplayOemAppSelected();
                return null;
            }
            case 12: {
                ((HsmTarget)object).dsiCarplayUpdateMainAudioType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((HsmTarget)object).dsiCarplayResponseModeChange((Resource[])objectArray[0], (AppState[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((HsmTarget)object).dsiCarplayDuckAudio(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).doubleValue());
                return null;
            }
            case 15: {
                ((HsmTarget)object).dsiCarplayUnduckAudio(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                return ((HsmTarget)object).getClusterService();
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

