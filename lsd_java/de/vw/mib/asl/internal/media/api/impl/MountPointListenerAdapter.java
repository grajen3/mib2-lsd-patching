/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.api.impl;

import de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationListener;
import de.vw.mib.asl.api.media.services.sources.medialist.MountPointListener;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;

public class MountPointListenerAdapter
implements MediaIndicationListener {
    private final int deviceType;
    private final int slot;
    private final MountPointListener listener;

    public MountPointListenerAdapter(int n, int n2, MountPointListener mountPointListener) {
        this.deviceType = n;
        this.slot = n2;
        this.listener = mountPointListener;
    }

    @Override
    public void onSourceChanged(Source source, Source source2) {
        if (!(source.getSourceId().getDeviceType() != this.deviceType || source.getSourceId().getSlot() != this.slot || source2 != null && StringUtil.equals(source.getMountPoint(), source2.getMountPoint()))) {
            this.listener.updateMountPoint(source.getMountPoint());
        }
    }
}

