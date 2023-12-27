/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.api.impl;

import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.api.phone.callback.ContactlistUpdates;
import de.vw.mib.asl.api.phone.callback.PhoneConnectedUpdate;
import de.vw.mib.asl.api.phone.callback.SpecialNumbersUpdate;
import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.calls.CallService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.api.model.SpecialNumbersUpdater;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.threads.AsyncServiceFactory;

public final class PhoneServiceImpl
implements PhoneService {
    private IntOptHashSet requiredTargets = new IntOptHashSet(3);
    private CallService callService;
    private final SpecialNumbersUpdater specialNumbersUpdater = new SpecialNumbersUpdater();
    private static PhoneServiceImpl instance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$PhoneService;

    private PhoneServiceImpl() {
        this.requiredTargets.add(5261);
        this.requiredTargets.add(5251);
        this.requiredTargets.add(1922634752);
    }

    @Override
    public int numberSpeciality(String string) {
        ASLPhoneData aSLPhoneData = ASLPhoneData.getInstance();
        if (string.equals(aSLPhoneData.mailboxNumber)) {
            return 2;
        }
        if (aSLPhoneData.emergencyNumbers != null && string.equals(aSLPhoneData.emergencyNumbers.mainEmergencyNumber)) {
            return 1;
        }
        if (aSLPhoneData.serviceNumbers != null && (string.equals(aSLPhoneData.serviceNumbers.breakdownNumber) || string.equals(aSLPhoneData.serviceNumbers.breakdownNumberRoaming))) {
            return 4;
        }
        if (aSLPhoneData.serviceNumbers != null && string.equals(aSLPhoneData.serviceNumbers.infonumber) || string.equals(aSLPhoneData.serviceNumbers.infonumberRoaming)) {
            return 3;
        }
        return 0;
    }

    @Override
    public String getSpecialNumber(int n) {
        ASLPhoneData aSLPhoneData = ASLPhoneData.getInstance();
        switch (n) {
            case 1: {
                if (aSLPhoneData.emergencyNumbers == null) {
                    return null;
                }
                return aSLPhoneData.emergencyNumbers.mainEmergencyNumber;
            }
            case 3: {
                if (aSLPhoneData.serviceNumbers == null) {
                    return null;
                }
                if (!aSLPhoneData.roaming) {
                    return aSLPhoneData.serviceNumbers.infonumber;
                }
                return aSLPhoneData.serviceNumbers.infonumberRoaming;
            }
            case 2: {
                return aSLPhoneData.mailboxNumber;
            }
            case 4: {
                if (aSLPhoneData.serviceNumbers == null) {
                    return null;
                }
                if (!aSLPhoneData.roaming) {
                    return aSLPhoneData.serviceNumbers.breakdownNumber;
                }
                return aSLPhoneData.serviceNumbers.breakdownNumberRoaming;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Special number constant ").append(n).append(" unknown.").toString());
    }

    @Override
    public void registerContactlistUpdates(ContactlistUpdates contactlistUpdates) {
        contactlistUpdates = (ContactlistUpdates)this.asyncServiceFactory().create(contactlistUpdates);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5261, 5261, -1585053440);
        eventGeneric.setObject(0, contactlistUpdates);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void registerPhoneConnectedUpdates(PhoneConnectedUpdate phoneConnectedUpdate) {
        phoneConnectedUpdate = (PhoneConnectedUpdate)this.asyncServiceFactory().create(phoneConnectedUpdate);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5251, 5251, -1551499008);
        eventGeneric.setObject(0, phoneConnectedUpdate);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    private AsyncServiceFactory asyncServiceFactory() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory();
    }

    public SpecialNumbersUpdater getSpecialNumbersUpdater() {
        return this.specialNumbersUpdater;
    }

    @Override
    public void registerSpecialNumberUpdate(SpecialNumbersUpdate specialNumbersUpdate) {
        specialNumbersUpdate = (SpecialNumbersUpdate)this.asyncServiceFactory().create(specialNumbersUpdate);
        this.specialNumbersUpdater.addListener(specialNumbersUpdate);
    }

    @Override
    public void dialNumber(String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1922634752, 1922634752, -430172864);
        eventGeneric.setLong(0, 0L);
        eventGeneric.setString(1, string);
        eventGeneric.setInt(2, 0);
        eventGeneric.setInt(3, -1);
        eventGeneric.setInt(4, -1);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void dialNumber(PhoneNumber phoneNumber) {
        this.callService.dialNumber(phoneNumber);
    }

    public static PhoneServiceImpl getInstance() {
        if (instance == null) {
            instance = new PhoneServiceImpl();
        }
        return instance;
    }

    public void callServiceReady(CallService callService) {
        this.callService = callService;
        this.targetReady(1922634752);
    }

    public void targetReady(int n) {
        if (this.requiredTargets != null) {
            this.requiredTargets.remove(n);
            if (this.requiredTargets.isEmpty()) {
                ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$phone$PhoneService == null ? (class$de$vw$mib$asl$api$phone$PhoneService = PhoneServiceImpl.class$("de.vw.mib.asl.api.phone.PhoneService")) : class$de$vw$mib$asl$api$phone$PhoneService, this);
                this.requiredTargets = null;
            }
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
}

