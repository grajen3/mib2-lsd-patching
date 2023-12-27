/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.reflection.generated.mma;

import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public final class LR2ac6e964c
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
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1710802708: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1547918303: {
                if (bl) {
                    if (n2 != -1214164264) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1455383258: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1309669857: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1220189975: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1001644092: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -950794095: {
                if (bl) {
                    if (n2 != -5823633) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -883437929: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -864679556: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -804777819: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -214341212: {
                if (bl) {
                    if (n2 != 1427760290) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
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
            case 157696589: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
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
            case 310212133: {
                if (bl) {
                    if (n2 != -2118374744) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 445754996: {
                if (bl) {
                    if (n2 != -1852591364) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
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
            case 702451638: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 794362033: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1238537396: {
                if (bl) {
                    if (n2 != -1924501671) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1271852814: {
                if (bl) {
                    if (n2 != -714412959) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 2001412786: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
            case -1402038708: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((AndroidAutoTarget)object).shutdown();
                return null;
            }
            case 1: {
                ((AndroidAutoTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((AndroidAutoTarget)object).initializeDSI();
                return null;
            }
            case 3: {
                return ((AndroidAutoTarget)object).getDSIAndroidAuto2();
            }
            case 4: {
                ((AndroidAutoTarget)object).startup();
                return null;
            }
            case 5: {
                ((AndroidAutoTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                return ((AndroidAutoTarget)object).getRequestHandler();
            }
            case 7: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2VideoFocusRequestNotification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2VideoAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2AudioFocusRequestNotification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2AudioAvailable(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2VoiceSessionNotification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2MicrophoneRequestNotification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2NavFocusRequestNotification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2UpdateCallState((CallState[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2UpdateTelephonyState((TelephonyState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2UpdateNowPlayingData((TrackData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2UpdatePlaybackState((PlaybackInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2UpdatePlayposition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2UpdateCoverArtUrl((ResourceLocator)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2UpdateNavigationNextTurnEvent((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 21: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2UpdateNavigationNextTurnDistance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 22: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2SetExternalDestination(((Number)objectArray[0]).doubleValue(), ((Number)objectArray[1]).doubleValue(), (String)objectArray[2], (String)objectArray[3]);
                return null;
            }
            case 23: {
                ((AndroidAutoTarget)object).dsiAndroidAuto2BluetoothPairingRequest((String)objectArray[0], ((Number)objectArray[1]).intValue());
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

