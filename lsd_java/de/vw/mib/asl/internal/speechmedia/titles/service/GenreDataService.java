/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.service;

import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.titles.model.TitleModel;
import de.vw.mib.asl.internal.speechmedia.titles.service.AbstractMusicDataService;

public class GenreDataService
extends AbstractMusicDataService {
    public GenreDataService(MediaServiceController mediaServiceController) {
        super(mediaServiceController, 16);
    }

    @Override
    protected TitleModel fromMediaEntry(MediaEntry mediaEntry) {
        TitleModel titleModel = new TitleModel();
        titleModel.mediaEntry = mediaEntry;
        titleModel.id = mediaEntry.getEntryId();
        titleModel.titleName = "";
        titleModel.artistName = "";
        titleModel.albumName = "";
        titleModel.genre = "";
        titleModel.genre = mediaEntry.getGenreName().getValue();
        if (!mediaEntry.getGenreName().isLocalized()) {
            titleModel.genreType = 1;
        }
        titleModel.value = titleModel.genre;
        return titleModel;
    }

    @Override
    protected TitleModel fromGroup(ResultItem resultItem) {
        TitleModel titleModel = new TitleModel();
        titleModel.titleName = "";
        titleModel.numberOfSubitems = resultItem.getSize();
        titleModel.artistName = "";
        titleModel.albumName = "";
        titleModel.value = titleModel.genre = resultItem.getText();
        return titleModel;
    }
}

