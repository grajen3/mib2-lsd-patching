/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.popup;

import de.vw.mib.asl.api.system.powerstate.ClampSignalAdapter;
import de.vw.mib.asl.internal.globalgoodbye.popup.Controller;

class Controller$1
extends ClampSignalAdapter {
    private final /* synthetic */ Controller this$0;

    Controller$1(Controller controller) {
        this.this$0 = controller;
    }

    @Override
    public void onClampSValueChanged(boolean bl) {
        this.this$0.processClampSChange(bl);
    }
}

