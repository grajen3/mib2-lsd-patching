/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.reflection.generated.mma;

import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public final class LR278fd854b
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2117711178: {
                if (bl) {
                    if (n2 != -2062025617) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1897184014: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1880343092: {
                if (bl) {
                    if (n2 != -513227954) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1870076863: {
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
            case -1471459711: {
                if (bl) {
                    if (n2 != -820350045) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1197266567: {
                if (bl) {
                    if (n2 != -1214164264) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1169423383: {
                if (bl) {
                    if (n2 != -1014726651) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -942236016: {
                if (bl) {
                    if (n2 != -1646303317) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
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
            case 192566018: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
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
            case 1060079249: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1259403139: {
                if (bl) {
                    if (n2 != -820350045) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1595381272: {
                if (bl) {
                    if (n2 != -1676902285) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1700098694: {
                if (bl) {
                    if (n2 != -1924501671) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
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
            case 2029880651: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((CarlifeHSMTarget)object).shutdown();
                return null;
            }
            case 1: {
                ((CarlifeHSMTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((CarlifeHSMTarget)object).initializeDSI();
                return null;
            }
            case 3: {
                return ((CarlifeHSMTarget)object).getDSICarLife();
            }
            case 4: {
                ((CarlifeHSMTarget)object).startup();
                return null;
            }
            case 5: {
                ((CarlifeHSMTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((CarlifeHSMTarget)object).dsiCarlifeResponseSetMode((Resource[])objectArray[0], (AppState[])objectArray[1]);
                return null;
            }
            case 7: {
                ((CarlifeHSMTarget)object).dsiCarlifeUpdateCallState((CallState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((CarlifeHSMTarget)object).dsiCarlifeUpdateNowPlayingData((TrackData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((CarlifeHSMTarget)object).dsiCarlifeUpdatePlaybackState((PlaybackInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((CarlifeHSMTarget)object).dsiCarlifeUpdatePlaymodeState((PlaymodeInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((CarlifeHSMTarget)object).dsiCarlifeUpdatePlayposition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((CarlifeHSMTarget)object).dsiCarlifeUpdateCoverArtUrl((ResourceLocator)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((CarlifeHSMTarget)object).dsiCarlifeUpdateNavigationNextTurnInfo((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 14: {
                ((CarlifeHSMTarget)object).dsiCarlifeUpdateDeviceInfo((DeviceInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((CarlifeHSMTarget)object).dsiCarlifeRequestModeChange((Resource[])objectArray[0], (AppState[])objectArray[1]);
                return null;
            }
            case 16: {
                ((CarlifeHSMTarget)object).dsiCarlifeUpdateVideoAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
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

