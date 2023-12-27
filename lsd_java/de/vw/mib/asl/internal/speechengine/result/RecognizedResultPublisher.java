/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result;

import org.dsi.ifc.speechrec.NBestList;

public interface RecognizedResultPublisher {
    default public void publish(int n, int n2, NBestList nBestList) {
    }
}

