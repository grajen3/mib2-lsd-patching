/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.gem.AbstractBitmap
 *  de.audi.gem.AbstractComposite
 *  de.audi.gem.AbstractConfig
 *  de.audi.gem.AbstractGraphics
 *  de.audi.gem.AbstractGraphicsIFC
 *  de.audi.gem.AbstractText
 */
package de.vw.mib.widgets.gem;

import de.audi.gem.AbstractBitmap;
import de.audi.gem.AbstractComposite;
import de.audi.gem.AbstractConfig;
import de.audi.gem.AbstractGraphics;
import de.audi.gem.AbstractGraphicsIFC;
import de.audi.gem.AbstractText;
import de.vw.mib.Disposable;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.font.FontManager;
import de.vw.mib.graphics.image.ImageManager;
import de.vw.mib.widgets.gem.VWGEMBitmap;
import de.vw.mib.widgets.gem.VWGEMComposite;
import de.vw.mib.widgets.gem.VWGEMText;
import java.io.IOException;

public final class VWGEMGraphics
extends AbstractGraphics
implements Disposable {
    private final Graphics3D g3d;
    private final ImageManager imageManager;
    private final FontManager fontManager;

    public VWGEMGraphics(Graphics3D graphics3D, ImageManager imageManager, FontManager fontManager, int n, int n2) {
        super(n, n2);
        this.g3d = graphics3D;
        this.imageManager = imageManager;
        this.fontManager = fontManager;
    }

    @Override
    public void dispose() {
    }

    public AbstractText getText(String string) {
        try {
            AbstractConfig abstractConfig = AbstractConfig.getInstance((AbstractGraphicsIFC)this);
            int n = abstractConfig.getColor(0, false);
            int n2 = abstractConfig.getColor(0, true);
            VWGEMText vWGEMText = new VWGEMText(this.g3d, string, this.fontManager.getDefaultFont(), abstractConfig.getFONT_SIZE());
            vWGEMText.setColors(n, n2);
            return vWGEMText;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Missing default font");
        }
    }

    public AbstractComposite getComposite(int n, int n2) {
        return new VWGEMComposite(this.g3d, n, n2);
    }

    protected AbstractBitmap getInternalBitmap(String string, int n, boolean bl) {
        return new VWGEMBitmap(this.g3d, this.imageManager, string);
    }

    public AbstractBitmap getBitmap(String string, int n) {
        return this.getInternalBitmap(string, n, false);
    }

    public void drawTree() {
        this.getRoot().draw();
    }
}

