/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation.lum;

import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarter;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.AbstractLumReadyOperation;

public class StartupAnimationSendLumReadyOperation
extends AbstractLumReadyOperation {
    public StartupAnimationSendLumReadyOperation(StartupServices startupServices, WorkUnitStarter workUnitStarter) {
        super(startupServices, workUnitStarter);
        this.sendLumReady();
    }
}

