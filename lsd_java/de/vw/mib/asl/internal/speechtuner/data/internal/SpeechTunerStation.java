/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.data.internal;

public abstract class SpeechTunerStation {
    protected int numberOfSubitems = 0;
    protected long objectID = -1L;
    protected String name;

    public SpeechTunerStation() {
    }

    public SpeechTunerStation(String string, int n) {
        this.name = string;
        this.numberOfSubitems = n;
    }

    public int getNumberOfSubitems() {
        return this.numberOfSubitems;
    }

    public long getObjectID() {
        return this.objectID;
    }

    public String getName() {
        return this.name;
    }
}

