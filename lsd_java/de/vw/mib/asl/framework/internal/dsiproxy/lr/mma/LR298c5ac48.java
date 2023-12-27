/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.upnp.DSIUPNPPlayerListener;
import org.dsi.ifc.upnp.DeviceInfo;
import org.dsi.ifc.upnp.EntryInfo;
import org.dsi.ifc.upnp.PlaybackMode;
import org.dsi.ifc.waveplayer.DSIWavePlayerListener;

public final class LR298c5ac48
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
            case -1546029788: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1462191177: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1407529512: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -426881091: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1348628102: {
                if (bl) {
                    if (n2 != 416856863) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -982786206: {
                if (bl) {
                    if (n2 != -1261696176) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -924533157: {
                if (bl) {
                    if (n2 != -1940116817) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -859139144: {
                if (bl) {
                    if (n2 != -1261696176) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -502753230: {
                if (bl) {
                    if (n2 != 1896024787) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 383756348: {
                if (bl) {
                    if (n2 != -1261696176) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1974653117: {
                if (bl) {
                    if (n2 != 224462384) break;
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
            case -1769379914: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -689327761: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIWavePlayerListener)object).setPlayTone(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIWavePlayerListener)object).updateAudioRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIWavePlayerListener)object).updatePlayTone(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIWavePlayerListener)object).audioTriggerResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIWavePlayerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIUPNPPlayerListener)object).updatePlaybackState((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSIUPNPPlayerListener)object).updateVolume((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSIUPNPPlayerListener)object).updateDeviceList((DeviceInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIUPNPPlayerListener)object).updatePlaybackModeList((String)objectArray[0], (PlaybackMode[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((DSIUPNPPlayerListener)object).updatePlaybackMode((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((DSIUPNPPlayerListener)object).updatePlayPosition((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 11: {
                ((DSIUPNPPlayerListener)object).updateDetailInfo((String)objectArray[0], (EntryInfo)objectArray[1], (ResourceLocator)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 12: {
                ((DSIUPNPPlayerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

