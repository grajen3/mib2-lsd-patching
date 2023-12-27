/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app;

import de.vw.mib.app.AppUIService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.modelapi.ui.ModelApiDownEventService;
import de.vw.mib.sm.AppHmiEnvironment;
import java.util.Map;

public class AppLayerEnvironment
implements AppHmiEnvironment {
    private static final boolean VISIBLE;
    private final AppDefinition appInstance;
    private final AppUIService uiService;
    private final Map viewNameToScreenAreasMap;

    public AppLayerEnvironment(AppDefinition appDefinition, AppUIService appUIService, Map map) {
        this.appInstance = appDefinition;
        this.uiService = appUIService;
        this.viewNameToScreenAreasMap = map;
        Preconditions.checkNotNull(this.appInstance, "appInstance");
        Preconditions.checkNotNull(this.uiService, "uiService");
        Preconditions.checkNotNull(this.viewNameToScreenAreasMap, "viewNameToScreenAreasMap");
    }

    @Override
    public AppDefinition getAppInstance() {
        return this.appInstance;
    }

    @Override
    public ModelApiDownEventService getModelApiDownEventService() {
        return this.uiService.getModelApiDownEventService();
    }

    @Override
    public void showView(String string, String string2, boolean bl, int n) {
        this.uiService.enterView(string, string2, bl, n);
        this.updateProvidedScreenAreaVisibilities(string, string2, true);
    }

    @Override
    public void hideView(String string, String string2) {
        this.updateProvidedScreenAreaVisibilities(string, string2, false);
        this.uiService.leaveView(string, string2);
    }

    private void updateProvidedScreenAreaVisibilities(String string, String string2, boolean bl) {
        String[] stringArray = (String[])this.viewNameToScreenAreasMap.get(string2);
        if (stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string3 = stringArray[i2];
                this.uiService.updateProvidedScreenAreaVisibility(string, string3, bl);
            }
        }
    }

    @Override
    public void requestVisibility(String string) {
        this.uiService.requestVisibility(string);
    }
}

