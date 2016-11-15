package mx.charly.userssecurity.dto;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Risko
 * @since 13/11/2016.
 */
@Entity
@Table(name = "ROLE")
@Data
class RoleDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ROLE", nullable = false)
    private String name;
}
