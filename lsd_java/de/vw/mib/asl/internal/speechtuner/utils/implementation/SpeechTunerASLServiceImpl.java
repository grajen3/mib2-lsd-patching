/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils.implementation;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechtuner.utils.FeatureAvailabilityChecker;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerASLServices;
import de.vw.mib.asl.internal.speechtuner.utils.implementation.FeatureAvailabilityCheckerImpl;
import de.vw.mib.configuration.ConfigurationManager;

public final class SpeechTunerASLServiceImpl
implements SpeechTunerASLServices {
    private final Services frameworkServices;
    private final FeatureAvailabilityChecker featureAvailabilityChecker;

    public SpeechTunerASLServiceImpl(Services services, ConfigurationManager configurationManager) {
        this.frameworkServices = services;
        this.featureAvailabilityChecker = new FeatureAvailabilityCheckerImpl(configurationManager);
    }

    @Override
    public long getCurrentTimeMillis() {
        return this.frameworkServices.getFramework4U().system.currentTimeMillis();
    }

    @Override
    public void requestAPI(Class clazz, ASLComponentAPICallback aSLComponentAPICallback) {
        this.frameworkServices.getASLComponentRegistry().requestAPI(clazz, aSLComponentAPICallback);
    }

    @Override
    public FeatureAvailabilityChecker getFeatureAvailabilityChecker() {
        return this.featureAvailabilityChecker;
    }
}

