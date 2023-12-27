/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.asl.internal.system.input.InputDeviceRegistrator;
import de.vw.mib.asl.internal.system.input.InputDeviceRegistrator$1;
import de.vw.mib.input.InputManager;

class InputDeviceRegistrator$1$1
implements Runnable {
    private final /* synthetic */ InputManager val$inputManager;
    private final /* synthetic */ InputDeviceRegistrator$1 this$1;

    InputDeviceRegistrator$1$1(InputDeviceRegistrator$1 inputDeviceRegistrator$1, InputManager inputManager) {
        this.this$1 = inputDeviceRegistrator$1;
        this.val$inputManager = inputManager;
    }

    @Override
    public void run() {
        InputDeviceRegistrator.access$200(InputDeviceRegistrator$1.access$100(this.this$1), this.val$inputManager);
        InputDeviceRegistrator.access$300(InputDeviceRegistrator$1.access$100(this.this$1), this.val$inputManager);
    }
}

