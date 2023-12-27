/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.browser;

import de.vw.mib.asl.api.media.services.ResultCode;
import java.util.List;

public interface MediaEntriesCallback {
    default public void responseMediaEntry(List list, ResultCode resultCode) {
    }
}

