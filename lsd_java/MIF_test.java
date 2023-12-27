/*
 * Decompiled with CFR 0.152.
 */
import de.eso.mib.ImageSPIImpl;
import de.vw.mib.graphics.image.spi.NativeImage;

class MIF_test {
    MIF_test() {
    }

    public static void main(String[] stringArray) {
        NativeImage nativeImage;
        int n;
        ImageSPIImpl imageSPIImpl = new ImageSPIImpl();
        imageSPIImpl.initNative();
        long l = System.currentTimeMillis();
        int n2 = 0;
        for (n = 0; n < 20; ++n) {
            try {
                nativeImage = imageSPIImpl.loadImageFromSkin(1, 8);
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, 5325);
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, 896);
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, 897);
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, 20);
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, 24);
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, 359);
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, 363);
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, 771);
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, 770);
                n2 += nativeImage.width;
                continue;
            }
            catch (Exception exception) {
                System.out.println("MIF image failed: ");
                exception.printStackTrace();
            }
        }
        System.out.println(new StringBuffer().append("loading from MIF took ").append(System.currentTimeMillis() - l).append("ms. Checksum ").append(n2).toString());
        l = System.currentTimeMillis();
        n2 = 0;
        for (n = 0; n < 20; ++n) {
            try {
                nativeImage = imageSPIImpl.loadImageFromSkin(1, "Backgrounds/Background_Car.png");
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, "Special_No_Scale/Tuner_Frequency_Bands/Band_AM_EU/Band_AM_EU-04.png");
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, "Icons/Audio/Source_Filebrowser_Setup/iPod/iPod-06.png");
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, "Icons/Audio/Source_Filebrowser_Setup/SD_Card/SD_Card-02.png");
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, "Backgrounds/Background_Off_Clock.png");
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, "Backgrounds/Background_PopUp.png");
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, "Buttons/Type620/06.png");
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, "Buttons/Type650/06.png");
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, "Icons/Audio/Podcast/Preview/Preview.png");
                n2 += nativeImage.width;
                nativeImage = imageSPIImpl.loadImageFromSkin(1, "Icons/Audio/Podcast/Fullscreen/Fullscreen.png");
                n2 += nativeImage.width;
                continue;
            }
            catch (Exception exception) {
                System.out.println("filesystem image failed: ");
                exception.printStackTrace();
            }
        }
        System.out.println(new StringBuffer().append("loading from filesystem took ").append(System.currentTimeMillis() - l).append("ms. Checksum ").append(n2).toString());
        imageSPIImpl.uninitNative();
    }

    static {
        System.loadLibrary("mibhighvwspi");
    }
}

