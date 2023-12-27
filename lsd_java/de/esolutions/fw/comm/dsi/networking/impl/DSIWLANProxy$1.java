/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.comm.dsi.networking.impl.DSIWLANProxy;
import de.esolutions.fw.comm.dsi.networking.impl.ProfileSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.networking.Profile;

class DSIWLANProxy$1
implements ISerializable {
    private final /* synthetic */ Profile val$profileData;
    private final /* synthetic */ DSIWLANProxy this$0;

    DSIWLANProxy$1(DSIWLANProxy dSIWLANProxy, Profile profile) {
        this.this$0 = dSIWLANProxy;
        this.val$profileData = profile;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ProfileSerializer.putOptionalProfile(iSerializer, this.val$profileData);
    }
}

