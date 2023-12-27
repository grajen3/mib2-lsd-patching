/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.speechphone.appui;

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
import generated.de.vw.mib.speechphone.appui.internal.SpeechPhoneModelApiUpEventHandler;
import generated.de.vw.mib.speechphone.view.internal.LocalViewHandlerFactoryImpl;
import java.util.HashMap;
import java.util.Map;

public class SpeechPhoneAppUIGate
extends AbstractHmiAppUIGate {
    public static final String APP_NAME;
    public static final String LAYER_MAIN;
    private static final Map VIEWNAME_2_SCREENAREAS_MAP;
    private static final int[] ENTRY_POINTS_OF_LAYER_MAIN;

    public SpeechPhoneAppUIGate(AppDefinition appDefinition, AppSystemServices appSystemServices) {
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
        return new SpeechPhoneModelApiUpEventHandler(this.appDefinition, statemachineEventDispatcher, modelDatapool, appAdapterListItemControlManager);
    }

    @Override
    protected void requestVisibilityOfAllLayers(AppUIService appUIService) {
        appUIService.requestVisibility("Main");
    }

    @Override
    public void denyVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(-380072631);
        }
    }

    @Override
    public void grantVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(710511945);
        }
    }

    @Override
    public void revokeVisibility(String string) {
        if (string.equals("Main")) {
            this.fireInternalHMIEvent(1817808201);
        }
    }

    public String toString() {
        return new StringBuffer().append("App UI Gate: ").append(this.appDefinition.getAppName()).toString();
    }

    static {
        VIEWNAME_2_SCREENAREAS_MAP = new HashMap();
        VIEWNAME_2_SCREENAREAS_MAP.put("Sc", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Scn", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sdc", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sdn", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Shc_AC25", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Shc_80F4", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("She", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Shi", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Shm", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Shn", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Shr", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Shs_D9C3", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Shs_17CD", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sm_02B1", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snc_CF6A", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Snc_2549", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Sne", new String[]{"ScreenAreaHeadline"});
        VIEWNAME_2_SCREENAREAS_MAP.put("Srs", new String[]{"ScreenAreaHeadline"});
        ENTRY_POINTS_OF_LAYER_MAIN = new int[]{598, 627, 628};
    }
}

