/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.model.CountryStateModel;
import generated.de.vw.mib.asl.internal.ListManager;

public abstract class DestinationInputCountryStateControllerBase
extends DestinationInputControllerBase {
    protected DestinationInputCountryStateControllerBase(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void notifyGroupExpanded(int n) {
        if (n >= 0 && n < ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects().length) {
            CountryStateModel countryStateModel = (CountryStateModel)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[n];
            Framework.updateUIValue(1594373120, countryStateModel.getTitle());
        }
        super.notifyGroupExpanded(n);
    }

    @Override
    public void notifyItemSelected() {
        CountryStateModel countryStateModel = (CountryStateModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        Framework.updateUIValue(1594373120, countryStateModel.getCountryStateTitle());
        Framework.fireUIEvent(1997026304);
    }
}

