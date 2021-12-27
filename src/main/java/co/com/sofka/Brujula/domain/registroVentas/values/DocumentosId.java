package co.com.sofka.Brujula.domain.registroVentas.values;

import co.com.sofka.domain.generic.Identity;

public class DocumentosId extends Identity {
    public DocumentosId() {
    }

    public DocumentosId(String Id) {
        super(Id);
    }

    public static DocumentosId of(String Id) {
        return new DocumentosId(Id);
    }


}
