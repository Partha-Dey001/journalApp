package net.engineeringdigest.journalapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.engineeringdigest.journalapp.api.response.WeatherResponse;
import net.engineeringdigest.journalapp.entity.User;
import net.engineeringdigest.journalapp.repository.UserRepository;
import net.engineeringdigest.journalapp.service.UserService;
import net.engineeringdigest.journalapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Tag(name = "User APIs", description = "Read, Update & Delete user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "Update current user's details", description = "Updates the username and password for the currently authenticated user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User updated successfully"),
            @ApiResponse(responseCode = "401", description = "User not authenticated")
    })
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) { // See security note below
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete current user", description = "Deletes the currently authenticated user and all their data.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "401", description = "User not authenticated")
    })
    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get user greeting", description = "Returns a personalized greeting for the authenticated user, including current weather.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Greeting returned successfully"),
            @ApiResponse(responseCode = "401", description = "User not authenticated")
    })
    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Kolkata");
        String greetings = "";
        if (weatherResponse != null) {
            greetings =  ", Weather feels like "+weatherResponse.getCurrent().getFeelsLike();
        }
        return new ResponseEntity<>("Hi " + authentication.getName() + greetings, HttpStatus.OK);
    }

}
