/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.phone.appui;

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
import generated.de.vw.mib.phone.appui.internal.PhoneModelApiUpEventHandler;
import generated.de.vw.mib.phone.view.internal.LocalViewHandlerFactoryImpl;
import java.util.HashMap;
import java.util.Map;

public class PhoneAppUIGate
extends AbstractHmiAppUIGate {
    public static final String APP_NAME;
    public static final String LAYER_MAIN;
    public static final String LAYER_POPUP;
    private static final Map VIEWNAME_2_SCREENAREAS_MAP;
    private static final int[] ENTRY_POINTS_OF_LAYER_MAIN;
    private static final int[] DYNAMIC_STATEMACHINES_OF_LAYER_POPUP;

    public PhoneAppUIGate(AppDefinition appDefinition, AppSystemServices appSystemServices) {
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
        return new PhoneModelApiUpEventHandler(this.appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }

    @Override
    protected void requestVisibilityOfAllLayers(AppUIService appUIService) {
        appUIService.requestVisibility("Main");
        appUIService.requestVisibility("Popup");
    }

    @Override
    public void denyVisibility(String string) {
    }

    @Override
    public void grantVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(324635977);
        }
    }

    @Override
    public void revokeVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(1431932233);
        }
    }

    public String toString() {
        return new StringBuffer().append("App UI Gate: ").append(this.appDefinition.getAppName()).toString();
    }

    static {
        VIEWNAME_2_SCREENAREAS_MAP = new HashMap();
        ENTRY_POINTS_OF_LAYER_MAIN = new int[]{584, 618};
        DYNAMIC_STATEMACHINES_OF_LAYER_POPUP = new int[]{0, 1, 2, 3, 4, 5, 71, 72, 73, 77, 78, 79, 80, 81, 82, 83, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 119, 120, 121, 122, 123, 124, 125, 126, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 243, 244, 245, 246, 247, 248, 249, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 478, 483, 484, 486};
    }
}

