/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.application;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.contexts.SpeechContext;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterStateConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.NavigationMapServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.NavigationOnboardPOIServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationErrorHandlerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.map.Rect;

public class ApplicationController
extends ApplicationErrorHandlerBase
implements SpeechContext,
RecognizedEventConsumer,
ModelEventConsumer,
TeleprompterStateConsumer {
    public static final int CMD_NAV;
    public static final int APP_IDLING;
    public static final int APP_REQUEST_VISIBILITY;
    public static final int APP_TOGGLE_TELEPROMPTER_VISIBILITY;
    public static final int APP_UPDATE_UI_LIST_ADJUSTING;
    public static final int APP_INITIALIZE_MAP_SIZE;
    private final TeleprompterManager applicationTeleprompter;
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;
    private final DialogManager dialogManager;

    public ApplicationController(CioDictionary cioDictionary, CioDispatcher cioDispatcher, TeleprompterManager teleprompterManager, DialogManager dialogManager) {
        this.cioDictionary = cioDictionary;
        this.cioDispatcher = cioDispatcher;
        this.applicationTeleprompter = teleprompterManager;
        this.applicationTeleprompter.register(this);
        this.dialogManager = dialogManager;
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(2064135168);
    }

    protected void onApplication() {
        try {
            this.checkNaviServiceAvailable();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.info(this, new StringBuffer().append(".onApplication(), an error has occured: ").append(navigationServiceException.getMessage()).toString());
            return;
        }
        Framework.fireUIEvent(1460155392);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141827: {
                this.onApplication();
                break;
            }
            default: {
                AppLogger.error(this, new StringBuffer().append(".onRecognizedEvent( event = ").append(n).append(" ), is not handled.").toString());
            }
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077141873: {
                AppLogger.trace(this, new StringBuffer().append(".onEvent( event = TOGGLE_TELEPROMPTER_VISIBILITY [").append(eventGeneric.toString()).append("] )").toString());
                this.applicationTeleprompter.toggle();
                break;
            }
            case 1077141919: {
                AppLogger.trace(this, new StringBuffer().append(".onEvent( event = APP_IDLING [").append(eventGeneric.toString()).append("] )").toString());
                NavigationDestinationInputServiceAdapter.getService().release();
                NavigationOnboardPOIServiceAdapter.getService().release();
                NavigationMapServiceAdapter.getMapService().release();
                break;
            }
            case 1077141899: {
                AppLogger.trace(this, new StringBuffer().append(".onEvent( event = INIT_MAP_WINDOW_SIZE [").append(eventGeneric.toString()).append("] )").toString());
                Rect rect = new Rect();
                rect.kordX = eventGeneric.getInt(0);
                rect.kordY = eventGeneric.getInt(1);
                rect.diffX = eventGeneric.getInt(3);
                rect.diffY = eventGeneric.getInt(2);
                NavigationMapServiceAdapter.getMapService().initMapSize(rect);
                break;
            }
            case 1077142004: {
                AppLogger.trace(this, new StringBuffer().append(".onEvent( event = APP_REQUEST_VISIBILITY [").append(eventGeneric.toString()).append("] )").toString());
                CioIntent cioIntent = this.cioDictionary.getCioIntent("ShowContent", "HMI_SPEECHNAVIGATION");
                this.cioDispatcher.dispatch(cioIntent);
                break;
            }
            case 1077142015: {
                AppLogger.trace(this, new StringBuffer().append(".onEvent( event = UPDATE_CURRENT_UI_LIST_ADJUSTING [").append(eventGeneric.toString()).append("] )").toString());
                this.dialogManager.pauseSession();
                break;
            }
            default: {
                AppLogger.error(this, new StringBuffer().append(".onEvent( event = ").append(eventGeneric.toString()).append(" ), is not handled.").toString());
            }
        }
    }

    @Override
    public void onTeleprompterStateChanged(int n) {
        boolean bl = n == 0;
        Framework.updateUIValue(1611150336, bl ? 0 : 1);
        Framework.updateUIValue(1493709824, bl);
    }

    @Override
    public int getSpeechContextId() {
        return 2;
    }

    @Override
    public void enterMainView() {
        AppLogger.info(this, "enterMainView(), show navigation use case teleprompter triggered by a different context");
        this.onApplication();
    }
}

