/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.speechnavigation.appui;

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
import generated.de.vw.mib.speechnavigation.appui.internal.SpeechNavigationModelApiUpEventHandler;
import generated.de.vw.mib.speechnavigation.view.internal.LocalViewHandlerFactoryImpl;
import java.util.HashMap;
import java.util.Map;

public class SpeechNavigationAppUIGate
extends AbstractHmiAppUIGate {
    public static final String APP_NAME;
    public static final String LAYER_MAIN;
    private static final Map VIEWNAME_2_SCREENAREAS_MAP;
    private static final int[] ENTRY_POINTS_OF_LAYER_MAIN;

    public SpeechNavigationAppUIGate(AppDefinition appDefinition, AppSystemServices appSystemServices) {
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
        return new SpeechNavigationModelApiUpEventHandler(this.appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }

    @Override
    protected void requestVisibilityOfAllLayers(AppUIService appUIService) {
        appUIService.requestVisibility("Main");
    }

    @Override
    public void denyVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(-396849847);
        }
    }

    @Override
    public void grantVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(693734729);
        }
    }

    @Override
    public void revokeVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(1801030985);
        }
    }

    public String toString() {
        return new StringBuffer().append("App UI Gate: ").append(this.appDefinition.getAppName()).toString();
    }

    static {
        VIEWNAME_2_SCREENAREAS_MAP = new HashMap();
        VIEWNAME_2_SCREENAREAS_MAP.put("Sndcl", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sndcma", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sndcn", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snddd", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sndgh", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sndopcn", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sndopclaa", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sndopclai", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sndopdd", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sndoprl", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snga", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sngh", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sngld", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sngldl", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sngldn", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sngm", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sngnc", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sngp", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sngpo", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sngr", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndme", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndmhs", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndmj", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndmncsn", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndmn", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndo", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndoj", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndon_A02C", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndon_04E6", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndonj", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snndonn", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snopsd_1C46", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snopsd_7E65", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snopsr", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snsn", new String[]{"ScreenAreaHeadline"});
        ENTRY_POINTS_OF_LAYER_MAIN = new int[]{597, 625, 626};
    }
}

