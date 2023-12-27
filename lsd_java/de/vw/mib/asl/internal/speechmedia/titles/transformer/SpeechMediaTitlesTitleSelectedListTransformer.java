/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.transformer;

import de.vw.mib.asl.internal.speechmedia.titles.model.TitleModel;
import generated.de.vw.mib.asl.internal.speechmedia.titles.transformer.AbstractSpeechMediaTitlesTitleSelectedListTransformer;

public class SpeechMediaTitlesTitleSelectedListTransformer
extends AbstractSpeechMediaTitlesTitleSelectedListTransformer {
    @Override
    public long getLong(int n, Object object) {
        TitleModel titleModel = (TitleModel)object;
        switch (n) {
            case 0: {
                return titleModel.id;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        TitleModel titleModel = (TitleModel)object;
        switch (n) {
            case 1: {
                return titleModel.titleName;
            }
            case 2: {
                return titleModel.value;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

