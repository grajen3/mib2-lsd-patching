/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlActiveTrack;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlDevice;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerActiveTrack;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlServicePlayer;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.Helper;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.mediacontrol.opendevice.ASLMediaControlOpenDevicePropertyManager;
import generated.de.vw.mib.asl.internal.mediacontrol.opendevice.transformer.MediaControlOpenDeviceCurrentTrackInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public class TrackDetails
implements MediaControlListenerActiveTrack {
    private String mCurrentDeviceId;
    private MediaControlDevice[] mDevices;

    protected TrackDetails(MediaControlAPI mediaControlAPI) {
        MediaControlServicePlayer mediaControlServicePlayer = mediaControlAPI.getPlayerService();
        mediaControlServicePlayer.addActiveTrackListener(this);
    }

    @Override
    public void updateActiveTrack(MediaControlDevice[] mediaControlDeviceArray) {
        this.mDevices = mediaControlDeviceArray;
        this.update();
    }

    protected void setOpenedDevice(String string) {
        this.mCurrentDeviceId = string;
        this.update();
    }

    private void update() {
        GenericASLList genericASLList = ListManager.getGenericASLList(-1189062912);
        Object[] objectArray = null;
        objectArray = (MediaControlOpenDeviceCurrentTrackInfoCollector[])genericASLList.getDSIObjects();
        ResourceLocator resourceLocator = ASLMediaControlOpenDevicePropertyManager.COVER__DEFAULT_VALUE;
        objectArray[0].mediacontrol_opendevice_album = "";
        objectArray[0].mediacontrol_opendevice_artist = "";
        objectArray[0].mediacontrol_opendevice_title = "";
        MediaControlActiveTrack mediaControlActiveTrack = Helper.getActiveTrack(this.mDevices, this.mCurrentDeviceId);
        if (mediaControlActiveTrack != null) {
            resourceLocator = mediaControlActiveTrack.coverArt;
            ((MediaControlOpenDeviceCurrentTrackInfoCollector)objectArray[0]).mediacontrol_opendevice_album = mediaControlActiveTrack.album;
            ((MediaControlOpenDeviceCurrentTrackInfoCollector)objectArray[0]).mediacontrol_opendevice_artist = mediaControlActiveTrack.artist;
            ((MediaControlOpenDeviceCurrentTrackInfoCollector)objectArray[0]).mediacontrol_opendevice_title = mediaControlActiveTrack.title;
        }
        genericASLList.updateList(objectArray);
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(-1289726208, resourceLocator);
    }
}

