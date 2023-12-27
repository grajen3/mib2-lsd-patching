/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.speechgeneral.appui;

import de.vw.mib.app.AbstractHmiAppUIGate;
import de.vw.mib.app.AppLayerEnvironment;
import de.vw.mib.app.AppUIService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.internal.AppSystemServices;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.view.internal.ViewHandlerAppServices;
import de.vw.mib.view.internal.ViewHandlerServices;
import de.vw.mib.viewmanager.internal.ViewHandlerFactory;
import generated.de.vw.mib.speechgeneral.appui.internal.SpeechGeneralModelApiUpEventHandler;
import generated.de.vw.mib.speechgeneral.view.internal.LocalViewHandlerFactoryImpl;
import java.util.HashMap;
import java.util.Map;

public class SpeechGeneralAppUIGate
extends AbstractHmiAppUIGate {
    public static final String APP_NAME;
    public static final String LAYER_MAIN;
    public static final String LAYER_POPUP;
    private static final Map VIEWNAME_2_SCREENAREAS_MAP;
    private static final int[] ENTRY_POINTS_OF_LAYER_MAIN;
    private static final int[] DYNAMIC_STATEMACHINES_OF_LAYER_POPUP;

    public SpeechGeneralAppUIGate(AppDefinition appDefinition, AppSystemServices appSystemServices) {
        super(appDefinition, appSystemServices);
    }

    @Override
    protected ViewHandlerFactory newViewHandlerFactory(ViewHandlerAppServices viewHandlerAppServices) {
        SkinClassLoader skinClassLoader = this.systemServices.getSkinClassLoader();
        PerfService perfService = this.systemServices.getPerfService();
        ViewHandlerServices viewHandlerServices = this.systemServices.getViewHandlerServices();
        return new LocalViewHandlerFactoryImpl(skinClassLoader, perfService, viewHandlerServices, viewHandlerAppServices);
    }

    @Override
    protected void onReady(AppUIService appUIService) {
        AppLayerEnvironment appLayerEnvironment = new AppLayerEnvironment(this.appDefinition, appUIService, VIEWNAME_2_SCREENAREAS_MAP);
        ServiceManagerStatemachine.statemachineManager.activateMainStatemachines(appLayerEnvironment, ENTRY_POINTS_OF_LAYER_MAIN);
        ServiceManagerStatemachine.statemachineManager.defineAppLayerEnvironmentForDynamicStatemachines(appLayerEnvironment, DYNAMIC_STATEMACHINES_OF_LAYER_POPUP);
    }

    @Override
    protected ModelApiUpEventHandler newModelApiUpEventHandler(AppAdapterListItemControlManager appAdapterListItemControlManager) {
        StatemachineEventDispatcher statemachineEventDispatcher = this.systemServices.getEventDispatcher();
        ModelDatapool modelDatapool = ServiceManagerCommon.modelDatapool;
        return new SpeechGeneralModelApiUpEventHandler(this.appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }

    @Override
    protected void requestVisibilityOfAllLayers(AppUIService appUIService) {
        appUIService.requestVisibility("Main");
        appUIService.requestVisibility("Popup");
    }

    @Override
    public void denyVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(-447181495);
        }
    }

    @Override
    public void grantVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(643403081);
        }
    }

    @Override
    public void revokeVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(1750699337);
        }
    }

    public String toString() {
        return new StringBuffer().append("App UI Gate: ").append(this.appDefinition.getAppName()).toString();
    }

    static {
        VIEWNAME_2_SCREENAREAS_MAP = new HashMap();
        VIEWNAME_2_SCREENAREAS_MAP.put("Sgmm", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sgnv", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sgtdc", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sgths", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sgtvb", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sgubt", new String[]{"ScreenAreaHeadline"});
        ENTRY_POINTS_OF_LAYER_MAIN = new int[]{594, 621, 622};
        DYNAMIC_STATEMACHINES_OF_LAYER_POPUP = new int[]{487, 488, 489, 490};
    }
}

