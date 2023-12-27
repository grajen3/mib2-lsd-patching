/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ic.mqb.pq;

import de.vw.mib.asl.api.ic.mqb.pq.ASLICMQBPQAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLICMQBPQFactory
extends ASLFactoryBase {
    private static ASLICMQBPQAPI apiInstance = null;

    public static ASLICMQBPQAPI getICMQBPQApi() {
        if (apiInstance == null) {
            // empty if block
        }
        return apiInstance;
    }
}

