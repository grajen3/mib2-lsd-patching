/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

public class LscListenerItem {
    private int aslId;
    private int listenerType;
    private String initLanguage;
    private int initSkin;
    private int initSkinmode;

    public LscListenerItem(int n, int n2, String string, int n3, int n4) {
        this.aslId = n;
        this.listenerType = n2;
        this.initLanguage = string;
        this.initSkin = n3;
        this.initSkinmode = n4;
    }

    public int getAslId() {
        return this.aslId;
    }

    public int getListenerType() {
        return this.listenerType;
    }

    public String getInitLanguage() {
        return this.initLanguage;
    }

    public int getInitSkin() {
        return this.initSkin;
    }

    public int getInitSkinmode() {
        return this.initSkinmode;
    }
}

