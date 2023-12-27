/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sdfeaturecollectionmanager.internal;

import de.vw.mib.asl.api.speechengine.features.FeatureFactory;
import de.vw.mib.asl.api.speechengine.speechproxy.SpeechProxy;
import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionHandlerFactory;

public final class ServiceManagerSdFeatureCollection {
    public static SdFeatureCollectionHandlerFactory sdFeatureCollectionHandlerFactory;
    public static FeatureFactory featureFactory;
    public static SpeechProxy speechProxy;
    public static int maxSpeechIndex;

    private ServiceManagerSdFeatureCollection() {
    }
}

