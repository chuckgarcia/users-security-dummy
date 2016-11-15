package mx.charly.userssecurity.dto;

import lombok.Data;
import mx.charly.userssecurity.commons.util.GenericDto;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Risko
 * @since 13/11/2016.
 */
@Data
@Entity
@Table(name = "USER")
public class UserDto extends GenericDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USER")
    private String userName;

    @Column(name = "PASSWD")
    private String passwd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_ROLE")
    private RoleDto roleDto;

}
