/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9;

import com.microdoc.j9.Tools;

class Tools$1
extends Thread {
    private final /* synthetic */ int val$priority;
    private final /* synthetic */ Integer val$serverPort;

    Tools$1(int n, Integer n2) {
        this.val$priority = n;
        this.val$serverPort = n2;
    }

    @Override
    public void run() {
        this.setName("Thread Dump - Socket listener");
        this.setPriority(this.val$priority);
        Tools.access$0(this.val$serverPort);
    }
}

