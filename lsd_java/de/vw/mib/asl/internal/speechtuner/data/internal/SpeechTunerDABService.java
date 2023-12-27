/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.internal;

import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerStation;

public class SpeechTunerDABService
extends SpeechTunerStation {
    private String ensemblename;

    public SpeechTunerDABService(String string, int n) {
        super(string, n);
    }

    public SpeechTunerDABService(long l, String string, String string2) {
        this.objectID = l;
        this.name = string;
        this.ensemblename = string2;
    }

    public String getEnsembleName() {
        return this.ensemblename;
    }
}

