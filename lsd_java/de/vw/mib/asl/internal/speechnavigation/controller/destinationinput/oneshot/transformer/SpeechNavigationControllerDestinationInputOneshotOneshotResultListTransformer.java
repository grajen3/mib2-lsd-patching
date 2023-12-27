/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.model.OneShotJpnModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.transformer.AbstractSpeechNavigationControllerDestinationInputOneshotOneshotResultListTransformer;

public class SpeechNavigationControllerDestinationInputOneshotOneshotResultListTransformer
extends AbstractSpeechNavigationControllerDestinationInputOneshotOneshotResultListTransformer {
    private final String emptyString;

    public SpeechNavigationControllerDestinationInputOneshotOneshotResultListTransformer() {
        this.emptyString = "";
    }

    @Override
    public String getString(int n, Object object) {
        boolean bl = object instanceof OneShotJpnModel;
        OneShotModel oneShotModel = (OneShotModel)object;
        switch (n) {
            case 1: {
                return oneShotModel.city.objectId;
            }
            case 2: {
                return oneShotModel.city.recognizedString;
            }
            case 3: {
                return oneShotModel.street.objectId;
            }
            case 4: {
                return oneShotModel.street.recognizedString;
            }
            case 5: {
                return oneShotModel.houseNumber.objectId;
            }
            case 6: {
                return oneShotModel.houseNumber.recognizedString;
            }
            case 7: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).prefecture.objectId;
                }
                return "";
            }
            case 8: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).prefecture.recognizedString;
                }
                return "";
            }
            case 9: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).municipality.objectId;
                }
                return "";
            }
            case 10: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).municipality.recognizedString;
                }
                return "";
            }
            case 11: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).place.objectId;
                }
                return "";
            }
            case 12: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).place.recognizedString;
                }
                return "";
            }
            case 13: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).chome.objectId;
                }
                return "";
            }
            case 14: {
                if (bl) {
                    return ((OneShotJpnModel)oneShotModel).chome.recognizedString;
                }
                return "";
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public int getInt(int n, Object object) {
        OneShotModel oneShotModel = (OneShotModel)object;
        switch (n) {
            case 0: {
                return oneShotModel.getSize();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

