/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.app.framework.assembly.CioFilterData$CioFilterEntry;

final class CioFilterDataImpl$CioFilterEntryImpl
implements CioFilterData$CioFilterEntry {
    private final String appNameRef;
    private final String appInstanceNameRef;
    private final String cioNameRef;
    private final String cioIntentNameRef;

    public CioFilterDataImpl$CioFilterEntryImpl(String string, String string2, String string3, String string4) {
        this.appNameRef = string;
        this.appInstanceNameRef = string2;
        this.cioNameRef = string3;
        this.cioIntentNameRef = string4;
    }

    @Override
    public String getAppNameRef() {
        return this.appNameRef;
    }

    @Override
    public String getAppInstanceNameRef() {
        return this.appInstanceNameRef;
    }

    @Override
    public String getCioNameRef() {
        return this.cioNameRef;
    }

    @Override
    public String getCioIntentNameRef() {
        return this.cioIntentNameRef;
    }
}

