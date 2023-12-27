/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound.has;

import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import generated.de.vw.mib.has.containers.BalanceFaderContainer;
import generated.de.vw.mib.has.containers.BalanceFaderRangesContainer;
import generated.de.vw.mib.has.containers.SoundVolumeContainer;
import generated.de.vw.mib.has.containers.SoundVolumeRangeContainer;
import generated.de.vw.mib.has.containers.SoundVolumeRangesContainer;
import generated.de.vw.mib.has.contexts.sound.SoundProperties;

public class SoundHASUpdater {
    private static SoundProperties hasProperties;
    private static SoundVolumeContainer soundVolumeContainer;
    private static SoundVolumeRangesContainer soundVolumeRangesContainer;
    private static SoundVolumeRangeContainer soundVolumeRangeContainerEntertainment;
    private static SoundVolumeRangeContainer soundVolumeRangeContainerTA;
    private static SoundVolumeRangeContainer soundVolumeRangeContainerNavigation;
    private static SoundVolumeRangeContainer soundVolumeRangeContainerPhone;
    private static SoundVolumeRangeContainer soundVolumeRangeContainerSDS;
    private static BalanceFaderContainer balanceFaderContainer;
    private static BalanceFaderRangesContainer balanceFaderRangesContainer;
    private static int entVolume;
    private static int taVolume;
    private static int navVolume;
    private static int phoneVolume;
    private static int sdsVolume;
    private static HASContext context;

    public static void setcontextAvailable(boolean bl) {
        context.setContextState(bl ? 2 : 3);
    }

    public static void setVolumeContainerVolume(int n, int n2) {
        if (soundVolumeContainer.getSource() == SoundHASUpdater.convertASLVolumeComponent2HAS(n)) {
            soundVolumeContainer.setVolume(n2);
            SoundHASUpdater.setComponentVolume(n, n2);
            hasProperties.updateSoundVolume(soundVolumeContainer);
        }
    }

    public static void setVolumeContainerSource(int n) {
        soundVolumeContainer.setSource(SoundHASUpdater.convertASLAudioComponent2HAS(n));
        soundVolumeContainer.setVolume(SoundHASUpdater.getComponentVolume(n));
        hasProperties.updateSoundVolume(soundVolumeContainer);
    }

    public static void setVolumeContainerEntertainmentMuted(boolean bl) {
        if (soundVolumeContainer.getEntertainmentMuted() != bl) {
            soundVolumeContainer.setEntertainmentMuted(bl);
            hasProperties.updateSoundVolume(soundVolumeContainer);
        }
    }

    private static int convertASLAudioComponent2HAS(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 1: {
                return 3;
            }
            case 2: {
                return 4;
            }
            case 4: {
                return 5;
            }
        }
        return 1;
    }

    private static int convertASLVolumeComponent2HAS(int n) {
        switch (n) {
            case 1493: {
                return 1;
            }
            case 1503: {
                return 2;
            }
            case 1496: {
                return 3;
            }
            case 1500: {
                return 4;
            }
            case 1502: {
                return 5;
            }
        }
        return 1;
    }

    private static void setComponentVolume(int n, int n2) {
        switch (n) {
            case 1493: {
                entVolume = n2;
                break;
            }
            case 1503: {
                taVolume = n2;
                break;
            }
            case 1496: {
                navVolume = n2;
                break;
            }
            case 1500: {
                phoneVolume = n2;
                break;
            }
            case 1502: {
                sdsVolume = n2;
                break;
            }
        }
    }

    private static int getComponentVolume(int n) {
        switch (n) {
            case 1493: {
                return entVolume;
            }
            case 1503: {
                return taVolume;
            }
            case 1496: {
                return navVolume;
            }
            case 1500: {
                return phoneVolume;
            }
            case 1502: {
                return sdsVolume;
            }
        }
        return entVolume;
    }

    public static void setVolumeRanges(int n, int n2, int n3) {
        int n4 = SoundHASUpdater.convertASLVolumeComponent2HAS(n);
        for (int i2 = 0; i2 < soundVolumeRangesContainer.getVolumeRanges().length; ++i2) {
            if (n4 != soundVolumeRangesContainer.getVolumeRanges()[i2].getSource()) continue;
            soundVolumeRangesContainer.getVolumeRanges()[i2].setMinVolume(n2);
            soundVolumeRangesContainer.getVolumeRanges()[i2].setMaxVolume(n3);
        }
        hasProperties.updateSoundVolumeRanges(soundVolumeRangesContainer);
    }

    public static void setBalanceFaderContainer(int n, int n2) {
        balanceFaderContainer.setBalance(n);
        balanceFaderContainer.setFader(n2);
        hasProperties.updateBalanceFader(balanceFaderContainer);
    }

    public static void setBalanceFaderRangesContainerBalance(int n, int n2) {
        balanceFaderRangesContainer.setBalanceLeft(n);
        balanceFaderRangesContainer.setBalanceRight(n2);
        hasProperties.updateBalanceFaderRanges(balanceFaderRangesContainer);
    }

    public static void setBalanceFaderRangesContainerFader(int n, int n2) {
        balanceFaderRangesContainer.setFaderFront(n);
        balanceFaderRangesContainer.setFaderRear(n2);
        hasProperties.updateBalanceFaderRanges(balanceFaderRangesContainer);
    }

    static {
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        context = hASEngineAPI.getRegistry().getContextByName("Sound");
        hasProperties = (SoundProperties)context.getPropertiesImpl();
        HASFactory hASFactory = HAS.getInstance().getFactory();
        soundVolumeContainer = (SoundVolumeContainer)hASFactory.createContainer(27);
        soundVolumeContainer.setEntertainmentMuted(false);
        soundVolumeRangeContainerEntertainment = (SoundVolumeRangeContainer)hASFactory.createContainer(28);
        soundVolumeRangeContainerEntertainment.setSource(1);
        soundVolumeRangeContainerTA = (SoundVolumeRangeContainer)hASFactory.createContainer(28);
        soundVolumeRangeContainerTA.setSource(2);
        soundVolumeRangeContainerNavigation = (SoundVolumeRangeContainer)hASFactory.createContainer(28);
        soundVolumeRangeContainerNavigation.setSource(3);
        soundVolumeRangeContainerPhone = (SoundVolumeRangeContainer)hASFactory.createContainer(28);
        soundVolumeRangeContainerPhone.setSource(4);
        soundVolumeRangeContainerSDS = (SoundVolumeRangeContainer)hASFactory.createContainer(28);
        soundVolumeRangeContainerSDS.setSource(5);
        soundVolumeRangesContainer = (SoundVolumeRangesContainer)hASFactory.createContainer(29);
        soundVolumeRangesContainer.setVolumeRanges(new SoundVolumeRangeContainer[]{soundVolumeRangeContainerEntertainment, soundVolumeRangeContainerTA, soundVolumeRangeContainerNavigation, soundVolumeRangeContainerPhone, soundVolumeRangeContainerSDS});
        balanceFaderContainer = (BalanceFaderContainer)hASFactory.createContainer(48);
        balanceFaderRangesContainer = (BalanceFaderRangesContainer)hASFactory.createContainer(49);
    }
}

