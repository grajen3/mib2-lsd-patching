/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.assembly.AppDefinitionData;
import de.vw.mib.app.framework.assembly.AppDefinitionDataProvider;
import de.vw.mib.app.framework.assembly.CioIntentClassData;
import de.vw.mib.app.framework.internal.Assembly$AppDef;
import de.vw.mib.app.framework.internal.Assembly$LifecycleCioIntentDef;
import de.vw.mib.app.framework.internal.Assembly$ShowContentCioIntentDef;
import de.vw.mib.cio.app.framework.CioIntentDefinition;
import de.vw.mib.util.StringBuilder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class Assembly {
    private final Map appDefinitions = new HashMap();
    private final Map data2AppDefinitions = new HashMap();
    private final AppDefinitionDataProvider dataProvider;
    private AppDefinition desktopAppDefinition;
    private final Map lazyAppDefinitions = new HashMap();
    private final Map providedContent = new HashMap();

    Assembly(AppDefinitionDataProvider appDefinitionDataProvider) {
        this.dataProvider = appDefinitionDataProvider;
        this.desktopAppDefinition = this.createAppDefinitions(appDefinitionDataProvider);
        String string = this.desktopAppDefinition.getAppName();
        this.appDefinitions.put(this.toUniqueName(string, string), this.desktopAppDefinition);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HmiAssembly - ").append("DesktopApp: ").append(this.desktopAppDefinition.getAppName());
        return stringBuilder.toString();
    }

    AppDefinition getAppDefinition(String string, String string2) {
        return (AppDefinition)this.appDefinitions.get(this.toUniqueName(string, string2));
    }

    CioIntentDefinition getAppLifecycleCio(AppDefinition appDefinition, String string) {
        CioIntentDefinition[] cioIntentDefinitionArray = appDefinition.getCioIntents();
        for (int i2 = 0; i2 < cioIntentDefinitionArray.length; ++i2) {
            CioIntentDefinition cioIntentDefinition = cioIntentDefinitionArray[i2];
            if (!string.equals(cioIntentDefinition.getCioIntentClassName())) continue;
            return cioIntentDefinition;
        }
        Assembly$LifecycleCioIntentDef assembly$LifecycleCioIntentDef = new Assembly$LifecycleCioIntentDef(appDefinition, string);
        return assembly$LifecycleCioIntentDef;
    }

    CioIntentClassData[] getCioIntentClasses() {
        return this.dataProvider.getCioIntentClasses();
    }

    AppDefinition getDesktopAppDefinition() {
        return this.desktopAppDefinition;
    }

    AppDefinition getLazyAppDefinition(String string, String string2) {
        return (AppDefinition)this.lazyAppDefinitions.get(this.toUniqueName(string, string2));
    }

    Collection getLazyAppDefinitions() {
        return this.lazyAppDefinitions.values();
    }

    Map getProvidedContent(AppDefinition appDefinition) {
        return (Map)this.providedContent.get(appDefinition);
    }

    CioIntentDefinition getShowContentCio(AppDefinition appDefinition, String string) {
        CioIntentDefinition[] cioIntentDefinitionArray = appDefinition.getCioIntents();
        for (int i2 = 0; i2 < cioIntentDefinitionArray.length; ++i2) {
            if (!"ShowContent".equals(cioIntentDefinitionArray[i2].getCioIntentClassName())) continue;
            return cioIntentDefinitionArray[i2];
        }
        return new Assembly$ShowContentCioIntentDef(appDefinition, string);
    }

    boolean hasLazyHostedApps(AppDefinition appDefinition) {
        Iterator iterator = this.getLazyAppDefinitions().iterator();
        while (iterator.hasNext()) {
            Assembly$AppDef assembly$AppDef = (Assembly$AppDef)iterator.next();
            if (!assembly$AppDef.isHostApp(appDefinition)) continue;
            return true;
        }
        return false;
    }

    private void addProvidedContent(AppDefinition appDefinition, Map map) {
        this.providedContent.put(appDefinition, map);
    }

    private boolean containsAppDefinitionData(AppDefinitionData appDefinitionData, AppDefinitionData[] appDefinitionDataArray) {
        for (int i2 = 0; i2 < appDefinitionDataArray.length; ++i2) {
            if (appDefinitionDataArray[i2] != appDefinitionData) continue;
            return true;
        }
        return false;
    }

    private Assembly$AppDef createAppDefinition(AppDefinitionData appDefinitionData, boolean bl) {
        if (this.data2AppDefinitions.containsKey(appDefinitionData)) {
            return (Assembly$AppDef)this.data2AppDefinitions.get(appDefinitionData);
        }
        String string = appDefinitionData.getAppName();
        String string2 = appDefinitionData.getAppInstanceName();
        Assembly$AppDef assembly$AppDef = Assembly$AppDef.createAppDefinition(string, appDefinitionData.getAppInstanceId(), string2, appDefinitionData.getUniqueId(), appDefinitionData.getAppType(), bl, appDefinitionData.getProvidedScreenAreas(), appDefinitionData.getUsedScreenAreas(), appDefinitionData.getParameters(), appDefinitionData.getNeededBusinessComponents(), appDefinitionData.getCioIntents(), appDefinitionData.getAppAdapterClassName());
        this.data2AppDefinitions.put(appDefinitionData, assembly$AppDef);
        this.appDefinitions.put(this.toUniqueName(string, string2), assembly$AppDef);
        this.addProvidedContent(assembly$AppDef, appDefinitionData.getProvidedContent());
        return assembly$AppDef;
    }

    private AppDefinition createAppDefinitions(AppDefinitionDataProvider appDefinitionDataProvider) {
        AppDefinitionData appDefinitionData = appDefinitionDataProvider.getDesktopAppDefinitionData();
        Assembly$AppDef assembly$AppDef = this.createDesktopAppDefinition(appDefinitionData);
        this.createAppDefinitionsForHostedApps(appDefinitionData, assembly$AppDef);
        return assembly$AppDef;
    }

    private void createAppDefinitionsForHostedApps(AppDefinitionData appDefinitionData, Assembly$AppDef assembly$AppDef) {
        Assembly$AppDef assembly$AppDef2;
        AppDefinitionData appDefinitionData2;
        int n;
        AppDefinitionData[] appDefinitionDataArray = appDefinitionData.getLazyStartingHostedApps();
        AppDefinitionData[] appDefinitionDataArray2 = appDefinitionData.getMandatoryHostedApps();
        AppDefinitionData[] appDefinitionDataArray3 = appDefinitionData.getOptionalHostedApps();
        for (n = 0; n < appDefinitionDataArray2.length; ++n) {
            appDefinitionData2 = appDefinitionDataArray2[n];
            assembly$AppDef2 = this.createAppDefinition(appDefinitionData2, true);
            assembly$AppDef.addHostedApp(assembly$AppDef2);
            this.createAppDefinitionsForHostedApps(appDefinitionData2, assembly$AppDef2);
        }
        for (n = 0; n < appDefinitionDataArray3.length; ++n) {
            appDefinitionData2 = appDefinitionDataArray3[n];
            assembly$AppDef2 = this.createAppDefinition(appDefinitionData2, false);
            if (this.containsAppDefinitionData(appDefinitionData2, appDefinitionDataArray)) {
                String string = assembly$AppDef2.getAppName();
                String string2 = assembly$AppDef2.getAppInstanceName();
                this.lazyAppDefinitions.put(this.toUniqueName(string, string2), assembly$AppDef2);
                assembly$AppDef2.addHostApp(assembly$AppDef);
            } else {
                assembly$AppDef.addHostedApp(assembly$AppDef2);
            }
            this.createAppDefinitionsForHostedApps(appDefinitionData2, assembly$AppDef2);
        }
    }

    private Assembly$AppDef createDesktopAppDefinition(AppDefinitionData appDefinitionData) {
        Assembly$AppDef assembly$AppDef = Assembly$AppDef.createDesktopAppDefinition(appDefinitionData.getAppName(), appDefinitionData.getAppInstanceId(), appDefinitionData.getAppInstanceName(), appDefinitionData.getUniqueId(), appDefinitionData.getAppType(), appDefinitionData.getProvidedScreenAreas(), new HashMap(), appDefinitionData.getParameters(), appDefinitionData.getNeededBusinessComponents(), appDefinitionData.getCioIntents(), appDefinitionData.getAppAdapterClassName());
        return assembly$AppDef;
    }

    private String toUniqueName(String string, String string2) {
        return new StringBuffer().append(string).append(".").append(string2).toString();
    }
}

