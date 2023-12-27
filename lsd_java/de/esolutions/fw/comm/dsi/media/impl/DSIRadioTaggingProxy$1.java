/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.dsi.media.impl.DSIRadioTaggingProxy;
import de.esolutions.fw.comm.dsi.media.impl.TagInformationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.TagInformation;

class DSIRadioTaggingProxy$1
implements ISerializable {
    private final /* synthetic */ TagInformation val$tagInformation;
    private final /* synthetic */ DSIRadioTaggingProxy this$0;

    DSIRadioTaggingProxy$1(DSIRadioTaggingProxy dSIRadioTaggingProxy, TagInformation tagInformation) {
        this.this$0 = dSIRadioTaggingProxy;
        this.val$tagInformation = tagInformation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TagInformationSerializer.putOptionalTagInformation(iSerializer, this.val$tagInformation);
    }
}

