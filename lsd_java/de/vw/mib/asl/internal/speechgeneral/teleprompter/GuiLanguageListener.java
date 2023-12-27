/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.teleprompter;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.NvListener;
import de.vw.mib.threads.AsyncServiceFactory;

public class GuiLanguageListener
implements NvListener {
    private final ConfigurationManager configManager;
    private final ASLPropertyManager aslPropertyManager;
    private final AsyncServiceFactory asyncAslFactory;
    static /* synthetic */ Class class$de$vw$mib$configuration$NvListener;

    public GuiLanguageListener(ConfigurationManager configurationManager, ASLPropertyManager aSLPropertyManager, AsyncServiceFactory asyncServiceFactory) {
        this.configManager = configurationManager;
        this.aslPropertyManager = aSLPropertyManager;
        this.asyncAslFactory = asyncServiceFactory;
    }

    public void start() {
        this.updateGuiLanguageModelValue();
        NvListener nvListener = (NvListener)this.asyncAslFactory.create(this, new Class[]{class$de$vw$mib$configuration$NvListener == null ? (class$de$vw$mib$configuration$NvListener = GuiLanguageListener.class$("de.vw.mib.configuration.NvListener")) : class$de$vw$mib$configuration$NvListener});
        this.configManager.addNvListener(nvListener, 2);
    }

    @Override
    public void notifyNvListener(int n) {
        this.updateGuiLanguageModelValue();
    }

    private void updateGuiLanguageModelValue() {
        String string = this.configManager.getCurrentGuiLanguage();
        this.aslPropertyManager.valueChangedString(368783360, string);
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

