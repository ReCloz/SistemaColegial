package com.ricardoclaro.colegial.entity;

import com.ricardoclaro.colegial.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table (name = "tb_roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel implements GrantedAuthority, Serializable { //Implementa a interface GrantedAuthority responsável pelas funções do nosso usuário

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "roleName", nullable = false)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }

    @ManyToOne
    private UserModel userModel;
}