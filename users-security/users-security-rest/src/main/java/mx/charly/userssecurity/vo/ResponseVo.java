package mx.charly.userssecurity.vo;

import lombok.Data;

/**
 * @author Risko
 * @since 16/11/2016.
 */
@Data
public class ResponseVo {
    private String mensaje;
    private String traza;
    private String estatus;

    public ResponseVo(String mensaje, String traza, String estatus){
        this.mensaje = mensaje;
        this.traza = traza;
        this.estatus = estatus;
    }
}
