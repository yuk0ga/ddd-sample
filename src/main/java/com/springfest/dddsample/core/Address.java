package com.springfest.dddsample.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author KIYOTA, Takeshi
 */
@ValueObject
@Embeddable
@Value
@NoArgsConstructor(force = true,access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class Address implements Serializable {

    private final String country;

    private final String zip;

    private final String state;

    private final String city;

    private final String line1;

    private final String line2;
}
