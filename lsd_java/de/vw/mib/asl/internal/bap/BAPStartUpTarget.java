/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.bap;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.bap.BAPStartUpTarget$BapStartupState;
import de.vw.mib.bap.mqbab2.audiosd.controller.AudioSdTarget;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;
import de.vw.mib.bap.mqbab2.navsd.controller.NavSdTarget;
import de.vw.mib.bap.mqbab2.sdssd.controller.SDSSDTarget;
import de.vw.mib.bap.mqbab2.telephone.controller.TelephoneTarget;
import de.vw.mib.bap.mqbab2.telephone2.controller.Telephone2Target;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class BAPStartUpTarget
extends AbstractASLHsmTarget {
    private AudioSdTarget audioSdTarget;
    private NavSdTarget navSdTarget;
    private TelephoneTarget telephoneTarget;
    private Telephone2Target telephone2Target;
    private SDSSDTarget sdsSdTarget;
    protected final HsmState bapStartupState = new BAPStartUpTarget$BapStartupState(this, this.getHsm(), "Startup", super.getWorkStateParent());

    public BAPStartUpTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1484843264;
    }

    public Logger getLogger() {
        return APIFactory.getAPIFactory().getLogger();
    }

    @Override
    protected HsmState getDefaultState() {
        return this.bapStartupState;
    }

    private void startAudioSDTarget() {
        try {
            this.audioSdTarget = new AudioSdTarget(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents(), "hsmtask");
            this.audioSdTarget.triggerMe(106);
        }
        catch (Exception exception) {
            APIFactory.getAPIFactory().getLogger().error(1, "Error during starting of AudioSDTarget", exception);
        }
    }

    private void startNavSDTarget() {
        try {
            this.navSdTarget = new NavSdTarget(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents(), "hsmtask");
            this.navSdTarget.triggerMe(106);
        }
        catch (Exception exception) {
            APIFactory.getAPIFactory().getLogger().error(1, "Error during starting of NavSDTarget", exception);
        }
    }

    private void startPhoneTarget() {
        try {
            this.telephoneTarget = new TelephoneTarget(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents(), "hsmtask");
            this.telephoneTarget.triggerMe(106);
        }
        catch (Exception exception) {
            APIFactory.getAPIFactory().getLogger().error(1, "Error during starting of TelephoneTarget", exception);
        }
    }

    private void startPhone2Target() {
        try {
            this.telephone2Target = new Telephone2Target(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents(), "hsmtask");
            this.telephone2Target.triggerMe(106);
        }
        catch (Exception exception) {
            APIFactory.getAPIFactory().getLogger().error(1, "Error during starting of Telephone2Target", exception);
        }
    }

    private void startSDSTarget() {
        try {
            this.sdsSdTarget = new SDSSDTarget(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents(), "hsmtask");
            this.sdsSdTarget.triggerMe(106);
        }
        catch (Exception exception) {
            APIFactory.getAPIFactory().getLogger().error(1, "Error during starting of SDSSDTarget", exception);
        }
    }

    private void startBapTargets() {
        if (this.audioSdTarget == null) {
            this.startAudioSDTarget();
        }
        ConfigurationService configurationService = APIFactory.getAPIFactory().getConfigurationService();
        if (this.navSdTarget == null && (configurationService.isNavigationFeatureSelected() || configurationService.isNARVariantSelected()) && !configurationService.isExboxFeatureSelected()) {
            this.startNavSDTarget();
        }
        if (this.telephoneTarget == null) {
            this.startPhoneTarget();
        }
        if (this.telephone2Target == null) {
            this.startPhone2Target();
        }
        if (this.sdsSdTarget == null) {
            this.startSDSTarget();
        }
    }

    static /* synthetic */ void access$000(BAPStartUpTarget bAPStartUpTarget) {
        bAPStartUpTarget.startBapTargets();
    }

    static /* synthetic */ HsmState access$100(BAPStartUpTarget bAPStartUpTarget) {
        return bAPStartUpTarget.stateTop;
    }
}

