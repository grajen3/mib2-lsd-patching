/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlResultCode$1;
import de.vw.mib.asl.api.mediacontrol.services.MediaControlResultCode$2;

public interface MediaControlResultCode {
    public static final MediaControlResultCode NOK = new MediaControlResultCode$1();
    public static final MediaControlResultCode OK = new MediaControlResultCode$2();
}

