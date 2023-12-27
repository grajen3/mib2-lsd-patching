/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.capabilities;

import de.vw.mib.asl.api.speechengine.vde.Capabilities;
import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntryCallback;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.VdeCapabilityHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.capabilities.RequestVdeCaps$1;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.capabilities.RequestVdeCaps$2;
import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.VDECapabilities;

public class RequestVdeCaps
extends AbstractTask
implements VdeCapabilityHandler {
    private final VoiceDestinationEntryCallback vdeCallback;
    private final AsrController asrController;
    private final String countryAbbreviation;
    private static final String EMPTY_STRING;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler;

    public RequestVdeCaps(Logger logger, String string, VoiceDestinationEntryCallback voiceDestinationEntryCallback, AsrController asrController) {
        super(logger);
        this.vdeCallback = voiceDestinationEntryCallback;
        this.asrController = asrController;
        this.countryAbbreviation = string;
    }

    @Override
    public void execute() {
        if (this.countryAbbreviation == null || this.countryAbbreviation.equals("")) {
            this.taskLogger.error(512, "Attempt to request VDECapabilities with countryAbbreviation NULL or empty-string is not allowed! Returning default capabilities. ");
            this.vdeCallback.setCapabilitiesResult(this.getDefaultCaps());
            this.terminate();
        } else {
            this.asrController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler = RequestVdeCaps.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.VdeCapabilityHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler, this);
            this.asrController.getSpeechRec().requestVDECapabilities(this.countryAbbreviation);
        }
    }

    @Override
    public void terminate() {
        this.asrController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler = RequestVdeCaps.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.VdeCapabilityHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler, this);
    }

    @Override
    public void abort() {
    }

    @Override
    public void responseRequestVDECapabilities(int n, VDECapabilities vDECapabilities) {
        Capabilities capabilities = null;
        if (vDECapabilities == null) {
            capabilities = this.getDefaultCaps();
            this.terminate();
        } else if (this.countryAbbreviation.equals(vDECapabilities.getCountryAbbreviation())) {
            capabilities = this.getCaps(vDECapabilities);
            this.terminate();
        }
        try {
            this.vdeCallback.setCapabilitiesResult(capabilities);
        }
        catch (Exception exception) {
            LogMessage logMessage = this.taskLogger.error(512);
            logMessage.append("[RequestVdeCaps] ");
            logMessage.append("Catching exception from callback-handler. ");
            logMessage.attachThrowable(exception);
            logMessage.log();
        }
    }

    private Capabilities getDefaultCaps() {
        return new RequestVdeCaps$1(this);
    }

    private Capabilities getCaps(VDECapabilities vDECapabilities) {
        return new RequestVdeCaps$2(this, vDECapabilities);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

