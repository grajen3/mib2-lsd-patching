/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.assembly.CioIntentData;
import de.vw.mib.app.framework.internal.Assembly$CioIntentDef;
import de.vw.mib.cio.app.framework.CioIntentDefinition;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

final class Assembly$AppDef
implements AppDefinition {
    private final String appAdapterClassName;
    private final CioIntentDefinition[] cioIntents;
    private final ArrayList hostApps = new ArrayList();
    private final ArrayList hostedApps = new ArrayList();
    private final int instanceId;
    private final String instanceName;
    private final boolean mandatory;
    private final String name;
    private final String[] neededBusinessComponents;
    private final Properties parameters;
    private final String[] providedScreenAreas;
    private final String type;
    private final Map usedScreenAreas;
    private final int uniqueId;

    static Assembly$AppDef createAppDefinition(String string, int n, String string2, int n2, String string3, boolean bl, String[] stringArray, Map map, Properties properties, String[] stringArray2, CioIntentData[] cioIntentDataArray, String string4) {
        Assembly$AppDef assembly$AppDef = new Assembly$AppDef(string, n, string2, n2, string3, bl, stringArray, map, properties, stringArray2, cioIntentDataArray, string4);
        return assembly$AppDef;
    }

    static Assembly$AppDef createDesktopAppDefinition(String string, int n, String string2, int n2, String string3, String[] stringArray, Map map, Properties properties, String[] stringArray2, CioIntentData[] cioIntentDataArray, String string4) {
        Assembly$AppDef assembly$AppDef = new Assembly$AppDef(string, n, string2, n2, string3, true, stringArray, map, properties, stringArray2, cioIntentDataArray, string4);
        return assembly$AppDef;
    }

    private static CioIntentDefinition[] createCioIntentArray(AppDefinition appDefinition, CioIntentData[] cioIntentDataArray) {
        if (cioIntentDataArray == null) {
            return new CioIntentDefinition[0];
        }
        CioIntentDefinition[] cioIntentDefinitionArray = new CioIntentDefinition[cioIntentDataArray.length];
        for (int i2 = 0; i2 < cioIntentDataArray.length; ++i2) {
            cioIntentDefinitionArray[i2] = new Assembly$CioIntentDef(appDefinition, cioIntentDataArray[i2]);
        }
        return cioIntentDefinitionArray;
    }

    private Assembly$AppDef(String string, int n, String string2, int n2, String string3, boolean bl, String[] stringArray, Map map, Properties properties, String[] stringArray2, CioIntentData[] cioIntentDataArray, String string4) {
        this.name = string;
        this.instanceId = n;
        this.instanceName = string2;
        this.uniqueId = n2;
        this.type = string3;
        this.providedScreenAreas = stringArray;
        this.usedScreenAreas = map;
        this.neededBusinessComponents = stringArray2;
        this.parameters = properties;
        this.mandatory = bl;
        this.cioIntents = Assembly$AppDef.createCioIntentArray(this, cioIntentDataArray);
        this.appAdapterClassName = string4;
    }

    void addHostApp(Assembly$AppDef assembly$AppDef) {
        this.hostApps.add(assembly$AppDef);
    }

    void addHostedApp(Assembly$AppDef assembly$AppDef) {
        this.hostedApps.add(assembly$AppDef);
        assembly$AppDef.addHostApp(this);
    }

    boolean isHostApp(AppDefinition appDefinition) {
        return this.hostApps.contains(appDefinition);
    }

    @Override
    public String getAppAdapterClass() {
        return this.appAdapterClassName;
    }

    @Override
    public int getAppInstanceId() {
        return this.instanceId;
    }

    @Override
    public String getAppInstanceName() {
        return this.instanceName;
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
    public CioIntentDefinition[] getCioIntents() {
        return this.cioIntents;
    }

    @Override
    public AppDefinition[] getHostApps() {
        return (AppDefinition[])this.hostApps.toArray(new AppDefinition[0]);
    }

    @Override
    public AppDefinition[] getHostedApps() {
        return (AppDefinition[])this.hostedApps.toArray(new AppDefinition[0]);
    }

    @Override
    public String[] getNeededBusinessComponents() {
        return this.neededBusinessComponents;
    }

    @Override
    public Properties getParameters() {
        return this.parameters;
    }

    @Override
    public String[] getProvidedScreenAreas() {
        return this.providedScreenAreas;
    }

    @Override
    public int getUniqueId() {
        return this.uniqueId;
    }

    @Override
    public Map getUsedScreenAreas() {
        return this.usedScreenAreas;
    }

    @Override
    public boolean isMandatory() {
        return this.mandatory;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AppDefinition - appName: ").append(this.name);
        if (!this.name.equals(this.instanceName)) {
            stringBuilder.append(".").append(this.instanceName);
        }
        return stringBuilder.toString();
    }
}

