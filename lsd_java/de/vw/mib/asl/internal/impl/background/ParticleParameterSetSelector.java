/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.background;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.background.services.ParticleBackgroundService;
import de.vw.mib.asl.api.background.services.ParticleSubStates;
import de.vw.mib.asl.internal.background.BackgroundServices;
import de.vw.mib.asl.internal.impl.background.ParticleParameterSetSelector$1;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.desktop.DesktopInformationReceiver;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.Iterator;
import java.util.List;

public class ParticleParameterSetSelector
implements ParticleBackgroundService {
    static final String DEFAULT_PARTICLE_PARAMETER_SET;
    private final ASLPropertyManager propertyManager;
    private final ConfigurationManagerDiag configurationManager;
    private String currentParameterSet;
    private String currentView;
    private int currentSubState = ParticleSubStates.DEFAULT;
    static /* synthetic */ Class class$de$vw$mib$desktop$DesktopInformationReceiver;

    public ParticleParameterSetSelector(BackgroundServices backgroundServices) {
        this.propertyManager = backgroundServices.getAslPropertyManager();
        this.configurationManager = backgroundServices.getConfigurationManager();
        AsyncServiceFactory asyncServiceFactory = backgroundServices.getAsyncServiceFactory();
        DesktopInformationReceiver desktopInformationReceiver = this.createDesktopInformationReceiver(asyncServiceFactory);
        backgroundServices.getBundleContext().registerService((class$de$vw$mib$desktop$DesktopInformationReceiver == null ? (class$de$vw$mib$desktop$DesktopInformationReceiver = ParticleParameterSetSelector.class$("de.vw.mib.desktop.DesktopInformationReceiver")) : class$de$vw$mib$desktop$DesktopInformationReceiver).getName(), (Object)desktopInformationReceiver, null);
        this.updateParameterSet("Default");
    }

    @Override
    public void applySubState(int n) {
        this.currentSubState = n;
        this.applyParameterSet(this.currentView, n);
    }

    void updateParticleParameters(List list) {
        boolean bl = false;
        Iterator iterator = list.iterator();
        while (iterator.hasNext() && !bl) {
            String string = (String)iterator.next();
            bl = this.applyParameterSet(string, this.currentSubState);
        }
        if (!bl) {
            this.updateParameterSet("Default");
        }
    }

    private boolean applyParameterSet(String string, int n) {
        String string2 = this.configurationManager.getParticleParameterSetName(string, n);
        if (string2 != null) {
            this.updateParameterSet(string2);
            this.currentView = string;
            return true;
        }
        if (n != ParticleSubStates.DEFAULT) {
            return this.applyParameterSet(string, ParticleSubStates.DEFAULT);
        }
        return false;
    }

    private void updateParameterSet(String string) {
        if (!string.equals(this.currentParameterSet)) {
            this.propertyManager.valueChangedString(1910392576, string);
            this.currentParameterSet = string;
        }
    }

    private DesktopInformationReceiver createDesktopInformationReceiver(AsyncServiceFactory asyncServiceFactory) {
        ParticleParameterSetSelector$1 particleParameterSetSelector$1 = new ParticleParameterSetSelector$1(this);
        return (DesktopInformationReceiver)asyncServiceFactory.create(particleParameterSetSelector$1);
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

