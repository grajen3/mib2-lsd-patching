/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services;

import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;

public interface SourceCallback {
    default public void response(ResultCode resultCode, Source source) {
    }
}

