package dev.lest.GymRecorder.infrastructure.dtos.responses.user;

import lombok.Builder;

@Builder
public record UserDeleteResponse(Long id,
                                 String result) {
}
