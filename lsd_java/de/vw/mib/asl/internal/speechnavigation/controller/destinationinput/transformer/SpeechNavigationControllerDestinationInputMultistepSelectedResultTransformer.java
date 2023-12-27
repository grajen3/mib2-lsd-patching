/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer.AbstractSpeechNavigationControllerDestinationInputMultistepSelectedResultTransformer;

public class SpeechNavigationControllerDestinationInputMultistepSelectedResultTransformer
extends AbstractSpeechNavigationControllerDestinationInputMultistepSelectedResultTransformer {
    @Override
    public String getString(int n, Object object) {
        ViewModelItem viewModelItem = (ViewModelItem)object;
        switch (n) {
            case 0: {
                return viewModelItem.objectId;
            }
            case 1: {
                return viewModelItem.recognizedString;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

