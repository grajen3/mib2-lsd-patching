/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaPlayer;
import org.dsi.ifc.media.DSIMediaRecorder;

public final class LR24c2b808
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1790474785: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 8;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 9;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 10;
                    break;
                }
                n3 = 8;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 11;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 12;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 13;
                    break;
                }
                n3 = 11;
                break;
            }
            case -321555600: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -218686074: {
                if (bl) {
                    if (n2 != 1372686599) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -176577089: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -170892950: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 814559537: {
                if (bl) {
                    if (n2 != 1372686599) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1985341218: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 2136003868: {
                if (bl) {
                    if (n2 != -1653679357) break;
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
            case -2057742000: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1995599067: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -1969693783: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1745867515: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1422805238: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1422696142: {
                if (bl) {
                    if (n2 != 2043950673) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1169354353: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 42;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 43;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 44;
                    break;
                }
                n3 = 42;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 45;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 46;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 47;
                    break;
                }
                n3 = 45;
                break;
            }
            case -934425950: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -705710585: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -620526101: {
                if (bl) {
                    if (n2 != 1892534951) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -402420139: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -356811521: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -237375216: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -205895525: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 3444137: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 3526893: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 3532788: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 3541623: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 106440811: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 172874269: {
                if (bl) {
                    if (n2 != 1920279622) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 219130503: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 225864725: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 227576579: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 543296276: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 674269324: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 814559537: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 995652865: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1391381413: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
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
            case -1490575824: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -603398771: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMediaRecorder)object).setSelection(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIMediaRecorder)object).setActiveMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 2: {
                ((DSIMediaRecorder)object).startImport((Boolean)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIMediaRecorder)object).abortImport();
                return null;
            }
            case 4: {
                ((DSIMediaRecorder)object).startDelete();
                return null;
            }
            case 5: {
                ((DSIMediaRecorder)object).abortDelete();
                return null;
            }
            case 6: {
                ((DSIMediaRecorder)object).setTargetMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 7: {
                ((DSIMediaRecorder)object).setEncodingQuality(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSIMediaRecorder)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIMediaRecorder)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIMediaRecorder)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIMediaRecorder)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIMediaRecorder)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIMediaRecorder)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIMediaPlayer)object).resume();
                return null;
            }
            case 15: {
                ((DSIMediaPlayer)object).stop();
                return null;
            }
            case 16: {
                ((DSIMediaPlayer)object).skip(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIMediaPlayer)object).setEntry(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIMediaPlayer)object).requestFullyQualifiedName(((Number)objectArray[0]).longValue());
                return null;
            }
            case 19: {
                ((DSIMediaPlayer)object).setActiveMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 20: {
                ((DSIMediaPlayer)object).setPlaybackMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIMediaPlayer)object).setVideoNorm(((Number)objectArray[0]).intValue());
                return null;
            }
            case 22: {
                ((DSIMediaPlayer)object).setRating(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIMediaPlayer)object).requestCoverArt(((Number)objectArray[0]).longValue());
                return null;
            }
            case 24: {
                ((DSIMediaPlayer)object).play();
                return null;
            }
            case 25: {
                ((DSIMediaPlayer)object).pause();
                return null;
            }
            case 26: {
                ((DSIMediaPlayer)object).seek(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSIMediaPlayer)object).requestPlayView(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 28: {
                ((DSIMediaPlayer)object).executeMenuCmd(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSIMediaPlayer)object).setVideoAngle(((Number)objectArray[0]).intValue());
                return null;
            }
            case 30: {
                ((DSIMediaPlayer)object).setAudioStream(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((DSIMediaPlayer)object).setVideoFormat(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIMediaPlayer)object).setSubtitleLanguage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 33: {
                ((DSIMediaPlayer)object).requestDetailInfo(((Number)objectArray[0]).longValue());
                return null;
            }
            case 34: {
                ((DSIMediaPlayer)object).setPlaySelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 35: {
                ((DSIMediaPlayer)object).setPlaySelectionAB(((Number)objectArray[0]).intValue());
                return null;
            }
            case 36: {
                ((DSIMediaPlayer)object).setPlaybackURL((String)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSIMediaPlayer)object).setVideoRect(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue());
                return null;
            }
            case 38: {
                ((DSIMediaPlayer)object).playSimilarEntry(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSIMediaPlayer)object).grantTempPMLRequest();
                return null;
            }
            case 40: {
                ((DSIMediaPlayer)object).denyTempPMLRequest();
                return null;
            }
            case 41: {
                ((DSIMediaPlayer)object).requestTouchEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 42: {
                ((DSIMediaPlayer)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 43: {
                ((DSIMediaPlayer)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 44: {
                ((DSIMediaPlayer)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 45: {
                ((DSIMediaPlayer)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 46: {
                ((DSIMediaPlayer)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 47: {
                ((DSIMediaPlayer)object).clearNotification((DSIListener)objectArray[0]);
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

