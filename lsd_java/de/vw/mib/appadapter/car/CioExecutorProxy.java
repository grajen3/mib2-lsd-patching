/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.car;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;

public class CioExecutorProxy
implements CioExecutor {
    CioExecutor[] cioExecutors;

    public CioExecutorProxy(CioExecutor[] cioExecutorArray) {
        this.cioExecutors = cioExecutorArray;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        for (int i2 = 0; i2 < this.cioExecutors.length; ++i2) {
            this.cioExecutors[i2].execute(contentInformationObject, cioActionParameters);
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

