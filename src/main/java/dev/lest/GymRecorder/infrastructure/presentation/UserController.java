package dev.lest.GymRecorder.infrastructure.presentation;

import dev.lest.GymRecorder.core.usecases.Users.interfaces.CreateUserCase;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.DeleteUserCase;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.FindByIdUserCase;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.UpdateUserCase;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserDeleteRequest;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserUpdateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserCreateResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserDeleteResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserUpdateResponse;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserCreateMapper;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserDeleteMapper;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserMapper;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserUpdateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final CreateUserCase createUserCase;
    private final DeleteUserCase deleteUserCase;
    private final FindByIdUserCase findByIdUserCase;
    private final UpdateUserCase updateUserCase;

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createEndPoint(@RequestBody UserCreateRequest userCreateRequest) {
        UserCreateResponse userCreateResponse = UserCreateMapper.map(createUserCase.execute(UserCreateMapper.map(userCreateRequest)));
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", "User successfully created!");
        responseHashMap.put("User:",userCreateResponse);
        return ResponseEntity.ok(responseHashMap);
    }

    @DeleteMapping("detele/{id}")
    public ResponseEntity<Map<String, Object>> deleteEndPoint(@PathVariable Long id,
                                                             UserDeleteRequest userDeleteRequest) {
        UserDeleteResponse userDeleteResponse = UserDeleteMapper.map(deleteUserCase.execute(id, userDeleteRequest.password()), id);
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", userDeleteResponse.result());
        responseHashMap.put("User:", userDeleteResponse);
        return ResponseEntity.ok(responseHashMap);
    }

    @GetMapping("find-by/{id}")
    public ResponseEntity<Map<String, Object>> findByIdEndPoint(@PathVariable Long id) {
        UserResponse userResponse = UserMapper.map(findByIdUserCase.execute(id));
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:","User successfully found!");
        responseHashMap.put("User:", userResponse);
        return ResponseEntity.ok(responseHashMap);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Map<String, Object>> updateEndPoint(@PathVariable Long id,
                                                             @RequestBody UserUpdateRequest userUpdateRequest) {
        UserUpdateResponse userUpdateResponse = UserUpdateMapper.map(updateUserCase.execute(UserUpdateMapper.map(userUpdateRequest, id)));
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", "User successfully updated!");
        responseHashMap.put("User:", userUpdateResponse);
        return ResponseEntity.ok(responseHashMap);
    }
}
