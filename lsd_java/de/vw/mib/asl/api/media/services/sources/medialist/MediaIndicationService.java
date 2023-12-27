/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.sources.medialist;

import de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationListener;
import de.vw.mib.asl.api.media.services.sources.medialist.MountPointListener;

public interface MediaIndicationService {
    default public void registerMediaIndicationListener(MediaIndicationListener mediaIndicationListener) {
    }

    default public void registerSystemIndicationListener(MediaIndicationListener mediaIndicationListener) {
    }

    default public void registerMountPointListenerSD(MountPointListener mountPointListener, int n) {
    }

    default public MediaIndicationListener filterDeviceType(int[] nArray, MediaIndicationListener mediaIndicationListener) {
    }

    default public MediaIndicationListener filterInsertionStatus(MediaIndicationListener mediaIndicationListener) {
    }
}

