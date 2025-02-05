/*
 * Copyright (C) 2021 DarkKronicle
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package io.github.darkkronicle.advancedchatcore.interfaces;

import io.github.darkkronicle.advancedchatcore.util.FluidText;
import java.util.Optional;
import org.jetbrains.annotations.Nullable;

/** An interface for taking text and processing it. */
public interface IMessageProcessor extends IMessageFilter {
    /**
     * Processes text without the unfiltered text.
     *
     * <p>Deprecated because it won't return anything. If unfiltered doesn't exist, insert null into
     * process.
     *
     * @param text Text to modify
     * @return Empty
     */
    @Deprecated
    @Override
    default Optional<FluidText> filter(FluidText text) {
        process(text, null);
        return Optional.empty();
    }

    /**
     * Consumes text.
     *
     * @param text Final text to process
     * @param unfiltered Original text (if available)
     * @return If the processing was a success
     */
    boolean process(FluidText text, @Nullable FluidText unfiltered);
}
