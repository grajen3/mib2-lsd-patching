/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal;

import de.vw.mib.asl.internal.registry.ASLDevice;
import de.vw.mib.asl.internal.registry.ASLDeviceAction;
import de.vw.mib.genericevents.ServiceRegister;

final class StartUpUtil$1
implements ASLDeviceAction {
    private final /* synthetic */ ServiceRegister val$register;

    StartUpUtil$1(ServiceRegister serviceRegister) {
        this.val$register = serviceRegister;
    }

    @Override
    public void execute(ASLDevice aSLDevice) {
        aSLDevice.registerASLServices(this.val$register);
    }
}

