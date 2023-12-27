/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.speech;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.exboxm.ExBoxMAudio;
import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechApplicant;
import de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechKeyHandler;
import de.vw.mib.asl.internal.exboxm.util.Preconditions;

public class ExboxSpeechApplicantFactory {
    public static ExboxSpeechApplicant createSpeechApplicant(ExboxServices exboxServices, ExBoxMAudio exBoxMAudio) {
        Preconditions.checkArgumentNotNull(exboxServices, "The ExboxServices must not be null.");
        Preconditions.checkArgumentNotNull(exBoxMAudio, "The ExBoxMAudio must not be null.");
        Preconditions.checkArgumentNotNull(exboxServices.getBundleContext(), "The bundleContext must not be null.");
        ExboxSpeechApplicant exboxSpeechApplicant = new ExboxSpeechApplicant(exboxServices, exBoxMAudio);
        Services services = exboxServices.getAslFrameworkApi().getServices();
        ExboxSpeechKeyHandler exboxSpeechKeyHandler = new ExboxSpeechKeyHandler(exboxSpeechApplicant, exboxServices.getLogger(), services);
        ASLSystemAPI aSLSystemAPI = exboxServices.getAslSystemApi();
        aSLSystemAPI.addKeyListener(15, exboxSpeechKeyHandler);
        for (int i2 = 0; i2 < ExboxSpeechKeyHandler.SPEECH_ABORT_KEYS.length; ++i2) {
            aSLSystemAPI.addKeyListener(ExboxSpeechKeyHandler.SPEECH_ABORT_KEYS[i2], exboxSpeechKeyHandler);
        }
        return exboxSpeechApplicant;
    }
}

