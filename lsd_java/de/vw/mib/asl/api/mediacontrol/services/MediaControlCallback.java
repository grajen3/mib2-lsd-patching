/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlCallback$1;
import de.vw.mib.asl.api.mediacontrol.services.MediaControlResultCode;

public interface MediaControlCallback {
    public static final MediaControlCallback NOP = new MediaControlCallback$1();

    default public void response(MediaControlResultCode mediaControlResultCode) {
    }
}

