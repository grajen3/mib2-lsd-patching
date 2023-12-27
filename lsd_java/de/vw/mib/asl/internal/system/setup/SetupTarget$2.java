/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.setup;

import de.vw.mib.asl.internal.system.setup.SetupTarget;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;

class SetupTarget$2
implements CioExecutor {
    private final /* synthetic */ SetupTarget this$0;

    SetupTarget$2(SetupTarget setupTarget) {
        this.this$0 = setupTarget;
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        this.this$0.showSystemSetup();
    }
}

