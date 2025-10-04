package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalapp.entity.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;


import java.util.stream.Stream;


public class UserArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(new User("shyam", "shyam")),
                Arguments.of(new User ("vicky", "vicky")),
                Arguments.of(new User ("ramu", "ramu"))
        );
    }
}
