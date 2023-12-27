/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.filebrowser.sourcehandling;

import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.media.MediaInfo;

public class FileBrowserSourceList {
    private final ArrayList sources = new ArrayList(7);

    public FileBrowserSourceInfo getSourceById(int n) {
        for (int i2 = 0; i2 < this.sources.size(); ++i2) {
            FileBrowserSourceInfo fileBrowserSourceInfo = this.get(i2);
            if (fileBrowserSourceInfo == null || fileBrowserSourceInfo.getSourceId() != n) continue;
            return fileBrowserSourceInfo;
        }
        return null;
    }

    public FileBrowserSourceInfo getSourceByIndex(int n) {
        if (0 <= n && n < this.sources.size()) {
            return this.get(n);
        }
        return null;
    }

    public FileBrowserSourceInfo getSourceByMountPoint(String string) {
        for (int i2 = this.count() - 1; i2 >= 0; --i2) {
            FileBrowserSourceInfo fileBrowserSourceInfo = this.get(i2);
            if (null == fileBrowserSourceInfo) continue;
            for (int i3 = fileBrowserSourceInfo.getMediaInfos().length - 1; i3 >= 0; --i3) {
                if (fileBrowserSourceInfo.getMediaInfos()[i3].mountPoint == null || !fileBrowserSourceInfo.getMediaInfos()[i3].mountPoint.equals(string)) continue;
                return fileBrowserSourceInfo;
            }
        }
        return null;
    }

    public MediaInfo getMediaInfoByMountPoint(String string) {
        for (int i2 = this.count() - 1; i2 >= 0; --i2) {
            FileBrowserSourceInfo fileBrowserSourceInfo = this.get(i2);
            if (null == fileBrowserSourceInfo) continue;
            for (int i3 = fileBrowserSourceInfo.getMediaInfos().length - 1; i3 >= 0; --i3) {
                MediaInfo mediaInfo = fileBrowserSourceInfo.getMediaInfos()[i3];
                if (mediaInfo.mountPoint == null || !mediaInfo.mountPoint.equals(string)) continue;
                return mediaInfo;
            }
        }
        return null;
    }

    public boolean isSourceAvailable(int n) {
        FileBrowserSourceInfo fileBrowserSourceInfo;
        if (0 <= n && n < this.sources.size() && null != (fileBrowserSourceInfo = this.get(n))) {
            return fileBrowserSourceInfo.isAvailable();
        }
        return false;
    }

    public int count() {
        return this.sources.size();
    }

    public FileBrowserSourceInfo get(int n) {
        return (FileBrowserSourceInfo)this.sources.get(n);
    }

    public FileBrowserSourceInfo getSource(long l, long l2) {
        for (int i2 = this.sources.size() - 1; i2 >= 0; --i2) {
            if (null == this.get(i2) || this.get((int)i2).getDeviceInfo().deviceID != l) continue;
            if (this.get(i2).hasMedium(l2)) {
                return this.get(i2);
            }
            return null;
        }
        return null;
    }

    public String toString() {
        return new StringBuffer().append("FileBrowserSourceList [sources=").append(this.sources != null ? Arrays.asList(this.sources.toArray(new FileBrowserSourceInfo[this.sources.size()])) : null).append("]").toString();
    }

    public void add(FileBrowserSourceInfo fileBrowserSourceInfo) {
        this.sources.add(fileBrowserSourceInfo);
    }

    public void reset() {
        this.sources.clear();
    }
}

