/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.transformer;

import de.vw.mib.asl.internal.speechmedia.titles.model.TitleModel;
import generated.de.vw.mib.asl.internal.speechmedia.titles.transformer.AbstractSpeechMediaTitlesTitleSubListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechMediaTitlesTitleSubListTransformer
extends AbstractSpeechMediaTitlesTitleSubListTransformer {
    @Override
    public int getInt(int n, Object object) {
        TitleModel titleModel = (TitleModel)object;
        switch (n) {
            case 2: {
                return titleModel.titleType;
            }
            case 4: {
                return titleModel.artistType;
            }
            case 6: {
                return titleModel.albumType;
            }
            case 9: {
                return titleModel.genreType;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

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
            case 3: {
                return titleModel.artistName;
            }
            case 5: {
                return titleModel.albumName;
            }
            case 8: {
                return titleModel.genre;
            }
            case 7: {
                return titleModel.value;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        TitleModel titleModel = (TitleModel)object;
        switch (n) {
            case 10: {
                return titleModel.cover;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

