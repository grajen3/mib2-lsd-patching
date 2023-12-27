/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.popup;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.internal.globalgoodbye.popup.InformationContainer;
import de.vw.mib.hmi.utils.Preconditions;

public class DatapoolUpdater {
    private final ASLPropertyManager aslPropertyManager;
    static /* synthetic */ Class class$de$vw$mib$asl$ASLPropertyManager;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$globalgoodbye$popup$InformationContainer;

    public DatapoolUpdater(ASLPropertyManager aSLPropertyManager) {
        Preconditions.checkNotNull(aSLPropertyManager, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$asl$ASLPropertyManager == null ? (class$de$vw$mib$asl$ASLPropertyManager = DatapoolUpdater.class$("de.vw.mib.asl.ASLPropertyManager")) : class$de$vw$mib$asl$ASLPropertyManager).getName()).append(" must not be null!").toString());
        this.aslPropertyManager = aSLPropertyManager;
    }

    void update(InformationContainer informationContainer) {
        Preconditions.checkNotNull(informationContainer, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$asl$internal$globalgoodbye$popup$InformationContainer == null ? (class$de$vw$mib$asl$internal$globalgoodbye$popup$InformationContainer = DatapoolUpdater.class$("de.vw.mib.asl.internal.globalgoodbye.popup.InformationContainer")) : class$de$vw$mib$asl$internal$globalgoodbye$popup$InformationContainer).getName()).append(" must not be null!").toString());
        this.aslPropertyManager.valueChangedBoolean(-768903424, informationContainer.isShowOnlineSection());
        this.aslPropertyManager.valueChangedString(-752126208, informationContainer.getNameOfEnrolledUser());
        this.aslPropertyManager.valueChangedBoolean(-785680640, informationContainer.isShowPhoneSection());
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

