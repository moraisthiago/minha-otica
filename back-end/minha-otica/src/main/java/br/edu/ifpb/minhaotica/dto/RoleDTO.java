package br.edu.ifpb.minhaotica.dto;

import br.edu.ifpb.minhaotica.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private RoleName name;
}
