/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.internal.Assembly$BaseCioIntentDef;

final class Assembly$ShowContentCioIntentDef
extends Assembly$BaseCioIntentDef {
    private final String contentId;

    Assembly$ShowContentCioIntentDef(AppDefinition appDefinition, String string) {
        super(appDefinition);
        this.contentId = string;
    }

    @Override
    public String getCioIntentClassName() {
        return "ShowContent";
    }

    @Override
    public String getCioName() {
        return "ShowContent";
    }

    @Override
    public String getIntentName() {
        return "ShowContent";
    }

    @Override
    public String getUsage() {
        return this.contentId;
    }
}

