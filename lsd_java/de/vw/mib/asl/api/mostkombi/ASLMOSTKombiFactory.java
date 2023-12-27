/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mostkombi;

import de.vw.mib.asl.api.mostkombi.ASLMOSTKombiAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLMOSTKombiFactory
extends ASLFactoryBase {
    private static ASLMOSTKombiAPI apiInstance = null;

    public static ASLMOSTKombiAPI getMOSTKombiApi() {
        if (apiInstance == null) {
            // empty if block
        }
        return apiInstance;
    }
}

