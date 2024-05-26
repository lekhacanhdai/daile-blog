package com.blog.account.domain.prefetch;

import com.blog.account.domain.entity.RoleEntity;
import com.blog.account.domain.repository.RoleRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author daile
 * @since 26/05/2024
 */

@Component
@Getter
public class PrefetchEntityProvider {
    private final Map<UUID, RoleEntity> roleMap;
    private final Map<String, RoleEntity> roleMapName;

    private PrefetchEntityProvider(RoleRepository roleRepository){
        var listRole = roleRepository.findAll();
        this.roleMap = listRole.stream().collect(Collectors.toMap(RoleEntity::getRoleId, r -> r));
        this.roleMapName = listRole.stream().collect(Collectors.toMap(RoleEntity::getRole, r -> r));
    }
}
