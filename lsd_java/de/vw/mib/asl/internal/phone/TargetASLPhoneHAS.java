/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.internal.phone.HASPhoneServicesImpl;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLPhoneTarget;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import generated.de.vw.mib.has.containers.ContactContainer;
import generated.de.vw.mib.has.contexts.phone.PhoneResults;

public class TargetASLPhoneHAS
extends AbstractASLPhoneTarget {
    HASEngineAPI engine = HAS.getInstance().getEngine();
    HASContext context = this.engine.getRegistry().getContextByName("Phone");
    private boolean alreadyRegistered = false;

    public TargetASLPhoneHAS(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5281;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            HASPhoneServicesImpl hASPhoneServicesImpl = new HASPhoneServicesImpl(this);
            this.context.setServicesImpl(hASPhoneServicesImpl);
        }
        this.alreadyRegistered = true;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                break;
            }
        }
    }

    public void callContact(int n, ContactContainer contactContainer) {
        this.trace(new StringBuffer().append("callContact received via HAS with callId=").append(n).append(" and number=").append(contactContainer != null ? contactContainer.getTelephoneNumber() : "null").toString());
        PhoneResults phoneResults = (PhoneResults)this.context.getResultsImpl();
        int n2 = 1;
        if (PhoneUtil.getFreeLine()) {
            if (contactContainer != null && contactContainer.isTelephoneNumberSet()) {
                this.trace("dial request sent to model");
                TargetASLPhoneHAS.writeStringToDatapool(-628943616, contactContainer.getTelephoneNumber());
                n2 = 0;
            } else {
                n2 = 1;
            }
        } else {
            n2 = -1;
        }
        phoneResults.callContactResult(n, n2);
        this.trace(new StringBuffer().append("callContact result sent via HAS with callId=").append(n).append(" and result=").append(n2).toString());
    }
}

