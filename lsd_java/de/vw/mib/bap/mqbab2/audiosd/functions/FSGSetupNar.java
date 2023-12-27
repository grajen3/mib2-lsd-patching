/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.FSGSetup;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FSG_Setup_ReceptionList_AutoUpdate;

public class FSGSetupNar
extends FSGSetup {
    @Override
    protected void setReceptionListAutoUpdateFlags(FSG_Setup_ReceptionList_AutoUpdate fSG_Setup_ReceptionList_AutoUpdate) {
        super.setReceptionListAutoUpdateFlags(fSG_Setup_ReceptionList_AutoUpdate);
        fSG_Setup_ReceptionList_AutoUpdate.sdarsReceptionListIsAutomaticallyUpdated = true;
    }
}

