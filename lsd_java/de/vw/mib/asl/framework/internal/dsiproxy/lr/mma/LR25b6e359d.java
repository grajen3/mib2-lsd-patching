/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.tts.DSITTSListener;
import org.dsi.ifc.tts.LanguageVoiceInfo;
import org.dsi.ifc.tvtuner.DSITVTunerListener;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

public final class LR25b6e359d
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1462191177: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1231464292: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1161935538: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -743417418: {
                if (bl) {
                    if (n2 != 1541746573) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -306072758: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 392312432: {
                if (bl) {
                    if (n2 != 970558022) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 735779525: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1225688664: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1361004328: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1438902118: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1940150876: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1891955194: {
                if (bl) {
                    if (n2 != -1430797342) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1887567985: {
                if (bl) {
                    if (n2 != -2048300200) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1831332087: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1831012582: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1818933717: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1764218238: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
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
            case -1612503687: {
                if (bl) {
                    if (n2 != -1391160675) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1587357554: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1548961217: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1484338673: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1425584067: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1397497017: {
                if (bl) {
                    if (n2 != 154961721) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1190325642: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -771278576: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -326218723: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 225385012: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 592693374: {
                if (bl) {
                    if (n2 != 743138304) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 592964635: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 802712785: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1037292072: {
                if (bl) {
                    if (n2 != 749480048) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1210387532: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1226625759: {
                if (bl) {
                    if (n2 != -114972594) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1238357732: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1894867285: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 2000200467: {
                if (bl) {
                    if (n2 != -1757586570) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
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
            case -1401720317: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1857994147: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSITTSListener)object).updateAudioRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSITTSListener)object).updateAvailableLanguages((LanguageVoiceInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSITTSListener)object).updateLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 3: {
                ((DSITTSListener)object).responseAudioTrigger((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSITTSListener)object).responseInit((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSITTSListener)object).responseSetLanguage((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSITTSListener)object).updateMarkerPassed(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSITTSListener)object).responsePlayTone((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSITTSListener)object).responseSpeakPrompt((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSITTSListener)object).responseSkipSpeaking((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSITTSListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((DSITVTunerListener)object).selectService(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSITVTunerListener)object).selectNextService(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSITVTunerListener)object).abortSeek(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSITVTunerListener)object).switchSource(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSITVTunerListener)object).updateServiceList((ServiceInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSITVTunerListener)object).updateSelectedService((ProgramInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSITVTunerListener)object).updateTunerState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSITVTunerListener)object).updateSelectedSource(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSITVTunerListener)object).updateTVNormArea(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSITVTunerListener)object).updateAudioChannel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSITVTunerListener)object).updateMuteState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSITVTunerListener)object).updateInfoTextState((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSITVTunerListener)object).updateTerminalMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 24: {
                ((DSITVTunerListener)object).updateServiceLinking((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSITVTunerListener)object).updateTVNormList((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSITVTunerListener)object).updateTVNormAreaSubList((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSITVTunerListener)object).updateAVNorm(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSITVTunerListener)object).updateEWSInfoList((EWSInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSITVTunerListener)object).updateSubtitle((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSITVTunerListener)object).updateLogoList((LogoInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSITVTunerListener)object).updateCASInfo((Boolean)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSITVTunerListener)object).updateTuneStatus((Boolean)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 33: {
                ((DSITVTunerListener)object).updateMessageService(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSITVTunerListener)object).updateStartUpMUConfig((StartUpConfig)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSITVTunerListener)object).updateTMTVKeyPanel((short)((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 36: {
                ((DSITVTunerListener)object).updateBrowserListSort(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSITVTunerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

