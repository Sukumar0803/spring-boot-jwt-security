package com.microservices.usermanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseDTO {

    @Schema(description = "API Path of Error", example = "/all")
    private String path;

    @Schema(description = "System Error Code", example = "T001")
    private String systemErrorCode;

    @Schema(description = "Type Id of Error", example = "API_GET_PRODUCTS_ERROR")
    private String typeId;

    @Schema(description = "Message of Error", example = "Null Pointer Exception")
    private String message;

    @Schema(description = "Multiple Errors", example = "{\"id\":\"id is mandatory\"}")
    private Map<String, String> errors;

    @Schema(description = "Time Stamp of error", example = "2024-03-10 12:10:30")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/New_York")
    private LocalDateTime timestamp;
}
