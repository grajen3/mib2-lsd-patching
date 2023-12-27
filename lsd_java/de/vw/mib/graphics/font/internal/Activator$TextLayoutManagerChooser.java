/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager;
import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.LscController;
import de.vw.mib.lsctng.LscListener;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

final class Activator$TextLayoutManagerChooser
implements LscListener,
ServiceListener {
    private final CachingTextLayoutManager textLayoutManager;
    private final BundleContext bundleContext;
    private LscController lscController;

    public Activator$TextLayoutManagerChooser(BundleContext bundleContext, CachingTextLayoutManager cachingTextLayoutManager) {
        this.bundleContext = bundleContext;
        this.textLayoutManager = cachingTextLayoutManager;
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        switch (serviceEvent.getType()) {
            case 1: {
                Object object = this.bundleContext.getService(serviceEvent.getServiceReference());
                if (!(object instanceof LscController)) break;
                this.registerLscListener((LscController)object);
                this.bundleContext.removeServiceListener(this);
                break;
            }
        }
    }

    @Override
    public void onNewLanguage(LanguageChanger languageChanger, int n, String string) {
        this.textLayoutManager.setNewLanguage();
        languageChanger.setChangeResult(n, true, string);
    }

    @Override
    public void onNewSkin(SkinChanger skinChanger, int n, int n2) {
        throw new UnsupportedOperationException("TextLayoutManagerChooser only listens for language changes");
    }

    @Override
    public void onNewSkinmode(SkinmodeChanger skinmodeChanger, int n, int n2) {
        throw new UnsupportedOperationException("TextLayoutManagerChooser only listens for language changes");
    }

    public void registerLscListener(LscController lscController) {
        this.lscController = lscController;
        this.lscController.addListener(this, 3, "NO_LANGUAGE", -2, -2);
    }
}

