/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.InputField;

class InputField$1
implements Runnable {
    private final /* synthetic */ InputField this$0;

    InputField$1(InputField inputField) {
        this.this$0 = inputField;
    }

    @Override
    public void run() {
        this.this$0.setCursorVisible(!this.this$0.isCursorVisible());
        this.this$0.repaintParent();
    }
}

