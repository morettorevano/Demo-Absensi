package indocyber.DemoAbsensi.dto.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Object JSON yang digunakan untuk me-respond permintaan JWT.")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter
public class ResponseTokenDTO {

    @Schema(description = "Username yang digunakan untuk aplikasi client-side.")
    private String username;

    @Schema(description = "Role yang digunakan untuk aplikasi client-side.")
    private String role;

    @Schema(description = "Token JWT untuk requester.")
    private String token;
}
