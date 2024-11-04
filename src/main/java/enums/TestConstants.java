package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TestConstants {
    IN_TEXT("In"),
    OUT_TEXT("Out"),
    ADULT_TEXT("Adult"),
    ADULTS_TEXT("Adults"),
    CHILD_TEXT("Child"),
    CHILDREN_TEXT("Children"),
    GUESTS_TEXT(" guests");

    public final String value;
}
