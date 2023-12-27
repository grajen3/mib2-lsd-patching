/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.ContentInformationObject;

public interface CioExecutor {
    public static final boolean ALLOW_REGISTRATION;
    public static final boolean DENY_REGISTRATION;

    default public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
    }

    default public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
    }
}

