/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.api.media.services.sources.medialist.MountPointListener;

public class SDCardMountPoint
implements MountPointListener {
    private String path;

    @Override
    public void updateMountPoint(String string) {
        this.path = string;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String string) {
        this.path = string;
    }
}

