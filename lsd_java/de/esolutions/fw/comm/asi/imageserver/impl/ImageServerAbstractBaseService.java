/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.asi.imageserver.ImageServerReply;
import de.esolutions.fw.comm.asi.imageserver.ImageServerS;
import de.esolutions.fw.comm.asi.imageserver.impl.ImageServerAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ImageServerAbstractBaseService
implements ImageServerS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.imageserver.ImageServer");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public ImageServerAbstractBaseService() {
        ImageServerAbstractBaseService$AttributesBitMapProvider imageServerAbstractBaseService$AttributesBitMapProvider = new ImageServerAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ImageServer", imageServerAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ImageServerReply imageServerReply) {
        this.baseService.setNotification(l, (Object)imageServerReply);
        this.sendAttributeUpdate(l, imageServerReply);
    }

    @Override
    public synchronized void setNotification(ImageServerReply imageServerReply) {
        this.baseService.setNotification(imageServerReply);
        this.sendAttributeUpdate(imageServerReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ImageServerReply imageServerReply) {
        this.baseService.setNotification(lArray, (Object)imageServerReply);
        this.sendAttributeUpdate(lArray, imageServerReply);
    }

    @Override
    public synchronized void clearNotification(long l, ImageServerReply imageServerReply) {
        this.baseService.clearNotification(l, (Object)imageServerReply);
    }

    @Override
    public synchronized void clearNotification(ImageServerReply imageServerReply) {
        this.baseService.clearNotification(imageServerReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ImageServerReply imageServerReply) {
        this.baseService.clearNotification(lArray, (Object)imageServerReply);
    }

    private void sendAttributeUpdate(ImageServerReply imageServerReply) {
        try {
            imageServerReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ImageServerReply imageServerReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], imageServerReply);
        }
    }

    private void sendAttributeUpdate(long l, ImageServerReply imageServerReply) {
        try {
            if (l == 0) {
                imageServerReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else {
                System.out.println("unexpected");
            }
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    public void updateASIVersion(String string) {
        this.updateASIVersion(string, true);
    }

    public void updateASIVersion(String string, boolean bl) {
        this.ASIVersion = ImageServerAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ImageServerReply imageServerReply = (ImageServerReply)iterator.next();
            try {
                imageServerReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

