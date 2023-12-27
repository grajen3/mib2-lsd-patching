/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.dsi.media.impl.DSIRadioTaggingProxy;
import de.esolutions.fw.comm.dsi.media.impl.TagInformationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.TagInformation;

class DSIRadioTaggingProxy$2
implements ISerializable {
    private final /* synthetic */ TagInformation val$tagInformation1;
    private final /* synthetic */ TagInformation val$tagInformation2;
    private final /* synthetic */ DSIRadioTaggingProxy this$0;

    DSIRadioTaggingProxy$2(DSIRadioTaggingProxy dSIRadioTaggingProxy, TagInformation tagInformation, TagInformation tagInformation2) {
        this.this$0 = dSIRadioTaggingProxy;
        this.val$tagInformation1 = tagInformation;
        this.val$tagInformation2 = tagInformation2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TagInformationSerializer.putOptionalTagInformation(iSerializer, this.val$tagInformation1);
        TagInformationSerializer.putOptionalTagInformation(iSerializer, this.val$tagInformation2);
    }
}

