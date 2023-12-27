/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.lastdestinations.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.model.LastDestination;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.lastdestinations.transformer.AbstractSpeechNavigationControllerLastDestinationsLastDestinationDetailListTransformer;

public class SpeechNavigationControllerLastDestinationsLastDestinationDetailListTransformer
extends AbstractSpeechNavigationControllerLastDestinationsLastDestinationDetailListTransformer {
    @Override
    public long getLong(int n, Object object) {
        LastDestination lastDestination = (LastDestination)object;
        switch (n) {
            case 0: {
                return lastDestination.objectId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        LastDestination lastDestination = (LastDestination)object;
        switch (n) {
            case 1: {
                return lastDestination.title;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

