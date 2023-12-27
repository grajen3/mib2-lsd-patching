/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.service;

import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.titles.model.TitleModel;
import de.vw.mib.asl.internal.speechmedia.titles.service.AbstractMusicDataService;

public class AlbumDataService
extends AbstractMusicDataService {
    public AlbumDataService(MediaServiceController mediaServiceController) {
        super(mediaServiceController, 14);
    }

    @Override
    protected TitleModel fromMediaEntry(MediaEntry mediaEntry) {
        TitleModel titleModel = new TitleModel();
        titleModel.mediaEntry = mediaEntry;
        titleModel.id = mediaEntry.getEntryId();
        titleModel.artistName = mediaEntry.getArtistName().getValue();
        if (!mediaEntry.getArtistName().isLocalized()) {
            titleModel.artistType = mediaEntry.getArtistName().getLocalizationType() == 30 ? 2 : 1;
        }
        titleModel.albumName = mediaEntry.getAlbumName().getValue();
        if (!mediaEntry.getAlbumName().isLocalized()) {
            titleModel.albumType = 1;
        }
        titleModel.titleName = "";
        titleModel.genre = "";
        titleModel.cover = mediaEntry.getCover();
        titleModel.value = titleModel.albumName;
        return titleModel;
    }

    @Override
    protected TitleModel fromGroup(ResultItem resultItem) {
        TitleModel titleModel = new TitleModel();
        titleModel.artistName = "";
        titleModel.numberOfSubitems = resultItem.getSize();
        titleModel.titleName = "";
        titleModel.albumName = resultItem.getText();
        titleModel.genre = "";
        titleModel.value = titleModel.albumName;
        return titleModel;
    }
}

