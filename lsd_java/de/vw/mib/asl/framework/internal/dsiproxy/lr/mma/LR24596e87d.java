/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.speechrec.DSISpeechRecListener;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;
import org.dsi.ifc.sse.DSISSEListener;

public final class LR24596e87d
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2034215821: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1937606570: {
                if (bl) {
                    if (n2 != -1979219789) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1830144688: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -1779115334: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1770184875: {
                if (bl) {
                    if (n2 != -1995172334) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1646089103: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1638075428: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case -1552764885: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -1549677386: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1500641052: {
                if (bl) {
                    if (n2 != -1979219789) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -1410919600: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1292073070: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1161935538: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -997130813: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -995891271: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -905980594: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -889326235: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -878862752: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -775271025: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -743417418: {
                if (bl) {
                    if (n2 != -1261696176) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -743258830: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -623723556: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -540832586: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -520232847: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -494785267: {
                if (bl) {
                    if (n2 != -1995172334) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -355678456: {
                if (bl) {
                    if (n2 != 315442652) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -335785970: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -249221621: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -163824098: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -128693362: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -80775463: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -42865973: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 139922165: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 294520158: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 392312432: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 548032704: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 607940595: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 694371916: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 715959757: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 795942390: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 836628548: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 884204380: {
                if (bl) {
                    if (n2 != -1995172334) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 901076607: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 955207880: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 991611415: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 1015394348: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1020390599: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 1111137305: {
                if (bl) {
                    if (n2 != 106852157) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1152018244: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1386725208: {
                if (bl) {
                    if (n2 != -1979219789) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1438902118: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1476285313: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 1532772980: {
                if (bl) {
                    if (n2 != -1995172334) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1604239675: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1648533988: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1660364422: {
                if (bl) {
                    if (n2 != -1979219789) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1686818388: {
                if (bl) {
                    if (n2 != -1144691716) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 1712443126: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1754508856: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1758489833: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1819510057: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1858851493: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1860795100: {
                if (bl) {
                    if (n2 != -1106086257) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 1935098199: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1955623363: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2067924324: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1717775335: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -480211737: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -296133503: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 356276788: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 1390554447: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
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
            case -1728904285: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1587324259: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISpeechRecListener)object).responseRestoreFactorySettings(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSISpeechRecListener)object).updateAvailableLanguages((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSISpeechRecListener)object).updateLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSISpeechRecListener)object).updateAvailableProfiles((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSISpeechRecListener)object).responseAbort(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSISpeechRecListener)object).responseDeleteProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSISpeechRecListener)object).responseDeleteVoiceTag(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((DSISpeechRecListener)object).responseEnableContinuousUpdate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSISpeechRecListener)object).responseGetVersion((String)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSISpeechRecListener)object).responseInit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSISpeechRecListener)object).responseInitVoiceTag(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSISpeechRecListener)object).responseLoadGrammar(((Number)objectArray[0]).intValue(), (GrammarInfo[])objectArray[1]);
                return null;
            }
            case 12: {
                ((DSISpeechRecListener)object).responseLoadProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSISpeechRecListener)object).responsePreloadGrammar(((Number)objectArray[0]).intValue(), (GrammarInfo[])objectArray[1]);
                return null;
            }
            case 14: {
                ((DSISpeechRecListener)object).responseRecordVoiceTag(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSISpeechRecListener)object).responseSetLanguage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSISpeechRecListener)object).responseShutdown(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSISpeechRecListener)object).responseStartRecognition(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSISpeechRecListener)object).responseUnloadGrammar(((Number)objectArray[0]).intValue(), (GrammarInfo[])objectArray[1]);
                return null;
            }
            case 19: {
                ((DSISpeechRecListener)object).responseUnloadProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSISpeechRecListener)object).responseUnpreloadGrammar(((Number)objectArray[0]).intValue(), (GrammarInfo[])objectArray[1]);
                return null;
            }
            case 21: {
                ((DSISpeechRecListener)object).responseWaitForResults(((Number)objectArray[0]).intValue(), (NBestList)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSISpeechRecListener)object).updateAborted((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSISpeechRecListener)object).updateFailure((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSISpeechRecListener)object).updateRecognizerState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSISpeechRecListener)object).updateAbsoluteConfidenceThreshold(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSISpeechRecListener)object).responseSetMaxCommandNBestListSize(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((DSISpeechRecListener)object).updateMaxCommandNBestListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSISpeechRecListener)object).responseSetMaxSlotNBestListSize(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSISpeechRecListener)object).updateMaxSlotNBestListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSISpeechRecListener)object).responseSetConfidenceRejectThreshold(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((DSISpeechRecListener)object).updateConfidenceRejectThreshold(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSISpeechRecListener)object).responseSetUtteranceStartTimeout(((Number)objectArray[0]).intValue());
                return null;
            }
            case 33: {
                ((DSISpeechRecListener)object).updateUtteranceStartTimeout(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSISpeechRecListener)object).responseSetRecognitionTimeout(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSISpeechRecListener)object).updateRecognitionTimeout(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSISpeechRecListener)object).responseSetUnambiguousResultThreshold(((Number)objectArray[0]).intValue());
                return null;
            }
            case 37: {
                ((DSISpeechRecListener)object).updateUnambiguousResultThreshold(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSISpeechRecListener)object).responseSetUnambiguousResultRange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 39: {
                ((DSISpeechRecListener)object).updateUnambiguousResultRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSISpeechRecListener)object).responseSetFirstLevelSize(((Number)objectArray[0]).intValue());
                return null;
            }
            case 41: {
                ((DSISpeechRecListener)object).updateFirstLevelSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSISpeechRecListener)object).responseStartPostTraining(((Number)objectArray[0]).intValue());
                return null;
            }
            case 43: {
                ((DSISpeechRecListener)object).responseStopPostTraining(((Number)objectArray[0]).intValue());
                return null;
            }
            case 44: {
                ((DSISpeechRecListener)object).responseRequestSDSAvailability(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSISpeechRecListener)object).updateSDSAvailability(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSISpeechRecListener)object).responseSetSpellingMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 47: {
                ((DSISpeechRecListener)object).responseDeleteLastSpellingBlock(((Number)objectArray[0]).intValue(), (NBestList)objectArray[1]);
                return null;
            }
            case 48: {
                ((DSISpeechRecListener)object).responseStartDialogue(((Number)objectArray[0]).intValue());
                return null;
            }
            case 49: {
                ((DSISpeechRecListener)object).responseStopDialogue(((Number)objectArray[0]).intValue());
                return null;
            }
            case 50: {
                ((DSISpeechRecListener)object).updateGrammarStatus(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 51: {
                ((DSISpeechRecListener)object).updateGrammarState((GrammarStateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSISpeechRecListener)object).updateTemporaryG2PLanguageChangeActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((DSISpeechRecListener)object).responseCheckDbPartition(((Number)objectArray[0]).intValue());
                return null;
            }
            case 54: {
                ((DSISpeechRecListener)object).responseRequestGraphemicGroupAsNBestList(((Number)objectArray[0]).intValue(), (NBestList)objectArray[1]);
                return null;
            }
            case 55: {
                ((DSISpeechRecListener)object).responseRequestVDECapabilities(((Number)objectArray[0]).intValue(), (VDECapabilities)objectArray[1]);
                return null;
            }
            case 56: {
                ((DSISpeechRecListener)object).responseSetDictionary(((Number)objectArray[0]).intValue());
                return null;
            }
            case 57: {
                ((DSISpeechRecListener)object).updateNBestList((NBestList)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSISpeechRecListener)object).responseSetASRParameterConfiguration(((Number)objectArray[0]).intValue());
                return null;
            }
            case 59: {
                ((DSISpeechRecListener)object).updateASRParameterConfiguration((int[])objectArray[0], (int[])objectArray[1], (int[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 60: {
                ((DSISpeechRecListener)object).responseDeleteLastFlexVDEPart(((Number)objectArray[0]).intValue(), (NBestList)objectArray[1]);
                return null;
            }
            case 61: {
                ((DSISpeechRecListener)object).responseClearFlexVDEHistory(((Number)objectArray[0]).intValue());
                return null;
            }
            case 62: {
                ((DSISpeechRecListener)object).updateVDEMediumState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSISpeechRecListener)object).updateAvailableSLMLanguages((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSISpeechRecListener)object).updateOnlineCapabilities((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((DSISpeechRecListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 66: {
                ((DSISSEListener)object).updateMicGainLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((DSISSEListener)object).responseSetMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 68: {
                ((DSISSEListener)object).updateMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((DSISSEListener)object).responseSetMicGainLevel(((Number)objectArray[0]).intValue());
                return null;
            }
            case 70: {
                ((DSISSEListener)object).updateMicMuteState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 71: {
                ((DSISSEListener)object).responseSetMicMuteState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 72: {
                ((DSISSEListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
                case 2: {
                    return this.f2(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

