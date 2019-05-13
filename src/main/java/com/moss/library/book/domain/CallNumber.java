package com.moss.library.book.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CallNumber {
    /**
     * 별치기호
     */
    private String locationSymbol;

    /**
     * 분류기호
     */
    private String className;

    /**
     * 도서기호
     */
    private String bookNumber;

    /**
     * 부차적기호
     */
    private String additionalNumber;
}
