/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.common;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingFactory;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.common.AbstractComponent;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public abstract class AbstractMediaTarget
extends AbstractComponent
implements MediaListObserver {
    private static final int RT_WAIT_FOR_FLAG = AbstractMediaTarget.assignRequestId();
    MediaCollector mRequestedMedia;
    private int mRequestedFlag;
    private boolean mRequestedFlagSet;

    public AbstractMediaTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        ASLDeviceHandlingFactory.getDeviceHandlingApi().register(this);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 1024;
    }

    protected EventGeneric newEvent(int n, int n2) {
        return ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), n, n2);
    }

    protected EventGeneric newEvent(int n, int n2, int n3) {
        return ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), n, n3, n2);
    }

    protected EventGeneric newServiceEvent(int n) {
        return ServiceManager.mGenericEventFactory.newEvent(n);
    }

    protected boolean isTimerActive(int n) {
        return this.getTimerServer().isTimerActive(this.getTargetId(), n);
    }

    protected void valueChangedBoolean(int n, boolean bl) {
        AbstractMediaTarget.writeBooleanToDatapool(n, bl);
    }

    public void valueChangedInteger(int n, int n2) {
        AbstractMediaTarget.writeIntegerToDatapool(n, n2);
    }

    public void rqWaitForFlag(MediaCollector mediaCollector, int n, boolean bl, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_WAIT_FOR_FLAG, responseHandler)) {
            this.mRequestedMedia = mediaCollector;
            this.mRequestedFlag = n;
            this.mRequestedFlagSet = bl;
            this.detectFlagRequestCompletion();
        }
    }

    private void detectFlagRequestCompletion() {
        if (this.isRegisteredForResponse(RT_WAIT_FOR_FLAG) && this.mRequestedFlagSet == this.mRequestedMedia.isFlagSet(this.mRequestedFlag)) {
            this.fireResponse(true, new StringBuffer().append(MediaBrowserHelper.getMediaFlagsStr(this.mRequestedFlag)).append(this.mRequestedFlagSet ? " part of " : " not part of ").append(this.mRequestedMedia.toStringShort()).toString());
        }
    }

    @Override
    public void onUpdate(Devices devices) {
        this.detectFlagRequestCompletion();
        this.onDevicesUpdated();
    }

    public void onDevicesUpdated() {
    }
}

