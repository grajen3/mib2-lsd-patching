/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ic.mqb2;

import de.vw.mib.asl.api.ic.mqb2.ASLICMQB2API;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLICMQB2Factory
extends ASLFactoryBase {
    private static ASLICMQB2API apiInstance = null;

    public static ASLICMQB2API getICMQB2Api() {
        if (apiInstance == null) {
            // empty if block
        }
        return apiInstance;
    }
}

