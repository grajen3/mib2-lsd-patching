/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui.service;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.vde.Capabilities;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.DestinationInputService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.CapabilitiesStartUpListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.LastDestinationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.LastDestinationListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUICheckerService$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUICheckerService$2;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.genericevents.ThreadSwitchingTarget;

public class SUICheckerService
implements LastDestinationListener,
CapabilitiesStartUpListener {
    protected final ThreadSwitchingTarget threadSwitchingTarget;
    protected String systemLanguage = ServiceManager.configManagerDiag.getCurrentGuiLanguage();
    protected DestinationInputService destinationInputService = null;
    private LastDestinationService lastDestinationsService = null;
    private boolean isSUISupported = false;
    private boolean isFirstEvaluation = true;

    public SUICheckerService(Services services) {
        Framework.updateUIValue(-2096614400, false);
        Framework.updateUIValue(-1928842240, this.systemLanguage);
        this.threadSwitchingTarget = services.getASLThreadSwitch();
        try {
            this.destinationInputService = NavigationDestinationInputServiceAdapter.getService();
            this.destinationInputService.registerOnStartUpCapabilities(this);
            this.lastDestinationsService = NavigationMemoryServiceAdapter.getLastDestinationService();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".ctor(): ").append(navigationServiceException.getMessage()).toString());
        }
        ServiceManager.configManagerDiag.addNvListener(new SUICheckerService$1(this), 2);
        this.lastDestinationsService.register(this);
    }

    public boolean getIsSUISupported() {
        return this.isSUISupported;
    }

    @Override
    public void onStartUpCapabilitiesRetrieved() {
        Capabilities capabilities;
        AppLogger.trace(this, ".onStartUpCapabilitiesRetrived(), init SUI evaluation. ");
        if (this.isFirstEvaluation && (capabilities = this.destinationInputService.getCurrentInputSpeechCapabilities()) != null) {
            this.isFirstEvaluation = false;
            this.evaluateSUIFeature(capabilities, this.destinationInputService.getCurrentInput());
        }
    }

    public void onSystemLanguageChanged() {
        this.systemLanguage = ServiceManager.configManagerDiag.getCurrentGuiLanguage();
        Framework.updateUIValue(-1928842240, this.systemLanguage);
        if (!this.isFirstEvaluation) {
            this.evaluateSUIFeature(this.destinationInputService.getCurrentInputSpeechCapabilities(), this.destinationInputService.getCurrentInput());
        }
    }

    @Override
    public void onLastDestinationChanged(INavigationListElement iNavigationListElement) {
        AppLogger.trace(this, ".onLastDestinationChanged(), init SUI evaluation calling initializeDestinationInput(..). ");
        if (!this.isFirstEvaluation) {
            this.destinationInputService.initializeDestinationInput(new SUICheckerService$2(this));
        }
    }

    protected void evaluateSUIFeature(Capabilities capabilities, INavigationLocation iNavigationLocation) {
        if (capabilities == null || iNavigationLocation == null) {
            AppLogger.error(this, ".evaluateSUIFeature(..) failed as capabilities or lastUsedDestination are invalid. ");
            return;
        }
        this.isSUISupported = false;
        String[] stringArray = capabilities.getGrammarLanguage();
        ObjectArrayList objectArrayList = new ObjectArrayList(stringArray.length);
        if (capabilities.isOneShot()) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                objectArrayList.add(stringArray[i2]);
                if (!stringArray[i2].equalsIgnoreCase(this.systemLanguage)) continue;
                this.isSUISupported = true;
                break;
            }
        }
        AppLogger.trace(this, new StringBuffer().append(".evaluateSUIFeature( .. ) ==> [isSUISupported] = ").append(this.isSUISupported).append(" [is one shot supported] = ").append(capabilities.isOneShot()).append(", [system language] = ").append(this.systemLanguage).append(", [last dest country] = ").append(iNavigationLocation.getCountry()).append(", [last dest country abr] = ").append(iNavigationLocation.getCountryAbbreviation()).append(", [supported languages] = ").append(objectArrayList.toString()).toString());
        if (this.isSUISupported) {
            Framework.updateUIValue(-2096614400, true);
        } else {
            Framework.updateUIValue(-2096614400, false);
        }
        Framework.updateUIValue(-2079837184, this.isSUISupported);
    }
}

