package br.com.consumer.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRedis implements Serializable {

    private String id;

    private String name;

    private String email;

    private String cpf;

    public static List<Object> retornaListaUsuarios(Map<String, UserRedis> users) {
        List<Object> userRedisLista = new ArrayList<>();
        Iterator userIterator = users.entrySet().iterator();
        while (userIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)userIterator.next();
            userRedisLista.add(mapElement.getValue());
        }

        return userRedisLista;
    }

    public UserRedis converteRedis(UserRedis usuario) {

        UserRedis usuarioDatabase = UserRedis
                .builder()
                .name(usuario.getName())
                .email(usuario.getEmail())
                .cpf(usuario.getCpf())
                .build();
        return usuarioDatabase;
    }

    public UserPostgres converte() {

        return new UserPostgres(name,email,cpf);
    }
}
