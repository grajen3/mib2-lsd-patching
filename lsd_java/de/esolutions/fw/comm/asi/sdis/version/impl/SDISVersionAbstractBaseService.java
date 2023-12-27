/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version.impl;

import de.esolutions.fw.comm.asi.sdis.version.SDISVersionReply;
import de.esolutions.fw.comm.asi.sdis.version.SDISVersionS;
import de.esolutions.fw.comm.asi.sdis.version.impl.SDISVersionAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class SDISVersionAbstractBaseService
implements SDISVersionS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.sdis.version.SDISVersion");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private String SDISInterfaceVersion;
    private boolean SDISInterfaceVersion_valid = false;
    private String MMXSWVersion;
    private boolean MMXSWVersion_valid = false;
    private String MMXSKUVersion;
    private boolean MMXSKUVersion_valid = false;
    private String MUDetailedVersion;
    private boolean MUDetailedVersion_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public SDISVersionAbstractBaseService() {
        SDISVersionAbstractBaseService$AttributesBitMapProvider sDISVersionAbstractBaseService$AttributesBitMapProvider = new SDISVersionAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("SDISVersion", sDISVersionAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, SDISVersionReply sDISVersionReply) {
        this.baseService.setNotification(l, (Object)sDISVersionReply);
        this.sendAttributeUpdate(l, sDISVersionReply);
    }

    @Override
    public synchronized void setNotification(SDISVersionReply sDISVersionReply) {
        this.baseService.setNotification(sDISVersionReply);
        this.sendAttributeUpdate(sDISVersionReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, SDISVersionReply sDISVersionReply) {
        this.baseService.setNotification(lArray, (Object)sDISVersionReply);
        this.sendAttributeUpdate(lArray, sDISVersionReply);
    }

    @Override
    public synchronized void clearNotification(long l, SDISVersionReply sDISVersionReply) {
        this.baseService.clearNotification(l, (Object)sDISVersionReply);
    }

    @Override
    public synchronized void clearNotification(SDISVersionReply sDISVersionReply) {
        this.baseService.clearNotification(sDISVersionReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, SDISVersionReply sDISVersionReply) {
        this.baseService.clearNotification(lArray, (Object)sDISVersionReply);
    }

    private void sendAttributeUpdate(SDISVersionReply sDISVersionReply) {
        try {
            sDISVersionReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            sDISVersionReply.updateSDISInterfaceVersion(this.SDISInterfaceVersion, this.SDISInterfaceVersion_valid);
            sDISVersionReply.updateMMXSWVersion(this.MMXSWVersion, this.MMXSWVersion_valid);
            sDISVersionReply.updateMMXSKUVersion(this.MMXSKUVersion, this.MMXSKUVersion_valid);
            sDISVersionReply.updateMUDetailedVersion(this.MUDetailedVersion, this.MUDetailedVersion_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, SDISVersionReply sDISVersionReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], sDISVersionReply);
        }
    }

    private void sendAttributeUpdate(long l, SDISVersionReply sDISVersionReply) {
        try {
            if (l == 0) {
                sDISVersionReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                sDISVersionReply.updateSDISInterfaceVersion(this.SDISInterfaceVersion, this.SDISInterfaceVersion_valid);
            } else if (l == 0) {
                sDISVersionReply.updateMMXSWVersion(this.MMXSWVersion, this.MMXSWVersion_valid);
            } else if (l == 0) {
                sDISVersionReply.updateMMXSKUVersion(this.MMXSKUVersion, this.MMXSKUVersion_valid);
            } else if (l == 0) {
                sDISVersionReply.updateMUDetailedVersion(this.MUDetailedVersion, this.MUDetailedVersion_valid);
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
        this.ASIVersion = SDISVersionAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SDISVersionReply sDISVersionReply = (SDISVersionReply)iterator.next();
            try {
                sDISVersionReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSDISInterfaceVersion(String string) {
        this.updateSDISInterfaceVersion(string, true);
    }

    public void updateSDISInterfaceVersion(String string, boolean bl) {
        this.SDISInterfaceVersion = SDISVersionAbstractBaseService.copyString(string);
        this.SDISInterfaceVersion_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SDISVersionReply sDISVersionReply = (SDISVersionReply)iterator.next();
            try {
                sDISVersionReply.updateSDISInterfaceVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateMMXSWVersion(String string) {
        this.updateMMXSWVersion(string, true);
    }

    public void updateMMXSWVersion(String string, boolean bl) {
        this.MMXSWVersion = SDISVersionAbstractBaseService.copyString(string);
        this.MMXSWVersion_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SDISVersionReply sDISVersionReply = (SDISVersionReply)iterator.next();
            try {
                sDISVersionReply.updateMMXSWVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateMMXSKUVersion(String string) {
        this.updateMMXSKUVersion(string, true);
    }

    public void updateMMXSKUVersion(String string, boolean bl) {
        this.MMXSKUVersion = SDISVersionAbstractBaseService.copyString(string);
        this.MMXSKUVersion_valid = bl;
        List list = this.baseService.getNotifications(7);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SDISVersionReply sDISVersionReply = (SDISVersionReply)iterator.next();
            try {
                sDISVersionReply.updateMMXSKUVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateMUDetailedVersion(String string) {
        this.updateMUDetailedVersion(string, true);
    }

    public void updateMUDetailedVersion(String string, boolean bl) {
        this.MUDetailedVersion = SDISVersionAbstractBaseService.copyString(string);
        this.MUDetailedVersion_valid = bl;
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SDISVersionReply sDISVersionReply = (SDISVersionReply)iterator.next();
            try {
                sDISVersionReply.updateMUDetailedVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

