/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.globalsetupwizard.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map$Entry;

class GlobalSetupWizardDescriptorSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardDescriptorSerializer;

    GlobalSetupWizardDescriptorSerializer(PersistableSerializerFactory persistableSerializerFactory) {
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
            return this.serializeCommonData((GlobalSetupWizardDescriptor)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeUserSpecificData((GlobalSetupWizardDescriptor)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(GlobalSetupWizardDescriptor globalSetupWizardDescriptor) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(GlobalSetupWizardDescriptor globalSetupWizardDescriptor) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(globalSetupWizardDescriptor.getMapWizardPages().size());
        Iterator iterator = globalSetupWizardDescriptor.getMapWizardPages().entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            long l = (Long)map$Entry.getKey();
            boolean bl = (Boolean)map$Entry.getValue();
            dataOutputStream.writeLong(l);
            dataOutputStream.writeBoolean(bl);
        }
        dataOutputStream.writeBoolean(globalSetupWizardDescriptor.isDontShowAgain());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardDescriptorSerializer == null ? (class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardDescriptorSerializer = GlobalSetupWizardDescriptorSerializer.class$("de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptorSerializer")) : class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardDescriptorSerializer).desiredAssertionStatus();
    }
}

