/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.controller;

import de.vw.mib.asl.internal.kombipictureserver.common.api.adaptation.AdaptationAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.BapAudioSdAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.BapTelephoneAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.media.MediaCoverArtAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.phone.PhoneCallAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.radio.RadioStationArtAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.TvTunerStationArtAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.category.Category;
import de.vw.mib.asl.internal.kombipictureserver.common.category.CategoryManager;
import de.vw.mib.asl.internal.kombipictureserver.common.category.CategoryManagerDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceRegistry;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.CallPicture;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.CoverArt;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArt;

class PictureServerCategoryManager
extends CategoryManager {
    public PictureServerCategoryManager(CategoryManagerDelegate categoryManagerDelegate) {
        super(categoryManagerDelegate);
    }

    @Override
    protected AslServiceRegistry createService(Class clazz) {
        AslServiceRegistry aslServiceRegistry;
        if (clazz == BapAudioSdAdapter.getServiceClass()) {
            BapAudioSdAdapter bapAudioSdAdapter = new BapAudioSdAdapter();
            bapAudioSdAdapter.register();
            aslServiceRegistry = bapAudioSdAdapter;
        } else if (clazz == BapTelephoneAdapter.getServiceClass()) {
            BapTelephoneAdapter bapTelephoneAdapter = new BapTelephoneAdapter();
            bapTelephoneAdapter.register();
            aslServiceRegistry = bapTelephoneAdapter;
        } else if (clazz == MediaCoverArtAdapter.getServiceClass()) {
            MediaCoverArtAdapter mediaCoverArtAdapter = new MediaCoverArtAdapter();
            mediaCoverArtAdapter.register();
            aslServiceRegistry = mediaCoverArtAdapter;
        } else if (clazz == PhoneCallAdapter.getServiceClass()) {
            PhoneCallAdapter phoneCallAdapter = new PhoneCallAdapter();
            phoneCallAdapter.register();
            aslServiceRegistry = phoneCallAdapter;
        } else if (clazz == AdaptationAdapter.getServiceClass()) {
            AdaptationAdapter adaptationAdapter = new AdaptationAdapter();
            adaptationAdapter.register();
            aslServiceRegistry = adaptationAdapter;
        } else if (clazz == RadioStationArtAdapter.getServiceClass()) {
            RadioStationArtAdapter radioStationArtAdapter = new RadioStationArtAdapter();
            radioStationArtAdapter.register();
            aslServiceRegistry = radioStationArtAdapter;
        } else if (clazz == TvTunerStationArtAdapter.getServiceClass()) {
            TvTunerStationArtAdapter tvTunerStationArtAdapter = new TvTunerStationArtAdapter();
            tvTunerStationArtAdapter.register();
            aslServiceRegistry = tvTunerStationArtAdapter;
        } else {
            aslServiceRegistry = super.createService(clazz);
        }
        return aslServiceRegistry;
    }

    @Override
    protected Category[] createCategories() {
        Category[] categoryArray = new Category[]{new CoverArt(), new CallPicture(), new StationArt()};
        return categoryArray;
    }
}

