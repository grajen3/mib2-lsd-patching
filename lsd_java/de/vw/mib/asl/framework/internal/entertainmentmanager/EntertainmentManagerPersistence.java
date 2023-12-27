/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentManagerPersistenceServiceImpl;
import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentPersistence;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentManagerPersistence$1;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentManagerPersistence$2;
import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbsoluteActivation;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntMap$Entry;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import java.util.Iterator;

public final class EntertainmentManagerPersistence
extends AbstractSharedPersistable
implements Loggable {
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    private EntertainmentPersistence entertainmentPersistence;
    private AbsoluteActivation active;
    private IntIntMap contextLastmodes = new IntIntOptHashMap(5);
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService;

    public AbsoluteActivation getActive() {
        return this.active;
    }

    public void setActive(AbsoluteActivation absoluteActivation) {
        if (!absoluteActivation.isValid()) {
            throw new IllegalArgumentException("The active mode/activation must not be invalid!");
        }
        this.markDirty(true);
        this.active = absoluteActivation;
        this.setContext(absoluteActivation.getContext());
    }

    private void setContext(int n) {
        this.entertainmentPersistence.setContext(n);
    }

    public AbsoluteActivation getContextLastmode(int n) {
        int n2 = this.contextLastmodes.get(n);
        AbsoluteActivation absoluteActivation = new AbsoluteActivation(n, n2);
        return absoluteActivation;
    }

    public void setContextLastmode(AbsoluteActivation absoluteActivation) {
        this.contextLastmodes.put(absoluteActivation.getContext(), absoluteActivation.getSubcontext());
    }

    private void readContextLastmodes(PersistenceInputStream persistenceInputStream) {
        int n = persistenceInputStream.readInt();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = persistenceInputStream.readInt();
            int n3 = persistenceInputStream.readInt();
            this.contextLastmodes.put(n2, n3);
        }
    }

    private void writeContextLastmodes(PersistenceOutputStream persistenceOutputStream) {
        this.contextLastmodes.entrySet().iterator();
        persistenceOutputStream.writeInt(this.contextLastmodes.size());
        Iterator iterator = this.contextLastmodes.entrySet().iterator();
        while (iterator.hasNext()) {
            IntIntMap$Entry intIntMap$Entry = (IntIntMap$Entry)iterator.next();
            persistenceOutputStream.writeInt(intIntMap$Entry.getKey());
            persistenceOutputStream.writeInt(intIntMap$Entry.getValue());
        }
    }

    public EntertainmentManagerPersistence() {
        super(5011, 0);
        this.entertainmentPersistence = EntertainmentManagerPersistenceServiceImpl.getInstance().loadEntertainmentPersistence();
        this.clear();
        EntertainmentManagerPersistenceServiceImpl.getInstance().addProfileChangeListener(new EntertainmentManagerPersistence$1(this));
        ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi().addGlobalProfileChangeListener(new EntertainmentManagerPersistence$2(this), 10);
    }

    @Override
    public void clear() {
        if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16).append("EntertainmentManagerPersistence.clear()").log();
        }
        this.active = AbsoluteActivation.LAST_RESORT;
        this.contextLastmodes.clear();
    }

    private AbsoluteActivation readActivation(PersistenceInputStream persistenceInputStream) {
        int n = persistenceInputStream.readInt();
        int n2 = persistenceInputStream.readInt();
        if (n != -1) {
            return new AbsoluteActivation(n, n2);
        }
        return AbsoluteActivation.INVALID;
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16).append("EntertainmentManagerPersistence.fromStreamInternal()").log();
        }
        if (s == 10) {
            this.active = this.readActivation(persistenceInputStream);
            this.readContextLastmodes(persistenceInputStream);
        } else {
            this.clear();
        }
        ServiceManager.logger2.info(16).append("fromStreamInternal\\").append(this).log();
    }

    private void writeActivation(PersistenceOutputStream persistenceOutputStream, AbsoluteActivation absoluteActivation) {
        persistenceOutputStream.writeInt(absoluteActivation.getContext());
        persistenceOutputStream.writeInt(absoluteActivation.getSubcontext());
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16).append("EntertainmentManagerPersistence.toStreamInternal() ").append(this).log();
        }
        this.writeActivation(persistenceOutputStream, this.active);
        this.writeContextLastmodes(persistenceOutputStream);
        ServiceManager.logger2.info(16).append("toStreamInternal\\").append(this).log();
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public short[] getSupportedVersions() {
        return SUPPORTED_VERSIONS;
    }

    @Override
    public short getVersion() {
        return 10;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("EntertainmentManagerPersistence [active=").append(this.active).append(']');
        logMessage.append(" contextLastmodes: ");
        Iterator iterator = this.contextLastmodes.entrySet().iterator();
        while (iterator.hasNext()) {
            IntIntMap$Entry intIntMap$Entry = (IntIntMap$Entry)iterator.next();
            logMessage.append("(").append(intIntMap$Entry.getKey()).append(",").append(intIntMap$Entry.getValue()).append(")");
        }
    }

    public int loadContext() {
        this.entertainmentPersistence = EntertainmentManagerPersistenceServiceImpl.getInstance().loadEntertainmentPersistence();
        int n = this.entertainmentPersistence.getContext();
        this.setActive(this.getContextLastmode(n));
        ServiceManager.logger2.info(16).append("loadContext\\").append(this).log();
        return n;
    }

    static /* synthetic */ EntertainmentPersistence access$000(EntertainmentManagerPersistence entertainmentManagerPersistence) {
        return entertainmentManagerPersistence.entertainmentPersistence;
    }

    static /* synthetic */ EntertainmentPersistence access$002(EntertainmentManagerPersistence entertainmentManagerPersistence, EntertainmentPersistence entertainmentPersistence) {
        entertainmentManagerPersistence.entertainmentPersistence = entertainmentPersistence;
        return entertainmentManagerPersistence.entertainmentPersistence;
    }

    static /* synthetic */ void access$100(EntertainmentManagerPersistence entertainmentManagerPersistence, int n) {
        entertainmentManagerPersistence.setContext(n);
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
        SUPPORTED_VERSIONS = NO_SUPPORTED_VERSION;
    }
}

