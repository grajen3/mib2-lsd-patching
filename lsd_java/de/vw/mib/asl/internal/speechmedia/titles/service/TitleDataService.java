/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.service;

import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.titles.model.TitleModel;
import de.vw.mib.asl.internal.speechmedia.titles.service.AbstractMusicDataService;

public class TitleDataService
extends AbstractMusicDataService {
    public TitleDataService(MediaServiceController mediaServiceController) {
        super(mediaServiceController, 1);
    }

    @Override
    protected TitleModel fromMediaEntry(MediaEntry mediaEntry) {
        TitleModel titleModel = new TitleModel();
        titleModel.mediaEntry = mediaEntry;
        titleModel.id = mediaEntry.getEntryId();
        titleModel.titleName = mediaEntry.getTitleName().getValue();
        if (!mediaEntry.getTitleName().isLocalized()) {
            titleModel.titleType = 1;
        }
        titleModel.artistName = mediaEntry.getArtistName().getValue();
        if (!mediaEntry.getArtistName().isLocalized()) {
            titleModel.artistType = mediaEntry.getArtistName().getLocalizationType() == 30 ? 2 : 1;
        }
        titleModel.albumName = "";
        titleModel.genre = "";
        titleModel.value = titleModel.titleName;
        return titleModel;
    }

    @Override
    protected TitleModel fromGroup(ResultItem resultItem) {
        TitleModel titleModel = new TitleModel();
        titleModel.titleName = resultItem.getText();
        titleModel.numberOfSubitems = resultItem.getSize();
        titleModel.artistName = "";
        titleModel.albumName = "";
        titleModel.genre = "";
        titleModel.value = titleModel.titleName;
        return titleModel;
    }
}

