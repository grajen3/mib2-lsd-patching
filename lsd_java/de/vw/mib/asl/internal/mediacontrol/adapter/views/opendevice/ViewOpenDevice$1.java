/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice;

import de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice.ViewOpenDevice;

class ViewOpenDevice$1
implements Runnable {
    private final /* synthetic */ ViewOpenDevice this$0;

    ViewOpenDevice$1(ViewOpenDevice viewOpenDevice) {
        this.this$0 = viewOpenDevice;
    }

    @Override
    public void run() {
        if (ViewOpenDevice.access$000(this.this$0) != 0) {
            ViewOpenDevice.access$100(this.this$0, ViewOpenDevice.access$000(this.this$0));
            ViewOpenDevice.access$002(this.this$0, 0);
        }
    }
}

