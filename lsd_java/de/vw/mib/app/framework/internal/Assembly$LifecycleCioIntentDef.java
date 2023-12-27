/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.internal.Assembly$BaseCioIntentDef;

final class Assembly$LifecycleCioIntentDef
extends Assembly$BaseCioIntentDef {
    private final String intentClass;

    Assembly$LifecycleCioIntentDef(AppDefinition appDefinition, String string) {
        super(appDefinition);
        this.intentClass = string;
    }

    @Override
    public String getCioIntentClassName() {
        return this.intentClass;
    }

    @Override
    public String getCioName() {
        return this.intentClass;
    }

    @Override
    public String getIntentName() {
        return this.intentClass;
    }
}

