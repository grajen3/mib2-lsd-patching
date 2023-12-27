/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.sourcehandling;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.clients.DeviceChangeListener;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceList;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.media.MediaInfo;

public class FileBrowserConnector
extends DeviceChangeListener {
    private final FileBrowserSourceList fileBrowserSourceList;

    public FileBrowserConnector(FileBrowserSourceList fileBrowserSourceList) {
        super(DeviceFilter.REMOVABLE);
        this.fileBrowserSourceList = fileBrowserSourceList;
    }

    @Override
    protected void onChange(Device device) {
        Medium medium;
        int n;
        FileBrowserSourceInfo fileBrowserSourceInfo = FileBrowserSourceInfo.get(device);
        if (fileBrowserSourceInfo == null) {
            fileBrowserSourceInfo = new FileBrowserSourceInfo(device);
            this.fileBrowserSourceList.add(fileBrowserSourceInfo);
        } else {
            fileBrowserSourceInfo.sync();
        }
        for (n = 0; n < device.getMediumCount(); ++n) {
            medium = device.getMedium(n);
            if (!medium.getPreviousState().isPictureViewerAvailable() || medium.getCurrentState().isPictureViewerAvailable()) continue;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1306188288);
            eventGeneric.setObject(0, fileBrowserSourceInfo);
            eventGeneric.setInt(1, n);
            eventGeneric.setString(2, medium.getPreviousInfo().getMountPoint());
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
        for (n = 0; n < device.getMediumCount(); ++n) {
            medium = device.getMedium(n);
            if (!medium.getCurrentState().isPictureViewerAvailable() || medium.getCurrentState().isPictureViewerAvailable()) continue;
            this.reportAddedSource(fileBrowserSourceInfo, n);
        }
    }

    private void reportAddedSource(FileBrowserSourceInfo fileBrowserSourceInfo, int n) {
        MediaInfo mediaInfo = fileBrowserSourceInfo.getMediumAtIndex(n);
        if (mediaInfo != null && mediaInfo.getMediaType() != 19 && mediaInfo.getMediaType() != 17) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1322965504);
            eventGeneric.setObject(0, fileBrowserSourceInfo);
            eventGeneric.setInt(1, n);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
    }

    private void reportUpdatedSourceList() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, this.fileBrowserSourceList);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-1339742720, eventGeneric);
    }

    private void notify(int n, Device device) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, device != null && device.getCurrentState().isOperable() && device.getCurrentState().isAvailable());
    }

    @Override
    public void onUpdate(Devices devices) {
        super.onUpdate(devices);
        this.reportUpdatedSourceList();
        this.notify(2895, devices.getByDeviceType(1, 0));
        this.notify(2896, devices.getByDeviceType(1, 1));
        this.notify(3820, devices.getInternalOptical());
        this.notify(2897, devices.getByDeviceType(2, 0));
        this.notify(3819, devices.getByDeviceType(2, 1));
        ServiceManager.aslPropertyManager.valueChangedBoolean(419, false);
    }
}

