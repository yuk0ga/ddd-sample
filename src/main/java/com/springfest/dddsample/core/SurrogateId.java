package com.springfest.dddsample.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import org.hibernate.annotations.Type;
import org.jmolecules.ddd.types.Identifier;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class SurrogateId implements Identifier, Serializable {

    @Type(type = "uuid-char")
    @Column(name = "id", length = 36)
    @Getter(onMethod = @__(@JsonValue))
    private final UUID id;

    public static SurrogateId create(){
        return SurrogateId.of(UUID.randomUUID());
    }

}
