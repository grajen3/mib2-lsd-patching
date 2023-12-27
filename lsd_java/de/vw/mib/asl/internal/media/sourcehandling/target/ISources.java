/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.target;

import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public interface ISources {
    default public void rqRequestSourceActivation(MediaCollector mediaCollector, ResponseHandler responseHandler) {
    }

    default public void beginActivation() {
    }

    default public void endActivation(MediaCollector mediaCollector, CommandState commandState, boolean bl) {
    }

    default public void endDeactivation(MediaCollector mediaCollector, CommandState commandState, boolean bl) {
    }

    default public MediaCollector getSourceByID(int n) {
    }

    default public MediaCollector getHDD() {
    }

    default public boolean isCancelPending() {
    }

    default public boolean isDeviceValid(MediaCollector mediaCollector) {
    }

    default public boolean checkSource(MediaCollector mediaCollector) {
    }

    default public void resetToFactorySettings() {
    }

    default public void setDisconnectedState(MediaCollector mediaCollector) {
    }

    default public void setDisconnectedStateWithCallback(CommandCallback commandCallback) {
    }

    default public boolean isMediaContext() {
    }

    default public void disconnectBluetooth(MediaCollector mediaCollector) {
    }

    default public MediaCollector getCollector(SourceId sourceId) {
    }

    default public MediaCollector getSourceById(long l, long l2) {
    }
}

