/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.devicehandling.clients.MediumChangeListener;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public class MediumPlayedDetector
extends MediumChangeListener {
    public MediumPlayedDetector(DeviceFilter deviceFilter) {
        super(deviceFilter);
    }

    @Override
    protected void onChange(Medium medium) {
        SourceHandlingPersistence.getInstance().checkVirginity(MediaCollector.get(medium));
    }
}

