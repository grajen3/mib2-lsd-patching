/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.sourcehandling;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingFactory;
import de.vw.mib.asl.api.devicehandling.clients.DeviceAslList;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceList;
import de.vw.mib.asl.internal.filebrowser.sourcehandling.FileBrowserConnector;
import de.vw.mib.asl.internal.filebrowser.sourcehandling.TargetSourceHandling$1;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.media.MediaInfo;

public class TargetSourceHandling
extends AbstractTarget {
    private final FileBrowserSourceList currentSourceList;
    private final String _classname = super.getClass().getName();
    private DeviceAslList navDeviceList = new DeviceAslList(414, MEDIA_SOURCES);
    private static DeviceFilter MEDIA_SOURCES = new TargetSourceHandling$1();

    public TargetSourceHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.currentSourceList = new FileBrowserSourceList();
    }

    @Override
    public int getDefaultTargetId() {
        return -1041559040;
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                ASLDeviceHandlingFactory.getDeviceHandlingApi().register(new FileBrowserConnector(this.currentSourceList));
                ASLDeviceHandlingFactory.getDeviceHandlingApi().register(this.navDeviceList);
                break;
            }
            case 3000002: {
                this.currentSourceList.reset();
                break;
            }
            case 2500013: {
                eventGeneric.setObject(0, this.currentSourceList);
                break;
            }
            case 2500014: {
                eventGeneric.setObject(2, this.getPartitions((MediaInfo)eventGeneric.getObject(1)));
                break;
            }
        }
    }

    private MediaInfo[] getPartitions(MediaInfo mediaInfo) {
        FileBrowserSourceInfo fileBrowserSourceInfo = this.currentSourceList.getSource(mediaInfo.deviceID, mediaInfo.mediaID);
        MediaInfo[] mediaInfoArray = new MediaInfo[fileBrowserSourceInfo.getDevice().getCurrentState().countPictureViewerAvailable()];
        int n = 0;
        for (int i2 = 0; i2 < fileBrowserSourceInfo.getMediaInfos().length; ++i2) {
            if (!fileBrowserSourceInfo.getDevice().getMedium(i2).getCurrentState().isPictureViewerAvailable()) continue;
            mediaInfoArray[n++] = fileBrowserSourceInfo.getMediaInfos()[i2];
        }
        return mediaInfoArray;
    }
}

