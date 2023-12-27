/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services;

import de.vw.mib.asl.api.media.services.ResultCode$1;
import de.vw.mib.asl.api.media.services.ResultCode$2;

public interface ResultCode {
    public static final ResultCode NOK = new ResultCode$1();
    public static final ResultCode OK = new ResultCode$2();
}

