/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.vicsetc.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.vicsetc.persistence.VicsEtc;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class VicsEtcSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$vicsetc$persistence$VicsEtcSerializer;

    VicsEtcSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 1;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((VicsEtc)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("VicsEtc does not conatain any user specific data");
    }

    private byte[] serializeCommonData(VicsEtc vicsEtc) {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(vicsEtc.getPopupDurationTime());
        dataOutputStream.writeBoolean(vicsEtc.getPrefectureString() == null);
        if (vicsEtc.getPrefectureString() != null) {
            byArray = vicsEtc.getPrefectureString().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeInt(vicsEtc.getStationSelectMode());
        dataOutputStream.writeBoolean(vicsEtc.isDataUploadChecked());
        dataOutputStream.writeBoolean(vicsEtc.isEtcCardNotInsertedChecked());
        dataOutputStream.writeBoolean(vicsEtc.isEtcCardReminderChecked());
        dataOutputStream.writeBoolean(vicsEtc.isPopupEtcDrivingSupportChecked());
        dataOutputStream.writeBoolean(vicsEtc.isPopupEtcTrafficAnnouncementChecked());
        dataOutputStream.writeBoolean(vicsEtc.isPopupEtcTrafficInformationChecked());
        dataOutputStream.writeBoolean(vicsEtc.isTollFeeAnnouncementChecked());
        dataOutputStream.writeBoolean(vicsEtc.isTollFeePopupChecked());
        dataOutputStream.writeBoolean(vicsEtc.isVicsEventNoticeMapChecked());
        dataOutputStream.writeBoolean(vicsEtc.isVicsBeaconMessagesChecked());
        dataOutputStream.writeBoolean(vicsEtc.isVicsBeaconGraphicsChecked());
        dataOutputStream.writeBoolean(vicsEtc.isShortcutMessageChecked());
        dataOutputStream.writeBoolean(vicsEtc.getShortcutMessageValue() == null);
        if (vicsEtc.getShortcutMessageValue() != null) {
            byArray = vicsEtc.getShortcutMessageValue().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        return byteArrayOutputStream.toByteArray();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$vicsetc$persistence$VicsEtcSerializer == null ? (class$de$vw$mib$asl$vicsetc$persistence$VicsEtcSerializer = VicsEtcSerializer.class$("de.vw.mib.asl.vicsetc.persistence.VicsEtcSerializer")) : class$de$vw$mib$asl$vicsetc$persistence$VicsEtcSerializer).desiredAssertionStatus();
    }
}

