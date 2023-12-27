/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging.util;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MatchedAddress;

public class CompatibilityAccessor {
    private CompatibilityAccessor() {
    }

    public static ResourceLocator getAttachmentPath(AttachmentInformation attachmentInformation) {
        ResourceLocator resourceLocator = attachmentInformation.getAttachmentPath();
        if (resourceLocator instanceof String) {
            return new ResourceLocator((String)((Object)resourceLocator));
        }
        return resourceLocator;
    }

    public static ResourceLocator getAdbPictureID(MatchedAddress matchedAddress) {
        ResourceLocator resourceLocator = matchedAddress.getAdbPictureID();
        if (resourceLocator instanceof String) {
            return new ResourceLocator((String)((Object)resourceLocator));
        }
        return resourceLocator;
    }
}

