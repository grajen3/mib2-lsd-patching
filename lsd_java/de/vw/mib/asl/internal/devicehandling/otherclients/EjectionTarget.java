/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling.otherclients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.sources.MediaEjectionService;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.devicehandling.DeviceHandlingTarget;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.controller.commands.base.CmdEjectSource;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.Iterator;

public final class EjectionTarget
extends AbstractASLTarget
implements MediaListObserver,
MediaEjectionService {
    private static final int[] OBSERVER_EJECT = new int[]{1023737920, 161300736, 1711603776, 355798080};
    private final DeviceHandlingTarget deviceHandlingTarget;
    private Device ejectedMedia;
    private Devices devices;
    private final ObjectObjectOptHashMap ejectionRequests = new ObjectObjectOptHashMap();
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService;

    public EjectionTarget(GenericEvents genericEvents, String string, DeviceHandlingTarget deviceHandlingTarget) {
        super(genericEvents, string);
        this.deviceHandlingTarget = deviceHandlingTarget;
    }

    @Override
    public int getDefaultTargetId() {
        return 1974407936;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.addObservers(OBSERVER_EJECT);
                ASLComponentRegistry aSLComponentRegistry = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry();
                if (aSLComponentRegistry.getAPIInstance(class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService == null ? (class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService = EjectionTarget.class$("de.vw.mib.asl.api.media.services.sources.MediaEjectionService")) : class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService) != null) break;
                aSLComponentRegistry.registerAPI(class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService == null ? (class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService = EjectionTarget.class$("de.vw.mib.asl.api.media.services.sources.MediaEjectionService")) : class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService, this);
                break;
            }
            case 107: {
                this.removeObservers(OBSERVER_EJECT);
                break;
            }
            case 1073743206: {
                int n = eventGeneric.getInt(0);
                this.ejectMedium(this.devices.getByDeviceType(1, n));
                break;
            }
            case 4300041: 
            case 1073743165: {
                this.ejectOptical();
                break;
            }
            case 1074541845: {
                this.ejectMedium(this.devices.getByDeviceType(2, eventGeneric.getInt(0)));
                break;
            }
        }
    }

    private void ejectOptical() {
        this.ejectedMedia = this.devices.getInternalOptical();
        if (this.isOpticalMediaEjectable()) {
            this.sendHMIEvent(406);
        } else {
            this.sendHMIEvent(413);
        }
        this.ejectMedium(this.ejectedMedia);
    }

    private boolean isOpticalMediaEjectable() {
        return this.ejectedMedia != null && this.ejectedMedia.getMedium(0).getCurrentInfo().getMediaType() != 10;
    }

    private void ejectMedium(Device device) {
        if (device != null) {
            this.ejectedMedia = device;
            for (int i2 = 0; i2 < this.ejectedMedia.getMediumCount(); ++i2) {
                Medium medium = this.ejectedMedia.getMedium(i2);
                if (!medium.getCurrentState().isInserted() && this.ejectedMedia.getMediumCount() != 1) continue;
                this.deviceHandlingTarget.eject(medium);
            }
        }
    }

    private boolean checkUnmountProgress(Device device) {
        if (device.getMedium(0).getCurrentInfo().getMediaType() == 10) {
            switch (device.getCurrentInfo().getDeviceType()) {
                case 1: {
                    if (device.getSlot() == 0) {
                        this.sendHMIEvent(363);
                        break;
                    }
                    this.sendHMIEvent(370);
                    break;
                }
                case 2: {
                    if (device.getSlot() == 0) {
                        this.sendHMIEvent(384);
                        this.sendHMIEvent(385);
                        break;
                    }
                    this.sendHMIEvent(548);
                    this.sendHMIEvent(549);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void onUpdate(Devices devices) {
        this.devices = devices;
        if (this.ejectedMedia != null && this.checkUnmountProgress(this.ejectedMedia)) {
            this.ejectedMedia = null;
        }
        this.checkEjectionRequests();
    }

    @Override
    public void eject(SourceId sourceId, Callback callback) {
        Device device = this.devices.getBySourceId(sourceId);
        if (device == null) {
            throw new IllegalArgumentException(new StringBuffer().append("eject: ").append(sourceId).append(" does not exist.").toString());
        }
        MediaObjectAccessor.mMediaController.addCommand(new CmdEjectSource(this, device, callback));
    }

    public void requestEject(Device device, ResponseHandler responseHandler) {
        this.ejectMedium(device);
        if (!device.getCurrentState().isMediaInSlot()) {
            responseHandler.handleResponse(1, "Medium already ejected");
        } else {
            this.ejectionRequests.put(device, responseHandler);
        }
    }

    public void cancelEject(Device device) {
        this.ejectionRequests.remove(device);
    }

    private void checkEjectionRequests() {
        Iterator iterator = this.ejectionRequests.keyIterator();
        while (iterator.hasNext()) {
            Device device = (Device)iterator.next();
            if (device.getCurrentState().isMediaInSlot()) continue;
            ResponseHandler responseHandler = (ResponseHandler)this.ejectionRequests.get(device);
            iterator.remove();
            responseHandler.handleResponse(1, "ejection detected");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

