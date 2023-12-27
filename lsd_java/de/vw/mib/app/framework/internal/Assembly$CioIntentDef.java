/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.assembly.CioIntentData;
import de.vw.mib.app.framework.assembly.CioVisualizationData;
import de.vw.mib.app.framework.internal.Assembly$BaseCioIntentDef;

final class Assembly$CioIntentDef
extends Assembly$BaseCioIntentDef {
    private final CioIntentData data;
    private final String intentClassName;
    private final String[] visualizationNames;

    Assembly$CioIntentDef(AppDefinition appDefinition, CioIntentData cioIntentData) {
        super(appDefinition);
        this.data = cioIntentData;
        this.intentClassName = cioIntentData.getCioIntentClass().getName();
        this.visualizationNames = this.getCioVisualizationNames(cioIntentData.getCioVisualizations());
    }

    @Override
    public int getActionId() {
        return this.data.getActionId();
    }

    @Override
    public String getCioName() {
        return this.data.getCioName();
    }

    @Override
    public String getCioIntentClassName() {
        return this.intentClassName;
    }

    @Override
    public String[] getCioVisualizationNames() {
        return this.visualizationNames;
    }

    @Override
    public String getIntentName() {
        return this.data.getIntentName();
    }

    @Override
    public int getFeatureFlagId() {
        return this.data.getFeatureFlagId();
    }

    @Override
    public String getForwardedCioIntentClassName() {
        return this.data.getForwardedCioIntentClassName();
    }

    @Override
    public String getForwardedUsageName() {
        return this.data.getForwardedUsageName();
    }

    @Override
    public int getRank() {
        return this.data.getRank();
    }

    @Override
    public String getUsage() {
        return this.data.getUsage();
    }

    @Override
    public boolean isForwardingCioIntent() {
        return this.data.isForwardingCioIntent();
    }

    private String[] getCioVisualizationNames(CioVisualizationData[] cioVisualizationDataArray) {
        if (cioVisualizationDataArray == null || cioVisualizationDataArray.length == 0) {
            return new String[0];
        }
        String[] stringArray = new String[cioVisualizationDataArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringArray[i2] = cioVisualizationDataArray[i2] == null ? null : cioVisualizationDataArray[i2].getName();
        }
        return stringArray;
    }
}

