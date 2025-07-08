package dev.lest.GymRecorder.infrastructure.presentation;

import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserDeleteRequest;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserUpdateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserCreateResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserDeleteResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserUpdateResponse;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserCreateMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {

    @PostMapping("create")
    public UserCreateResponse createEndPoint(@RequestBody UserCreateRequest userCreateRequest) {
        return UserCreateMapper.map(
                UserCreateMapper.map(userCreateRequest));
    }

    @DeleteMapping("detele/{id}")
    public UserDeleteResponse deleteEndPoint(@PathVariable Long id,
                                             UserDeleteRequest userDeleteRequest) {
    }

    @GetMapping("find-by/{id}")
    public UserResponse findByIdEndPoint(@PathVariable Long id) {
    }

    @PatchMapping("update/{id}")
    public UserUpdateResponse updateEndPoint(@PathVariable Long id,
                                             @RequestBody UserUpdateRequest userUpdateRequest) {
    }
}
