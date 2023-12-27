/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mediacontrol.services.browser;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlResultCode;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListEntry;

public interface MediaControlCallbackListRequest {
    default public void responseList(MediaControlListEntry[] mediaControlListEntryArray, int n, MediaControlResultCode mediaControlResultCode) {
    }
}

