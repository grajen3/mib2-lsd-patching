/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognition;
import org.dsi.ifc.telephone.DSINAD;

public final class LR2d438db55
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2016516841: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 2;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 3;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 4;
                    break;
                }
                n3 = 2;
                break;
            }
            case -948729267: {
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
            case 1134885049: {
                if (bl) {
                    if (n2 != 17) break;
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
            case -1757351524: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1489283190: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 19;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 20;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 21;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1089241616: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 22;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 23;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 24;
                    break;
                }
                n3 = 22;
                break;
            }
            case -628247110: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -368680620: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 337433819: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 705792921: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1209404366: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1429358049: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1681332589: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1974016857: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
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
            case -1859065058: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1710808516: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMobileSpeechRecognition)object).requestStartSpeechRecognition();
                return null;
            }
            case 1: {
                ((DSIMobileSpeechRecognition)object).requestStopSpeechRecognition();
                return null;
            }
            case 2: {
                ((DSIMobileSpeechRecognition)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSIMobileSpeechRecognition)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSIMobileSpeechRecognition)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIMobileSpeechRecognition)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIMobileSpeechRecognition)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIMobileSpeechRecognition)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSINAD)object).restoreFactorySettings();
                return null;
            }
            case 9: {
                ((DSINAD)object).requestNetworkSearch();
                return null;
            }
            case 10: {
                ((DSINAD)object).requestNetworkRegistration((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSINAD)object).requestAbortNetworkRegistration();
                return null;
            }
            case 12: {
                ((DSINAD)object).requestAbortNetworkSearch();
                return null;
            }
            case 13: {
                ((DSINAD)object).requestSetAutomaticPinEntryActive((Boolean)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSINAD)object).requestTelPower(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSINAD)object).requestUnlockSIM(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 16: {
                ((DSINAD)object).requestCheckSIMPINCode((String)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSINAD)object).requestChangeSIMCode(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 18: {
                ((DSINAD)object).requestSIMPINRequired((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSINAD)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSINAD)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSINAD)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSINAD)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSINAD)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSINAD)object).clearNotification((DSIListener)objectArray[0]);
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

