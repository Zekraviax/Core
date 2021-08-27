package com.cafecraft.core.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.nbt.NbtCompound;

public interface EnumComponent extends ComponentV3 {
    int getValue();
    String valueToString();
}

class DayEnumComponent implements EnumComponent {
    int value = 0;

    public int getValue() {
        return value;
    }

    public String valueToString() {
        String returnString = "null";

        switch (value) {
            case 0: {
                returnString = "Monday";
                break;
            }
            case 1: {
                returnString = "Tuesday";
                break;
            }
            default: {
                returnString = "error";
                break;
            }
        }

        return returnString;
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