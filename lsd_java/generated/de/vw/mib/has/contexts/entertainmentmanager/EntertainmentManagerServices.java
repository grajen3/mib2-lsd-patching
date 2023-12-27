/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.entertainmentmanager;

import de.vw.mib.has.HASContextServices;
import generated.de.vw.mib.has.containers.MediaSourceContainer;
import generated.de.vw.mib.has.containers.RadioBandContainer;

public interface EntertainmentManagerServices
extends HASContextServices {
    default public void activateRadioBand(int n, RadioBandContainer radioBandContainer) {
    }

    default public void activateMediaSource(int n, MediaSourceContainer mediaSourceContainer) {
    }

    default public void activateAppConnectAudio(int n) {
    }

    default public void getEntertainmentContext() {
    }
}

