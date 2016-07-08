package net.riverSoft.model.visual;


import net.riverSoft.model.visual.impl.VisualEn;
import net.riverSoft.model.visual.impl.VisualRu;
import net.riverSoft.model.visual.impl.VisualUa;

public class VisualUtil {
    private Visual visual;

    public static Visual selectLang(int codeLang){

        switch (codeLang){
            case 1: return new VisualEn();
            case 2: return new VisualRu();
            case 3: return new VisualUa();
            default:return new VisualRu();
        }
    }
}
