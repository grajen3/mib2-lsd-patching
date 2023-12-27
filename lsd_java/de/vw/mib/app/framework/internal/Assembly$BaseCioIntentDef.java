/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.cio.app.framework.CioIntentDefinition;
import de.vw.mib.util.StringBuilder;

abstract class Assembly$BaseCioIntentDef
implements CioIntentDefinition {
    private final AppDefinition appDefinition;

    Assembly$BaseCioIntentDef(AppDefinition appDefinition) {
        this.appDefinition = appDefinition;
    }

    @Override
    public int getActionId() {
        return -1;
    }

    @Override
    public String getAppInstanceName() {
        return this.appDefinition.getAppInstanceName();
    }

    @Override
    public String getAppName() {
        return this.appDefinition.getAppName();
    }

    @Override
    public String[] getCioVisualizationNames() {
        return null;
    }

    @Override
    public int getFeatureFlagId() {
        return -1;
    }

    @Override
    public String getForwardedCioIntentClassName() {
        return null;
    }

    @Override
    public String getForwardedUsageName() {
        return null;
    }

    @Override
    public int getRank() {
        return -1;
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public boolean isForwardingCioIntent() {
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CioIntent - ");
        stringBuilder.append("cio name: ").append(this.getCioName());
        stringBuilder.append(", cio intent name: ").append(this.getIntentName());
        stringBuilder.append(", cio intent class: ").append(this.getCioIntentClassName());
        if (this.isForwardingCioIntent()) {
            stringBuilder.insert(0, "Forwarding");
            stringBuilder.append(", forward to cio intent class: ").append(this.getForwardedCioIntentClassName());
            stringBuilder.append(", forward to usage: ").append(this.getForwardedUsageName());
        }
        return stringBuilder.toString();
    }
}

