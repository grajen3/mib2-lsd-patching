/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener;
import org.dsi.ifc.telephone.DSINADListener;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.ServiceProvider;

public final class LR25c07becd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1297490190: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -457462713: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -277588663: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1883716167: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1948712827: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
            case -2035071097: {
                if (bl) {
                    if (n2 != 1960351444) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1745511364: {
                if (bl) {
                    if (n2 != 576851223) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1453614118: {
                if (bl) {
                    if (n2 != -953354753) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1301834822: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1293476197: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1277924181: {
                if (bl) {
                    if (n2 != 248057213) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1273043613: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1190354646: {
                if (bl) {
                    if (n2 != -1314144535) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1121773759: {
                if (bl) {
                    if (n2 != -1673465575) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -194880640: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -61250232: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 0x5020522: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 122630695: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 139922165: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 264457682: {
                if (bl) {
                    if (n2 != 1070156060) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 705134733: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1214636148: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1226924594: {
                if (bl) {
                    if (n2 != 1780461108) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1397170023: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1826392083: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 2079876731: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 2125803708: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
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
            case -2118020080: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -1693623566: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMobileSpeechRecognitionListener)object).updateSpeechRecognitionAvailable(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIMobileSpeechRecognitionListener)object).updateSpeechRecognitionActive(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIMobileSpeechRecognitionListener)object).updateSpeechRecognitionType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIMobileSpeechRecognitionListener)object).responseStartSpeechRecognition(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIMobileSpeechRecognitionListener)object).responseStopSpeechRecognition(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSIMobileSpeechRecognitionListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSINADListener)object).responseRestoreFactorySettings(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((DSINADListener)object).responseNetworkSearch((NetworkProvider[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSINADListener)object).updateSignalQuality(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSINADListener)object).responseAbortNetworkRegistration(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSINADListener)object).responseAbortNetworkSearch(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSINADListener)object).responseChangeSIMCode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSINADListener)object).responseSIMPINRequired(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSINADListener)object).updateSIMPINRequired((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSINADListener)object).responseNetworkRegistration(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSINADListener)object).responseUnlockSIM(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSINADListener)object).responseCheckSIMPINCode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSINADListener)object).responseTelPower(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSINADListener)object).responseSetAutomaticPinEntryActive(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSINADListener)object).updateActivationState((ActivationStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSINADListener)object).updateAutomaticPinEntryActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSINADListener)object).updateLockState((LockStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSINADListener)object).updateNADTemperature((NADTemperatureStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSINADListener)object).updatePhoneInformation((PhoneInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSINADListener)object).updateNetworkProvider((NetworkProviderName)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSINADListener)object).updateNetworkType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSINADListener)object).updateRegisterState((RegisterStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSINADListener)object).updateServiceProvider((ServiceProvider)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSINADListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

