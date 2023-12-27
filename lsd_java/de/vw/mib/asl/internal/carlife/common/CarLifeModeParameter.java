/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.common;

import de.vw.mib.asl.internal.carlife.common.CarLifeResourceOwner;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;

public class CarLifeModeParameter {
    static Resource resource_main_screen_device = new Resource(1, 2);
    static Resource resource_main_screen_hmi = new Resource(1, 1);
    static Resource resource_main_screen_undefined = new Resource(1, 0);
    static Resource resource_audio_media_device = new Resource(3, 2);
    static Resource resource_audio_media_hmi = new Resource(3, 1);
    static Resource resource_audio_media_undefined = new Resource(3, 0);
    static Resource resource_audio_microphone_device = new Resource(2, 2);
    static Resource resource_audio_microphone_hmi = new Resource(2, 1);
    static Resource resource_audio_microphone_undefined = new Resource(2, 0);
    static Resource resource_audio_tts_device = new Resource(4, 2);
    static Resource resource_audio_tts_hmi = new Resource(4, 1);
    static Resource resource_audio_tts_undefined = new Resource(4, 0);
    static AppState appstate_nav_device = new AppState(1, 2);
    static AppState appstate_nav_hmi = new AppState(1, 1);
    static AppState appstate_nav_unknown = new AppState(1, 0);
    static AppState appstate_speech_device = new AppState(2, 2);
    static AppState appstate_speech_hmi = new AppState(2, 1);
    static AppState appstate_speech_unknown = new AppState(2, 0);

    private static Resource getScreenResource(CarLifeResourceOwner carLifeResourceOwner) {
        switch (carLifeResourceOwner.getScreenOwner()) {
            case 2: {
                return resource_main_screen_device;
            }
            case 1: {
                return resource_main_screen_hmi;
            }
        }
        return resource_main_screen_undefined;
    }

    private static Resource getAudioMediaResource(CarLifeResourceOwner carLifeResourceOwner) {
        switch (carLifeResourceOwner.getAudioMediaOwner()) {
            case 2: {
                return resource_audio_media_device;
            }
            case 1: {
                return resource_audio_media_hmi;
            }
        }
        return resource_audio_media_undefined;
    }

    private static Resource getAudioMicrophoneResource(CarLifeResourceOwner carLifeResourceOwner) {
        switch (carLifeResourceOwner.getAudioMicrophoneOwner()) {
            case 2: {
                return resource_audio_microphone_device;
            }
            case 1: {
                return resource_audio_microphone_hmi;
            }
        }
        return resource_audio_microphone_undefined;
    }

    private static Resource getAudioTTSResource(CarLifeResourceOwner carLifeResourceOwner) {
        switch (carLifeResourceOwner.getAudioTTSOwner()) {
            case 2: {
                return resource_audio_tts_device;
            }
            case 1: {
                return resource_audio_tts_hmi;
            }
        }
        return resource_audio_tts_undefined;
    }

    public static Resource[] getResources(CarLifeResourceOwner carLifeResourceOwner) {
        Resource[] resourceArray = new Resource[]{CarLifeModeParameter.getScreenResource(carLifeResourceOwner), CarLifeModeParameter.getAudioMicrophoneResource(carLifeResourceOwner), CarLifeModeParameter.getAudioMediaResource(carLifeResourceOwner), CarLifeModeParameter.getAudioTTSResource(carLifeResourceOwner)};
        return resourceArray;
    }

    private static AppState getNavigationAppState(CarLifeResourceOwner carLifeResourceOwner) {
        switch (carLifeResourceOwner.getNavigationOwner()) {
            case 2: {
                return appstate_nav_device;
            }
            case 1: {
                return appstate_nav_hmi;
            }
        }
        return appstate_nav_unknown;
    }

    private static AppState getSpeechAppState(CarLifeResourceOwner carLifeResourceOwner) {
        switch (carLifeResourceOwner.getSpeechOwner()) {
            case 2: {
                return appstate_speech_device;
            }
            case 1: {
                return appstate_speech_hmi;
            }
        }
        return appstate_speech_unknown;
    }

    public static AppState[] getAppStates(CarLifeResourceOwner carLifeResourceOwner) {
        AppState[] appStateArray = new AppState[]{CarLifeModeParameter.getNavigationAppState(carLifeResourceOwner), CarLifeModeParameter.getSpeechAppState(carLifeResourceOwner)};
        return appStateArray;
    }
}

