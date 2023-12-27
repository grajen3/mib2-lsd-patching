/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.devicelist;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.MediaControlCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.adapter.common.ModelView;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.devicelist.DeviceList;
import de.vw.mib.genericevents.EventGeneric;

public class ViewDeviceList
implements ModelView {
    private final MediaControlAPI mMediaControlAPI;
    private final DeviceList mDeviceList;
    private static int[] ACTIONS = new int[]{-1292282304, -1325836736, -1342613952, -1158064576, -1174841792, -1342613952, -1191619008, -879681280};

    public ViewDeviceList(MediaControlAPI mediaControlAPI) {
        this.mMediaControlAPI = mediaControlAPI;
        this.mDeviceList = new DeviceList(mediaControlAPI);
    }

    @Override
    public int[] getSupportedActions() {
        return ACTIONS;
    }

    @Override
    public void handleAction(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1079441842: {
                String string = eventGeneric.getString(0);
                this.mMediaControlAPI.getPlayerService().resume(string, MediaControlCallback.NOP);
                break;
            }
            case 1079441840: {
                String string = eventGeneric.getString(0);
                this.mMediaControlAPI.getPlayerService().pause(string, MediaControlCallback.NOP);
                break;
            }
            case 1079441839: {
                String string = eventGeneric.getString(0);
                this.mDeviceList.toggleDeviceSelection(string);
                break;
            }
            case 1079441850: {
                this.mDeviceList.selectAll();
                break;
            }
            case 1079441849: {
                this.mDeviceList.deselectAll();
                break;
            }
            case 1079441848: {
                String string = eventGeneric.getString(0);
                String[] stringArray = this.mDeviceList.getSelectedDevices();
                this.mMediaControlAPI.getPlayerService().playTrack(stringArray, string, MediaControlCallback.NOP);
                break;
            }
            case 2200011: {
                boolean bl = eventGeneric.getBoolean(0);
                int n = 1;
                n = bl ? 1 : 0;
                ServiceManager.aslPropertyManager.valueChangedInteger(-1038067968, n);
                break;
            }
        }
    }
}

