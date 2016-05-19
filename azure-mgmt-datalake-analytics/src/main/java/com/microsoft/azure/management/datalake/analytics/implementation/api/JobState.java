/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.analytics.implementation.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for JobState.
 */
public enum JobState {
    /** Enum value Accepted. */
    ACCEPTED("Accepted"),

    /** Enum value Compiling. */
    COMPILING("Compiling"),

    /** Enum value Ended. */
    ENDED("Ended"),

    /** Enum value New. */
    NEW("New"),

    /** Enum value Queued. */
    QUEUED("Queued"),

    /** Enum value Running. */
    RUNNING("Running"),

    /** Enum value Scheduling. */
    SCHEDULING("Scheduling"),

    /** Enum value Starting. */
    STARTING("Starting"),

    /** Enum value Paused. */
    PAUSED("Paused"),

    /** Enum value WaitingForCapacity. */
    WAITING_FOR_CAPACITY("WaitingForCapacity");

    /** The actual serialized value for a JobState instance. */
    private String value;

    JobState(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a JobState instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a JobState instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed JobState object, or null if unable to parse.
     */
    @JsonCreator
    public static JobState fromValue(String value) {
        JobState[] items = JobState.values();
        for (JobState item : items) {
            if (item.toValue().equals(value)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return toValue();
    }
}
