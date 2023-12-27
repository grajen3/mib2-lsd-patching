/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi;

import de.vw.mib.asl.clientapi.ASLClientAPIResources;
import de.vw.mib.asl.clientapi.ASLClientAPIStateListener;

public interface ASLClientAPIServiceInitData {
    default public ASLClientAPIStateListener getStateListener() {
    }

    default public ASLClientAPIResources getResources() {
    }
}

