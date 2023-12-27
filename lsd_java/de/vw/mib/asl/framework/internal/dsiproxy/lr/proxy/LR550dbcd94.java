/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.proxy;

import de.vw.mib.reflection.AbstractProxy;
import de.vw.mib.reflection.InvocationHandler;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.DSIMediaPlayerListener;
import org.dsi.ifc.media.DSIMediaRecorderListener;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.PlaybackMode;

public final class LR550dbcd94
extends AbstractProxy
implements DSIMediaPlayerListener,
DSIMediaRecorderListener {
    private static final Method[] JMS = new Method[43];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR550dbcd94(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void responseCoverArt(long l, ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = resourceLocator;
            this.h.invoke(this, LR550dbcd94.gjm(0, "org.dsi.ifc.media.DSIMediaPlayerListener", 44672305, 350261563), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePlaybackState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(1, "org.dsi.ifc.media.DSIMediaPlayerListener", 1658809285, 1676164096), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseFullyQualifiedName(long l, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = string;
            this.h.invoke(this, LR550dbcd94.gjm(2, "org.dsi.ifc.media.DSIMediaPlayerListener", 860803602, -16961460), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVideoFormat(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(3, "org.dsi.ifc.media.DSIMediaPlayerListener", 1052427747, 1676164096), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateVideoNorm(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(4, "org.dsi.ifc.media.DSIMediaPlayerListener", -2093069417, 1676164096), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCmdBlockingMask(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(5, "org.dsi.ifc.media.DSIMediaPlayerListener", -2025209282, 1676164096), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateNumVideoAngles(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(6, "org.dsi.ifc.media.DSIMediaPlayerListener", -1824907145, 1676164096), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePlaybackModeList(PlaybackMode[] playbackModeArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = playbackModeArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(7, "org.dsi.ifc.media.DSIMediaPlayerListener", 2056363439, -1334304661), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePlaybackMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(8, "org.dsi.ifc.media.DSIMediaPlayerListener", 1017700118, 1676164096), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateActiveMedia(long l, long l2, int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            objectArray[4] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR550dbcd94.gjm(9, "org.dsi.ifc.media.DSIMediaPlayerListener", 1790861948, -155224285), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePlaybackFolder(ListEntry[] listEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = listEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(10, "org.dsi.ifc.media.DSIMediaPlayerListener", 118661073, 2084990025), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCapabilities(Capabilities capabilities, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = capabilities;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(11, "org.dsi.ifc.media.DSIMediaPlayerListener", -1799787411, 445532934), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePlayPosition(long l, int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR550dbcd94.gjm(12, "org.dsi.ifc.media.DSIMediaPlayerListener", 1539237064, 1920279622), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePlayViewSize(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR550dbcd94.gjm(13, "org.dsi.ifc.media.DSIMediaPlayerListener", 2027526371, 1043255048), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateActiveVideoAngle(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(14, "org.dsi.ifc.media.DSIMediaPlayerListener", 480437980, 1676164096), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateAudioStreamList(AudioStream[] audioStreamArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = audioStreamArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(15, "org.dsi.ifc.media.DSIMediaPlayerListener", 546303890, -94011602), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateActiveAudioStream(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(16, "org.dsi.ifc.media.DSIMediaPlayerListener", -1134808645, 1676164096), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSubtitleList(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(17, "org.dsi.ifc.media.DSIMediaPlayerListener", -1269942452, -1034208512), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateActiveSubtitle(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(18, "org.dsi.ifc.media.DSIMediaPlayerListener", -600002400, 1676164096), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseCmdBlocked(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(19, "org.dsi.ifc.media.DSIMediaPlayerListener", -396868955, 1687814400), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseRating(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(20, "org.dsi.ifc.media.DSIMediaPlayerListener", -1279326461, -266965504), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responsePlayView(ListEntry[] listEntryArray, int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = listEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR550dbcd94.gjm(21, "org.dsi.ifc.media.DSIMediaPlayerListener", -819357002, -22797681), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseDetailInfo(EntryInfo entryInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = entryInfo;
            this.h.invoke(this, LR550dbcd94.gjm(22, "org.dsi.ifc.media.DSIMediaPlayerListener", 901122008, -982352613), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicationDvdEvent(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(23, "org.dsi.ifc.media.DSIMediaPlayerListener", -1724949807, 1687814400), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseSetPlaySelection(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(24, "org.dsi.ifc.media.DSIMediaPlayerListener", 1279064070, 1676164096), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseSetPlaySelectionAB(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR550dbcd94.gjm(25, "org.dsi.ifc.media.DSIMediaPlayerListener", -1389702871, -1600866162), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseSetPlaybackURL(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR550dbcd94.gjm(26, "org.dsi.ifc.media.DSIMediaPlayerListener", -1466912722, -633848249), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseSetVideoRect(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        try {
            Object[] objectArray = this.p.borrowArray(8);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(n5);
            objectArray[5] = RuntimeUtil.valueOf(n6);
            objectArray[6] = RuntimeUtil.valueOf(n7);
            objectArray[7] = RuntimeUtil.valueOf(n8);
            this.h.invoke(this, LR550dbcd94.gjm(27, "org.dsi.ifc.media.DSIMediaPlayerListener", 326171793, 2043950673), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responsePlaySimilarEntry(long l, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR550dbcd94.gjm(28, "org.dsi.ifc.media.DSIMediaPlayerListener", 1906822685, 767814030), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void tempPMLRequest(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(29, "org.dsi.ifc.media.DSIMediaPlayerListener", -383333305, 1687814400), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updatePlaybackContentFolder(ListEntry[] listEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = listEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(30, "org.dsi.ifc.media.DSIMediaPlayerListener", 406713814, 2084990025), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(31, "org.dsi.ifc.media.DSIMediaPlayerListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateActiveMedia(long l, long l2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(32, "org.dsi.ifc.media.DSIMediaRecorderListener", 1790861948, 739712016), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseSetSelection(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR550dbcd94.gjm(33, "org.dsi.ifc.media.DSIMediaRecorderListener", -1598799140, -1600866162), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(7);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            objectArray[2] = RuntimeUtil.valueOf(l3);
            objectArray[3] = RuntimeUtil.valueOf(l4);
            objectArray[4] = RuntimeUtil.valueOf(l5);
            objectArray[5] = RuntimeUtil.valueOf(l6);
            objectArray[6] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(34, "org.dsi.ifc.media.DSIMediaRecorderListener", 1839211828, -57104458), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateImportProgress(long l, ListEntry listEntry, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = listEntry;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(35, "org.dsi.ifc.media.DSIMediaRecorderListener", -1869065091, 1421144674), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateImportStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(36, "org.dsi.ifc.media.DSIMediaRecorderListener", -708186805, 1676164096), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDeletionProgress(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(37, "org.dsi.ifc.media.DSIMediaRecorderListener", 2032745733, -266965504), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDeletionStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR550dbcd94.gjm(38, "org.dsi.ifc.media.DSIMediaRecorderListener", -25139253, 1676164096), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateDatabaseSpace(DatabaseSpace databaseSpace, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = databaseSpace;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(39, "org.dsi.ifc.media.DSIMediaRecorderListener", 2012012716, -813373144), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTargetMedia(long l, long l2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(40, "org.dsi.ifc.media.DSIMediaRecorderListener", -1079325634, 739712016), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseSetEncodingQuality(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR550dbcd94.gjm(41, "org.dsi.ifc.media.DSIMediaRecorderListener", 2680982, 1687814400), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}

