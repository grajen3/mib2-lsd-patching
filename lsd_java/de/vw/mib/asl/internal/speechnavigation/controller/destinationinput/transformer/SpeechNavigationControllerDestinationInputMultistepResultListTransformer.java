/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer.AbstractSpeechNavigationControllerDestinationInputMultistepResultListTransformer;

public class SpeechNavigationControllerDestinationInputMultistepResultListTransformer
extends AbstractSpeechNavigationControllerDestinationInputMultistepResultListTransformer {
    @Override
    public int getInt(int n, Object object) {
        ViewModelItem viewModelItem = (ViewModelItem)object;
        switch (n) {
            case 2: {
                return viewModelItem.size;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

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

