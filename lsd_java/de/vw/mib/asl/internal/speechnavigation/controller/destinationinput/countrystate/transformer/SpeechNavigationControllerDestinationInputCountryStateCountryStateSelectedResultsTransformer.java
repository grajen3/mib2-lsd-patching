/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.model.CountryStateModel;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate.transformer.AbstractSpeechNavigationControllerDestinationInputCountryStateCountryStateSelectedResultsTransformer;

public class SpeechNavigationControllerDestinationInputCountryStateCountryStateSelectedResultsTransformer
extends AbstractSpeechNavigationControllerDestinationInputCountryStateCountryStateSelectedResultsTransformer {
    @Override
    public String getString(int n, Object object) {
        CountryStateModel countryStateModel = (CountryStateModel)object;
        switch (n) {
            case 0: {
                return countryStateModel.country.objectId;
            }
            case 1: {
                return countryStateModel.country.recognizedString;
            }
            case 2: {
                return countryStateModel.state.objectId;
            }
            case 3: {
                return countryStateModel.state.recognizedString;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

