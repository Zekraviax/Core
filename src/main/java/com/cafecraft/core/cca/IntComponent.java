package com.cafecraft.core.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.nbt.NbtCompound;

public interface IntComponent extends ComponentV3 {
    int getValue();
}

class RandomIntComponent implements IntComponent {
    private int value = (int) (Math.random() * 20);

    @Override public int getValue() {
        return this.value;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        this.value = tag.getInt("value");
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("value", this.value);
    }
}
