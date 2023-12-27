/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sdfeaturecollectionmanager.internal;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionHandler;
import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionManager;
import de.vw.mib.sdfeaturecollectionmanager.internal.ServiceManagerSdFeatureCollection;
import edu.emory.mathcs.backport.java.util.Arrays;

public class SdFeatureCollectionManagerImpl
implements SdFeatureCollectionManager {
    private static final int INITIAL_STACK_DEPTH;
    private static final int STACKSIZE_INITIAL;
    private static final int STACKSIZE_INCREASE;
    private static final int NON_EXISTENT_SD_FEATURE_COLLECTION_ID;
    private static final Feature[] EMPTY_FEATURE_ARRAY;
    private final int[] currentStackDepth;
    private final int[] oldStackDepthFromLastChange;
    private final int[][] stackedFeatureCollectionIds;
    private final int[][] instantiatedFeatureCollectionIds;
    private final SdFeatureCollectionHandler[][] instantiatedSdFeatureCollectionHandlers;
    private final Logger logger = ServiceManagerCommon.loggerFactory.getLogger(4096);

    public SdFeatureCollectionManagerImpl() {
        int n = ServiceManagerSdFeatureCollection.maxSpeechIndex;
        this.currentStackDepth = new int[n];
        this.oldStackDepthFromLastChange = new int[n];
        this.stackedFeatureCollectionIds = new int[n][3];
        this.instantiatedFeatureCollectionIds = new int[n][3];
        this.instantiatedSdFeatureCollectionHandlers = new SdFeatureCollectionHandler[n][3];
        for (int i2 = 0; i2 < n; ++i2) {
            this.currentStackDepth[i2] = -1;
            this.oldStackDepthFromLastChange[i2] = -1;
            for (int i3 = 0; i3 < this.stackedFeatureCollectionIds[i2].length; ++i3) {
                this.stackedFeatureCollectionIds[i2][i3] = -1;
                this.instantiatedFeatureCollectionIds[i2][i3] = -1;
            }
        }
    }

    @Override
    public void changeSdFeatureCollection(int n, int n2) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.trace(1).append("Changing SdCommandFeatureCollection: ").append(n).log();
        }
        this.instantiateNewDestroyOldSdFeatureCollectionHandlersFromBottomToTop(n, n2);
        this.destroyOldSdFeatureCollectionHandlersAboveTop(n);
        this.collectSdFeaturesAndActivatePropertyObservation(n, n2);
        this.oldStackDepthFromLastChange[n] = this.currentStackDepth[n];
    }

    @Override
    public void pushSdFeatureCollection(int n, int n2) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.trace(1).append("Pushing SdCommandFeatureCollection: ").append(n).append("/").append(n2).log();
        }
        int n3 = n;
        this.currentStackDepth[n3] = this.currentStackDepth[n3] + 1;
        if (this.currentStackDepth[n] >= this.stackedFeatureCollectionIds[n].length) {
            this.increaseStackSize(n);
        }
        this.stackedFeatureCollectionIds[n][this.currentStackDepth[n]] = n2;
    }

    @Override
    public void popSdFeatureCollection(int n) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.trace(1).append("Popping SdCommandFeatureCollection: ").append(n).log();
        }
        if (this.currentStackDepth[n] == -1) {
            this.logger.error(1).append("Cannot pop an SdFeatureCollectionHandler for speech SM, because stack index would be negative! Speech sm Index: ").append(n).log();
            return;
        }
        this.stackedFeatureCollectionIds[n][this.currentStackDepth[n]] = -1;
        int n2 = n;
        this.currentStackDepth[n2] = this.currentStackDepth[n2] - 1;
    }

    private void instantiateNewDestroyOldSdFeatureCollectionHandlersFromBottomToTop(int n, int n2) {
        for (int i2 = 0; i2 <= this.currentStackDepth[n]; ++i2) {
            this.reuseExistingHandlerOrDestroyAndCreateNewOne(n, n2, i2);
            this.setParentRelation(n, i2);
        }
    }

    private void reuseExistingHandlerOrDestroyAndCreateNewOne(int n, int n2, int n3) {
        if (this.instantiatedFeatureCollectionIds[n][n3] != this.stackedFeatureCollectionIds[n][n3]) {
            this.destroyHandler(n, n3);
            this.createHandler(n, n3, n2);
        }
    }

    private void destroyOldSdFeatureCollectionHandlersAboveTop(int n) {
        for (int i2 = this.currentStackDepth[n] + 1; i2 < this.stackedFeatureCollectionIds[n].length; ++i2) {
            if (this.instantiatedSdFeatureCollectionHandlers[n][i2] == null) continue;
            this.destroyHandler(n, i2);
        }
    }

    private void collectSdFeaturesAndActivatePropertyObservation(int n, int n2) {
        if (this.currentStackDepth[n] > -1) {
            SdFeatureCollectionHandler sdFeatureCollectionHandler = this.instantiatedSdFeatureCollectionHandlers[n][this.currentStackDepth[n]];
            ServiceManagerSdFeatureCollection.speechProxy.setFeatures(n2, sdFeatureCollectionHandler.collectFeaturesAndActivateConditionObservation());
        } else {
            this.logger.info(1).append(new StringBuffer().append("Empty stack at SdFeatureCollectionManager (smIndex = ").append(n).append(", speechClientId = ").append(n2).append("). Will send empty Features to SpeechProxy.").toString()).log();
            this.sendEmptyFeatures(n2);
        }
    }

    private void sendEmptyFeatures(int n) {
        ServiceManagerSdFeatureCollection.speechProxy.setFeatures(n, EMPTY_FEATURE_ARRAY);
    }

    private void setParentRelation(int n, int n2) {
        if (n2 == 0) {
            return;
        }
        this.instantiatedSdFeatureCollectionHandlers[n][n2].setParent(this.instantiatedSdFeatureCollectionHandlers[n][n2 - 1]);
    }

    private void destroyHandler(int n, int n2) {
        if (this.instantiatedSdFeatureCollectionHandlers[n][n2] != null) {
            this.instantiatedSdFeatureCollectionHandlers[n][n2].destroy();
            ServiceManagerSdFeatureCollection.sdFeatureCollectionHandlerFactory.destroySdFeatureCollectionHandler(this.instantiatedSdFeatureCollectionHandlers[n][n2]);
            this.instantiatedSdFeatureCollectionHandlers[n][n2] = null;
            this.instantiatedFeatureCollectionIds[n][n2] = -1;
        }
    }

    private void createHandler(int n, int n2, int n3) {
        int n4 = this.stackedFeatureCollectionIds[n][n2];
        SdFeatureCollectionHandler sdFeatureCollectionHandler = ServiceManagerSdFeatureCollection.sdFeatureCollectionHandlerFactory.createSdFeatureCollectionHandler(n4, n3);
        this.instantiatedFeatureCollectionIds[n][n2] = n4;
        this.instantiatedSdFeatureCollectionHandlers[n][n2] = sdFeatureCollectionHandler;
    }

    private void increaseStackSize(int n) {
        this.stackedFeatureCollectionIds[n] = Arrays.copyOf(this.stackedFeatureCollectionIds[n], this.stackedFeatureCollectionIds[n].length + 1);
        this.instantiatedFeatureCollectionIds[n] = Arrays.copyOf(this.instantiatedFeatureCollectionIds[n], this.instantiatedFeatureCollectionIds[n].length + 1);
        for (int i2 = this.currentStackDepth[n]; i2 < this.stackedFeatureCollectionIds[n].length; ++i2) {
            this.stackedFeatureCollectionIds[n][i2] = -1;
            this.instantiatedFeatureCollectionIds[n][i2] = -1;
        }
        this.instantiatedSdFeatureCollectionHandlers[n] = (SdFeatureCollectionHandler[])Arrays.copyOf(this.instantiatedSdFeatureCollectionHandlers[n], this.instantiatedSdFeatureCollectionHandlers[n].length + 1);
    }

    static {
        EMPTY_FEATURE_ARRAY = new Feature[0];
    }
}

