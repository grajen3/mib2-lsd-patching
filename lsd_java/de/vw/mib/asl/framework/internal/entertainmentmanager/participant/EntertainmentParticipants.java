/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.participant;

import de.vw.mib.asl.framework.api.entertainmentmanager.participant.EntertainmentManagerParticipant;
import de.vw.mib.asl.framework.api.entertainmentmanager.participant.EntertainmentManagerParticipantService;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentController;
import de.vw.mib.asl.framework.internal.entertainmentmanager.LegacyActivation;
import de.vw.mib.asl.framework.internal.entertainmentmanager.TargetRegistry;
import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbsoluteActivation;
import de.vw.mib.asl.framework.internal.entertainmentmanager.core.EntertainmentCore;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.Logger;

public class EntertainmentParticipants
implements EntertainmentManagerParticipantService {
    private final Logger logger;
    private final Services services;
    private final EntertainmentCore core;
    private EntertainmentController controller;
    private final IntObjectOptHashMap participants = new IntObjectOptHashMap();

    public EntertainmentParticipants(Logger logger, Services services, EntertainmentCore entertainmentCore) {
        this.logger = logger;
        this.services = services;
        if (this.services == null) {
            throw new NullPointerException();
        }
        this.core = entertainmentCore;
    }

    public void setController(EntertainmentController entertainmentController) {
        this.controller = entertainmentController;
    }

    @Override
    public void registerParticipant(int n, EntertainmentManagerParticipant entertainmentManagerParticipant) {
        if (entertainmentManagerParticipant == null) {
            throw new NullPointerException();
        }
        if (this.participants.containsKey(n)) {
            if (this.participants.get(n) != entertainmentManagerParticipant) {
                this.logger.warn(16).append("EntertainmentManagerParticipantService.registerParticipant(contextId=").append(n).append("): overwriting participant due to duplicate registration.").attachThrowable(new IllegalStateException()).log();
            } else {
                this.logger.warn(16).append("EntertainmentManagerParticipantService.registerParticipant(contextId=").append(n).append("): duplicate registration with the same ('==') participant").log();
            }
        }
        this.participants.put(n, entertainmentManagerParticipant);
    }

    @Override
    public void unregisterParticipant(int n) {
        Object object;
        if (this.logger.isTraceEnabled(16)) {
            this.logger.trace(16).append("EntertainmentManagerParticipantService.unregisterParticipant( contextId=").append(n).append(" )").log();
        }
        if ((object = this.participants.remove(n)) == null) {
            this.logger.warn(16).append("EntertainmentManagerParticipantService.unregisterParticipant( contextId=").append(n).append(" ): context not registered at this time.").log();
        }
    }

    @Override
    public boolean isRegistered(int n) {
        return this.participants.containsKey(n) || this.controller.getTargetRegistry().isContextRegistered(n);
    }

    @Override
    public void requestContext(int n) {
        EntertainmentManagerParticipant entertainmentManagerParticipant = (EntertainmentManagerParticipant)this.participants.get(n);
        if (entertainmentManagerParticipant != null) {
            entertainmentManagerParticipant.doRequest(this.core);
        } else {
            TargetRegistry targetRegistry = this.controller.getTargetRegistry();
            if (targetRegistry.isContextRegistered(n)) {
                AbsoluteActivation absoluteActivation = this.controller.getContextLastmode(n);
                targetRegistry.get(n).changeView();
                this.core.request(new LegacyActivation(this.controller, targetRegistry.getTargetIdForContext(n), absoluteActivation));
            } else {
                this.logger.warn(16).append("EntertainmentManagerParticipantService.requestContext( ").append(n).append(" ): Context neither registered as EntertainmentManagerParticipant nor via REGISTER_TARGET").log();
            }
        }
    }
}

