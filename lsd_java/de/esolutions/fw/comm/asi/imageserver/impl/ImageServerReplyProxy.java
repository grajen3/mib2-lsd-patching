/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.asi.imageserver.Image;
import de.esolutions.fw.comm.asi.imageserver.ImageInfo;
import de.esolutions.fw.comm.asi.imageserver.ImageServerReply;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageServerReplyProxy$1;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageServerReplyProxy$2;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageServerReplyProxy$3;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ImageServerReplyProxy
implements ImageServerReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.imageserver.ImageServer");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ImageServerReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4859e928-623e-4248-8210-d55453bef3a4", -1, "b9a016f3-d0ec-5bf0-bc90-42549185f0a0", "asi.imageserver.ImageServer");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseImage(String string, Image image, int n) {
        ImageServerReplyProxy$1 imageServerReplyProxy$1 = new ImageServerReplyProxy$1(this, string, image, n);
        this.proxy.remoteCallMethod((short)24, imageServerReplyProxy$1);
    }

    @Override
    public void responseImageInformation(String string, ImageInfo imageInfo, int n) {
        ImageServerReplyProxy$2 imageServerReplyProxy$2 = new ImageServerReplyProxy$2(this, string, imageInfo, n);
        this.proxy.remoteCallMethod((short)25, imageServerReplyProxy$2);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ImageServerReplyProxy$3 imageServerReplyProxy$3 = new ImageServerReplyProxy$3(this, string, bl);
        this.proxy.remoteCallMethod((short)23, imageServerReplyProxy$3);
    }
}

