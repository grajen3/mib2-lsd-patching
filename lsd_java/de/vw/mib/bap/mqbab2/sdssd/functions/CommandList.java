/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.functions;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechService;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechServiceListener;
import de.vw.mib.bap.mqbab2.common.api.speech.datatypes.SpeechCommand;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayDeltaContext;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListElementComparator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListGenericIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.CommandList_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.CommandList_Data;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.CommandList_GetArray;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.CommandList_StatusArray;
import java.util.Iterator;
import java.util.List;

public class CommandList
extends Function
implements FsgArrayListElementComparator,
Array,
SpeechServiceListener {
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MAX_ELEMENTS__COMMAND_ID;
    private static final int MAX_ELEMENTS__COMMAND_ID_COMMAND_TEXT;
    private static final int MAX_ELEMENTS__COMMAND_TEXT;
    private static final int MAX_ELEMENTS__POS;
    public static final int COMMAND_LIST__CHANGED_ARRAY_ACK_RECEIVED;
    private static final int COMMAND_LIST_DATA__UNKNOWN_COMMAND_ID;
    protected FsgArrayListComplete commandsList;
    protected static final int[] SPEECH_LISTENER_IDS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    private boolean internalBocked;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$CommandList_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.commandsList = new FsgArrayListComplete(new FsgArrayListGenericIdGenerator(255, 1));
        this.getSpeechService().addSpeechServiceListener(this, SPEECH_LISTENER_IDS);
        return this.getCommandListFullRangeUpdate();
    }

    protected CommandList_ChangedArray dequeueBAPEntity() {
        return (CommandList_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$CommandList_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$CommandList_ChangedArray = CommandList.class$("de.vw.mib.bap.mqbab2.generated.sdssd.serializer.CommandList_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$CommandList_ChangedArray);
    }

    protected void updateReceivedAcknowledgment() {
        int[] nArray = new int[]{17};
        this.context.updateStages(this, nArray, new Integer(1));
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 17: {
                this.setBlocked((Boolean)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 18;
    }

    private FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    private CommandList_ChangedArray getCommandListFullRangeUpdate() {
        CommandList_ChangedArray commandList_ChangedArray = this.dequeueBAPEntity();
        commandList_ChangedArray.getArrayHeader().setFullRangeUpdate(false);
        return commandList_ChangedArray;
    }

    private void transmitStatus(ArrayListener arrayListener, CommandList_StatusArray commandList_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(commandList_StatusArray);
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        CommandList_GetArray commandList_GetArray = (CommandList_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(commandList_GetArray)) {
            if (!this.getSpeechService().isSdsSdInMenuActive()) {
                this.transmitStatus(arrayListener, this.getEmptyCommandListArray(commandList_GetArray));
            } else {
                FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(commandList_GetArray.getArrayHeader(), this.commandsList, CommandList.maximumElementsForRecordAddress(commandList_GetArray.getArrayHeader().getRecordAddress()));
                CommandList_StatusArray commandList_StatusArray = new CommandList_StatusArray();
                fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(commandList_StatusArray, commandList_GetArray, this.commandsList);
                fsgArrayRequestData.setTransmissionPosForArbitraryArray(commandList_StatusArray);
                this.transmitStatus(arrayListener, commandList_StatusArray);
            }
        }
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(55, this);
    }

    public CommandList_StatusArray getEmptyCommandListArray(CommandList_GetArray commandList_GetArray) {
        CommandList_StatusArray commandList_StatusArray = new CommandList_StatusArray();
        commandList_StatusArray.setAsgId(commandList_GetArray.getAsgId());
        commandList_StatusArray.setTransactionId(commandList_GetArray.getTransactionId());
        commandList_StatusArray.setArrayHeader(commandList_GetArray.getArrayHeader());
        return commandList_StatusArray;
    }

    @Override
    public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        int n2;
        CommandList_Data commandList_Data = (CommandList_Data)bAPArrayElement;
        CommandList_Data commandList_Data2 = (CommandList_Data)bAPArrayElement2;
        switch (n) {
            case -1: {
                if (commandList_Data.commandId != commandList_Data2.commandId && !commandList_Data.commandText.equalTo(commandList_Data2.commandText)) {
                    n2 = 1;
                    break;
                }
                if (commandList_Data.commandText.equalTo(commandList_Data2.commandText)) {
                    n2 = 3;
                    break;
                }
                if (commandList_Data.commandId != commandList_Data2.commandId) {
                    n2 = 2;
                    break;
                }
                n2 = -1;
                break;
            }
            case 2: {
                if (!commandList_Data.commandText.equalTo(commandList_Data2.commandText)) {
                    n2 = 1;
                    break;
                }
                if (commandList_Data.commandId != commandList_Data2.commandId) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            case 3: {
                if (commandList_Data.commandId != commandList_Data2.commandId) {
                    n2 = 1;
                    break;
                }
                if (!commandList_Data.commandText.equalTo(commandList_Data2.commandText)) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                n2 = commandList_Data.commandId != commandList_Data2.commandId || !commandList_Data.commandText.equalTo(commandList_Data2.commandText) ? n : -1;
            }
        }
        return n2;
    }

    @Override
    public void requestAcknowledge() {
        if (this.getLogger().isTraceEnabled(1024)) {
            this.getLogger().trace(1024).append("CommandList: Acknowledgement received.").log();
        }
        this.getArrayRequestTracker().requestAcknowledge();
        this.updateReceivedAcknowledgment();
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
        this.getArrayRequestTracker().reset();
    }

    @Override
    public void uninitialize() {
        this.getSpeechService().removeSpeechServiceListener(this, SPEECH_LISTENER_IDS);
        this.getArrayRequestTracker().reset();
    }

    private void reportCommandListChangedContent(boolean bl) {
        Object object;
        CommandList_ChangedArray commandList_ChangedArray;
        if (this.getLogger().isTraceEnabled(1024)) {
            this.getLogger().trace(1024).append("CommandList: process ");
        }
        if (!this.getSpeechService().isSdsSdInMenuActive()) {
            if (this.commandsList.getSize() > 0) {
                this.commandsList.clear();
                commandList_ChangedArray = this.getCommandListFullRangeUpdate();
            } else {
                commandList_ChangedArray = null;
            }
        } else if (this.commandsList.numberOfMappedIDValues() > 200) {
            this.commandsList.clear();
            this.computeFullCommandList();
            commandList_ChangedArray = this.getCommandListFullRangeUpdate();
        } else {
            object = this.commandsList.createNewDeltaContext(this);
            this.computeFullCommandList();
            commandList_ChangedArray = this.searchForChangedContent((FsgArrayDeltaContext)object);
        }
        if (bl && commandList_ChangedArray == null) {
            commandList_ChangedArray = this.getCommandListFullRangeUpdate();
        }
        if (commandList_ChangedArray != null) {
            if (this.getLogger().isTraceEnabled(1024)) {
                object = this.getLogger().trace(1024).append("CommandList: Commands changed: ");
                List list = this.getSpeechService().getCommands();
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    SpeechCommand speechCommand = (SpeechCommand)iterator.next();
                    object.append("\"").append(speechCommand.getText()).append("\" ");
                }
                object.log();
                this.getLogger().trace(1024).append("CommandList: Report ChangedArray. ").log();
            }
            this.getArrayRequestTracker().reportChangedArray(commandList_ChangedArray);
        }
    }

    @Override
    public void process(int n) {
        this.reportCommandListChangedContent(false);
    }

    private void computeFullCommandList() {
        this.commandsList.clear();
        List list = this.getSpeechService().getCommands();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SpeechCommand speechCommand = (SpeechCommand)iterator.next();
            CommandList_Data commandList_Data = new CommandList_Data(null);
            commandList_Data.commandId = -1;
            commandList_Data.commandText.setContent(speechCommand.getText());
            this.commandsList.putElement(speechCommand.hashCode(), commandList_Data, -1L);
        }
    }

    private CommandList_ChangedArray searchForChangedContent(FsgArrayDeltaContext fsgArrayDeltaContext) {
        CommandList_ChangedArray commandList_ChangedArray = this.dequeueBAPEntity();
        if (!FsgArrayRequestData.computeChangeArrayData(commandList_ChangedArray, fsgArrayDeltaContext, this.commandsList, false)) {
            commandList_ChangedArray = null;
        }
        return commandList_ChangedArray;
    }

    private static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 5;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            case 15: {
                n2 = 5;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateSpeechData(SpeechService speechService, int n) {
        if (n == -352124800 && this.getLogger().isTraceEnabled(1024)) {
            this.getLogger().trace(1024).append("CommandList: TeleprompterData changed.").log();
        }
        if (!this.isBlocked()) {
            this.process(-1);
        }
    }

    public boolean isBlocked() {
        return this.internalBocked;
    }

    public void setBlocked(boolean bl) {
        if (this.internalBocked != bl) {
            if (!bl) {
                if (this.getLogger().isTraceEnabled(1024)) {
                    this.getLogger().trace(1024).append("CommandList: Unblocked process: ");
                }
                this.reportCommandListChangedContent(true);
            }
            this.internalBocked = bl;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        SPEECH_LISTENER_IDS = new int[]{-352124800};
    }
}

