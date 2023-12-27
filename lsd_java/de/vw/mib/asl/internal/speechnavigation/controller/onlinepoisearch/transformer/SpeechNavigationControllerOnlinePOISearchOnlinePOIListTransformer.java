/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.onlinepoisearch.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.model.OnlinePOI;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.onlinepoisearch.transformer.AbstractSpeechNavigationControllerOnlinePOISearchOnlinePOIListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechNavigationControllerOnlinePOISearchOnlinePOIListTransformer
extends AbstractSpeechNavigationControllerOnlinePOISearchOnlinePOIListTransformer {
    @Override
    public int getInt(int n, Object object) {
        OnlinePOI onlinePOI = (OnlinePOI)object;
        switch (n) {
            case 3: {
                return onlinePOI.getDistance();
            }
            case 4: {
                return onlinePOI.getDirectionArrowIndex();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        OnlinePOI onlinePOI = (OnlinePOI)object;
        switch (n) {
            case 0: {
                return onlinePOI.getId();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        OnlinePOI onlinePOI = (OnlinePOI)object;
        switch (n) {
            case 1: {
                return onlinePOI.getIcon();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        OnlinePOI onlinePOI = (OnlinePOI)object;
        switch (n) {
            case 2: {
                return onlinePOI.getName();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

