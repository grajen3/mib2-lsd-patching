/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tts.DSITTS;
import org.dsi.ifc.tts.TTSPrompt;
import org.dsi.ifc.tvtuner.DSITVTuner;

public final class LR2824c44a5
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1986807288: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1716607696: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1587357554: {
                if (bl) {
                    if (n2 != -883163127) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1425584067: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1298337705: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 15;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 16;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 17;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1112395210: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 18;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 19;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 20;
                    break;
                }
                n3 = 18;
                break;
            }
            case -774940832: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -193483113: {
                if (bl) {
                    if (n2 != 1359336183) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 45315816: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 61469674: {
                if (bl) {
                    if (n2 != 2103651840) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 281775115: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 592964635: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 669146420: {
                if (bl) {
                    if (n2 != 826925271) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1238357732: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1689857092: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 27;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 28;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 29;
                    break;
                }
                n3 = 27;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 30;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 31;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 32;
                    break;
                }
                n3 = 30;
                break;
            }
            case 3237765: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 172820714: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -1549110930) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 578941971: {
                if (bl) {
                    if (n2 != -887467249) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1068851110: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1231594059: {
                if (bl) {
                    if (n2 != -1820730131) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
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
            case -1310421297: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -867982545: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSITVTuner)object).selectService(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 1: {
                ((DSITVTuner)object).selectNextService(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSITVTuner)object).abortSeek();
                return null;
            }
            case 3: {
                ((DSITVTuner)object).switchSource(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSITVTuner)object).setAudioChannel(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSITVTuner)object).setNormArea(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSITVTuner)object).enableServiceLinking((Boolean)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSITVTuner)object).setTerminalMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSITVTuner)object).setNormAreaSubList((int[])objectArray[0]);
                return null;
            }
            case 9: {
                ((DSITVTuner)object).setAVNorm(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSITVTuner)object).incMoved((byte)((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSITVTuner)object).setCoordinateRel((short)((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSITVTuner)object).setTMTVKeyPanel((short)((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSITVTuner)object).enableSubtitle((Boolean)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSITVTuner)object).setBrowserListSort(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSITVTuner)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSITVTuner)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSITVTuner)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSITVTuner)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSITVTuner)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSITVTuner)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSITTS)object).init((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 22: {
                ((DSITTS)object).setLanguage((short)((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 23: {
                ((DSITTS)object).requestAudioTrigger((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSITTS)object).speakPrompt((short)((Number)objectArray[0]).intValue(), (TTSPrompt)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSITTS)object).requestPlayTone((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSITTS)object).requestSkipSpeaking((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 27: {
                ((DSITTS)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSITTS)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSITTS)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSITTS)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSITTS)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSITTS)object).clearNotification((DSIListener)objectArray[0]);
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

