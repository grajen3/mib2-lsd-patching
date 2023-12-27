/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.data.internal;

public abstract class AbstractNBestModel {
    protected int numberOfSubitems = 0;
    protected String name;

    public AbstractNBestModel() {
    }

    public AbstractNBestModel(String string, int n) {
        this.setName(string);
        this.setNumberOfSubitems(n);
    }

    public int getNumberOfSubitems() {
        return this.numberOfSubitems;
    }

    public void setNumberOfSubitems(int n) {
        this.numberOfSubitems = n;
    }

    public abstract long getObjectID() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }
}

