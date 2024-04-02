/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package ink.hydroxide.client.misc;

import net.minecraft.NBTTagCompound;

public interface ISerializable<T> {
    NBTTagCompound toTag();

    T fromTag(NBTTagCompound tag);
}
