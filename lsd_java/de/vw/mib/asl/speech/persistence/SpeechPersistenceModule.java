/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.speech.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.speech.persistence.SpeechHandlerFactory;
import de.vw.mib.asl.speech.persistence.SpeechPersistableFactory;
import de.vw.mib.asl.speech.persistence.SpeechSerializerFactory;
import de.vw.mib.log4mib.Logger;

class SpeechPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    SpeechPersistenceModule(Logger logger) {
        this.handlerFactory = new SpeechHandlerFactory(logger, this);
        this.persistableFactory = new SpeechPersistableFactory(this);
        this.serializerFactory = new SpeechSerializerFactory();
    }

    @Override
    public String getName() {
        return "Speech";
    }

    @Override
    public long getVersion() {
        return 0L;
    }

    @Override
    public HandlerFactory getHandlerFactory() {
        return this.handlerFactory;
    }

    @Override
    public PersistableFactory getPersistableFactory() {
        return this.persistableFactory;
    }

    @Override
    public PersistableSerializerFactory getSerializerFactory() {
        return this.serializerFactory;
    }

    @Override
    public boolean isUserSpecific() {
        return true;
    }

    @Override
    public byte[] getDeclaration() {
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 4, 0, 0, 0, 7, 0, 0, 0, 2, 1, 6, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 3, 0, 0, 0, 0, 4, 0, 0, 0, 0, 5, 0, 0, 0, 0, 6};
    }
}

