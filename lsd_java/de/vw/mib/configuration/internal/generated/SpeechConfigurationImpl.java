/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal.generated;

import de.vw.mib.configuration.internal.generated.SpeechConfiguration;

public class SpeechConfigurationImpl
implements SpeechConfiguration {
    private static String[] speechClientNames = new String[]{"SPEECH_CLIENT_SPEECH_GENERAL", "SPEECH_CLIENT_SPEECH_NAVI", "SPEECH_CLIENT_SPEECH_MEDIA", "SPEECH_CLIENT_SPEECH_PHONE", "SPEECH_CLIENT_SPEECH_TUNER", "SPEECH_CLIENT_SPEECH_TEST", "SPEECH_CLIENT_SPEECH_DIALOG_MANAGER", "SPEECH_CLIENT_HAPTIC_NAVI", "SPEECH_CLIENT_HAPTIC_MEDIA", "SPEECH_CLIENT_HAPTIC_TUNER", "SPEECH_CLIENT_HAPTIC_PHONE", "SPEECH_CLIENT_HAPTIC_MESSAGING", "SPEECH_CLIENT_HAPTIC_TEST", "SPEECH_CLIENT_POPUP_MANAGER", "SPEECH_CLIENT_BAP", "SPEECH_CLIENT_SOUND", "SPEECH_CLIENT_CONTENT_PROCESSOR", "SPEECH_CLIENT_HAPTIC_SYSTEM", "SPEECH_CLIENT_SPEECH_SETUP"};
    private static String[] speechClientShortNames = new String[]{"SC_S_GE", "SC_S_NA", "SC_S_ME", "SC_S_PH", "SC_S_TU", "SC_S_TE", "SC_S_DM", "SC_H_NA", "SC_H_ME", "SC_H_TU", "SC_H_PH", "SC_H_MG", "SC_H_TE", "SC_POP", "SC_BAP", "SC_SOUND", "SC_CP", "SC_H_SY", "SC_S_SE"};

    @Override
    public String getSpeechClientName(int n) {
        if (n - 1 >= 0 && n - 1 < speechClientNames.length) {
            return speechClientNames[n - 1];
        }
        return null;
    }

    @Override
    public String getSpeechClientShortName(int n) {
        if (n - 1 >= 0 && n - 1 < speechClientShortNames.length) {
            return speechClientShortNames[n - 1];
        }
        return null;
    }
}

