package com.shatteredpixel.shatteredpixeldungeon.effects;

import com.watabou.noosa.ColorBlock;
import com.watabou.noosa.Game;

public class Flash extends ColorBlock {

    private float duration;
    private float time;

    public Flash(int color, float duration) {
        super(Game.width, Game.height, color);
        this.duration = this.time = duration;
    }

    @Override
    public void update() {
        super.update();

        if ((time -= Game.elapsed) <= 0) {
            killAndErase();
        } else {
            alpha(time / duration);
        }
    }
}
