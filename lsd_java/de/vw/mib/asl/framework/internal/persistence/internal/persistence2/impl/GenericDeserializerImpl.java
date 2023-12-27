/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.GenericDeserializer;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.EntryCollectionHandler;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.GenericDeserializerImpl$NullOutputStream;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.GenericDeserializerImpl$TypeParameter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GenericDeserializerImpl
implements GenericDeserializer {
    private static final byte TYPE_PRIMITIVE_BOOLEAN;
    private static final byte TYPE_PRIMITIVE_BYTE;
    private static final byte TYPE_PRIMITIVE_CHAR;
    private static final byte TYPE_PRIMITIVE_SHORT;
    private static final byte TYPE_PRIMITIVE_INTEGER;
    private static final byte TYPE_PRIMITIVE_LONG;
    private static final byte TYPE_PRIMITIVE_FLOAT;
    private static final byte TYPE_PRIMITIVE_DOUBLE;
    private static final byte TYPE_PRIMITIVE_STRING;
    private static final byte TYPE_CONTAINER_LIST;
    private static final byte TYPE_CONTAINER_SET;
    private static final byte TYPE_CONTAINER_MAP;
    private static final byte TYPE_PERSITABLE;
    private final PersistenceLogger logger;
    private DataInputStream declarationStream;
    private DataInputStream dataStream;
    private PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$persistence$internal$persistence2$impl$GenericDeserializerImpl;

    public GenericDeserializerImpl(PersistenceLogger persistenceLogger) {
        if (!$assertionsDisabled && persistenceLogger == null) {
            throw new AssertionError();
        }
        this.logger = persistenceLogger;
    }

    @Override
    public Persistable deserialize(byte[] byArray, byte[] byArray2, Persistable persistable, PersistenceModule persistenceModule, boolean bl) {
        if (!$assertionsDisabled && byArray == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byArray2 == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && persistable == null) {
            throw new AssertionError();
        }
        this.declarationStream = new DataInputStream(new ByteArrayInputStream(byArray));
        this.dataStream = new DataInputStream(new ByteArrayInputStream(byArray2));
        this.module = persistenceModule;
        this.prepareDeclarationStream(this.declarationStream, persistenceModule);
        this.checkSerializerVersion(this.dataStream);
        return this.doDeserialize(persistable, bl);
    }

    private Persistable doDeserialize(Persistable persistable, boolean bl) {
        int n = persistable.getId();
        DataInputStream dataInputStream = this.findPersistableDeclaration(this.declarationStream, n, bl);
        PersistenceDataHandler persistenceDataHandler = bl ? this.module.getHandlerFactory().createUserHandler(persistable) : this.module.getHandlerFactory().createCommonHandler(persistable);
        this.deserializeFields(persistenceDataHandler, dataInputStream);
        return persistable;
    }

    private void deserializeFields(PersistenceDataHandler persistenceDataHandler, DataInputStream dataInputStream) {
        try {
            int n = dataInputStream.readByte();
            for (int i2 = 0; i2 < n; ++i2) {
                byte by = dataInputStream.readByte();
                this.deserializeField(by, dataInputStream, persistenceDataHandler);
            }
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while reading from data stream or declaration stream: Data is corrupted.");
        }
        persistenceDataHandler.finish();
    }

    private void deserializeField(byte by, DataInputStream dataInputStream, PersistenceDataHandler persistenceDataHandler) {
        if (this.checkIsCollectionType(by)) {
            this.deserializeContainer(by, dataInputStream, persistenceDataHandler);
        } else if (this.checkIsClassType(by)) {
            this.dserializeObject(by, dataInputStream, persistenceDataHandler);
        } else {
            this.deserializePrimitive(by, dataInputStream, persistenceDataHandler);
        }
    }

    private void deserializePrimitive(byte by, DataInputStream dataInputStream, PersistenceDataHandler persistenceDataHandler) {
        int n = dataInputStream.readInt();
        this.deserializePrimitiveForField(by, persistenceDataHandler, n);
    }

    private void deserializePrimitiveForField(byte by, PersistenceDataHandler persistenceDataHandler, int n) {
        switch (by) {
            case 0: {
                persistenceDataHandler.handle(n, this.dataStream.readBoolean());
                break;
            }
            case 1: {
                persistenceDataHandler.handle(n, this.dataStream.readByte());
                break;
            }
            case 2: {
                persistenceDataHandler.handle(n, this.dataStream.readChar());
                break;
            }
            case 3: {
                persistenceDataHandler.handle(n, this.dataStream.readShort());
                break;
            }
            case 4: {
                persistenceDataHandler.handle(n, this.dataStream.readInt());
                break;
            }
            case 5: {
                persistenceDataHandler.handle(n, this.dataStream.readLong());
                break;
            }
            case 6: {
                persistenceDataHandler.handle(n, this.dataStream.readFloat());
                break;
            }
            case 7: {
                persistenceDataHandler.handle(n, this.dataStream.readDouble());
                break;
            }
            case 8: {
                String string = null;
                boolean bl = this.dataStream.readBoolean();
                if (!bl) {
                    int n2 = this.dataStream.readInt();
                    byte[] byArray = new byte[n2];
                    this.dataStream.readFully(byArray);
                    string = new String(byArray);
                }
                persistenceDataHandler.handle(n, string);
                break;
            }
            default: {
                throw new PersistenceException(new StringBuffer().append("The primitive type ").append(by).append(" is no valid. The declaration stream seems to be corrupted.").toString());
            }
        }
    }

    private void dserializeObject(byte by, DataInputStream dataInputStream, PersistenceDataHandler persistenceDataHandler) {
        int n = dataInputStream.readInt();
        int n2 = dataInputStream.readInt();
        this.deserializeObjectForField(persistenceDataHandler, n, n2);
    }

    private void deserializeObjectForField(PersistenceDataHandler persistenceDataHandler, int n, int n2) {
        Persistable persistable = null;
        boolean bl = this.dataStream.readBoolean();
        if (!bl) {
            persistable = this.module.getPersistableFactory().createPersistable(n);
            boolean bl2 = false;
            persistable = this.doDeserialize(persistable, bl2);
        }
        persistenceDataHandler.handle(n2, persistable);
    }

    private void deserializeContainer(byte by, DataInputStream dataInputStream, PersistenceDataHandler persistenceDataHandler) {
        switch (by) {
            case 20: 
            case 21: {
                this.deserializeCollection(by, dataInputStream, persistenceDataHandler);
                break;
            }
            case 22: {
                this.deserializeMap(by, dataInputStream, persistenceDataHandler);
                break;
            }
            default: {
                throw new PersistenceException(new StringBuffer().append("Unsupported container type: ").append(by).toString());
            }
        }
    }

    private void deserializeMap(byte by, DataInputStream dataInputStream, PersistenceDataHandler persistenceDataHandler) {
        GenericDeserializerImpl$TypeParameter typeParameter = this.readTypeParameter(dataInputStream);
        GenericDeserializerImpl$TypeParameter typeParameter2 = this.readTypeParameter(dataInputStream);
        int n = dataInputStream.readInt();
        int n2 = this.dataStream.readInt();
        if (n2 != 0) {
            EntryCollectionHandler entryCollectionHandler = new EntryCollectionHandler(n, persistenceDataHandler);
            for (int i2 = 0; i2 < n2; ++i2) {
                this.deserializeContainerElement(entryCollectionHandler, typeParameter, n);
                this.deserializeContainerElement(entryCollectionHandler, typeParameter2, n);
            }
        } else {
            persistenceDataHandler.handleEmptyCollection(n);
        }
    }

    private void deserializeCollection(byte by, DataInputStream dataInputStream, PersistenceDataHandler persistenceDataHandler) {
        GenericDeserializerImpl$TypeParameter typeParameter = this.readTypeParameter(dataInputStream);
        int n = dataInputStream.readInt();
        int n2 = this.dataStream.readInt();
        if (n2 != 0) {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.deserializeContainerElement(persistenceDataHandler, typeParameter, n);
            }
        } else {
            persistenceDataHandler.handleEmptyCollection(n);
        }
    }

    private boolean checkIsClassType(byte by) {
        return by == 30;
    }

    private boolean checkIsCollectionType(byte by) {
        return by == 20 || by == 21 || by == 22;
    }

    private DataInputStream findPersistableDeclaration(DataInputStream dataInputStream, int n, boolean bl) {
        this.skipToPersitable(dataInputStream, n, bl);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.extractCurrentDeclaration(dataInputStream, new DataOutputStream(byteArrayOutputStream));
        }
        catch (IOException iOException) {
            throw new PersistenceException(new StringBuffer().append("Could not extract declaration for persistable ").append(n).append(", declaration is corrupted.").toString());
        }
        return new DataInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    private void prepareDeclarationStream(DataInputStream dataInputStream, PersistenceModule persistenceModule) {
        this.checkSerializerVersion(dataInputStream);
        this.checkModuleVersion(dataInputStream, persistenceModule);
        this.markStream(dataInputStream);
    }

    private void checkSerializerVersion(DataInputStream dataInputStream) {
        try {
            short s = dataInputStream.readShort();
            if (s != 1) {
                throw new PersistenceException(new StringBuffer().append("Unsupported persistable version: ").append(s).toString());
            }
        }
        catch (IOException iOException) {
            throw new PersistenceException("Could not read version from data stream", iOException);
        }
    }

    private GenericDeserializerImpl$TypeParameter readTypeParameter(DataInputStream dataInputStream) {
        GenericDeserializerImpl$TypeParameter genericDeserializerImpl$TypeParameter = new GenericDeserializerImpl$TypeParameter(this);
        genericDeserializerImpl$TypeParameter.setType(dataInputStream.readByte());
        if (this.checkIsClassType(genericDeserializerImpl$TypeParameter.getType())) {
            genericDeserializerImpl$TypeParameter.setPersistableId(dataInputStream.readInt());
        }
        return genericDeserializerImpl$TypeParameter;
    }

    private void checkModuleVersion(DataInputStream dataInputStream, PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && dataInputStream == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        try {
            long l = dataInputStream.readLong();
            long l2 = persistenceModule.getVersion();
            if (l == l2) {
                this.logger.trace(new StringBuffer().append("Declaration version and module version do match (version ").append(l2).append("), expecting no migration in persistence for module ").append(persistenceModule.getName()).toString());
            } else {
                this.logger.trace(new StringBuffer().append("Declaration version (version ").append(l).append(") and module version (version ").append(l2).append(") do NOT match, expecting migration in persistnce module ").append(l2).append(persistenceModule.getName()).toString());
            }
        }
        catch (IOException iOException) {
            throw new PersistenceException("Could not read declaration version from stream", iOException);
        }
    }

    private void markStream(InputStream inputStream) {
        int n = -129;
        inputStream.mark(n);
    }

    private void skipToPersitable(DataInputStream dataInputStream, int n, boolean bl) {
        DataOutputStream dataOutputStream = new DataOutputStream(GenericDeserializerImpl$NullOutputStream.NULL_OUTPUT_STREAM);
        try {
            dataInputStream.reset();
            boolean bl2 = false;
            while (!bl2 && dataInputStream.available() > 0) {
                int n2 = dataInputStream.readInt();
                boolean bl3 = dataInputStream.readBoolean();
                if (n2 == n && bl3 == bl) {
                    bl2 = true;
                    continue;
                }
                this.extractCurrentDeclaration(dataInputStream, dataOutputStream);
            }
            if (!bl2) {
                throw new PersistenceException(new StringBuffer().append("Could not find declaration for persistable ").append(n).toString());
            }
        }
        catch (IOException iOException) {
            throw new PersistenceException("Could not skip persistable: Declaration is corrupted", iOException);
        }
    }

    private void extractCurrentDeclaration(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        int n = dataInputStream.readByte();
        dataOutputStream.writeByte(n);
        for (int i2 = 0; i2 < n; ++i2) {
            this.extractTypeDeclaration(dataInputStream, dataOutputStream);
        }
    }

    private void extractTypeDeclaration(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        int n;
        byte by = dataInputStream.readByte();
        dataOutputStream.writeByte(by);
        if (this.checkIsCollectionType(by)) {
            this.extractTypeParameterDeclaration(dataInputStream, dataOutputStream);
            if (by == 22) {
                this.extractTypeParameterDeclaration(dataInputStream, dataOutputStream);
            }
        } else if (this.checkIsClassType(by)) {
            n = dataInputStream.readInt();
            dataOutputStream.writeInt(n);
        }
        n = dataInputStream.readInt();
        dataOutputStream.writeInt(n);
    }

    private void extractTypeParameterDeclaration(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        byte by = dataInputStream.readByte();
        dataOutputStream.writeByte(by);
        if (this.checkIsClassType(by)) {
            int n = dataInputStream.readInt();
            dataOutputStream.writeInt(n);
        }
    }

    private void deserializeContainerElement(PersistenceDataHandler persistenceDataHandler, GenericDeserializerImpl$TypeParameter genericDeserializerImpl$TypeParameter, int n) {
        if (this.checkIsClassType(genericDeserializerImpl$TypeParameter.getType())) {
            this.deserializeObjectForField(persistenceDataHandler, genericDeserializerImpl$TypeParameter.getPersistableId(), n);
        } else {
            this.deserializePrimitiveForField(genericDeserializerImpl$TypeParameter.getType(), persistenceDataHandler, n);
        }
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
        $assertionsDisabled = !(class$de$vw$mib$asl$framework$internal$persistence$internal$persistence2$impl$GenericDeserializerImpl == null ? (class$de$vw$mib$asl$framework$internal$persistence$internal$persistence2$impl$GenericDeserializerImpl = GenericDeserializerImpl.class$("de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.GenericDeserializerImpl")) : class$de$vw$mib$asl$framework$internal$persistence$internal$persistence2$impl$GenericDeserializerImpl).desiredAssertionStatus();
    }
}

