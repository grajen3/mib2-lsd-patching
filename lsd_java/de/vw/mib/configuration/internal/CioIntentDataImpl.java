/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.app.framework.assembly.AppDefinitionData;
import de.vw.mib.app.framework.assembly.CioIntentClassData;
import de.vw.mib.app.framework.assembly.CioIntentData;
import de.vw.mib.app.framework.assembly.CioVisualizationData;

public class CioIntentDataImpl
implements CioIntentData {
    private AppDefinitionData app;
    private int actionId;
    private String cioName;
    private CioIntentClassData cioIntentClass;
    private CioVisualizationData[] cioVisualizations;
    private String intentName;
    private int featureFlagId;
    private String forwardedCioIntentClassName;
    private String forwardedUsageName;
    private int rank;
    private String usage;

    public CioIntentDataImpl(AppDefinitionData appDefinitionData, int n, String string, CioIntentClassData cioIntentClassData, CioVisualizationData cioVisualizationData, String string2, int n2, int n3, String string3) {
        this.app = appDefinitionData;
        this.actionId = n;
        this.cioName = string;
        this.cioIntentClass = cioIntentClassData;
        this.cioVisualizations = new CioVisualizationData[]{cioVisualizationData};
        this.intentName = string2;
        this.featureFlagId = n2;
        this.rank = n3;
        this.usage = string3;
    }

    public CioIntentDataImpl(AppDefinitionData appDefinitionData, int n, String string, CioIntentClassData cioIntentClassData, CioVisualizationData[] cioVisualizationDataArray, String string2, int n2, int n3, String string3) {
        this.app = appDefinitionData;
        this.actionId = n;
        this.cioName = string;
        this.cioIntentClass = cioIntentClassData;
        this.cioVisualizations = cioVisualizationDataArray;
        this.intentName = string2;
        this.featureFlagId = n2;
        this.rank = n3;
        this.usage = string3;
    }

    public CioIntentDataImpl(AppDefinitionData appDefinitionData, int n, String string, CioIntentClassData cioIntentClassData, CioVisualizationData[] cioVisualizationDataArray, String string2, int n2, int n3, String string3, String string4, String string5) {
        this.app = appDefinitionData;
        this.actionId = n;
        this.cioName = string;
        this.cioIntentClass = cioIntentClassData;
        this.cioVisualizations = cioVisualizationDataArray;
        this.intentName = string2;
        this.featureFlagId = n2;
        this.rank = n3;
        this.usage = string3;
        this.forwardedCioIntentClassName = string4;
        this.forwardedUsageName = string5;
    }

    @Override
    public AppDefinitionData getApp() {
        return this.app;
    }

    @Override
    public int getActionId() {
        return this.actionId;
    }

    @Override
    public String getCioName() {
        return this.cioName;
    }

    @Override
    public CioIntentClassData getCioIntentClass() {
        return this.cioIntentClass;
    }

    @Override
    public CioVisualizationData[] getCioVisualizations() {
        return this.cioVisualizations;
    }

    @Override
    public boolean isForwardingCioIntent() {
        return this.getForwardedCioIntentClassName() != null && this.getForwardedCioIntentClassName().length() > 0;
    }

    @Override
    public String getForwardedCioIntentClassName() {
        return this.forwardedCioIntentClassName;
    }

    @Override
    public String getForwardedUsageName() {
        return this.forwardedUsageName;
    }

    @Override
    public String getIntentName() {
        return this.intentName;
    }

    @Override
    public int getFeatureFlagId() {
        return this.featureFlagId;
    }

    @Override
    public int getRank() {
        return this.rank;
    }

    @Override
    public String getUsage() {
        return this.usage;
    }
}

