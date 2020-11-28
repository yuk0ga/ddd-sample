package com.springfest.dddsample.order;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author KIYOTA, Takeshi
 */
@Embeddable // 複合主キーであることを示す
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class OrderNumber implements Serializable {

    private final String number;
}
