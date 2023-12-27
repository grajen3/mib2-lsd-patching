/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.DestinationInputService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;

public abstract class DestinationInputModalControllerBase
extends ApplicationModalControllerBase {
    protected final DestinationInputService destinationInputService = NavigationDestinationInputServiceAdapter.getService();
    protected final ApplicationVariant applicationVariant = new ApplicationVariantImpl();

    @Override
    protected void checkPrerequisites() {
        super.checkPrerequisites();
    }

    public void checkCountrySupported() {
        if (this.applicationVariant.isCHNVariant() || this.applicationVariant.isTWNVariant()) {
            if (this.destinationInputService.isCountrySelected() && !this.destinationInputService.getCurrentInputSpeechCapabilities().isOneShot()) {
                this.onCountryNotSupported();
                throw new NavigationServiceException(" sds not supported for current country ");
            }
        } else if (this.destinationInputService.isCountrySelected() && !this.destinationInputService.getCurrentInputSpeechCapabilities().isOneShot() && !this.destinationInputService.getCurrentInputSpeechCapabilities().isFullWord()) {
            this.onCountryNotSupported();
            throw new NavigationServiceException(" sds not supported for current country ");
        }
    }

    private void onCountryNotSupported() {
        Framework.fireUIEvent(-301452288);
    }
}

