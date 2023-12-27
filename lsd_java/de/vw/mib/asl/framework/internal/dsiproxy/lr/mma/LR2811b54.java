/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingAudioListener;

public final class LR2811b54
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1716298142: {
                if (bl) {
                    if (n2 != 397160978) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1713576716: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1573749811: {
                if (bl) {
                    if (n2 != 1518700703) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1457319321: {
                if (bl) {
                    if (n2 != -1059402175) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -982457559: {
                if (bl) {
                    if (n2 != -1949797810) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -762587745: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -296202095: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -47085986: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 48501477: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 216866383: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 715476011: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 820210050: {
                if (bl) {
                    if (n2 != -215107951) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 998815701: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1084759488: {
                if (bl) {
                    if (n2 != -525545012) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1153682746: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1491712261: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1846049643: {
                if (bl) {
                    if (n2 != -1021381169) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -397622005: {
                if (bl) {
                    if (n2 != -1575918000) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 790468957: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 812172759: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1902928440: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
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
            case -731600123: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -444319116: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIKeyPanelListener)object).getProperty(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (byte[])objectArray[4]);
                return null;
            }
            case 1: {
                ((DSIKeyPanelListener)object).lastKey(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSIKeyPanelListener)object).getVersionInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 3: {
                ((DSIKeyPanelListener)object).updateKey2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 4: {
                ((DSIKeyPanelListener)object).updateEncoder2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 5: {
                ((DSIKeyPanelListener)object).updateDisplayTurnMechStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIKeyPanelListener)object).updateRecognizerLanguage2(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 7: {
                ((DSIKeyPanelListener)object).updateRecognizerMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIKeyPanelListener)object).updateCharacterEvent2(((Number)objectArray[0]).intValue(), (String[])objectArray[1], (int[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 9: {
                ((DSIKeyPanelListener)object).updateGesture2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (Boolean)objectArray[3], ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue(), ((Number)objectArray[8]).intValue(), ((Number)objectArray[9]).intValue());
                return null;
            }
            case 10: {
                ((DSIKeyPanelListener)object).genericSettingResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((DSIKeyPanelListener)object).updateProximity(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSIKeyPanelListener)object).updateAdvancedProximity(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue(), ((Number)objectArray[8]).intValue(), ((Number)objectArray[9]).intValue());
                return null;
            }
            case 13: {
                ((DSIKeyPanelListener)object).updateKeyboardType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIKeyPanelListener)object).updateTouchSensitiveArea(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 15: {
                ((DSIKeyPanelListener)object).updateInputPanelReady(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSIKeyPanelListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 17: {
                ((DSIFastListScrollingAudioListener)object).indicationMediaBrowser(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue(), ((Number)objectArray[8]).intValue(), ((Number)objectArray[9]).intValue(), ((Number)objectArray[10]).intValue());
                return null;
            }
            case 18: {
                ((DSIFastListScrollingAudioListener)object).indicationNotifyCommonListPUSH((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIFastListScrollingAudioListener)object).indicationNotifyReceptionListPUSH((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIFastListScrollingAudioListener)object).indicationNotifyCurrentListSizeAudio((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIFastListScrollingAudioListener)object).indicationMediaBrowserJobs(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (ArrayHeader[])objectArray[3]);
                return null;
            }
            case 22: {
                ((DSIFastListScrollingAudioListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

