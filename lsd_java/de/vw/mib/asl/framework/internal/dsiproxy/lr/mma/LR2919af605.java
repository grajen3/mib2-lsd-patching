/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.speechrec.DSISpeechRec;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.sse.DSISSE;

public final class LR2919af605
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 3;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 4;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 5;
                    break;
                }
                n3 = 3;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 6;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 7;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 8;
                    break;
                }
                n3 = 6;
                break;
            }
            case 96635097: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 128639499: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 933123622: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -2029530831: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1635575732: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1599006013: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1480291580: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1407113617: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1232243028: {
                if (bl) {
                    if (n2 != 309507224) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1221420025: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 48;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 49;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 50;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1076732664: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1028835632: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 51;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 52;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 53;
                    break;
                }
                n3 = 51;
                break;
            }
            case -822202280: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -780323734: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -514197517: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -232518058: {
                if (bl) {
                    if (n2 != 552154271) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -205183328: {
                if (bl) {
                    if (n2 != 1598376704) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -169342773: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -106724657: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -102308681: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 3237765: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 43739091: {
                if (bl) {
                    if (n2 != 552154271) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 92612005: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 145172504: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 269455944: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 294337709: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 328025763: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 523581471: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 523856614: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 696995069: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 923433229: {
                if (bl) {
                    if (n2 != -2075244131) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1113265693: {
                if (bl) {
                    if (n2 != 309507224) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1115351717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1178215603: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1388469015: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1497693585: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1692530292: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1737130017: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1952228341: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 2030662382: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 2062957874: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
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
            case -1614883633: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 2064004751: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISSE)object).requestSetMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSISSE)object).requestSetMicGainLevel(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSISSE)object).requestSetMicMuteState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSISSE)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSISSE)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSISSE)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSISSE)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSISSE)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSISSE)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSISpeechRec)object).shutdown();
                return null;
            }
            case 10: {
                ((DSISpeechRec)object).init();
                return null;
            }
            case 11: {
                ((DSISpeechRec)object).setDictionary(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2], (DictionaryEntry[])objectArray[3]);
                return null;
            }
            case 12: {
                ((DSISpeechRec)object).getVersion();
                return null;
            }
            case 13: {
                ((DSISpeechRec)object).setLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSISpeechRec)object).requestRestoreFactorySettings();
                return null;
            }
            case 15: {
                ((DSISpeechRec)object).deleteProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSISpeechRec)object).abort();
                return null;
            }
            case 17: {
                ((DSISpeechRec)object).deleteVoiceTag(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSISpeechRec)object).enableContinuousUpdate((Boolean)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSISpeechRec)object).initVoiceTag(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSISpeechRec)object).loadGrammar((Grammar[])objectArray[0]);
                return null;
            }
            case 21: {
                ((DSISpeechRec)object).loadProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 22: {
                ((DSISpeechRec)object).preloadGrammar((Grammar[])objectArray[0]);
                return null;
            }
            case 23: {
                ((DSISpeechRec)object).recordVoiceTag();
                return null;
            }
            case 24: {
                ((DSISpeechRec)object).startRecognition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 25: {
                ((DSISpeechRec)object).unloadGrammar((GrammarInfo[])objectArray[0]);
                return null;
            }
            case 26: {
                ((DSISpeechRec)object).unloadProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((DSISpeechRec)object).unpreloadGrammar((GrammarInfo[])objectArray[0]);
                return null;
            }
            case 28: {
                ((DSISpeechRec)object).waitForResults();
                return null;
            }
            case 29: {
                ((DSISpeechRec)object).setMaxCommandNBestListSize(((Number)objectArray[0]).intValue());
                return null;
            }
            case 30: {
                ((DSISpeechRec)object).setMaxSlotNBestListSize(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((DSISpeechRec)object).setRecognitionTimeout(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSISpeechRec)object).setUnambiguousResultThreshold(((Number)objectArray[0]).intValue());
                return null;
            }
            case 33: {
                ((DSISpeechRec)object).setUnambiguousResultRange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 34: {
                ((DSISpeechRec)object).setFirstLevelSize(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSISpeechRec)object).startPostTraining(((Number)objectArray[0]).intValue());
                return null;
            }
            case 36: {
                ((DSISpeechRec)object).stopPostTraining();
                return null;
            }
            case 37: {
                ((DSISpeechRec)object).requestSDSAvailability();
                return null;
            }
            case 38: {
                ((DSISpeechRec)object).setSpellingMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 39: {
                ((DSISpeechRec)object).deleteLastSpellingBlock();
                return null;
            }
            case 40: {
                ((DSISpeechRec)object).startDialogue();
                return null;
            }
            case 41: {
                ((DSISpeechRec)object).stopDialogue();
                return null;
            }
            case 42: {
                ((DSISpeechRec)object).requestCheckDbPartition();
                return null;
            }
            case 43: {
                ((DSISpeechRec)object).requestGraphemicGroupAsNBestList(((Number)objectArray[0]).intValue());
                return null;
            }
            case 44: {
                ((DSISpeechRec)object).requestVDECapabilities((String)objectArray[0]);
                return null;
            }
            case 45: {
                ((DSISpeechRec)object).setASRParameterConfiguration((int[])objectArray[0], (int[])objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 46: {
                ((DSISpeechRec)object).deleteLastFlexVDEPart();
                return null;
            }
            case 47: {
                ((DSISpeechRec)object).clearFlexVDEHistory();
                return null;
            }
            case 48: {
                ((DSISpeechRec)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 49: {
                ((DSISpeechRec)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 50: {
                ((DSISpeechRec)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 51: {
                ((DSISpeechRec)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 52: {
                ((DSISpeechRec)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 53: {
                ((DSISpeechRec)object).clearNotification((DSIListener)objectArray[0]);
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

