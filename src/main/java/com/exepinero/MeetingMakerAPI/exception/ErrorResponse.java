package com.exepinero.MeetingMakerAPI.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * This class hold a list of {@code ErrorModel} that describe the error raised on rejected validation
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private List<ErrorModel> errorMessage;

}


