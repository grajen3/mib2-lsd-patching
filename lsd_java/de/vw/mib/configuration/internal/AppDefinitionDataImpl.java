/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.app.framework.assembly.AppDefinitionData;
import de.vw.mib.app.framework.assembly.CioIntentData;
import java.util.Map;
import java.util.Properties;

public class AppDefinitionDataImpl
implements AppDefinitionData {
    private final String name;
    private final String type;
    private Map providedContent;
    private String[] providedScreenAreas;
    private Map usedScreenAreas;
    private AppDefinitionData[] mandatoryHostedApps;
    private AppDefinitionData[] optionalHostedApps;
    private AppDefinitionData[] lazyStartingHostedApps;
    private String[] neededBusinessComponents = new String[0];
    private String appAdapterClassName;
    private int appInstanceId;
    private String appInstanceName;
    private CioIntentData[] cioIntents = new CioIntentData[0];
    private int uniqueId;

    public AppDefinitionDataImpl(String string, String string2, int n, int n2, String string3) {
        this.name = string;
        this.appInstanceName = string2;
        this.appInstanceId = n;
        this.uniqueId = n2;
        this.type = string3;
    }

    @Override
    public String getAppAdapterClassName() {
        return this.appAdapterClassName;
    }

    public void setAppAdapterClassName(String string) {
        this.appAdapterClassName = string;
    }

    @Override
    public int getAppInstanceId() {
        return this.appInstanceId;
    }

    public void setAppInstanceId(int n) {
        this.appInstanceId = n;
    }

    @Override
    public String getAppInstanceName() {
        return this.appInstanceName;
    }

    public void setAppInstanceName(String string) {
        this.appInstanceName = string;
    }

    @Override
    public String getAppName() {
        return this.name;
    }

    @Override
    public String getAppType() {
        return this.type;
    }

    @Override
    public CioIntentData[] getCioIntents() {
        return this.cioIntents;
    }

    public void setCioIntents(CioIntentData[] cioIntentDataArray) {
        this.cioIntents = cioIntentDataArray;
    }

    @Override
    public AppDefinitionData[] getMandatoryHostedApps() {
        return this.mandatoryHostedApps;
    }

    public void setMandatoryHostedApps(AppDefinitionData[] appDefinitionDataArray) {
        this.mandatoryHostedApps = appDefinitionDataArray;
    }

    @Override
    public AppDefinitionData[] getOptionalHostedApps() {
        return this.optionalHostedApps;
    }

    public void setOptionalHostedApps(AppDefinitionData[] appDefinitionDataArray) {
        this.optionalHostedApps = appDefinitionDataArray;
    }

    @Override
    public AppDefinitionData[] getLazyStartingHostedApps() {
        return this.lazyStartingHostedApps;
    }

    public void setLazyStartingHostedApps(AppDefinitionData[] appDefinitionDataArray) {
        this.lazyStartingHostedApps = appDefinitionDataArray;
    }

    @Override
    public String[] getNeededBusinessComponents() {
        return this.neededBusinessComponents;
    }

    @Override
    public Properties getParameters() {
        return null;
    }

    @Override
    public Map getProvidedContent() {
        return this.providedContent;
    }

    public void setProvidedContent(Map map) {
        this.providedContent = map;
    }

    @Override
    public String[] getProvidedScreenAreas() {
        return this.providedScreenAreas;
    }

    public void setProvidedScreenAreas(String[] stringArray) {
        this.providedScreenAreas = stringArray;
    }

    @Override
    public int getUniqueId() {
        return this.uniqueId;
    }

    @Override
    public Map getUsedScreenAreas() {
        return this.usedScreenAreas;
    }

    public void setUsedScreenAreas(Map map) {
        this.usedScreenAreas = map;
    }

    public String toString() {
        return new StringBuffer().append("AppDef: ").append(this.getAppName()).toString();
    }
}

