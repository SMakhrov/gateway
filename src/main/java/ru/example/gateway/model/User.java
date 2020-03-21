package ru.example.gateway.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(
        name = "users",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "constraint_unique_user_name")})
public class User extends AbstractNamedEntityAbstract {
    @NotBlank
    @Length(min = 4)
    private String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;

    public User(Long id, String name, String password, Role role, Role... roles) {
        this(id, name, password,  EnumSet.of(role, roles));
    }

    public User(Long id, String name, String password, Collection<Role> roles) {
        super(id, name);
        this.password = password;
        setRoles(roles);
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }
}
