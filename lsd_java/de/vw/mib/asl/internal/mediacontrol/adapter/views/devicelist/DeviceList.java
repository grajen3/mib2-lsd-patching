/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.devicelist;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlDevice;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerActiveTrack;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerDevices;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerPlaybackState;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlServicePlayer;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.Helper;
import de.vw.mib.asl.internal.mediacontrol.transformer.MediaControlDeviceListTransformerEntry;
import de.vw.mib.collections.ObjectOptHashSet;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Iterator;

public class DeviceList
implements MediaControlListenerDevices,
MediaControlListenerPlaybackState,
MediaControlListenerActiveTrack {
    private static final GenericASLList DEVICE_LIST = ListManager.getGenericASLList(-1306503424);
    private final ObjectOptHashSet mSelectedDevices = new ObjectOptHashSet(7);
    private MediaControlDevice[] mDevices;

    public DeviceList(MediaControlAPI mediaControlAPI) {
        MediaControlServicePlayer mediaControlServicePlayer = mediaControlAPI.getPlayerService();
        mediaControlServicePlayer.addDevicesListener(this);
        mediaControlServicePlayer.addActiveTrackListener(this);
        mediaControlServicePlayer.addPlaybackStateListener(this);
    }

    private boolean containsDeviceId(String string, MediaControlDevice[] mediaControlDeviceArray) {
        if (!Util.isNullOrEmpty(mediaControlDeviceArray)) {
            for (int i2 = 0; i2 < mediaControlDeviceArray.length; ++i2) {
                if (!mediaControlDeviceArray[i2].deviceID.equals(string)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateDeviceList(MediaControlDevice[] mediaControlDeviceArray, MediaControlDevice[] mediaControlDeviceArray2) {
        this.mDevices = mediaControlDeviceArray;
        Iterator iterator = this.mSelectedDevices.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            if (this.containsDeviceId(string, mediaControlDeviceArray)) continue;
            iterator.remove();
        }
        this.selectAll();
    }

    @Override
    public void updateActiveTrack(MediaControlDevice[] mediaControlDeviceArray) {
        this.mDevices = mediaControlDeviceArray;
        this.forwardDeviceList();
    }

    @Override
    public void updatePlaybackState(MediaControlDevice[] mediaControlDeviceArray) {
        this.mDevices = mediaControlDeviceArray;
        this.forwardDeviceList();
    }

    public void toggleDeviceSelection(String string) {
        if (this.mSelectedDevices.contains(string)) {
            this.mSelectedDevices.remove(string);
        } else {
            this.mSelectedDevices.add(string);
        }
        this.forwardDeviceList();
    }

    public void selectAll() {
        if (!Util.isNullOrEmpty(this.mDevices)) {
            for (int i2 = 0; i2 < this.mDevices.length; ++i2) {
                this.mSelectedDevices.add(this.mDevices[i2].deviceID);
            }
        }
        this.forwardDeviceList();
    }

    public void deselectAll() {
        this.mSelectedDevices.clear();
        this.forwardDeviceList();
    }

    public String[] getSelectedDevices() {
        return (String[])this.mSelectedDevices.toArray(new String[this.mSelectedDevices.size()]);
    }

    private void forwardDeviceList() {
        MediaControlDeviceListTransformerEntry[] mediaControlDeviceListTransformerEntryArray = null;
        if (!Util.isNullOrEmpty(this.mDevices)) {
            mediaControlDeviceListTransformerEntryArray = new MediaControlDeviceListTransformerEntry[this.mDevices.length];
            for (int i2 = 0; i2 < this.mDevices.length; ++i2) {
                mediaControlDeviceListTransformerEntryArray[i2] = new MediaControlDeviceListTransformerEntry();
                mediaControlDeviceListTransformerEntryArray[i2].id = this.mDevices[i2].deviceID;
                mediaControlDeviceListTransformerEntryArray[i2].name = this.mDevices[i2].deviceName;
                mediaControlDeviceListTransformerEntryArray[i2].playbackState = Helper.getOpenDevicePlaybackState(this.mDevices[i2].playbackState);
                mediaControlDeviceListTransformerEntryArray[i2].selected = this.mSelectedDevices.contains(this.mDevices[i2].deviceID);
                if (this.mDevices[i2].activeTrack == null) continue;
                mediaControlDeviceListTransformerEntryArray[i2].cover = this.mDevices[i2].activeTrack.coverArt;
            }
        }
        DEVICE_LIST.updateList(mediaControlDeviceListTransformerEntryArray);
        ServiceManager.aslPropertyManager.valueChangedInteger(-1121954048, this.mSelectedDevices.size());
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1323280640, !Util.isNullOrEmpty(this.mDevices));
    }
}

