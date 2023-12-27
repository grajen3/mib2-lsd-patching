/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersonalizationListener;

class PersonalizationListener$CopyProfileDesc {
    private final byte sourceProfile;
    private final byte destinationProfile;
    private final /* synthetic */ PersonalizationListener this$0;

    public PersonalizationListener$CopyProfileDesc(PersonalizationListener personalizationListener, byte by, byte by2) {
        this.this$0 = personalizationListener;
        this.sourceProfile = by;
        this.destinationProfile = by2;
    }

    public byte getSourceProfile() {
        return this.sourceProfile;
    }

    public byte getDestinationProfile() {
        return this.destinationProfile;
    }
}

