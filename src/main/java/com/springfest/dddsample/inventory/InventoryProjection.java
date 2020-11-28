package com.springfest.dddsample.inventory;

import com.springfest.dddsample.core.Address;
import com.springfest.dddsample.core.SurrogateId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import javax.persistence.Id;

/**
 * @author KIYOTA, Takeshi
 */
@Document(indexName = "inventories")
@Setting(settingPath = "elasticsearch.json")
@Getter
@Setter
public class InventoryProjection {

    @Id
    private SurrogateId id;

    @Field(type = FieldType.Text, analyzer = "japanese")
    private String name;

    private Address address;
}
