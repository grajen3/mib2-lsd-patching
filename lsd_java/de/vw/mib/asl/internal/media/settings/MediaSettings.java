/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.common.AbstractMediaTarget;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.persistence.MediaPersistence;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public final class MediaSettings
extends AbstractMediaTarget {
    public static final int EV_PROFILE_CHANGE;
    private static final int[] OBSERVER;
    private boolean includeSubfolder = true;
    private static final int RT_INCLUDE_SUBFOLDER;

    public MediaSettings(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 380572416;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.initializeSettings();
                EventGeneric eventGeneric2 = this.newEvent(279909120, -1501167360);
                eventGeneric2.setObject(0, this);
                this.sendSafe(eventGeneric2);
                this.addObservers(OBSERVER);
                if (!this.isTraceEnabled()) break;
                this.trace("SETTINGS TARGETS ~ TargetSettings -> POWERED ON");
                break;
            }
            case 107: {
                this.removeObservers(OBSERVER);
                if (!this.isTraceEnabled()) break;
                this.trace("SETTINGS TARGETS ~ TargetSettings -> POWERED OFF");
                break;
            }
            case 1073743816: {
                this.toggleIncludeSubfolder();
                this.fireResponse(true, RT_INCLUDE_SUBFOLDER);
                break;
            }
            case 1073743952: {
                this.fireResponse(true, RT_INCLUDE_SUBFOLDER);
                break;
            }
            case 100001: {
                this.initializeSettings();
                break;
            }
        }
    }

    private void initializeSettings() {
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            ServiceManager.logger.trace(1024).append("MediaSettings.initializeSettings()").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(4, false);
        this.includeSubfolder = MediaObjectAccessor.getPersistence().isIncludeSubfolders();
        this.notifyIncludeSubfoldersSettingToModel(this.includeSubfolder);
    }

    public void resetToFactorySettings() {
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            ServiceManager.logger.trace(1024).append("MediaSettings.resetToFactorySettings()").log();
        }
        MediaPersistence mediaPersistence = MediaObjectAccessor.getPersistence();
        this.includeSubfolder = true;
        mediaPersistence.setIsIncludeSubfolders(this.includeSubfolder);
        this.notifyIncludeSubfoldersSettingToModel(this.includeSubfolder);
    }

    private void notifyIncludeSubfoldersSettingToModel(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            ServiceManager.logger.trace(1024).append("MediaSettings.notifyIncludeSubfoldersSettingToModel()").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(41, bl);
    }

    public void toggleIncludeSubfolder() {
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            ServiceManager.logger.trace(1024).append("MediaSettings.toggleIncludeSubfolder()").log();
        }
        this.includeSubfolder = !this.includeSubfolder;
        this.notifyIncludeSubfoldersSettingToModel(this.includeSubfolder);
        MediaObjectAccessor.getPersistence().setIsIncludeSubfolders(this.includeSubfolder);
    }

    public boolean getIncludeSubfolder() {
        return this.includeSubfolder;
    }

    public void rqIncludeSubfolder(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_INCLUDE_SUBFOLDER, responseHandler)) {
            if (this.includeSubfolder) {
                this.fireResponse(true);
            } else {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(5);
            }
        }
    }

    @Override
    public int getComponentId() {
        return 16;
    }

    static {
        OBSERVER = new int[]{-939065280, 1342701632};
        RT_INCLUDE_SUBFOLDER = MediaSettings.assignRequestId();
    }
}

