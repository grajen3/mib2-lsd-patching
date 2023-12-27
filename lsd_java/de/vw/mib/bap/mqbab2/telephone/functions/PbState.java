/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookServiceListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.PbState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class PbState
extends Function
implements Property,
ASLTelephoneConstants,
SystemServiceListener,
AddressbookServiceListener,
PhoneServiceListener {
    private static final int INVALID_NUMBER_OF_ENTRIES;
    protected static final int[] SYSTEM_LISTENER_IDS;
    protected static final int[] ADDRESSBOOK_LISTENER_IDS;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$PbState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getAddressbookService().addAddressbookServiceListener(this, ADDRESSBOOK_LISTENER_IDS);
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computePbState_Status();
    }

    protected void setPhoneBookStateStatus(PbState_Status pbState_Status) {
        int[] nArray = new int[]{53, 52};
        this.context.updateStages(this, nArray, pbState_Status);
    }

    protected PbState_Status dequeueBAPEntity() {
        return (PbState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$PbState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$PbState_Status = PbState.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.PbState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$PbState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 51;
    }

    @Override
    public void process(int n) {
        this.sendPbState(this.computePbState_Status());
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getAddressbookService().removeAddressbookServiceListener(this, ADDRESSBOOK_LISTENER_IDS);
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    private void setDownloadState(PbState_Status pbState_Status) {
        pbState_Status.downloadState = this.getSystemService().getAddressbookDomainAvailable() == 1 ? (this.getPhoneService().getContactsDownloadStatus() != 0 ? 1 : 2) : 0;
    }

    private void setPbEntries(PbState_Status pbState_Status) {
        if (pbState_Status.downloadState == 0) {
            pbState_Status.pbEntriesUhv = -65536;
        } else {
            int n = this.getAddressbookService().getPhoneBookNumberOEntries();
            if (n == -65536 || n == 0) {
                pbState_Status.pbEntriesUhv = 0;
            } else {
                pbState_Status.pbEntriesUhv = n;
                pbState_Status.downloadState = 2;
            }
        }
    }

    private void sendPbState(PbState_Status pbState_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(pbState_Status, this)) {
            this.setPhoneBookStateStatus(pbState_Status);
        }
    }

    private PbState_Status computePbState_Status() {
        PbState_Status pbState_Status = this.dequeueBAPEntity();
        this.setDownloadState(pbState_Status);
        this.setPbEntries(pbState_Status);
        return pbState_Status;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
        this.process(-1);
    }

    @Override
    public void updateAddressbookData(AddressbookService addressbookService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
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
        SYSTEM_LISTENER_IDS = new int[]{1645};
        ADDRESSBOOK_LISTENER_IDS = new int[]{1108};
        PHONE_LISTENER_IDS = new int[]{1180};
    }
}

