/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.singleuserinterface.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.model.OneShotJpnModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.model.SUIModel;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.singleuserinterface.transformer.AbstractSpeechNavigationControllerSingleUserInterfaceSUIResultDetailListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechNavigationControllerSingleUserInterfaceSUIResultDetailListTransformer
extends AbstractSpeechNavigationControllerSingleUserInterfaceSUIResultDetailListTransformer {
    private final String emptyString;

    public SpeechNavigationControllerSingleUserInterfaceSUIResultDetailListTransformer() {
        this.emptyString = "";
    }

    @Override
    public int getInt(int n, Object object) {
        SUIModel sUIModel = (SUIModel)object;
        switch (n) {
            case 0: {
                return sUIModel.getItemType();
            }
            case 12: {
                return sUIModel.getContact().getAddressesStatus();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        SUIModel sUIModel = (SUIModel)object;
        switch (n) {
            case 7: {
                return sUIModel.getContact().contactId;
            }
            case 13: {
                return sUIModel.getPOICategory().objectId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        SUIModel sUIModel = (SUIModel)object;
        switch (n) {
            case 9: {
                return sUIModel.getContact().contactPicture;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        SUIModel sUIModel = (SUIModel)object;
        boolean bl = sUIModel.getAddress() instanceof OneShotJpnModel;
        switch (n) {
            case 8: {
                return sUIModel.getContact().contactName;
            }
            case 10: {
                return sUIModel.getContact().getFirstAddress().toShortString();
            }
            case 11: {
                return sUIModel.getContact().getFirstAddress().toLongString();
            }
            case 14: {
                return sUIModel.getPOICategory().title;
            }
            case 1: {
                return sUIModel.getAddress().city.objectId;
            }
            case 2: {
                if (bl) {
                    return ((OneShotJpnModel)sUIModel.getAddress()).getNbestHeadlineText();
                }
                return sUIModel.getAddress().city.recognizedString;
            }
            case 3: {
                return sUIModel.getAddress().street.objectId;
            }
            case 4: {
                return sUIModel.getAddress().street.recognizedString;
            }
            case 5: {
                return sUIModel.getAddress().houseNumber.objectId;
            }
            case 6: {
                return sUIModel.getAddress().houseNumber.recognizedString;
            }
            case 15: {
                if (bl) {
                    return ((OneShotJpnModel)sUIModel.getAddress()).prefecture.objectId;
                }
                return "";
            }
            case 16: {
                if (bl) {
                    return ((OneShotJpnModel)sUIModel.getAddress()).prefecture.recognizedString;
                }
                return "";
            }
            case 17: {
                if (bl) {
                    return ((OneShotJpnModel)sUIModel.getAddress()).municipality.objectId;
                }
                return "";
            }
            case 18: {
                if (bl) {
                    return ((OneShotJpnModel)sUIModel.getAddress()).municipality.recognizedString;
                }
                return "";
            }
            case 19: {
                if (bl) {
                    return ((OneShotJpnModel)sUIModel.getAddress()).place.objectId;
                }
                return "";
            }
            case 20: {
                if (bl) {
                    return ((OneShotJpnModel)sUIModel.getAddress()).place.recognizedString;
                }
                return "";
            }
            case 21: {
                if (bl) {
                    return ((OneShotJpnModel)sUIModel.getAddress()).chome.objectId;
                }
                return "";
            }
            case 22: {
                if (bl) {
                    return ((OneShotJpnModel)sUIModel.getAddress()).chome.recognizedString;
                }
                return "";
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

