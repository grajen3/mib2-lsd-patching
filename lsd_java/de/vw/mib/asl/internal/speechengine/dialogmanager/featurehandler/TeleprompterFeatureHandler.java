/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerParameters;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractCommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TeleprompterFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TeleprompterFeatureHandler$2;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TeleprompterFeatureHandler$3;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TeleprompterFeatureHandler$4;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.client.context.TeleprompterOnOffContextFeature;
import de.vw.mib.asl.internal.speechengine.features.master.TeleprompterOnOffMasterFeature;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.HashSet;
import java.util.Set;

public class TeleprompterFeatureHandler {
    private static final String LOGGER_PREFIX;
    private static final String COMMAND_ON;
    private static final String COMMAND_OFF;
    protected DialogManagerLogger logger = new DialogManagerLogger("[TeleprompterFeatureHandler] ");
    private DialogManagerInternal dialogManager;
    protected TeleprompterManager teleprompterManager;
    private AbstractCommandConsumer onCommandConsumer;
    private AbstractCommandConsumer offCommandConsumer;
    protected OrderedPromptsManager onPrompts;
    protected OrderedPromptsManager offPrompts;
    protected IntObjectMap onEvents;
    protected IntObjectMap offEvents;
    protected Set clients;
    private FeatureHandler teleprompterFeatureHandler = new TeleprompterFeatureHandler$1(this);
    private FeatureHandler teleprompterContextFeatureHandler = new TeleprompterFeatureHandler$2(this);

    public TeleprompterFeatureHandler(DialogManagerInternal dialogManagerInternal, DialogManagerParameters dialogManagerParameters) {
        this.dialogManager = dialogManagerInternal;
        this.teleprompterManager = dialogManagerParameters.getTeleprompterManager();
        this.initCommandConsumers();
        this.onPrompts = new OrderedPromptsManager();
        this.offPrompts = new OrderedPromptsManager();
        this.onEvents = new IntObjectOptHashMap();
        this.offEvents = new IntObjectOptHashMap();
        this.clients = new HashSet();
        dialogManagerInternal.registerFeatureHandler(203, this.teleprompterContextFeatureHandler);
        dialogManagerInternal.registerFeatureHandler(112, this.teleprompterFeatureHandler);
    }

    void handleTeleprompterFeature(TeleprompterOnOffMasterFeature teleprompterOnOffMasterFeature) {
        if (teleprompterOnOffMasterFeature.isTeleprompterOnCommandValid()) {
            this.onCommandConsumer.updateCommand(teleprompterOnOffMasterFeature.getTeleprompterOnCommand());
        }
        if (teleprompterOnOffMasterFeature.isTeleprompterOffCommandValid()) {
            this.offCommandConsumer.updateCommand(teleprompterOnOffMasterFeature.getTeleprompterOffCommand());
        }
        if (teleprompterOnOffMasterFeature.isTeleprompterOnPromptsValid()) {
            this.onPrompts.clearPrompts();
            this.onPrompts.addPrompts(teleprompterOnOffMasterFeature.getTeleprompterOnPrompts());
        }
        if (teleprompterOnOffMasterFeature.isTeleprompterOffPromptsValid()) {
            this.offPrompts.clearPrompts();
            this.offPrompts.addPrompts(teleprompterOnOffMasterFeature.getTeleprompterOffPrompts());
        }
    }

    void setTeleprompterContextFeature(TeleprompterOnOffContextFeature teleprompterOnOffContextFeature) {
        this.logger.error("TeleprompterOnOffClientFeature is deprecated. Please use TeleprompterStateConsumer in ASL to listen for Teleprompter state.");
    }

    private void initCommandConsumers() {
        this.onCommandConsumer = new TeleprompterFeatureHandler$3(this, this.dialogManager, "[TeleprompterFeatureHandler] ", "TELEPROMPTER_ON");
        this.offCommandConsumer = new TeleprompterFeatureHandler$4(this, this.dialogManager, "[TeleprompterFeatureHandler] ", "TELEPROMPTER_OFF");
    }
}

