/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.speechtuner.appui;

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
import generated.de.vw.mib.speechtuner.appui.internal.SpeechTunerModelApiUpEventHandler;
import generated.de.vw.mib.speechtuner.view.internal.LocalViewHandlerFactoryImpl;
import java.util.HashMap;
import java.util.Map;

public class SpeechTunerAppUIGate
extends AbstractHmiAppUIGate {
    public static final String APP_NAME;
    public static final String LAYER_MAIN;
    private static final Map VIEWNAME_2_SCREENAREAS_MAP;
    private static final int[] ENTRY_POINTS_OF_LAYER_MAIN;

    public SpeechTunerAppUIGate(AppDefinition appDefinition, AppSystemServices appSystemServices) {
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
    }

    @Override
    protected ModelApiUpEventHandler newModelApiUpEventHandler(AppAdapterListItemControlManager appAdapterListItemControlManager) {
        StatemachineEventDispatcher statemachineEventDispatcher = this.systemServices.getEventDispatcher();
        ModelDatapool modelDatapool = ServiceManagerCommon.modelDatapool;
        return new SpeechTunerModelApiUpEventHandler(this.appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }

    @Override
    protected void requestVisibilityOfAllLayers(AppUIService appUIService) {
        appUIService.requestVisibility("Main");
    }

    @Override
    public void denyVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(-363295415);
        }
    }

    @Override
    public void grantVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(727289161);
        }
    }

    @Override
    public void revokeVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(1834585417);
        }
    }

    public String toString() {
        return new StringBuffer().append("App UI Gate: ").append(this.appDefinition.getAppName()).toString();
    }

    static {
        VIEWNAME_2_SCREENAREAS_MAP = new HashMap();
        VIEWNAME_2_SCREENAREAS_MAP.put("Std", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Stm", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Stnl", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Stne", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sttbc", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sttfs", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sttss", new String[]{"ScreenAreaHeadline"});
        ENTRY_POINTS_OF_LAYER_MAIN = new int[]{600, 629, 630};
    }
}

