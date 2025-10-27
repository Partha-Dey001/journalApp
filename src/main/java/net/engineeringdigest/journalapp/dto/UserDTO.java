package net.engineeringdigest.journalapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
    private String email;
    private boolean sentimentAnalysis;
}
