/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.teleprompter;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.api.speechengine.features.model.DynamicString;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterData;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterDataConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SpeechClientIdentifiersUtil;
import de.vw.mib.asl.internal.speechengine.features.client.state.TeleprompterDataStateFeature;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataImpl;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataManagerLogger;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import java.util.ArrayList;
import java.util.List;

public class TeleprompterDataManagerImpl
extends AbstractFeatureHandler {
    protected TeleprompterDataManagerLogger logger = new TeleprompterDataManagerLogger("[TeleprompterDataManager] ");
    private TeleprompterData emptyData;
    private List consumers;
    private IntSet activeClients;
    private TeleprompterData currentData;

    public TeleprompterDataManagerImpl(DialogManagerInternal dialogManagerInternal) {
        dialogManagerInternal.registerFeatureHandler(309, this);
        this.consumers = new ArrayList();
        this.activeClients = new IntOptHashSet();
        TeleprompterDataImpl teleprompterDataImpl = new TeleprompterDataImpl();
        teleprompterDataImpl.setHeadlineTitle(null);
        teleprompterDataImpl.setCommandExamples(new DynamicString[0]);
        teleprompterDataImpl.setTeleprompterType(1);
        this.emptyData = teleprompterDataImpl;
    }

    public void register(TeleprompterDataConsumer teleprompterDataConsumer) {
        if (!this.consumers.contains(teleprompterDataConsumer)) {
            this.consumers.add(teleprompterDataConsumer);
        }
    }

    public void unregister(TeleprompterDataConsumer teleprompterDataConsumer) {
        this.consumers.remove(teleprompterDataConsumer);
    }

    public TeleprompterData getTeleprompterData() {
        return this.currentData;
    }

    private void notifyTeleprompterDataChanged() {
        this.logger.logTeleprompterData(this.currentData);
        for (int i2 = 0; i2 < this.consumers.size(); ++i2) {
            TeleprompterDataConsumer teleprompterDataConsumer = (TeleprompterDataConsumer)this.consumers.get(i2);
            teleprompterDataConsumer.onTeleprompterDataChanged(this.currentData);
        }
    }

    private void handleTeleprompterDataFeature(int n, TeleprompterDataStateFeature teleprompterDataStateFeature) {
        if (teleprompterDataStateFeature.isTeleprompterTypeValid() && teleprompterDataStateFeature.getTeleprompterType() == 0) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("Empty TeleprompterDateFeature from client: ").append(SpeechClientIdentifiersUtil.toString(n)).log();
            }
            this.deactivateClient(n);
            if (this.activeClients.size() == 0) {
                this.currentData = this.emptyData;
                this.notifyTeleprompterDataChanged();
            }
            return;
        }
        if (teleprompterDataStateFeature.isTeleprompterTypeValid() && teleprompterDataStateFeature.isHeadlineTextValid() && teleprompterDataStateFeature.isCommandExamplesValid()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("Filled TeleprompterDateFeature from client: ").append(SpeechClientIdentifiersUtil.toString(n)).log();
            }
            this.activateClient(n);
            TeleprompterDataImpl teleprompterDataImpl = new TeleprompterDataImpl();
            teleprompterDataImpl.setTeleprompterType(this.adaptTeleprompterType(teleprompterDataStateFeature.getTeleprompterType()));
            teleprompterDataImpl.setHeadlineTitle(teleprompterDataStateFeature.getHeadlineText());
            teleprompterDataImpl.setCommandExamples(teleprompterDataStateFeature.getCommandExamples());
            this.currentData = teleprompterDataImpl;
            this.notifyTeleprompterDataChanged();
        } else {
            this.logger.error("Cannot handle TeleprompterDataFeature, because the dataset is not complete.");
        }
    }

    private int adaptTeleprompterType(int n) {
        switch (n) {
            case 4: {
                return 5;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
            case 0: {
                return 1;
            }
        }
        this.logger.error(new StringBuffer().append("adaptTeleprompterType() unknown TeleprompterType: ").append(n).toString());
        return 1;
    }

    private void activateClient(int n) {
        this.activeClients.add(n);
    }

    private void deactivateClient(int n) {
        this.activeClients.remove(n);
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.handleTeleprompterDataFeature(n, (TeleprompterDataStateFeature)feature);
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.handleTeleprompterDataFeature(n, (TeleprompterDataStateFeature)feature);
    }
}

