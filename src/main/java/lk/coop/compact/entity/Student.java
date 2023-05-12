package lk.coop.compact.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "STUDENT")
public class Student extends BaseEntity {

    @Column(name = "FIRST_NAME", length = 75)
    private String firstName;

    @Column(name = "LAST_NAME", length = 75)
    private String lastName;

}
