/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.model.OneShotJpnModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.transformer.AbstractSpeechNavigationControllerDestinationInputOneshotOneshotSelectedResultTransformer;

public class SpeechNavigationControllerDestinationInputOneshotOneshotSelectedResultTransformer
extends AbstractSpeechNavigationControllerDestinationInputOneshotOneshotSelectedResultTransformer {
    private final String emptyString;

    public SpeechNavigationControllerDestinationInputOneshotOneshotSelectedResultTransformer() {
        this.emptyString = "";
    }

    @Override
    public String getString(int n, Object object) {
        boolean bl = object instanceof OneShotJpnModel;
        OneShotModel oneShotModel = (OneShotModel)object;
        switch (n) {
            case 0: {
                return oneShotModel.city.objectId;
            }
            case 1: {
                return oneShotModel.city.recognizedString;
            }
            case 2: {
                return oneShotModel.street.objectId;
            }
            case 3: {
                return oneShotModel.street.recognizedString;
            }
            case 4: {
                return oneShotModel.houseNumber.objectId;
            }
            case 5: {
                return oneShotModel.houseNumber.recognizedString;
            }
            case 6: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).prefecture.objectId;
                }
                return "";
            }
            case 7: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).prefecture.recognizedString;
                }
                return "";
            }
            case 8: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).municipality.objectId;
                }
                return "";
            }
            case 9: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).municipality.recognizedString;
                }
                return "";
            }
            case 10: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).place.objectId;
                }
                return "";
            }
            case 11: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).place.recognizedString;
                }
                return "";
            }
            case 12: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).chome.objectId;
                }
                return "";
            }
            case 13: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).chome.recognizedString;
                }
                return "";
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

