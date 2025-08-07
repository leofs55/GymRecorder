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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserCase createUserCase;
    private final DeleteUserCase deleteUserCase;
    private final FindByIdUserCase findByIdUserCase;
    private final UpdateUserCase updateUserCase;

    @PostMapping("create")
    public ResponseEntity<UserCreateResponse> createEndPoint(@RequestBody UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok(UserCreateMapper.map(createUserCase.execute(UserCreateMapper.map(userCreateRequest))));
    }

    @DeleteMapping("detele/{id}")
    public ResponseEntity<UserDeleteResponse> deleteEndPoint(@PathVariable Long id,
                                             UserDeleteRequest userDeleteRequest) {
        return ResponseEntity.ok(UserDeleteMapper.map(deleteUserCase.execute(id, userDeleteRequest.password()), id));
    }

    @GetMapping("find-by/{id}")
    public ResponseEntity<UserResponse> findByIdEndPoint(@PathVariable Long id) {
        return ResponseEntity.ok(UserMapper.map(findByIdUserCase.execute(id)));
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<UserUpdateResponse> updateEndPoint(@PathVariable Long id,
                                             @RequestBody UserUpdateRequest userUpdateRequest) {
        return ResponseEntity.ok(UserUpdateMapper.map(updateUserCase.execute(UserUpdateMapper.map(userUpdateRequest))));
    }
}
