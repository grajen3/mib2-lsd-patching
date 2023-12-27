/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.api.model;

import de.vw.mib.asl.api.phone.model.SpecialNumbers;

public class SpecialNumbersImpl
implements SpecialNumbers {
    private String mailbox;
    private String emergency;
    private String service;
    private String info;

    public void setMailbox(String string) {
        this.mailbox = string;
    }

    public void setEmergency(String string) {
        this.emergency = string;
    }

    public void setService(String string) {
        this.service = string;
    }

    public void setInfo(String string) {
        this.info = string;
    }

    @Override
    public String getMailbox() {
        return this.mailbox;
    }

    @Override
    public String getEmergency() {
        return this.emergency;
    }

    @Override
    public String getService() {
        return this.service;
    }

    @Override
    public String getInfo() {
        return this.info;
    }
}

