/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TrackData;
import org.dsi.ifc.asiainput.DSIAsiaInputListener;
import org.dsi.ifc.global.ResourceLocator;

public final class LR2a139477d
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1817560945: {
                if (bl) {
                    if (n2 != -1214164264) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1452453257: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1024892169: {
                if (bl) {
                    if (n2 != -2118374744) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -989177285: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -982786206: {
                if (bl) {
                    if (n2 != -1852591364) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -509017592: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -417107197: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -95488990: {
                if (bl) {
                    if (n2 != -1924501671) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -63251488: {
                if (bl) {
                    if (n2 != -714412959) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 57693828: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 148365439: {
                if (bl) {
                    if (n2 != -5823633) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 735187818: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 945646070: {
                if (bl) {
                    if (n2 != 2024348537) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1651271053: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1959296818: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 2001771482: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 2077502981: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2131904371: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1817704994: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1709058629: {
                if (bl) {
                    if (n2 != -1166448617) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1427451563: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1178238051: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1171993035: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -578748852: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -170139640: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -46570075: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 48501477: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 86151086: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 541871461: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 678021847: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1058327991: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1234020681: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1298086627: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1308933499: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1413371643: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1749432854: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
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
            case 41234659: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1179203875: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAndroidAuto2Listener)object).updateCallState((CallState[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIAndroidAuto2Listener)object).updateTelephonyState((TelephonyState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIAndroidAuto2Listener)object).updateNowPlayingData((TrackData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIAndroidAuto2Listener)object).updatePlaybackState((PlaybackInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIAndroidAuto2Listener)object).updatePlayposition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIAndroidAuto2Listener)object).updateCoverArtUrl((ResourceLocator)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIAndroidAuto2Listener)object).updateNavigationNextTurnEvent((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 7: {
                ((DSIAndroidAuto2Listener)object).updateNavigationNextTurnDistance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIAndroidAuto2Listener)object).setExternalDestination(((Number)objectArray[0]).doubleValue(), ((Number)objectArray[1]).doubleValue(), (String)objectArray[2], (String)objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 9: {
                ((DSIAndroidAuto2Listener)object).videoFocusRequestNotification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIAndroidAuto2Listener)object).videoAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIAndroidAuto2Listener)object).audioFocusRequestNotification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIAndroidAuto2Listener)object).audioAvailable(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSIAndroidAuto2Listener)object).voiceSessionNotification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIAndroidAuto2Listener)object).microphoneRequestNotification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIAndroidAuto2Listener)object).navFocusRequestNotification(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIAndroidAuto2Listener)object).bluetoothPairingRequest((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIAndroidAuto2Listener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSIAsiaInputListener)object).initialized(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIAsiaInputListener)object).getSpelling((String)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSIAsiaInputListener)object).getCandidates((String[])objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIAsiaInputListener)object).getBooleanParameter(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIAsiaInputListener)object).getIntParameter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIAsiaInputListener)object).getVersionInfo((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSIAsiaInputListener)object).getStringParameter(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSIAsiaInputListener)object).getSegmentation((String)objectArray[0]);
                return null;
            }
            case 26: {
                ((DSIAsiaInputListener)object).builtCandidates(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((DSIAsiaInputListener)object).selectedCandidate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSIAsiaInputListener)object).indicateErrorStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSIAsiaInputListener)object).indicateDataInvalidated(((Number)objectArray[0]).intValue());
                return null;
            }
            case 30: {
                ((DSIAsiaInputListener)object).setIntParameterResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 31: {
                ((DSIAsiaInputListener)object).setBooleanParameterResult(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIAsiaInputListener)object).setStringParameterResult(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 33: {
                ((DSIAsiaInputListener)object).setAdditionalWordDatabasesResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 34: {
                ((DSIAsiaInputListener)object).setUserDatabaseStateResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 35: {
                ((DSIAsiaInputListener)object).resetToFactorySettingsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 36: {
                ((DSIAsiaInputListener)object).responseSegmentationForTruffles((String)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSIAsiaInputListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

