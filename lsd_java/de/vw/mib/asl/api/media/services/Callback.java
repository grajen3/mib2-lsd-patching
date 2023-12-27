/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services;

import de.vw.mib.asl.api.media.services.ResultCode;

public interface Callback {
    default public void response(ResultCode resultCode) {
    }
}

