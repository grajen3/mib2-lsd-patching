/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.framework.api.displaymanagement.displayable.DisplayableServiceAdapter;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoGlobalProperties;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.StartupHandler;

public class DisplayableListener
extends DisplayableServiceAdapter {
    private AndroidAutoTarget target;
    private AndroidAutoGlobalProperties properties;
    private StartupHandler startupHandler;

    public DisplayableListener(AndroidAutoTarget androidAutoTarget, AndroidAutoGlobalProperties androidAutoGlobalProperties, StartupHandler startupHandler) {
        this.target = androidAutoTarget;
        this.properties = androidAutoGlobalProperties;
        this.startupHandler = startupHandler;
    }

    @Override
    public void onDisplayableHidden(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("DisplayableListener::onDisplayableHidden - displayable = ").append(n).toString());
        }
        if (n == 4 && this.startupHandler.isDeviceConnected()) {
            if (this.properties.getVideoFocusState() != 2 && this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
                this.target.getDSIAndroidAuto2().videoFocusNotification(2, true);
            }
            this.properties.setVideoFocusState(2);
        }
    }

    @Override
    public void onDisplayableShown(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("DisplayableListener::onDisplayableShown - displayable = ").append(n).toString());
        }
        if (n == 4 && this.startupHandler.isDeviceConnected()) {
            if (this.properties.getVideoFocusState() != 1 && this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
                this.target.getDSIAndroidAuto2().videoFocusNotification(1, true);
            }
            this.properties.setVideoFocusState(1);
        }
    }
}

