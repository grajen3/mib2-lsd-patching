/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.housenumber.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.housenumber.transformer.AbstractSpeechNavigationControllerDestinationInputHousenumberSelectedHousenumberTransformer;

public class SpeechNavigationControllerDestinationInputHousenumberSelectedHousenumberTransformer
extends AbstractSpeechNavigationControllerDestinationInputHousenumberSelectedHousenumberTransformer {
    @Override
    public int getInt(int n, Object object) {
        HouseNumber houseNumber = (HouseNumber)object;
        switch (n) {
            case 1: {
                return houseNumber.getIndex();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnId=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        HouseNumber houseNumber = (HouseNumber)object;
        switch (n) {
            case 0: {
                return houseNumber.objectId;
            }
            case 2: {
                return houseNumber.recognizedString;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnId=").append(n).append(" can not be resolved. ").toString());
    }
}

