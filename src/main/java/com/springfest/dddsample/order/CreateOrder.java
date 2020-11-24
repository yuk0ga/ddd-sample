package com.springfest.dddsample.order;

import com.springfest.dddsample.core.SurrogateId;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * command にあたる
 * @author KIYOTA, Takeshi
 */
@Getter
@Setter
public class CreateOrder {

    private SurrogateId owner;

    private LocalDate orderDate;

    // 注文する人
    private SurrogateId from;
}
