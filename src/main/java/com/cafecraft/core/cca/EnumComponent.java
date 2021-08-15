package com.cafecraft.core.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.nbt.NbtCompound;

public interface EnumComponent extends ComponentV3 {
    int getValue();
}

class DayEnumComponent implements EnumComponent {
    int value;

    public int getValue() {
        return value;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        this.value = tag.getByte("dayValue");
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("dayValue", this.value);
    }

    /*
        enum Day {
            MONDAY,
            TUESDAY,
            WEDNESDAY,
            THURSDAY,
            FRIDAY,
            SATURDAY,
            SUNDAY
        };
    */
}