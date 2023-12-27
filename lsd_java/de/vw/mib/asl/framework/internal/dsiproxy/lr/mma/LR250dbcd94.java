/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.DSIMediaPlayerListener;
import org.dsi.ifc.media.DSIMediaRecorderListener;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.PlaybackMode;

public final class LR250dbcd94
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1845727213: {
                if (bl) {
                    if (n2 != 2043950673) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1829794016: {
                if (bl) {
                    if (n2 != -94011602) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1756676477: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1599062820: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1522378520: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1348628102: {
                if (bl) {
                    if (n2 != -1334304661) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1231410737: {
                if (bl) {
                    if (n2 != -22797681) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1154392900: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -982786206: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -924533157: {
                if (bl) {
                    if (n2 != 1920279622) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -782618727: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -778104313: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -688571112: {
                if (bl) {
                    if (n2 != 2084990025) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -670583243: {
                if (bl) {
                    if (n2 != -982352613) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -588864996: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -476522120: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -473580994: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 50839475: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 116931660: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 315772467: {
                if (bl) {
                    if (n2 != -16961460) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 383756348: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 500082545: {
                if (bl) {
                    if (n2 != 767814030) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 701573805: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 783323304: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 832940290: {
                if (bl) {
                    if (n2 != 350261563) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1052920199: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1204561641: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1278693044: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1835841940: {
                if (bl) {
                    if (n2 != 445532934) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1998600851: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 2086846058: {
                if (bl) {
                    if (n2 != -155224285) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1763170304: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1394545545: {
                if (bl) {
                    if (n2 != -813373144) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -882409218: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -599608160: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 87894393: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 874881133: {
                if (bl) {
                    if (n2 != -57104458) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1053600447: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 1273874901: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 2086846058: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 2102696080: {
                if (bl) {
                    if (n2 != 1421144674) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
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
            case -1586439164: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 427781729: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMediaPlayerListener)object).responseCoverArt(((Number)objectArray[0]).longValue(), (ResourceLocator)objectArray[1]);
                return null;
            }
            case 1: {
                ((DSIMediaPlayerListener)object).updatePlaybackState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIMediaPlayerListener)object).responseFullyQualifiedName(((Number)objectArray[0]).longValue(), (String)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSIMediaPlayerListener)object).updateVideoFormat(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIMediaPlayerListener)object).updateVideoNorm(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIMediaPlayerListener)object).updateCmdBlockingMask(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIMediaPlayerListener)object).updateNumVideoAngles(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIMediaPlayerListener)object).updatePlaybackModeList((PlaybackMode[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIMediaPlayerListener)object).updatePlaybackMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIMediaPlayerListener)object).updateActiveMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 10: {
                ((DSIMediaPlayerListener)object).updatePlaybackFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIMediaPlayerListener)object).updateCapabilities((Capabilities)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIMediaPlayerListener)object).updatePlayPosition(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 13: {
                ((DSIMediaPlayerListener)object).updatePlayViewSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSIMediaPlayerListener)object).updateActiveVideoAngle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIMediaPlayerListener)object).updateAudioStreamList((AudioStream[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIMediaPlayerListener)object).updateActiveAudioStream(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIMediaPlayerListener)object).updateSubtitleList((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIMediaPlayerListener)object).updateActiveSubtitle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIMediaPlayerListener)object).responseCmdBlocked(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSIMediaPlayerListener)object).responseRating(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSIMediaPlayerListener)object).responsePlayView((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 22: {
                ((DSIMediaPlayerListener)object).responseDetailInfo((EntryInfo)objectArray[0]);
                return null;
            }
            case 23: {
                ((DSIMediaPlayerListener)object).indicationDvdEvent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 24: {
                ((DSIMediaPlayerListener)object).responseSetPlaySelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIMediaPlayerListener)object).responseSetPlaySelectionAB(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIMediaPlayerListener)object).responseSetPlaybackURL((String)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSIMediaPlayerListener)object).responseSetVideoRect(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue());
                return null;
            }
            case 28: {
                ((DSIMediaPlayerListener)object).responsePlaySimilarEntry(((Number)objectArray[0]).longValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIMediaPlayerListener)object).tempPMLRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 30: {
                ((DSIMediaPlayerListener)object).updatePlaybackContentFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSIMediaPlayerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIMediaRecorderListener)object).updateActiveMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 33: {
                ((DSIMediaRecorderListener)object).responseSetSelection(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSIMediaRecorderListener)object).updateImportSummary(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).longValue(), ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).intValue());
                return null;
            }
            case 35: {
                ((DSIMediaRecorderListener)object).updateImportProgress(((Number)objectArray[0]).longValue(), (ListEntry)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 36: {
                ((DSIMediaRecorderListener)object).updateImportStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSIMediaRecorderListener)object).updateDeletionProgress(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSIMediaRecorderListener)object).updateDeletionStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSIMediaRecorderListener)object).updateDatabaseSpace((DatabaseSpace)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSIMediaRecorderListener)object).updateTargetMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 41: {
                ((DSIMediaRecorderListener)object).responseSetEncodingQuality(((Number)objectArray[0]).intValue());
                return null;
            }
            case 42: {
                ((DSIMediaRecorderListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

