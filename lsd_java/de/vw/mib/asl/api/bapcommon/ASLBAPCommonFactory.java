/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bapcommon;

import de.vw.mib.asl.api.bapcommon.ASLBAPCommonAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLBAPCommonFactory
extends ASLFactoryBase {
    private static ASLBAPCommonAPI apiInstance = null;

    public static ASLBAPCommonAPI getBAPCommonApi() {
        if (apiInstance == null) {
            // empty if block
        }
        return apiInstance;
    }
}

